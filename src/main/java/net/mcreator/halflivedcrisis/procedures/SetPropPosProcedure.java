package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;
import net.mcreator.halflivedcrisis.entity.WoodCrateEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

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
			HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_x = entity.level()
					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 0.5;
			HalfLivedCrisisModVariables.WorldVariables.get(world).syncData(world);
			HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_y = entity.level()
					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			HalfLivedCrisisModVariables.WorldVariables.get(world).syncData(world);
			HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_z = entity.level()
					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 0.5;
			HalfLivedCrisisModVariables.WorldVariables.get(world).syncData(world);
			HalfLivedCrisisModVariables.WorldVariables.get(world).player_rotation = entity.getYRot();
			HalfLivedCrisisModVariables.WorldVariables.get(world).syncData(world);
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
