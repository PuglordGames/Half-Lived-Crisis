package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;

public class SuitBatteryDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).suit_battery_display;
	}
}
