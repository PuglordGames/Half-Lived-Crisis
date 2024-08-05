package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.GravityGunItem;

public class GravityGunItemModel extends GeoModel<GravityGunItem> {
	@Override
	public ResourceLocation getAnimationResource(GravityGunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/gravity_gun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GravityGunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/gravity_gun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GravityGunItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/gravity_gun.png");
	}
}
