package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.MagnumItem;

public class MagnumItemModel extends GeoModel<MagnumItem> {
	@Override
	public ResourceLocation getAnimationResource(MagnumItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/.357_magnum.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MagnumItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/.357_magnum.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MagnumItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/.357_magnum.png");
	}
}
