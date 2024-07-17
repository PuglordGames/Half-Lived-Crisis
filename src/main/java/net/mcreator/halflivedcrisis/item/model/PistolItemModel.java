package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.PistolItem;

public class PistolItemModel extends GeoModel<PistolItem> {
	@Override
	public ResourceLocation getAnimationResource(PistolItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/pistol.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PistolItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/pistol.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PistolItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/9mm_pistol.png");
	}
}
