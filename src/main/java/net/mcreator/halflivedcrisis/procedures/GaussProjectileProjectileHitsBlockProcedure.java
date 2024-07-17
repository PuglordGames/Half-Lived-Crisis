package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModParticleTypes;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class GaussProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 5; index0++) {
			HalfLivedCrisisMod.queueServerWork(1, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (HalfLivedCrisisModParticleTypes.GAUSS_IMPACT_PROJECTILE.get()), x, (y + 1), z, 1, 0, 0, 0, 0);
			});
		}
	}
}
