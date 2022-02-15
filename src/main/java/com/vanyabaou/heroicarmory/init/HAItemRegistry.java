package com.vanyabaou.heroicarmory.init;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.WeaponProperties;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyExtraDamage;
import com.vanyabaou.heroicarmory.HAConfig;
import com.vanyabaou.heroicarmory.HeroicArmory;
import com.vanyabaou.heroicarmory.IHeroicItem;
import com.vanyabaou.heroicarmory.integration.ItemType.*;
import com.vanyabaou.heroicarmory.integration.WeaponProperties.*;
import com.vanyabaou.heroicarmory.items.HAWeapon;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static com.vanyabaou.heroicarmory.HeroicArmory.SupportSpartanWeaponry;

@Mod.EventBusSubscriber(modid= HeroicArmory.MOD_ID)
public class HAItemRegistry {


	//lord of the rings
	public static Item lotrGimliBattleAxe, lotrGimliLongAxe, lotrMorgulBlade, lotrSting, lotrGlamdring, lotrAnduril, lotrNarsil,
		lotrSauronMace, lotrWitchKingSword;

	//legend of zelda
	public static Item lozMasterSword, lozMasterSwordII, lozTemperedSword, lozMasterSwordIII, lozGoldenSword, lozFlameblade,
		lozDarknutSwordTp, lozGhirahimSword, lozFierceDeitySword, lozZeldaSword, lozBokoStick, lozCaneofByrna, lozMegatonHammer,
		lozKokiriSwordMm, lozKokiriSwordOoT, lozDemiseSword, lozGiantKnife, lozBiggoronSword, lozPhantomGanonSword, lozUltimateSword,
		lozRoyalGuardSword, lozMagicSwordConcept, lozMagicSword, lozWhiteSword, lozWhiteSwordConcept, lozPicoriBlade, lozRazorSword,
		lozGreatFairySword, lozGoddessWhiteSword, lozGoddessSword, lozGildedSword, lozSpikedBokoClub, lozBokoClub;

	//adventure time
	public static Item atJakeSword, atCrystalSword, atNothung, atFinnSword, atSwordoftheDead, atWishStarSword, atFightKingSword,
		atRootSword, atScarlet, atGrassSword, atDemonBloodSword, atAxeBass;

	//final fantasy
	public static Item ffTheMasamune, ffBusterSword, ffCaladbolg;

	//realm of the mad god
	public static Item rotmgSwordoftheColossus, rotmgCrystalSword, rotmgPixieEnchantedSword, rotmgSwordOfAcclaim, rotmgDemonBlade,
	rotmgSwordoftheMadGod, rotmgIndomptable, rotmgPirateKingCutlass, rotmgSwordofSplendor, rotmgSkysplitterSword,
	rotmgArchonSword, rotmgAncientStoneSword, rotmgDragonsoulSword, rotmgRavenheartSword;

	//soul calibur
	public static Item scFirangi, scCocytus, scErlangBlade, scSoulEdgeNightmare, scPhlegethon, scAcheron, scLethe, scQueenGuard,
		scHolyAntler, scEpee, scWarHammer, scKulutues, scEstoc, scFlambert2P, scReiterpallasch, scFlambert, scBlueCrystalRod,
		scFireBlade, scXiSword, scOmegaSword2P, scOmegaSword, scOrichalcum, scStiletto, scRequiem, scFaust, scFlamberge,
		scSteelPaddle, scGlam, scGreatBlade;

	//runescape
	public static Item rsBronzeSword, rsIronSword, rsWhiteSword, rsBlackSword, rsSteelSword, rsMithrilSword, rsAdamantSword, rsRuneSword, rsDragonSword,
		rsBronzeBattleaxe, rsIronBattleaxe, rsSteelBattleaxe, rsBlackBattleaxe, rsWhiteBattleaxe, rsMithrilBattleaxe, rsAdamantBattleaxe, rsRuneBattleaxe, rsDragonBattleaxe,
		rsBronzeScimitar, rsIronScimitar, rsBlackScimitar, rsWhiteScimitar, rsSteelScimitar, rsMithrilScimitar, rsAdamantScimitar, rsRuneScimitar, rsDragonScimitar,
		rsBronzeWarhammer, rsIronWarhammer, rsSteelWarhammer, rsBlackWarhammer, rsWhiteWarhammer, rsMithrilWarhammer, rsAdamantWarhammer, rsRuneWarhammer,
		rsBronzeMace, rsIronMace, rsSteelMace, rsBlackMace, rsWhiteMace, rsMithrilMace, rsAdamantMace, rsRuneMace,
		rsGraniteLongsword, rsGraniteHammer, rsGraniteMaul,
		rsElderMaul, rsToktzxilak, rsWolfsbane,
		rsZamorakGodsword, rsBandosGodsword, rsArmadylGodsword, rsSaradominGodsword, rsBarrelchestAnchor;

	//devil may cry
	public static Item dmcRedQueen, dmcRebellion, dmcYamato;

	//pokemon
	public static Item pkmnHonedgeShiny, pkmnHonedge;

	//kirby
	public static Item kirbyGalaxia, kirbyKirbyUltraSword, kirbyKirbySword;

	//fire emblem
	public static Item feChromFalchion, feFalchion;

	//kingdom hearts
	public static Item khKeyblade;

	//bleach
	public static Item bleachZabimaru, bleachZangetsu;

	//dark souls
	public static Item dsGreatswordofArtorias, dsGreatLordGreatsword, dsAstoraGreatsword, dsZweihander;

	//mythology
	public static Item mythDeathScythe, mythTheDevilPitchfork;

	//bayonetta
	public static Item bayonettaShuraba, bayonettaAngelSlayer;

	//god of war
	public static Item gowLeviathanUpgraded, gowLeviathan, gowBladeofOlympus, gowBladeofChaos;

	//skyrim
	public static Item skyrimIronSword, skyrimIronWarhammer, skyrimSteelSword, skyrimSteelWarhammer, skyrimOrcishSword,
		skyrimOrcishWarhammer, skyrimDwarvenSword, skyrimDwarvenWarhammer, skyrimElvenSword, skyrimElvenWarhammer, skyrimGlassSword,
		skyrimGlassWarhammer, skyrimEbonySword, skyrimEbonyWarhammer, skyrimDaedricSword, skyrimDaedricWarhammer, skyrimDragonboneSword,
		skyrimDragonboneWarhammer, skyrimImperialSword, skyrimDawnbreaker, skyrimAncientNordSword, skyrimChillrend, skyrimEbonyBlade;

	//monster hunter
	public static Item mhChickenDecapitator, mhGolemBlade, mhDefender, mhBlackBeltBlade, mhWailingCleaver, mhGaelicFlame, mhBoneKatana,
		mhHellishSlasher, mhCentenarianDagger, mhWyvernBladeBlood, mhWyvernBladeHolly, mhWyvernBladePale, mhWyvernBladeAzure,
		mhWyvernBladeLeaf, mhRathalosFlamesword;

	//terraria
	public static Item terrariaPalmWoodSword, terrariaBorealWoodSword, terrariaShadewoodSword, terrariaEbonwoodSword,
	terrariaCopperShortsword, terrariaCopperBroadsword, terrariaTinShortsword, terrariaTinBroadsword, terrariaLeadShortsword,
		terrariaLeadBroadsword, terrariaSpear, terrariaIronShortsword, terrariaIronBroadsword, terrariaSilverBroadsword,
		terrariaSilverShortsword, terrariaGoldShortsword, terrariaGoldBroadsword, terrariaTungstenBroadsword, terrariaTungstenShortsword,
		terrariaPlatinumShortsword, terrariaPlatinumBroadsword, terrariaMandibleBlade, terrariaKatana, terrariaExoticScimitar,
		terrariaMuramasa, terrariaFalconBlade, terrariaBladeofGrass, terrariaFieryGreatsword, terrariaBoneSword, terrariaBloodButcherer,
		terrariaEnchantedSword, terrariaStarfury, terrariaBeeKeeper, terrariaIceBlade, terrariaNightEdge, terrariaArkhalis,
		terrariaTrident, terrariaTheRottedFork, terrariaWhitePhaseblade, terrariaYellowPhaseblade, terrariaPurplePhaseblade,
		terrariaGreenPhaseblade, terrariaRedPhaseblade, terrariaBluePhaseblade, terrariaLightBane, terrariaDarkLance,
		terrariaPurpleClubberfish, terrariaCactusSword, terrariaSwordfish;

	//star wars
	public static Item swYellowLightsaber, swGreenLightsaber, swBlueLightsaber, swRedLightsaber, swMaceWinduLightsaber,
		swTheInquisitorLightsaber, swDarthMaulLightsaber, swQuiGonJinnLightsaber, swKyloRenLightsaber, swCountDookuLightsaber, swDarksaber;

	//internet
	public static Item internetDemonoidPitchfork;

	//nethack
	public static Item nhMagicbane, nhAthame, nhGrayswandir, nhSilverSaber;

	//abcm
	public static Item abcmExcalibur;



	static List<Item> ALL_ITEMS = new ArrayList<>();
	static List<Item> HEROIC_ITEMS = new ArrayList<>();

	//creative tab
	public static final CreativeTabs tabHeroicArmory = new CreativeTabs("tabHeroicArmory") {
		@Override
		@Nonnull
		@MethodsReturnNonnullByDefault
		public ItemStack getTabIconItem() {
			return new ItemStack(lotrNarsil);
		}		
	};

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		ToolMaterial dummyMaterial = EnumHelper.addToolMaterial("HeroicMaterial",0,1000,1f,0f,0);

		Object dummyMaterialEx = null;
		if (SupportSpartanWeaponry){
			dummyMaterialEx = new ToolMaterialEx("HeroicMaterialEX", HAConfig.repairDict, HeroicArmory.MOD_ID, 0, 0, 0, 1000, 1, 0, 0);
		}

		//lotr
		if (HAConfig.includeSeries.lotr) {
			if (HAConfig.modifiedItems.lotrModified.GimliBattleAxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.GimliBattleAxe.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.GimliBattleAxe.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.GimliBattleAxe.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.GimliBattleAxe.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.GimliBattleAxe.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrGimliBattleAxe = new HAWeapon("lotrGimliBattleAxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrGimliBattleAxe);
				}else{
					lotrGimliBattleAxe = new ItemBattleaxeHW("lotrGimliBattleAxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(lotrGimliBattleAxe, HeroicArmory.MOD_ID, "lotrGimliBattleAxe");
				}
				ALL_ITEMS.add(lotrGimliBattleAxe);
			}
			if (HAConfig.modifiedItems.lotrModified.GimliLongAxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.GimliLongAxe.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.GimliLongAxe.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.GimliLongAxe.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.GimliLongAxe.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.GimliLongAxe.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrGimliLongAxe = new HAWeapon("lotrGimliLongAxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrGimliLongAxe);
				}else {
					lotrGimliLongAxe = new ItemBattleaxeHW("lotrGimliLongAxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(lotrGimliLongAxe, HeroicArmory.MOD_ID, "lotrGimliLongAxe");
				}
				ALL_ITEMS.add(lotrGimliLongAxe);
			}
			if (HAConfig.modifiedItems.lotrModified.MorgulBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.MorgulBlade.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.MorgulBlade.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.MorgulBlade.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.MorgulBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.MorgulBlade.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrMorgulBlade = new HAWeapon("lotrMorgulBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrMorgulBlade);
				}else {
					lotrMorgulBlade = new ItemDaggerHW("lotrMorgulBlade", dummyMaterialEx, properties, new WeaponPropertyBonusLiving(), new WeaponPropertyPotion(MobEffects.WITHER.getName(), MobEffects.WITHER, 5, 3), WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_BACKSTAB);
					SpartanWeaponryAPI.addItemModelToRegistry(lotrMorgulBlade, HeroicArmory.MOD_ID, "lotrMorgulBlade");
				}
				ALL_ITEMS.add(lotrMorgulBlade);
			}
			if (HAConfig.modifiedItems.lotrModified.Sting.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.Sting.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.Sting.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.Sting.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.Sting.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.Sting.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrSting = new HAWeapon("lotrSting", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrSting);
				}else {
					lotrSting = new ItemDaggerHW("lotrSting", dummyMaterialEx, properties, new WeaponPropertyElven(), WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_BACKSTAB);
					SpartanWeaponryAPI.addItemModelToRegistry(lotrSting, HeroicArmory.MOD_ID, "lotrSting");
				}
				ALL_ITEMS.add(lotrSting);
			}
			if (HAConfig.modifiedItems.lotrModified.Glamdring.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.Glamdring.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.Glamdring.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.Glamdring.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.Glamdring.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.Glamdring.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrGlamdring = new HAWeapon("lotrGlamdring", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrGlamdring);
				}else {
					lotrGlamdring = new ItemLongswordHW("lotrGlamdring", dummyMaterialEx, properties, new WeaponPropertyElven(), new WeaponPropertyHandAndAHalf());
					SpartanWeaponryAPI.addItemModelToRegistry(lotrGlamdring, HeroicArmory.MOD_ID, "lotrGlamdring");
				}
				ALL_ITEMS.add(lotrGlamdring);
			}
			if (HAConfig.modifiedItems.lotrModified.Anduril.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.Anduril.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.Anduril.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.Anduril.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.Anduril.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.Anduril.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrAnduril = new HAWeapon("lotrAnduril", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrAnduril);
				}else {
					lotrAnduril = new ItemLongswordHW("lotrAnduril", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 1.75F), new WeaponPropertyRandomRepair());
					SpartanWeaponryAPI.addItemModelToRegistry(lotrAnduril, HeroicArmory.MOD_ID, "lotrAnduril");
				}
				ALL_ITEMS.add(lotrAnduril);
			}
			if (HAConfig.modifiedItems.lotrModified.Narsil.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.Narsil.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.Narsil.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.Narsil.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.Narsil.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.Narsil.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrNarsil = new HAWeapon("lotrNarsil", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrNarsil);
				}else {
					lotrNarsil = new ItemLongswordHW("lotrNarsil", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(lotrNarsil, HeroicArmory.MOD_ID, "lotrNarsil");
				}
				ALL_ITEMS.add(lotrNarsil);
			}
			if (HAConfig.modifiedItems.lotrModified.SauronMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.SauronMace.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.SauronMace.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.SauronMace.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.SauronMace.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.SauronMace.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrSauronMace = new HAWeapon("lotrSauronMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrSauronMace);
				}else {
					lotrSauronMace = new ItemGreatswordHW("lotrSauronMace", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyPotion(MobEffects.NAUSEA.getName(), MobEffects.NAUSEA, 5, 1));
					SpartanWeaponryAPI.addItemModelToRegistry(lotrSauronMace, HeroicArmory.MOD_ID, "lotrSauronMace");
				}
				ALL_ITEMS.add(lotrSauronMace);
			}
			if (HAConfig.modifiedItems.lotrModified.WitchKingSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrModified.WitchKingSword.damage);
					put("durability", HAConfig.modifiedItems.lotrModified.WitchKingSword.durability);
					put("speed", HAConfig.modifiedItems.lotrModified.WitchKingSword.speed);
					put("enchantability", HAConfig.modifiedItems.lotrModified.WitchKingSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrModified.WitchKingSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lotrWitchKingSword = new HAWeapon("lotrWitchKingSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lotrWitchKingSword);
				}else {
					lotrWitchKingSword = new ItemGreatswordHW("lotrWitchKingSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(lotrWitchKingSword, HeroicArmory.MOD_ID, "lotrWitchKingSword");
				}
				ALL_ITEMS.add(lotrWitchKingSword);
			}
		}
		//loz
		if (HAConfig.includeSeries.loz) {
			if (HAConfig.modifiedItems.lozModified.MasterSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.MasterSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.MasterSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.MasterSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.MasterSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.MasterSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozMasterSword = new HAWeapon("lozMasterSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozMasterSword);
				}else {
					lozMasterSword = new ItemLongswordHW("lozMasterSword", dummyMaterialEx, properties, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(lozMasterSword, HeroicArmory.MOD_ID, "lozMasterSword");
				}
				ALL_ITEMS.add(lozMasterSword);
			}
			if (HAConfig.modifiedItems.lozModified.MasterSwordII.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.MasterSwordII.damage);
					put("durability", HAConfig.modifiedItems.lozModified.MasterSwordII.durability);
					put("speed", HAConfig.modifiedItems.lozModified.MasterSwordII.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.MasterSwordII.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.MasterSwordII.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozMasterSwordII = new HAWeapon("lozMasterSwordII", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozMasterSwordII);
				}else {
					lozMasterSwordII = new ItemLongswordHW("lozMasterSwordII", dummyMaterialEx, properties, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(lozMasterSwordII, HeroicArmory.MOD_ID, "lozMasterSwordII");
				}
				ALL_ITEMS.add(lozMasterSwordII);
			}
			if (HAConfig.modifiedItems.lozModified.TemperedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.TemperedSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.TemperedSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.TemperedSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.TemperedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.TemperedSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozTemperedSword = new HAWeapon("lozTemperedSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozTemperedSword);
				}else {
					lozTemperedSword = new ItemLongswordHW("lozTemperedSword", dummyMaterialEx, properties, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(lozTemperedSword, HeroicArmory.MOD_ID, "lozTemperedSword");
				}
				ALL_ITEMS.add(lozTemperedSword);
			}
			if (HAConfig.modifiedItems.lozModified.MasterSwordIII.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.MasterSwordIII.damage);
					put("durability", HAConfig.modifiedItems.lozModified.MasterSwordIII.durability);
					put("speed", HAConfig.modifiedItems.lozModified.MasterSwordIII.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.MasterSwordIII.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.MasterSwordIII.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozMasterSwordIII = new HAWeapon("lozMasterSwordIII", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozMasterSwordIII);
				}else {
					lozMasterSwordIII = new ItemLongswordHW("lozMasterSwordIII", dummyMaterialEx, properties, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(lozMasterSwordIII, HeroicArmory.MOD_ID, "lozMasterSwordIII");
				}
				ALL_ITEMS.add(lozMasterSwordIII);
			}
			if (HAConfig.modifiedItems.lozModified.GoldenSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GoldenSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GoldenSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GoldenSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GoldenSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GoldenSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozGoldenSword = new HAWeapon("lozGoldenSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozGoldenSword);
				}else {
					lozGoldenSword = new ItemLongswordHW("lozGoldenSword", dummyMaterialEx, properties, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(lozGoldenSword, HeroicArmory.MOD_ID, "lozGoldenSword");
				}
				ALL_ITEMS.add(lozGoldenSword);
			}
			if (HAConfig.modifiedItems.lozModified.Flameblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.Flameblade.damage);
					put("durability", HAConfig.modifiedItems.lozModified.Flameblade.durability);
					put("speed", HAConfig.modifiedItems.lozModified.Flameblade.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.Flameblade.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.Flameblade.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozFlameblade = new HAWeapon("lozFlameblade", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozFlameblade);
				}else {
					lozFlameblade = new ItemLongswordHW("lozFlameblade", dummyMaterialEx, properties, new WeaponPropertyIgnite(4));
					SpartanWeaponryAPI.addItemModelToRegistry(lozFlameblade, HeroicArmory.MOD_ID, "lozFlameblade");
				}
				ALL_ITEMS.add(lozFlameblade);
			}
			if (HAConfig.modifiedItems.lozModified.DarknutSwordTp.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.DarknutSwordTp.damage);
					put("durability", HAConfig.modifiedItems.lozModified.DarknutSwordTp.durability);
					put("speed", HAConfig.modifiedItems.lozModified.DarknutSwordTp.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.DarknutSwordTp.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.DarknutSwordTp.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozDarknutSwordTp = new HAWeapon("lozDarknutSwordTp", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozDarknutSwordTp);
				}else {
					lozDarknutSwordTp = new ItemGreatswordHW("lozDarknutSwordTp", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(lozDarknutSwordTp, HeroicArmory.MOD_ID, "lozDarknutSwordTp");
				}
				ALL_ITEMS.add(lozDarknutSwordTp);
			}
			if (HAConfig.modifiedItems.lozModified.GhirahimSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GhirahimSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GhirahimSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GhirahimSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GhirahimSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GhirahimSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozGhirahimSword = new HAWeapon("lozGhirahimSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozGhirahimSword);
				}else {
					lozGhirahimSword = new ItemKatanaHW("lozGhirahimSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(lozGhirahimSword, HeroicArmory.MOD_ID, "lozGhirahimSword");
				}
				ALL_ITEMS.add(lozGhirahimSword);
			}
			if (HAConfig.modifiedItems.lozModified.FierceDeitySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.FierceDeitySword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.FierceDeitySword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.FierceDeitySword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.FierceDeitySword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.FierceDeitySword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozFierceDeitySword = new HAWeapon("lozFierceDeitySword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozFierceDeitySword);
				}else {
					lozFierceDeitySword = new ItemGreatswordHW("lozFierceDeitySword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(lozFierceDeitySword, HeroicArmory.MOD_ID, "lozFierceDeitySword");
				}
				ALL_ITEMS.add(lozFierceDeitySword);
			}
			if (HAConfig.modifiedItems.lozModified.ZeldaSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.ZeldaSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.ZeldaSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.ZeldaSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.ZeldaSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.ZeldaSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozZeldaSword = new HAWeapon("lozZeldaSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozZeldaSword);
				}else {
					lozZeldaSword = new ItemRapierHW("lozZeldaSword", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR);
					SpartanWeaponryAPI.addItemModelToRegistry(lozZeldaSword, HeroicArmory.MOD_ID, "lozZeldaSword");
				}
				ALL_ITEMS.add(lozZeldaSword);
			}
			if (HAConfig.modifiedItems.lozModified.BokoStick.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.BokoStick.damage);
					put("durability", HAConfig.modifiedItems.lozModified.BokoStick.durability);
					put("speed", HAConfig.modifiedItems.lozModified.BokoStick.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.BokoStick.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.BokoStick.rarity);
				}};
				lozBokoStick = new HAWeapon("lozBokoStick", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozBokoStick);
				ALL_ITEMS.add(lozBokoStick);
			}
			if (HAConfig.modifiedItems.lozModified.CaneofByrna.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.CaneofByrna.damage);
					put("durability", HAConfig.modifiedItems.lozModified.CaneofByrna.durability);
					put("speed", HAConfig.modifiedItems.lozModified.CaneofByrna.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.CaneofByrna.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.CaneofByrna.rarity);
				}};
				lozCaneofByrna = new HAWeapon("lozCaneofByrna", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozCaneofByrna);
				ALL_ITEMS.add(lozCaneofByrna);
			}
			if (HAConfig.modifiedItems.lozModified.MegatonHammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.MegatonHammer.damage);
					put("durability", HAConfig.modifiedItems.lozModified.MegatonHammer.durability);
					put("speed", HAConfig.modifiedItems.lozModified.MegatonHammer.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.MegatonHammer.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.MegatonHammer.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozMegatonHammer = new HAWeapon("lozMegatonHammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozMegatonHammer);
				}else {
					lozMegatonHammer = new ItemHammerHW("lozMegatonHammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(lozMegatonHammer, HeroicArmory.MOD_ID, "lozMegatonHammer");
				}
				ALL_ITEMS.add(lozMegatonHammer);
			}
			if (HAConfig.modifiedItems.lozModified.KokiriSwordMm.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.KokiriSwordMm.damage);
					put("durability", HAConfig.modifiedItems.lozModified.KokiriSwordMm.durability);
					put("speed", HAConfig.modifiedItems.lozModified.KokiriSwordMm.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.KokiriSwordMm.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.KokiriSwordMm.rarity);
				}};
				lozKokiriSwordMm = new HAWeapon("lozKokiriSwordMm", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozKokiriSwordMm);
				ALL_ITEMS.add(lozKokiriSwordMm);
			}
			if (HAConfig.modifiedItems.lozModified.KokiriSwordOoT.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.KokiriSwordOoT.damage);
					put("durability", HAConfig.modifiedItems.lozModified.KokiriSwordOoT.durability);
					put("speed", HAConfig.modifiedItems.lozModified.KokiriSwordOoT.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.KokiriSwordOoT.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.KokiriSwordOoT.rarity);
				}};
				lozKokiriSwordOoT = new HAWeapon("lozKokiriSwordOoT", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozKokiriSwordOoT);
				ALL_ITEMS.add(lozKokiriSwordOoT);
			}
			if (HAConfig.modifiedItems.lozModified.DemiseSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.DemiseSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.DemiseSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.DemiseSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.DemiseSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.DemiseSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozDemiseSword = new HAWeapon("lozDemiseSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozDemiseSword);
				}else {
					lozDemiseSword = new ItemParryingDaggerHW("lozDemiseSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.BLOCK_MELEE, new WeaponPropertyThunder());
					SpartanWeaponryAPI.addItemModelToRegistry(lozDemiseSword, HeroicArmory.MOD_ID, "lozDemiseSword");
				}
				ALL_ITEMS.add(lozDemiseSword);
			}
			if (HAConfig.modifiedItems.lozModified.GiantKnife.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GiantKnife.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GiantKnife.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GiantKnife.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GiantKnife.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GiantKnife.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozGiantKnife = new HAWeapon("lozGiantKnife", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozGiantKnife);
				}else {
					lozGiantKnife = new ItemGreatswordHW("lozGiantKnife", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(lozGiantKnife, HeroicArmory.MOD_ID, "lozGiantKnife");
				}
				ALL_ITEMS.add(lozGiantKnife);
			}
			if (HAConfig.modifiedItems.lozModified.BiggoronSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.BiggoronSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.BiggoronSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.BiggoronSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.BiggoronSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.BiggoronSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozBiggoronSword = new HAWeapon("lozBiggoronSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozBiggoronSword);
				}else {
					lozBiggoronSword = new ItemGreatswordHW("lozBiggoronSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(lozBiggoronSword, HeroicArmory.MOD_ID, "lozBiggoronSword");
				}
				ALL_ITEMS.add(lozBiggoronSword);
			}
			if (HAConfig.modifiedItems.lozModified.PhantomGanonSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.PhantomGanonSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.PhantomGanonSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.PhantomGanonSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.PhantomGanonSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.PhantomGanonSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozPhantomGanonSword = new HAWeapon("lozPhantomGanonSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozPhantomGanonSword);
				}else {
					lozPhantomGanonSword = new ItemGreatswordHW("lozPhantomGanonSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(lozPhantomGanonSword, HeroicArmory.MOD_ID, "lozPhantomGanonSword");
				}
				ALL_ITEMS.add(lozPhantomGanonSword);
			}
			if (HAConfig.modifiedItems.lozModified.UltimateSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.UltimateSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.UltimateSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.UltimateSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.UltimateSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.UltimateSword.rarity);
				}};
				lozUltimateSword = new HAWeapon("lozUltimateSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozUltimateSword);
				ALL_ITEMS.add(lozUltimateSword);
			}
			if (HAConfig.modifiedItems.lozModified.RoyalGuardSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.RoyalGuardSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.RoyalGuardSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.RoyalGuardSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.RoyalGuardSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.RoyalGuardSword.rarity);
				}};
				lozRoyalGuardSword = new HAWeapon("lozRoyalGuardSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozRoyalGuardSword);
				ALL_ITEMS.add(lozRoyalGuardSword);
			}
			if (HAConfig.modifiedItems.lozModified.MagicSwordConcept.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.MagicSwordConcept.damage);
					put("durability", HAConfig.modifiedItems.lozModified.MagicSwordConcept.durability);
					put("speed", HAConfig.modifiedItems.lozModified.MagicSwordConcept.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.MagicSwordConcept.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.MagicSwordConcept.rarity);
				}};
				lozMagicSwordConcept = new HAWeapon("lozMagicSwordConcept", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozMagicSwordConcept);
				ALL_ITEMS.add(lozMagicSwordConcept);
			}
			if (HAConfig.modifiedItems.lozModified.MagicSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.MagicSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.MagicSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.MagicSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.MagicSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.MagicSword.rarity);
				}};
				lozMagicSword = new HAWeapon("lozMagicSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozMagicSword);
				ALL_ITEMS.add(lozMagicSword);
			}
			if (HAConfig.modifiedItems.lozModified.WhiteSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.WhiteSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.WhiteSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.WhiteSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.WhiteSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.WhiteSword.rarity);
				}};
				lozWhiteSword = new HAWeapon("lozWhiteSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozWhiteSword);
				ALL_ITEMS.add(lozWhiteSword);
			}
			if (HAConfig.modifiedItems.lozModified.WhiteSwordConcept.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.WhiteSwordConcept.damage);
					put("durability", HAConfig.modifiedItems.lozModified.WhiteSwordConcept.durability);
					put("speed", HAConfig.modifiedItems.lozModified.WhiteSwordConcept.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.WhiteSwordConcept.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.WhiteSwordConcept.rarity);
				}};
				lozWhiteSwordConcept = new HAWeapon("lozWhiteSwordConcept", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozWhiteSwordConcept);
				ALL_ITEMS.add(lozWhiteSwordConcept);
			}
			if (HAConfig.modifiedItems.lozModified.PicoriBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.PicoriBlade.damage);
					put("durability", HAConfig.modifiedItems.lozModified.PicoriBlade.durability);
					put("speed", HAConfig.modifiedItems.lozModified.PicoriBlade.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.PicoriBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.PicoriBlade.rarity);
				}};
				lozPicoriBlade = new HAWeapon("lozPicoriBlade", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozPicoriBlade);
				ALL_ITEMS.add(lozPicoriBlade);
			}
			if (HAConfig.modifiedItems.lozModified.RazorSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.RazorSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.RazorSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.RazorSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.RazorSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.RazorSword.rarity);
				}};
				lozRazorSword = new HAWeapon("lozRazorSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozRazorSword);
				ALL_ITEMS.add(lozRazorSword);
			}
			if (HAConfig.modifiedItems.lozModified.GreatFairySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GreatFairySword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GreatFairySword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GreatFairySword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GreatFairySword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GreatFairySword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozGreatFairySword = new HAWeapon("lozGreatFairySword", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozGreatFairySword);
				}else {
					lozGreatFairySword = new ItemGreatswordHW("lozGreatFairySword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(lozGreatFairySword, HeroicArmory.MOD_ID, "lozGreatFairySword");
				}
				ALL_ITEMS.add(lozGreatFairySword);
			}
			if (HAConfig.modifiedItems.lozModified.GoddessWhiteSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GoddessWhiteSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GoddessWhiteSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GoddessWhiteSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GoddessWhiteSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GoddessWhiteSword.rarity);
				}};
				lozGoddessWhiteSword = new HAWeapon("lozGoddessWhiteSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozGoddessWhiteSword);
				ALL_ITEMS.add(lozGoddessWhiteSword);
			}
			if (HAConfig.modifiedItems.lozModified.GoddessSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GoddessSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GoddessSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GoddessSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GoddessSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GoddessSword.rarity);
				}};
				lozGoddessSword = new HAWeapon("lozGoddessSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozGoddessSword);
				ALL_ITEMS.add(lozGoddessSword);
			}
			if (HAConfig.modifiedItems.lozModified.GildedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.GildedSword.damage);
					put("durability", HAConfig.modifiedItems.lozModified.GildedSword.durability);
					put("speed", HAConfig.modifiedItems.lozModified.GildedSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.GildedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.GildedSword.rarity);
				}};
				lozGildedSword = new HAWeapon("lozGildedSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(lozGildedSword);
				ALL_ITEMS.add(lozGildedSword);
			}
			if (HAConfig.modifiedItems.lozModified.SpikedBokoClub.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.SpikedBokoClub.damage);
					put("durability", HAConfig.modifiedItems.lozModified.SpikedBokoClub.durability);
					put("speed", HAConfig.modifiedItems.lozModified.SpikedBokoClub.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.SpikedBokoClub.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.SpikedBokoClub.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozSpikedBokoClub = new HAWeapon("lozSpikedBokoClub", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozSpikedBokoClub);
				}else {
					lozSpikedBokoClub = new ItemClubHW("lozSpikedBokoClub", dummyMaterialEx, properties, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(lozSpikedBokoClub, HeroicArmory.MOD_ID, "lozSpikedBokoClub");
				}
				ALL_ITEMS.add(lozSpikedBokoClub);
			}
			if (HAConfig.modifiedItems.lozModified.BokoClub.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozModified.BokoClub.damage);
					put("durability", HAConfig.modifiedItems.lozModified.BokoClub.durability);
					put("speed", HAConfig.modifiedItems.lozModified.BokoClub.speed);
					put("enchantability", HAConfig.modifiedItems.lozModified.BokoClub.enchantability);
					put("rarity", HAConfig.modifiedItems.lozModified.BokoClub.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					lozBokoClub = new HAWeapon("lozBokoClub", dummyMaterial, properties);
					HEROIC_ITEMS.add(lozBokoClub);
				}else {
					lozBokoClub = new ItemClubHW("lozBokoClub", dummyMaterialEx, properties, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(lozBokoClub, HeroicArmory.MOD_ID, "lozBokoClub");
				}
				ALL_ITEMS.add(lozBokoClub);
			}
		}
		//at
		if (HAConfig.includeSeries.at) {
			if (HAConfig.modifiedItems.atModified.JakeSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.JakeSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.JakeSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.JakeSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.JakeSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.JakeSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atJakeSword = new HAWeapon("atJakeSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(atJakeSword);
				}else {
					atJakeSword = new ItemLongswordHW("atJakeSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(atJakeSword, HeroicArmory.MOD_ID, "atJakeSword");
				}
				ALL_ITEMS.add(atJakeSword);
			}
			if (HAConfig.modifiedItems.atModified.CrystalSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.CrystalSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.CrystalSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.CrystalSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.CrystalSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.CrystalSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atCrystalSword = new HAWeapon("atCrystalSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(atCrystalSword);
				}else {
					atCrystalSword = new ItemLongswordHW("atCrystalSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(atCrystalSword, HeroicArmory.MOD_ID, "atCrystalSword");
				}
				ALL_ITEMS.add(atCrystalSword);
			}
			if (HAConfig.modifiedItems.atModified.Nothung.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.Nothung.damage);
					put("durability", HAConfig.modifiedItems.atModified.Nothung.durability);
					put("speed", HAConfig.modifiedItems.atModified.Nothung.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.Nothung.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.Nothung.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atNothung = new HAWeapon("atNothung", dummyMaterial, properties);
					HEROIC_ITEMS.add(atNothung);
				}else {
					atNothung = new ItemLongswordHW("atNothung", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(atNothung, HeroicArmory.MOD_ID, "atNothung");
				}
				ALL_ITEMS.add(atNothung);
			}
			if (HAConfig.modifiedItems.atModified.FinnSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.FinnSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.FinnSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.FinnSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.FinnSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.FinnSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atFinnSword = new HAWeapon("atFinnSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(atFinnSword);
				}else {
					atFinnSword = new ItemLongswordHW("atFinnSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(atFinnSword, HeroicArmory.MOD_ID, "atFinnSword");
				}
				ALL_ITEMS.add(atFinnSword);
			}
			if (HAConfig.modifiedItems.atModified.SwordoftheDead.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.SwordoftheDead.damage);
					put("durability", HAConfig.modifiedItems.atModified.SwordoftheDead.durability);
					put("speed", HAConfig.modifiedItems.atModified.SwordoftheDead.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.SwordoftheDead.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.SwordoftheDead.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atSwordoftheDead = new HAWeapon("atSwordoftheDead", dummyMaterial, properties);
					HEROIC_ITEMS.add(atSwordoftheDead);
				}else {
					atSwordoftheDead = new ItemLongswordHW("atSwordoftheDead", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(atSwordoftheDead, HeroicArmory.MOD_ID, "atSwordoftheDead");
				}
				ALL_ITEMS.add(atSwordoftheDead);
			}
			if (HAConfig.modifiedItems.atModified.WishStarSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.WishStarSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.WishStarSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.WishStarSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.WishStarSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.WishStarSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atWishStarSword = new HAWeapon("atWishStarSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(atWishStarSword);
				}else {
					atWishStarSword = new ItemLongswordHW("atWishStarSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(atWishStarSword, HeroicArmory.MOD_ID, "atWishStarSword");
				}
				ALL_ITEMS.add(atWishStarSword);
			}
			if (HAConfig.modifiedItems.atModified.FightKingSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.FightKingSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.FightKingSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.FightKingSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.FightKingSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.FightKingSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atFightKingSword = new HAWeapon("atFightKingSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(atFightKingSword);
				}else {
					atFightKingSword = new ItemGreatswordHW("atFightKingSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.THROWABLE);
					SpartanWeaponryAPI.addItemModelToRegistry(atFightKingSword, HeroicArmory.MOD_ID, "atFightKingSword");
				}
				ALL_ITEMS.add(atFightKingSword);
			}
			if (HAConfig.modifiedItems.atModified.RootSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.RootSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.RootSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.RootSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.RootSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.RootSword.rarity);
				}};
				atRootSword = new HAWeapon("atRootSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(atRootSword);
				ALL_ITEMS.add(atRootSword);
			}
			if (HAConfig.modifiedItems.atModified.Scarlet.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.Scarlet.damage);
					put("durability", HAConfig.modifiedItems.atModified.Scarlet.durability);
					put("speed", HAConfig.modifiedItems.atModified.Scarlet.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.Scarlet.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.Scarlet.rarity);
				}};
				atScarlet = new HAWeapon("atScarlet", dummyMaterial, properties);
				HEROIC_ITEMS.add(atScarlet);
				ALL_ITEMS.add(atScarlet);
			}
			if (HAConfig.modifiedItems.atModified.GrassSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.GrassSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.GrassSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.GrassSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.GrassSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.GrassSword.rarity);
				}};
				atGrassSword = new HAWeapon("atGrassSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(atGrassSword);
				ALL_ITEMS.add(atGrassSword);
			}
			if (HAConfig.modifiedItems.atModified.DemonBloodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.DemonBloodSword.damage);
					put("durability", HAConfig.modifiedItems.atModified.DemonBloodSword.durability);
					put("speed", HAConfig.modifiedItems.atModified.DemonBloodSword.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.DemonBloodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.DemonBloodSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atDemonBloodSword = new HAWeapon("atDemonBloodSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(atDemonBloodSword);
				}else {
					atDemonBloodSword = new ItemGreatswordHW("atDemonBloodSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(atDemonBloodSword, HeroicArmory.MOD_ID, "atDemonBloodSword");
				}
				ALL_ITEMS.add(atDemonBloodSword);
			}
			if (HAConfig.modifiedItems.atModified.AxeBass.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atModified.AxeBass.damage);
					put("durability", HAConfig.modifiedItems.atModified.AxeBass.durability);
					put("speed", HAConfig.modifiedItems.atModified.AxeBass.speed);
					put("enchantability", HAConfig.modifiedItems.atModified.AxeBass.enchantability);
					put("rarity", HAConfig.modifiedItems.atModified.AxeBass.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					atAxeBass = new HAWeapon("atAxeBass", dummyMaterial, properties);
					HEROIC_ITEMS.add(atAxeBass);
				}else {
					atAxeBass = new ItemBattleaxeHW("atAxeBass", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(atAxeBass, HeroicArmory.MOD_ID, "atAxeBass");
				}
				ALL_ITEMS.add(atAxeBass);
			}
		}
		//ff
		if (HAConfig.includeSeries.ff) {
			if (HAConfig.modifiedItems.ffModified.TheMasamune.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.ffModified.TheMasamune.damage);
					put("durability", HAConfig.modifiedItems.ffModified.TheMasamune.durability);
					put("speed", HAConfig.modifiedItems.ffModified.TheMasamune.speed);
					put("enchantability", HAConfig.modifiedItems.ffModified.TheMasamune.enchantability);
					put("rarity", HAConfig.modifiedItems.ffModified.TheMasamune.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					ffTheMasamune = new HAWeapon("ffTheMasamune", dummyMaterial, properties);
					HEROIC_ITEMS.add(ffTheMasamune);
				}else {
					ffTheMasamune = new ItemKatanaHW("ffTheMasamune", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL , WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(ffTheMasamune, HeroicArmory.MOD_ID, "ffTheMasamune");
				}
				ALL_ITEMS.add(ffTheMasamune);
			}
			if (HAConfig.modifiedItems.ffModified.BusterSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.ffModified.BusterSword.damage);
					put("durability", HAConfig.modifiedItems.ffModified.BusterSword.durability);
					put("speed", HAConfig.modifiedItems.ffModified.BusterSword.speed);
					put("enchantability", HAConfig.modifiedItems.ffModified.BusterSword.enchantability);
					put("rarity", HAConfig.modifiedItems.ffModified.BusterSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					ffBusterSword = new HAWeapon("ffBusterSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(ffBusterSword);
				}else {
					ffBusterSword = new ItemGreatswordHW("ffBusterSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(ffBusterSword, HeroicArmory.MOD_ID, "ffBusterSword");
				}
				ALL_ITEMS.add(ffBusterSword);
			}
			if (HAConfig.modifiedItems.ffModified.Caladbolg.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.ffModified.Caladbolg.damage);
					put("durability", HAConfig.modifiedItems.ffModified.Caladbolg.durability);
					put("speed", HAConfig.modifiedItems.ffModified.Caladbolg.speed);
					put("enchantability", HAConfig.modifiedItems.ffModified.Caladbolg.enchantability);
					put("rarity", HAConfig.modifiedItems.ffModified.Caladbolg.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					ffCaladbolg = new HAWeapon("ffCaladbolg", dummyMaterial, properties);
					HEROIC_ITEMS.add(ffCaladbolg);
				}else {
					ffCaladbolg = new ItemGreatswordHW("ffCaladbolg", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyCelestial());
					SpartanWeaponryAPI.addItemModelToRegistry(ffCaladbolg, HeroicArmory.MOD_ID, "ffCaladbolg");
				}
				ALL_ITEMS.add(ffCaladbolg);
			}
		}
		//rotmg
		if (HAConfig.includeSeries.rotmg) {
			if (HAConfig.modifiedItems.rotmgModified.SwordoftheColossus.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.SwordoftheColossus.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.SwordoftheColossus.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.SwordoftheColossus.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.SwordoftheColossus.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.SwordoftheColossus.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					rotmgSwordoftheColossus = new HAWeapon("rotmgSwordoftheColossus", dummyMaterial, properties);
					HEROIC_ITEMS.add(rotmgSwordoftheColossus);
				}else {
					rotmgSwordoftheColossus = new ItemGreatswordHW("rotmgSwordoftheColossus", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(rotmgSwordoftheColossus, HeroicArmory.MOD_ID, "rotmgSwordoftheColossus");
				}
				ALL_ITEMS.add(rotmgSwordoftheColossus);
			}
			if (HAConfig.modifiedItems.rotmgModified.CrystalSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.CrystalSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.CrystalSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.CrystalSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.CrystalSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.CrystalSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					rotmgCrystalSword = new HAWeapon("rotmgCrystalSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rotmgCrystalSword);
				}else {
					rotmgCrystalSword = new ItemLongswordHW("rotmgCrystalSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(rotmgCrystalSword, HeroicArmory.MOD_ID, "rotmgCrystalSword");
				}
				ALL_ITEMS.add(rotmgCrystalSword);
			}
			if (HAConfig.modifiedItems.rotmgModified.PixieEnchantedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.PixieEnchantedSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.PixieEnchantedSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.PixieEnchantedSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.PixieEnchantedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.PixieEnchantedSword.rarity);
				}};
				rotmgPixieEnchantedSword = new HAWeapon("rotmgPixieEnchantedSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgPixieEnchantedSword);
				ALL_ITEMS.add(rotmgPixieEnchantedSword);
			}
			if (HAConfig.modifiedItems.rotmgModified.SwordOfAcclaim.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.SwordOfAcclaim.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.SwordOfAcclaim.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.SwordOfAcclaim.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.SwordOfAcclaim.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.SwordOfAcclaim.rarity);
				}};
				rotmgSwordOfAcclaim = new HAWeapon("rotmgSwordOfAcclaim", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgSwordOfAcclaim);
				ALL_ITEMS.add(rotmgSwordOfAcclaim);
			}
			if (HAConfig.modifiedItems.rotmgModified.DemonBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.DemonBlade.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.DemonBlade.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.DemonBlade.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.DemonBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.DemonBlade.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					rotmgDemonBlade = new HAWeapon("rotmgDemonBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(rotmgDemonBlade);
				}else {
					rotmgDemonBlade = new ItemGreatswordHW("rotmgDemonBlade", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(rotmgDemonBlade, HeroicArmory.MOD_ID, "rotmgDemonBlade");
				}
				ALL_ITEMS.add(rotmgDemonBlade);
			}
			if (HAConfig.modifiedItems.rotmgModified.SwordoftheMadGod.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.SwordoftheMadGod.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.SwordoftheMadGod.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.SwordoftheMadGod.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.SwordoftheMadGod.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.SwordoftheMadGod.rarity);
				}};
				rotmgSwordoftheMadGod = new HAWeapon("rotmgSwordoftheMadGod", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgSwordoftheMadGod);
				ALL_ITEMS.add(rotmgSwordoftheMadGod);
			}
			if (HAConfig.modifiedItems.rotmgModified.Indomptable.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.Indomptable.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.Indomptable.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.Indomptable.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.Indomptable.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.Indomptable.rarity);
				}};
				rotmgIndomptable = new HAWeapon("rotmgIndomptable", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgIndomptable);
				ALL_ITEMS.add(rotmgIndomptable);
			}
			if (HAConfig.modifiedItems.rotmgModified.PirateKingCutlass.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.PirateKingCutlass.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.PirateKingCutlass.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.PirateKingCutlass.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.PirateKingCutlass.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.PirateKingCutlass.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					rotmgPirateKingCutlass = new HAWeapon("rotmgPirateKingCutlass", dummyMaterial, properties);
					HEROIC_ITEMS.add(rotmgPirateKingCutlass);
				}else {
					rotmgPirateKingCutlass = new ItemSaberHW("rotmgPirateKingCutlass", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rotmgPirateKingCutlass, HeroicArmory.MOD_ID, "rotmgPirateKingCutlass");
				}
				ALL_ITEMS.add(rotmgPirateKingCutlass);
			}
			if (HAConfig.modifiedItems.rotmgModified.SwordofSplendor.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.SwordofSplendor.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.SwordofSplendor.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.SwordofSplendor.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.SwordofSplendor.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.SwordofSplendor.rarity);
				}};
				rotmgSwordofSplendor = new HAWeapon("rotmgSwordofSplendor", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgSwordofSplendor);
				ALL_ITEMS.add(rotmgSwordofSplendor);
			}
			if (HAConfig.modifiedItems.rotmgModified.SkysplitterSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.SkysplitterSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.SkysplitterSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.SkysplitterSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.SkysplitterSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.SkysplitterSword.rarity);
				}};
				rotmgSkysplitterSword = new HAWeapon("rotmgSkysplitterSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgSkysplitterSword);
				ALL_ITEMS.add(rotmgSkysplitterSword);
			}
			if (HAConfig.modifiedItems.rotmgModified.ArchonSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.ArchonSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.ArchonSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.ArchonSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.ArchonSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.ArchonSword.rarity);
				}};
				rotmgArchonSword = new HAWeapon("rotmgArchonSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgArchonSword);
				ALL_ITEMS.add(rotmgArchonSword);
			}
			if (HAConfig.modifiedItems.rotmgModified.AncientStoneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.AncientStoneSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.AncientStoneSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.AncientStoneSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.AncientStoneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.AncientStoneSword.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					rotmgAncientStoneSword = new HAWeapon("rotmgAncientStoneSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rotmgAncientStoneSword);
				}else {
					rotmgAncientStoneSword = new ItemGreatswordHW("rotmgAncientStoneSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(rotmgAncientStoneSword, HeroicArmory.MOD_ID, "rotmgAncientStoneSword");
				}
				ALL_ITEMS.add(rotmgAncientStoneSword);
			}
			if (HAConfig.modifiedItems.rotmgModified.DragonsoulSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.DragonsoulSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.DragonsoulSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.DragonsoulSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.DragonsoulSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.DragonsoulSword.rarity);
				}};
				rotmgDragonsoulSword = new HAWeapon("rotmgDragonsoulSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgDragonsoulSword);
				ALL_ITEMS.add(rotmgDragonsoulSword);
			}
			if (HAConfig.modifiedItems.rotmgModified.RavenheartSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgModified.RavenheartSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgModified.RavenheartSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgModified.RavenheartSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgModified.RavenheartSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgModified.RavenheartSword.rarity);
				}};
				rotmgRavenheartSword = new HAWeapon("rotmgRavenheartSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rotmgRavenheartSword);
				ALL_ITEMS.add(rotmgRavenheartSword);
			}
		}
		//sc
		if (HAConfig.includeSeries.sc) {
			if (HAConfig.modifiedItems.scModified.Firangi.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Firangi.damage);
					put("durability", HAConfig.modifiedItems.scModified.Firangi.durability);
					put("speed", HAConfig.modifiedItems.scModified.Firangi.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Firangi.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Firangi.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scFirangi = new HAWeapon("scFirangi", dummyMaterial, properties);
					HEROIC_ITEMS.add(scFirangi);
				}else {
					scFirangi = new ItemGreatswordHW("scFirangi", dummyMaterialEx, properties, new WeaponPropertySelfPotion(MobEffects.REGENERATION.getName(), MobEffects.REGENERATION, 0.1D, 0));
					SpartanWeaponryAPI.addItemModelToRegistry(scFirangi, HeroicArmory.MOD_ID, "scFirangi");
				}
				ALL_ITEMS.add(scFirangi);
			}
			if (HAConfig.modifiedItems.scModified.Cocytus.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Cocytus.damage);
					put("durability", HAConfig.modifiedItems.scModified.Cocytus.durability);
					put("speed", HAConfig.modifiedItems.scModified.Cocytus.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Cocytus.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Cocytus.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scCocytus = new HAWeapon("scCocytus", dummyMaterial, properties);
					HEROIC_ITEMS.add(scCocytus);
				}else {
					scCocytus = new ItemGreatswordHW("scCocytus", dummyMaterialEx, properties, new WeaponPropertyLifePercent(-30));
					SpartanWeaponryAPI.addItemModelToRegistry(scCocytus, HeroicArmory.MOD_ID, "scCocytus");
				}
				ALL_ITEMS.add(scCocytus);
			}
			if (HAConfig.modifiedItems.scModified.ErlangBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.ErlangBlade.damage);
					put("durability", HAConfig.modifiedItems.scModified.ErlangBlade.durability);
					put("speed", HAConfig.modifiedItems.scModified.ErlangBlade.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.ErlangBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.ErlangBlade.rarity);
				}};
				scErlangBlade = new HAWeapon("scErlangBlade", dummyMaterial, properties);
				HEROIC_ITEMS.add(scErlangBlade);
				ALL_ITEMS.add(scErlangBlade);
			}
			if (HAConfig.modifiedItems.scModified.SoulEdgeNightmare.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.SoulEdgeNightmare.damage);
					put("durability", HAConfig.modifiedItems.scModified.SoulEdgeNightmare.durability);
					put("speed", HAConfig.modifiedItems.scModified.SoulEdgeNightmare.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.SoulEdgeNightmare.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.SoulEdgeNightmare.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scSoulEdgeNightmare = new HAWeapon("scSoulEdgeNightmare", dummyMaterial, properties);
					HEROIC_ITEMS.add(scSoulEdgeNightmare);
				}else {
					scSoulEdgeNightmare = new ItemGreatswordHW("scSoulEdgeNightmare", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scSoulEdgeNightmare, HeroicArmory.MOD_ID, "scSoulEdgeNightmare");
				}
				ALL_ITEMS.add(scSoulEdgeNightmare);
			}
			if (HAConfig.modifiedItems.scModified.Phlegethon.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Phlegethon.damage);
					put("durability", HAConfig.modifiedItems.scModified.Phlegethon.durability);
					put("speed", HAConfig.modifiedItems.scModified.Phlegethon.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Phlegethon.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Phlegethon.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scPhlegethon = new HAWeapon("scPhlegethon", dummyMaterial, properties);
					HEROIC_ITEMS.add(scPhlegethon);
				}else {
					scPhlegethon = new ItemLongswordHW("scPhlegethon", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, new WeaponPropertyShieldPierce(0.2f));
					SpartanWeaponryAPI.addItemModelToRegistry(scPhlegethon, HeroicArmory.MOD_ID, "scPhlegethon");
				}
				ALL_ITEMS.add(scPhlegethon);
			}
			if (HAConfig.modifiedItems.scModified.Acheron.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Acheron.damage);
					put("durability", HAConfig.modifiedItems.scModified.Acheron.durability);
					put("speed", HAConfig.modifiedItems.scModified.Acheron.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Acheron.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Acheron.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scAcheron = new HAWeapon("scAcheron", dummyMaterial, properties);
					HEROIC_ITEMS.add(scAcheron);
				}else {
					scAcheron = new ItemLongswordHW("scAcheron", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(scAcheron, HeroicArmory.MOD_ID, "scAcheron");
				}
				ALL_ITEMS.add(scAcheron);
			}
			if (HAConfig.modifiedItems.scModified.Lethe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Lethe.damage);
					put("durability", HAConfig.modifiedItems.scModified.Lethe.durability);
					put("speed", HAConfig.modifiedItems.scModified.Lethe.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Lethe.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Lethe.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scLethe = new HAWeapon("scLethe", dummyMaterial, properties);
					HEROIC_ITEMS.add(scLethe);
				}else {
					scLethe = new ItemLongswordHW("scLethe", dummyMaterialEx, properties, new WeaponPropertyLifePercent(20));
					SpartanWeaponryAPI.addItemModelToRegistry(scLethe, HeroicArmory.MOD_ID, "scLethe");
				}
				ALL_ITEMS.add(scLethe);
			}
			if (HAConfig.modifiedItems.scModified.QueenGuard.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.QueenGuard.damage);
					put("durability", HAConfig.modifiedItems.scModified.QueenGuard.durability);
					put("speed", HAConfig.modifiedItems.scModified.QueenGuard.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.QueenGuard.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.QueenGuard.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scQueenGuard = new HAWeapon("scQueenGuard", dummyMaterial, properties);
					HEROIC_ITEMS.add(scQueenGuard);
				}else {
					scQueenGuard = new ItemRapierHW("scQueenGuard", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR, new WeaponPropertySelfPotion(MobEffects.REGENERATION.getName(), MobEffects.REGENERATION, 0.1D, 0));
					SpartanWeaponryAPI.addItemModelToRegistry(scQueenGuard, HeroicArmory.MOD_ID, "scQueenGuard");
				}
				ALL_ITEMS.add(scQueenGuard);
			}
			if (HAConfig.modifiedItems.scModified.HolyAntler.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.HolyAntler.damage);
					put("durability", HAConfig.modifiedItems.scModified.HolyAntler.durability);
					put("speed", HAConfig.modifiedItems.scModified.HolyAntler.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.HolyAntler.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.HolyAntler.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scHolyAntler = new HAWeapon("scHolyAntler", dummyMaterial, properties);
					HEROIC_ITEMS.add(scHolyAntler);
				}else {
					scHolyAntler = new ItemRapierHW("scHolyAntler", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR, new WeaponPropertyLifeFlat(2));
					SpartanWeaponryAPI.addItemModelToRegistry(scHolyAntler, HeroicArmory.MOD_ID, "scHolyAntler");
				}
				ALL_ITEMS.add(scHolyAntler);
			}
			if (HAConfig.modifiedItems.scModified.Epee.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Epee.damage);
					put("durability", HAConfig.modifiedItems.scModified.Epee.durability);
					put("speed", HAConfig.modifiedItems.scModified.Epee.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Epee.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Epee.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scEpee = new HAWeapon("scEpee", dummyMaterial, properties);
					HEROIC_ITEMS.add(scEpee);
				}else {
					scEpee = new ItemRapierHW("scEpee", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR, new WeaponPropertyArmorBuff(0.3f));
					SpartanWeaponryAPI.addItemModelToRegistry(scEpee, HeroicArmory.MOD_ID, "scEpee");
				}
				ALL_ITEMS.add(scEpee);
			}
			if (HAConfig.modifiedItems.scModified.WarHammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.WarHammer.damage);
					put("durability", HAConfig.modifiedItems.scModified.WarHammer.durability);
					put("speed", HAConfig.modifiedItems.scModified.WarHammer.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.WarHammer.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.WarHammer.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scWarHammer = new HAWeapon("scWarHammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(scWarHammer);
				}else {
					scWarHammer = new ItemWarhammerHW("scWarHammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(scWarHammer, HeroicArmory.MOD_ID, "scWarHammer");
				}
				ALL_ITEMS.add(scWarHammer);
			}
			if (HAConfig.modifiedItems.scModified.Kulutues.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Kulutues.damage);
					put("durability", HAConfig.modifiedItems.scModified.Kulutues.durability);
					put("speed", HAConfig.modifiedItems.scModified.Kulutues.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Kulutues.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Kulutues.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scKulutues = new HAWeapon("scKulutues", dummyMaterial, properties);
					HEROIC_ITEMS.add(scKulutues);
				}else {
					scKulutues = new ItemBattleaxeHW("scKulutues", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE, WeaponProperties.ARMOUR_PIERCING_50, WeaponProperties.SWEEP_DAMAGE_HALF);
					SpartanWeaponryAPI.addItemModelToRegistry(scKulutues, HeroicArmory.MOD_ID, "scKulutues");
				}
				ALL_ITEMS.add(scKulutues);
			}
			if (HAConfig.modifiedItems.scModified.Estoc.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Estoc.damage);
					put("durability", HAConfig.modifiedItems.scModified.Estoc.durability);
					put("speed", HAConfig.modifiedItems.scModified.Estoc.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Estoc.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Estoc.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scEstoc = new HAWeapon("scEstoc", dummyMaterial, properties);
					HEROIC_ITEMS.add(scEstoc);
				}else {
					scEstoc = new ItemRapierHW("scEstoc", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR, new WeaponPropertyShieldPierce(0.2f));
					SpartanWeaponryAPI.addItemModelToRegistry(scEstoc, HeroicArmory.MOD_ID, "scEstoc");
				}
				ALL_ITEMS.add(scEstoc);
			}
			if (HAConfig.modifiedItems.scModified.Flambert2P.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Flambert2P.damage);
					put("durability", HAConfig.modifiedItems.scModified.Flambert2P.durability);
					put("speed", HAConfig.modifiedItems.scModified.Flambert2P.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Flambert2P.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Flambert2P.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scFlambert2P = new HAWeapon("scFlambert2P", dummyMaterial, properties);
					HEROIC_ITEMS.add(scFlambert2P);
				}else {
					scFlambert2P = new ItemRapierHW("scFlambert2P", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR);
					SpartanWeaponryAPI.addItemModelToRegistry(scFlambert2P, HeroicArmory.MOD_ID, "scFlambert2P");
				}
				ALL_ITEMS.add(scFlambert2P);
			}
			if (HAConfig.modifiedItems.scModified.Reiterpallasch.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Reiterpallasch.damage);
					put("durability", HAConfig.modifiedItems.scModified.Reiterpallasch.durability);
					put("speed", HAConfig.modifiedItems.scModified.Reiterpallasch.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Reiterpallasch.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Reiterpallasch.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scReiterpallasch = new HAWeapon("scReiterpallasch", dummyMaterial, properties);
					HEROIC_ITEMS.add(scReiterpallasch);
				}else {
					scReiterpallasch = new ItemRapierHW("scReiterpallasch", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR);
					SpartanWeaponryAPI.addItemModelToRegistry(scReiterpallasch, HeroicArmory.MOD_ID, "scReiterpallasch");
				}
				ALL_ITEMS.add(scReiterpallasch);
			}
			if (HAConfig.modifiedItems.scModified.Flambert.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Flambert.damage);
					put("durability", HAConfig.modifiedItems.scModified.Flambert.durability);
					put("speed", HAConfig.modifiedItems.scModified.Flambert.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Flambert.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Flambert.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scFlambert = new HAWeapon("scFlambert", dummyMaterial, properties);
					HEROIC_ITEMS.add(scFlambert);
				}else {
					scFlambert = new ItemRapierHW("scFlambert", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR);
					SpartanWeaponryAPI.addItemModelToRegistry(scFlambert, HeroicArmory.MOD_ID, "scFlambert");
				}
				ALL_ITEMS.add(scFlambert);
			}
			if (HAConfig.modifiedItems.scModified.BlueCrystalRod.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.BlueCrystalRod.damage);
					put("durability", HAConfig.modifiedItems.scModified.BlueCrystalRod.durability);
					put("speed", HAConfig.modifiedItems.scModified.BlueCrystalRod.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.BlueCrystalRod.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.BlueCrystalRod.rarity);
				}};
				scBlueCrystalRod = new HAWeapon("scBlueCrystalRod", dummyMaterial, properties);
				HEROIC_ITEMS.add(scBlueCrystalRod);
				ALL_ITEMS.add(scBlueCrystalRod);
			}
			if (HAConfig.modifiedItems.scModified.FireBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.FireBlade.damage);
					put("durability", HAConfig.modifiedItems.scModified.FireBlade.durability);
					put("speed", HAConfig.modifiedItems.scModified.FireBlade.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.FireBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.FireBlade.rarity);
				}};
				if (!SupportSpartanWeaponry) {
					scFireBlade = new HAWeapon("scFireBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(scFireBlade);
				}else {
					scFireBlade = new ItemRapierHW("scFireBlade", dummyMaterialEx, properties, new WeaponPropertyShieldPierce(0.2f) );
					SpartanWeaponryAPI.addItemModelToRegistry(scFireBlade, HeroicArmory.MOD_ID, "scFireBlade");
				}
				ALL_ITEMS.add(scFireBlade);
			}
			if (HAConfig.modifiedItems.scModified.XiSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.XiSword.damage);
					put("durability", HAConfig.modifiedItems.scModified.XiSword.durability);
					put("speed", HAConfig.modifiedItems.scModified.XiSword.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.XiSword.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.XiSword.rarity);
				}};
				scXiSword = new HAWeapon("scXiSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(scXiSword);
				ALL_ITEMS.add(scXiSword);
			}
			if (HAConfig.modifiedItems.scModified.OmegaSword2P.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.OmegaSword2P.damage);
					put("durability", HAConfig.modifiedItems.scModified.OmegaSword2P.durability);
					put("speed", HAConfig.modifiedItems.scModified.OmegaSword2P.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.OmegaSword2P.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.OmegaSword2P.rarity);
				}};
				scOmegaSword2P = new HAWeapon("scOmegaSword2P", dummyMaterial, properties);
				HEROIC_ITEMS.add(scOmegaSword2P);
				ALL_ITEMS.add(scOmegaSword2P);
			}
			if (HAConfig.modifiedItems.scModified.OmegaSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.OmegaSword.damage);
					put("durability", HAConfig.modifiedItems.scModified.OmegaSword.durability);
					put("speed", HAConfig.modifiedItems.scModified.OmegaSword.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.OmegaSword.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.OmegaSword.rarity);
				}};
				scOmegaSword = new HAWeapon("scOmegaSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(scOmegaSword);
				ALL_ITEMS.add(scOmegaSword);
			}
			if (HAConfig.modifiedItems.scModified.Orichalcum.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Orichalcum.damage);
					put("durability", HAConfig.modifiedItems.scModified.Orichalcum.durability);
					put("speed", HAConfig.modifiedItems.scModified.Orichalcum.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Orichalcum.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Orichalcum.rarity);
				}};
				scOrichalcum = new HAWeapon("scOrichalcum", dummyMaterial, properties);
				HEROIC_ITEMS.add(scOrichalcum);
				ALL_ITEMS.add(scOrichalcum);
			}
			if (HAConfig.modifiedItems.scModified.Stiletto.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Stiletto.damage);
					put("durability", HAConfig.modifiedItems.scModified.Stiletto.durability);
					put("speed", HAConfig.modifiedItems.scModified.Stiletto.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Stiletto.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Stiletto.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scStiletto = new HAWeapon("scStiletto", dummyMaterial, properties);
					HEROIC_ITEMS.add(scStiletto);
				}else {
					scStiletto = new ItemRapierHW("scStiletto", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_3_NO_ARMOUR);
					SpartanWeaponryAPI.addItemModelToRegistry(scStiletto, HeroicArmory.MOD_ID, "scStiletto");
				}
				ALL_ITEMS.add(scStiletto);
			}
			if (HAConfig.modifiedItems.scModified.Requiem.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Requiem.damage);
					put("durability", HAConfig.modifiedItems.scModified.Requiem.durability);
					put("speed", HAConfig.modifiedItems.scModified.Requiem.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Requiem.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Requiem.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scRequiem = new HAWeapon("scRequiem", dummyMaterial, properties);
					HEROIC_ITEMS.add(scRequiem);
				}else {
					scRequiem = new ItemGreatswordHW("scRequiem", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scRequiem, HeroicArmory.MOD_ID, "scRequiem");
				}
				ALL_ITEMS.add(scRequiem);
			}
			if (HAConfig.modifiedItems.scModified.Faust.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Faust.damage);
					put("durability", HAConfig.modifiedItems.scModified.Faust.durability);
					put("speed", HAConfig.modifiedItems.scModified.Faust.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Faust.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Faust.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scFaust = new HAWeapon("scFaust", dummyMaterial, properties);
					HEROIC_ITEMS.add(scFaust);
				}else {
					scFaust = new ItemGreatswordHW("scFaust", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scFaust, HeroicArmory.MOD_ID, "scFaust");
				}
				ALL_ITEMS.add(scFaust);
			}
			if (HAConfig.modifiedItems.scModified.Flamberge.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Flamberge.damage);
					put("durability", HAConfig.modifiedItems.scModified.Flamberge.durability);
					put("speed", HAConfig.modifiedItems.scModified.Flamberge.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Flamberge.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Flamberge.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scFlamberge = new HAWeapon("scFlamberge", dummyMaterial, properties);
					HEROIC_ITEMS.add(scFlamberge);
				}else {
					scFlamberge = new ItemGreatswordHW("scFlamberge", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scFlamberge, HeroicArmory.MOD_ID, "scFlamberge");
				}
				ALL_ITEMS.add(scFlamberge);
			}
			if (HAConfig.modifiedItems.scModified.SteelPaddle.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.SteelPaddle.damage);
					put("durability", HAConfig.modifiedItems.scModified.SteelPaddle.durability);
					put("speed", HAConfig.modifiedItems.scModified.SteelPaddle.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.SteelPaddle.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.SteelPaddle.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scSteelPaddle = new HAWeapon("scSteelPaddle", dummyMaterial, properties);
					HEROIC_ITEMS.add(scSteelPaddle);
				}else {
					scSteelPaddle = new ItemGreatswordHW("scSteelPaddle", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scSteelPaddle, HeroicArmory.MOD_ID, "scSteelPaddle");
				}
				ALL_ITEMS.add(scSteelPaddle);
			}
			if (HAConfig.modifiedItems.scModified.Glam.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.Glam.damage);
					put("durability", HAConfig.modifiedItems.scModified.Glam.durability);
					put("speed", HAConfig.modifiedItems.scModified.Glam.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.Glam.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.Glam.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scGlam = new HAWeapon("scGlam", dummyMaterial, properties);
					HEROIC_ITEMS.add(scGlam);
				}else {
					scGlam = new ItemGreatswordHW("scGlam", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scGlam, HeroicArmory.MOD_ID, "scGlam");
				}
				ALL_ITEMS.add(scGlam);
			}
			if (HAConfig.modifiedItems.scModified.GreatBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scModified.GreatBlade.damage);
					put("durability", HAConfig.modifiedItems.scModified.GreatBlade.durability);
					put("speed", HAConfig.modifiedItems.scModified.GreatBlade.speed);
					put("enchantability", HAConfig.modifiedItems.scModified.GreatBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.scModified.GreatBlade.rarity);
				}};
				if (!SupportSpartanWeaponry){
					scGreatBlade = new HAWeapon("scGreatBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(scGreatBlade);
				}else {
					scGreatBlade = new ItemGreatswordHW("scGreatBlade", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(scGreatBlade, HeroicArmory.MOD_ID, "scGreatBlade");
				}
				ALL_ITEMS.add(scGreatBlade);
			}
		}
		//rs
		if (HAConfig.includeSeries.rs) {
			if (HAConfig.modifiedItems.rsModified.BronzeSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BronzeSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BronzeSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BronzeSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BronzeSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BronzeSword.rarity);
				}};
				rsBronzeSword = new HAWeapon("rsBronzeSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsBronzeSword);
				ALL_ITEMS.add(rsBronzeSword);
			}
			if (HAConfig.modifiedItems.rsModified.IronSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.IronSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.IronSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.IronSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.IronSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.IronSword.rarity);
				}};
				rsIronSword = new HAWeapon("rsIronSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsIronSword);
				ALL_ITEMS.add(rsIronSword);
			}
			if (HAConfig.modifiedItems.rsModified.WhiteSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.WhiteSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.WhiteSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.WhiteSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.WhiteSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.WhiteSword.rarity);
				}};
				rsWhiteSword = new HAWeapon("rsWhiteSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsWhiteSword);
				ALL_ITEMS.add(rsWhiteSword);
			}
			if (HAConfig.modifiedItems.rsModified.BlackSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BlackSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BlackSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BlackSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BlackSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BlackSword.rarity);
				}};
				rsBlackSword = new HAWeapon("rsBlackSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsBlackSword);
				ALL_ITEMS.add(rsBlackSword);
			}
			if (HAConfig.modifiedItems.rsModified.SteelSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.SteelSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.SteelSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.SteelSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.SteelSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.SteelSword.rarity);
				}};
				rsSteelSword = new HAWeapon("rsSteelSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsSteelSword);
				ALL_ITEMS.add(rsSteelSword);
			}
			if (HAConfig.modifiedItems.rsModified.MithrilSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.MithrilSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.MithrilSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.MithrilSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.MithrilSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.MithrilSword.rarity);
				}};
				rsMithrilSword = new HAWeapon("rsMithrilSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsMithrilSword);
				ALL_ITEMS.add(rsMithrilSword);
			}
			if (HAConfig.modifiedItems.rsModified.AdamantSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.AdamantSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.AdamantSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.AdamantSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.AdamantSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.AdamantSword.rarity);
				}};
				rsAdamantSword = new HAWeapon("rsAdamantSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsAdamantSword);
				ALL_ITEMS.add(rsAdamantSword);
			}
			if (HAConfig.modifiedItems.rsModified.RuneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.RuneSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.RuneSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.RuneSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.RuneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.RuneSword.rarity);
				}};
				rsRuneSword = new HAWeapon("rsRuneSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsRuneSword);
				ALL_ITEMS.add(rsRuneSword);
			}
			if (HAConfig.modifiedItems.rsModified.DragonSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.DragonSword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.DragonSword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.DragonSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.DragonSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.DragonSword.rarity);
				}};
				rsDragonSword = new HAWeapon("rsDragonSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsDragonSword);
				ALL_ITEMS.add(rsDragonSword);
			}
			if (HAConfig.modifiedItems.rsModified.BronzeBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BronzeBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BronzeBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BronzeBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BronzeBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BronzeBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBronzeBattleaxe = new HAWeapon("rsBronzeBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBronzeBattleaxe);
				}else {
					rsBronzeBattleaxe = new ItemBattleaxeHW("rsBronzeBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBronzeBattleaxe, HeroicArmory.MOD_ID, "rsBronzeBattleaxe");
				}
				ALL_ITEMS.add(rsBronzeBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.IronBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.IronBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.IronBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.IronBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.IronBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.IronBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsIronBattleaxe = new HAWeapon("rsIronBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsIronBattleaxe);
				}else {
					rsIronBattleaxe = new ItemBattleaxeHW("rsIronBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsIronBattleaxe, HeroicArmory.MOD_ID, "rsIronBattleaxe");
				}
				ALL_ITEMS.add(rsIronBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.SteelBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.SteelBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.SteelBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.SteelBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.SteelBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.SteelBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsSteelBattleaxe = new HAWeapon("rsSteelBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsSteelBattleaxe);
				}else {
					rsSteelBattleaxe = new ItemBattleaxeHW("rsSteelBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsSteelBattleaxe, HeroicArmory.MOD_ID, "rsSteelBattleaxe");
				}
				ALL_ITEMS.add(rsSteelBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.BlackBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BlackBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BlackBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BlackBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BlackBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BlackBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBlackBattleaxe = new HAWeapon("rsBlackBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBlackBattleaxe);
				}else {
					rsBlackBattleaxe = new ItemBattleaxeHW("rsBlackBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBlackBattleaxe, HeroicArmory.MOD_ID, "rsBlackBattleaxe");
				}
				ALL_ITEMS.add(rsBlackBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.WhiteBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.WhiteBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.WhiteBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.WhiteBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.WhiteBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.WhiteBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsWhiteBattleaxe = new HAWeapon("rsWhiteBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsWhiteBattleaxe);
				}else {
					rsWhiteBattleaxe = new ItemBattleaxeHW("rsWhiteBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsWhiteBattleaxe, HeroicArmory.MOD_ID, "rsWhiteBattleaxe");
				}
				ALL_ITEMS.add(rsWhiteBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.MithrilBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.MithrilBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.MithrilBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.MithrilBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.MithrilBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.MithrilBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsMithrilBattleaxe = new HAWeapon("rsMithrilBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsMithrilBattleaxe);
				}else {
					rsMithrilBattleaxe = new ItemBattleaxeHW("rsMithrilBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsMithrilBattleaxe, HeroicArmory.MOD_ID, "rsMithrilBattleaxe");
				}
				ALL_ITEMS.add(rsMithrilBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.AdamantBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.AdamantBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.AdamantBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.AdamantBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.AdamantBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.AdamantBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsAdamantBattleaxe = new HAWeapon("rsAdamantBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsAdamantBattleaxe);
				}else {
					rsAdamantBattleaxe = new ItemBattleaxeHW("rsAdamantBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsAdamantBattleaxe, HeroicArmory.MOD_ID, "rsAdamantBattleaxe");
				}
				ALL_ITEMS.add(rsAdamantBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.RuneBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.RuneBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.RuneBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.RuneBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.RuneBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.RuneBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsRuneBattleaxe = new HAWeapon("rsRuneBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsRuneBattleaxe);
				}else {
					rsRuneBattleaxe = new ItemBattleaxeHW("rsRuneBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsRuneBattleaxe, HeroicArmory.MOD_ID, "rsRuneBattleaxe");
				}
				ALL_ITEMS.add(rsRuneBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.DragonBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.DragonBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsModified.DragonBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsModified.DragonBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.DragonBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.DragonBattleaxe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsDragonBattleaxe = new HAWeapon("rsDragonBattleaxe", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsDragonBattleaxe);
				}else {
					rsDragonBattleaxe = new ItemBattleaxeHW("rsDragonBattleaxe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE);
					SpartanWeaponryAPI.addItemModelToRegistry(rsDragonBattleaxe, HeroicArmory.MOD_ID, "rsDragonBattleaxe");
				}
				ALL_ITEMS.add(rsDragonBattleaxe);
			}
			if (HAConfig.modifiedItems.rsModified.BronzeScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BronzeScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BronzeScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BronzeScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BronzeScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BronzeScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBronzeScimitar = new HAWeapon("rsBronzeScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBronzeScimitar);
				}else {
					rsBronzeScimitar = new ItemSaberHW("rsBronzeScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBronzeScimitar, HeroicArmory.MOD_ID, "rsBronzeScimitar");
				}
				ALL_ITEMS.add(rsBronzeScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.IronScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.IronScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.IronScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.IronScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.IronScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.IronScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsIronScimitar = new HAWeapon("rsIronScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsIronScimitar);
				}else {
					rsIronScimitar = new ItemSaberHW("rsIronScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsIronScimitar, HeroicArmory.MOD_ID, "rsIronScimitar");
				}
				ALL_ITEMS.add(rsIronScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.BlackScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BlackScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BlackScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BlackScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BlackScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BlackScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBlackScimitar = new HAWeapon("rsBlackScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBlackScimitar);
				}else {
					rsBlackScimitar = new ItemSaberHW("rsBlackScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBlackScimitar, HeroicArmory.MOD_ID, "rsBlackScimitar");
				}
				ALL_ITEMS.add(rsBlackScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.WhiteScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.WhiteScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.WhiteScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.WhiteScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.WhiteScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.WhiteScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsWhiteScimitar = new HAWeapon("rsWhiteScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsWhiteScimitar);
				}else {
					rsWhiteScimitar = new ItemSaberHW("rsWhiteScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsWhiteScimitar, HeroicArmory.MOD_ID, "rsWhiteScimitar");
				}
				ALL_ITEMS.add(rsWhiteScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.SteelScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.SteelScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.SteelScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.SteelScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.SteelScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.SteelScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsSteelScimitar = new HAWeapon("rsSteelScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsSteelScimitar);
				}else {
					rsSteelScimitar = new ItemSaberHW("rsSteelScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsSteelScimitar, HeroicArmory.MOD_ID, "rsSteelScimitar");
				}
				ALL_ITEMS.add(rsSteelScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.MithrilScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.MithrilScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.MithrilScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.MithrilScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.MithrilScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.MithrilScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsMithrilScimitar = new HAWeapon("rsMithrilScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsMithrilScimitar);
				}else {
					rsMithrilScimitar = new ItemSaberHW("rsMithrilScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsMithrilScimitar, HeroicArmory.MOD_ID, "rsMithrilScimitar");
				}
				ALL_ITEMS.add(rsMithrilScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.AdamantScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.AdamantScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.AdamantScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.AdamantScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.AdamantScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.AdamantScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsAdamantScimitar = new HAWeapon("rsAdamantScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsAdamantScimitar);
				}else {
					rsAdamantScimitar = new ItemSaberHW("rsAdamantScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsAdamantScimitar, HeroicArmory.MOD_ID, "rsAdamantScimitar");
				}
				ALL_ITEMS.add(rsAdamantScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.RuneScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.RuneScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.RuneScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.RuneScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.RuneScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.RuneScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsRuneScimitar = new HAWeapon("rsRuneScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsRuneScimitar);
				}else {
					rsRuneScimitar = new ItemSaberHW("rsRuneScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsRuneScimitar, HeroicArmory.MOD_ID, "rsRuneScimitar");
				}
				ALL_ITEMS.add(rsRuneScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.DragonScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.DragonScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsModified.DragonScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsModified.DragonScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.DragonScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.DragonScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsDragonScimitar = new HAWeapon("rsDragonScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsDragonScimitar);
				}else {
					rsDragonScimitar = new ItemSaberHW("rsDragonScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(rsDragonScimitar, HeroicArmory.MOD_ID, "rsDragonScimitar");
				}
				ALL_ITEMS.add(rsDragonScimitar);
			}
			if (HAConfig.modifiedItems.rsModified.BronzeWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BronzeWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BronzeWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BronzeWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BronzeWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BronzeWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBronzeWarhammer = new HAWeapon("rsBronzeWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBronzeWarhammer);
				}else {
					rsBronzeWarhammer = new ItemHammerHW("rsBronzeWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBronzeWarhammer, HeroicArmory.MOD_ID, "rsBronzeWarhammer");
				}
				ALL_ITEMS.add(rsBronzeWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.IronWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.IronWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.IronWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.IronWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.IronWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.IronWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsIronWarhammer = new HAWeapon("rsIronWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsIronWarhammer);
				}else {
					rsIronWarhammer = new ItemHammerHW("rsIronWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsIronWarhammer, HeroicArmory.MOD_ID, "rsIronWarhammer");
				}
				ALL_ITEMS.add(rsIronWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.SteelWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.SteelWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.SteelWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.SteelWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.SteelWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.SteelWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsSteelWarhammer = new HAWeapon("rsSteelWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsSteelWarhammer);
				}else {
					rsSteelWarhammer = new ItemHammerHW("rsSteelWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsSteelWarhammer, HeroicArmory.MOD_ID, "rsSteelWarhammer");
				}
				ALL_ITEMS.add(rsSteelWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.BlackWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BlackWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BlackWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BlackWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BlackWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BlackWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBlackWarhammer = new HAWeapon("rsBlackWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBlackWarhammer);
				}else {
					rsBlackWarhammer = new ItemHammerHW("rsBlackWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBlackWarhammer, HeroicArmory.MOD_ID, "rsBlackWarhammer");
				}
				ALL_ITEMS.add(rsBlackWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.WhiteWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.WhiteWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.WhiteWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.WhiteWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.WhiteWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.WhiteWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsWhiteWarhammer = new HAWeapon("rsWhiteWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsWhiteWarhammer);
				}else {
					rsWhiteWarhammer = new ItemHammerHW("rsWhiteWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsWhiteWarhammer, HeroicArmory.MOD_ID, "rsWhiteWarhammer");
				}
				ALL_ITEMS.add(rsWhiteWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.MithrilWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.MithrilWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.MithrilWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.MithrilWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.MithrilWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.MithrilWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsMithrilWarhammer = new HAWeapon("rsMithrilWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsMithrilWarhammer);
				}else {
					rsMithrilWarhammer = new ItemHammerHW("rsMithrilWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsMithrilWarhammer, HeroicArmory.MOD_ID, "rsMithrilWarhammer");
				}
				ALL_ITEMS.add(rsMithrilWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.AdamantWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.AdamantWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.AdamantWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.AdamantWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.AdamantWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.AdamantWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsAdamantWarhammer = new HAWeapon("rsAdamantWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsAdamantWarhammer);
				}else {
					rsAdamantWarhammer = new ItemHammerHW("rsAdamantWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsAdamantWarhammer, HeroicArmory.MOD_ID, "rsAdamantWarhammer");
				}
				ALL_ITEMS.add(rsAdamantWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.RuneWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.RuneWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.RuneWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.RuneWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.RuneWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.RuneWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsRuneWarhammer = new HAWeapon("rsRuneWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsRuneWarhammer);
				}else {
					rsRuneWarhammer = new ItemHammerHW("rsRuneWarhammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsRuneWarhammer, HeroicArmory.MOD_ID, "rsRuneWarhammer");
				}
				ALL_ITEMS.add(rsRuneWarhammer);
			}
			if (HAConfig.modifiedItems.rsModified.BronzeMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BronzeMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BronzeMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BronzeMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BronzeMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BronzeMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBronzeMace = new HAWeapon("rsBronzeMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBronzeMace);
				}else {
					rsBronzeMace = new ItemMaceHW("rsBronzeMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBronzeMace, HeroicArmory.MOD_ID, "rsBronzeMace");
				}
				ALL_ITEMS.add(rsBronzeMace);
			}
			if (HAConfig.modifiedItems.rsModified.IronMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.IronMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.IronMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.IronMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.IronMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.IronMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsIronMace = new HAWeapon("rsIronMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsIronMace);
				}else {
					rsIronMace = new ItemMaceHW("rsIronMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsIronMace, HeroicArmory.MOD_ID, "rsIronMace");
				}
				ALL_ITEMS.add(rsIronMace);
			}
			if (HAConfig.modifiedItems.rsModified.SteelMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.SteelMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.SteelMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.SteelMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.SteelMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.SteelMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsSteelMace = new HAWeapon("rsSteelMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsSteelMace);
				}else {
					rsSteelMace = new ItemMaceHW("rsSteelMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsSteelMace, HeroicArmory.MOD_ID, "rsSteelMace");
				}
				ALL_ITEMS.add(rsSteelMace);
			}
			if (HAConfig.modifiedItems.rsModified.BlackMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BlackMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BlackMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BlackMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BlackMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BlackMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBlackMace = new HAWeapon("rsBlackMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBlackMace);
				}else {
					rsBlackMace = new ItemMaceHW("rsBlackMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBlackMace, HeroicArmory.MOD_ID, "rsBlackMace");
				}
				ALL_ITEMS.add(rsBlackMace);
			}
			if (HAConfig.modifiedItems.rsModified.WhiteMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.WhiteMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.WhiteMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.WhiteMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.WhiteMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.WhiteMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsWhiteMace = new HAWeapon("rsWhiteMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsWhiteMace);
				}else {
					rsWhiteMace = new ItemMaceHW("rsWhiteMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsWhiteMace, HeroicArmory.MOD_ID, "rsWhiteMace");
				}
				ALL_ITEMS.add(rsWhiteMace);
			}
			if (HAConfig.modifiedItems.rsModified.MithrilMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.MithrilMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.MithrilMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.MithrilMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.MithrilMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.MithrilMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsMithrilMace = new HAWeapon("rsMithrilMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsMithrilMace);
				}else {
					rsMithrilMace = new ItemMaceHW("rsMithrilMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsMithrilMace, HeroicArmory.MOD_ID, "rsMithrilMace");
				}
				ALL_ITEMS.add(rsMithrilMace);
			}
			if (HAConfig.modifiedItems.rsModified.AdamantMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.AdamantMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.AdamantMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.AdamantMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.AdamantMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.AdamantMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsAdamantMace = new HAWeapon("rsAdamantMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsAdamantMace);
				}else {
					rsAdamantMace = new ItemMaceHW("rsAdamantMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsAdamantMace, HeroicArmory.MOD_ID, "rsAdamantMace");
				}
				ALL_ITEMS.add(rsAdamantMace);
			}
			if (HAConfig.modifiedItems.rsModified.RuneMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.RuneMace.damage);
					put("durability", HAConfig.modifiedItems.rsModified.RuneMace.durability);
					put("speed", HAConfig.modifiedItems.rsModified.RuneMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.RuneMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.RuneMace.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsRuneMace = new HAWeapon("rsRuneMace", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsRuneMace);
				}else {
					rsRuneMace = new ItemMaceHW("rsRuneMace", dummyMaterialEx, properties, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(rsRuneMace, HeroicArmory.MOD_ID, "rsRuneMace");
				}
				ALL_ITEMS.add(rsRuneMace);
			}
			if (HAConfig.modifiedItems.rsModified.GraniteLongsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.GraniteLongsword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.GraniteLongsword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.GraniteLongsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.GraniteLongsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.GraniteLongsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsGraniteLongsword = new HAWeapon("rsGraniteLongsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsGraniteLongsword);
				}else {
					rsGraniteLongsword = new ItemLongswordHW("rsGraniteLongsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(rsGraniteLongsword, HeroicArmory.MOD_ID, "rsGraniteLongsword");
				}
				ALL_ITEMS.add(rsGraniteLongsword);
			}
			if (HAConfig.modifiedItems.rsModified.GraniteHammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.GraniteHammer.damage);
					put("durability", HAConfig.modifiedItems.rsModified.GraniteHammer.durability);
					put("speed", HAConfig.modifiedItems.rsModified.GraniteHammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.GraniteHammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.GraniteHammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsGraniteHammer = new HAWeapon("rsGraniteHammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsGraniteHammer);
				}else {
					rsGraniteHammer = new ItemHammerHW("rsGraniteHammer", dummyMaterialEx, properties, WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsGraniteHammer, HeroicArmory.MOD_ID, "rsGraniteHammer");
				}
				ALL_ITEMS.add(rsGraniteHammer);
			}
			if (HAConfig.modifiedItems.rsModified.GraniteMaul.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.GraniteMaul.damage);
					put("durability", HAConfig.modifiedItems.rsModified.GraniteMaul.durability);
					put("speed", HAConfig.modifiedItems.rsModified.GraniteMaul.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.GraniteMaul.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.GraniteMaul.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsGraniteMaul = new HAWeapon("rsGraniteMaul", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsGraniteMaul);
				}else {
					rsGraniteMaul = new ItemWarhammerHW("rsGraniteMaul", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(rsGraniteMaul, HeroicArmory.MOD_ID, "rsGraniteMaul");
				}
				ALL_ITEMS.add(rsGraniteMaul);
			}
			if (HAConfig.modifiedItems.rsModified.ElderMaul.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.ElderMaul.damage);
					put("durability", HAConfig.modifiedItems.rsModified.ElderMaul.durability);
					put("speed", HAConfig.modifiedItems.rsModified.ElderMaul.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.ElderMaul.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.ElderMaul.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsElderMaul = new HAWeapon("rsElderMaul", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsElderMaul);
				}else {
					rsElderMaul = new ItemWarhammerHW("rsElderMaul", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(rsElderMaul, HeroicArmory.MOD_ID, "rsElderMaul");
				}
				ALL_ITEMS.add(rsElderMaul);
			}
			if (HAConfig.modifiedItems.rsModified.Toktzxilak.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.Toktzxilak.damage);
					put("durability", HAConfig.modifiedItems.rsModified.Toktzxilak.durability);
					put("speed", HAConfig.modifiedItems.rsModified.Toktzxilak.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.Toktzxilak.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.Toktzxilak.rarity);
				}};
				rsToktzxilak = new HAWeapon("rsToktzxilak", dummyMaterial, properties);
				HEROIC_ITEMS.add(rsToktzxilak);
				ALL_ITEMS.add(rsToktzxilak);
			}
			if (HAConfig.modifiedItems.rsModified.Wolfsbane.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.Wolfsbane.damage);
					put("durability", HAConfig.modifiedItems.rsModified.Wolfsbane.durability);
					put("speed", HAConfig.modifiedItems.rsModified.Wolfsbane.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.Wolfsbane.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.Wolfsbane.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsWolfsbane = new HAWeapon("rsWolfsbane", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsWolfsbane);
				}else {
					rsWolfsbane = new ItemDaggerHW("rsWolfsbane", dummyMaterialEx, properties, WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_BACKSTAB);
					SpartanWeaponryAPI.addItemModelToRegistry(rsWolfsbane, HeroicArmory.MOD_ID, "rsWolfsbane");
				}
				ALL_ITEMS.add(rsWolfsbane);
			}
			if (HAConfig.modifiedItems.rsModified.ZamorakGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.ZamorakGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.ZamorakGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.ZamorakGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.ZamorakGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.ZamorakGodsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsZamorakGodsword = new HAWeapon("rsZamorakGodsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsZamorakGodsword);
				}else {
					rsZamorakGodsword = new ItemGreatswordHW("rsZamorakGodsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyFreeze(6));
					SpartanWeaponryAPI.addItemModelToRegistry(rsZamorakGodsword, HeroicArmory.MOD_ID, "rsZamorakGodsword");
				}
				ALL_ITEMS.add(rsZamorakGodsword);
			}
			if (HAConfig.modifiedItems.rsModified.BandosGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BandosGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BandosGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BandosGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BandosGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BandosGodsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBandosGodsword = new HAWeapon("rsBandosGodsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBandosGodsword);
				}else {
					rsBandosGodsword = new ItemGreatswordHW("rsBandosGodsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyArmorDebuff(30));
					SpartanWeaponryAPI.addItemModelToRegistry(rsBandosGodsword, HeroicArmory.MOD_ID, "rsBandosGodsword");
				}
				ALL_ITEMS.add(rsBandosGodsword);
			}
			if (HAConfig.modifiedItems.rsModified.ArmadylGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.ArmadylGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.ArmadylGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.ArmadylGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.ArmadylGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.ArmadylGodsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsArmadylGodsword = new HAWeapon("rsArmadylGodsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsArmadylGodsword);
				}else {
					rsArmadylGodsword = new ItemGreatswordHW("rsArmadylGodsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyCritBonus(0.25f));
					SpartanWeaponryAPI.addItemModelToRegistry(rsArmadylGodsword, HeroicArmory.MOD_ID, "rsArmadylGodsword");
				}
				ALL_ITEMS.add(rsArmadylGodsword);
			}
			if (HAConfig.modifiedItems.rsModified.SaradominGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.SaradominGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsModified.SaradominGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsModified.SaradominGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.SaradominGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.SaradominGodsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsSaradominGodsword = new HAWeapon("rsSaradominGodsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsSaradominGodsword);
				}else {
					rsSaradominGodsword = new ItemGreatswordHW("rsSaradominGodsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyLifePercent(20));
					SpartanWeaponryAPI.addItemModelToRegistry(rsSaradominGodsword, HeroicArmory.MOD_ID, "rsSaradominGodsword");
				}
				ALL_ITEMS.add(rsSaradominGodsword);
			}
			if (HAConfig.modifiedItems.rsModified.BarrelchestAnchor.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsModified.BarrelchestAnchor.damage);
					put("durability", HAConfig.modifiedItems.rsModified.BarrelchestAnchor.durability);
					put("speed", HAConfig.modifiedItems.rsModified.BarrelchestAnchor.speed);
					put("enchantability", HAConfig.modifiedItems.rsModified.BarrelchestAnchor.enchantability);
					put("rarity", HAConfig.modifiedItems.rsModified.BarrelchestAnchor.rarity);
				}};
				if (!SupportSpartanWeaponry){
					rsBarrelchestAnchor = new HAWeapon("rsBarrelchestAnchor", dummyMaterial, properties);
					HEROIC_ITEMS.add(rsBarrelchestAnchor);
				}else {
					rsBarrelchestAnchor = new ItemClubHW("rsBarrelchestAnchor", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.SWEEP_DAMAGE_FULL , WeaponProperties.KNOCKBACK, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(rsBarrelchestAnchor, HeroicArmory.MOD_ID, "rsBarrelchestAnchor");
				}
				ALL_ITEMS.add(rsBarrelchestAnchor);
			}
		}
		//dmc
		if (HAConfig.includeSeries.dmc) {
			if (HAConfig.modifiedItems.dmcModified.RedQueen.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dmcModified.RedQueen.damage);
					put("durability", HAConfig.modifiedItems.dmcModified.RedQueen.durability);
					put("speed", HAConfig.modifiedItems.dmcModified.RedQueen.speed);
					put("enchantability", HAConfig.modifiedItems.dmcModified.RedQueen.enchantability);
					put("rarity", HAConfig.modifiedItems.dmcModified.RedQueen.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dmcRedQueen = new HAWeapon("dmcRedQueen", dummyMaterial, properties);
					HEROIC_ITEMS.add(dmcRedQueen);
				}else {
					dmcRedQueen = new ItemSaberHW("dmcRedQueen", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(dmcRedQueen, HeroicArmory.MOD_ID, "dmcRedQueen");
				}
				ALL_ITEMS.add(dmcRedQueen);
			}
			if (HAConfig.modifiedItems.dmcModified.Rebellion.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dmcModified.Rebellion.damage);
					put("durability", HAConfig.modifiedItems.dmcModified.Rebellion.durability);
					put("speed", HAConfig.modifiedItems.dmcModified.Rebellion.speed);
					put("enchantability", HAConfig.modifiedItems.dmcModified.Rebellion.enchantability);
					put("rarity", HAConfig.modifiedItems.dmcModified.Rebellion.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dmcRebellion = new HAWeapon("dmcRebellion", dummyMaterial, properties);
					HEROIC_ITEMS.add(dmcRebellion);
				}else {
					dmcRebellion = new ItemGreatswordHW("dmcRebellion", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(dmcRebellion, HeroicArmory.MOD_ID, "dmcRebellion");
				}
				ALL_ITEMS.add(dmcRebellion);
			}
			if (HAConfig.modifiedItems.dmcModified.Yamato.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dmcModified.Yamato.damage);
					put("durability", HAConfig.modifiedItems.dmcModified.Yamato.durability);
					put("speed", HAConfig.modifiedItems.dmcModified.Yamato.speed);
					put("enchantability", HAConfig.modifiedItems.dmcModified.Yamato.enchantability);
					put("rarity", HAConfig.modifiedItems.dmcModified.Yamato.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dmcYamato = new HAWeapon("dmcYamato", dummyMaterial, properties);
					HEROIC_ITEMS.add(dmcYamato);
				}else {
					dmcYamato = new ItemKatanaHW("dmcYamato", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(dmcYamato, HeroicArmory.MOD_ID, "dmcYamato");
				}
				ALL_ITEMS.add(dmcYamato);
			}
		}
		//pkmn
		if (HAConfig.includeSeries.pkmn) {
			if (HAConfig.modifiedItems.pkmnModified.HonedgeShiny.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.pkmnModified.HonedgeShiny.damage);
					put("durability", HAConfig.modifiedItems.pkmnModified.HonedgeShiny.durability);
					put("speed", HAConfig.modifiedItems.pkmnModified.HonedgeShiny.speed);
					put("enchantability", HAConfig.modifiedItems.pkmnModified.HonedgeShiny.enchantability);
					put("rarity", HAConfig.modifiedItems.pkmnModified.HonedgeShiny.rarity);
				}};
				pkmnHonedgeShiny = new HAWeapon("pkmnHonedgeShiny", dummyMaterial, properties);
				HEROIC_ITEMS.add(pkmnHonedgeShiny);
				ALL_ITEMS.add(pkmnHonedgeShiny);
			}
			if (HAConfig.modifiedItems.pkmnModified.Honedge.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.pkmnModified.Honedge.damage);
					put("durability", HAConfig.modifiedItems.pkmnModified.Honedge.durability);
					put("speed", HAConfig.modifiedItems.pkmnModified.Honedge.speed);
					put("enchantability", HAConfig.modifiedItems.pkmnModified.Honedge.enchantability);
					put("rarity", HAConfig.modifiedItems.pkmnModified.Honedge.rarity);
				}};
				pkmnHonedge = new HAWeapon("pkmnHonedge", dummyMaterial, properties);
				HEROIC_ITEMS.add(pkmnHonedge);
				ALL_ITEMS.add(pkmnHonedge);
			}
		}
		//kirby
		if (HAConfig.includeSeries.kirby) {
			if (HAConfig.modifiedItems.kirbyModified.Galaxia.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.kirbyModified.Galaxia.damage);
					put("durability", HAConfig.modifiedItems.kirbyModified.Galaxia.durability);
					put("speed", HAConfig.modifiedItems.kirbyModified.Galaxia.speed);
					put("enchantability", HAConfig.modifiedItems.kirbyModified.Galaxia.enchantability);
					put("rarity", HAConfig.modifiedItems.kirbyModified.Galaxia.rarity);
				}};
				kirbyGalaxia = new HAWeapon("kirbyGalaxia", dummyMaterial, properties);
				HEROIC_ITEMS.add(kirbyGalaxia);
				ALL_ITEMS.add(kirbyGalaxia);
			}
			if (HAConfig.modifiedItems.kirbyModified.KirbyUltraSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.kirbyModified.KirbyUltraSword.damage);
					put("durability", HAConfig.modifiedItems.kirbyModified.KirbyUltraSword.durability);
					put("speed", HAConfig.modifiedItems.kirbyModified.KirbyUltraSword.speed);
					put("enchantability", HAConfig.modifiedItems.kirbyModified.KirbyUltraSword.enchantability);
					put("rarity", HAConfig.modifiedItems.kirbyModified.KirbyUltraSword.rarity);
				}};
				kirbyKirbyUltraSword = new HAWeapon("kirbyKirbyUltraSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(kirbyKirbyUltraSword);
				ALL_ITEMS.add(kirbyKirbyUltraSword);
			}
			if (HAConfig.modifiedItems.kirbyModified.KirbySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.kirbyModified.KirbySword.damage);
					put("durability", HAConfig.modifiedItems.kirbyModified.KirbySword.durability);
					put("speed", HAConfig.modifiedItems.kirbyModified.KirbySword.speed);
					put("enchantability", HAConfig.modifiedItems.kirbyModified.KirbySword.enchantability);
					put("rarity", HAConfig.modifiedItems.kirbyModified.KirbySword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					kirbyKirbySword = new HAWeapon("kirbyKirbySword", dummyMaterial, properties);
					HEROIC_ITEMS.add(kirbyKirbySword);
				}else {
					kirbyKirbySword = new ItemDaggerHW("kirbyKirbySword", dummyMaterialEx, properties, WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_BACKSTAB);
					SpartanWeaponryAPI.addItemModelToRegistry(kirbyKirbySword, HeroicArmory.MOD_ID, "kirbyKirbySword");
				}
				ALL_ITEMS.add(kirbyKirbySword);
			}
		}
		//fe
		if (HAConfig.includeSeries.fe) {
			if (HAConfig.modifiedItems.feModified.ChromFalchion.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.feModified.ChromFalchion.damage);
					put("durability", HAConfig.modifiedItems.feModified.ChromFalchion.durability);
					put("speed", HAConfig.modifiedItems.feModified.ChromFalchion.speed);
					put("enchantability", HAConfig.modifiedItems.feModified.ChromFalchion.enchantability);
					put("rarity", HAConfig.modifiedItems.feModified.ChromFalchion.rarity);
				}};
				if (!SupportSpartanWeaponry){
					feChromFalchion = new HAWeapon("feChromFalchion", dummyMaterial, properties);
					HEROIC_ITEMS.add(feChromFalchion);
				}else {
					feChromFalchion = new ItemLongswordHW("feChromFalchion", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(feChromFalchion, HeroicArmory.MOD_ID, "feChromFalchion");
				}
				ALL_ITEMS.add(feChromFalchion);
			}
			if (HAConfig.modifiedItems.feModified.Falchion.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.feModified.Falchion.damage);
					put("durability", HAConfig.modifiedItems.feModified.Falchion.durability);
					put("speed", HAConfig.modifiedItems.feModified.Falchion.speed);
					put("enchantability", HAConfig.modifiedItems.feModified.Falchion.enchantability);
					put("rarity", HAConfig.modifiedItems.feModified.Falchion.rarity);
				}};
				if (!SupportSpartanWeaponry){
					feFalchion = new HAWeapon("feFalchion", dummyMaterial, properties);
					HEROIC_ITEMS.add(feFalchion);
				}else {
					feFalchion = new ItemLongswordHW("feFalchion", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(feFalchion, HeroicArmory.MOD_ID, "feFalchion");
				}
				ALL_ITEMS.add(feFalchion);
			}
		}
		//kh
		if (HAConfig.includeSeries.kh) {
			if (HAConfig.modifiedItems.khModified.Keyblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.khModified.Keyblade.damage);
					put("durability", HAConfig.modifiedItems.khModified.Keyblade.durability);
					put("speed", HAConfig.modifiedItems.khModified.Keyblade.speed);
					put("enchantability", HAConfig.modifiedItems.khModified.Keyblade.enchantability);
					put("rarity", HAConfig.modifiedItems.khModified.Keyblade.rarity);
				}};
				if (!SupportSpartanWeaponry){
					khKeyblade = new HAWeapon("khKeyblade", dummyMaterial, properties);
					HEROIC_ITEMS.add(khKeyblade);
				}else {
					khKeyblade = new ItemCustomKeybladeHW("khKeyblade", dummyMaterialEx, properties, WeaponProperties.BLOCK_MELEE, WeaponProperties.THROWABLE, WeaponProperties.SWEEP_DAMAGE_HALF, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), WeaponProperties.QUICK_STRIKE);
					SpartanWeaponryAPI.addItemModelToRegistry(khKeyblade, HeroicArmory.MOD_ID, "khKeyblade");
				}
				ALL_ITEMS.add(khKeyblade);
			}
		}
		//bleach
		if (HAConfig.includeSeries.bleach) {
			if (HAConfig.modifiedItems.bleachModified.Zabimaru.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bleachModified.Zabimaru.damage);
					put("durability", HAConfig.modifiedItems.bleachModified.Zabimaru.durability);
					put("speed", HAConfig.modifiedItems.bleachModified.Zabimaru.speed);
					put("enchantability", HAConfig.modifiedItems.bleachModified.Zabimaru.enchantability);
					put("rarity", HAConfig.modifiedItems.bleachModified.Zabimaru.rarity);
				}};
				if (!SupportSpartanWeaponry){
					bleachZabimaru = new HAWeapon("bleachZabimaru", dummyMaterial, properties);
					HEROIC_ITEMS.add(bleachZabimaru);
				}else {
					bleachZabimaru = new ItemGreatswordHW("bleachZabimaru", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(bleachZabimaru, HeroicArmory.MOD_ID, "bleachZabimaru");
				}
				ALL_ITEMS.add(bleachZabimaru);
			}
			if (HAConfig.modifiedItems.bleachModified.Zangetsu.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bleachModified.Zangetsu.damage);
					put("durability", HAConfig.modifiedItems.bleachModified.Zangetsu.durability);
					put("speed", HAConfig.modifiedItems.bleachModified.Zangetsu.speed);
					put("enchantability", HAConfig.modifiedItems.bleachModified.Zangetsu.enchantability);
					put("rarity", HAConfig.modifiedItems.bleachModified.Zangetsu.rarity);
				}};
				if (!SupportSpartanWeaponry){
					bleachZangetsu = new HAWeapon("bleachZangetsu", dummyMaterial, properties);
					HEROIC_ITEMS.add(bleachZangetsu);
				}else {
					bleachZangetsu = new ItemGreatswordHW("bleachZangetsu", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(bleachZangetsu, HeroicArmory.MOD_ID, "bleachZangetsu");
				}
				ALL_ITEMS.add(bleachZangetsu);
			}
		}
		//ds
		if (HAConfig.includeSeries.ds) {
			if (HAConfig.modifiedItems.dsModified.GreatswordofArtorias.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsModified.GreatswordofArtorias.damage);
					put("durability", HAConfig.modifiedItems.dsModified.GreatswordofArtorias.durability);
					put("speed", HAConfig.modifiedItems.dsModified.GreatswordofArtorias.speed);
					put("enchantability", HAConfig.modifiedItems.dsModified.GreatswordofArtorias.enchantability);
					put("rarity", HAConfig.modifiedItems.dsModified.GreatswordofArtorias.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dsGreatswordofArtorias = new HAWeapon("dsGreatswordofArtorias", dummyMaterial, properties);
					HEROIC_ITEMS.add(dsGreatswordofArtorias);
				}else {
					dsGreatswordofArtorias = new ItemGreatswordHW("dsGreatswordofArtorias", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(dsGreatswordofArtorias, HeroicArmory.MOD_ID, "dsGreatswordofArtorias");
				}
				ALL_ITEMS.add(dsGreatswordofArtorias);
			}
			if (HAConfig.modifiedItems.dsModified.GreatLordGreatsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsModified.GreatLordGreatsword.damage);
					put("durability", HAConfig.modifiedItems.dsModified.GreatLordGreatsword.durability);
					put("speed", HAConfig.modifiedItems.dsModified.GreatLordGreatsword.speed);
					put("enchantability", HAConfig.modifiedItems.dsModified.GreatLordGreatsword.enchantability);
					put("rarity", HAConfig.modifiedItems.dsModified.GreatLordGreatsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dsGreatLordGreatsword = new HAWeapon("dsGreatLordGreatsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(dsGreatLordGreatsword);
				}else {
					dsGreatLordGreatsword = new ItemGreatswordHW("dsGreatLordGreatsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(dsGreatLordGreatsword, HeroicArmory.MOD_ID, "dsGreatLordGreatsword");
				}
				ALL_ITEMS.add(dsGreatLordGreatsword);
			}
			if (HAConfig.modifiedItems.dsModified.AstoraGreatsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsModified.AstoraGreatsword.damage);
					put("durability", HAConfig.modifiedItems.dsModified.AstoraGreatsword.durability);
					put("speed", HAConfig.modifiedItems.dsModified.AstoraGreatsword.speed);
					put("enchantability", HAConfig.modifiedItems.dsModified.AstoraGreatsword.enchantability);
					put("rarity", HAConfig.modifiedItems.dsModified.AstoraGreatsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dsAstoraGreatsword = new HAWeapon("dsAstoraGreatsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(dsAstoraGreatsword);
				}else {
					dsAstoraGreatsword = new ItemGreatswordHW("dsAstoraGreatsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(dsAstoraGreatsword, HeroicArmory.MOD_ID, "dsAstoraGreatsword");
				}
				ALL_ITEMS.add(dsAstoraGreatsword);
			}
			if (HAConfig.modifiedItems.dsModified.Zweihander.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsModified.Zweihander.damage);
					put("durability", HAConfig.modifiedItems.dsModified.Zweihander.durability);
					put("speed", HAConfig.modifiedItems.dsModified.Zweihander.speed);
					put("enchantability", HAConfig.modifiedItems.dsModified.Zweihander.enchantability);
					put("rarity", HAConfig.modifiedItems.dsModified.Zweihander.rarity);
				}};
				if (!SupportSpartanWeaponry){
					dsZweihander = new HAWeapon("dsZweihander", dummyMaterial, properties);
					HEROIC_ITEMS.add(dsZweihander);
				}else {
					dsZweihander = new ItemGreatswordHW("dsZweihander", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(dsZweihander, HeroicArmory.MOD_ID, "dsZweihander");
				}
				ALL_ITEMS.add(dsZweihander);
			}
		}
		//myth
		if (HAConfig.includeSeries.myth) {
			if (HAConfig.modifiedItems.mythModified.DeathScythe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mythModified.DeathScythe.damage);
					put("durability", HAConfig.modifiedItems.mythModified.DeathScythe.durability);
					put("speed", HAConfig.modifiedItems.mythModified.DeathScythe.speed);
					put("enchantability", HAConfig.modifiedItems.mythModified.DeathScythe.enchantability);
					put("rarity", HAConfig.modifiedItems.mythModified.DeathScythe.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mythDeathScythe = new HAWeapon("mythDeathScythe", dummyMaterial, properties);
					HEROIC_ITEMS.add(mythDeathScythe);
				}else {
					mythDeathScythe = new ItemHalberdHW("mythDeathScythe", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SHIELD_BREACH);
					SpartanWeaponryAPI.addItemModelToRegistry(mythDeathScythe, HeroicArmory.MOD_ID, "mythDeathScythe");
				}
				ALL_ITEMS.add(mythDeathScythe);
			}
			if (HAConfig.modifiedItems.mythModified.TheDevilPitchfork.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mythModified.TheDevilPitchfork.damage);
					put("durability", HAConfig.modifiedItems.mythModified.TheDevilPitchfork.durability);
					put("speed", HAConfig.modifiedItems.mythModified.TheDevilPitchfork.speed);
					put("enchantability", HAConfig.modifiedItems.mythModified.TheDevilPitchfork.enchantability);
					put("rarity", HAConfig.modifiedItems.mythModified.TheDevilPitchfork.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mythTheDevilPitchfork = new HAWeapon("mythTheDevilPitchfork", dummyMaterial, properties);
					HEROIC_ITEMS.add(mythTheDevilPitchfork);
				}else {
					mythTheDevilPitchfork = new ItemSpearHW("mythTheDevilPitchfork", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(mythTheDevilPitchfork, HeroicArmory.MOD_ID, "mythTheDevilPitchfork");
				}
				ALL_ITEMS.add(mythTheDevilPitchfork);
			}
		}
		//bayonetta
		if (HAConfig.includeSeries.bayonetta) {
			if (HAConfig.modifiedItems.bayonettaModified.Shuraba.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bayonettaModified.Shuraba.damage);
					put("durability", HAConfig.modifiedItems.bayonettaModified.Shuraba.durability);
					put("speed", HAConfig.modifiedItems.bayonettaModified.Shuraba.speed);
					put("enchantability", HAConfig.modifiedItems.bayonettaModified.Shuraba.enchantability);
					put("rarity", HAConfig.modifiedItems.bayonettaModified.Shuraba.rarity);
				}};
				if (!SupportSpartanWeaponry){
					bayonettaShuraba = new HAWeapon("bayonettaShuraba", dummyMaterial, properties);
					HEROIC_ITEMS.add(bayonettaShuraba);
				}else {
					bayonettaShuraba = new ItemKatanaHW("bayonettaShuraba", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.EXTRA_DAMAGE_2_CHEST, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(bayonettaShuraba, HeroicArmory.MOD_ID, "bayonettaShuraba");
				}
				ALL_ITEMS.add(bayonettaShuraba);
			}
			if (HAConfig.modifiedItems.bayonettaModified.AngelSlayer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bayonettaModified.AngelSlayer.damage);
					put("durability", HAConfig.modifiedItems.bayonettaModified.AngelSlayer.durability);
					put("speed", HAConfig.modifiedItems.bayonettaModified.AngelSlayer.speed);
					put("enchantability", HAConfig.modifiedItems.bayonettaModified.AngelSlayer.enchantability);
					put("rarity", HAConfig.modifiedItems.bayonettaModified.AngelSlayer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					bayonettaAngelSlayer = new HAWeapon("bayonettaAngelSlayer", dummyMaterial, properties);
					HEROIC_ITEMS.add(bayonettaAngelSlayer);
				}else {
					bayonettaAngelSlayer = new ItemSaberHW("bayonettaAngelSlayer", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(bayonettaAngelSlayer, HeroicArmory.MOD_ID, "bayonettaAngelSlayer");
				}
				ALL_ITEMS.add(bayonettaAngelSlayer);
			}
		}
		//gow
		if (HAConfig.includeSeries.gow) {
			if (HAConfig.modifiedItems.gowModified.LeviathanUpgraded.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowModified.LeviathanUpgraded.damage);
					put("durability", HAConfig.modifiedItems.gowModified.LeviathanUpgraded.durability);
					put("speed", HAConfig.modifiedItems.gowModified.LeviathanUpgraded.speed);
					put("enchantability", HAConfig.modifiedItems.gowModified.LeviathanUpgraded.enchantability);
					put("rarity", HAConfig.modifiedItems.gowModified.LeviathanUpgraded.rarity);
				}};
				if (!SupportSpartanWeaponry){
					gowLeviathanUpgraded = new HAWeapon("gowLeviathanUpgraded", dummyMaterial, properties);
					HEROIC_ITEMS.add(gowLeviathanUpgraded);
				}else {
					gowLeviathanUpgraded = new ItemBattleaxeHW("gowLeviathanUpgraded", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE, WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_2_THROWN, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.SHIELD_BREACH, new WeaponPropertyFreeze(8));
					SpartanWeaponryAPI.addItemModelToRegistry(gowLeviathanUpgraded, HeroicArmory.MOD_ID, "gowLeviathanUpgraded");
				}
				ALL_ITEMS.add(gowLeviathanUpgraded);
			}
			if (HAConfig.modifiedItems.gowModified.Leviathan.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowModified.Leviathan.damage);
					put("durability", HAConfig.modifiedItems.gowModified.Leviathan.durability);
					put("speed", HAConfig.modifiedItems.gowModified.Leviathan.speed);
					put("enchantability", HAConfig.modifiedItems.gowModified.Leviathan.enchantability);
					put("rarity", HAConfig.modifiedItems.gowModified.Leviathan.rarity);
				}};
				if (!SupportSpartanWeaponry){
					gowLeviathan = new HAWeapon("gowLeviathan", dummyMaterial, properties);
					HEROIC_ITEMS.add(gowLeviathan);
				}else {
					gowLeviathan = new ItemBattleaxeHW("gowLeviathan", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.VERSATILE, WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_2_THROWN, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(gowLeviathan, HeroicArmory.MOD_ID, "gowLeviathan");
				}
				ALL_ITEMS.add(gowLeviathan);
			}
			if (HAConfig.modifiedItems.gowModified.BladeofOlympus.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowModified.BladeofOlympus.damage);
					put("durability", HAConfig.modifiedItems.gowModified.BladeofOlympus.durability);
					put("speed", HAConfig.modifiedItems.gowModified.BladeofOlympus.speed);
					put("enchantability", HAConfig.modifiedItems.gowModified.BladeofOlympus.enchantability);
					put("rarity", HAConfig.modifiedItems.gowModified.BladeofOlympus.rarity);
				}};
				if (!SupportSpartanWeaponry){
					gowBladeofOlympus = new HAWeapon("gowBladeofOlympus", dummyMaterial, properties);
					HEROIC_ITEMS.add(gowBladeofOlympus);
				}else {
					gowBladeofOlympus = new ItemGreatswordHW("gowBladeofOlympus", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(gowBladeofOlympus, HeroicArmory.MOD_ID, "gowBladeofOlympus");
				}
				ALL_ITEMS.add(gowBladeofOlympus);
			}
			if (HAConfig.modifiedItems.gowModified.BladeofChaos.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowModified.BladeofChaos.damage);
					put("durability", HAConfig.modifiedItems.gowModified.BladeofChaos.durability);
					put("speed", HAConfig.modifiedItems.gowModified.BladeofChaos.speed);
					put("enchantability", HAConfig.modifiedItems.gowModified.BladeofChaos.enchantability);
					put("rarity", HAConfig.modifiedItems.gowModified.BladeofChaos.rarity);
				}};
				if (!SupportSpartanWeaponry){
					gowBladeofChaos = new HAWeapon("gowBladeofChaos", dummyMaterial, properties);
					HEROIC_ITEMS.add(gowBladeofChaos);
				}else {
					gowBladeofChaos = new ItemCustomBoomerangHW("gowBladeofChaos", dummyMaterialEx, properties, 2, WeaponProperties.THROWABLE);
					SpartanWeaponryAPI.addItemModelToRegistry(gowBladeofChaos, HeroicArmory.MOD_ID, "gowBladeofChaos");
				}
				ALL_ITEMS.add(gowBladeofChaos);
			}
		}
		//skyrim
		if (HAConfig.includeSeries.skyrim) {
			if (HAConfig.modifiedItems.skyrimModified.IronSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.IronSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.IronSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.IronSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.IronSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.IronSword.rarity);
				}};
				skyrimIronSword = new HAWeapon("skyrimIronSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimIronSword);
				ALL_ITEMS.add(skyrimIronSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.IronWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.IronWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.IronWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.IronWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.IronWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.IronWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimIronWarhammer = new HAWeapon("skyrimIronWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimIronWarhammer);
				}else {
					skyrimIronWarhammer = new ItemWarhammerHW("skyrimIronWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimIronWarhammer, HeroicArmory.MOD_ID, "skyrimIronWarhammer");
				}
				ALL_ITEMS.add(skyrimIronWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.SteelSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.SteelSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.SteelSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.SteelSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.SteelSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.SteelSword.rarity);
				}};
				skyrimSteelSword = new HAWeapon("skyrimSteelSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimSteelSword);
				ALL_ITEMS.add(skyrimSteelSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.SteelWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.SteelWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.SteelWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.SteelWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.SteelWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.SteelWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimSteelWarhammer = new HAWeapon("skyrimSteelWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimSteelWarhammer);
				}else {
					skyrimSteelWarhammer = new ItemWarhammerHW("skyrimSteelWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimSteelWarhammer, HeroicArmory.MOD_ID, "skyrimSteelWarhammer");
				}
				ALL_ITEMS.add(skyrimSteelWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.OrcishSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.OrcishSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.OrcishSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.OrcishSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.OrcishSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.OrcishSword.rarity);
				}};
				skyrimOrcishSword = new HAWeapon("skyrimOrcishSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimOrcishSword);
				ALL_ITEMS.add(skyrimOrcishSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.OrcishWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.OrcishWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.OrcishWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.OrcishWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.OrcishWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.OrcishWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimOrcishWarhammer = new HAWeapon("skyrimOrcishWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimOrcishWarhammer);
				}else {
					skyrimOrcishWarhammer = new ItemWarhammerHW("skyrimOrcishWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimOrcishWarhammer, HeroicArmory.MOD_ID, "skyrimOrcishWarhammer");
				}
				ALL_ITEMS.add(skyrimOrcishWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.DwarvenSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.DwarvenSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.DwarvenSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.DwarvenSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.DwarvenSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.DwarvenSword.rarity);
				}};
				skyrimDwarvenSword = new HAWeapon("skyrimDwarvenSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimDwarvenSword);
				ALL_ITEMS.add(skyrimDwarvenSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.DwarvenWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.DwarvenWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.DwarvenWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.DwarvenWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.DwarvenWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.DwarvenWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimDwarvenWarhammer = new HAWeapon("skyrimDwarvenWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimDwarvenWarhammer);
				}else {
					skyrimDwarvenWarhammer = new ItemWarhammerHW("skyrimDwarvenWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimDwarvenWarhammer, HeroicArmory.MOD_ID, "skyrimDwarvenWarhammer");
				}
				ALL_ITEMS.add(skyrimDwarvenWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.ElvenSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.ElvenSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.ElvenSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.ElvenSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.ElvenSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.ElvenSword.rarity);
				}};
				skyrimElvenSword = new HAWeapon("skyrimElvenSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimElvenSword);
				ALL_ITEMS.add(skyrimElvenSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.ElvenWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.ElvenWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.ElvenWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.ElvenWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.ElvenWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.ElvenWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimElvenWarhammer = new HAWeapon("skyrimElvenWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimElvenWarhammer);
				}else {
					skyrimElvenWarhammer = new ItemWarhammerHW("skyrimElvenWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimElvenWarhammer, HeroicArmory.MOD_ID, "skyrimElvenWarhammer");
				}
				ALL_ITEMS.add(skyrimElvenWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.GlassSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.GlassSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.GlassSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.GlassSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.GlassSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.GlassSword.rarity);
				}};
				skyrimGlassSword = new HAWeapon("skyrimGlassSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimGlassSword);
				ALL_ITEMS.add(skyrimGlassSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.GlassWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.GlassWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.GlassWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.GlassWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.GlassWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.GlassWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimGlassWarhammer = new HAWeapon("skyrimGlassWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimGlassWarhammer);
				}else {
					skyrimGlassWarhammer = new ItemWarhammerHW("skyrimGlassWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimGlassWarhammer, HeroicArmory.MOD_ID, "skyrimGlassWarhammer");
				}
				ALL_ITEMS.add(skyrimGlassWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.EbonySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.EbonySword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.EbonySword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.EbonySword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.EbonySword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.EbonySword.rarity);
				}};
				skyrimEbonySword = new HAWeapon("skyrimEbonySword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimEbonySword);
				ALL_ITEMS.add(skyrimEbonySword);
			}
			if (HAConfig.modifiedItems.skyrimModified.EbonyWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.EbonyWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.EbonyWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.EbonyWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.EbonyWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.EbonyWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimEbonyWarhammer = new HAWeapon("skyrimEbonyWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimEbonyWarhammer);
				}else {
					skyrimEbonyWarhammer = new ItemWarhammerHW("skyrimEbonyWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimEbonyWarhammer, HeroicArmory.MOD_ID, "skyrimEbonyWarhammer");
				}
				ALL_ITEMS.add(skyrimEbonyWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.DaedricSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.DaedricSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.DaedricSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.DaedricSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.DaedricSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.DaedricSword.rarity);
				}};
				skyrimDaedricSword = new HAWeapon("skyrimDaedricSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimDaedricSword);
				ALL_ITEMS.add(skyrimDaedricSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.DaedricWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.DaedricWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.DaedricWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.DaedricWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.DaedricWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.DaedricWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimDaedricWarhammer = new HAWeapon("skyrimDaedricWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimDaedricWarhammer);
				}else {
					skyrimDaedricWarhammer = new ItemWarhammerHW("skyrimDaedricWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimDaedricWarhammer, HeroicArmory.MOD_ID, "skyrimDaedricWarhammer");
				}
				ALL_ITEMS.add(skyrimDaedricWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.DragonboneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.DragonboneSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.DragonboneSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.DragonboneSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.DragonboneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.DragonboneSword.rarity);
				}};
				skyrimDragonboneSword = new HAWeapon("skyrimDragonboneSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimDragonboneSword);
				ALL_ITEMS.add(skyrimDragonboneSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.DragonboneWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.DragonboneWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.DragonboneWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.DragonboneWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.DragonboneWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.DragonboneWarhammer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimDragonboneWarhammer = new HAWeapon("skyrimDragonboneWarhammer", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimDragonboneWarhammer);
				}else {
					skyrimDragonboneWarhammer = new ItemWarhammerHW("skyrimDragonboneWarhammer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.ARMOUR_PIERCING_50);
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimDragonboneWarhammer, HeroicArmory.MOD_ID, "skyrimDragonboneWarhammer");
				}
				ALL_ITEMS.add(skyrimDragonboneWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimModified.ImperialSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.ImperialSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.ImperialSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.ImperialSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.ImperialSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.ImperialSword.rarity);
				}};
				skyrimImperialSword = new HAWeapon("skyrimImperialSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimImperialSword);
				ALL_ITEMS.add(skyrimImperialSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.Dawnbreaker.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.Dawnbreaker.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.Dawnbreaker.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.Dawnbreaker.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.Dawnbreaker.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.Dawnbreaker.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimDawnbreaker = new HAWeapon("skyrimDawnbreaker", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimDawnbreaker);
				}else {
					skyrimDawnbreaker = new ItemLongswordHW("skyrimDawnbreaker", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 2.00F), new WeaponPropertyDetonateDead());
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimDawnbreaker, HeroicArmory.MOD_ID, "skyrimDawnbreaker");
				}
				ALL_ITEMS.add(skyrimDawnbreaker);
			}
			if (HAConfig.modifiedItems.skyrimModified.AncientNordSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.AncientNordSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.AncientNordSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.AncientNordSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.AncientNordSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.AncientNordSword.rarity);
				}};
				skyrimAncientNordSword = new HAWeapon("skyrimAncientNordSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(skyrimAncientNordSword);
				ALL_ITEMS.add(skyrimAncientNordSword);
			}
			if (HAConfig.modifiedItems.skyrimModified.Chillrend.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.Chillrend.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.Chillrend.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.Chillrend.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.Chillrend.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.Chillrend.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimChillrend = new HAWeapon("skyrimChillrend", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimChillrend);
				}else {
					skyrimChillrend = new ItemLongswordHW("skyrimChillrend", dummyMaterialEx, properties, new WeaponPropertyFreeze(4));
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimChillrend, HeroicArmory.MOD_ID, "skyrimChillrend");
				}
				ALL_ITEMS.add(skyrimChillrend);
			}
			if (HAConfig.modifiedItems.skyrimModified.EbonyBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimModified.EbonyBlade.damage);
					put("durability", HAConfig.modifiedItems.skyrimModified.EbonyBlade.durability);
					put("speed", HAConfig.modifiedItems.skyrimModified.EbonyBlade.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimModified.EbonyBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimModified.EbonyBlade.rarity);
				}};
				if (!SupportSpartanWeaponry){
					skyrimEbonyBlade = new HAWeapon("skyrimEbonyBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(skyrimEbonyBlade);
				}else {
					skyrimEbonyBlade = new ItemLongswordHW("skyrimEbonyBlade", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.EXTRA_DAMAGE_2_CHEST, new WeaponPropertyLifeFlat(2));
					SpartanWeaponryAPI.addItemModelToRegistry(skyrimEbonyBlade, HeroicArmory.MOD_ID, "skyrimEbonyBlade");
				}
				ALL_ITEMS.add(skyrimEbonyBlade);
			}
		}
		//mh
		if (HAConfig.includeSeries.mh) {
			if (HAConfig.modifiedItems.mhModified.ChickenDecapitator.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.ChickenDecapitator.damage);
					put("durability", HAConfig.modifiedItems.mhModified.ChickenDecapitator.durability);
					put("speed", HAConfig.modifiedItems.mhModified.ChickenDecapitator.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.ChickenDecapitator.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.ChickenDecapitator.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhChickenDecapitator = new HAWeapon("mhChickenDecapitator", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhChickenDecapitator);
				}else {
					mhChickenDecapitator = new ItemGreatswordHW("mhChickenDecapitator", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyIgnite(4));
					SpartanWeaponryAPI.addItemModelToRegistry(mhChickenDecapitator, HeroicArmory.MOD_ID, "mhChickenDecapitator");
				}
				ALL_ITEMS.add(mhChickenDecapitator);
			}
			if (HAConfig.modifiedItems.mhModified.GolemBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.GolemBlade.damage);
					put("durability", HAConfig.modifiedItems.mhModified.GolemBlade.durability);
					put("speed", HAConfig.modifiedItems.mhModified.GolemBlade.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.GolemBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.GolemBlade.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhGolemBlade = new HAWeapon("mhGolemBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhGolemBlade);
				}else {
					mhGolemBlade = new ItemGreatswordHW("mhGolemBlade", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(mhGolemBlade, HeroicArmory.MOD_ID, "mhGolemBlade");
				}
				ALL_ITEMS.add(mhGolemBlade);
			}
			if (HAConfig.modifiedItems.mhModified.Defender.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.Defender.damage);
					put("durability", HAConfig.modifiedItems.mhModified.Defender.durability);
					put("speed", HAConfig.modifiedItems.mhModified.Defender.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.Defender.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.Defender.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhDefender = new HAWeapon("mhDefender", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhDefender);
				}else {
					mhDefender = new ItemParryingDaggerHW("mhDefender", dummyMaterialEx, properties, WeaponProperties.BLOCK_MELEE, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_HALF);
					SpartanWeaponryAPI.addItemModelToRegistry(mhDefender, HeroicArmory.MOD_ID, "mhDefender");
				}
				ALL_ITEMS.add(mhDefender);
			}
			if (HAConfig.modifiedItems.mhModified.BlackBeltBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.BlackBeltBlade.damage);
					put("durability", HAConfig.modifiedItems.mhModified.BlackBeltBlade.durability);
					put("speed", HAConfig.modifiedItems.mhModified.BlackBeltBlade.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.BlackBeltBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.BlackBeltBlade.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhBlackBeltBlade = new HAWeapon("mhBlackBeltBlade", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhBlackBeltBlade);
				}else {
					mhBlackBeltBlade = new ItemGreatswordHW("mhBlackBeltBlade", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(mhBlackBeltBlade, HeroicArmory.MOD_ID, "mhBlackBeltBlade");
				}
				ALL_ITEMS.add(mhBlackBeltBlade);
			}
			if (HAConfig.modifiedItems.mhModified.WailingCleaver.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.WailingCleaver.damage);
					put("durability", HAConfig.modifiedItems.mhModified.WailingCleaver.durability);
					put("speed", HAConfig.modifiedItems.mhModified.WailingCleaver.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.WailingCleaver.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.WailingCleaver.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhWailingCleaver = new HAWeapon("mhWailingCleaver", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhWailingCleaver);
				}else {
					mhWailingCleaver = new ItemLongswordHW("mhWailingCleaver", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(mhWailingCleaver, HeroicArmory.MOD_ID, "mhWailingCleaver");
				}
				ALL_ITEMS.add(mhWailingCleaver);
			}
			if (HAConfig.modifiedItems.mhModified.GaelicFlame.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.GaelicFlame.damage);
					put("durability", HAConfig.modifiedItems.mhModified.GaelicFlame.durability);
					put("speed", HAConfig.modifiedItems.mhModified.GaelicFlame.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.GaelicFlame.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.GaelicFlame.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhGaelicFlame = new HAWeapon("mhGaelicFlame", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhGaelicFlame);
				}else {
					mhGaelicFlame = new ItemLongswordHW("mhGaelicFlame", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(mhGaelicFlame, HeroicArmory.MOD_ID, "mhGaelicFlame");
				}
				ALL_ITEMS.add(mhGaelicFlame);
			}
			if (HAConfig.modifiedItems.mhModified.BoneKatana.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.BoneKatana.damage);
					put("durability", HAConfig.modifiedItems.mhModified.BoneKatana.durability);
					put("speed", HAConfig.modifiedItems.mhModified.BoneKatana.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.BoneKatana.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.BoneKatana.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhBoneKatana = new HAWeapon("mhBoneKatana", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhBoneKatana);
				}else {
					mhBoneKatana = new ItemLongswordHW("mhBoneKatana", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(mhBoneKatana, HeroicArmory.MOD_ID, "mhBoneKatana");
				}
				ALL_ITEMS.add(mhBoneKatana);
			}
			if (HAConfig.modifiedItems.mhModified.HellishSlasher.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.HellishSlasher.damage);
					put("durability", HAConfig.modifiedItems.mhModified.HellishSlasher.durability);
					put("speed", HAConfig.modifiedItems.mhModified.HellishSlasher.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.HellishSlasher.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.HellishSlasher.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhHellishSlasher = new HAWeapon("mhHellishSlasher", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhHellishSlasher);
				}else {
					mhHellishSlasher = new ItemLongswordHW("mhHellishSlasher", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, new WeaponPropertyBonusDragon());
					SpartanWeaponryAPI.addItemModelToRegistry(mhHellishSlasher, HeroicArmory.MOD_ID, "mhHellishSlasher");
				}
				ALL_ITEMS.add(mhHellishSlasher);
			}
			if (HAConfig.modifiedItems.mhModified.CentenarianDagger.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.CentenarianDagger.damage);
					put("durability", HAConfig.modifiedItems.mhModified.CentenarianDagger.durability);
					put("speed", HAConfig.modifiedItems.mhModified.CentenarianDagger.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.CentenarianDagger.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.CentenarianDagger.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhCentenarianDagger = new HAWeapon("mhCentenarianDagger", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhCentenarianDagger);
				}else {
					mhCentenarianDagger = new ItemLongswordHW("mhCentenarianDagger", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(mhCentenarianDagger, HeroicArmory.MOD_ID, "mhCentenarianDagger");
				}
				ALL_ITEMS.add(mhCentenarianDagger);
			}
			if (HAConfig.modifiedItems.mhModified.WyvernBladeLeaf.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.WyvernBladeLeaf.damage);
					put("durability", HAConfig.modifiedItems.mhModified.WyvernBladeLeaf.durability);
					put("speed", HAConfig.modifiedItems.mhModified.WyvernBladeLeaf.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.WyvernBladeLeaf.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.WyvernBladeLeaf.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhWyvernBladeLeaf = new HAWeapon("mhWyvernBladeLeaf", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhWyvernBladeLeaf);
				}else {
					mhWyvernBladeLeaf = new ItemLongswordHW("mhWyvernBladeLeaf", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyPotion(MobEffects.POISON.getName(), MobEffects.POISON, 3, 0));
					SpartanWeaponryAPI.addItemModelToRegistry(mhWyvernBladeLeaf, HeroicArmory.MOD_ID, "mhWyvernBladeLeaf");
				}
				ALL_ITEMS.add(mhWyvernBladeLeaf);
			}
			if (HAConfig.modifiedItems.mhModified.WyvernBladeHolly.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.WyvernBladeHolly.damage);
					put("durability", HAConfig.modifiedItems.mhModified.WyvernBladeHolly.durability);
					put("speed", HAConfig.modifiedItems.mhModified.WyvernBladeHolly.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.WyvernBladeHolly.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.WyvernBladeHolly.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhWyvernBladeHolly = new HAWeapon("mhWyvernBladeHolly", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhWyvernBladeHolly);
				}else {
					mhWyvernBladeHolly = new ItemLongswordHW("mhWyvernBladeHolly", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyPotion(MobEffects.POISON.getName(), MobEffects.POISON, 8, 3));
					SpartanWeaponryAPI.addItemModelToRegistry(mhWyvernBladeHolly, HeroicArmory.MOD_ID, "mhWyvernBladeHolly");
				}
				ALL_ITEMS.add(mhWyvernBladeHolly);
			}
			if (HAConfig.modifiedItems.mhModified.WyvernBladeBlood.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.WyvernBladeBlood.damage);
					put("durability", HAConfig.modifiedItems.mhModified.WyvernBladeBlood.durability);
					put("speed", HAConfig.modifiedItems.mhModified.WyvernBladeBlood.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.WyvernBladeBlood.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.WyvernBladeBlood.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhWyvernBladeBlood = new HAWeapon("mhWyvernBladeBlood", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhWyvernBladeBlood);
				}else {
					mhWyvernBladeBlood = new ItemLongswordHW("mhWyvernBladeBlood", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyIgnite(6));
					SpartanWeaponryAPI.addItemModelToRegistry(mhWyvernBladeBlood, HeroicArmory.MOD_ID, "mhWyvernBladeBlood");
				}
				ALL_ITEMS.add(mhWyvernBladeBlood);
			}
			if (HAConfig.modifiedItems.mhModified.WyvernBladeAzure.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.WyvernBladeAzure.damage);
					put("durability", HAConfig.modifiedItems.mhModified.WyvernBladeAzure.durability);
					put("speed", HAConfig.modifiedItems.mhModified.WyvernBladeAzure.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.WyvernBladeAzure.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.WyvernBladeAzure.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhWyvernBladeAzure = new HAWeapon("mhWyvernBladeAzure", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhWyvernBladeAzure);
				}else {
					mhWyvernBladeAzure = new ItemLongswordHW("mhWyvernBladeAzure", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyIgnite(8));
					SpartanWeaponryAPI.addItemModelToRegistry(mhWyvernBladeAzure, HeroicArmory.MOD_ID, "mhWyvernBladeAzure");
				}
				ALL_ITEMS.add(mhWyvernBladeAzure);
			}
			if (HAConfig.modifiedItems.mhModified.WyvernBladePale.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.WyvernBladePale.damage);
					put("durability", HAConfig.modifiedItems.mhModified.WyvernBladePale.durability);
					put("speed", HAConfig.modifiedItems.mhModified.WyvernBladePale.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.WyvernBladePale.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.WyvernBladePale.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhWyvernBladePale = new HAWeapon("mhWyvernBladePale", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhWyvernBladePale);
				}else {
					mhWyvernBladePale = new ItemLongswordHW("mhWyvernBladePale", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.REACH_2, WeaponProperties.SWEEP_DAMAGE_FULL, WeaponProperties.ARMOUR_PIERCING_50, new WeaponPropertyIgnite(10));
					SpartanWeaponryAPI.addItemModelToRegistry(mhWyvernBladePale, HeroicArmory.MOD_ID, "mhWyvernBladePale");
				}
				ALL_ITEMS.add(mhWyvernBladePale);
			}
			if (HAConfig.modifiedItems.mhModified.RathalosFlamesword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhModified.RathalosFlamesword.damage);
					put("durability", HAConfig.modifiedItems.mhModified.RathalosFlamesword.durability);
					put("speed", HAConfig.modifiedItems.mhModified.RathalosFlamesword.speed);
					put("enchantability", HAConfig.modifiedItems.mhModified.RathalosFlamesword.enchantability);
					put("rarity", HAConfig.modifiedItems.mhModified.RathalosFlamesword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					mhRathalosFlamesword = new HAWeapon("mhRathalosFlamesword", dummyMaterial, properties);
					HEROIC_ITEMS.add(mhRathalosFlamesword);
				}else {
					mhRathalosFlamesword = new ItemGreatswordHW("mhRathalosFlamesword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyIgnite(14));
					SpartanWeaponryAPI.addItemModelToRegistry(mhRathalosFlamesword, HeroicArmory.MOD_ID, "mhRathalosFlamesword");
				}
				ALL_ITEMS.add(mhRathalosFlamesword);
			}
		}
		//terraria
		if (HAConfig.includeSeries.terraria) {
			if (HAConfig.modifiedItems.terrariaModified.PalmWoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.PalmWoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.PalmWoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.PalmWoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.PalmWoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.PalmWoodSword.rarity);
				}};
				terrariaPalmWoodSword = new HAWeapon("terrariaPalmWoodSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaPalmWoodSword);
				ALL_ITEMS.add(terrariaPalmWoodSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.BorealWoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.BorealWoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.BorealWoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.BorealWoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.BorealWoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.BorealWoodSword.rarity);
				}};
				terrariaBorealWoodSword = new HAWeapon("terrariaBorealWoodSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaBorealWoodSword);
				ALL_ITEMS.add(terrariaBorealWoodSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.ShadewoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.ShadewoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.ShadewoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.ShadewoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.ShadewoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.ShadewoodSword.rarity);
				}};
				terrariaShadewoodSword = new HAWeapon("terrariaShadewoodSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaShadewoodSword);
				ALL_ITEMS.add(terrariaShadewoodSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.EbonwoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.EbonwoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.EbonwoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.EbonwoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.EbonwoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.EbonwoodSword.rarity);
				}};
				terrariaEbonwoodSword = new HAWeapon("terrariaEbonwoodSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaEbonwoodSword);
				ALL_ITEMS.add(terrariaEbonwoodSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.CopperShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.CopperShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.CopperShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.CopperShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.CopperShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.CopperShortsword.rarity);
				}};
				terrariaCopperShortsword = new HAWeapon("terrariaCopperShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaCopperShortsword);
				ALL_ITEMS.add(terrariaCopperShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.CopperBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.CopperBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.CopperBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.CopperBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.CopperBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.CopperBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaCopperBroadsword = new HAWeapon("terrariaCopperBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaCopperBroadsword);
				}else {
					terrariaCopperBroadsword = new ItemGreatswordHW("terrariaCopperBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaCopperBroadsword, HeroicArmory.MOD_ID, "terrariaCopperBroadsword");
				}
				ALL_ITEMS.add(terrariaCopperBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.TinShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.TinShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.TinShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.TinShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.TinShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.TinShortsword.rarity);
				}};
				terrariaTinShortsword = new HAWeapon("terrariaTinShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaTinShortsword);
				ALL_ITEMS.add(terrariaTinShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.TinBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.TinBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.TinBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.TinBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.TinBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.TinBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaTinBroadsword = new HAWeapon("terrariaTinBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaTinBroadsword);
				}else {
					terrariaTinBroadsword = new ItemGreatswordHW("terrariaTinBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaTinBroadsword, HeroicArmory.MOD_ID, "terrariaTinBroadsword");
				}
				ALL_ITEMS.add(terrariaTinBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.LeadShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.LeadShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.LeadShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.LeadShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.LeadShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.LeadShortsword.rarity);
				}};
				terrariaLeadShortsword = new HAWeapon("terrariaLeadShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaLeadShortsword);
				ALL_ITEMS.add(terrariaLeadShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.LeadBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.LeadBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.LeadBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.LeadBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.LeadBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.LeadBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaLeadBroadsword = new HAWeapon("terrariaLeadBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaLeadBroadsword);
				}else {
					terrariaLeadBroadsword = new ItemGreatswordHW("terrariaLeadBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaLeadBroadsword, HeroicArmory.MOD_ID, "terrariaLeadBroadsword");
				}
				ALL_ITEMS.add(terrariaLeadBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.Spear.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Spear.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Spear.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Spear.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Spear.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Spear.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaSpear = new HAWeapon("terrariaSpear", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaSpear);
				}else {
					terrariaSpear = new ItemSpearHW("terrariaSpear", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaSpear, HeroicArmory.MOD_ID, "terrariaSpear");
				}
				ALL_ITEMS.add(terrariaSpear);
			}
			if (HAConfig.modifiedItems.terrariaModified.IronShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.IronShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.IronShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.IronShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.IronShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.IronShortsword.rarity);
				}};
				terrariaIronShortsword = new HAWeapon("terrariaIronShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaIronShortsword);
				ALL_ITEMS.add(terrariaIronShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.IronBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.IronBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.IronBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.IronBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.IronBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.IronBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaIronBroadsword = new HAWeapon("terrariaIronBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaIronBroadsword);
				}else {
					terrariaIronBroadsword = new ItemGreatswordHW("terrariaIronBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaIronBroadsword, HeroicArmory.MOD_ID, "terrariaIronBroadsword");
				}
				ALL_ITEMS.add(terrariaIronBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.SilverBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.SilverBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.SilverBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.SilverBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.SilverBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.SilverBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaSilverBroadsword = new HAWeapon("terrariaSilverBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaSilverBroadsword);
				}else {
					terrariaSilverBroadsword = new ItemGreatswordHW("terrariaSilverBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaSilverBroadsword, HeroicArmory.MOD_ID, "terrariaSilverBroadsword");
				}
				ALL_ITEMS.add(terrariaSilverBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.SilverShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.SilverShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.SilverShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.SilverShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.SilverShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.SilverShortsword.rarity);
				}};
				terrariaSilverShortsword = new HAWeapon("terrariaSilverShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaSilverShortsword);
				ALL_ITEMS.add(terrariaSilverShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.GoldShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.GoldShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.GoldShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.GoldShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.GoldShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.GoldShortsword.rarity);
				}};
				terrariaGoldShortsword = new HAWeapon("terrariaGoldShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaGoldShortsword);
				ALL_ITEMS.add(terrariaGoldShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.GoldBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.GoldBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.GoldBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.GoldBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.GoldBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.GoldBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaGoldBroadsword = new HAWeapon("terrariaGoldBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaGoldBroadsword);
				}else {
					terrariaGoldBroadsword = new ItemGreatswordHW("terrariaGoldBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaGoldBroadsword, HeroicArmory.MOD_ID, "terrariaGoldBroadsword");
				}
				ALL_ITEMS.add(terrariaGoldBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.TungstenBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.TungstenBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.TungstenBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.TungstenBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.TungstenBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.TungstenBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaTungstenBroadsword = new HAWeapon("terrariaTungstenBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaTungstenBroadsword);
				}else {
					terrariaTungstenBroadsword = new ItemGreatswordHW("terrariaTungstenBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaTungstenBroadsword, HeroicArmory.MOD_ID, "terrariaTungstenBroadsword");
				}
				ALL_ITEMS.add(terrariaTungstenBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.TungstenShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.TungstenShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.TungstenShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.TungstenShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.TungstenShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.TungstenShortsword.rarity);
				}};
				terrariaTungstenShortsword = new HAWeapon("terrariaTungstenShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaTungstenShortsword);
				ALL_ITEMS.add(terrariaTungstenShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.PlatinumShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.PlatinumShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.PlatinumShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.PlatinumShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.PlatinumShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.PlatinumShortsword.rarity);
				}};
				terrariaPlatinumShortsword = new HAWeapon("terrariaPlatinumShortsword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaPlatinumShortsword);
				ALL_ITEMS.add(terrariaPlatinumShortsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.PlatinumBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.PlatinumBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.PlatinumBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.PlatinumBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.PlatinumBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.PlatinumBroadsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaPlatinumBroadsword = new HAWeapon("terrariaPlatinumBroadsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaPlatinumBroadsword);
				}else {
					terrariaPlatinumBroadsword = new ItemGreatswordHW("terrariaPlatinumBroadsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaPlatinumBroadsword, HeroicArmory.MOD_ID, "terrariaPlatinumBroadsword");
				}
				ALL_ITEMS.add(terrariaPlatinumBroadsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.MandibleBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.MandibleBlade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.MandibleBlade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.MandibleBlade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.MandibleBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.MandibleBlade.rarity);
				}};
				terrariaMandibleBlade = new HAWeapon("terrariaMandibleBlade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaMandibleBlade);
				ALL_ITEMS.add(terrariaMandibleBlade);
			}
			if (HAConfig.modifiedItems.terrariaModified.Katana.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Katana.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Katana.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Katana.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Katana.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Katana.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaKatana = new HAWeapon("terrariaKatana", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaKatana);
				}else {
					terrariaKatana = new ItemKatanaHW("terrariaKatana", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaKatana, HeroicArmory.MOD_ID, "terrariaKatana");
				}
				ALL_ITEMS.add(terrariaKatana);
			}
			if (HAConfig.modifiedItems.terrariaModified.ExoticScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.ExoticScimitar.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.ExoticScimitar.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.ExoticScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.ExoticScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.ExoticScimitar.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaExoticScimitar = new HAWeapon("terrariaExoticScimitar", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaExoticScimitar);
				}else {
					terrariaExoticScimitar = new ItemSaberHW("terrariaExoticScimitar", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaExoticScimitar, HeroicArmory.MOD_ID, "terrariaExoticScimitar");
				}
				ALL_ITEMS.add(terrariaExoticScimitar);
			}
			if (HAConfig.modifiedItems.terrariaModified.Muramasa.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Muramasa.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Muramasa.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Muramasa.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Muramasa.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Muramasa.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaMuramasa = new HAWeapon("terrariaMuramasa", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaMuramasa);
				}else {
					terrariaMuramasa = new ItemKatanaHW("terrariaMuramasa", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaMuramasa, HeroicArmory.MOD_ID, "terrariaMuramasa");
				}
				ALL_ITEMS.add(terrariaMuramasa);
			}
			if (HAConfig.modifiedItems.terrariaModified.FalconBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.FalconBlade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.FalconBlade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.FalconBlade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.FalconBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.FalconBlade.rarity);
				}};
				terrariaFalconBlade = new HAWeapon("terrariaFalconBlade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaFalconBlade);
				ALL_ITEMS.add(terrariaFalconBlade);
			}
			if (HAConfig.modifiedItems.terrariaModified.BladeofGrass.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.BladeofGrass.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.BladeofGrass.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.BladeofGrass.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.BladeofGrass.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.BladeofGrass.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaBladeofGrass = new HAWeapon("terrariaBladeofGrass", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaBladeofGrass);
				}else {
					terrariaBladeofGrass = new ItemLongswordHW("terrariaBladeofGrass", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaBladeofGrass, HeroicArmory.MOD_ID, "terrariaBladeofGrass");
				}
				ALL_ITEMS.add(terrariaBladeofGrass);
			}
			if (HAConfig.modifiedItems.terrariaModified.FieryGreatsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.FieryGreatsword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.FieryGreatsword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.FieryGreatsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.FieryGreatsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.FieryGreatsword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaFieryGreatsword = new HAWeapon("terrariaFieryGreatsword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaFieryGreatsword);
				}else {
					terrariaFieryGreatsword = new ItemGreatswordHW("terrariaFieryGreatsword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyIgnite(8));
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaFieryGreatsword, HeroicArmory.MOD_ID, "terrariaFieryGreatsword");
				}
				ALL_ITEMS.add(terrariaFieryGreatsword);
			}
			if (HAConfig.modifiedItems.terrariaModified.BoneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.BoneSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.BoneSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.BoneSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.BoneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.BoneSword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaBoneSword = new HAWeapon("terrariaBoneSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaBoneSword);
				}else {
					terrariaBoneSword = new ItemLongswordHW("terrariaBoneSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaBoneSword, HeroicArmory.MOD_ID, "terrariaBoneSword");
				}
				ALL_ITEMS.add(terrariaBoneSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.BloodButcherer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.BloodButcherer.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.BloodButcherer.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.BloodButcherer.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.BloodButcherer.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.BloodButcherer.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaBloodButcherer = new HAWeapon("terrariaBloodButcherer", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaBloodButcherer);
				}else {
					terrariaBloodButcherer = new ItemGreatswordHW("terrariaBloodButcherer", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaBloodButcherer, HeroicArmory.MOD_ID, "terrariaBloodButcherer");
				}
				ALL_ITEMS.add(terrariaBloodButcherer);
			}
			if (HAConfig.modifiedItems.terrariaModified.EnchantedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.EnchantedSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.EnchantedSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.EnchantedSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.EnchantedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.EnchantedSword.rarity);
				}};
				terrariaEnchantedSword = new HAWeapon("terrariaEnchantedSword", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaEnchantedSword);
				ALL_ITEMS.add(terrariaEnchantedSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.Starfury.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Starfury.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Starfury.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Starfury.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Starfury.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Starfury.rarity);
				}};
				terrariaStarfury = new HAWeapon("terrariaStarfury", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaStarfury);
				ALL_ITEMS.add(terrariaStarfury);
			}
			if (HAConfig.modifiedItems.terrariaModified.BeeKeeper.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.BeeKeeper.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.BeeKeeper.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.BeeKeeper.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.BeeKeeper.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.BeeKeeper.rarity);
				}};
				terrariaBeeKeeper = new HAWeapon("terrariaBeeKeeper", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaBeeKeeper);
				ALL_ITEMS.add(terrariaBeeKeeper);
			}
			if (HAConfig.modifiedItems.terrariaModified.IceBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.IceBlade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.IceBlade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.IceBlade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.IceBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.IceBlade.rarity);
				}};
				terrariaIceBlade = new HAWeapon("terrariaIceBlade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaIceBlade);
				ALL_ITEMS.add(terrariaIceBlade);
			}
			if (HAConfig.modifiedItems.terrariaModified.NightEdge.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.NightEdge.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.NightEdge.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.NightEdge.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.NightEdge.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.NightEdge.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaNightEdge = new HAWeapon("terrariaNightEdge", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaNightEdge);
				}else {
					terrariaNightEdge = new ItemGreatswordHW("terrariaNightEdge", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaNightEdge, HeroicArmory.MOD_ID, "terrariaNightEdge");
				}
				ALL_ITEMS.add(terrariaNightEdge);
			}
			if (HAConfig.modifiedItems.terrariaModified.Arkhalis.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Arkhalis.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Arkhalis.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Arkhalis.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Arkhalis.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Arkhalis.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaArkhalis = new HAWeapon("terrariaArkhalis", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaArkhalis);
				}else {
					terrariaArkhalis = new ItemParryingDaggerHW("terrariaArkhalis", dummyMaterialEx, properties, WeaponProperties.BLOCK_MELEE, WeaponProperties.QUICK_STRIKE, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaArkhalis, HeroicArmory.MOD_ID, "terrariaArkhalis");
				}
				ALL_ITEMS.add(terrariaArkhalis);
			}
			if (HAConfig.modifiedItems.terrariaModified.Trident.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Trident.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Trident.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Trident.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Trident.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Trident.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaTrident = new HAWeapon("terrariaTrident", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaTrident);
				}else {
					terrariaTrident = new ItemSpearHW("terrariaTrident", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaTrident, HeroicArmory.MOD_ID, "terrariaTrident");
				}
				ALL_ITEMS.add(terrariaTrident);
			}
			if (HAConfig.modifiedItems.terrariaModified.TheRottedFork.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.TheRottedFork.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.TheRottedFork.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.TheRottedFork.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.TheRottedFork.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.TheRottedFork.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaTheRottedFork = new HAWeapon("terrariaTheRottedFork", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaTheRottedFork);
				}else {
					terrariaTheRottedFork = new ItemSpearHW("terrariaTheRottedFork", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaTheRottedFork, HeroicArmory.MOD_ID, "terrariaTheRottedFork");
				}
				ALL_ITEMS.add(terrariaTheRottedFork);
			}
			if (HAConfig.modifiedItems.terrariaModified.WhitePhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.WhitePhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.WhitePhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.WhitePhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.WhitePhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.WhitePhaseblade.rarity);
				}};
				terrariaWhitePhaseblade = new HAWeapon("terrariaWhitePhaseblade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaWhitePhaseblade);
				ALL_ITEMS.add(terrariaWhitePhaseblade);
			}
			if (HAConfig.modifiedItems.terrariaModified.YellowPhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.YellowPhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.YellowPhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.YellowPhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.YellowPhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.YellowPhaseblade.rarity);
				}};
				terrariaYellowPhaseblade = new HAWeapon("terrariaYellowPhaseblade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaYellowPhaseblade);
				ALL_ITEMS.add(terrariaYellowPhaseblade);
			}
			if (HAConfig.modifiedItems.terrariaModified.PurplePhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.PurplePhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.PurplePhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.PurplePhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.PurplePhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.PurplePhaseblade.rarity);
				}};
				terrariaPurplePhaseblade = new HAWeapon("terrariaPurplePhaseblade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaPurplePhaseblade);
				ALL_ITEMS.add(terrariaPurplePhaseblade);
			}
			if (HAConfig.modifiedItems.terrariaModified.GreenPhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.GreenPhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.GreenPhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.GreenPhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.GreenPhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.GreenPhaseblade.rarity);
				}};
				terrariaGreenPhaseblade = new HAWeapon("terrariaGreenPhaseblade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaGreenPhaseblade);
				ALL_ITEMS.add(terrariaGreenPhaseblade);
			}
			if (HAConfig.modifiedItems.terrariaModified.RedPhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.RedPhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.RedPhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.RedPhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.RedPhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.RedPhaseblade.rarity);
				}};
				terrariaRedPhaseblade = new HAWeapon("terrariaRedPhaseblade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaRedPhaseblade);
				ALL_ITEMS.add(terrariaRedPhaseblade);
			}
			if (HAConfig.modifiedItems.terrariaModified.BluePhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.BluePhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.BluePhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.BluePhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.BluePhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.BluePhaseblade.rarity);
				}};
				terrariaBluePhaseblade = new HAWeapon("terrariaBluePhaseblade", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaBluePhaseblade);
				ALL_ITEMS.add(terrariaBluePhaseblade);
			}
			if (HAConfig.modifiedItems.terrariaModified.LightBane.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.LightBane.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.LightBane.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.LightBane.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.LightBane.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.LightBane.rarity);
				}};
				terrariaLightBane = new HAWeapon("terrariaLightBane", dummyMaterial, properties);
				HEROIC_ITEMS.add(terrariaLightBane);
				ALL_ITEMS.add(terrariaLightBane);
			}
			if (HAConfig.modifiedItems.terrariaModified.DarkLance.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.DarkLance.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.DarkLance.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.DarkLance.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.DarkLance.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.DarkLance.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaDarkLance = new HAWeapon("terrariaDarkLance", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaDarkLance);
				}else {
					terrariaDarkLance = new ItemSpearHW("terrariaDarkLance", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaDarkLance, HeroicArmory.MOD_ID, "terrariaDarkLance");
				}
				ALL_ITEMS.add(terrariaDarkLance);
			}
			if (HAConfig.modifiedItems.terrariaModified.PurpleClubberfish.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.PurpleClubberfish.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.PurpleClubberfish.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.PurpleClubberfish.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.PurpleClubberfish.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.PurpleClubberfish.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaPurpleClubberfish = new HAWeapon("terrariaPurpleClubberfish", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaPurpleClubberfish);
				}else {
					terrariaPurpleClubberfish = new ItemClubHW("terrariaPurpleClubberfish", dummyMaterialEx, properties, WeaponProperties.NAUSEA);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaPurpleClubberfish, HeroicArmory.MOD_ID, "terrariaPurpleClubberfish");
				}
				ALL_ITEMS.add(terrariaPurpleClubberfish);
			}
			if (HAConfig.modifiedItems.terrariaModified.CactusSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.CactusSword.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.CactusSword.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.CactusSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.CactusSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.CactusSword.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaCactusSword = new HAWeapon("terrariaCactusSword", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaCactusSword);
				}else {
					terrariaCactusSword = new ItemGreatswordHW("terrariaCactusSword", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaCactusSword, HeroicArmory.MOD_ID, "terrariaCactusSword");
				}
				ALL_ITEMS.add(terrariaCactusSword);
			}
			if (HAConfig.modifiedItems.terrariaModified.Swordfish.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariaModified.Swordfish.damage);
					put("durability", HAConfig.modifiedItems.terrariaModified.Swordfish.durability);
					put("speed", HAConfig.modifiedItems.terrariaModified.Swordfish.speed);
					put("enchantability", HAConfig.modifiedItems.terrariaModified.Swordfish.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariaModified.Swordfish.rarity);
				}};
				if (!SupportSpartanWeaponry){
					terrariaSwordfish = new HAWeapon("terrariaSwordfish", dummyMaterial, properties);
					HEROIC_ITEMS.add(terrariaSwordfish);
				}else {
					terrariaSwordfish = new ItemSpearHW("terrariaSwordfish", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(terrariaSwordfish, HeroicArmory.MOD_ID, "terrariaSwordfish");
				}
				ALL_ITEMS.add(terrariaSwordfish);
			}
		}
		//sw
		if (HAConfig.includeSeries.sw) {
			if (HAConfig.modifiedItems.swModified.YellowLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.YellowLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.YellowLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.YellowLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.YellowLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.YellowLightsaber.rarity);
				}};
				swYellowLightsaber = new HAWeapon("swYellowLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swYellowLightsaber);
				ALL_ITEMS.add(swYellowLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.GreenLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.GreenLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.GreenLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.GreenLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.GreenLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.GreenLightsaber.rarity);
				}};
				swGreenLightsaber = new HAWeapon("swGreenLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swGreenLightsaber);
				ALL_ITEMS.add(swGreenLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.BlueLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.BlueLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.BlueLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.BlueLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.BlueLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.BlueLightsaber.rarity);
				}};
				swBlueLightsaber = new HAWeapon("swBlueLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swBlueLightsaber);
				ALL_ITEMS.add(swBlueLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.RedLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.RedLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.RedLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.RedLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.RedLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.RedLightsaber.rarity);
				}};
				swRedLightsaber = new HAWeapon("swRedLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swRedLightsaber);
				ALL_ITEMS.add(swRedLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.MaceWinduLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.MaceWinduLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.MaceWinduLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.MaceWinduLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.MaceWinduLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.MaceWinduLightsaber.rarity);
				}};
				swMaceWinduLightsaber = new HAWeapon("swMaceWinduLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swMaceWinduLightsaber);
				ALL_ITEMS.add(swMaceWinduLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.TheInquisitorLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.TheInquisitorLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.TheInquisitorLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.TheInquisitorLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.TheInquisitorLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.TheInquisitorLightsaber.rarity);
				}};
				swTheInquisitorLightsaber = new HAWeapon("swTheInquisitorLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swTheInquisitorLightsaber);
				ALL_ITEMS.add(swTheInquisitorLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.DarthMaulLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.DarthMaulLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.DarthMaulLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.DarthMaulLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.DarthMaulLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.DarthMaulLightsaber.rarity);
				}};
				swDarthMaulLightsaber = new HAWeapon("swDarthMaulLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swDarthMaulLightsaber);
				ALL_ITEMS.add(swDarthMaulLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.QuiGonJinnLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.QuiGonJinnLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.QuiGonJinnLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.QuiGonJinnLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.QuiGonJinnLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.QuiGonJinnLightsaber.rarity);
				}};
				swQuiGonJinnLightsaber = new HAWeapon("swQuiGonJinnLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swQuiGonJinnLightsaber);
				ALL_ITEMS.add(swQuiGonJinnLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.KyloRenLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.KyloRenLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.KyloRenLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.KyloRenLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.KyloRenLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.KyloRenLightsaber.rarity);
				}};
				swKyloRenLightsaber = new HAWeapon("swKyloRenLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swKyloRenLightsaber);
				ALL_ITEMS.add(swKyloRenLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.CountDookuLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.CountDookuLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.CountDookuLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.CountDookuLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.CountDookuLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.CountDookuLightsaber.rarity);
				}};
				swCountDookuLightsaber = new HAWeapon("swCountDookuLightsaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swCountDookuLightsaber);
				ALL_ITEMS.add(swCountDookuLightsaber);
			}
			if (HAConfig.modifiedItems.swModified.Darksaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swModified.Darksaber.damage);
					put("durability", HAConfig.modifiedItems.swModified.Darksaber.durability);
					put("speed", HAConfig.modifiedItems.swModified.Darksaber.speed);
					put("enchantability", HAConfig.modifiedItems.swModified.Darksaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swModified.Darksaber.rarity);
				}};
				swDarksaber = new HAWeapon("swDarksaber", dummyMaterial, properties);
				HEROIC_ITEMS.add(swDarksaber);
				ALL_ITEMS.add(swDarksaber);
			}
		}
		//internet
		if (HAConfig.includeSeries.internet) {
			if (HAConfig.modifiedItems.internetModified.DemonoidPitchfork.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.internetModified.DemonoidPitchfork.damage);
					put("durability", HAConfig.modifiedItems.internetModified.DemonoidPitchfork.durability);
					put("speed", HAConfig.modifiedItems.internetModified.DemonoidPitchfork.speed);
					put("enchantability", HAConfig.modifiedItems.internetModified.DemonoidPitchfork.enchantability);
					put("rarity", HAConfig.modifiedItems.internetModified.DemonoidPitchfork.rarity);
				}};
				if (!SupportSpartanWeaponry){
					internetDemonoidPitchfork = new HAWeapon("internetDemonoidPitchfork", dummyMaterial, properties);
					HEROIC_ITEMS.add(internetDemonoidPitchfork);
				}else {
					internetDemonoidPitchfork = new ItemSpearHW("internetDemonoidPitchfork", dummyMaterialEx, properties, WeaponProperties.REACH_1);
					SpartanWeaponryAPI.addItemModelToRegistry(internetDemonoidPitchfork, HeroicArmory.MOD_ID, "internetDemonoidPitchfork");
				}
				ALL_ITEMS.add(internetDemonoidPitchfork);
			}
		}
		//nh
		if (HAConfig.includeSeries.nh) {
			if (HAConfig.modifiedItems.nhModified.Magicbane.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhModified.Magicbane.damage);
					put("durability", HAConfig.modifiedItems.nhModified.Magicbane.durability);
					put("speed", HAConfig.modifiedItems.nhModified.Magicbane.speed);
					put("enchantability", HAConfig.modifiedItems.nhModified.Magicbane.enchantability);
					put("rarity", HAConfig.modifiedItems.nhModified.Magicbane.rarity);
				}};
				if (!SupportSpartanWeaponry){
					nhMagicbane = new HAWeapon("nhMagicbane", dummyMaterial, properties);
					HEROIC_ITEMS.add(nhMagicbane);
				}else {
					nhMagicbane = new ItemDaggerHW("nhMagicbane", dummyMaterialEx, properties, WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_BACKSTAB);
					SpartanWeaponryAPI.addItemModelToRegistry(nhMagicbane, HeroicArmory.MOD_ID, "nhMagicbane");
				}
				ALL_ITEMS.add(nhMagicbane);
			}
			if (HAConfig.modifiedItems.nhModified.Athame.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhModified.Athame.damage);
					put("durability", HAConfig.modifiedItems.nhModified.Athame.durability);
					put("speed", HAConfig.modifiedItems.nhModified.Athame.speed);
					put("enchantability", HAConfig.modifiedItems.nhModified.Athame.enchantability);
					put("rarity", HAConfig.modifiedItems.nhModified.Athame.rarity);
				}};
				if (!SupportSpartanWeaponry){
					nhAthame = new HAWeapon("nhAthame", dummyMaterial, properties);
					HEROIC_ITEMS.add(nhAthame);
				}else {
					nhAthame = new ItemDaggerHW("nhAthame", dummyMaterialEx, properties, WeaponProperties.THROWABLE, WeaponProperties.EXTRA_DAMAGE_BACKSTAB);
					SpartanWeaponryAPI.addItemModelToRegistry(nhAthame, HeroicArmory.MOD_ID, "nhAthame");
				}
				ALL_ITEMS.add(nhAthame);
			}
			if (HAConfig.modifiedItems.nhModified.Grayswandir.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhModified.Grayswandir.damage);
					put("durability", HAConfig.modifiedItems.nhModified.Grayswandir.durability);
					put("speed", HAConfig.modifiedItems.nhModified.Grayswandir.speed);
					put("enchantability", HAConfig.modifiedItems.nhModified.Grayswandir.enchantability);
					put("rarity", HAConfig.modifiedItems.nhModified.Grayswandir.rarity);
				}};
				if (!SupportSpartanWeaponry){
					nhGrayswandir = new HAWeapon("nhGrayswandir", dummyMaterial, properties);
					HEROIC_ITEMS.add(nhGrayswandir);
				}else {
					nhGrayswandir = new ItemSaberHW("nhGrayswandir", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST, WeaponProperties.EXTRA_DAMAGE_50P_UNDEAD);
					SpartanWeaponryAPI.addItemModelToRegistry(nhGrayswandir, HeroicArmory.MOD_ID, "nhGrayswandir");
				}
				ALL_ITEMS.add(nhGrayswandir);
			}
			if (HAConfig.modifiedItems.nhModified.SilverSaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhModified.SilverSaber.damage);
					put("durability", HAConfig.modifiedItems.nhModified.SilverSaber.durability);
					put("speed", HAConfig.modifiedItems.nhModified.SilverSaber.speed);
					put("enchantability", HAConfig.modifiedItems.nhModified.SilverSaber.enchantability);
					put("rarity", HAConfig.modifiedItems.nhModified.SilverSaber.rarity);
				}};
				if (!SupportSpartanWeaponry){
					nhSilverSaber = new HAWeapon("nhSilverSaber", dummyMaterial, properties);
					HEROIC_ITEMS.add(nhSilverSaber);
				}else {
					nhSilverSaber = new ItemSaberHW("nhSilverSaber", dummyMaterialEx, properties, WeaponProperties.DAMAGE_ABSORB_25, WeaponProperties.EXTRA_DAMAGE_2_CHEST);
					SpartanWeaponryAPI.addItemModelToRegistry(nhSilverSaber, HeroicArmory.MOD_ID, "nhSilverSaber");
				}
				ALL_ITEMS.add(nhSilverSaber);
			}
		}
		//abcm
		if (HAConfig.includeSeries.abcm) {
			if (HAConfig.modifiedItems.abcmModified.Excalibur.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.abcmModified.Excalibur.damage);
					put("durability", HAConfig.modifiedItems.abcmModified.Excalibur.durability);
					put("speed", HAConfig.modifiedItems.abcmModified.Excalibur.speed);
					put("enchantability", HAConfig.modifiedItems.abcmModified.Excalibur.enchantability);
					put("rarity", HAConfig.modifiedItems.abcmModified.Excalibur.rarity);
				}};
				if (!SupportSpartanWeaponry){
					abcmExcalibur = new HAWeapon("abcmExcalibur", dummyMaterial, properties);
					HEROIC_ITEMS.add(abcmExcalibur);
				}else {
					abcmExcalibur = new ItemGreatswordHW("abcmExcalibur", dummyMaterialEx, properties, WeaponProperties.TWO_HANDED_2, WeaponProperties.REACH_1, WeaponProperties.SWEEP_DAMAGE_FULL, new WeaponPropertyExtraDamage("extra_damage_undead", "spartanweaponry", 1.75F), new WeaponPropertyRepairUndead());
					SpartanWeaponryAPI.addItemModelToRegistry(abcmExcalibur, HeroicArmory.MOD_ID, "abcmExcalibur");
				}
				ALL_ITEMS.add(abcmExcalibur);
			}
		}

		if (ALL_ITEMS != null) {
			Iterator<Item> itemList = ALL_ITEMS.listIterator();
			Item item;
			while (itemList.hasNext()) {
				item = itemList.next();
				System.out.println(item.getRegistryName());
				event.getRegistry().register(item);
			}
		}

		//Loot Tables
		LootTableList.register(new ResourceLocation("heroicarmory", "loot"));
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		if (HEROIC_ITEMS != null){
			Iterator<Item> itemList = HEROIC_ITEMS.listIterator();
			Item item;
			while (itemList.hasNext()) {
				item = itemList.next();
				if (item.getRegistryName() != null) {
					ModelLoader.setCustomModelResourceLocation(item, 0,
							new ModelResourceLocation(item.getRegistryName(), "inventory"));
				}
			}
		}
	}

	//loot tables
	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {

		if (HAConfig.lootChance > 0){
			String name = evt.getName().toString();

			if (name.contains("chest")) {

				//return if not a minecraft chest
				if (!HAConfig.includeModChests && !name.contains("minecraft:")) {
					System.out.println("skipping loot table '" + name + "' because mod chests are disabled in config");
					return;
				}

				System.out.println("added loot to loot table '" + name + "'");

				ArrayList<LootEntryItem> entries = new ArrayList<>();

				if (ALL_ITEMS != null && HAConfig.lootChance != 0) {
					Iterator<Item> itemList = ALL_ITEMS.listIterator();
					Item item;
					while (itemList.hasNext()) {
						item = itemList.next();
						System.out.println("Adding " + item.getRegistryName() + " to loot tables");
						entries.add(new LootEntryItem(item, (int) Math.ceil(Math.pow(((IHeroicItem) item).getLootRarity(), HAConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:" + item.getRegistryName()));
					}
				}

				entries.add(new LootEntryItem(Items.BONE, (int) Math.round((2486 / HAConfig.lootChance) - 2486), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:emptyItem"));

				LootEntry[] entriesArray = entries.toArray(new LootEntry[entries.size()]);
				LootPool pool = new LootPool(entriesArray, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(1), "heroicarmorypool");

				evt.getTable().addPool(pool);
			}
		}
	}

}