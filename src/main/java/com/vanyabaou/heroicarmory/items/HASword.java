package com.vanyabaou.heroicarmory.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.vanyabaou.heroicarmory.IHeroicItem;
import com.vanyabaou.heroicarmory.init.HAItemRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSword;

import java.util.HashMap;

public class HASword extends ItemSword implements IHeroicItem {

	private final float attackDamage;
	private final double attackSpeed;
	private final int enchantability;
	private final int lootRarity;

	public HASword(String name, ToolMaterial material, HashMap<String,Object> properties) {
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
}