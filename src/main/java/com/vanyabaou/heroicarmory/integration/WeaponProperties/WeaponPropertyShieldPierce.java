package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.text.DecimalFormat;
import java.util.List;

public class WeaponPropertyShieldPierce extends WeaponPropertyWithCallback {

    public WeaponPropertyShieldPierce(float propMagnitude) {
        super("shieldpierce", HeroicArmory.MOD_ID, 1, propMagnitude);
    }

    @SideOnly(Side.CLIENT)
    protected void addTooltipDescription(ItemStack stack, List<String> tooltip) {
        tooltip.add(TextFormatting.GRAY + "" + TextFormatting.ITALIC + "  " + SpartanWeaponryAPI.internalHandler.translateFormattedString(this.type + ".desc", "tooltip", HeroicArmory.MOD_ID, new DecimalFormat("0").format(this.magnitude*100)));
    }

}
