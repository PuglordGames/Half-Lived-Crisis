package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModParticleTypes;

public class GaussProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (HalfLivedCrisisModParticleTypes.GAUSS_IMPACT_PROJECTILE.get()), (x + 0.5), (y + 1), (z + 0.5), Mth.nextInt(RandomSource.create(), 2, 7), 0.5, 0.25, 0.5, 0.1);
	}
}
