package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.util.DamageSource;

public class WeaponPropertyBonusLiving extends WeaponPropertyWithCallback {
    public WeaponPropertyBonusLiving() {
        super("bonus_living", HeroicArmory.MOD_ID);
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        return victim.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD ? baseDamage * 1.75f : baseDamage;
    }
}
