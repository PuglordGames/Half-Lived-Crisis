
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.halflivedcrisis.client.renderer.WoodCrateRenderer;
import net.mcreator.halflivedcrisis.client.renderer.ShotgunProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.SMGProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.SMGGrenadeProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.PistolProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.MagnumProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.GrenadeProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.CrossbowProjectileRenderer;
import net.mcreator.halflivedcrisis.client.renderer.AR2ProjectileRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HalfLivedCrisisModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(HalfLivedCrisisModEntities.PISTOL_PROJECTILE.get(), PistolProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.SMG_PROJECTILE.get(), SMGProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.MAGNUM_PROJECTILE.get(), MagnumProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.SMG_GRENADE_PROJECTILE.get(), SMGGrenadeProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.GAUSS_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.SHOTGUN_PROJECTILE.get(), ShotgunProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.AR_2_PROJECTILE.get(), AR2ProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.CROSSBOW_PROJECTILE.get(), CrossbowProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.GRENADE_PROJECTILE.get(), GrenadeProjectileRenderer::new);
		event.registerEntityRenderer(HalfLivedCrisisModEntities.WOOD_CRATE.get(), WoodCrateRenderer::new);
	}
}
