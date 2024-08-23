package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.OICWItem;

public class OICWItemModel extends GeoModel<OICWItem> {
	@Override
	public ResourceLocation getAnimationResource(OICWItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/oicw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OICWItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/oicw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OICWItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/oicw.png");
	}
}
