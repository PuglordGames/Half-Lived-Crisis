package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModItems;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

import java.util.function.Supplier;
import java.util.Map;

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
