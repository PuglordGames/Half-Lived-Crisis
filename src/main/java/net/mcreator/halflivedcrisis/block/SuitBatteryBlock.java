
package net.mcreator.halflivedcrisis.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SuitBatteryBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public SuitBatteryBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.METAL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
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
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6.5, 0, 6, 9.5, 8, 8), box(7, 5, 8, 9, 7, 11), box(6.5, 0, 8, 9.5, 1, 10), box(6.5, 0, 8, 9.5, 8, 10));
				case WALL -> Shapes.or(box(6.5, 8, 0, 9.5, 10, 8), box(7, 5, 5, 9, 8, 7), box(6.5, 6, 0, 9.5, 8, 1), box(6.5, 6, 0, 9.5, 8, 8));
				case CEILING -> Shapes.or(box(6.5, 8, 6, 9.5, 16, 8), box(7, 9, 8, 9, 11, 11), box(6.5, 15, 8, 9.5, 16, 10), box(6.5, 8, 8, 9.5, 16, 10));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6.5, 0, 8, 9.5, 8, 10), box(7, 5, 5, 9, 7, 8), box(6.5, 0, 6, 9.5, 1, 8), box(6.5, 0, 6, 9.5, 8, 8));
				case WALL -> Shapes.or(box(6.5, 8, 8, 9.5, 10, 16), box(7, 5, 9, 9, 8, 11), box(6.5, 6, 15, 9.5, 8, 16), box(6.5, 6, 8, 9.5, 8, 16));
				case CEILING -> Shapes.or(box(6.5, 8, 8, 9.5, 16, 10), box(7, 9, 5, 9, 11, 8), box(6.5, 15, 6, 9.5, 16, 8), box(6.5, 8, 6, 9.5, 16, 8));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6, 0, 6.5, 8, 8, 9.5), box(8, 5, 7, 11, 7, 9), box(8, 0, 6.5, 10, 1, 9.5), box(8, 0, 6.5, 10, 8, 9.5));
				case WALL -> Shapes.or(box(0, 8, 6.5, 8, 10, 9.5), box(5, 5, 7, 7, 8, 9), box(0, 6, 6.5, 1, 8, 9.5), box(0, 6, 6.5, 8, 8, 9.5));
				case CEILING -> Shapes.or(box(6, 8, 6.5, 8, 16, 9.5), box(8, 9, 7, 11, 11, 9), box(8, 15, 6.5, 10, 16, 9.5), box(8, 8, 6.5, 10, 16, 9.5));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(8, 0, 6.5, 10, 8, 9.5), box(5, 5, 7, 8, 7, 9), box(6, 0, 6.5, 8, 1, 9.5), box(6, 0, 6.5, 8, 8, 9.5));
				case WALL -> Shapes.or(box(8, 8, 6.5, 16, 10, 9.5), box(9, 5, 7, 11, 8, 9), box(15, 6, 6.5, 16, 8, 9.5), box(8, 6, 6.5, 16, 8, 9.5));
				case CEILING -> Shapes.or(box(8, 8, 6.5, 10, 16, 9.5), box(5, 9, 7, 8, 11, 9), box(6, 15, 6.5, 8, 16, 9.5), box(6, 8, 6.5, 8, 16, 9.5));
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, FACE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
	}
}
