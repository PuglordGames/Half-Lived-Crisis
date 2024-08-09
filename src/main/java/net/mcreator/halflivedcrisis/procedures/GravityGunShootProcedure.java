package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class GravityGunShootProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.GRAVITY_GUN.get() && !sourceentity.isShiftKeyDown()
				&& entity.getPersistentData().getBoolean("picked_up") == true && sourceentity.getPersistentData().getBoolean("pick_up") == true && !sourceentity.isSprinting()) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof GravityGunItem)
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "shoot");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:gravity_gun_shoot")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:gravity_gun_shoot")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if ((sourceentity.getDirection()) == Direction.NORTH) {
				entity.setDeltaMovement(new Vec3(0, 1, (-5)));
				sourceentity.getPersistentData().putBoolean("pick_up", false);
				entity.getPersistentData().putBoolean("picked_up", false);
			}
			if ((sourceentity.getDirection()) == Direction.SOUTH) {
				entity.setDeltaMovement(new Vec3(0, 1, 5));
				sourceentity.getPersistentData().putBoolean("pick_up", false);
				entity.getPersistentData().putBoolean("picked_up", false);
			}
			if ((sourceentity.getDirection()) == Direction.WEST) {
				entity.setDeltaMovement(new Vec3((-5), 1, 0));
				sourceentity.getPersistentData().putBoolean("pick_up", false);
				entity.getPersistentData().putBoolean("picked_up", false);
			}
			if ((sourceentity.getDirection()) == Direction.EAST) {
				entity.setDeltaMovement(new Vec3(5, 1, 0));
				sourceentity.getPersistentData().putBoolean("pick_up", false);
				entity.getPersistentData().putBoolean("picked_up", false);
			}
			if ((sourceentity.getDirection()) == Direction.UP) {
				entity.setDeltaMovement(new Vec3(0, 5, 0));
				sourceentity.getPersistentData().putBoolean("pick_up", false);
				entity.getPersistentData().putBoolean("picked_up", false);
			}
			if ((sourceentity.getDirection()) == Direction.DOWN) {
				entity.setDeltaMovement(new Vec3(0, (-5), 0));
				sourceentity.getPersistentData().putBoolean("pick_up", false);
				entity.getPersistentData().putBoolean("picked_up", false);
			}
		}
	}
}
