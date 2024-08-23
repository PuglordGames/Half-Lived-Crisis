package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;

public class ChangeOICWAltFireOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).oicw_alt_fire_mode).equals("Grenade")) {
			{
				String _setval = "Scope";
				entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.oicw_alt_fire_mode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).oicw_alt_fire_mode).equals("Scope")) {
			{
				String _setval = "Grenade";
				entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.oicw_alt_fire_mode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
