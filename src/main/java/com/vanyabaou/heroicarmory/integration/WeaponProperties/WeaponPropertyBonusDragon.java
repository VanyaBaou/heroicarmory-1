package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.github.alexthe666.iceandfire.entity.EntityFireDragon;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.DamageSource;

public class WeaponPropertyBonusDragon extends WeaponPropertyWithCallback {
    public WeaponPropertyBonusDragon() {
        super("bonus_dragon", HeroicArmory.MOD_ID);
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        if (victim instanceof EntityDragon || (HeroicArmory.SupportIceAndFire && (victim instanceof EntityFireDragon || victim instanceof EntityIceDragon))){
            return baseDamage * 1.5f;
        }
        return baseDamage;
    }
}
