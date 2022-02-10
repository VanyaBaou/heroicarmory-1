package com.vanyabaou.heroicarmory.integration.ItemType;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.init.EnchantmentRegistrySW;
import com.oblivioussp.spartanweaponry.item.IBlockingWeapon;
import com.oblivioussp.spartanweaponry.item.ItemBoomerang;
import com.oblivioussp.spartanweaponry.util.NBTHelper;
import com.oblivioussp.spartanweaponry.util.StringHelper;
import com.vanyabaou.heroicarmory.HeroicArmory;
import com.vanyabaou.heroicarmory.IHeroicItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.vanyabaou.heroicarmory.init.HAItemRegistry.tabHeroicArmory;

public class ItemCustomKeybladeHW extends ItemBoomerang implements IHeroicItem, IBlockingWeapon {

    protected int enchantability;
    protected int lootRarity;

    protected List<Enchantment> enchList = Arrays.asList(Enchantments.SHARPNESS,Enchantments.SMITE,Enchantments.BANE_OF_ARTHROPODS,Enchantments.FIRE_ASPECT,Enchantments.LOOTING);

    public ItemCustomKeybladeHW(String unlocName, Object material, HashMap<String,Object> properties, WeaponProperty... weaponProperties) {
        super(unlocName, HeroicArmory.MOD_ID, (ToolMaterialEx)material);
        this.setCreativeTab(tabHeroicArmory);
        this.modId = HeroicArmory.MOD_ID;

        this.displayName = unlocName;

        this.attackDamage = (float)properties.getOrDefault("attack", 9f) - 1;
        this.attackSpeed = (double)properties.getOrDefault("speed", 1.6f);
        this.setMaxDamage((int)properties.getOrDefault("durability", 1000));
        this.enchantability = (int)properties.getOrDefault("enchantability", 0);
        this.lootRarity = (int)properties.getOrDefault("rarity",0);

        this.maxAmmo = 1;
        this.properties = Arrays.asList(weaponProperties);

        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack && !entityIn.isSneaking() ? 1.0F : 0.0F;
            }
        });

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (isSelected){
            NBTHelper.setBoolean(stack, "ha.sneak", entity.isSneaking());
        }
        super.onUpdate(stack, world, entity, itemSlot, isSelected);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        if (!slotChanged) {
//            if (ItemStack.areItemsEqualIgnoreDurability(oldStack, newStack)){
//                if (NBTHelper.getBoolean(oldStack, "ha.sneak") != NBTHelper.getBoolean(newStack, "ha.sneak")) {
//                    return false;
//                }
//            }
            return false;
        }
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (entityLiving.isSneaking() && NBTHelper.getBoolean(stack,"ha.sneak")){
            super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
        }
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        if (NBTHelper.getBoolean(stack,"ha.sneak")){
            return EnumAction.BOW;
        }else{
            return EnumAction.BLOCK;
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack heldStack = playerIn.getHeldItem(hand);
        if (playerIn.isSneaking()) {
            NBTHelper.setBoolean(heldStack,"ha.sneak",true);
            if (heldStack.hasTagCompound() && NBTHelper.getInteger(heldStack,"AmmoUsed") == this.getMaxAmmo(heldStack)) {
                return ActionResult.newResult(EnumActionResult.FAIL, heldStack);
            } else {
                playerIn.setActiveHand(hand);
                return ActionResult.newResult(EnumActionResult.SUCCESS, heldStack);
            }
        } else {
            NBTHelper.setBoolean(heldStack,"ha.sneak",false);
            playerIn.setActiveHand(hand);
            return ActionResult.newResult(EnumActionResult.SUCCESS, heldStack);
        }
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.getDirectAttackDamage(), 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackSpeed - 4.0D, 0));
        }
        return multimap;
    }

    @Override
    public int getLootRarity(){
        return this.lootRarity;
    }

    @Override
    public Item setCreativeTab(CreativeTabs tab) {
        return super.setCreativeTab(tabHeroicArmory);
    }

    @Override
    public String getCreatorModId(ItemStack itemStack) {
        return HeroicArmory.MOD_ID;
    }

    @Override
    public int getItemEnchantability() {
        return this.enchantability;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (this.displayName != null) {
            return I18n.format(String.format("item.%s.name", this.displayName), I18n.format(this.materialEx.getFullUnlocName()));
        }
        return super.getItemStackDisplayName(stack);
    }

    @Override
    public String getUnlocalizedName() {
        return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == EnchantmentRegistrySW.THROWING_AMMO){
            return false;
        }
        if (this.enchList.contains(enchantment)){
            return true;
        }
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean canBlockProjectiles() {
        return false;
    }

    @Override
    public boolean canBlockMelee() {
        return true;
    }
}
