package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModBlocks;

public class XenPortalParticleAdditionalParticleExpiryConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == HalfLivedCrisisModBlocks.XEN_PORTAL.get())) {
			return true;
		}
		return false;
	}
}
