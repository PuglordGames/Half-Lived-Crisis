package net.mcreator.halflivedcrisis.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.block.entity.NihilanthsLairTileEntity;

public class NihilanthsLairBlockModel extends GeoModel<NihilanthsLairTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(NihilanthsLairTileEntity animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/nihilanths_lair.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NihilanthsLairTileEntity animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/nihilanths_lair.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NihilanthsLairTileEntity animatable) {
		return new ResourceLocation("half_lived_crisis", "textures/block/nihilanths_lair.png");
	}
}
