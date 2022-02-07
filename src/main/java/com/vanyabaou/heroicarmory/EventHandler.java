package com.vanyabaou.heroicarmory;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class EventHandler {
    protected static int tickCounter5 = 0;
    protected static int tickCounter10 = 0;
    protected static int tickCounter20 = 0;
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if(event.side == Side.SERVER && event.phase == TickEvent.Phase.END)
        {
            tickCounter5++;
            if(tickCounter5 == 5)
            {
                tickCounter5 = 0;
            }
            tickCounter10++;
            if(tickCounter10 == 10)
            {
                tickCounter10 = 0;
            }
            tickCounter20++;
            if(tickCounter20 == 20)
            {
                tickCounter20 = 0;
            }
        }
    }
    public static int getTickCounter(int amount)
    {
        switch (amount) {
            case 5:
                return tickCounter5;
            case 10:
                return tickCounter10;
            case 20:
                return tickCounter20;
        }
        return tickCounter20;
    }
}
