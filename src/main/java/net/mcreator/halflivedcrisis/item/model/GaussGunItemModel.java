package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.GaussGunItem;

public class GaussGunItemModel extends GeoModel<GaussGunItem> {
	@Override
	public ResourceLocation getAnimationResource(GaussGunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/gauss_gun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GaussGunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/gauss_gun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GaussGunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/gauss_gun.png");
	}
}
