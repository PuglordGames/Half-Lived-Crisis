package net.mcreator.halflivedcrisis.block.renderer;

public class LightStalkDisplayItemRenderer extends GeoItemRenderer<LightStalkDisplayItem> {
	public LightStalkDisplayItemRenderer() {
		super(new LightStalkDisplayModel());
	}

	@Override
	public RenderType getRenderType(LightStalkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}