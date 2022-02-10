package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class WeaponPropertySelfPotion extends WeaponPropertyWithCallback {

    protected String potionName;
    protected Potion potionType;
    protected double potionDuration;
    protected int potionStrength;

    public WeaponPropertySelfPotion(String type, Potion potion, double duration, int strength) {
        super("selfpotion", HeroicArmory.MOD_ID, strength + 1);
        this.potionName = type;
        this.potionType = potion;
        this.potionDuration = duration;
        this.potionStrength = strength;
    }

    @Override
    public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
        if (entity != null && isSelected) {
            entity.addPotionEffect(new PotionEffect(this.potionType, (int) (this.potionDuration * 20), this.potionStrength));
        }
    }

    @SideOnly(Side.CLIENT)
    protected void addTooltipTitle(ItemStack stack, List<String> tooltip) {
        tooltip.add(this.getQuality().getFormatting() + "- " + SpartanWeaponryAPI.internalHandler.translateFormattedString(this.type, "tooltip", HeroicArmory.MOD_ID, I18n.format(this.potionName), I18n.format("enchantment.level." + this.level)));
    }

    @SideOnly(Side.CLIENT)
    protected void addTooltipDescription(ItemStack stack, List<String> tooltip) {
        tooltip.add(TextFormatting.GRAY + "" + TextFormatting.ITALIC + "  " + SpartanWeaponryAPI.internalHandler.translateFormattedString(this.type + ".desc", "tooltip", HeroicArmory.MOD_ID, I18n.format(this.potionName), I18n.format("enchantment.level." + this.level)));
    }

}
