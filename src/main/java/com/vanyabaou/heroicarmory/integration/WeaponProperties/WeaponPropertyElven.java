package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.EventHandler;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class WeaponPropertyElven extends WeaponPropertyWithCallback {
    public WeaponPropertyElven() {
        super("elven", HeroicArmory.MOD_ID);
    }

    @Override
    public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
        if (HeroicArmory.SupportIceAndFire) {
            if (isSelected) {
                if (EventHandler.getTickCounter(20) == 0) {
                    int range = 32;
                    AxisAlignedBB region = new AxisAlignedBB(entity.posX - range, entity.posY - range, entity.posZ - range, entity.posX + range, entity.posY + range, entity.posZ + range);
                    world.getEntitiesWithinAABBExcludingEntity(entity, region).forEach((entitylist) -> {
                        if (entitylist.getName().toLowerCase().contains("troll")) {
                            ((EntityLivingBase) entitylist).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 10, 0));
                        }
                    });
                }
            }
        }
    }
}
