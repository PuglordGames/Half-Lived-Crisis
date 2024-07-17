
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.halflivedcrisis.client.renderer.SMGGrenadeProjectileRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HalfLivedCrisisModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(HalfLivedCrisisModEntities.PISTOL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.SMG_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.MAGNUM_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.SMG_GRENADE_PROJECTILE.get(), SMGGrenadeProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.GAUSS_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}
