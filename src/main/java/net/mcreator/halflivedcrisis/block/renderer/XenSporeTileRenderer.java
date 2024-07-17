package net.mcreator.halflivedcrisis.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.block.model.XenSporeBlockModel;
import net.mcreator.halflivedcrisis.block.entity.XenSporeTileEntity;

public class XenSporeTileRenderer extends GeoBlockRenderer<XenSporeTileEntity> {
	public XenSporeTileRenderer() {
		super(new XenSporeBlockModel());
	}

	@Override
	public RenderType getRenderType(XenSporeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
