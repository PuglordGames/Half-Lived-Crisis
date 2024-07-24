
package net.mcreator.halflivedcrisis.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.procedures.MedkitOnBlockRightClickedProcedure;
import net.mcreator.halflivedcrisis.procedures.MedkitEntityCollidesInTheBlockProcedure;

public class MedkitBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public MedkitBlock() {
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
				case FLOOR -> Shapes.or(box(2, 2, 3, 6, 3, 6), box(8.5, 2, 5, 10.5, 4, 10), box(2, 0, 3, 11, 2, 13), box(2, 2, 3, 11, 4, 13));
				case WALL -> Shapes.or(box(2, 10, 2, 6, 13, 3), box(8.5, 6, 2, 10.5, 11, 4), box(2, 3, 0, 11, 13, 2), box(2, 3, 2, 11, 13, 4));
				case CEILING -> Shapes.or(box(10, 13, 3, 14, 14, 6), box(5.5, 12, 5, 7.5, 14, 10), box(5, 14, 3, 14, 16, 13), box(5, 12, 3, 14, 14, 13));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(10, 2, 10, 14, 3, 13), box(5.5, 2, 6, 7.5, 4, 11), box(5, 0, 3, 14, 2, 13), box(5, 2, 3, 14, 4, 13));
				case WALL -> Shapes.or(box(10, 10, 13, 14, 13, 14), box(5.5, 6, 12, 7.5, 11, 14), box(5, 3, 14, 14, 13, 16), box(5, 3, 12, 14, 13, 14));
				case CEILING -> Shapes.or(box(2, 13, 10, 6, 14, 13), box(8.5, 12, 6, 10.5, 14, 11), box(2, 14, 3, 11, 16, 13), box(2, 12, 3, 11, 14, 13));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(3, 2, 10, 6, 3, 14), box(5, 2, 5.5, 10, 4, 7.5), box(3, 0, 5, 13, 2, 14), box(3, 2, 5, 13, 4, 14));
				case WALL -> Shapes.or(box(2, 10, 10, 3, 13, 14), box(2, 6, 5.5, 4, 11, 7.5), box(0, 3, 5, 2, 13, 14), box(2, 3, 5, 4, 13, 14));
				case CEILING -> Shapes.or(box(3, 13, 2, 6, 14, 6), box(5, 12, 8.5, 10, 14, 10.5), box(3, 14, 2, 13, 16, 11), box(3, 12, 2, 13, 14, 11));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(10, 2, 2, 13, 3, 6), box(6, 2, 8.5, 11, 4, 10.5), box(3, 0, 2, 13, 2, 11), box(3, 2, 2, 13, 4, 11));
				case WALL -> Shapes.or(box(13, 10, 2, 14, 13, 6), box(12, 6, 8.5, 14, 11, 10.5), box(14, 3, 2, 16, 13, 11), box(12, 3, 2, 14, 13, 11));
				case CEILING -> Shapes.or(box(10, 13, 10, 13, 14, 14), box(6, 12, 5.5, 11, 14, 7.5), box(3, 14, 5, 13, 16, 14), box(3, 12, 5, 13, 14, 14));
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

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		MedkitEntityCollidesInTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		MedkitOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
