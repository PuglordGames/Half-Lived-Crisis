package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModBlocks;

public class XenSporeBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR) {
			world.setBlock(BlockPos.containing(x, y + 2, z), HalfLivedCrisisModBlocks.XEN_SPORE_TOP.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
