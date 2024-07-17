package net.mcreator.halflivedcrisis.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.item.SMGItem;

public class SMGItemModel extends GeoModel<SMGItem> {
	@Override
	public ResourceLocation getAnimationResource(SMGItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/smg.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SMGItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/smg.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SMGItem animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/item/smg.png");
	}
}
