package net.mcreator.halflivedcrisis.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.block.display.LightStalkDisplayItem;

public class LightStalkDisplayModel extends GeoModel<LightStalkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(LightStalkDisplayItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/light_stalk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LightStalkDisplayItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/light_stalk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LightStalkDisplayItem entity) {
		return new ResourceLocation("half_lived_crisis", "textures/block/light_stalk.png");
	}
}
