
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<SimpleParticleType> GAUSS_IMPACT_PROJECTILE = REGISTRY.register("gauss_impact_projectile", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> NIHILANTH_LAIR_PARTICLE = REGISTRY.register("nihilanth_lair_particle", () -> new SimpleParticleType(true));
}
