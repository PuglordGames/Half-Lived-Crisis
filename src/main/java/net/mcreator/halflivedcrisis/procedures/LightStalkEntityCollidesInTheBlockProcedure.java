package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModBlocks;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class LightStalkEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), HalfLivedCrisisModBlocks.LIGHT_STALK_HIDDEN.get().defaultBlockState(), 3);
		HalfLivedCrisisMod.queueServerWork(60, () -> {
			world.setBlock(BlockPos.containing(x, y, z), HalfLivedCrisisModBlocks.LIGHT_STALK.get().defaultBlockState(), 3);
		});
	}
}
