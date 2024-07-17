package net.mcreator.halflivedcrisis.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.block.model.LightStalkBlockModel;
import net.mcreator.halflivedcrisis.block.entity.LightStalkTileEntity;

public class LightStalkTileRenderer extends GeoBlockRenderer<LightStalkTileEntity> {
	public LightStalkTileRenderer() {
		super(new LightStalkBlockModel());
	}

	@Override
	public RenderType getRenderType(LightStalkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
