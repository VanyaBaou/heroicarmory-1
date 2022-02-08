package com.vanyabaou.heroicarmory;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class EventHandler {
    protected static int tickCounter20 = 0;
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if(event.side == Side.SERVER && event.phase == TickEvent.Phase.END)
        {
            tickCounter20++;
            if(tickCounter20 == 20)
            {
                tickCounter20 = 0;
            }
        }
    }
    public static int getTickCounter()
    {
        return tickCounter20;
    }
}
