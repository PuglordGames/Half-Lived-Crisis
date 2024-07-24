package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModItems;

public class PulseRifleCrosshairDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.AR_2.get() && !entity.isShiftKeyDown()) {
			return true;
		}
		return false;
	}
}
