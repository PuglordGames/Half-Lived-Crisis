package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SpareAmmoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).spare_ammo;
	}
}
