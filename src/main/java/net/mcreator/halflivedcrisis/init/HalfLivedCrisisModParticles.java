
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.halflivedcrisis.client.particle.NihilanthLairParticleParticle;
import net.mcreator.halflivedcrisis.client.particle.GaussImpactProjectileParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HalfLivedCrisisModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(HalfLivedCrisisModParticleTypes.GAUSS_IMPACT_PROJECTILE.get(), GaussImpactProjectileParticle::provider);
		event.registerSpriteSet(HalfLivedCrisisModParticleTypes.NIHILANTH_LAIR_PARTICLE.get(), NihilanthLairParticleParticle::provider);
	}
}
