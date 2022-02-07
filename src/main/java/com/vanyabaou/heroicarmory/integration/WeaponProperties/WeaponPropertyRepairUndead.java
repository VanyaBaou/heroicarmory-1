package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemStack;

public class WeaponPropertyRepairUndead extends WeaponPropertyWithCallback {
    public WeaponPropertyRepairUndead() {
        super("repairundead", HeroicArmory.MOD_ID);
    }

    @Override
    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if (target.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD && target.getHealth() <= 0){
            System.out.println("Reapir Undead proc");
            stack.setItemDamage(Math.min(stack.getMaxDamage(), stack.getItemDamage() - ((int)(Math.random() * 2 + 1))));
        }
    }
}
