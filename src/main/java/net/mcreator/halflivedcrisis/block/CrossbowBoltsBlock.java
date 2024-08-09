
package net.mcreator.halflivedcrisis.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CrossbowBoltsBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public CrossbowBoltsBlock() {
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
				case FLOOR -> Shapes.or(box(6.75, 0, 0, 7.75, 1, 17), box(8.25, 0, 0, 9.25, 1, 17), box(7.725, 0.6, -0.25, 9.225, 2.1, 17.25), box(6.775, 0.6, -0.25, 8.275, 2.1, 17.25), box(7.275, 0.1, -0.25, 8.775, 1.6, 17.25),
						box(7.5, 1.25, 0, 8.5, 2.25, 17));
				case WALL -> Shapes.or(box(6.75, -1, 0, 7.75, 16, 1), box(8.25, -1, 0, 9.25, 16, 1), box(7.725, -1.25, 0.6, 9.225, 16.25, 2.1), box(6.775, -1.25, 0.6, 8.275, 16.25, 2.1), box(7.275, -1.25, 0.1, 8.775, 16.25, 1.6),
						box(7.5, -1, 1.25, 8.5, 16, 2.25));
				case CEILING -> Shapes.or(box(8.25, 15, 0, 9.25, 16, 17), box(6.75, 15, 0, 7.75, 16, 17), box(6.775, 13.9, -0.25, 8.275, 15.4, 17.25), box(7.725, 13.9, -0.25, 9.225, 15.4, 17.25), box(7.225, 14.4, -0.25, 8.725, 15.9, 17.25),
						box(7.5, 13.75, 0, 8.5, 14.75, 17));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(8.25, 0, -1, 9.25, 1, 16), box(6.75, 0, -1, 7.75, 1, 16), box(6.775, 0.6, -1.25, 8.275, 2.1, 16.25), box(7.725, 0.6, -1.25, 9.225, 2.1, 16.25), box(7.225, 0.1, -1.25, 8.725, 1.6, 16.25),
						box(7.5, 1.25, -1, 8.5, 2.25, 16));
				case WALL -> Shapes.or(box(8.25, -1, 15, 9.25, 16, 16), box(6.75, -1, 15, 7.75, 16, 16), box(6.775, -1.25, 13.9, 8.275, 16.25, 15.4), box(7.725, -1.25, 13.9, 9.225, 16.25, 15.4), box(7.225, -1.25, 14.4, 8.725, 16.25, 15.9),
						box(7.5, -1, 13.75, 8.5, 16, 14.75));
				case CEILING -> Shapes.or(box(6.75, 15, -1, 7.75, 16, 16), box(8.25, 15, -1, 9.25, 16, 16), box(7.725, 13.9, -1.25, 9.225, 15.4, 16.25), box(6.775, 13.9, -1.25, 8.275, 15.4, 16.25), box(7.275, 14.4, -1.25, 8.775, 15.9, 16.25),
						box(7.5, 13.75, -1, 8.5, 14.75, 16));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(0, 0, 8.25, 17, 1, 9.25), box(0, 0, 6.75, 17, 1, 7.75), box(-0.25, 0.6, 6.775, 17.25, 2.1, 8.275), box(-0.25, 0.6, 7.725, 17.25, 2.1, 9.225), box(-0.25, 0.1, 7.225, 17.25, 1.6, 8.725),
						box(0, 1.25, 7.5, 17, 2.25, 8.5));
				case WALL -> Shapes.or(box(0, -1, 8.25, 1, 16, 9.25), box(0, -1, 6.75, 1, 16, 7.75), box(0.6, -1.25, 6.775, 2.1, 16.25, 8.275), box(0.6, -1.25, 7.725, 2.1, 16.25, 9.225), box(0.1, -1.25, 7.225, 1.6, 16.25, 8.725),
						box(1.25, -1, 7.5, 2.25, 16, 8.5));
				case CEILING -> Shapes.or(box(0, 15, 6.75, 17, 16, 7.75), box(0, 15, 8.25, 17, 16, 9.25), box(-0.25, 13.9, 7.725, 17.25, 15.4, 9.225), box(-0.25, 13.9, 6.775, 17.25, 15.4, 8.275), box(-0.25, 14.4, 7.275, 17.25, 15.9, 8.775),
						box(0, 13.75, 7.5, 17, 14.75, 8.5));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(-1, 0, 6.75, 16, 1, 7.75), box(-1, 0, 8.25, 16, 1, 9.25), box(-1.25, 0.6, 7.725, 16.25, 2.1, 9.225), box(-1.25, 0.6, 6.775, 16.25, 2.1, 8.275), box(-1.25, 0.1, 7.275, 16.25, 1.6, 8.775),
						box(-1, 1.25, 7.5, 16, 2.25, 8.5));
				case WALL -> Shapes.or(box(15, -1, 6.75, 16, 16, 7.75), box(15, -1, 8.25, 16, 16, 9.25), box(13.9, -1.25, 7.725, 15.4, 16.25, 9.225), box(13.9, -1.25, 6.775, 15.4, 16.25, 8.275), box(14.4, -1.25, 7.275, 15.9, 16.25, 8.775),
						box(13.75, -1, 7.5, 14.75, 16, 8.5));
				case CEILING -> Shapes.or(box(-1, 15, 8.25, 16, 16, 9.25), box(-1, 15, 6.75, 16, 16, 7.75), box(-1.25, 13.9, 6.775, 16.25, 15.4, 8.275), box(-1.25, 13.9, 7.725, 16.25, 15.4, 9.225), box(-1.25, 14.4, 7.225, 16.25, 15.9, 8.725),
						box(-1, 13.75, 7.5, 16, 14.75, 8.5));
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
		CrossbowBoltsEntityCollidesInTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
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
		CrossbowBoltsOnBlockRightClickedProcedure.execute();
		return InteractionResult.SUCCESS;
	}
}