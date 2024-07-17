package net.mcreator.halflivedcrisis.block.renderer;

public class LightStalkTileRenderer extends GeoBlockRenderer<LightStalkTileEntity> {
	public LightStalkTileRenderer() {
		super(new LightStalkBlockModel());
	}

	@Override
	public RenderType getRenderType(LightStalkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}