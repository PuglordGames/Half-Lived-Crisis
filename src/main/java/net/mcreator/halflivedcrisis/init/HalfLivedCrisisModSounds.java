
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<SoundEvent> PISTOL_SHOOT = REGISTRY.register("pistol_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "pistol_shoot")));
	public static final RegistryObject<SoundEvent> PISTOL_RELOAD = REGISTRY.register("pistol_reload", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "pistol_reload")));
	public static final RegistryObject<SoundEvent> SMG_RELOAD = REGISTRY.register("smg_reload", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "smg_reload")));
	public static final RegistryObject<SoundEvent> MAGNUM_SHOOT = REGISTRY.register("magnum_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "magnum_shoot")));
	public static final RegistryObject<SoundEvent> MAGNUM_RELOAD = REGISTRY.register("magnum_reload", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "magnum_reload")));
	public static final RegistryObject<SoundEvent> SMG_SHOOT = REGISTRY.register("smg_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "smg_shoot")));
	public static final RegistryObject<SoundEvent> SMG_GRENADE_SHOOT = REGISTRY.register("smg_grenade_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "smg_grenade_shoot")));
	public static final RegistryObject<SoundEvent> GAUSS_SHOOT = REGISTRY.register("gauss_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "gauss_shoot")));
	public static final RegistryObject<SoundEvent> TRANSCENDENT = REGISTRY.register("transcendent", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "transcendent")));
	public static final RegistryObject<SoundEvent> HEV_SUIT_STARTUP = REGISTRY.register("hev_suit_startup", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("half_lived_crisis", "hev_suit_startup")));
}
