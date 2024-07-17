package net.mcreator.halflivedcrisis.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.block.model.LightStalkDisplayModel;
import net.mcreator.halflivedcrisis.block.display.LightStalkDisplayItem;

public class LightStalkDisplayItemRenderer extends GeoItemRenderer<LightStalkDisplayItem> {
	public LightStalkDisplayItemRenderer() {
		super(new LightStalkDisplayModel());
	}

	@Override
	public RenderType getRenderType(LightStalkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
