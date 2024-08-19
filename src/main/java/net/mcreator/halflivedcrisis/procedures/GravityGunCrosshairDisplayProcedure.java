package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class GravityGunCrosshairDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.GRAVITY_GUN.get()) {
			return true;
		}
		return false;
	}
}
