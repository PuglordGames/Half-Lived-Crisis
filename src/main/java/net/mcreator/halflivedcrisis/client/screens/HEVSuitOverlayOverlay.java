
package net.mcreator.halflivedcrisis.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.halflivedcrisis.procedures.SuitBatteryDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.ShotgunDoubleShotCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.ShotgunCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.SMGCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.PulseRifleCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.PistolCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.MagnumCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.HealthDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.HEVSuitOverlayDisplayOverlayIngameProcedure;
import net.mcreator.halflivedcrisis.procedures.GrenadeCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.GaussGunCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.CrowbarCrosshairDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.AmmoDisplayProcedure;
import net.mcreator.halflivedcrisis.procedures.AmmoDisplayLogicProcedure;
import net.mcreator.halflivedcrisis.procedures.AR2EnergyBallCrosshairDisplayProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class HEVSuitOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (HEVSuitOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/hev_suit_overlay.png"), 0, 0, 0, 0, w, h, w, h);
			if (CrowbarCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/crowbar_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (PistolCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/pistol_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (SMGCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/smg_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (GrenadeCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/grenade_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (MagnumCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/magnum_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (GaussGunCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/gauss_gun_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (ShotgunCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/shotgun_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (ShotgunDoubleShotCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/shotgun_double_shot_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (PulseRifleCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/ar2_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (AR2EnergyBallCrosshairDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/ar2_energy_ball_crosshair.png"), w / 2 + -8, h / 2 + -8, 0, 0, 15, 15, 15, 15);
			}
			if (AmmoDisplayLogicProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/health_overlay.png"), w - 57, h - 24, 0, 0, 32, 24, 32, 24);
			}
			if (AmmoDisplayLogicProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/smg_ammo.png"), w - 55, h - 13, 0, 0, 8, 3, 8, 3);
			}
			event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/health_overlay.png"), 6, h - 24, 0, 0, 32, 24, 32, 24);

			event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/health.png"), 7, h - 24, 0, 0, 32, 24, 32, 24);

			event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/health_overlay.png"), 46, h - 24, 0, 0, 32, 24, 32, 24);

			event.getGuiGraphics().blit(new ResourceLocation("half_lived_crisis:textures/screens/suit.png"), 47, h - 24, 0, 0, 32, 24, 32, 24);

			if (AmmoDisplayLogicProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						AmmoDisplayProcedure.execute(entity), w - 41, h - 16, -13312, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					HealthDisplayProcedure.execute(entity), 20, h - 16, -13312, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					SuitBatteryDisplayProcedure.execute(entity), 60, h - 16, -13312, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
