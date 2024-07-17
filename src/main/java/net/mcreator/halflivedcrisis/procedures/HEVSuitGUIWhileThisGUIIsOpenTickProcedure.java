package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModItems;

import java.util.function.Supplier;
import java.util.Map;

public class HEVSuitGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("JumpModuleAdded") == true
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY)
						.getItem() == HalfLivedCrisisModItems.LONG_JUMP_MODULE.get())) {
			entity.getPersistentData().putBoolean("JumpModuleAdded", false);
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(HalfLivedCrisisModItems.LONG_JUMP_MODULE.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(21)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		} else if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY)
				.getItem() == HalfLivedCrisisModItems.LONG_JUMP_MODULE.get())) {
			entity.getPersistentData().putBoolean("JumpModuleAdded", false);
		}
	}
}
