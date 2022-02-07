package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class WeaponPropertyRandomRepair extends WeaponPropertyWithCallback {
    public WeaponPropertyRandomRepair() {
        super("randomrepair", HeroicArmory.MOD_ID);
    }

    @Override
    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if (((int)(Math.random() * 4 + 1)) > 1){
            stack.setItemDamage(Math.min(stack.getMaxDamage(), stack.getItemDamage() - 1));
        }
    }
}
