package net.mcreator.halflivedcrisis.client.renderer;

import com.mojang.math.Axis;

public class CrossbowProjectileRenderer extends EntityRenderer<CrossbowProjectileEntity> {

	private static final ResourceLocation texture = new ResourceLocation("half_lived_crisis:textures/entities/crossbow.png");

	private final ModelCustomModel model;

	public CrossbowProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelCustomModel(context.bakeLayer(ModelCustomModel.LAYER_LOCATION));
	}

	@Override
	public void render(CrossbowProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(CrossbowProjectileEntity entity) {
		return texture;
	}

}
