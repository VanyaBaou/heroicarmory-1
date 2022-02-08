package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.github.alexthe666.iceandfire.entity.EntityFireDragon;
import com.github.alexthe666.iceandfire.entity.FrozenEntityProperties;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.ilexiconn.llibrary.server.entity.EntityPropertiesHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class WeaponPropertyFreeze extends WeaponPropertyWithCallback {
    public WeaponPropertyFreeze(int propLevel) {
        super("freeze", HeroicArmory.MOD_ID, propLevel);
    }

    @Override
    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if ((HeroicArmory.SupportIceAndFire && target instanceof EntityFireDragon) || target instanceof EntityBlaze || target instanceof EntityMagmaCube) {
            target.attackEntityFrom(DamageSource.IN_FIRE, 2f * this.level);
            if (HeroicArmory.SupportIceAndFire){
                FrozenEntityProperties frozenProps = EntityPropertiesHandler.INSTANCE.getProperties(target, FrozenEntityProperties.class);
                frozenProps.setFrozenFor(300);
            }
        }
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
        target.knockBack(target, 1F, attacker.posX - target.posX, attacker.posZ - target.posZ);
    }
}
