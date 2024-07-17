package net.mcreator.halflivedcrisis.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.block.display.XenSporeDisplayItem;

public class XenSporeDisplayModel extends GeoModel<XenSporeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(XenSporeDisplayItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/xen_spore.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(XenSporeDisplayItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/xen_spore.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(XenSporeDisplayItem entity) {
		return new ResourceLocation("half_lived_crisis", "textures/block/xen_spore.png");
	}
}
