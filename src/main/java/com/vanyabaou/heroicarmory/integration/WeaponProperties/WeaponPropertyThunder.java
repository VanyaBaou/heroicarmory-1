package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.IWeaponPropertyContainer;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.oblivioussp.spartanweaponry.util.NBTHelper;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class WeaponPropertyThunder extends WeaponPropertyWithCallback {

    protected final ResourceLocation propertykey = new ResourceLocation("charged");

    public WeaponPropertyThunder() {
        super("thunder", HeroicArmory.MOD_ID);
    }

    @Override
    public void onCreateItem(ToolMaterialEx material, ItemStack created) {
        IWeaponPropertyContainer<?> container = (IWeaponPropertyContainer<?>) created.getItem();
        if (created.getItem().getPropertyGetter(propertykey) == null) {
            System.out.println("propertykey not yet created for " + created.getItem().getRegistryName());
            if (container.getFirstWeaponPropertyWithType("thunder") != null) {
                System.out.println("Adding propertykey for thunder");
                created.getItem().addPropertyOverride(propertykey, (stack, worldIn, entityIn) -> NBTHelper.getBoolean(stack, "charged") ? 1f : 0f);
            }
        }
    }

    @Override
    public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
        if (entity != null && !world.isRemote && isSelected){
            if (!NBTHelper.getBoolean(stack, "charged") && entity.isHandActive() && entity.getActiveItemStack() == stack) {
//            System.out.println("selected");
                BlockPos pos = entity.getPosition();
                if (world.getWorldInfo().isRaining() && world.isRainingAt(pos)) {
                    System.out.println("raining");
                    if (world.getWorldInfo().isThundering()) {
                        System.out.println("thundering");
                        int randy = world.rand.nextInt(50);
                        System.out.println("random: (" + (randy == 0) + ")" + randy);
                        if (randy == 0 && world.provider.canDoLightning(world.getChunkFromBlockCoords(pos))) {
                            System.out.println("charging, summoning lightning");
                            world.addWeatherEffect(new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true));
                            NBTHelper.setBoolean(stack, "charged", true);
                        }
                    }
                }
            }else if (NBTHelper.getBoolean(stack, "charged")){

            }
        }
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, float initialDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        ItemStack heldMain = attacker.getHeldItemMainhand();
        if (NBTHelper.getBoolean(heldMain,"charged")){
//            System.out.println("is charged");
            System.out.println("striking enemy with lightning");
            BlockPos pos = victim.getPosition();
            victim.world.addWeatherEffect(new EntityLightningBolt(attacker.world, pos.getX(), pos.getY(), pos.getZ(), true));
            List<Entity> hitList = attacker.getEntityWorld().getEntitiesInAABBexcluding(attacker, victim.getEntityBoundingBox().grow(2.5,1,2.5), ent -> ent instanceof EntityLivingBase && !ent.isDead && ent.canBeAttackedWithItem());
            for (Entity near : hitList){
                if (near instanceof EntityLivingBase){
                    near.hurtResistantTime = 0;
                    source.damageType = DamageSource.LIGHTNING_BOLT.getDamageType();
                    near.attackEntityFrom(source, baseDamage / 2f);
                    ((EntityLivingBase) near).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS,10*20,1,true,false));
                    ((EntityLivingBase) near).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,10*20,2,true,false));
                    ((EntityLivingBase) near).addPotionEffect(new PotionEffect(MobEffects.NAUSEA,10*20,2,true,false));
                    ((EntityLivingBase) near).knockBack(attacker, 1f, victim.posX - near.posX, victim.posZ - near.posZ);
                }
            }
            int randy = attacker.getRNG().nextInt(4);
            //25% for discharge
            if (randy == 3){
                System.out.println("discharging");
                NBTHelper.setBoolean(heldMain,"charged",false);
            }
            System.out.println("damage increased from " + baseDamage + " to " + (baseDamage * 2f));
            return baseDamage * 2f;
        }
        return baseDamage;
    }
}
