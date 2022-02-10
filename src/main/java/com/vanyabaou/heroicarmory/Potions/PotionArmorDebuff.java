package com.vanyabaou.heroicarmory.Potions;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.Constants;

public class PotionArmorDebuff extends Potion {

    private double modif;

    protected PotionArmorDebuff(int potionColor, double modifier) {
        super(true, potionColor);
        this.modif = modifier;
    }

    public void registerPotionAttributeModifier() {
        this.registerPotionAttributeModifier(SharedMonsterAttributes.ARMOR, "f08a0981-e16c-401c-bcb9-f248590b05f0", modif, Constants.AttributeModifierOperation.MULTIPLY);
    }

}
