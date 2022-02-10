package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

public class WeaponPropertyArmorBuff extends WeaponPropertyWithCallback {
    public WeaponPropertyArmorBuff(float propMagnitude) {
        super("armorbuff", HeroicArmory.MOD_ID, 1, propMagnitude);
    }

    @Override
    public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
        ItemStack mainHand = entity.getHeldItemMainhand();

        UUID armorAddUUID = UUID.fromString("53ee0ce2-b323-45dc-a83e-877520cc6166");
        AttributeModifier modifierNew_ArmorAdd = new AttributeModifier(armorAddUUID,"ha.defu", (double)(this.magnitude), Constants.AttributeModifierOperation.MULTIPLY);
        IAttributeInstance attribute_ARMOR = entity.getEntityAttribute(SharedMonsterAttributes.ARMOR);

        if (ItemStack.areItemsEqualIgnoreDurability(stack, mainHand)) {
                if (attribute_ARMOR.getModifier(armorAddUUID) == null) {
                    attribute_ARMOR.applyModifier(modifierNew_ArmorAdd);
                }
        }else{
            if (attribute_ARMOR.getModifier(armorAddUUID) != null) {
                attribute_ARMOR.removeModifier(armorAddUUID);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    protected void addTooltipDescription(ItemStack stack, List<String> tooltip) {
        tooltip.add(TextFormatting.GRAY + "" + TextFormatting.ITALIC + "  " + SpartanWeaponryAPI.internalHandler.translateFormattedString(this.type + ".desc", "tooltip", HeroicArmory.MOD_ID, new DecimalFormat("0").format(this.magnitude*100)));
    }

}
