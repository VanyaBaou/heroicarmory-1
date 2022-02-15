package com.vanyabaou.heroicarmory.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.vanyabaou.heroicarmory.HAConfig;
import com.vanyabaou.heroicarmory.IHeroicItem;
import com.vanyabaou.heroicarmory.init.HAItemRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;

public class HAWeapon extends ItemSword implements IHeroicItem {

	private final float attackDamage;
	private final double attackSpeed;
	private final int enchantability;
	private final int lootRarity;

	public HAWeapon(String name, ToolMaterial material, HashMap<String,Object> properties) {
		super(material);
		this.setCreativeTab(HAItemRegistry.tabHeroicArmory);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.attackDamage = (float)properties.getOrDefault("attack", 9f);
		this.attackSpeed = (double)properties.getOrDefault("speed", 1.6f);
		this.setMaxDamage((int)properties.getOrDefault("durability", 1000));
		this.enchantability = (int)properties.getOrDefault("enchantability", 0);
		this.lootRarity = (int)properties.getOrDefault("rarity",0);
	}

	@Override
	public int getLootRarity(){
		return this.lootRarity;
	}
	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}
	@Override
	public int getItemEnchantability() { return this.enchantability; }

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage - 1, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackSpeed - 4, 0));
		}
		return multimap;
	}

	@Override
	@ParametersAreNonnullByDefault
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (!toRepair.isEmpty() && !repair.isEmpty()) {
			return doesOreDictMatch(repair) || super.getIsRepairable(toRepair, repair);
		} else {
			return false;
		}
	}

	public static boolean doesOreDictMatch(ItemStack stack)
	{
		if (!OreDictionary.doesOreNameExist(HAConfig.repairDict)) {
			System.out.println("Config repairDict does not exist!");
			return false;
		}
		NonNullList<ItemStack> ores = OreDictionary.getOres(HAConfig.repairDict, false);
		for(ItemStack ore : ores)
		{
			if(OreDictionary.itemMatches(ore, stack, false))
				System.out.println("Found match for " + stack.getItem().getRegistryName() + " repairDict: " + ore.getItem().getRegistryName());
				return true;
		}
		System.out.println("repairItem does not match repairDict!");
		return false;
	}

}