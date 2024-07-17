package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class HEVsuitSlot21ContentChangeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.LONG_JUMP_MODULE
				.get()) {
			entity.getPersistentData().putBoolean("JumpModuleAdded", true);
		} else if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY)
				.getItem() == HalfLivedCrisisModItems.LONG_JUMP_MODULE.get())) {
			HalfLivedCrisisMod.queueServerWork(1, () -> {
				entity.getPersistentData().putBoolean("JumpModuleAdded", false);
			});
		}
	}
}
