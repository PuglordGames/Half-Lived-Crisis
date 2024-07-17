package net.mcreator.halflivedcrisis.procedures;

import org.joml.Vector3f;
import org.joml.Matrix4f;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Camera;

import javax.annotation.Nullable;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

import com.mojang.blaze3d.vertex.PoseStack;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class XenDimensionSetupProcedure {
	public static abstract class HalfLivedCrisisModDimensionEffects extends DimensionSpecialEffects {
		public static final List<Predicate<Object[]>> CUSTOM_CLOUDS = new ArrayList<>();
		public static final List<Predicate<Object[]>> CUSTOM_SKY = new ArrayList<>();
		public static final List<Predicate<Object[]>> CUSTOM_WEATHER = new ArrayList<>();
		public static final List<Predicate<Object[]>> CUSTOM_EFFECTS = new ArrayList<>();
		public static final List<Consumer<Object[]>> CUSTOM_LIGHTS = new ArrayList<>();

		public HalfLivedCrisisModDimensionEffects(float cloudHeight, boolean hasGround, DimensionSpecialEffects.SkyType skyType, boolean forceBrightLightmap, boolean constantAmbientLight) {
			super(cloudHeight, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
		}

		@Override
		public boolean renderClouds(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, double camX, double camY, double camZ, Matrix4f projectionMatrix) {
			boolean flag = false;
			if (CUSTOM_CLOUDS != null && !CUSTOM_CLOUDS.isEmpty()) {
				for (Predicate<Object[]> predicate : CUSTOM_CLOUDS)
					flag |= predicate.test(new Object[]{level, ticks, partialTick, poseStack, camX, camY, camZ, projectionMatrix});
				CUSTOM_CLOUDS.clear();
			}
			return flag;
		}

		@Override
		public boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
			boolean flag = false;
			if (CUSTOM_SKY != null && !CUSTOM_SKY.isEmpty()) {
				for (Predicate<Object[]> predicate : CUSTOM_SKY)
					flag |= predicate.test(new Object[]{level, ticks, partialTick, poseStack, camera, projectionMatrix, isFoggy, setupFog});
				CUSTOM_SKY.clear();
			}
			return flag;
		}

		@Override
		public boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ) {
			boolean flag = false;
			if (CUSTOM_WEATHER != null && !CUSTOM_WEATHER.isEmpty()) {
				for (Predicate<Object[]> predicate : CUSTOM_WEATHER)
					flag |= predicate.test(new Object[]{level, ticks, partialTick, lightTexture, camX, camY, camZ});
				CUSTOM_WEATHER.clear();
			}
			return flag;
		}

		@Override
		public boolean tickRain(ClientLevel level, int ticks, Camera camera) {
			boolean flag = false;
			if (CUSTOM_EFFECTS != null && !CUSTOM_EFFECTS.isEmpty()) {
				for (Predicate<Object[]> predicate : CUSTOM_EFFECTS)
					flag |= predicate.test(new Object[]{level, ticks, camera});
				CUSTOM_EFFECTS.clear();
			}
			return flag;
		}

		@Override
		public void adjustLightmapColors(ClientLevel level, float partialTick, float skyDarken, float blockLightRedFlicker, float skyLight, int pixelX, int pixelY, Vector3f colors) {
			if (CUSTOM_LIGHTS != null && !CUSTOM_LIGHTS.isEmpty()) {
				for (Consumer<Object[]> consumer : CUSTOM_LIGHTS)
					consumer.accept(new Object[]{level, partialTick, skyDarken, blockLightRedFlicker, skyLight, pixelX, pixelY, colors});
				if (pixelX == 15 && pixelY == 15)
					CUSTOM_LIGHTS.clear();
			}
		}
	}

	private static RegisterDimensionSpecialEffectsEvent provider = null;

	public static void register(ResourceKey<Level> dimension, DimensionSpecialEffects effects) {
		provider.register(dimension.location(), effects);
	}

	public static DimensionSpecialEffects createOverworldEffects(final boolean constantWhiteLight, final boolean constantAmbientLight, final boolean fog) {
		return new HalfLivedCrisisModDimensionEffects(192.0F, true, DimensionSpecialEffects.SkyType.NORMAL, constantWhiteLight, constantAmbientLight) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color.multiply(sunHeight * 0.94F + 0.06F, sunHeight * 0.94F + 0.06F, sunHeight * 0.91F + 0.09F);
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return fog;
			}
		};
	}

	public static DimensionSpecialEffects createNetherEffects(final boolean constantWhiteLight, final boolean constantAmbientLight, final boolean fog) {
		return new HalfLivedCrisisModDimensionEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, constantWhiteLight, constantAmbientLight) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color;
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return fog;
			}
		};
	}

	public static DimensionSpecialEffects createEndEffects(final boolean constantWhiteLight, final boolean constantAmbientLight, final boolean fog) {
		return new HalfLivedCrisisModDimensionEffects(Float.NaN, false, DimensionSpecialEffects.SkyType.END, constantWhiteLight, constantAmbientLight) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color.scale(0.15F);
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return fog;
			}
		};
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void setupDimensions(RegisterDimensionSpecialEffectsEvent event) {
		provider = event;
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		register(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("half_lived_crisis:xen")), createNetherEffects(false, true, false));
	}
}