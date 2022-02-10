package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.EventHandler;
import com.vanyabaou.heroicarmory.HeroicArmory;
import com.vanyabaou.heroicarmory.Potions.HAPotions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class WeaponPropertyArmorDebuff extends WeaponPropertyWithCallback {
    public WeaponPropertyArmorDebuff(int propMagnitude) {
        super("armordebuff", HeroicArmory.MOD_ID, 1, propMagnitude);
    }

    @Override
    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if (attacker instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) attacker;
            HashMap<String,Boolean> attackInfo = EventHandler.getPlayerAttackInfo(player.getDisplayNameString());
            boolean critbool = attackInfo.getOrDefault("crit",false);
            if (critbool) {
                System.out.println("Applying crit debuff");
                target.addPotionEffect(new PotionEffect(HAPotions.armordebuff, (int) (this.magnitude*20)));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    protected void addTooltipDescription(ItemStack stack, List<String> tooltip) {
        tooltip.add(TextFormatting.GRAY + "" + TextFormatting.ITALIC + "  " + SpartanWeaponryAPI.internalHandler.translateFormattedString(this.type + ".desc", "tooltip", HeroicArmory.MOD_ID, new DecimalFormat("0").format(HAPotions.armorDebuffAmount*100), new DecimalFormat("0").format(this.magnitude*20)));
    }

}
