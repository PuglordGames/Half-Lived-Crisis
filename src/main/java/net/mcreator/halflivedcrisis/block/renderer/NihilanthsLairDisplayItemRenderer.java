package net.mcreator.halflivedcrisis.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.block.model.NihilanthsLairDisplayModel;
import net.mcreator.halflivedcrisis.block.display.NihilanthsLairDisplayItem;

public class NihilanthsLairDisplayItemRenderer extends GeoItemRenderer<NihilanthsLairDisplayItem> {
	public NihilanthsLairDisplayItemRenderer() {
		super(new NihilanthsLairDisplayModel());
	}

	@Override
	public RenderType getRenderType(NihilanthsLairDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
