package net.mcreator.halflivedcrisis.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.block.model.NihilanthsLairBlockModel;
import net.mcreator.halflivedcrisis.block.entity.NihilanthsLairTileEntity;

public class NihilanthsLairTileRenderer extends GeoBlockRenderer<NihilanthsLairTileEntity> {
	public NihilanthsLairTileRenderer() {
		super(new NihilanthsLairBlockModel());
	}

	@Override
	public RenderType getRenderType(NihilanthsLairTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
