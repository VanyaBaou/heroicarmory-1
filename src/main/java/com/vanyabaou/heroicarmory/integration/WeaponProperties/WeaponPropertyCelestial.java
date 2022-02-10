package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class WeaponPropertyCelestial extends WeaponPropertyWithCallback {
    public WeaponPropertyCelestial() {
        super("celestial", HeroicArmory.MOD_ID);
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        return (float) (baseDamage + (Math.pow(attacker.getHealth()/attacker.getMaxHealth(),2.5) * baseDamage));
    }
}
