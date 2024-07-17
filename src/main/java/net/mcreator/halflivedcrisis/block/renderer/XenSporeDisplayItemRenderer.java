package net.mcreator.halflivedcrisis.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.block.model.XenSporeDisplayModel;
import net.mcreator.halflivedcrisis.block.display.XenSporeDisplayItem;

public class XenSporeDisplayItemRenderer extends GeoItemRenderer<XenSporeDisplayItem> {
	public XenSporeDisplayItemRenderer() {
		super(new XenSporeDisplayModel());
	}

	@Override
	public RenderType getRenderType(XenSporeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
