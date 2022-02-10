package com.vanyabaou.heroicarmory;

import com.oblivioussp.spartanweaponry.api.IWeaponPropertyContainer;
import com.oblivioussp.spartanweaponry.item.IBlockingWeapon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@EventBusSubscriber
public class EventHandler {

    private static HashMap<String,ArrayList<Boolean>> playerAttackInfo = new HashMap<>();

    public static HashMap<String, Boolean> getPlayerAttackInfo(String playerName){
        if (playerAttackInfo.containsKey(playerName)){
            ArrayList<Boolean> attackInfo = playerAttackInfo.getOrDefault(playerName, new ArrayList<Boolean>(Arrays.asList(false, false)));
            return new HashMap<String, Boolean>() {{
                put("strong", attackInfo.get(0));
                put("crit", attackInfo.get(1));
            }};
        }else{
            return new HashMap<String, Boolean>() {{
                put("strong", false);
                put("crit", false);
            }};
        }
    }

    protected static void updateAttackInfo(String playerName, boolean strong, boolean crit){
        ArrayList<Boolean> attackInfo = new ArrayList<Boolean>();
        attackInfo.add(strong);
        attackInfo.add(crit);
        playerAttackInfo.put(playerName, attackInfo);
    }

    protected static int tickCounter20 = 0;
    @SubscribeEvent
    protected static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if(event.side == Side.SERVER && event.phase == TickEvent.Phase.END) {
            tickCounter20++;
            if(tickCounter20 == 20) {
                tickCounter20 = 0;
            }
        }
    }

    public static int getTickCounter() {
        return tickCounter20;
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event){
        Entity targetEntity = event.getTarget();
        EntityPlayer attacker = event.getEntityPlayer();
        if (targetEntity instanceof EntityLivingBase){
            float attackStrength = attacker.getCooledAttackStrength(0.5F);
            boolean fullStrength = attackStrength > 0.9F;
            boolean critHit = fullStrength && attacker.fallDistance > 0.0F && !attacker.onGround && !attacker.isOnLadder() && !attacker.isInWater() && !attacker.isPotionActive(MobEffects.BLINDNESS) && !attacker.isRiding();
            critHit = critHit && !attacker.isSprinting();
            CriticalHitEvent hitResult = ForgeHooks.getCriticalHit(attacker, targetEntity, critHit, critHit ? 1.5F : 1.0F);
            critHit = hitResult != null;
            String playerName = attacker.getDisplayNameString();
            updateAttackInfo(playerName, fullStrength, critHit);
        }
    }

    @SubscribeEvent
    public static void onCritEvent(CriticalHitEvent event){
        EntityPlayer player = event.getEntityPlayer();
        ItemStack heldMain = player.getHeldItemMainhand();
        if (heldMain.getItem() instanceof IWeaponPropertyContainer<?>){
            IWeaponPropertyContainer<?> container = (IWeaponPropertyContainer<?>) heldMain.getItem();
            if (event.isVanillaCritical() && container.getFirstWeaponPropertyWithType("critbonus") != null){
                float multiplier = container.getFirstWeaponPropertyWithType("critbonus").getMagnitude();
                event.setDamageModifier(event.getDamageModifier() + multiplier);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        DamageSource source = event.getSource();
        float damageDealt = event.getAmount();
        EntityLivingBase victim = event.getEntityLiving();
        if (damageDealt == 0 ||
                source.isProjectile() || source.isMagicDamage() || source.isExplosion() || source.isFireDamage() ||
                (!source.getDamageType().equals("player") && !source.getDamageType().equals("mob")))
            return;
        if (source.getImmediateSource() == source.getTrueSource() && source.getTrueSource() instanceof EntityLivingBase && victim != null) {
            EntityLivingBase attacker = (EntityLivingBase) source.getTrueSource();
            ItemStack attackerStack = attacker.getHeldItemMainhand();
            if (attackerStack.getItem() instanceof IWeaponPropertyContainer) {
                IWeaponPropertyContainer<?> container = (IWeaponPropertyContainer<?>) attackerStack.getItem();
                if (container.getFirstWeaponPropertyWithType("shieldpierce") != null) {
                    float pierceStrength = container.getFirstWeaponPropertyWithType("shieldpierce").getMagnitude();
                    if (victim.isHandActive() && !victim.getActiveItemStack().isEmpty()) {
                        ItemStack victimStack = victim.getActiveItemStack();
                        if (victimStack.getItem().isShield(victimStack,victim) || (HeroicArmory.SupportSpartanWeaponry && victimStack.getItem() instanceof IBlockingWeapon)) {
                            System.out.println("dealing " + pierceStrength + "x of [" + damageDealt + "] > " + (damageDealt * pierceStrength));
                            victim.attackEntityFrom(event.getSource(), damageDealt * pierceStrength);
                        }
                    }
                }
            }
        }
    }

}
