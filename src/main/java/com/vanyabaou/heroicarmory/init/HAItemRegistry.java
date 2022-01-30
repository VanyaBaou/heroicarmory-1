package com.vanyabaou.heroicarmory.init;

import com.vanyabaou.heroicarmory.HAConfig;
import com.vanyabaou.heroicarmory.HeroicArmory;
import com.vanyabaou.heroicarmory.items.HASword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	public static Item scFirangi, scCocytus, scErlangBlade, scSoulEdgeNightmare, scPhlegathon, scAcheron, scLethe, scQueenGuard,
		scHolyAntler, scEpee, scWarHammer, scKalutues, scEstoc, scFlambert2P, scReiterpallasch, scFlambert, scBlueCrystalRod,
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
	public static Item dsGreatswordofArtorias, dsGreatLordGreatsword, dsAstoraGreatsword, dsZweilhander;

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

	//creative tab
	public static final CreativeTabs tabHeroicArmory = new CreativeTabs("tabHeroicArmory") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(lotrNarsil);
		}		
	};

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		System.out.println("registerItems start");
		ToolMaterial dummyMaterial = EnumHelper.addToolMaterial("HeroicMaterial",0,1000,1f,0f,0);

		//lotr
		if (HAConfig.includeSeries.lotr) {
			if (HAConfig.modifiedItems.lotrmodified.GimliBattleAxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.GimliBattleAxe.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.GimliBattleAxe.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.GimliBattleAxe.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.GimliBattleAxe.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.GimliBattleAxe.rarity);
				}};
				lotrGimliBattleAxe = new HASword("lotrGimliBattleAxe", dummyMaterial, properties);
				ALL_ITEMS.add(lotrGimliBattleAxe);
			}
			if (HAConfig.modifiedItems.lotrmodified.GimliLongAxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.GimliLongAxe.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.GimliLongAxe.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.GimliLongAxe.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.GimliLongAxe.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.GimliLongAxe.rarity);
				}};
				lotrGimliLongAxe = new HASword("lotrGimliLongAxe", dummyMaterial, properties);
				ALL_ITEMS.add(lotrGimliLongAxe);
			}
			if (HAConfig.modifiedItems.lotrmodified.MorgulBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.MorgulBlade.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.MorgulBlade.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.MorgulBlade.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.MorgulBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.MorgulBlade.rarity);
				}};
				lotrMorgulBlade = new HASword("lotrMorgulBlade", dummyMaterial, properties);
				ALL_ITEMS.add(lotrMorgulBlade);
			}
			if (HAConfig.modifiedItems.lotrmodified.Sting.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.Sting.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.Sting.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.Sting.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.Sting.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.Sting.rarity);
				}};
				lotrSting = new HASword("lotrSting", dummyMaterial, properties);
				ALL_ITEMS.add(lotrSting);
			}
			if (HAConfig.modifiedItems.lotrmodified.Glamdring.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.Glamdring.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.Glamdring.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.Glamdring.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.Glamdring.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.Glamdring.rarity);
				}};
				lotrGlamdring = new HASword("lotrGlamdring", dummyMaterial, properties);
				ALL_ITEMS.add(lotrGlamdring);
			}
			if (HAConfig.modifiedItems.lotrmodified.Anduril.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.Anduril.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.Anduril.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.Anduril.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.Anduril.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.Anduril.rarity);
				}};
				lotrAnduril = new HASword("lotrAnduril", dummyMaterial, properties);
				ALL_ITEMS.add(lotrAnduril);
			}
			if (HAConfig.modifiedItems.lotrmodified.Narsil.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.Narsil.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.Narsil.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.Narsil.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.Narsil.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.Narsil.rarity);
				}};
				lotrNarsil = new HASword("lotrNarsil", dummyMaterial, properties);
				ALL_ITEMS.add(lotrNarsil);
			}
			if (HAConfig.modifiedItems.lotrmodified.SauronMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.SauronMace.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.SauronMace.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.SauronMace.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.SauronMace.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.SauronMace.rarity);
				}};
				lotrSauronMace = new HASword("lotrSauronMace", dummyMaterial, properties);
				ALL_ITEMS.add(lotrSauronMace);
			}
			if (HAConfig.modifiedItems.lotrmodified.WitchKingSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lotrmodified.WitchKingSword.damage);
					put("durability", HAConfig.modifiedItems.lotrmodified.WitchKingSword.durability);
					put("speed", HAConfig.modifiedItems.lotrmodified.WitchKingSword.speed);
					put("enchantability", HAConfig.modifiedItems.lotrmodified.WitchKingSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lotrmodified.WitchKingSword.rarity);
				}};
				lotrWitchKingSword = new HASword("lotrWitchKingSword", dummyMaterial, properties);
				ALL_ITEMS.add(lotrWitchKingSword);
			}
		}

//loz
		if (HAConfig.includeSeries.loz) {
			if (HAConfig.modifiedItems.lozmodified.MasterSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.MasterSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.MasterSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.MasterSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.MasterSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.MasterSword.rarity);
				}};
				lozMasterSword = new HASword("lozMasterSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozMasterSword);
			}
			if (HAConfig.modifiedItems.lozmodified.MasterSwordII.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.MasterSwordII.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.MasterSwordII.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.MasterSwordII.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.MasterSwordII.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.MasterSwordII.rarity);
				}};
				lozMasterSwordII = new HASword("lozMasterSwordII", dummyMaterial, properties);
				ALL_ITEMS.add(lozMasterSwordII);
			}
			if (HAConfig.modifiedItems.lozmodified.TemperedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.TemperedSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.TemperedSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.TemperedSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.TemperedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.TemperedSword.rarity);
				}};
				lozTemperedSword = new HASword("lozTemperedSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozTemperedSword);
			}
			if (HAConfig.modifiedItems.lozmodified.MasterSwordIII.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.MasterSwordIII.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.MasterSwordIII.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.MasterSwordIII.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.MasterSwordIII.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.MasterSwordIII.rarity);
				}};
				lozMasterSwordIII = new HASword("lozMasterSwordIII", dummyMaterial, properties);
				ALL_ITEMS.add(lozMasterSwordIII);
			}
			if (HAConfig.modifiedItems.lozmodified.GoldenSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GoldenSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GoldenSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GoldenSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GoldenSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GoldenSword.rarity);
				}};
				lozGoldenSword = new HASword("lozGoldenSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozGoldenSword);
			}
			if (HAConfig.modifiedItems.lozmodified.Flameblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.Flameblade.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.Flameblade.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.Flameblade.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.Flameblade.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.Flameblade.rarity);
				}};
				lozFlameblade = new HASword("lozFlameblade", dummyMaterial, properties);
				ALL_ITEMS.add(lozFlameblade);
			}
			if (HAConfig.modifiedItems.lozmodified.DarknutSwordTp.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.DarknutSwordTp.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.DarknutSwordTp.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.DarknutSwordTp.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.DarknutSwordTp.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.DarknutSwordTp.rarity);
				}};
				lozDarknutSwordTp = new HASword("lozDarknutSwordTp", dummyMaterial, properties);
				ALL_ITEMS.add(lozDarknutSwordTp);
			}
			if (HAConfig.modifiedItems.lozmodified.GhirahimSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GhirahimSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GhirahimSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GhirahimSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GhirahimSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GhirahimSword.rarity);
				}};
				lozGhirahimSword = new HASword("lozGhirahimSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozGhirahimSword);
			}
			if (HAConfig.modifiedItems.lozmodified.FierceDeitySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.FierceDeitySword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.FierceDeitySword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.FierceDeitySword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.FierceDeitySword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.FierceDeitySword.rarity);
				}};
				lozFierceDeitySword = new HASword("lozFierceDeitySword", dummyMaterial, properties);
				ALL_ITEMS.add(lozFierceDeitySword);
			}
			if (HAConfig.modifiedItems.lozmodified.ZeldaSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.ZeldaSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.ZeldaSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.ZeldaSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.ZeldaSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.ZeldaSword.rarity);
				}};
				lozZeldaSword = new HASword("lozZeldaSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozZeldaSword);
			}
			if (HAConfig.modifiedItems.lozmodified.BokoStick.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.BokoStick.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.BokoStick.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.BokoStick.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.BokoStick.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.BokoStick.rarity);
				}};
				lozBokoStick = new HASword("lozBokoStick", dummyMaterial, properties);
				ALL_ITEMS.add(lozBokoStick);
			}
			if (HAConfig.modifiedItems.lozmodified.CaneofByrna.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.CaneofByrna.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.CaneofByrna.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.CaneofByrna.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.CaneofByrna.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.CaneofByrna.rarity);
				}};
				lozCaneofByrna = new HASword("lozCaneofByrna", dummyMaterial, properties);
				ALL_ITEMS.add(lozCaneofByrna);
			}
			if (HAConfig.modifiedItems.lozmodified.MegatonHammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.MegatonHammer.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.MegatonHammer.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.MegatonHammer.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.MegatonHammer.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.MegatonHammer.rarity);
				}};
				lozMegatonHammer = new HASword("lozMegatonHammer", dummyMaterial, properties);
				ALL_ITEMS.add(lozMegatonHammer);
			}
			if (HAConfig.modifiedItems.lozmodified.KokiriSwordMm.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.KokiriSwordMm.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.KokiriSwordMm.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.KokiriSwordMm.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.KokiriSwordMm.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.KokiriSwordMm.rarity);
				}};
				lozKokiriSwordMm = new HASword("lozKokiriSwordMm", dummyMaterial, properties);
				ALL_ITEMS.add(lozKokiriSwordMm);
			}
			if (HAConfig.modifiedItems.lozmodified.KokiriSwordOoT.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.KokiriSwordOoT.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.KokiriSwordOoT.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.KokiriSwordOoT.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.KokiriSwordOoT.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.KokiriSwordOoT.rarity);
				}};
				lozKokiriSwordOoT = new HASword("lozKokiriSwordOoT", dummyMaterial, properties);
				ALL_ITEMS.add(lozKokiriSwordOoT);
			}
			if (HAConfig.modifiedItems.lozmodified.DemiseSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.DemiseSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.DemiseSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.DemiseSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.DemiseSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.DemiseSword.rarity);
				}};
				lozDemiseSword = new HASword("lozDemiseSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozDemiseSword);
			}
			if (HAConfig.modifiedItems.lozmodified.GiantKnife.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GiantKnife.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GiantKnife.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GiantKnife.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GiantKnife.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GiantKnife.rarity);
				}};
				lozGiantKnife = new HASword("lozGiantKnife", dummyMaterial, properties);
				ALL_ITEMS.add(lozGiantKnife);
			}
			if (HAConfig.modifiedItems.lozmodified.BiggoronSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.BiggoronSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.BiggoronSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.BiggoronSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.BiggoronSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.BiggoronSword.rarity);
				}};
				lozBiggoronSword = new HASword("lozBiggoronSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozBiggoronSword);
			}
			if (HAConfig.modifiedItems.lozmodified.PhantomGanonSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.PhantomGanonSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.PhantomGanonSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.PhantomGanonSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.PhantomGanonSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.PhantomGanonSword.rarity);
				}};
				lozPhantomGanonSword = new HASword("lozPhantomGanonSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozPhantomGanonSword);
			}
			if (HAConfig.modifiedItems.lozmodified.UltimateSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.UltimateSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.UltimateSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.UltimateSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.UltimateSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.UltimateSword.rarity);
				}};
				lozUltimateSword = new HASword("lozUltimateSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozUltimateSword);
			}
			if (HAConfig.modifiedItems.lozmodified.RoyalGuardSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.RoyalGuardSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.RoyalGuardSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.RoyalGuardSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.RoyalGuardSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.RoyalGuardSword.rarity);
				}};
				lozRoyalGuardSword = new HASword("lozRoyalGuardSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozRoyalGuardSword);
			}
			if (HAConfig.modifiedItems.lozmodified.MagicSwordConcept.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.MagicSwordConcept.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.MagicSwordConcept.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.MagicSwordConcept.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.MagicSwordConcept.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.MagicSwordConcept.rarity);
				}};
				lozMagicSwordConcept = new HASword("lozMagicSwordConcept", dummyMaterial, properties);
				ALL_ITEMS.add(lozMagicSwordConcept);
			}
			if (HAConfig.modifiedItems.lozmodified.MagicSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.MagicSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.MagicSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.MagicSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.MagicSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.MagicSword.rarity);
				}};
				lozMagicSword = new HASword("lozMagicSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozMagicSword);
			}
			if (HAConfig.modifiedItems.lozmodified.WhiteSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.WhiteSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.WhiteSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.WhiteSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.WhiteSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.WhiteSword.rarity);
				}};
				lozWhiteSword = new HASword("lozWhiteSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozWhiteSword);
			}
			if (HAConfig.modifiedItems.lozmodified.WhiteSwordConcept.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.WhiteSwordConcept.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.WhiteSwordConcept.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.WhiteSwordConcept.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.WhiteSwordConcept.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.WhiteSwordConcept.rarity);
				}};
				lozWhiteSwordConcept = new HASword("lozWhiteSwordConcept", dummyMaterial, properties);
				ALL_ITEMS.add(lozWhiteSwordConcept);
			}
			if (HAConfig.modifiedItems.lozmodified.PicoriBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.PicoriBlade.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.PicoriBlade.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.PicoriBlade.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.PicoriBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.PicoriBlade.rarity);
				}};
				lozPicoriBlade = new HASword("lozPicoriBlade", dummyMaterial, properties);
				ALL_ITEMS.add(lozPicoriBlade);
			}
			if (HAConfig.modifiedItems.lozmodified.RazorSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.RazorSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.RazorSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.RazorSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.RazorSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.RazorSword.rarity);
				}};
				lozRazorSword = new HASword("lozRazorSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozRazorSword);
			}
			if (HAConfig.modifiedItems.lozmodified.GreatFairySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GreatFairySword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GreatFairySword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GreatFairySword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GreatFairySword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GreatFairySword.rarity);
				}};
				lozGreatFairySword = new HASword("lozGreatFairySword", dummyMaterial, properties);
				ALL_ITEMS.add(lozGreatFairySword);
			}
			if (HAConfig.modifiedItems.lozmodified.GoddessWhiteSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GoddessWhiteSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GoddessWhiteSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GoddessWhiteSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GoddessWhiteSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GoddessWhiteSword.rarity);
				}};
				lozGoddessWhiteSword = new HASword("lozGoddessWhiteSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozGoddessWhiteSword);
			}
			if (HAConfig.modifiedItems.lozmodified.GoddessSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GoddessSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GoddessSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GoddessSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GoddessSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GoddessSword.rarity);
				}};
				lozGoddessSword = new HASword("lozGoddessSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozGoddessSword);
			}
			if (HAConfig.modifiedItems.lozmodified.GildedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.GildedSword.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.GildedSword.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.GildedSword.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.GildedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.GildedSword.rarity);
				}};
				lozGildedSword = new HASword("lozGildedSword", dummyMaterial, properties);
				ALL_ITEMS.add(lozGildedSword);
			}
			if (HAConfig.modifiedItems.lozmodified.SpikedBokoClub.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.SpikedBokoClub.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.SpikedBokoClub.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.SpikedBokoClub.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.SpikedBokoClub.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.SpikedBokoClub.rarity);
				}};
				lozSpikedBokoClub = new HASword("lozSpikedBokoClub", dummyMaterial, properties);
				ALL_ITEMS.add(lozSpikedBokoClub);
			}
			if (HAConfig.modifiedItems.lozmodified.BokoClub.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.lozmodified.BokoClub.damage);
					put("durability", HAConfig.modifiedItems.lozmodified.BokoClub.durability);
					put("speed", HAConfig.modifiedItems.lozmodified.BokoClub.speed);
					put("enchantability", HAConfig.modifiedItems.lozmodified.BokoClub.enchantability);
					put("rarity", HAConfig.modifiedItems.lozmodified.BokoClub.rarity);
				}};
				lozBokoClub = new HASword("lozBokoClub", dummyMaterial, properties);
				ALL_ITEMS.add(lozBokoClub);
			}
		}

//at
		if (HAConfig.includeSeries.at) {
			if (HAConfig.modifiedItems.atmodified.JakeSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.JakeSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.JakeSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.JakeSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.JakeSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.JakeSword.rarity);
				}};
				atJakeSword = new HASword("atJakeSword", dummyMaterial, properties);
				ALL_ITEMS.add(atJakeSword);
			}
			if (HAConfig.modifiedItems.atmodified.CrystalSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.CrystalSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.CrystalSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.CrystalSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.CrystalSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.CrystalSword.rarity);
				}};
				atCrystalSword = new HASword("atCrystalSword", dummyMaterial, properties);
				ALL_ITEMS.add(atCrystalSword);
			}
			if (HAConfig.modifiedItems.atmodified.Nothung.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.Nothung.damage);
					put("durability", HAConfig.modifiedItems.atmodified.Nothung.durability);
					put("speed", HAConfig.modifiedItems.atmodified.Nothung.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.Nothung.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.Nothung.rarity);
				}};
				atNothung = new HASword("atNothung", dummyMaterial, properties);
				ALL_ITEMS.add(atNothung);
			}
			if (HAConfig.modifiedItems.atmodified.FinnSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.FinnSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.FinnSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.FinnSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.FinnSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.FinnSword.rarity);
				}};
				atFinnSword = new HASword("atFinnSword", dummyMaterial, properties);
				ALL_ITEMS.add(atFinnSword);
			}
			if (HAConfig.modifiedItems.atmodified.SwordoftheDead.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.SwordoftheDead.damage);
					put("durability", HAConfig.modifiedItems.atmodified.SwordoftheDead.durability);
					put("speed", HAConfig.modifiedItems.atmodified.SwordoftheDead.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.SwordoftheDead.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.SwordoftheDead.rarity);
				}};
				atSwordoftheDead = new HASword("atSwordoftheDead", dummyMaterial, properties);
				ALL_ITEMS.add(atSwordoftheDead);
			}
			if (HAConfig.modifiedItems.atmodified.WishStarSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.WishStarSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.WishStarSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.WishStarSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.WishStarSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.WishStarSword.rarity);
				}};
				atWishStarSword = new HASword("atWishStarSword", dummyMaterial, properties);
				ALL_ITEMS.add(atWishStarSword);
			}
			if (HAConfig.modifiedItems.atmodified.FightKingSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.FightKingSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.FightKingSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.FightKingSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.FightKingSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.FightKingSword.rarity);
				}};
				atFightKingSword = new HASword("atFightKingSword", dummyMaterial, properties);
				ALL_ITEMS.add(atFightKingSword);
			}
			if (HAConfig.modifiedItems.atmodified.RootSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.RootSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.RootSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.RootSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.RootSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.RootSword.rarity);
				}};
				atRootSword = new HASword("atRootSword", dummyMaterial, properties);
				ALL_ITEMS.add(atRootSword);
			}
			if (HAConfig.modifiedItems.atmodified.Scarlet.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.Scarlet.damage);
					put("durability", HAConfig.modifiedItems.atmodified.Scarlet.durability);
					put("speed", HAConfig.modifiedItems.atmodified.Scarlet.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.Scarlet.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.Scarlet.rarity);
				}};
				atScarlet = new HASword("atScarlet", dummyMaterial, properties);
				ALL_ITEMS.add(atScarlet);
			}
			if (HAConfig.modifiedItems.atmodified.GrassSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.GrassSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.GrassSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.GrassSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.GrassSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.GrassSword.rarity);
				}};
				atGrassSword = new HASword("atGrassSword", dummyMaterial, properties);
				ALL_ITEMS.add(atGrassSword);
			}
			if (HAConfig.modifiedItems.atmodified.DemonBloodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.DemonBloodSword.damage);
					put("durability", HAConfig.modifiedItems.atmodified.DemonBloodSword.durability);
					put("speed", HAConfig.modifiedItems.atmodified.DemonBloodSword.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.DemonBloodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.DemonBloodSword.rarity);
				}};
				atDemonBloodSword = new HASword("atDemonBloodSword", dummyMaterial, properties);
				ALL_ITEMS.add(atDemonBloodSword);
			}
			if (HAConfig.modifiedItems.atmodified.AxeBass.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.atmodified.AxeBass.damage);
					put("durability", HAConfig.modifiedItems.atmodified.AxeBass.durability);
					put("speed", HAConfig.modifiedItems.atmodified.AxeBass.speed);
					put("enchantability", HAConfig.modifiedItems.atmodified.AxeBass.enchantability);
					put("rarity", HAConfig.modifiedItems.atmodified.AxeBass.rarity);
				}};
				atAxeBass = new HASword("atAxeBass", dummyMaterial, properties);
				ALL_ITEMS.add(atAxeBass);
			}
		}

//ff
		if (HAConfig.includeSeries.ff) {
			if (HAConfig.modifiedItems.ffmodified.TheMasamune.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.ffmodified.TheMasamune.damage);
					put("durability", HAConfig.modifiedItems.ffmodified.TheMasamune.durability);
					put("speed", HAConfig.modifiedItems.ffmodified.TheMasamune.speed);
					put("enchantability", HAConfig.modifiedItems.ffmodified.TheMasamune.enchantability);
					put("rarity", HAConfig.modifiedItems.ffmodified.TheMasamune.rarity);
				}};
				ffTheMasamune = new HASword("ffTheMasamune", dummyMaterial, properties);
				ALL_ITEMS.add(ffTheMasamune);
			}
			if (HAConfig.modifiedItems.ffmodified.BusterSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.ffmodified.BusterSword.damage);
					put("durability", HAConfig.modifiedItems.ffmodified.BusterSword.durability);
					put("speed", HAConfig.modifiedItems.ffmodified.BusterSword.speed);
					put("enchantability", HAConfig.modifiedItems.ffmodified.BusterSword.enchantability);
					put("rarity", HAConfig.modifiedItems.ffmodified.BusterSword.rarity);
				}};
				ffBusterSword = new HASword("ffBusterSword", dummyMaterial, properties);
				ALL_ITEMS.add(ffBusterSword);
			}
			if (HAConfig.modifiedItems.ffmodified.Caladbolg.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.ffmodified.Caladbolg.damage);
					put("durability", HAConfig.modifiedItems.ffmodified.Caladbolg.durability);
					put("speed", HAConfig.modifiedItems.ffmodified.Caladbolg.speed);
					put("enchantability", HAConfig.modifiedItems.ffmodified.Caladbolg.enchantability);
					put("rarity", HAConfig.modifiedItems.ffmodified.Caladbolg.rarity);
				}};
				ffCaladbolg = new HASword("ffCaladbolg", dummyMaterial, properties);
				ALL_ITEMS.add(ffCaladbolg);
			}
		}

//rotmg
		if (HAConfig.includeSeries.rotmg) {
			if (HAConfig.modifiedItems.rotmgmodified.SwordoftheColossus.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.SwordoftheColossus.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.SwordoftheColossus.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.SwordoftheColossus.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.SwordoftheColossus.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.SwordoftheColossus.rarity);
				}};
				rotmgSwordoftheColossus = new HASword("rotmgSwordoftheColossus", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgSwordoftheColossus);
			}
			if (HAConfig.modifiedItems.rotmgmodified.CrystalSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.CrystalSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.CrystalSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.CrystalSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.CrystalSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.CrystalSword.rarity);
				}};
				rotmgCrystalSword = new HASword("rotmgCrystalSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgCrystalSword);
			}
			if (HAConfig.modifiedItems.rotmgmodified.PixieEnchantedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.PixieEnchantedSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.PixieEnchantedSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.PixieEnchantedSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.PixieEnchantedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.PixieEnchantedSword.rarity);
				}};
				rotmgPixieEnchantedSword = new HASword("rotmgPixieEnchantedSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgPixieEnchantedSword);
			}
			if (HAConfig.modifiedItems.rotmgmodified.SwordOfAcclaim.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.SwordOfAcclaim.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.SwordOfAcclaim.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.SwordOfAcclaim.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.SwordOfAcclaim.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.SwordOfAcclaim.rarity);
				}};
				rotmgSwordOfAcclaim = new HASword("rotmgSwordOfAcclaim", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgSwordOfAcclaim);
			}
			if (HAConfig.modifiedItems.rotmgmodified.DemonBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.DemonBlade.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.DemonBlade.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.DemonBlade.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.DemonBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.DemonBlade.rarity);
				}};
				rotmgDemonBlade = new HASword("rotmgDemonBlade", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgDemonBlade);
			}
			if (HAConfig.modifiedItems.rotmgmodified.SwordoftheMadGod.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.SwordoftheMadGod.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.SwordoftheMadGod.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.SwordoftheMadGod.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.SwordoftheMadGod.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.SwordoftheMadGod.rarity);
				}};
				rotmgSwordoftheMadGod = new HASword("rotmgSwordoftheMadGod", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgSwordoftheMadGod);
			}
			if (HAConfig.modifiedItems.rotmgmodified.Indomptable.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.Indomptable.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.Indomptable.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.Indomptable.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.Indomptable.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.Indomptable.rarity);
				}};
				rotmgIndomptable = new HASword("rotmgIndomptable", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgIndomptable);
			}
			if (HAConfig.modifiedItems.rotmgmodified.PirateKingCutlass.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.PirateKingCutlass.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.PirateKingCutlass.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.PirateKingCutlass.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.PirateKingCutlass.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.PirateKingCutlass.rarity);
				}};
				rotmgPirateKingCutlass = new HASword("rotmgPirateKingCutlass", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgPirateKingCutlass);
			}
			if (HAConfig.modifiedItems.rotmgmodified.SwordofSplendor.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.SwordofSplendor.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.SwordofSplendor.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.SwordofSplendor.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.SwordofSplendor.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.SwordofSplendor.rarity);
				}};
				rotmgSwordofSplendor = new HASword("rotmgSwordofSplendor", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgSwordofSplendor);
			}
			if (HAConfig.modifiedItems.rotmgmodified.SkysplitterSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.SkysplitterSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.SkysplitterSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.SkysplitterSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.SkysplitterSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.SkysplitterSword.rarity);
				}};
				rotmgSkysplitterSword = new HASword("rotmgSkysplitterSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgSkysplitterSword);
			}
			if (HAConfig.modifiedItems.rotmgmodified.ArchonSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.ArchonSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.ArchonSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.ArchonSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.ArchonSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.ArchonSword.rarity);
				}};
				rotmgArchonSword = new HASword("rotmgArchonSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgArchonSword);
			}
			if (HAConfig.modifiedItems.rotmgmodified.AncientStoneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.AncientStoneSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.AncientStoneSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.AncientStoneSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.AncientStoneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.AncientStoneSword.rarity);
				}};
				rotmgAncientStoneSword = new HASword("rotmgAncientStoneSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgAncientStoneSword);
			}
			if (HAConfig.modifiedItems.rotmgmodified.DragonsoulSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.DragonsoulSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.DragonsoulSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.DragonsoulSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.DragonsoulSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.DragonsoulSword.rarity);
				}};
				rotmgDragonsoulSword = new HASword("rotmgDragonsoulSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgDragonsoulSword);
			}
			if (HAConfig.modifiedItems.rotmgmodified.RavenheartSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rotmgmodified.RavenheartSword.damage);
					put("durability", HAConfig.modifiedItems.rotmgmodified.RavenheartSword.durability);
					put("speed", HAConfig.modifiedItems.rotmgmodified.RavenheartSword.speed);
					put("enchantability", HAConfig.modifiedItems.rotmgmodified.RavenheartSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rotmgmodified.RavenheartSword.rarity);
				}};
				rotmgRavenheartSword = new HASword("rotmgRavenheartSword", dummyMaterial, properties);
				ALL_ITEMS.add(rotmgRavenheartSword);
			}
		}

//sc
		if (HAConfig.includeSeries.sc) {
			if (HAConfig.modifiedItems.scmodified.Firangi.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Firangi.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Firangi.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Firangi.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Firangi.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Firangi.rarity);
				}};
				scFirangi = new HASword("scFirangi", dummyMaterial, properties);
				ALL_ITEMS.add(scFirangi);
			}
			if (HAConfig.modifiedItems.scmodified.Cocytus.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Cocytus.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Cocytus.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Cocytus.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Cocytus.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Cocytus.rarity);
				}};
				scCocytus = new HASword("scCocytus", dummyMaterial, properties);
				ALL_ITEMS.add(scCocytus);
			}
			if (HAConfig.modifiedItems.scmodified.ErlangBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.ErlangBlade.damage);
					put("durability", HAConfig.modifiedItems.scmodified.ErlangBlade.durability);
					put("speed", HAConfig.modifiedItems.scmodified.ErlangBlade.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.ErlangBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.ErlangBlade.rarity);
				}};
				scErlangBlade = new HASword("scErlangBlade", dummyMaterial, properties);
				ALL_ITEMS.add(scErlangBlade);
			}
			if (HAConfig.modifiedItems.scmodified.SoulEdgeNightmare.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.SoulEdgeNightmare.damage);
					put("durability", HAConfig.modifiedItems.scmodified.SoulEdgeNightmare.durability);
					put("speed", HAConfig.modifiedItems.scmodified.SoulEdgeNightmare.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.SoulEdgeNightmare.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.SoulEdgeNightmare.rarity);
				}};
				scSoulEdgeNightmare = new HASword("scSoulEdgeNightmare", dummyMaterial, properties);
				ALL_ITEMS.add(scSoulEdgeNightmare);
			}
			if (HAConfig.modifiedItems.scmodified.Phlegathon.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Phlegathon.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Phlegathon.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Phlegathon.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Phlegathon.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Phlegathon.rarity);
				}};
				scPhlegathon = new HASword("scPhlegathon", dummyMaterial, properties);
				ALL_ITEMS.add(scPhlegathon);
			}
			if (HAConfig.modifiedItems.scmodified.Acheron.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Acheron.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Acheron.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Acheron.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Acheron.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Acheron.rarity);
				}};
				scAcheron = new HASword("scAcheron", dummyMaterial, properties);
				ALL_ITEMS.add(scAcheron);
			}
			if (HAConfig.modifiedItems.scmodified.Lethe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Lethe.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Lethe.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Lethe.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Lethe.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Lethe.rarity);
				}};
				scLethe = new HASword("scLethe", dummyMaterial, properties);
				ALL_ITEMS.add(scLethe);
			}
			if (HAConfig.modifiedItems.scmodified.QueenGuard.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.QueenGuard.damage);
					put("durability", HAConfig.modifiedItems.scmodified.QueenGuard.durability);
					put("speed", HAConfig.modifiedItems.scmodified.QueenGuard.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.QueenGuard.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.QueenGuard.rarity);
				}};
				scQueenGuard = new HASword("scQueenGuard", dummyMaterial, properties);
				ALL_ITEMS.add(scQueenGuard);
			}
			if (HAConfig.modifiedItems.scmodified.HolyAntler.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.HolyAntler.damage);
					put("durability", HAConfig.modifiedItems.scmodified.HolyAntler.durability);
					put("speed", HAConfig.modifiedItems.scmodified.HolyAntler.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.HolyAntler.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.HolyAntler.rarity);
				}};
				scHolyAntler = new HASword("scHolyAntler", dummyMaterial, properties);
				ALL_ITEMS.add(scHolyAntler);
			}
			if (HAConfig.modifiedItems.scmodified.Epee.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Epee.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Epee.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Epee.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Epee.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Epee.rarity);
				}};
				scEpee = new HASword("scEpee", dummyMaterial, properties);
				ALL_ITEMS.add(scEpee);
			}
			if (HAConfig.modifiedItems.scmodified.WarHammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.WarHammer.damage);
					put("durability", HAConfig.modifiedItems.scmodified.WarHammer.durability);
					put("speed", HAConfig.modifiedItems.scmodified.WarHammer.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.WarHammer.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.WarHammer.rarity);
				}};
				scWarHammer = new HASword("scWarHammer", dummyMaterial, properties);
				ALL_ITEMS.add(scWarHammer);
			}
			if (HAConfig.modifiedItems.scmodified.Kalutues.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Kalutues.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Kalutues.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Kalutues.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Kalutues.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Kalutues.rarity);
				}};
				scKalutues = new HASword("scKalutues", dummyMaterial, properties);
				ALL_ITEMS.add(scKalutues);
			}
			if (HAConfig.modifiedItems.scmodified.Estoc.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Estoc.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Estoc.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Estoc.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Estoc.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Estoc.rarity);
				}};
				scEstoc = new HASword("scEstoc", dummyMaterial, properties);
				ALL_ITEMS.add(scEstoc);
			}
			if (HAConfig.modifiedItems.scmodified.Flambert2P.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Flambert2P.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Flambert2P.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Flambert2P.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Flambert2P.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Flambert2P.rarity);
				}};
				scFlambert2P = new HASword("scFlambert2P", dummyMaterial, properties);
				ALL_ITEMS.add(scFlambert2P);
			}
			if (HAConfig.modifiedItems.scmodified.Reiterpallasch.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Reiterpallasch.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Reiterpallasch.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Reiterpallasch.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Reiterpallasch.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Reiterpallasch.rarity);
				}};
				scReiterpallasch = new HASword("scReiterpallasch", dummyMaterial, properties);
				ALL_ITEMS.add(scReiterpallasch);
			}
			if (HAConfig.modifiedItems.scmodified.Flambert.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Flambert.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Flambert.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Flambert.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Flambert.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Flambert.rarity);
				}};
				scFlambert = new HASword("scFlambert", dummyMaterial, properties);
				ALL_ITEMS.add(scFlambert);
			}
			if (HAConfig.modifiedItems.scmodified.BlueCrystalRod.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.BlueCrystalRod.damage);
					put("durability", HAConfig.modifiedItems.scmodified.BlueCrystalRod.durability);
					put("speed", HAConfig.modifiedItems.scmodified.BlueCrystalRod.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.BlueCrystalRod.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.BlueCrystalRod.rarity);
				}};
				scBlueCrystalRod = new HASword("scBlueCrystalRod", dummyMaterial, properties);
				ALL_ITEMS.add(scBlueCrystalRod);
			}
			if (HAConfig.modifiedItems.scmodified.FireBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.FireBlade.damage);
					put("durability", HAConfig.modifiedItems.scmodified.FireBlade.durability);
					put("speed", HAConfig.modifiedItems.scmodified.FireBlade.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.FireBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.FireBlade.rarity);
				}};
				scFireBlade = new HASword("scFireBlade", dummyMaterial, properties);
				ALL_ITEMS.add(scFireBlade);
			}
			if (HAConfig.modifiedItems.scmodified.XiSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.XiSword.damage);
					put("durability", HAConfig.modifiedItems.scmodified.XiSword.durability);
					put("speed", HAConfig.modifiedItems.scmodified.XiSword.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.XiSword.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.XiSword.rarity);
				}};
				scXiSword = new HASword("scXiSword", dummyMaterial, properties);
				ALL_ITEMS.add(scXiSword);
			}
			if (HAConfig.modifiedItems.scmodified.OmegaSword2P.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.OmegaSword2P.damage);
					put("durability", HAConfig.modifiedItems.scmodified.OmegaSword2P.durability);
					put("speed", HAConfig.modifiedItems.scmodified.OmegaSword2P.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.OmegaSword2P.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.OmegaSword2P.rarity);
				}};
				scOmegaSword2P = new HASword("scOmegaSword2P", dummyMaterial, properties);
				ALL_ITEMS.add(scOmegaSword2P);
			}
			if (HAConfig.modifiedItems.scmodified.OmegaSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.OmegaSword.damage);
					put("durability", HAConfig.modifiedItems.scmodified.OmegaSword.durability);
					put("speed", HAConfig.modifiedItems.scmodified.OmegaSword.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.OmegaSword.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.OmegaSword.rarity);
				}};
				scOmegaSword = new HASword("scOmegaSword", dummyMaterial, properties);
				ALL_ITEMS.add(scOmegaSword);
			}
			if (HAConfig.modifiedItems.scmodified.Orichalcum.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Orichalcum.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Orichalcum.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Orichalcum.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Orichalcum.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Orichalcum.rarity);
				}};
				scOrichalcum = new HASword("scOrichalcum", dummyMaterial, properties);
				ALL_ITEMS.add(scOrichalcum);
			}
			if (HAConfig.modifiedItems.scmodified.Stiletto.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Stiletto.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Stiletto.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Stiletto.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Stiletto.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Stiletto.rarity);
				}};
				scStiletto = new HASword("scStiletto", dummyMaterial, properties);
				ALL_ITEMS.add(scStiletto);
			}
			if (HAConfig.modifiedItems.scmodified.Requiem.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Requiem.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Requiem.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Requiem.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Requiem.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Requiem.rarity);
				}};
				scRequiem = new HASword("scRequiem", dummyMaterial, properties);
				ALL_ITEMS.add(scRequiem);
			}
			if (HAConfig.modifiedItems.scmodified.Faust.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Faust.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Faust.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Faust.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Faust.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Faust.rarity);
				}};
				scFaust = new HASword("scFaust", dummyMaterial, properties);
				ALL_ITEMS.add(scFaust);
			}
			if (HAConfig.modifiedItems.scmodified.Flamberge.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Flamberge.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Flamberge.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Flamberge.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Flamberge.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Flamberge.rarity);
				}};
				scFlamberge = new HASword("scFlamberge", dummyMaterial, properties);
				ALL_ITEMS.add(scFlamberge);
			}
			if (HAConfig.modifiedItems.scmodified.SteelPaddle.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.SteelPaddle.damage);
					put("durability", HAConfig.modifiedItems.scmodified.SteelPaddle.durability);
					put("speed", HAConfig.modifiedItems.scmodified.SteelPaddle.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.SteelPaddle.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.SteelPaddle.rarity);
				}};
				scSteelPaddle = new HASword("scSteelPaddle", dummyMaterial, properties);
				ALL_ITEMS.add(scSteelPaddle);
			}
			if (HAConfig.modifiedItems.scmodified.Glam.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.Glam.damage);
					put("durability", HAConfig.modifiedItems.scmodified.Glam.durability);
					put("speed", HAConfig.modifiedItems.scmodified.Glam.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.Glam.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.Glam.rarity);
				}};
				scGlam = new HASword("scGlam", dummyMaterial, properties);
				ALL_ITEMS.add(scGlam);
			}
			if (HAConfig.modifiedItems.scmodified.GreatBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.scmodified.GreatBlade.damage);
					put("durability", HAConfig.modifiedItems.scmodified.GreatBlade.durability);
					put("speed", HAConfig.modifiedItems.scmodified.GreatBlade.speed);
					put("enchantability", HAConfig.modifiedItems.scmodified.GreatBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.scmodified.GreatBlade.rarity);
				}};
				scGreatBlade = new HASword("scGreatBlade", dummyMaterial, properties);
				ALL_ITEMS.add(scGreatBlade);
			}
		}

//rs
		if (HAConfig.includeSeries.rs) {
			if (HAConfig.modifiedItems.rsmodified.BronzeSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BronzeSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BronzeSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BronzeSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BronzeSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BronzeSword.rarity);
				}};
				rsBronzeSword = new HASword("rsBronzeSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsBronzeSword);
			}
			if (HAConfig.modifiedItems.rsmodified.IronSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.IronSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.IronSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.IronSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.IronSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.IronSword.rarity);
				}};
				rsIronSword = new HASword("rsIronSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsIronSword);
			}
			if (HAConfig.modifiedItems.rsmodified.WhiteSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.WhiteSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.WhiteSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.WhiteSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.WhiteSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.WhiteSword.rarity);
				}};
				rsWhiteSword = new HASword("rsWhiteSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsWhiteSword);
			}
			if (HAConfig.modifiedItems.rsmodified.BlackSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BlackSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BlackSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BlackSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BlackSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BlackSword.rarity);
				}};
				rsBlackSword = new HASword("rsBlackSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsBlackSword);
			}
			if (HAConfig.modifiedItems.rsmodified.SteelSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.SteelSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.SteelSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.SteelSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.SteelSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.SteelSword.rarity);
				}};
				rsSteelSword = new HASword("rsSteelSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsSteelSword);
			}
			if (HAConfig.modifiedItems.rsmodified.MithrilSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.MithrilSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.MithrilSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.MithrilSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.MithrilSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.MithrilSword.rarity);
				}};
				rsMithrilSword = new HASword("rsMithrilSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsMithrilSword);
			}
			if (HAConfig.modifiedItems.rsmodified.AdamantSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.AdamantSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.AdamantSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.AdamantSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.AdamantSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.AdamantSword.rarity);
				}};
				rsAdamantSword = new HASword("rsAdamantSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsAdamantSword);
			}
			if (HAConfig.modifiedItems.rsmodified.RuneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.RuneSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.RuneSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.RuneSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.RuneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.RuneSword.rarity);
				}};
				rsRuneSword = new HASword("rsRuneSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsRuneSword);
			}
			if (HAConfig.modifiedItems.rsmodified.DragonSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.DragonSword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.DragonSword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.DragonSword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.DragonSword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.DragonSword.rarity);
				}};
				rsDragonSword = new HASword("rsDragonSword", dummyMaterial, properties);
				ALL_ITEMS.add(rsDragonSword);
			}
			if (HAConfig.modifiedItems.rsmodified.BronzeBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BronzeBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BronzeBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BronzeBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BronzeBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BronzeBattleaxe.rarity);
				}};
				rsBronzeBattleaxe = new HASword("rsBronzeBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsBronzeBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.IronBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.IronBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.IronBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.IronBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.IronBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.IronBattleaxe.rarity);
				}};
				rsIronBattleaxe = new HASword("rsIronBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsIronBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.SteelBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.SteelBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.SteelBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.SteelBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.SteelBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.SteelBattleaxe.rarity);
				}};
				rsSteelBattleaxe = new HASword("rsSteelBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsSteelBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.BlackBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BlackBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BlackBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BlackBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BlackBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BlackBattleaxe.rarity);
				}};
				rsBlackBattleaxe = new HASword("rsBlackBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsBlackBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.WhiteBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.WhiteBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.WhiteBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.WhiteBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.WhiteBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.WhiteBattleaxe.rarity);
				}};
				rsWhiteBattleaxe = new HASword("rsWhiteBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsWhiteBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.MithrilBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.MithrilBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.MithrilBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.MithrilBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.MithrilBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.MithrilBattleaxe.rarity);
				}};
				rsMithrilBattleaxe = new HASword("rsMithrilBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsMithrilBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.AdamantBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.AdamantBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.AdamantBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.AdamantBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.AdamantBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.AdamantBattleaxe.rarity);
				}};
				rsAdamantBattleaxe = new HASword("rsAdamantBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsAdamantBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.RuneBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.RuneBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.RuneBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.RuneBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.RuneBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.RuneBattleaxe.rarity);
				}};
				rsRuneBattleaxe = new HASword("rsRuneBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsRuneBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.DragonBattleaxe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.DragonBattleaxe.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.DragonBattleaxe.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.DragonBattleaxe.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.DragonBattleaxe.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.DragonBattleaxe.rarity);
				}};
				rsDragonBattleaxe = new HASword("rsDragonBattleaxe", dummyMaterial, properties);
				ALL_ITEMS.add(rsDragonBattleaxe);
			}
			if (HAConfig.modifiedItems.rsmodified.BronzeScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BronzeScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BronzeScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BronzeScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BronzeScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BronzeScimitar.rarity);
				}};
				rsBronzeScimitar = new HASword("rsBronzeScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsBronzeScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.IronScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.IronScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.IronScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.IronScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.IronScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.IronScimitar.rarity);
				}};
				rsIronScimitar = new HASword("rsIronScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsIronScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.BlackScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BlackScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BlackScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BlackScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BlackScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BlackScimitar.rarity);
				}};
				rsBlackScimitar = new HASword("rsBlackScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsBlackScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.WhiteScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.WhiteScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.WhiteScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.WhiteScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.WhiteScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.WhiteScimitar.rarity);
				}};
				rsWhiteScimitar = new HASword("rsWhiteScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsWhiteScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.SteelScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.SteelScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.SteelScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.SteelScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.SteelScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.SteelScimitar.rarity);
				}};
				rsSteelScimitar = new HASword("rsSteelScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsSteelScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.MithrilScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.MithrilScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.MithrilScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.MithrilScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.MithrilScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.MithrilScimitar.rarity);
				}};
				rsMithrilScimitar = new HASword("rsMithrilScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsMithrilScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.AdamantScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.AdamantScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.AdamantScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.AdamantScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.AdamantScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.AdamantScimitar.rarity);
				}};
				rsAdamantScimitar = new HASword("rsAdamantScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsAdamantScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.RuneScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.RuneScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.RuneScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.RuneScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.RuneScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.RuneScimitar.rarity);
				}};
				rsRuneScimitar = new HASword("rsRuneScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsRuneScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.DragonScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.DragonScimitar.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.DragonScimitar.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.DragonScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.DragonScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.DragonScimitar.rarity);
				}};
				rsDragonScimitar = new HASword("rsDragonScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(rsDragonScimitar);
			}
			if (HAConfig.modifiedItems.rsmodified.BronzeWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BronzeWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BronzeWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BronzeWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BronzeWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BronzeWarhammer.rarity);
				}};
				rsBronzeWarhammer = new HASword("rsBronzeWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsBronzeWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.IronWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.IronWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.IronWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.IronWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.IronWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.IronWarhammer.rarity);
				}};
				rsIronWarhammer = new HASword("rsIronWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsIronWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.SteelWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.SteelWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.SteelWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.SteelWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.SteelWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.SteelWarhammer.rarity);
				}};
				rsSteelWarhammer = new HASword("rsSteelWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsSteelWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.BlackWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BlackWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BlackWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BlackWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BlackWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BlackWarhammer.rarity);
				}};
				rsBlackWarhammer = new HASword("rsBlackWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsBlackWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.WhiteWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.WhiteWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.WhiteWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.WhiteWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.WhiteWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.WhiteWarhammer.rarity);
				}};
				rsWhiteWarhammer = new HASword("rsWhiteWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsWhiteWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.MithrilWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.MithrilWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.MithrilWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.MithrilWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.MithrilWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.MithrilWarhammer.rarity);
				}};
				rsMithrilWarhammer = new HASword("rsMithrilWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsMithrilWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.AdamantWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.AdamantWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.AdamantWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.AdamantWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.AdamantWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.AdamantWarhammer.rarity);
				}};
				rsAdamantWarhammer = new HASword("rsAdamantWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsAdamantWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.RuneWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.RuneWarhammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.RuneWarhammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.RuneWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.RuneWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.RuneWarhammer.rarity);
				}};
				rsRuneWarhammer = new HASword("rsRuneWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsRuneWarhammer);
			}
			if (HAConfig.modifiedItems.rsmodified.BronzeMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BronzeMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BronzeMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BronzeMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BronzeMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BronzeMace.rarity);
				}};
				rsBronzeMace = new HASword("rsBronzeMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsBronzeMace);
			}
			if (HAConfig.modifiedItems.rsmodified.IronMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.IronMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.IronMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.IronMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.IronMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.IronMace.rarity);
				}};
				rsIronMace = new HASword("rsIronMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsIronMace);
			}
			if (HAConfig.modifiedItems.rsmodified.SteelMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.SteelMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.SteelMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.SteelMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.SteelMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.SteelMace.rarity);
				}};
				rsSteelMace = new HASword("rsSteelMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsSteelMace);
			}
			if (HAConfig.modifiedItems.rsmodified.BlackMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BlackMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BlackMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BlackMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BlackMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BlackMace.rarity);
				}};
				rsBlackMace = new HASword("rsBlackMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsBlackMace);
			}
			if (HAConfig.modifiedItems.rsmodified.WhiteMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.WhiteMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.WhiteMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.WhiteMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.WhiteMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.WhiteMace.rarity);
				}};
				rsWhiteMace = new HASword("rsWhiteMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsWhiteMace);
			}
			if (HAConfig.modifiedItems.rsmodified.MithrilMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.MithrilMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.MithrilMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.MithrilMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.MithrilMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.MithrilMace.rarity);
				}};
				rsMithrilMace = new HASword("rsMithrilMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsMithrilMace);
			}
			if (HAConfig.modifiedItems.rsmodified.AdamantMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.AdamantMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.AdamantMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.AdamantMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.AdamantMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.AdamantMace.rarity);
				}};
				rsAdamantMace = new HASword("rsAdamantMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsAdamantMace);
			}
			if (HAConfig.modifiedItems.rsmodified.RuneMace.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.RuneMace.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.RuneMace.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.RuneMace.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.RuneMace.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.RuneMace.rarity);
				}};
				rsRuneMace = new HASword("rsRuneMace", dummyMaterial, properties);
				ALL_ITEMS.add(rsRuneMace);
			}
			if (HAConfig.modifiedItems.rsmodified.GraniteLongsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.GraniteLongsword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.GraniteLongsword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.GraniteLongsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.GraniteLongsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.GraniteLongsword.rarity);
				}};
				rsGraniteLongsword = new HASword("rsGraniteLongsword", dummyMaterial, properties);
				ALL_ITEMS.add(rsGraniteLongsword);
			}
			if (HAConfig.modifiedItems.rsmodified.GraniteHammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.GraniteHammer.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.GraniteHammer.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.GraniteHammer.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.GraniteHammer.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.GraniteHammer.rarity);
				}};
				rsGraniteHammer = new HASword("rsGraniteHammer", dummyMaterial, properties);
				ALL_ITEMS.add(rsGraniteHammer);
			}
			if (HAConfig.modifiedItems.rsmodified.GraniteMaul.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.GraniteMaul.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.GraniteMaul.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.GraniteMaul.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.GraniteMaul.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.GraniteMaul.rarity);
				}};
				rsGraniteMaul = new HASword("rsGraniteMaul", dummyMaterial, properties);
				ALL_ITEMS.add(rsGraniteMaul);
			}
			if (HAConfig.modifiedItems.rsmodified.ElderMaul.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.ElderMaul.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.ElderMaul.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.ElderMaul.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.ElderMaul.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.ElderMaul.rarity);
				}};
				rsElderMaul = new HASword("rsElderMaul", dummyMaterial, properties);
				ALL_ITEMS.add(rsElderMaul);
			}
			if (HAConfig.modifiedItems.rsmodified.Toktzxilak.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.Toktzxilak.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.Toktzxilak.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.Toktzxilak.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.Toktzxilak.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.Toktzxilak.rarity);
				}};
				rsToktzxilak = new HASword("rsToktzxilak", dummyMaterial, properties);
				ALL_ITEMS.add(rsToktzxilak);
			}
			if (HAConfig.modifiedItems.rsmodified.Wolfsbane.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.Wolfsbane.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.Wolfsbane.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.Wolfsbane.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.Wolfsbane.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.Wolfsbane.rarity);
				}};
				rsWolfsbane = new HASword("rsWolfsbane", dummyMaterial, properties);
				ALL_ITEMS.add(rsWolfsbane);
			}
			if (HAConfig.modifiedItems.rsmodified.ZamorakGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.ZamorakGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.ZamorakGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.ZamorakGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.ZamorakGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.ZamorakGodsword.rarity);
				}};
				rsZamorakGodsword = new HASword("rsZamorakGodsword", dummyMaterial, properties);
				ALL_ITEMS.add(rsZamorakGodsword);
			}
			if (HAConfig.modifiedItems.rsmodified.BandosGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BandosGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BandosGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BandosGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BandosGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BandosGodsword.rarity);
				}};
				rsBandosGodsword = new HASword("rsBandosGodsword", dummyMaterial, properties);
				ALL_ITEMS.add(rsBandosGodsword);
			}
			if (HAConfig.modifiedItems.rsmodified.ArmadylGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.ArmadylGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.ArmadylGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.ArmadylGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.ArmadylGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.ArmadylGodsword.rarity);
				}};
				rsArmadylGodsword = new HASword("rsArmadylGodsword", dummyMaterial, properties);
				ALL_ITEMS.add(rsArmadylGodsword);
			}
			if (HAConfig.modifiedItems.rsmodified.SaradominGodsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.SaradominGodsword.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.SaradominGodsword.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.SaradominGodsword.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.SaradominGodsword.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.SaradominGodsword.rarity);
				}};
				rsSaradominGodsword = new HASword("rsSaradominGodsword", dummyMaterial, properties);
				ALL_ITEMS.add(rsSaradominGodsword);
			}
			if (HAConfig.modifiedItems.rsmodified.BarrelchestAnchor.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.rsmodified.BarrelchestAnchor.damage);
					put("durability", HAConfig.modifiedItems.rsmodified.BarrelchestAnchor.durability);
					put("speed", HAConfig.modifiedItems.rsmodified.BarrelchestAnchor.speed);
					put("enchantability", HAConfig.modifiedItems.rsmodified.BarrelchestAnchor.enchantability);
					put("rarity", HAConfig.modifiedItems.rsmodified.BarrelchestAnchor.rarity);
				}};
				rsBarrelchestAnchor = new HASword("rsBarrelchestAnchor", dummyMaterial, properties);
				ALL_ITEMS.add(rsBarrelchestAnchor);
			}
		}

//dmc
		if (HAConfig.includeSeries.dmc) {
			if (HAConfig.modifiedItems.dmcmodified.RedQueen.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dmcmodified.RedQueen.damage);
					put("durability", HAConfig.modifiedItems.dmcmodified.RedQueen.durability);
					put("speed", HAConfig.modifiedItems.dmcmodified.RedQueen.speed);
					put("enchantability", HAConfig.modifiedItems.dmcmodified.RedQueen.enchantability);
					put("rarity", HAConfig.modifiedItems.dmcmodified.RedQueen.rarity);
				}};
				dmcRedQueen = new HASword("dmcRedQueen", dummyMaterial, properties);
				ALL_ITEMS.add(dmcRedQueen);
			}
			if (HAConfig.modifiedItems.dmcmodified.Rebellion.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dmcmodified.Rebellion.damage);
					put("durability", HAConfig.modifiedItems.dmcmodified.Rebellion.durability);
					put("speed", HAConfig.modifiedItems.dmcmodified.Rebellion.speed);
					put("enchantability", HAConfig.modifiedItems.dmcmodified.Rebellion.enchantability);
					put("rarity", HAConfig.modifiedItems.dmcmodified.Rebellion.rarity);
				}};
				dmcRebellion = new HASword("dmcRebellion", dummyMaterial, properties);
				ALL_ITEMS.add(dmcRebellion);
			}
			if (HAConfig.modifiedItems.dmcmodified.Yamato.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dmcmodified.Yamato.damage);
					put("durability", HAConfig.modifiedItems.dmcmodified.Yamato.durability);
					put("speed", HAConfig.modifiedItems.dmcmodified.Yamato.speed);
					put("enchantability", HAConfig.modifiedItems.dmcmodified.Yamato.enchantability);
					put("rarity", HAConfig.modifiedItems.dmcmodified.Yamato.rarity);
				}};
				dmcYamato = new HASword("dmcYamato", dummyMaterial, properties);
				ALL_ITEMS.add(dmcYamato);
			}
		}

//pkmn
		if (HAConfig.includeSeries.pkmn) {
			if (HAConfig.modifiedItems.pkmnmodified.HonedgeShiny.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.pkmnmodified.HonedgeShiny.damage);
					put("durability", HAConfig.modifiedItems.pkmnmodified.HonedgeShiny.durability);
					put("speed", HAConfig.modifiedItems.pkmnmodified.HonedgeShiny.speed);
					put("enchantability", HAConfig.modifiedItems.pkmnmodified.HonedgeShiny.enchantability);
					put("rarity", HAConfig.modifiedItems.pkmnmodified.HonedgeShiny.rarity);
				}};
				pkmnHonedgeShiny = new HASword("pkmnHonedgeShiny", dummyMaterial, properties);
				ALL_ITEMS.add(pkmnHonedgeShiny);
			}
			if (HAConfig.modifiedItems.pkmnmodified.Honedge.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.pkmnmodified.Honedge.damage);
					put("durability", HAConfig.modifiedItems.pkmnmodified.Honedge.durability);
					put("speed", HAConfig.modifiedItems.pkmnmodified.Honedge.speed);
					put("enchantability", HAConfig.modifiedItems.pkmnmodified.Honedge.enchantability);
					put("rarity", HAConfig.modifiedItems.pkmnmodified.Honedge.rarity);
				}};
				pkmnHonedge = new HASword("pkmnHonedge", dummyMaterial, properties);
				ALL_ITEMS.add(pkmnHonedge);
			}
		}

//kirby
		if (HAConfig.includeSeries.kirby) {
			if (HAConfig.modifiedItems.kirbymodified.Galaxia.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.kirbymodified.Galaxia.damage);
					put("durability", HAConfig.modifiedItems.kirbymodified.Galaxia.durability);
					put("speed", HAConfig.modifiedItems.kirbymodified.Galaxia.speed);
					put("enchantability", HAConfig.modifiedItems.kirbymodified.Galaxia.enchantability);
					put("rarity", HAConfig.modifiedItems.kirbymodified.Galaxia.rarity);
				}};
				kirbyGalaxia = new HASword("kirbyGalaxia", dummyMaterial, properties);
				ALL_ITEMS.add(kirbyGalaxia);
			}
			if (HAConfig.modifiedItems.kirbymodified.KirbyUltraSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.kirbymodified.KirbyUltraSword.damage);
					put("durability", HAConfig.modifiedItems.kirbymodified.KirbyUltraSword.durability);
					put("speed", HAConfig.modifiedItems.kirbymodified.KirbyUltraSword.speed);
					put("enchantability", HAConfig.modifiedItems.kirbymodified.KirbyUltraSword.enchantability);
					put("rarity", HAConfig.modifiedItems.kirbymodified.KirbyUltraSword.rarity);
				}};
				kirbyKirbyUltraSword = new HASword("kirbyKirbyUltraSword", dummyMaterial, properties);
				ALL_ITEMS.add(kirbyKirbyUltraSword);
			}
			if (HAConfig.modifiedItems.kirbymodified.KirbySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.kirbymodified.KirbySword.damage);
					put("durability", HAConfig.modifiedItems.kirbymodified.KirbySword.durability);
					put("speed", HAConfig.modifiedItems.kirbymodified.KirbySword.speed);
					put("enchantability", HAConfig.modifiedItems.kirbymodified.KirbySword.enchantability);
					put("rarity", HAConfig.modifiedItems.kirbymodified.KirbySword.rarity);
				}};
				kirbyKirbySword = new HASword("kirbyKirbySword", dummyMaterial, properties);
				ALL_ITEMS.add(kirbyKirbySword);
			}
		}

//fe
		if (HAConfig.includeSeries.fe) {
			if (HAConfig.modifiedItems.femodified.ChromFalchion.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.femodified.ChromFalchion.damage);
					put("durability", HAConfig.modifiedItems.femodified.ChromFalchion.durability);
					put("speed", HAConfig.modifiedItems.femodified.ChromFalchion.speed);
					put("enchantability", HAConfig.modifiedItems.femodified.ChromFalchion.enchantability);
					put("rarity", HAConfig.modifiedItems.femodified.ChromFalchion.rarity);
				}};
				feChromFalchion = new HASword("feChromFalchion", dummyMaterial, properties);
				ALL_ITEMS.add(feChromFalchion);
			}
			if (HAConfig.modifiedItems.femodified.Falchion.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.femodified.Falchion.damage);
					put("durability", HAConfig.modifiedItems.femodified.Falchion.durability);
					put("speed", HAConfig.modifiedItems.femodified.Falchion.speed);
					put("enchantability", HAConfig.modifiedItems.femodified.Falchion.enchantability);
					put("rarity", HAConfig.modifiedItems.femodified.Falchion.rarity);
				}};
				feFalchion = new HASword("feFalchion", dummyMaterial, properties);
				ALL_ITEMS.add(feFalchion);
			}
		}

//kh
		if (HAConfig.includeSeries.kh) {
			if (HAConfig.modifiedItems.khmodified.Keyblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.khmodified.Keyblade.damage);
					put("durability", HAConfig.modifiedItems.khmodified.Keyblade.durability);
					put("speed", HAConfig.modifiedItems.khmodified.Keyblade.speed);
					put("enchantability", HAConfig.modifiedItems.khmodified.Keyblade.enchantability);
					put("rarity", HAConfig.modifiedItems.khmodified.Keyblade.rarity);
				}};
				khKeyblade = new HASword("khKeyblade", dummyMaterial, properties);
				ALL_ITEMS.add(khKeyblade);
			}
		}

//bleach
		if (HAConfig.includeSeries.bleach) {
			if (HAConfig.modifiedItems.bleachmodified.Zabimaru.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bleachmodified.Zabimaru.damage);
					put("durability", HAConfig.modifiedItems.bleachmodified.Zabimaru.durability);
					put("speed", HAConfig.modifiedItems.bleachmodified.Zabimaru.speed);
					put("enchantability", HAConfig.modifiedItems.bleachmodified.Zabimaru.enchantability);
					put("rarity", HAConfig.modifiedItems.bleachmodified.Zabimaru.rarity);
				}};
				bleachZabimaru = new HASword("bleachZabimaru", dummyMaterial, properties);
				ALL_ITEMS.add(bleachZabimaru);
			}
			if (HAConfig.modifiedItems.bleachmodified.Zangetsu.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bleachmodified.Zangetsu.damage);
					put("durability", HAConfig.modifiedItems.bleachmodified.Zangetsu.durability);
					put("speed", HAConfig.modifiedItems.bleachmodified.Zangetsu.speed);
					put("enchantability", HAConfig.modifiedItems.bleachmodified.Zangetsu.enchantability);
					put("rarity", HAConfig.modifiedItems.bleachmodified.Zangetsu.rarity);
				}};
				bleachZangetsu = new HASword("bleachZangetsu", dummyMaterial, properties);
				ALL_ITEMS.add(bleachZangetsu);
			}
		}

//ds
		if (HAConfig.includeSeries.ds) {
			if (HAConfig.modifiedItems.dsmodified.GreatswordofArtorias.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsmodified.GreatswordofArtorias.damage);
					put("durability", HAConfig.modifiedItems.dsmodified.GreatswordofArtorias.durability);
					put("speed", HAConfig.modifiedItems.dsmodified.GreatswordofArtorias.speed);
					put("enchantability", HAConfig.modifiedItems.dsmodified.GreatswordofArtorias.enchantability);
					put("rarity", HAConfig.modifiedItems.dsmodified.GreatswordofArtorias.rarity);
				}};
				dsGreatswordofArtorias = new HASword("dsGreatswordofArtorias", dummyMaterial, properties);
				ALL_ITEMS.add(dsGreatswordofArtorias);
			}
			if (HAConfig.modifiedItems.dsmodified.GreatLordGreatsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsmodified.GreatLordGreatsword.damage);
					put("durability", HAConfig.modifiedItems.dsmodified.GreatLordGreatsword.durability);
					put("speed", HAConfig.modifiedItems.dsmodified.GreatLordGreatsword.speed);
					put("enchantability", HAConfig.modifiedItems.dsmodified.GreatLordGreatsword.enchantability);
					put("rarity", HAConfig.modifiedItems.dsmodified.GreatLordGreatsword.rarity);
				}};
				dsGreatLordGreatsword = new HASword("dsGreatLordGreatsword", dummyMaterial, properties);
				ALL_ITEMS.add(dsGreatLordGreatsword);
			}
			if (HAConfig.modifiedItems.dsmodified.AstoraGreatsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsmodified.AstoraGreatsword.damage);
					put("durability", HAConfig.modifiedItems.dsmodified.AstoraGreatsword.durability);
					put("speed", HAConfig.modifiedItems.dsmodified.AstoraGreatsword.speed);
					put("enchantability", HAConfig.modifiedItems.dsmodified.AstoraGreatsword.enchantability);
					put("rarity", HAConfig.modifiedItems.dsmodified.AstoraGreatsword.rarity);
				}};
				dsAstoraGreatsword = new HASword("dsAstoraGreatsword", dummyMaterial, properties);
				ALL_ITEMS.add(dsAstoraGreatsword);
			}
			if (HAConfig.modifiedItems.dsmodified.Zweilhander.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.dsmodified.Zweilhander.damage);
					put("durability", HAConfig.modifiedItems.dsmodified.Zweilhander.durability);
					put("speed", HAConfig.modifiedItems.dsmodified.Zweilhander.speed);
					put("enchantability", HAConfig.modifiedItems.dsmodified.Zweilhander.enchantability);
					put("rarity", HAConfig.modifiedItems.dsmodified.Zweilhander.rarity);
				}};
				dsZweilhander = new HASword("dsZweilhander", dummyMaterial, properties);
				ALL_ITEMS.add(dsZweilhander);
			}
		}

//myth
		if (HAConfig.includeSeries.myth) {
			if (HAConfig.modifiedItems.mythmodified.DeathScythe.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mythmodified.DeathScythe.damage);
					put("durability", HAConfig.modifiedItems.mythmodified.DeathScythe.durability);
					put("speed", HAConfig.modifiedItems.mythmodified.DeathScythe.speed);
					put("enchantability", HAConfig.modifiedItems.mythmodified.DeathScythe.enchantability);
					put("rarity", HAConfig.modifiedItems.mythmodified.DeathScythe.rarity);
				}};
				mythDeathScythe = new HASword("mythDeathScythe", dummyMaterial, properties);
				ALL_ITEMS.add(mythDeathScythe);
			}
			if (HAConfig.modifiedItems.mythmodified.TheDevilPitchfork.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mythmodified.TheDevilPitchfork.damage);
					put("durability", HAConfig.modifiedItems.mythmodified.TheDevilPitchfork.durability);
					put("speed", HAConfig.modifiedItems.mythmodified.TheDevilPitchfork.speed);
					put("enchantability", HAConfig.modifiedItems.mythmodified.TheDevilPitchfork.enchantability);
					put("rarity", HAConfig.modifiedItems.mythmodified.TheDevilPitchfork.rarity);
				}};
				mythTheDevilPitchfork = new HASword("mythTheDevilPitchfork", dummyMaterial, properties);
				ALL_ITEMS.add(mythTheDevilPitchfork);
			}
		}

//bayonetta
		if (HAConfig.includeSeries.bayonetta) {
			if (HAConfig.modifiedItems.bayonettamodified.Shuraba.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bayonettamodified.Shuraba.damage);
					put("durability", HAConfig.modifiedItems.bayonettamodified.Shuraba.durability);
					put("speed", HAConfig.modifiedItems.bayonettamodified.Shuraba.speed);
					put("enchantability", HAConfig.modifiedItems.bayonettamodified.Shuraba.enchantability);
					put("rarity", HAConfig.modifiedItems.bayonettamodified.Shuraba.rarity);
				}};
				bayonettaShuraba = new HASword("bayonettaShuraba", dummyMaterial, properties);
				ALL_ITEMS.add(bayonettaShuraba);
			}
			if (HAConfig.modifiedItems.bayonettamodified.AngelSlayer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.bayonettamodified.AngelSlayer.damage);
					put("durability", HAConfig.modifiedItems.bayonettamodified.AngelSlayer.durability);
					put("speed", HAConfig.modifiedItems.bayonettamodified.AngelSlayer.speed);
					put("enchantability", HAConfig.modifiedItems.bayonettamodified.AngelSlayer.enchantability);
					put("rarity", HAConfig.modifiedItems.bayonettamodified.AngelSlayer.rarity);
				}};
				bayonettaAngelSlayer = new HASword("bayonettaAngelSlayer", dummyMaterial, properties);
				ALL_ITEMS.add(bayonettaAngelSlayer);
			}
		}

//gow
		if (HAConfig.includeSeries.gow) {
			if (HAConfig.modifiedItems.gowmodified.LeviathanUpgraded.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowmodified.LeviathanUpgraded.damage);
					put("durability", HAConfig.modifiedItems.gowmodified.LeviathanUpgraded.durability);
					put("speed", HAConfig.modifiedItems.gowmodified.LeviathanUpgraded.speed);
					put("enchantability", HAConfig.modifiedItems.gowmodified.LeviathanUpgraded.enchantability);
					put("rarity", HAConfig.modifiedItems.gowmodified.LeviathanUpgraded.rarity);
				}};
				gowLeviathanUpgraded = new HASword("gowLeviathanUpgraded", dummyMaterial, properties);
				ALL_ITEMS.add(gowLeviathanUpgraded);
			}
			if (HAConfig.modifiedItems.gowmodified.Leviathan.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowmodified.Leviathan.damage);
					put("durability", HAConfig.modifiedItems.gowmodified.Leviathan.durability);
					put("speed", HAConfig.modifiedItems.gowmodified.Leviathan.speed);
					put("enchantability", HAConfig.modifiedItems.gowmodified.Leviathan.enchantability);
					put("rarity", HAConfig.modifiedItems.gowmodified.Leviathan.rarity);
				}};
				gowLeviathan = new HASword("gowLeviathan", dummyMaterial, properties);
				ALL_ITEMS.add(gowLeviathan);
			}
			if (HAConfig.modifiedItems.gowmodified.BladeofOlympus.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowmodified.BladeofOlympus.damage);
					put("durability", HAConfig.modifiedItems.gowmodified.BladeofOlympus.durability);
					put("speed", HAConfig.modifiedItems.gowmodified.BladeofOlympus.speed);
					put("enchantability", HAConfig.modifiedItems.gowmodified.BladeofOlympus.enchantability);
					put("rarity", HAConfig.modifiedItems.gowmodified.BladeofOlympus.rarity);
				}};
				gowBladeofOlympus = new HASword("gowBladeofOlympus", dummyMaterial, properties);
				ALL_ITEMS.add(gowBladeofOlympus);
			}
			if (HAConfig.modifiedItems.gowmodified.BladeofChaos.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.gowmodified.BladeofChaos.damage);
					put("durability", HAConfig.modifiedItems.gowmodified.BladeofChaos.durability);
					put("speed", HAConfig.modifiedItems.gowmodified.BladeofChaos.speed);
					put("enchantability", HAConfig.modifiedItems.gowmodified.BladeofChaos.enchantability);
					put("rarity", HAConfig.modifiedItems.gowmodified.BladeofChaos.rarity);
				}};
				gowBladeofChaos = new HASword("gowBladeofChaos", dummyMaterial, properties);
				ALL_ITEMS.add(gowBladeofChaos);
			}
		}

//skyrim
		if (HAConfig.includeSeries.skyrim) {
			if (HAConfig.modifiedItems.skyrimmodified.IronSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.IronSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.IronSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.IronSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.IronSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.IronSword.rarity);
				}};
				skyrimIronSword = new HASword("skyrimIronSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimIronSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.IronWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.IronWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.IronWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.IronWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.IronWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.IronWarhammer.rarity);
				}};
				skyrimIronWarhammer = new HASword("skyrimIronWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimIronWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.SteelSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.SteelSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.SteelSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.SteelSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.SteelSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.SteelSword.rarity);
				}};
				skyrimSteelSword = new HASword("skyrimSteelSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimSteelSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.SteelWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.SteelWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.SteelWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.SteelWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.SteelWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.SteelWarhammer.rarity);
				}};
				skyrimSteelWarhammer = new HASword("skyrimSteelWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimSteelWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.OrcishSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.OrcishSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.OrcishSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.OrcishSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.OrcishSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.OrcishSword.rarity);
				}};
				skyrimOrcishSword = new HASword("skyrimOrcishSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimOrcishSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.OrcishWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.OrcishWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.OrcishWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.OrcishWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.OrcishWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.OrcishWarhammer.rarity);
				}};
				skyrimOrcishWarhammer = new HASword("skyrimOrcishWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimOrcishWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.DwarvenSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.DwarvenSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.DwarvenSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.DwarvenSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.DwarvenSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.DwarvenSword.rarity);
				}};
				skyrimDwarvenSword = new HASword("skyrimDwarvenSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDwarvenSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.DwarvenWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.DwarvenWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.DwarvenWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.DwarvenWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.DwarvenWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.DwarvenWarhammer.rarity);
				}};
				skyrimDwarvenWarhammer = new HASword("skyrimDwarvenWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDwarvenWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.ElvenSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.ElvenSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.ElvenSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.ElvenSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.ElvenSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.ElvenSword.rarity);
				}};
				skyrimElvenSword = new HASword("skyrimElvenSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimElvenSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.ElvenWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.ElvenWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.ElvenWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.ElvenWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.ElvenWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.ElvenWarhammer.rarity);
				}};
				skyrimElvenWarhammer = new HASword("skyrimElvenWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimElvenWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.GlassSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.GlassSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.GlassSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.GlassSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.GlassSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.GlassSword.rarity);
				}};
				skyrimGlassSword = new HASword("skyrimGlassSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimGlassSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.GlassWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.GlassWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.GlassWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.GlassWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.GlassWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.GlassWarhammer.rarity);
				}};
				skyrimGlassWarhammer = new HASword("skyrimGlassWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimGlassWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.EbonySword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.EbonySword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.EbonySword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.EbonySword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.EbonySword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.EbonySword.rarity);
				}};
				skyrimEbonySword = new HASword("skyrimEbonySword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimEbonySword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.EbonyWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.EbonyWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.EbonyWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.EbonyWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.EbonyWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.EbonyWarhammer.rarity);
				}};
				skyrimEbonyWarhammer = new HASword("skyrimEbonyWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimEbonyWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.DaedricSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.DaedricSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.DaedricSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.DaedricSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.DaedricSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.DaedricSword.rarity);
				}};
				skyrimDaedricSword = new HASword("skyrimDaedricSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDaedricSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.DaedricWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.DaedricWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.DaedricWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.DaedricWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.DaedricWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.DaedricWarhammer.rarity);
				}};
				skyrimDaedricWarhammer = new HASword("skyrimDaedricWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDaedricWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.DragonboneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.DragonboneSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.DragonboneSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.DragonboneSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.DragonboneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.DragonboneSword.rarity);
				}};
				skyrimDragonboneSword = new HASword("skyrimDragonboneSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDragonboneSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.DragonboneWarhammer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.DragonboneWarhammer.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.DragonboneWarhammer.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.DragonboneWarhammer.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.DragonboneWarhammer.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.DragonboneWarhammer.rarity);
				}};
				skyrimDragonboneWarhammer = new HASword("skyrimDragonboneWarhammer", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDragonboneWarhammer);
			}
			if (HAConfig.modifiedItems.skyrimmodified.ImperialSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.ImperialSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.ImperialSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.ImperialSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.ImperialSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.ImperialSword.rarity);
				}};
				skyrimImperialSword = new HASword("skyrimImperialSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimImperialSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.Dawnbreaker.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.Dawnbreaker.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.Dawnbreaker.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.Dawnbreaker.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.Dawnbreaker.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.Dawnbreaker.rarity);
				}};
				skyrimDawnbreaker = new HASword("skyrimDawnbreaker", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimDawnbreaker);
			}
			if (HAConfig.modifiedItems.skyrimmodified.AncientNordSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.AncientNordSword.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.AncientNordSword.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.AncientNordSword.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.AncientNordSword.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.AncientNordSword.rarity);
				}};
				skyrimAncientNordSword = new HASword("skyrimAncientNordSword", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimAncientNordSword);
			}
			if (HAConfig.modifiedItems.skyrimmodified.Chillrend.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.Chillrend.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.Chillrend.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.Chillrend.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.Chillrend.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.Chillrend.rarity);
				}};
				skyrimChillrend = new HASword("skyrimChillrend", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimChillrend);
			}
			if (HAConfig.modifiedItems.skyrimmodified.EbonyBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.skyrimmodified.EbonyBlade.damage);
					put("durability", HAConfig.modifiedItems.skyrimmodified.EbonyBlade.durability);
					put("speed", HAConfig.modifiedItems.skyrimmodified.EbonyBlade.speed);
					put("enchantability", HAConfig.modifiedItems.skyrimmodified.EbonyBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.skyrimmodified.EbonyBlade.rarity);
				}};
				skyrimEbonyBlade = new HASword("skyrimEbonyBlade", dummyMaterial, properties);
				ALL_ITEMS.add(skyrimEbonyBlade);
			}
		}

//mh
		if (HAConfig.includeSeries.mh) {
			if (HAConfig.modifiedItems.mhmodified.ChickenDecapitator.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.ChickenDecapitator.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.ChickenDecapitator.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.ChickenDecapitator.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.ChickenDecapitator.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.ChickenDecapitator.rarity);
				}};
				mhChickenDecapitator = new HASword("mhChickenDecapitator", dummyMaterial, properties);
				ALL_ITEMS.add(mhChickenDecapitator);
			}
			if (HAConfig.modifiedItems.mhmodified.GolemBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.GolemBlade.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.GolemBlade.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.GolemBlade.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.GolemBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.GolemBlade.rarity);
				}};
				mhGolemBlade = new HASword("mhGolemBlade", dummyMaterial, properties);
				ALL_ITEMS.add(mhGolemBlade);
			}
			if (HAConfig.modifiedItems.mhmodified.Defender.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.Defender.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.Defender.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.Defender.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.Defender.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.Defender.rarity);
				}};
				mhDefender = new HASword("mhDefender", dummyMaterial, properties);
				ALL_ITEMS.add(mhDefender);
			}
			if (HAConfig.modifiedItems.mhmodified.BlackBeltBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.BlackBeltBlade.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.BlackBeltBlade.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.BlackBeltBlade.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.BlackBeltBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.BlackBeltBlade.rarity);
				}};
				mhBlackBeltBlade = new HASword("mhBlackBeltBlade", dummyMaterial, properties);
				ALL_ITEMS.add(mhBlackBeltBlade);
			}
			if (HAConfig.modifiedItems.mhmodified.WailingCleaver.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.WailingCleaver.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.WailingCleaver.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.WailingCleaver.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.WailingCleaver.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.WailingCleaver.rarity);
				}};
				mhWailingCleaver = new HASword("mhWailingCleaver", dummyMaterial, properties);
				ALL_ITEMS.add(mhWailingCleaver);
			}
			if (HAConfig.modifiedItems.mhmodified.GaelicFlame.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.GaelicFlame.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.GaelicFlame.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.GaelicFlame.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.GaelicFlame.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.GaelicFlame.rarity);
				}};
				mhGaelicFlame = new HASword("mhGaelicFlame", dummyMaterial, properties);
				ALL_ITEMS.add(mhGaelicFlame);
			}
			if (HAConfig.modifiedItems.mhmodified.BoneKatana.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.BoneKatana.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.BoneKatana.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.BoneKatana.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.BoneKatana.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.BoneKatana.rarity);
				}};
				mhBoneKatana = new HASword("mhBoneKatana", dummyMaterial, properties);
				ALL_ITEMS.add(mhBoneKatana);
			}
			if (HAConfig.modifiedItems.mhmodified.HellishSlasher.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.HellishSlasher.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.HellishSlasher.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.HellishSlasher.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.HellishSlasher.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.HellishSlasher.rarity);
				}};
				mhHellishSlasher = new HASword("mhHellishSlasher", dummyMaterial, properties);
				ALL_ITEMS.add(mhHellishSlasher);
			}
			if (HAConfig.modifiedItems.mhmodified.CentenarianDagger.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.CentenarianDagger.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.CentenarianDagger.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.CentenarianDagger.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.CentenarianDagger.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.CentenarianDagger.rarity);
				}};
				mhCentenarianDagger = new HASword("mhCentenarianDagger", dummyMaterial, properties);
				ALL_ITEMS.add(mhCentenarianDagger);
			}
			if (HAConfig.modifiedItems.mhmodified.WyvernBladeBlood.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.WyvernBladeBlood.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.WyvernBladeBlood.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.WyvernBladeBlood.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.WyvernBladeBlood.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.WyvernBladeBlood.rarity);
				}};
				mhWyvernBladeBlood = new HASword("mhWyvernBladeBlood", dummyMaterial, properties);
				ALL_ITEMS.add(mhWyvernBladeBlood);
			}
			if (HAConfig.modifiedItems.mhmodified.WyvernBladeHolly.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.WyvernBladeHolly.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.WyvernBladeHolly.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.WyvernBladeHolly.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.WyvernBladeHolly.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.WyvernBladeHolly.rarity);
				}};
				mhWyvernBladeHolly = new HASword("mhWyvernBladeHolly", dummyMaterial, properties);
				ALL_ITEMS.add(mhWyvernBladeHolly);
			}
			if (HAConfig.modifiedItems.mhmodified.WyvernBladePale.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.WyvernBladePale.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.WyvernBladePale.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.WyvernBladePale.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.WyvernBladePale.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.WyvernBladePale.rarity);
				}};
				mhWyvernBladePale = new HASword("mhWyvernBladePale", dummyMaterial, properties);
				ALL_ITEMS.add(mhWyvernBladePale);
			}
			if (HAConfig.modifiedItems.mhmodified.WyvernBladeAzure.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.WyvernBladeAzure.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.WyvernBladeAzure.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.WyvernBladeAzure.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.WyvernBladeAzure.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.WyvernBladeAzure.rarity);
				}};
				mhWyvernBladeAzure = new HASword("mhWyvernBladeAzure", dummyMaterial, properties);
				ALL_ITEMS.add(mhWyvernBladeAzure);
			}
			if (HAConfig.modifiedItems.mhmodified.WyvernBladeLeaf.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.WyvernBladeLeaf.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.WyvernBladeLeaf.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.WyvernBladeLeaf.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.WyvernBladeLeaf.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.WyvernBladeLeaf.rarity);
				}};
				mhWyvernBladeLeaf = new HASword("mhWyvernBladeLeaf", dummyMaterial, properties);
				ALL_ITEMS.add(mhWyvernBladeLeaf);
			}
			if (HAConfig.modifiedItems.mhmodified.RathalosFlamesword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.mhmodified.RathalosFlamesword.damage);
					put("durability", HAConfig.modifiedItems.mhmodified.RathalosFlamesword.durability);
					put("speed", HAConfig.modifiedItems.mhmodified.RathalosFlamesword.speed);
					put("enchantability", HAConfig.modifiedItems.mhmodified.RathalosFlamesword.enchantability);
					put("rarity", HAConfig.modifiedItems.mhmodified.RathalosFlamesword.rarity);
				}};
				mhRathalosFlamesword = new HASword("mhRathalosFlamesword", dummyMaterial, properties);
				ALL_ITEMS.add(mhRathalosFlamesword);
			}
		}

//terraria
		if (HAConfig.includeSeries.terraria) {
			if (HAConfig.modifiedItems.terrariamodified.PalmWoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.PalmWoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.PalmWoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.PalmWoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.PalmWoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.PalmWoodSword.rarity);
				}};
				terrariaPalmWoodSword = new HASword("terrariaPalmWoodSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaPalmWoodSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.BorealWoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.BorealWoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.BorealWoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.BorealWoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.BorealWoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.BorealWoodSword.rarity);
				}};
				terrariaBorealWoodSword = new HASword("terrariaBorealWoodSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaBorealWoodSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.ShadewoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.ShadewoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.ShadewoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.ShadewoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.ShadewoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.ShadewoodSword.rarity);
				}};
				terrariaShadewoodSword = new HASword("terrariaShadewoodSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaShadewoodSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.EbonwoodSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.EbonwoodSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.EbonwoodSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.EbonwoodSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.EbonwoodSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.EbonwoodSword.rarity);
				}};
				terrariaEbonwoodSword = new HASword("terrariaEbonwoodSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaEbonwoodSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.CopperShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.CopperShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.CopperShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.CopperShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.CopperShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.CopperShortsword.rarity);
				}};
				terrariaCopperShortsword = new HASword("terrariaCopperShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaCopperShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.CopperBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.CopperBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.CopperBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.CopperBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.CopperBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.CopperBroadsword.rarity);
				}};
				terrariaCopperBroadsword = new HASword("terrariaCopperBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaCopperBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.TinShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.TinShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.TinShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.TinShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.TinShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.TinShortsword.rarity);
				}};
				terrariaTinShortsword = new HASword("terrariaTinShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaTinShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.TinBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.TinBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.TinBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.TinBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.TinBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.TinBroadsword.rarity);
				}};
				terrariaTinBroadsword = new HASword("terrariaTinBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaTinBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.LeadShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.LeadShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.LeadShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.LeadShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.LeadShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.LeadShortsword.rarity);
				}};
				terrariaLeadShortsword = new HASword("terrariaLeadShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaLeadShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.LeadBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.LeadBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.LeadBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.LeadBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.LeadBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.LeadBroadsword.rarity);
				}};
				terrariaLeadBroadsword = new HASword("terrariaLeadBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaLeadBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.Spear.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Spear.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Spear.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Spear.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Spear.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Spear.rarity);
				}};
				terrariaSpear = new HASword("terrariaSpear", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaSpear);
			}
			if (HAConfig.modifiedItems.terrariamodified.IronShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.IronShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.IronShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.IronShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.IronShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.IronShortsword.rarity);
				}};
				terrariaIronShortsword = new HASword("terrariaIronShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaIronShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.IronBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.IronBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.IronBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.IronBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.IronBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.IronBroadsword.rarity);
				}};
				terrariaIronBroadsword = new HASword("terrariaIronBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaIronBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.SilverBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.SilverBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.SilverBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.SilverBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.SilverBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.SilverBroadsword.rarity);
				}};
				terrariaSilverBroadsword = new HASword("terrariaSilverBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaSilverBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.SilverShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.SilverShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.SilverShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.SilverShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.SilverShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.SilverShortsword.rarity);
				}};
				terrariaSilverShortsword = new HASword("terrariaSilverShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaSilverShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.GoldShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.GoldShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.GoldShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.GoldShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.GoldShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.GoldShortsword.rarity);
				}};
				terrariaGoldShortsword = new HASword("terrariaGoldShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaGoldShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.GoldBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.GoldBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.GoldBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.GoldBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.GoldBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.GoldBroadsword.rarity);
				}};
				terrariaGoldBroadsword = new HASword("terrariaGoldBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaGoldBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.TungstenBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.TungstenBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.TungstenBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.TungstenBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.TungstenBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.TungstenBroadsword.rarity);
				}};
				terrariaTungstenBroadsword = new HASword("terrariaTungstenBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaTungstenBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.TungstenShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.TungstenShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.TungstenShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.TungstenShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.TungstenShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.TungstenShortsword.rarity);
				}};
				terrariaTungstenShortsword = new HASword("terrariaTungstenShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaTungstenShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.PlatinumShortsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.PlatinumShortsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.PlatinumShortsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.PlatinumShortsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.PlatinumShortsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.PlatinumShortsword.rarity);
				}};
				terrariaPlatinumShortsword = new HASword("terrariaPlatinumShortsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaPlatinumShortsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.PlatinumBroadsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.PlatinumBroadsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.PlatinumBroadsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.PlatinumBroadsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.PlatinumBroadsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.PlatinumBroadsword.rarity);
				}};
				terrariaPlatinumBroadsword = new HASword("terrariaPlatinumBroadsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaPlatinumBroadsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.MandibleBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.MandibleBlade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.MandibleBlade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.MandibleBlade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.MandibleBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.MandibleBlade.rarity);
				}};
				terrariaMandibleBlade = new HASword("terrariaMandibleBlade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaMandibleBlade);
			}
			if (HAConfig.modifiedItems.terrariamodified.Katana.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Katana.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Katana.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Katana.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Katana.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Katana.rarity);
				}};
				terrariaKatana = new HASword("terrariaKatana", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaKatana);
			}
			if (HAConfig.modifiedItems.terrariamodified.ExoticScimitar.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.ExoticScimitar.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.ExoticScimitar.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.ExoticScimitar.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.ExoticScimitar.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.ExoticScimitar.rarity);
				}};
				terrariaExoticScimitar = new HASword("terrariaExoticScimitar", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaExoticScimitar);
			}
			if (HAConfig.modifiedItems.terrariamodified.Muramasa.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Muramasa.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Muramasa.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Muramasa.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Muramasa.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Muramasa.rarity);
				}};
				terrariaMuramasa = new HASword("terrariaMuramasa", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaMuramasa);
			}
			if (HAConfig.modifiedItems.terrariamodified.FalconBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.FalconBlade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.FalconBlade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.FalconBlade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.FalconBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.FalconBlade.rarity);
				}};
				terrariaFalconBlade = new HASword("terrariaFalconBlade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaFalconBlade);
			}
			if (HAConfig.modifiedItems.terrariamodified.BladeofGrass.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.BladeofGrass.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.BladeofGrass.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.BladeofGrass.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.BladeofGrass.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.BladeofGrass.rarity);
				}};
				terrariaBladeofGrass = new HASword("terrariaBladeofGrass", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaBladeofGrass);
			}
			if (HAConfig.modifiedItems.terrariamodified.FieryGreatsword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.FieryGreatsword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.FieryGreatsword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.FieryGreatsword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.FieryGreatsword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.FieryGreatsword.rarity);
				}};
				terrariaFieryGreatsword = new HASword("terrariaFieryGreatsword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaFieryGreatsword);
			}
			if (HAConfig.modifiedItems.terrariamodified.BoneSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.BoneSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.BoneSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.BoneSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.BoneSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.BoneSword.rarity);
				}};
				terrariaBoneSword = new HASword("terrariaBoneSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaBoneSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.BloodButcherer.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.BloodButcherer.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.BloodButcherer.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.BloodButcherer.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.BloodButcherer.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.BloodButcherer.rarity);
				}};
				terrariaBloodButcherer = new HASword("terrariaBloodButcherer", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaBloodButcherer);
			}
			if (HAConfig.modifiedItems.terrariamodified.EnchantedSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.EnchantedSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.EnchantedSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.EnchantedSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.EnchantedSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.EnchantedSword.rarity);
				}};
				terrariaEnchantedSword = new HASword("terrariaEnchantedSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaEnchantedSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.Starfury.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Starfury.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Starfury.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Starfury.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Starfury.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Starfury.rarity);
				}};
				terrariaStarfury = new HASword("terrariaStarfury", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaStarfury);
			}
			if (HAConfig.modifiedItems.terrariamodified.BeeKeeper.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.BeeKeeper.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.BeeKeeper.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.BeeKeeper.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.BeeKeeper.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.BeeKeeper.rarity);
				}};
				terrariaBeeKeeper = new HASword("terrariaBeeKeeper", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaBeeKeeper);
			}
			if (HAConfig.modifiedItems.terrariamodified.IceBlade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.IceBlade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.IceBlade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.IceBlade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.IceBlade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.IceBlade.rarity);
				}};
				terrariaIceBlade = new HASword("terrariaIceBlade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaIceBlade);
			}
			if (HAConfig.modifiedItems.terrariamodified.NightEdge.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.NightEdge.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.NightEdge.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.NightEdge.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.NightEdge.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.NightEdge.rarity);
				}};
				terrariaNightEdge = new HASword("terrariaNightEdge", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaNightEdge);
			}
			if (HAConfig.modifiedItems.terrariamodified.Arkhalis.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Arkhalis.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Arkhalis.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Arkhalis.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Arkhalis.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Arkhalis.rarity);
				}};
				terrariaArkhalis = new HASword("terrariaArkhalis", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaArkhalis);
			}
			if (HAConfig.modifiedItems.terrariamodified.Trident.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Trident.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Trident.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Trident.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Trident.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Trident.rarity);
				}};
				terrariaTrident = new HASword("terrariaTrident", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaTrident);
			}
			if (HAConfig.modifiedItems.terrariamodified.TheRottedFork.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.TheRottedFork.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.TheRottedFork.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.TheRottedFork.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.TheRottedFork.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.TheRottedFork.rarity);
				}};
				terrariaTheRottedFork = new HASword("terrariaTheRottedFork", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaTheRottedFork);
			}
			if (HAConfig.modifiedItems.terrariamodified.WhitePhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.WhitePhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.WhitePhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.WhitePhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.WhitePhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.WhitePhaseblade.rarity);
				}};
				terrariaWhitePhaseblade = new HASword("terrariaWhitePhaseblade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaWhitePhaseblade);
			}
			if (HAConfig.modifiedItems.terrariamodified.YellowPhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.YellowPhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.YellowPhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.YellowPhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.YellowPhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.YellowPhaseblade.rarity);
				}};
				terrariaYellowPhaseblade = new HASword("terrariaYellowPhaseblade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaYellowPhaseblade);
			}
			if (HAConfig.modifiedItems.terrariamodified.PurplePhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.PurplePhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.PurplePhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.PurplePhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.PurplePhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.PurplePhaseblade.rarity);
				}};
				terrariaPurplePhaseblade = new HASword("terrariaPurplePhaseblade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaPurplePhaseblade);
			}
			if (HAConfig.modifiedItems.terrariamodified.GreenPhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.GreenPhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.GreenPhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.GreenPhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.GreenPhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.GreenPhaseblade.rarity);
				}};
				terrariaGreenPhaseblade = new HASword("terrariaGreenPhaseblade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaGreenPhaseblade);
			}
			if (HAConfig.modifiedItems.terrariamodified.RedPhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.RedPhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.RedPhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.RedPhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.RedPhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.RedPhaseblade.rarity);
				}};
				terrariaRedPhaseblade = new HASword("terrariaRedPhaseblade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaRedPhaseblade);
			}
			if (HAConfig.modifiedItems.terrariamodified.BluePhaseblade.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.BluePhaseblade.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.BluePhaseblade.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.BluePhaseblade.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.BluePhaseblade.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.BluePhaseblade.rarity);
				}};
				terrariaBluePhaseblade = new HASword("terrariaBluePhaseblade", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaBluePhaseblade);
			}
			if (HAConfig.modifiedItems.terrariamodified.LightBane.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.LightBane.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.LightBane.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.LightBane.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.LightBane.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.LightBane.rarity);
				}};
				terrariaLightBane = new HASword("terrariaLightBane", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaLightBane);
			}
			if (HAConfig.modifiedItems.terrariamodified.DarkLance.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.DarkLance.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.DarkLance.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.DarkLance.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.DarkLance.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.DarkLance.rarity);
				}};
				terrariaDarkLance = new HASword("terrariaDarkLance", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaDarkLance);
			}
			if (HAConfig.modifiedItems.terrariamodified.PurpleClubberfish.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.PurpleClubberfish.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.PurpleClubberfish.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.PurpleClubberfish.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.PurpleClubberfish.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.PurpleClubberfish.rarity);
				}};
				terrariaPurpleClubberfish = new HASword("terrariaPurpleClubberfish", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaPurpleClubberfish);
			}
			if (HAConfig.modifiedItems.terrariamodified.CactusSword.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.CactusSword.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.CactusSword.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.CactusSword.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.CactusSword.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.CactusSword.rarity);
				}};
				terrariaCactusSword = new HASword("terrariaCactusSword", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaCactusSword);
			}
			if (HAConfig.modifiedItems.terrariamodified.Swordfish.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.terrariamodified.Swordfish.damage);
					put("durability", HAConfig.modifiedItems.terrariamodified.Swordfish.durability);
					put("speed", HAConfig.modifiedItems.terrariamodified.Swordfish.speed);
					put("enchantability", HAConfig.modifiedItems.terrariamodified.Swordfish.enchantability);
					put("rarity", HAConfig.modifiedItems.terrariamodified.Swordfish.rarity);
				}};
				terrariaSwordfish = new HASword("terrariaSwordfish", dummyMaterial, properties);
				ALL_ITEMS.add(terrariaSwordfish);
			}
		}

//sw
		if (HAConfig.includeSeries.sw) {
			if (HAConfig.modifiedItems.swmodified.YellowLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.YellowLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.YellowLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.YellowLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.YellowLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.YellowLightsaber.rarity);
				}};
				swYellowLightsaber = new HASword("swYellowLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swYellowLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.GreenLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.GreenLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.GreenLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.GreenLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.GreenLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.GreenLightsaber.rarity);
				}};
				swGreenLightsaber = new HASword("swGreenLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swGreenLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.BlueLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.BlueLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.BlueLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.BlueLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.BlueLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.BlueLightsaber.rarity);
				}};
				swBlueLightsaber = new HASword("swBlueLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swBlueLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.RedLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.RedLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.RedLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.RedLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.RedLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.RedLightsaber.rarity);
				}};
				swRedLightsaber = new HASword("swRedLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swRedLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.MaceWinduLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.MaceWinduLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.MaceWinduLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.MaceWinduLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.MaceWinduLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.MaceWinduLightsaber.rarity);
				}};
				swMaceWinduLightsaber = new HASword("swMaceWinduLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swMaceWinduLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.TheInquisitorLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.TheInquisitorLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.TheInquisitorLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.TheInquisitorLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.TheInquisitorLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.TheInquisitorLightsaber.rarity);
				}};
				swTheInquisitorLightsaber = new HASword("swTheInquisitorLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swTheInquisitorLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.DarthMaulLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.DarthMaulLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.DarthMaulLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.DarthMaulLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.DarthMaulLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.DarthMaulLightsaber.rarity);
				}};
				swDarthMaulLightsaber = new HASword("swDarthMaulLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swDarthMaulLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.QuiGonJinnLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.QuiGonJinnLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.QuiGonJinnLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.QuiGonJinnLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.QuiGonJinnLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.QuiGonJinnLightsaber.rarity);
				}};
				swQuiGonJinnLightsaber = new HASword("swQuiGonJinnLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swQuiGonJinnLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.KyloRenLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.KyloRenLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.KyloRenLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.KyloRenLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.KyloRenLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.KyloRenLightsaber.rarity);
				}};
				swKyloRenLightsaber = new HASword("swKyloRenLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swKyloRenLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.CountDookuLightsaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.CountDookuLightsaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.CountDookuLightsaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.CountDookuLightsaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.CountDookuLightsaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.CountDookuLightsaber.rarity);
				}};
				swCountDookuLightsaber = new HASword("swCountDookuLightsaber", dummyMaterial, properties);
				ALL_ITEMS.add(swCountDookuLightsaber);
			}
			if (HAConfig.modifiedItems.swmodified.Darksaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.swmodified.Darksaber.damage);
					put("durability", HAConfig.modifiedItems.swmodified.Darksaber.durability);
					put("speed", HAConfig.modifiedItems.swmodified.Darksaber.speed);
					put("enchantability", HAConfig.modifiedItems.swmodified.Darksaber.enchantability);
					put("rarity", HAConfig.modifiedItems.swmodified.Darksaber.rarity);
				}};
				swDarksaber = new HASword("swDarksaber", dummyMaterial, properties);
				ALL_ITEMS.add(swDarksaber);
			}
		}

//internet
		if (HAConfig.includeSeries.internet) {
			if (HAConfig.modifiedItems.internetmodified.DemonoidPitchfork.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.internetmodified.DemonoidPitchfork.damage);
					put("durability", HAConfig.modifiedItems.internetmodified.DemonoidPitchfork.durability);
					put("speed", HAConfig.modifiedItems.internetmodified.DemonoidPitchfork.speed);
					put("enchantability", HAConfig.modifiedItems.internetmodified.DemonoidPitchfork.enchantability);
					put("rarity", HAConfig.modifiedItems.internetmodified.DemonoidPitchfork.rarity);
				}};
				internetDemonoidPitchfork = new HASword("internetDemonoidPitchfork", dummyMaterial, properties);
				ALL_ITEMS.add(internetDemonoidPitchfork);
			}
		}

//nh
		if (HAConfig.includeSeries.nh) {
			if (HAConfig.modifiedItems.nhmodified.Magicbane.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhmodified.Magicbane.damage);
					put("durability", HAConfig.modifiedItems.nhmodified.Magicbane.durability);
					put("speed", HAConfig.modifiedItems.nhmodified.Magicbane.speed);
					put("enchantability", HAConfig.modifiedItems.nhmodified.Magicbane.enchantability);
					put("rarity", HAConfig.modifiedItems.nhmodified.Magicbane.rarity);
				}};
				nhMagicbane = new HASword("nhMagicbane", dummyMaterial, properties);
				ALL_ITEMS.add(nhMagicbane);
			}
			if (HAConfig.modifiedItems.nhmodified.Athame.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhmodified.Athame.damage);
					put("durability", HAConfig.modifiedItems.nhmodified.Athame.durability);
					put("speed", HAConfig.modifiedItems.nhmodified.Athame.speed);
					put("enchantability", HAConfig.modifiedItems.nhmodified.Athame.enchantability);
					put("rarity", HAConfig.modifiedItems.nhmodified.Athame.rarity);
				}};
				nhAthame = new HASword("nhAthame", dummyMaterial, properties);
				ALL_ITEMS.add(nhAthame);
			}
			if (HAConfig.modifiedItems.nhmodified.Grayswandir.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhmodified.Grayswandir.damage);
					put("durability", HAConfig.modifiedItems.nhmodified.Grayswandir.durability);
					put("speed", HAConfig.modifiedItems.nhmodified.Grayswandir.speed);
					put("enchantability", HAConfig.modifiedItems.nhmodified.Grayswandir.enchantability);
					put("rarity", HAConfig.modifiedItems.nhmodified.Grayswandir.rarity);
				}};
				nhGrayswandir = new HASword("nhGrayswandir", dummyMaterial, properties);
				ALL_ITEMS.add(nhGrayswandir);
			}
			if (HAConfig.modifiedItems.nhmodified.SilverSaber.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.nhmodified.SilverSaber.damage);
					put("durability", HAConfig.modifiedItems.nhmodified.SilverSaber.durability);
					put("speed", HAConfig.modifiedItems.nhmodified.SilverSaber.speed);
					put("enchantability", HAConfig.modifiedItems.nhmodified.SilverSaber.enchantability);
					put("rarity", HAConfig.modifiedItems.nhmodified.SilverSaber.rarity);
				}};
				nhSilverSaber = new HASword("nhSilverSaber", dummyMaterial, properties);
				ALL_ITEMS.add(nhSilverSaber);
			}
		}

//abcm
		if (HAConfig.includeSeries.abcm) {
			if (HAConfig.modifiedItems.abcmmodified.Excalibur.enabled) {
				HashMap<String, Object> properties = new HashMap<String, Object>() {{
					put("attack", HAConfig.modifiedItems.abcmmodified.Excalibur.damage);
					put("durability", HAConfig.modifiedItems.abcmmodified.Excalibur.durability);
					put("speed", HAConfig.modifiedItems.abcmmodified.Excalibur.speed);
					put("enchantability", HAConfig.modifiedItems.abcmmodified.Excalibur.enchantability);
					put("rarity", HAConfig.modifiedItems.abcmmodified.Excalibur.rarity);
				}};
				abcmExcalibur = new HASword("abcmExcalibur", dummyMaterial, properties);
				ALL_ITEMS.add(abcmExcalibur);
			}
		}

		if (ALL_ITEMS != null) {
			Iterator<Item> itemList = ALL_ITEMS.listIterator();
			Item item;
			while (itemList.hasNext()) {
				item = itemList.next();
				System.out.println("Registering HW item: " + item.getUnlocalizedName());
				event.getRegistry().register(item);
			}
		}

		//Loot Tables
		LootTableList.register(new ResourceLocation("heroicarmory", "loot"));
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		if (ALL_ITEMS != null){
			Iterator<Item> itemList = ALL_ITEMS.listIterator();
			Item item;
			while (itemList.hasNext()) {
				item = itemList.next();
				if (item.getRegistryName() != null) {
					System.out.println("Registering model for: " + item.getUnlocalizedName() + " / " + item.getRegistryName());
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

				ArrayList<LootEntryItem> entries = new ArrayList<LootEntryItem>();

				if (ALL_ITEMS != null) {
					Iterator<Item> itemList = ALL_ITEMS.listIterator();
					Item item;
					while (itemList.hasNext()) {
						item = itemList.next();
						System.out.println("Adding " + item.getRegistryName() + " to loot tables");
						entries.add(new LootEntryItem(item, (int) Math.ceil(Math.pow(((HASword) item).getLootRarity(), HAConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:" + item.getRegistryName()));
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