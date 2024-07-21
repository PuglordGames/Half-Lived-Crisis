package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.AR2Item;

public class AR2ItemModel extends GeoModel<AR2Item> {
	@Override
	public ResourceLocation getAnimationResource(AR2Item animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/ar2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AR2Item animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/ar2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AR2Item animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/ar2.png");
	}
}
