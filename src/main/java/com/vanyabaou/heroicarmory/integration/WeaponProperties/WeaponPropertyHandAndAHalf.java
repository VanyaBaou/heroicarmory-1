package com.vanyabaou.heroicarmory.integration.WeaponProperties;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.UUID;

public class WeaponPropertyHandAndAHalf extends WeaponPropertyWithCallback {
    public WeaponPropertyHandAndAHalf() {
        super("handandahalf", HeroicArmory.MOD_ID);
    }

    @Override
    public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
        ItemStack mainHand = entity.getHeldItemMainhand();
        ItemStack offHand = entity.getHeldItemOffhand();

        UUID damageAddUUID = UUID.fromString("9354fbca-a94b-47a2-9ce9-adc7ba5f0bd9");
        UUID damageRemUUID = UUID.fromString("755d9536-2000-4c51-803f-9efc576b7f94");
        AttributeModifier modifierNew_DamageAdd = new AttributeModifier(damageAddUUID,"ha.hh.damu", 0.2D, Constants.AttributeModifierOperation.MULTIPLY);
        AttributeModifier modifierNew_DamageRem = new AttributeModifier(damageRemUUID,"ha.hh.damd", -0.1D, Constants.AttributeModifierOperation.MULTIPLY);

        UUID speedAddUUID = UUID.fromString("97f686e9-963f-4848-b8d1-2208e18ab639");
        UUID speedRemUUID = UUID.fromString("e40a464b-4e76-493e-828b-dc12e95d0f9e");
        AttributeModifier modifierNew_SpeedAdd = new AttributeModifier(speedAddUUID,"ha.hh.spdu", 0.2D, Constants.AttributeModifierOperation.MULTIPLY);
        AttributeModifier modifierNew_SpeedRem = new AttributeModifier(speedRemUUID,"ha.hh.spdd", -0.1D, Constants.AttributeModifierOperation.MULTIPLY);

        IAttributeInstance attribute_DAMAGE = entity.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        IAttributeInstance attribute_SPEED = entity.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED);

        if (ItemStack.areItemsEqualIgnoreDurability(stack, mainHand)) {
            if (offHand.isEmpty()){
                //offhand empty, using 2 hands, add dam, rem spd
                if (attribute_DAMAGE.getModifier(damageAddUUID) == null) {
                    attribute_DAMAGE.applyModifier(modifierNew_DamageAdd);
                }
                if (attribute_DAMAGE.getModifier(damageRemUUID) != null) {
                    attribute_DAMAGE.removeModifier(damageRemUUID);
                }

                if (attribute_SPEED.getModifier(speedAddUUID) != null) {
                    attribute_SPEED.removeModifier(speedAddUUID);
                }
                if (attribute_SPEED.getModifier(speedRemUUID) == null) {
                    attribute_SPEED.applyModifier(modifierNew_SpeedRem);
                }
            }else{
                //offhand occupied, using 1 hands, rem dam, add spd
                if (attribute_DAMAGE.getModifier(damageAddUUID) != null) {
                    attribute_DAMAGE.removeModifier(damageAddUUID);
                }
                if (attribute_DAMAGE.getModifier(damageRemUUID) == null) {
                    attribute_DAMAGE.applyModifier(modifierNew_DamageRem);
                }

                if (attribute_SPEED.getModifier(speedAddUUID) == null) {
                    attribute_SPEED.applyModifier(modifierNew_SpeedAdd);
                }
                if (attribute_SPEED.getModifier(speedRemUUID) != null) {
                    attribute_SPEED.removeModifier(speedRemUUID);
                }
            }
        } else{
            //not held, rem all modifiers
            if (attribute_DAMAGE.getModifier(damageAddUUID) != null) {
                attribute_DAMAGE.removeModifier(damageAddUUID);
            }
            if (attribute_DAMAGE.getModifier(damageRemUUID) != null) {
                attribute_DAMAGE.removeModifier(damageRemUUID);
            }
            if (attribute_SPEED.getModifier(speedAddUUID) != null) {
                attribute_SPEED.removeModifier(speedAddUUID);
            }
            if (attribute_SPEED.getModifier(speedRemUUID) != null) {
                attribute_SPEED.removeModifier(speedRemUUID);
            }
        }
    }
}
