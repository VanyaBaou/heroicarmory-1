package com.vanyabaou.heroicarmory.Effects;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ModifiedExplosion extends Explosion {

    private final boolean causesFire;
    private final boolean damagesTerrain;
    private final Random random;
    private final World world;
    private final double x;
    private final double y;
    private final double z;
    private final Entity exploder;
    private final float size;
    private final List<BlockPos> affectedBlockPositions;
    private final Map<EntityPlayer, Vec3d> playerKnockbackMap;
    private final Vec3d position;
    private final float baseDamage;

    public ModifiedExplosion(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming, boolean damagesTerrain, float baseDamage) {
        super(worldIn, entityIn, x, y, z, size, flaming, damagesTerrain);
        this.random = new Random();
        this.affectedBlockPositions = Lists.newArrayList();
        this.playerKnockbackMap = Maps.newHashMap();
        this.world = worldIn;
        this.exploder = entityIn;
        this.size = size;
        this.x = x;
        this.y = y;
        this.z = z;
        this.causesFire = flaming;
        this.damagesTerrain = damagesTerrain;
        this.position = new Vec3d(this.x, this.y, this.z);
        this.baseDamage = baseDamage;
    }

    @Override
    public void doExplosionA() {
        super.doExplosionA();

        Set<BlockPos> set = Sets.newHashSet();
        int i = 16;

        for (int j = 0; j < 16; ++j) {
            for (int k = 0; k < 16; ++k) {
                for (int l = 0; l < 16; ++l) {
                    if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
                        double d0 = ((float)j / 15.0F * 2.0F - 1.0F);
                        double d1 = ((float)k / 15.0F * 2.0F - 1.0F);
                        double d2 = ((float)l / 15.0F * 2.0F - 1.0F);
                        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                        d0 = d0 / d3;
                        d1 = d1 / d3;
                        d2 = d2 / d3;
                        float f = this.size * (0.7F + this.world.rand.nextFloat() * 0.6F);
                        double d4 = this.x;
                        double d6 = this.y;
                        double d8 = this.z;

                        for (float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
                            BlockPos blockpos = new BlockPos(d4, d6, d8);
                            IBlockState iblockstate = this.world.getBlockState(blockpos);
                            if (iblockstate.getMaterial() != Material.AIR) {
                                float f2 = this.exploder != null ? this.exploder.getExplosionResistance(this, this.world, blockpos, iblockstate) : iblockstate.getBlock().getExplosionResistance(world, blockpos, null, this);
                                f -= (f2 + 0.3F) * 0.3F;
                            }
                            if (f > 0.0F && (this.exploder == null || this.exploder.canExplosionDestroyBlock(this, this.world, blockpos, iblockstate, f))) {
                                set.add(blockpos);
                            }
                            d4 += d0 * 0.30000001192092896D;
                            d6 += d1 * 0.30000001192092896D;
                            d8 += d2 * 0.30000001192092896D;
                        }
                    }
                }
            }
        }

        this.affectedBlockPositions.addAll(set);
        float damageRadius = this.size * 2.0F;
        int downX = MathHelper.floor(this.x - (double)damageRadius - 1.0D);
        int upX = MathHelper.floor(this.x + (double)damageRadius + 1.0D);
        int downY = MathHelper.floor(this.y - (double)damageRadius - 1.0D);
        int upY = MathHelper.floor(this.y + (double)damageRadius + 1.0D);
        int downZ = MathHelper.floor(this.z - (double)damageRadius - 1.0D);
        int upZ = MathHelper.floor(this.z + (double)damageRadius + 1.0D);
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.exploder, new AxisAlignedBB(downX, downY, downZ, upX, upY, upZ));
        net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.world, this, list, damageRadius);
        Vec3d vec3d = new Vec3d(this.x, this.y, this.z);

        for (int k2 = 0; k2 < list.size(); ++k2) {
            Entity entity = list.get(k2);
            if (!entity.isImmuneToExplosions()) {
                double entityDistance = entity.getDistance(this.x, this.y, this.z) / (double)damageRadius;
                if (entityDistance <= 1.0D) {
                    double d5 = entity.posX - this.x;
                    double d7 = entity.posY + (double)entity.getEyeHeight() - this.y;
                    double d9 = entity.posZ - this.z;
                    double d13 = (double)MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
                    if (d13 != 0.0D) {
                        d5 = d5 / d13;
                        d7 = d7 / d13;
                        d9 = d9 / d13;
                        double exposure = (double)this.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
                        double impact = (1.0D - entityDistance) * exposure;
                        entity.attackEntityFrom(DamageSource.causeExplosionDamage((EntityLivingBase) this.exploder), (float)((int)((impact * impact + impact) / 2.0D * baseDamage * (double)damageRadius + 1.0D)));
                        double reducedImpact = impact;
                        if (entity instanceof EntityLivingBase) {
                            reducedImpact = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase)entity, impact);
                        }
                        entity.motionX += d5 * reducedImpact;
                        entity.motionY += d7 * reducedImpact;
                        entity.motionZ += d9 * reducedImpact;
                        if (entity instanceof EntityPlayer) {
                            EntityPlayer entityplayer = (EntityPlayer)entity;
                            if (!entityplayer.isSpectator() && (!entityplayer.isCreative() || !entityplayer.capabilities.isFlying)) {
                                this.playerKnockbackMap.put(entityplayer, new Vec3d(d5 * impact, d7 * impact, d9 * impact));
                            }
                        }
                    }
                }
            }
        }
    }
}
