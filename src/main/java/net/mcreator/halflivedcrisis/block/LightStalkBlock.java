
package net.mcreator.halflivedcrisis.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.procedures.LightStalkEntityCollidesInTheBlockProcedure;

public class LightStalkBlock extends Block {
	public LightStalkBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(1f, 10f).lightLevel(s -> 7).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.or(box(7, 0, 7, 9, 4, 9), box(7.5, 4, 7.5, 8.5, 8, 8.5), box(7.5, 8, 7.5, 8.5, 12, 8.5), box(7.25, 11.75, 7.25, 8.75, 14.25, 8.75));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LightStalkEntityCollidesInTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
