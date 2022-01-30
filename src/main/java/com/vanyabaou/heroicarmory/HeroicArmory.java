package com.vanyabaou.heroicarmory;

import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = HeroicArmory.MOD_ID,
        name = HeroicArmory.MOD_NAME,
        version = HeroicArmory.VERSION
)
public class HeroicArmory {

    public static final String MOD_ID = "heroicarmory";
    public static final String MOD_NAME = "Heroic Armory";
    public static final String VERSION = "1.0";

    @Mod.Instance(MOD_ID)
    public static HeroicArmory INSTANCE;

}
