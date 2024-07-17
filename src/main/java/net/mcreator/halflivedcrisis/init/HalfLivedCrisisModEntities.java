
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.entity.SMGProjectileEntity;
import net.mcreator.halflivedcrisis.entity.SMGGrenadeProjectileEntity;
import net.mcreator.halflivedcrisis.entity.PistolProjectileEntity;
import net.mcreator.halflivedcrisis.entity.MagnumProjectileEntity;
import net.mcreator.halflivedcrisis.entity.GaussProjectileEntity;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HalfLivedCrisisModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<EntityType<PistolProjectileEntity>> PISTOL_PROJECTILE = register("pistol_projectile", EntityType.Builder.<PistolProjectileEntity>of(PistolProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PistolProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SMGProjectileEntity>> SMG_PROJECTILE = register("smg_projectile",
			EntityType.Builder.<SMGProjectileEntity>of(SMGProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(SMGProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MagnumProjectileEntity>> MAGNUM_PROJECTILE = register("magnum_projectile", EntityType.Builder.<MagnumProjectileEntity>of(MagnumProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MagnumProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SMGGrenadeProjectileEntity>> SMG_GRENADE_PROJECTILE = register("smg_grenade_projectile", EntityType.Builder.<SMGGrenadeProjectileEntity>of(SMGGrenadeProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SMGGrenadeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GaussProjectileEntity>> GAUSS_PROJECTILE = register("gauss_projectile", EntityType.Builder.<GaussProjectileEntity>of(GaussProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GaussProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
	}
}
