package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class WeaponPropertyIgnite extends WeaponPropertyWithCallback {
    public WeaponPropertyIgnite(int propLevel) {
        super("ignite", HeroicArmory.MOD_ID, propLevel);
    }

    @Override
    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if (HeroicArmory.SupportIceAndFire) {
            if (target instanceof EntityIceDragon) {
                System.out.println("Ignite bonus for " + (2f * this.level));
                target.attackEntityFrom(DamageSource.IN_FIRE, 2f * this.level);
            }
        }
        target.setFire(5);
        target.knockBack(target, 1f, attacker.posX - target.posX, attacker.posZ - target.posZ);
    }
}
