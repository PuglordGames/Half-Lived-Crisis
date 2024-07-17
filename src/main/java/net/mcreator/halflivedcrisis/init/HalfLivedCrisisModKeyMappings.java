
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

import net.mcreator.halflivedcrisis.network.ReloadMessage;
import net.mcreator.halflivedcrisis.network.HEVSuitOpenGUIMessage;
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
	public static final KeyMapping HEV_SUIT_OPEN_GUI = new KeyMapping("key.half_lived_crisis.hev_suit_open_gui", GLFW.GLFW_KEY_Z, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				HalfLivedCrisisMod.PACKET_HANDLER.sendToServer(new HEVSuitOpenGUIMessage(0, 0));
				HEVSuitOpenGUIMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(RELOAD);
		event.register(HEV_SUIT_OPEN_GUI);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				RELOAD.consumeClick();
				HEV_SUIT_OPEN_GUI.consumeClick();
			}
		}
	}
}
