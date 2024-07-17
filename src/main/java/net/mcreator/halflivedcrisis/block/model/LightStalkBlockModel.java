package net.mcreator.halflivedcrisis.block.model;

public class LightStalkBlockModel extends GeoModel<LightStalkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(LightStalkTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("half_lived_crisis", "animations/light_stalk.animation.json");
		if (blockstate == 2)
			return new ResourceLocation("half_lived_crisis", "animations/light_stalk_hidden.animation.json");
		return new ResourceLocation("half_lived_crisis", "animations/light_stalk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LightStalkTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("half_lived_crisis", "geo/light_stalk.geo.json");
		if (blockstate == 2)
			return new ResourceLocation("half_lived_crisis", "geo/light_stalk_hidden.geo.json");
		return new ResourceLocation("half_lived_crisis", "geo/light_stalk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LightStalkTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("half_lived_crisis", "textures/block/light_stalk.png");
		if (blockstate == 2)
			return new ResourceLocation("half_lived_crisis", "textures/block/light_stalk.png");
		return new ResourceLocation("half_lived_crisis", "textures/block/light_stalk.png");
	}
}