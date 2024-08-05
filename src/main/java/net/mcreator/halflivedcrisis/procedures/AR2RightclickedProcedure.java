package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;

public class AR2RightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).pusle_rifle_ammo != 0) {
			entity.getPersistentData().putBoolean("pusle_rilfe_fired", true);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough ammo."), true);
		}
	}
}
