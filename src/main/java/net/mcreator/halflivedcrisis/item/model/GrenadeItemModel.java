package net.mcreator.halflivedcrisis.item.model;

public class GrenadeItemModel extends GeoModel<GrenadeItem> {
	@Override
	public ResourceLocation getAnimationResource(GrenadeItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/grenade.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GrenadeItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/grenade.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GrenadeItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/grenade.png");
	}
}