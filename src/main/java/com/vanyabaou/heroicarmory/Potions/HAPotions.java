package com.vanyabaou.heroicarmory.Potions;

import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class HAPotions {
    public static double armorDebuffAmount = 0.3d;
    public static final Potion armordebuff = new PotionArmorDebuff(5601024, -armorDebuffAmount);

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Potion> event){
        IForgeRegistry<Potion> registry = event.getRegistry();

        PotionArmorDebuff pot = (PotionArmorDebuff) armordebuff;
        pot.setRegistryName(HeroicArmory.MOD_ID, "armordebuff");
        assert pot.getRegistryName() != null;
        pot.setPotionName("potion." + pot.getRegistryName().toString());
        pot.registerPotionAttributeModifier();
        registry.register(pot);
    }

}
