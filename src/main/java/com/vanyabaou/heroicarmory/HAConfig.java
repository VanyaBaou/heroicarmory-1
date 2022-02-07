package com.vanyabaou.heroicarmory;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.RequiresWorldRestart;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = HeroicArmory.MOD_ID)
@Config.LangKey("heroicarmory.config.title")
public class HAConfig {

    //INCLUDE===========================================================================================================

	@Comment("Whether to generate items in chests added by mods. WARNING: This may cause duplicates in vanilla chests, so you may want to lower the loot chance.")
	@Name("Include mod chests")
	@RequiresWorldRestart
	public static boolean includeModChests = false;

    //SCALE=============================================================================================================

    @Name("Scale Rarity")
	@Comment("This number exponentially multiplies how rare weapons are to each other (0 means all are equal, 3 means rare weapons are extremely rare)")
	@RangeDouble(min = 0, max = 3)
	@RequiresWorldRestart
	public static double rarityScale = 1;

    @Name("Scale Loot Chance")
	@Comment("This is the percentage chance that you will find an item in each chest. Set to 0 to prevent adding to loot tables.")
	@RangeDouble(min = 0, max = 1)
	@RequiresWorldRestart
	public static double lootChance = 0.75;

	//DISABLE BY SERIES===================================================================================================

	@Name("Repair Material")
	@Comment("This is the oreDict used to repair items (Optional)")
	@RequiresWorldRestart
	public static String repairDict = "gemDiamond";

	@Name("Spartan Weaponry Support")
	@Comment("This allows weapons to have weapon properties from Spartan Weaponry, if loaded.")
	@RequiresWorldRestart
	public static boolean spartanWeaponrySupport = true;

    //DISABLE BY SERIES===================================================================================================

	@Comment("Disable items by their source series")
	@RequiresMcRestart
	@Name("Disable By Series")
	public static final InculdeSeries includeSeries = new InculdeSeries();

	public static class InculdeSeries {

		
		@Name("Include Lord of the Rings")
		@Comment("Include all Lord of the Rings items from drop tables / creative mode")
		public boolean lotr = true;

		@Name("Include Legend of Zelda")
		@Comment("Include all Legend of Zelda items from drop tables / creative mode")
		public boolean loz = true;

		@Name("Include Adventure Time")
		@Comment("Include all Adventure Time items from drop tables / creative mode")
		public boolean at = true;

		@Name("Include Final Fantasy")
		@Comment("Include all Final Fantasy items from drop tables / creative mode")
		public boolean ff = true;

		@Name("Include Realm of the Mad God")
		@Comment("Include all Realm of the Mad God items from drop tables / creative mode")
		public boolean rotmg = true;

		@Name("Include Soul Calibur")
		@Comment("Include all Soul Calibur items from drop tables / creative mode")
		public boolean sc = true;

		@Name("Include Runescape")
		@Comment("Include all Runescape items from drop tables / creative mode")
		public boolean rs = true;

		@Name("Include Devil May Cry")
		@Comment("Include all Devil May Cry items from drop tables / creative mode")
		public boolean dmc = true;

		@Name("Include Pokemon")
		@Comment("Include all Pokemon items from drop tables / creative mode")
		public boolean pkmn = true;

		@Name("Include Kirby")
		@Comment("Include all Kirby items from drop tables / creative mode")
		public boolean kirby = true;

		@Name("Include Fire Emblem")
		@Comment("Include all Fire Emblem items from drop tables / creative mode")
		public boolean fe = true;

		@Name("Include Kingdom Hearts")
		@Comment("Include all Kingdom Hearts items from drop tables / creative mode")
		public boolean kh = true;

		@Name("Include Bleach")
		@Comment("Include all Bleach items from drop tables / creative mode")
		public boolean bleach = true;

		@Name("Include Dark Souls")
		@Comment("Include all Dark Souls items from drop tables / creative mode")
		public boolean ds = true;

		@Name("Include Mythology")
		@Comment("Include all Mythology items from drop tables / creative mode")
		public boolean myth = true;

		@Name("Include Bayonetta")
		@Comment("Include all Bayonetta items from drop tables / creative mode")
		public boolean bayonetta = true;

		@Name("Include God of War")
		@Comment("Include all God of War items from drop tables / creative mode")
		public boolean gow = true;

		@Name("Include Skyrim")
		@Comment("Include all Skyrim items from drop tables / creative mode")
		public boolean skyrim = true;

		@Name("Include Monster Hunter")
		@Comment("Include all Monster Hunter items from drop tables / creative mode")
		public boolean mh = true;

		@Name("Include Terraria")
		@Comment("Include all Terraria items from drop tables / creative mode")
		public boolean terraria = true;

		@Name("Include Star Wars")
		@Comment("Include all Star Wars items from drop tables / creative mode")
		public boolean sw = true;

		@Name("Include Internet")
		@Comment("Include all Internet items from drop tables / creative mode")
		public boolean internet = true;

		@Name("Include Nethack")
		@Comment("Include all Nethack items from drop tables / creative mode")
		public boolean nh = true;

		@Name("Include Merlin (ABC)")
		@Comment("Include all Merlin (ABC) items from drop tables / creative mode")
		public boolean abcm = true;

	}

	//MODIFY INDIVIDUAL================================================================================================

	@Comment("Modify stats for one item at a time")
	@RequiresMcRestart
	@Name("Modify Individual Items")
	public static final ModifiedItems modifiedItems = new ModifiedItems();

	public static class ModifiedItems {


		@Name("Lord of the Rings")
		public final lotrModified lotrmodified = new lotrModified();
		public static class lotrModified {

			@Name("Gimli's Battle Axe")
			public final GimliBattleAxe GimliBattleAxe = new GimliBattleAxe();
			public static class GimliBattleAxe {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 4100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Gimli's Long Axe")
			public final GimliLongAxe GimliLongAxe = new GimliLongAxe();
			public static class GimliLongAxe {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 3600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Morgul Blade")
			public final MorgulBlade MorgulBlade = new MorgulBlade();
			public static class MorgulBlade {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Sting")
			public final Sting Sting = new Sting();
			public static class Sting {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 2100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 28;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Glamdring")
			public final Glamdring Glamdring = new Glamdring();
			public static class Glamdring {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 30;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Anduril")
			public final Anduril Anduril = new Anduril();
			public static class Anduril {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Narsil")
			public final Narsil Narsil = new Narsil();
			public static class Narsil {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Sauron's Mace")
			public final SauronMace SauronMace = new SauronMace();
			public static class SauronMace {
				@Name("Damage")
				public float damage = 14;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 1;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Witch King's Sword")
			public final WitchKingSword WitchKingSword = new WitchKingSword();
			public static class WitchKingSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Legend of Zelda")
		public final lozModified lozmodified = new lozModified();
		public static class lozModified {

			@Name("Master Sword")
			public final MasterSword MasterSword = new MasterSword();
			public static class MasterSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Master Sword II")
			public final MasterSwordII MasterSwordII = new MasterSwordII();
			public static class MasterSwordII {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 4500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Tempered Sword")
			public final TemperedSword TemperedSword = new TemperedSword();
			public static class TemperedSword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 4500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Master Sword III")
			public final MasterSwordIII MasterSwordIII = new MasterSwordIII();
			public static class MasterSwordIII {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 7000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Golden Sword")
			public final GoldenSword GoldenSword = new GoldenSword();
			public static class GoldenSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 7000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Flameblade")
			public final Flameblade Flameblade = new Flameblade();
			public static class Flameblade {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 14;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Darknut Sword")
			public final DarknutSwordTp DarknutSwordTp = new DarknutSwordTp();
			public static class DarknutSwordTp {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ghirahim Sword")
			public final GhirahimSword GhirahimSword = new GhirahimSword();
			public static class GhirahimSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Fierce Deity's Sword")
			public final FierceDeitySword FierceDeitySword = new FierceDeitySword();
			public static class FierceDeitySword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 20;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Zelda's Sword")
			public final ZeldaSword ZeldaSword = new ZeldaSword();
			public static class ZeldaSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Boko Stick")
			public final BokoStick BokoStick = new BokoStick();
			public static class BokoStick {
				@Name("Damage")
				public float damage = 4;
				@Name("Durability")
				public int durability = 150;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 20;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Cane of Byrna")
			public final CaneofByrna CaneofByrna = new CaneofByrna();
			public static class CaneofByrna {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Megaton Hammer")
			public final MegatonHammer MegatonHammer = new MegatonHammer();
			public static class MegatonHammer {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Kokiri Sword MM")
			public final KokiriSwordMm KokiriSwordMm = new KokiriSwordMm();
			public static class KokiriSwordMm {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 750;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Kokiri Sword OoT")
			public final KokiriSwordOoT KokiriSwordOoT = new KokiriSwordOoT();
			public static class KokiriSwordOoT {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 750;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Demise's Sword")
			public final DemiseSword DemiseSword = new DemiseSword();
			public static class DemiseSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Giant's Knife")
			public final GiantKnife GiantKnife = new GiantKnife();
			public static class GiantKnife {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 40;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Biggoron's Sword")
			public final BiggoronSword BiggoronSword = new BiggoronSword();
			public static class BiggoronSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 8000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Phantom Ganon's Sword")
			public final PhantomGanonSword PhantomGanonSword = new PhantomGanonSword();
			public static class PhantomGanonSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ultimate Sword")
			public final UltimateSword UltimateSword = new UltimateSword();
			public static class UltimateSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Royal Guard's Sword")
			public final RoyalGuardSword RoyalGuardSword = new RoyalGuardSword();
			public static class RoyalGuardSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Magic Sword Concept")
			public final MagicSwordConcept MagicSwordConcept = new MagicSwordConcept();
			public static class MagicSwordConcept {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 38;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Magic Sword")
			public final MagicSword MagicSword = new MagicSword();
			public static class MagicSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 38;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Sword")
			public final WhiteSword WhiteSword = new WhiteSword();
			public static class WhiteSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Sword Concept")
			public final WhiteSwordConcept WhiteSwordConcept = new WhiteSwordConcept();
			public static class WhiteSwordConcept {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Picori Blade")
			public final PicoriBlade PicoriBlade = new PicoriBlade();
			public static class PicoriBlade {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 14;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Razor Sword")
			public final RazorSword RazorSword = new RazorSword();
			public static class RazorSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Great Fairy's Sword")
			public final GreatFairySword GreatFairySword = new GreatFairySword();
			public static class GreatFairySword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 20;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Goddess White Sword")
			public final GoddessWhiteSword GoddessWhiteSword = new GoddessWhiteSword();
			public static class GoddessWhiteSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Goddess Sword")
			public final GoddessSword GoddessSword = new GoddessSword();
			public static class GoddessSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Gilded Sword")
			public final GildedSword GildedSword = new GildedSword();
			public static class GildedSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 28;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Spiked Boko Club")
			public final SpikedBokoClub SpikedBokoClub = new SpikedBokoClub();
			public static class SpikedBokoClub {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Boko Club")
			public final BokoClub BokoClub = new BokoClub();
			public static class BokoClub {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 650;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 18;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Adventure Time")
		public final atModified atmodified = new atModified();
		public static class atModified {

			@Name("Jake's Sword")
			public final JakeSword JakeSword = new JakeSword();
			public static class JakeSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Crystal Sword")
			public final CrystalSword CrystalSword = new CrystalSword();
			public static class CrystalSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Nothung")
			public final Nothung Nothung = new Nothung();
			public static class Nothung {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Finn Sword")
			public final FinnSword FinnSword = new FinnSword();
			public static class FinnSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 11;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Sword of the Dead")
			public final SwordoftheDead SwordoftheDead = new SwordoftheDead();
			public static class SwordoftheDead {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 11;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wish Star Sword")
			public final WishStarSword WishStarSword = new WishStarSword();
			public static class WishStarSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Fight King Sword")
			public final FightKingSword FightKingSword = new FightKingSword();
			public static class FightKingSword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 5;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Root Sword")
			public final RootSword RootSword = new RootSword();
			public static class RootSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Scarlet")
			public final Scarlet Scarlet = new Scarlet();
			public static class Scarlet {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 28;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Grass Sword")
			public final GrassSword GrassSword = new GrassSword();
			public static class GrassSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Demon Blood Sword")
			public final DemonBloodSword DemonBloodSword = new DemonBloodSword();
			public static class DemonBloodSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 22;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Axe Bass")
			public final AxeBass AxeBass = new AxeBass();
			public static class AxeBass {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Final Fantasy")
		public final ffModified ffmodified = new ffModified();
		public static class ffModified {

			@Name("The Masamune")
			public final TheMasamune TheMasamune = new TheMasamune();
			public static class TheMasamune {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Buster Sword")
			public final BusterSword BusterSword = new BusterSword();
			public static class BusterSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Caladbolg")
			public final Caladbolg Caladbolg = new Caladbolg();
			public static class Caladbolg {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Realm of the Mad God")
		public final rotmgModified rotmgmodified = new rotmgModified();
		public static class rotmgModified {

			@Name("Sword of the Colossus")
			public final SwordoftheColossus SwordoftheColossus = new SwordoftheColossus();
			public static class SwordoftheColossus {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Crystal Sword")
			public final CrystalSword CrystalSword = new CrystalSword();
			public static class CrystalSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Pixie-Enchanted Sword")
			public final PixieEnchantedSword PixieEnchantedSword = new PixieEnchantedSword();
			public static class PixieEnchantedSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Sword Of Acclaim")
			public final SwordOfAcclaim SwordOfAcclaim = new SwordOfAcclaim();
			public static class SwordOfAcclaim {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 11;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Demon Blade")
			public final DemonBlade DemonBlade = new DemonBlade();
			public static class DemonBlade {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 3200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Sword of the Mad God")
			public final SwordoftheMadGod SwordoftheMadGod = new SwordoftheMadGod();
			public static class SwordoftheMadGod {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Indomptable")
			public final Indomptable Indomptable = new Indomptable();
			public static class Indomptable {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Pirate King's Cutlass")
			public final PirateKingCutlass PirateKingCutlass = new PirateKingCutlass();
			public static class PirateKingCutlass {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Sword of Splendor")
			public final SwordofSplendor SwordofSplendor = new SwordofSplendor();
			public static class SwordofSplendor {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Skysplitter Sword")
			public final SkysplitterSword SkysplitterSword = new SkysplitterSword();
			public static class SkysplitterSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Archon Sword")
			public final ArchonSword ArchonSword = new ArchonSword();
			public static class ArchonSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 14;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ancient Stone Sword")
			public final AncientStoneSword AncientStoneSword = new AncientStoneSword();
			public static class AncientStoneSword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 750;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dragonsoul Sword")
			public final DragonsoulSword DragonsoulSword = new DragonsoulSword();
			public static class DragonsoulSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ravenheart Sword")
			public final RavenheartSword RavenheartSword = new RavenheartSword();
			public static class RavenheartSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 17;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Soul Calibur")
		public final scModified scmodified = new scModified();
		public static class scModified {

			@Name("Firangi")
			public final Firangi Firangi = new Firangi();
			public static class Firangi {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Cocytus")
			public final Cocytus Cocytus = new Cocytus();
			public static class Cocytus {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Erlang's Blade")
			public final ErlangBlade ErlangBlade = new ErlangBlade();
			public static class ErlangBlade {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Soul Edge (Nightmare)")
			public final SoulEdgeNightmare SoulEdgeNightmare = new SoulEdgeNightmare();
			public static class SoulEdgeNightmare {
				@Name("Damage")
				public float damage = 11;
				@Name("Durability")
				public int durability = 3200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 4;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Phlegathon")
			public final Phlegathon Phlegathon = new Phlegathon();
			public static class Phlegathon {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Acheron")
			public final Acheron Acheron = new Acheron();
			public static class Acheron {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Lethe")
			public final Lethe Lethe = new Lethe();
			public static class Lethe {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Queen's Guard")
			public final QueenGuard QueenGuard = new QueenGuard();
			public static class QueenGuard {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Holy Antler")
			public final HolyAntler HolyAntler = new HolyAntler();
			public static class HolyAntler {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Epee")
			public final Epee Epee = new Epee();
			public static class Epee {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("War Hammer")
			public final WarHammer WarHammer = new WarHammer();
			public static class WarHammer {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Kalutues")
			public final Kalutues Kalutues = new Kalutues();
			public static class Kalutues {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Estoc")
			public final Estoc Estoc = new Estoc();
			public static class Estoc {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Flambert 2P")
			public final Flambert2P Flambert2P = new Flambert2P();
			public static class Flambert2P {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Reiterpallasch")
			public final Reiterpallasch Reiterpallasch = new Reiterpallasch();
			public static class Reiterpallasch {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Flambert")
			public final Flambert Flambert = new Flambert();
			public static class Flambert {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blue Crystal Rod")
			public final BlueCrystalRod BlueCrystalRod = new BlueCrystalRod();
			public static class BlueCrystalRod {
				@Name("Damage")
				public float damage = 4;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 30;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Fire Blade")
			public final FireBlade FireBlade = new FireBlade();
			public static class FireBlade {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 13;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Xi Sword")
			public final XiSword XiSword = new XiSword();
			public static class XiSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Omega Sword 2P")
			public final OmegaSword2P OmegaSword2P = new OmegaSword2P();
			public static class OmegaSword2P {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Omega Sword")
			public final OmegaSword OmegaSword = new OmegaSword();
			public static class OmegaSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Orichalcum")
			public final Orichalcum Orichalcum = new Orichalcum();
			public static class Orichalcum {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 19;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Stiletto")
			public final Stiletto Stiletto = new Stiletto();
			public static class Stiletto {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Requiem")
			public final Requiem Requiem = new Requiem();
			public static class Requiem {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Faust")
			public final Faust Faust = new Faust();
			public static class Faust {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Flamberge")
			public final Flamberge Flamberge = new Flamberge();
			public static class Flamberge {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Paddle")
			public final SteelPaddle SteelPaddle = new SteelPaddle();
			public static class SteelPaddle {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Glam")
			public final Glam Glam = new Glam();
			public static class Glam {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Great Blade")
			public final GreatBlade GreatBlade = new GreatBlade();
			public static class GreatBlade {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Runescape")
		public final rsModified rsmodified = new rsModified();
		public static class rsModified {

			@Name("Bronze Sword")
			public final BronzeSword BronzeSword = new BronzeSword();
			public static class BronzeSword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 350;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Sword")
			public final IronSword IronSword = new IronSword();
			public static class IronSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Sword")
			public final WhiteSword WhiteSword = new WhiteSword();
			public static class WhiteSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Black Sword")
			public final BlackSword BlackSword = new BlackSword();
			public static class BlackSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Sword")
			public final SteelSword SteelSword = new SteelSword();
			public static class SteelSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mithril Sword")
			public final MithrilSword MithrilSword = new MithrilSword();
			public static class MithrilSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Adamant Sword")
			public final AdamantSword AdamantSword = new AdamantSword();
			public static class AdamantSword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rune Sword")
			public final RuneSword RuneSword = new RuneSword();
			public static class RuneSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 4200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dragon Sword")
			public final DragonSword DragonSword = new DragonSword();
			public static class DragonSword {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 5600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bronze Battleaxe")
			public final BronzeBattleaxe BronzeBattleaxe = new BronzeBattleaxe();
			public static class BronzeBattleaxe {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 350;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Battleaxe")
			public final IronBattleaxe IronBattleaxe = new IronBattleaxe();
			public static class IronBattleaxe {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Battleaxe")
			public final SteelBattleaxe SteelBattleaxe = new SteelBattleaxe();
			public static class SteelBattleaxe {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Black Battleaxe")
			public final BlackBattleaxe BlackBattleaxe = new BlackBattleaxe();
			public static class BlackBattleaxe {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Battleaxe")
			public final WhiteBattleaxe WhiteBattleaxe = new WhiteBattleaxe();
			public static class WhiteBattleaxe {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mithril Battleaxe")
			public final MithrilBattleaxe MithrilBattleaxe = new MithrilBattleaxe();
			public static class MithrilBattleaxe {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Adamant Battleaxe")
			public final AdamantBattleaxe AdamantBattleaxe = new AdamantBattleaxe();
			public static class AdamantBattleaxe {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rune Battleaxe")
			public final RuneBattleaxe RuneBattleaxe = new RuneBattleaxe();
			public static class RuneBattleaxe {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 4200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dragon Battleaxe")
			public final DragonBattleaxe DragonBattleaxe = new DragonBattleaxe();
			public static class DragonBattleaxe {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 5600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bronze Scimitar")
			public final BronzeScimitar BronzeScimitar = new BronzeScimitar();
			public static class BronzeScimitar {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 350;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Scimitar")
			public final IronScimitar IronScimitar = new IronScimitar();
			public static class IronScimitar {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Black Scimitar")
			public final BlackScimitar BlackScimitar = new BlackScimitar();
			public static class BlackScimitar {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Scimitar")
			public final WhiteScimitar WhiteScimitar = new WhiteScimitar();
			public static class WhiteScimitar {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Scimitar")
			public final SteelScimitar SteelScimitar = new SteelScimitar();
			public static class SteelScimitar {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mithril Scimitar")
			public final MithrilScimitar MithrilScimitar = new MithrilScimitar();
			public static class MithrilScimitar {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Adamant Scimitar")
			public final AdamantScimitar AdamantScimitar = new AdamantScimitar();
			public static class AdamantScimitar {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rune Scimitar")
			public final RuneScimitar RuneScimitar = new RuneScimitar();
			public static class RuneScimitar {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 4200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dragon Scimitar")
			public final DragonScimitar DragonScimitar = new DragonScimitar();
			public static class DragonScimitar {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 5600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bronze Warhammer")
			public final BronzeWarhammer BronzeWarhammer = new BronzeWarhammer();
			public static class BronzeWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Warhammer")
			public final IronWarhammer IronWarhammer = new IronWarhammer();
			public static class IronWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Warhammer")
			public final SteelWarhammer SteelWarhammer = new SteelWarhammer();
			public static class SteelWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Black Warhammer")
			public final BlackWarhammer BlackWarhammer = new BlackWarhammer();
			public static class BlackWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Warhammer")
			public final WhiteWarhammer WhiteWarhammer = new WhiteWarhammer();
			public static class WhiteWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mithril Warhammer")
			public final MithrilWarhammer MithrilWarhammer = new MithrilWarhammer();
			public static class MithrilWarhammer {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Adamant Warhammer")
			public final AdamantWarhammer AdamantWarhammer = new AdamantWarhammer();
			public static class AdamantWarhammer {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rune Warhammer")
			public final RuneWarhammer RuneWarhammer = new RuneWarhammer();
			public static class RuneWarhammer {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 4200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bronze Mace")
			public final BronzeMace BronzeMace = new BronzeMace();
			public static class BronzeMace {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Mace")
			public final IronMace IronMace = new IronMace();
			public static class IronMace {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Mace")
			public final SteelMace SteelMace = new SteelMace();
			public static class SteelMace {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Black Mace")
			public final BlackMace BlackMace = new BlackMace();
			public static class BlackMace {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Mace")
			public final WhiteMace WhiteMace = new WhiteMace();
			public static class WhiteMace {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mithril Mace")
			public final MithrilMace MithrilMace = new MithrilMace();
			public static class MithrilMace {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Adamant Mace")
			public final AdamantMace AdamantMace = new AdamantMace();
			public static class AdamantMace {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rune Mace")
			public final RuneMace RuneMace = new RuneMace();
			public static class RuneMace {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 4200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Granite Longsword")
			public final GraniteLongsword GraniteLongsword = new GraniteLongsword();
			public static class GraniteLongsword {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 2400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 5;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Granite Hammer")
			public final GraniteHammer GraniteHammer = new GraniteHammer();
			public static class GraniteHammer {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 5;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Granite Maul")
			public final GraniteMaul GraniteMaul = new GraniteMaul();
			public static class GraniteMaul {
				@Name("Damage")
				public float damage = 11;
				@Name("Durability")
				public int durability = 2500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 5;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Elder Maul")
			public final ElderMaul ElderMaul = new ElderMaul();
			public static class ElderMaul {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 3200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Toktz-xil-ak")
			public final Toktzxilak Toktzxilak = new Toktzxilak();
			public static class Toktzxilak {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wolfsbane")
			public final Wolfsbane Wolfsbane = new Wolfsbane();
			public static class Wolfsbane {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 2500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Zamorak Godsword")
			public final ZamorakGodsword ZamorakGodsword = new ZamorakGodsword();
			public static class ZamorakGodsword {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bandos Godsword")
			public final BandosGodsword BandosGodsword = new BandosGodsword();
			public static class BandosGodsword {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Armadyl Godsword")
			public final ArmadylGodsword ArmadylGodsword = new ArmadylGodsword();
			public static class ArmadylGodsword {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Saradomin Godsword")
			public final SaradominGodsword SaradominGodsword = new SaradominGodsword();
			public static class SaradominGodsword {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 2800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Barrelchest Anchor")
			public final BarrelchestAnchor BarrelchestAnchor = new BarrelchestAnchor();
			public static class BarrelchestAnchor {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Devil May Cry")
		public final dmcModified dmcmodified = new dmcModified();
		public static class dmcModified {

			@Name("Red Queen")
			public final RedQueen RedQueen = new RedQueen();
			public static class RedQueen {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rebellion")
			public final Rebellion Rebellion = new Rebellion();
			public static class Rebellion {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Yamato")
			public final Yamato Yamato = new Yamato();
			public static class Yamato {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Pokemon")
		public final pkmnModified pkmnmodified = new pkmnModified();
		public static class pkmnModified {

			@Name("Honedge Shiny")
			public final HonedgeShiny HonedgeShiny = new HonedgeShiny();
			public static class HonedgeShiny {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 1;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Honedge")
			public final Honedge Honedge = new Honedge();
			public static class Honedge {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 11;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Kirby")
		public final kirbyModified kirbymodified = new kirbyModified();
		public static class kirbyModified {

			@Name("Galaxia")
			public final Galaxia Galaxia = new Galaxia();
			public static class Galaxia {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 3500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Kirby's Ultra Sword")
			public final KirbyUltraSword KirbyUltraSword = new KirbyUltraSword();
			public static class KirbyUltraSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Kirby's Sword")
			public final KirbySword KirbySword = new KirbySword();
			public static class KirbySword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Fire Emblem")
		public final feModified femodified = new feModified();
		public static class feModified {

			@Name("Chrom's Falchion")
			public final ChromFalchion ChromFalchion = new ChromFalchion();
			public static class ChromFalchion {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 20;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Falchion")
			public final Falchion Falchion = new Falchion();
			public static class Falchion {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 20;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Kingdom Hearts")
		public final khModified khmodified = new khModified();
		public static class khModified {

			@Name("Keyblade")
			public final Keyblade Keyblade = new Keyblade();
			public static class Keyblade {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Bleach")
		public final bleachModified bleachmodified = new bleachModified();
		public static class bleachModified {

			@Name("Zabimaru")
			public final Zabimaru Zabimaru = new Zabimaru();
			public static class Zabimaru {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Zangetsu")
			public final Zangetsu Zangetsu = new Zangetsu();
			public static class Zangetsu {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 9;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Dark Souls")
		public final dsModified dsmodified = new dsModified();
		public static class dsModified {

			@Name("Greatsword of Artorias")
			public final GreatswordofArtorias GreatswordofArtorias = new GreatswordofArtorias();
			public static class GreatswordofArtorias {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Great Lord Greatsword")
			public final GreatLordGreatsword GreatLordGreatsword = new GreatLordGreatsword();
			public static class GreatLordGreatsword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Astora Greatsword")
			public final AstoraGreatsword AstoraGreatsword = new AstoraGreatsword();
			public static class AstoraGreatsword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Zweilhander")
			public final Zweilhander Zweilhander = new Zweilhander();
			public static class Zweilhander {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Mythology")
		public final mythModified mythmodified = new mythModified();
		public static class mythModified {

			@Name("Death's Scythe")
			public final DeathScythe DeathScythe = new DeathScythe();
			public static class DeathScythe {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 2;
				@Name("Rarity")
				public int rarity = 1;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("The Devil's Pitchfork")
			public final TheDevilPitchfork TheDevilPitchfork = new TheDevilPitchfork();
			public static class TheDevilPitchfork {
				@Name("Damage")
				public float damage = 11;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 2;
				@Name("Rarity")
				public int rarity = 1;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Bayonetta")
		public final bayonettaModified bayonettamodified = new bayonettaModified();
		public static class bayonettaModified {

			@Name("Shuraba")
			public final Shuraba Shuraba = new Shuraba();
			public static class Shuraba {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Angel Slayer")
			public final AngelSlayer AngelSlayer = new AngelSlayer();
			public static class AngelSlayer {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("God of War")
		public final gowModified gowmodified = new gowModified();
		public static class gowModified {

			@Name("Leviathan Upgraded")
			public final LeviathanUpgraded LeviathanUpgraded = new LeviathanUpgraded();
			public static class LeviathanUpgraded {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Leviathan")
			public final Leviathan Leviathan = new Leviathan();
			public static class Leviathan {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blade of Olympus")
			public final BladeofOlympus BladeofOlympus = new BladeofOlympus();
			public static class BladeofOlympus {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 4000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blade of Chaos")
			public final BladeofChaos BladeofChaos = new BladeofChaos();
			public static class BladeofChaos {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Multiplier")
				public float multiplier = 3.5f;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Skyrim")
		public final skyrimModified skyrimmodified = new skyrimModified();
		public static class skyrimModified {

			@Name("Iron Sword")
			public final IronSword IronSword = new IronSword();
			public static class IronSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Warhammer")
			public final IronWarhammer IronWarhammer = new IronWarhammer();
			public static class IronWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 14;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Sword")
			public final SteelSword SteelSword = new SteelSword();
			public static class SteelSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 14;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Steel Warhammer")
			public final SteelWarhammer SteelWarhammer = new SteelWarhammer();
			public static class SteelWarhammer {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1700;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 17;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Orcish Sword")
			public final OrcishSword OrcishSword = new OrcishSword();
			public static class OrcishSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Orcish Warhammer")
			public final OrcishWarhammer OrcishWarhammer = new OrcishWarhammer();
			public static class OrcishWarhammer {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dwarven Sword")
			public final DwarvenSword DwarvenSword = new DwarvenSword();
			public static class DwarvenSword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dwarven Warhammer")
			public final DwarvenWarhammer DwarvenWarhammer = new DwarvenWarhammer();
			public static class DwarvenWarhammer {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2700;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Elven Sword")
			public final ElvenSword ElvenSword = new ElvenSword();
			public static class ElvenSword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Elven Warhammer")
			public final ElvenWarhammer ElvenWarhammer = new ElvenWarhammer();
			public static class ElvenWarhammer {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1700;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Glass Sword")
			public final GlassSword GlassSword = new GlassSword();
			public static class GlassSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 11;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Glass Warhammer")
			public final GlassWarhammer GlassWarhammer = new GlassWarhammer();
			public static class GlassWarhammer {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1700;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 11;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ebony Sword")
			public final EbonySword EbonySword = new EbonySword();
			public static class EbonySword {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ebony Warhammer")
			public final EbonyWarhammer EbonyWarhammer = new EbonyWarhammer();
			public static class EbonyWarhammer {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Daedric Sword")
			public final DaedricSword DaedricSword = new DaedricSword();
			public static class DaedricSword {
				@Name("Damage")
				public float damage = 11;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Daedric Warhammer")
			public final DaedricWarhammer DaedricWarhammer = new DaedricWarhammer();
			public static class DaedricWarhammer {
				@Name("Damage")
				public float damage = 11;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dragonbone Sword")
			public final DragonboneSword DragonboneSword = new DragonboneSword();
			public static class DragonboneSword {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 1300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 6;
				@Name("Rarity")
				public int rarity = 1;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dragonbone Warhammer")
			public final DragonboneWarhammer DragonboneWarhammer = new DragonboneWarhammer();
			public static class DragonboneWarhammer {
				@Name("Damage")
				public float damage = 12;
				@Name("Durability")
				public int durability = 1400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 6;
				@Name("Rarity")
				public int rarity = 1;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Imperial Sword")
			public final ImperialSword ImperialSword = new ImperialSword();
			public static class ImperialSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 15;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dawnbreaker")
			public final Dawnbreaker Dawnbreaker = new Dawnbreaker();
			public static class Dawnbreaker {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ancient Nord Sword")
			public final AncientNordSword AncientNordSword = new AncientNordSword();
			public static class AncientNordSword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 13;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Chillrend")
			public final Chillrend Chillrend = new Chillrend();
			public static class Chillrend {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ebony Blade")
			public final EbonyBlade EbonyBlade = new EbonyBlade();
			public static class EbonyBlade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Monster Hunter")
		public final mhModified mhmodified = new mhModified();
		public static class mhModified {

			@Name("Chicken Decapitator")
			public final ChickenDecapitator ChickenDecapitator = new ChickenDecapitator();
			public static class ChickenDecapitator {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 6;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Golem Blade")
			public final GolemBlade GolemBlade = new GolemBlade();
			public static class GolemBlade {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Defender")
			public final Defender Defender = new Defender();
			public static class Defender {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Black Belt Blade")
			public final BlackBeltBlade BlackBeltBlade = new BlackBeltBlade();
			public static class BlackBeltBlade {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wailing Cleaver")
			public final WailingCleaver WailingCleaver = new WailingCleaver();
			public static class WailingCleaver {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1700;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Gaelic Flame")
			public final GaelicFlame GaelicFlame = new GaelicFlame();
			public static class GaelicFlame {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 11;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bone Katana")
			public final BoneKatana BoneKatana = new BoneKatana();
			public static class BoneKatana {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1700;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Hellish Slasher")
			public final HellishSlasher HellishSlasher = new HellishSlasher();
			public static class HellishSlasher {
				@Name("Damage")
				public float damage = 10;
				@Name("Durability")
				public int durability = 2100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Centenarian Dagger")
			public final CentenarianDagger CentenarianDagger = new CentenarianDagger();
			public static class CentenarianDagger {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wyvern Blade Blood")
			public final WyvernBladeBlood WyvernBladeBlood = new WyvernBladeBlood();
			public static class WyvernBladeBlood {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wyvern Blade Holly")
			public final WyvernBladeHolly WyvernBladeHolly = new WyvernBladeHolly();
			public static class WyvernBladeHolly {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wyvern Blade Pale")
			public final WyvernBladePale WyvernBladePale = new WyvernBladePale();
			public static class WyvernBladePale {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wyvern Blade Azure")
			public final WyvernBladeAzure WyvernBladeAzure = new WyvernBladeAzure();
			public static class WyvernBladeAzure {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Wyvern Blade Leaf")
			public final WyvernBladeLeaf WyvernBladeLeaf = new WyvernBladeLeaf();
			public static class WyvernBladeLeaf {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Rathalos Flamesword")
			public final RathalosFlamesword RathalosFlamesword = new RathalosFlamesword();
			public static class RathalosFlamesword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Terraria")
		public final terrariaModified terrariamodified = new terrariaModified();
		public static class terrariaModified {

			@Name("Palm Wood Sword")
			public final PalmWoodSword PalmWoodSword = new PalmWoodSword();
			public static class PalmWoodSword {
				@Name("Damage")
				public float damage = 4;
				@Name("Durability")
				public int durability = 100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Boreal Wood Sword")
			public final BorealWoodSword BorealWoodSword = new BorealWoodSword();
			public static class BorealWoodSword {
				@Name("Damage")
				public float damage = 4;
				@Name("Durability")
				public int durability = 100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Shadewood Sword")
			public final ShadewoodSword ShadewoodSword = new ShadewoodSword();
			public static class ShadewoodSword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 350;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 18;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ebonwood Sword")
			public final EbonwoodSword EbonwoodSword = new EbonwoodSword();
			public static class EbonwoodSword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 350;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 18;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Copper Shortsword")
			public final CopperShortsword CopperShortsword = new CopperShortsword();
			public static class CopperShortsword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 150;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 20;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Copper Broadsword")
			public final CopperBroadsword CopperBroadsword = new CopperBroadsword();
			public static class CopperBroadsword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 180;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 19;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Tin Shortsword")
			public final TinShortsword TinShortsword = new TinShortsword();
			public static class TinShortsword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 150;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 17;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Tin Broadsword")
			public final TinBroadsword TinBroadsword = new TinBroadsword();
			public static class TinBroadsword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 180;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 10;
				@Name("Rarity")
				public int rarity = 17;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Lead Shortsword")
			public final LeadShortsword LeadShortsword = new LeadShortsword();
			public static class LeadShortsword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 150;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 17;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Lead Broadsword")
			public final LeadBroadsword LeadBroadsword = new LeadBroadsword();
			public static class LeadBroadsword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 180;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 17;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Spear")
			public final Spear Spear = new Spear();
			public static class Spear {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Shortsword")
			public final IronShortsword IronShortsword = new IronShortsword();
			public static class IronShortsword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 250;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Iron Broadsword")
			public final IronBroadsword IronBroadsword = new IronBroadsword();
			public static class IronBroadsword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 250;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Silver Broadsword")
			public final SilverBroadsword SilverBroadsword = new SilverBroadsword();
			public static class SilverBroadsword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Silver Shortsword")
			public final SilverShortsword SilverShortsword = new SilverShortsword();
			public static class SilverShortsword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Gold Shortsword")
			public final GoldShortsword GoldShortsword = new GoldShortsword();
			public static class GoldShortsword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Gold Broadsword")
			public final GoldBroadsword GoldBroadsword = new GoldBroadsword();
			public static class GoldBroadsword {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 26;
				@Name("Rarity")
				public int rarity = 16;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Tungsten Broadsword")
			public final TungstenBroadsword TungstenBroadsword = new TungstenBroadsword();
			public static class TungstenBroadsword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Tungsten Shortsword")
			public final TungstenShortsword TungstenShortsword = new TungstenShortsword();
			public static class TungstenShortsword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 650;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Platinum Shortsword")
			public final PlatinumShortsword PlatinumShortsword = new PlatinumShortsword();
			public static class PlatinumShortsword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 22;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Platinum Broadsword")
			public final PlatinumBroadsword PlatinumBroadsword = new PlatinumBroadsword();
			public static class PlatinumBroadsword {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 650;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 22;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mandible Blade")
			public final MandibleBlade MandibleBlade = new MandibleBlade();
			public static class MandibleBlade {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 500;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 6;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Katana")
			public final Katana Katana = new Katana();
			public static class Katana {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Exotic Scimitar")
			public final ExoticScimitar ExoticScimitar = new ExoticScimitar();
			public static class ExoticScimitar {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Muramasa")
			public final Muramasa Muramasa = new Muramasa();
			public static class Muramasa {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 23;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Falcon Blade")
			public final FalconBlade FalconBlade = new FalconBlade();
			public static class FalconBlade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 11;
				@Name("Rarity")
				public int rarity = 8;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blade of Grass")
			public final BladeofGrass BladeofGrass = new BladeofGrass();
			public static class BladeofGrass {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Fiery Greatsword")
			public final FieryGreatsword FieryGreatsword = new FieryGreatsword();
			public static class FieryGreatsword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bone Sword")
			public final BoneSword BoneSword = new BoneSword();
			public static class BoneSword {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blood Butcherer")
			public final BloodButcherer BloodButcherer = new BloodButcherer();
			public static class BloodButcherer {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Enchanted Sword")
			public final EnchantedSword EnchantedSword = new EnchantedSword();
			public static class EnchantedSword {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 32;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Starfury")
			public final Starfury Starfury = new Starfury();
			public static class Starfury {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 9;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Bee Keeper")
			public final BeeKeeper BeeKeeper = new BeeKeeper();
			public static class BeeKeeper {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1200;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 8;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Ice Blade")
			public final IceBlade IceBlade = new IceBlade();
			public static class IceBlade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 4;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Night's Edge")
			public final NightEdge NightEdge = new NightEdge();
			public static class NightEdge {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Arkhalis")
			public final Arkhalis Arkhalis = new Arkhalis();
			public static class Arkhalis {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1700;
				@Name("Speed")
				public double speed = 20.0;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Trident")
			public final Trident Trident = new Trident();
			public static class Trident {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 12;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("The Rotted Fork")
			public final TheRottedFork TheRottedFork = new TheRottedFork();
			public static class TheRottedFork {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 16;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("White Phaseblade")
			public final WhitePhaseblade WhitePhaseblade = new WhitePhaseblade();
			public static class WhitePhaseblade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Yellow Phaseblade")
			public final YellowPhaseblade YellowPhaseblade = new YellowPhaseblade();
			public static class YellowPhaseblade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Purple Phaseblade")
			public final PurplePhaseblade PurplePhaseblade = new PurplePhaseblade();
			public static class PurplePhaseblade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Green Phaseblade")
			public final GreenPhaseblade GreenPhaseblade = new GreenPhaseblade();
			public static class GreenPhaseblade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Red Phaseblade")
			public final RedPhaseblade RedPhaseblade = new RedPhaseblade();
			public static class RedPhaseblade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blue Phaseblade")
			public final BluePhaseblade BluePhaseblade = new BluePhaseblade();
			public static class BluePhaseblade {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Light's Bane")
			public final LightBane LightBane = new LightBane();
			public static class LightBane {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1900;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Dark Lance")
			public final DarkLance DarkLance = new DarkLance();
			public static class DarkLance {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 1400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 15;
				@Name("Rarity")
				public int rarity = 7;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Purple Clubberfish")
			public final PurpleClubberfish PurpleClubberfish = new PurpleClubberfish();
			public static class PurpleClubberfish {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Cactus Sword")
			public final CactusSword CactusSword = new CactusSword();
			public static class CactusSword {
				@Name("Damage")
				public float damage = 5;
				@Name("Durability")
				public int durability = 250;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 6;
				@Name("Rarity")
				public int rarity = 12;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Swordfish")
			public final Swordfish Swordfish = new Swordfish();
			public static class Swordfish {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 0;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Star Wars")
		public final swModified swmodified = new swModified();
		public static class swModified {

			@Name("Yellow Lightsaber")
			public final YellowLightsaber YellowLightsaber = new YellowLightsaber();
			public static class YellowLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Green Lightsaber")
			public final GreenLightsaber GreenLightsaber = new GreenLightsaber();
			public static class GreenLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Blue Lightsaber")
			public final BlueLightsaber BlueLightsaber = new BlueLightsaber();
			public static class BlueLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Red Lightsaber")
			public final RedLightsaber RedLightsaber = new RedLightsaber();
			public static class RedLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 5;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Mace Windu's Lightsaber")
			public final MaceWinduLightsaber MaceWinduLightsaber = new MaceWinduLightsaber();
			public static class MaceWinduLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("The Inquisitor's Lightsaber")
			public final TheInquisitorLightsaber TheInquisitorLightsaber = new TheInquisitorLightsaber();
			public static class TheInquisitorLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Darth Maul's Lightsaber")
			public final DarthMaulLightsaber DarthMaulLightsaber = new DarthMaulLightsaber();
			public static class DarthMaulLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2100;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Qui Gon Jinn's Lightsaber")
			public final QuiGonJinnLightsaber QuiGonJinnLightsaber = new QuiGonJinnLightsaber();
			public static class QuiGonJinnLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 4;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Kylo Ren's Lightsaber")
			public final KyloRenLightsaber KyloRenLightsaber = new KyloRenLightsaber();
			public static class KyloRenLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 1800;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Count Dooku's Lightsaber")
			public final CountDookuLightsaber CountDookuLightsaber = new CountDookuLightsaber();
			public static class CountDookuLightsaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Darksaber")
			public final Darksaber Darksaber = new Darksaber();
			public static class Darksaber {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2300;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 1;
				@Name("Rarity")
				public int rarity = 2;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Internet")
		public final internetModified internetmodified = new internetModified();
		public static class internetModified {

			@Name("Demonoid's Pitchfork")
			public final DemonoidPitchfork DemonoidPitchfork = new DemonoidPitchfork();
			public static class DemonoidPitchfork {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 666;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 6;
				@Name("Rarity")
				public int rarity = 6;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Nethack")
		public final nhModified nhmodified = new nhModified();
		public static class nhModified {

			@Name("Magicbane")
			public final Magicbane Magicbane = new Magicbane();
			public static class Magicbane {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2400;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 22;
				@Name("Rarity")
				public int rarity = 3;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Athame")
			public final Athame Athame = new Athame();
			public static class Athame {
				@Name("Damage")
				public float damage = 6;
				@Name("Durability")
				public int durability = 1600;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 18;
				@Name("Rarity")
				public int rarity = 11;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Grayswandir")
			public final Grayswandir Grayswandir = new Grayswandir();
			public static class Grayswandir {
				@Name("Damage")
				public float damage = 9;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 28;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}

			@Name("Silver Saber")
			public final SilverSaber SilverSaber = new SilverSaber();
			public static class SilverSaber {
				@Name("Damage")
				public float damage = 7;
				@Name("Durability")
				public int durability = 2000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 22;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

		@Name("Merlin (ABC)")
		public final abcmModified abcmmodified = new abcmModified();
		public static class abcmModified {

			@Name("Excalibur")
			public final Excalibur Excalibur = new Excalibur();
			public static class Excalibur {
				@Name("Damage")
				public float damage = 8;
				@Name("Durability")
				public int durability = 3000;
				@Name("Speed")
				public double speed = 1.6;
				@Name("Enchantability")
				public int enchantability = 24;
				@Name("Rarity")
				public int rarity = 10;
				@Name("Enabled")
				public boolean enabled = true;
			}
		}

	}

	@Mod.EventBusSubscriber(modid = HeroicArmory.MOD_ID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(HeroicArmory.MOD_ID)) {
				ConfigManager.sync(HeroicArmory.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}