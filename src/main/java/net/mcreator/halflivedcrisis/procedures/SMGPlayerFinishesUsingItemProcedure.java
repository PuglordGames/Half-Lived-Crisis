package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SMGPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.SMG.get()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("stopped"), true);
			entity.getPersistentData().putBoolean("smg_fired", false);
		}
	}
}
