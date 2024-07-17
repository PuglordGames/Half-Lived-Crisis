package net.mcreator.halflivedcrisis.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.block.entity.XenSporeTileEntity;

public class XenSporeBlockModel extends GeoModel<XenSporeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(XenSporeTileEntity animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/xen_spore.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(XenSporeTileEntity animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/xen_spore.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(XenSporeTileEntity animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/block/xen_spore.png");
	}
}
