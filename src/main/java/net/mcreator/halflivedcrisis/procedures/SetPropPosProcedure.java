package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class SetPropPosProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("pick_up") == true) {
		}
		if (!world.getEntitiesOfClass(WoodCrateEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			if (!(!world.getEntitiesOfClass(WoodCrateEntity.class, AABB.ofSize(new Vec3(x, (y - 1), z), 1, 1, 1), e -> true).isEmpty())) {
				if ((entity.getDirection()) == Direction.NORTH) {
					((Entity) world.getEntitiesOfClass(WoodCrateEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.1, 1.1, 1.1), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, (-0.1)));
				}
				if ((entity.getDirection()) == Direction.SOUTH) {
					((Entity) world.getEntitiesOfClass(WoodCrateEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.1, 1.1, 1.1), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, 0.1));
				}
				if ((entity.getDirection()) == Direction.WEST) {
					((Entity) world.getEntitiesOfClass(WoodCrateEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.1, 1.1, 1.1), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3((-0.1), 0, 0));
				}
				if ((entity.getDirection()) == Direction.EAST) {
					((Entity) world.getEntitiesOfClass(WoodCrateEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.1, 1.1, 1.1), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0.1, 0, 0));
				}
			}
		}
	}
}
