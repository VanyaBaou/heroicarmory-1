package com.vanyabaou.heroicarmory;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = HeroicArmory.MOD_ID,
        name = HeroicArmory.MOD_NAME,
        version = HeroicArmory.VERSION,
        dependencies = "after:spartanweaponry@[1.4.0,);" +
                "after:iceandfire@[1.9.1,);" +
                "after:llibrary@[1.7.20,);"
)
public class HeroicArmory {

    public static final String MOD_ID = "heroicarmory";
    public static final String MOD_NAME = "Heroic Armory";
    public static final String VERSION = "1.0";
    public static final boolean SupportSpartanWeaponry = HAConfig.spartanWeaponrySupport && Loader.isModLoaded("spartanweaponry");
    public static final boolean SupportIceAndFire = Loader.isModLoaded("iceandfire");

    @Mod.Instance(MOD_ID)
    public static HeroicArmory INSTANCE;

}
