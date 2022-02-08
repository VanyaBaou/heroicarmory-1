package com.vanyabaou.heroicarmory.integration.ItemType;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.init.EnchantmentRegistrySW;
import com.oblivioussp.spartanweaponry.item.ItemThrowingAxe;
import com.oblivioussp.spartanweaponry.item.ItemThrowingKnife;
import com.oblivioussp.spartanweaponry.util.StringHelper;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.vanyabaou.heroicarmory.init.HAItemRegistry.tabHeroicArmory;

public class ItemThrowingKnifeHW extends ItemThrowingKnife {

    protected int enchantability;
    protected int lootRarity;

    protected List<Enchantment> enchList = Arrays.asList(Enchantments.SHARPNESS,Enchantments.SMITE,Enchantments.BANE_OF_ARTHROPODS,Enchantments.FIRE_ASPECT,Enchantments.LOOTING);

    public ItemThrowingKnifeHW(String unlocName, Object material, HashMap<String,Object> properties, int maxAmmo, WeaponProperty... weaponProperties) {
        super(unlocName, HeroicArmory.MOD_ID, (ToolMaterialEx)material);
        this.setCreativeTab(tabHeroicArmory);
        this.modId = HeroicArmory.MOD_ID;

        this.displayName = unlocName;

        this.attackDamage = (float)properties.getOrDefault("attack", 9f);
        this.attackSpeed = (double)properties.getOrDefault("speed", 1.6f);
        this.setMaxDamage((int)properties.getOrDefault("durability", 1000));
        this.enchantability = (int)properties.getOrDefault("enchantability", 0);
        this.lootRarity = (int)properties.getOrDefault("rarity",0);

        this.maxAmmo = maxAmmo;
        this.properties = new ArrayList();
        this.properties.addAll(Arrays.asList(weaponProperties));
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

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == EnchantmentRegistrySW.THROWING_AMMO){
            return false;
        }
        if (this.enchList.contains(enchantment)){
            return true;
        }
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

}
