package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.CrowbarItem;

public class CrowbarItemModel extends GeoModel<CrowbarItem> {
	@Override
	public ResourceLocation getAnimationResource(CrowbarItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/crowbar.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrowbarItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/crowbar.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrowbarItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/crowbar.png");
	}
}
