package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TauChargeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.GAUSS_GUN.get()) {
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).gauss_ammo != 0) {
				entity.getPersistentData().putBoolean("tau_shot_no_ammo", false);
				{
					double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).gauss_ammo - 1;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gauss_ammo = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				HalfLivedCrisisMod.queueServerWork(5, () -> {
					entity.getPersistentData().putBoolean("tau_charging", true);
					entity.getPersistentData().putDouble("tau_charge", 25);
				});
			}
		}
	}
}
