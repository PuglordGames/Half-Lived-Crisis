package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.ShotgunItem;

public class ShotgunItemModel extends GeoModel<ShotgunItem> {
	@Override
	public ResourceLocation getAnimationResource(ShotgunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/shotgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShotgunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/shotgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShotgunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/shotgun.png");
	}
}
