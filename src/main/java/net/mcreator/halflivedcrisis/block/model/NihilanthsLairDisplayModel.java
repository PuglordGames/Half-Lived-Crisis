package net.mcreator.halflivedcrisis.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.halflivedcrisis.block.display.NihilanthsLairDisplayItem;

public class NihilanthsLairDisplayModel extends GeoModel<NihilanthsLairDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(NihilanthsLairDisplayItem animatable) {
		return new ResourceLocation("half_lived_crisis", "animations/nihilanths_lair.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NihilanthsLairDisplayItem animatable) {
		return new ResourceLocation("half_lived_crisis", "geo/nihilanths_lair.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NihilanthsLairDisplayItem entity) {
		return new ResourceLocation("half_lived_crisis", "textures/block/nihilanths_lair.png");
	}
}
