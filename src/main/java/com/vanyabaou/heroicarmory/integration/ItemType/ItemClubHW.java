package com.vanyabaou.heroicarmory.integration.ItemType;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemClub;
import com.oblivioussp.spartanweaponry.util.StringHelper;
import com.vanyabaou.heroicarmory.HeroicArmory;
import com.vanyabaou.heroicarmory.IHeroicItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;

import static com.vanyabaou.heroicarmory.init.HAItemRegistry.tabHeroicArmory;

public class ItemClubHW extends ItemClub implements IHeroicItem {

    protected int enchantability;
    protected int lootRarity;

    public ItemClubHW(String unlocName, Object material, HashMap<String,Object> properties, WeaponProperty... weaponProperties) {
        super(unlocName, (ToolMaterialEx)material, (int)properties.getOrDefault("durability",1000));
        this.setCreativeTab(tabHeroicArmory);
        this.modId = HeroicArmory.MOD_ID;

        this.displayName = unlocName;

        this.attackDamage = (float)properties.getOrDefault("attack", 9f) - 1;
        this.attackSpeed = (double)properties.getOrDefault("speed", 1.6f);
        this.setMaxDamage((int)properties.getOrDefault("durability", 1000));
        this.enchantability = (int)properties.getOrDefault("enchantability", 0);
        this.lootRarity = (int)properties.getOrDefault("rarity",0);

        this.properties = Arrays.asList(weaponProperties);
    }

    @Override
    public int getLootRarity(){
        return this.lootRarity;
    }

    @Override
    public Item setCreativeTab(CreativeTabs tab) {
        return super.setCreativeTab(tabHeroicArmory);
    }

    @Override
    public String getCreatorModId(ItemStack itemStack) {
        return HeroicArmory.MOD_ID;
    }

    @Override
    public int getItemEnchantability() {
        return this.enchantability;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (this.displayName != null) {
            return I18n.format(String.format("item.%s.name", this.displayName), I18n.format(this.materialEx.getFullUnlocName()));
        }
        return super.getItemStackDisplayName(stack);
    }

    @Override
    public String getUnlocalizedName() {
        return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
    }

}
