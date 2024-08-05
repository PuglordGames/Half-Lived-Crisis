
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.halflivedcrisis.network.TauChargeMessage;
import net.mcreator.halflivedcrisis.network.ReloadMessage;
import net.mcreator.halflivedcrisis.network.JumpKeybindMessage;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class HalfLivedCrisisModKeyMappings {
	public static final KeyMapping RELOAD = new KeyMapping("key.half_lived_crisis.reload", GLFW.GLFW_KEY_R, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				HalfLivedCrisisMod.PACKET_HANDLER.sendToServer(new ReloadMessage(0, 0));
				ReloadMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping JUMP_KEYBIND = new KeyMapping("key.half_lived_crisis.jump_keybind", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				HalfLivedCrisisMod.PACKET_HANDLER.sendToServer(new JumpKeybindMessage(0, 0));
				JumpKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TAU_CHARGE = new KeyMapping("key.half_lived_crisis.tau_charge", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				HalfLivedCrisisMod.PACKET_HANDLER.sendToServer(new TauChargeMessage(0, 0));
				TauChargeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TAU_CHARGE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TAU_CHARGE_LASTPRESS);
				HalfLivedCrisisMod.PACKET_HANDLER.sendToServer(new TauChargeMessage(1, dt));
				TauChargeMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long TAU_CHARGE_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(RELOAD);
		event.register(JUMP_KEYBIND);
		event.register(TAU_CHARGE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				RELOAD.consumeClick();
				JUMP_KEYBIND.consumeClick();
				TAU_CHARGE.consumeClick();
			}
		}
	}
}
