package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class NihilanthLairParticleAdditionalParticleExpiryConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x + 0.5, y - 3, z + 0.5))).getBlock() == Blocks.AIR)) {
			return true;
		}
		return false;
	}
}
