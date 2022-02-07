package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.Effects.ModifiedExplosion;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class WeaponPropertyDetonateDead extends WeaponPropertyWithCallback {
    public WeaponPropertyDetonateDead() {
        super("detonatedead", HeroicArmory.MOD_ID);
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, float initialDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        System.out.println("Detonate Undead start");
        System.out.println("DamageAmount: " + baseDamage);
        System.out.println("VictimHealth: " + victim.getHealth());
        System.out.println("Creature: " + victim.getCreatureAttribute());
        if (victim.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD && baseDamage > victim.getHealth()){
            System.out.println("Valid kill");
            attacker.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 10 * 20, 0));
            ModifiedExplosion expl = new ModifiedExplosion(victim.world, attacker, victim.posX + 0.5, victim.posY + 1.5, victim.posZ + 0.5, 2.0f, true, false, baseDamage * (this.level / 4f));
            expl.doExplosionA();
            expl.doExplosionB(true);
        }
        return baseDamage;
    }
}
