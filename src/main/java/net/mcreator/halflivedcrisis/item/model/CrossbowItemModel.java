package net.mcreator.halflivedcrisis.item.model;

public class CrossbowItemModel extends GeoModel<CrossbowItem> {
	@Override
	public ResourceLocation getAnimationResource(CrossbowItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/crossbow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrossbowItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/crossbow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrossbowItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/crossbow.png");
	}
}