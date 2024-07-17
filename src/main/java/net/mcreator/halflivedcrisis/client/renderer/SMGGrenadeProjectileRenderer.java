package net.mcreator.halflivedcrisis.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.halflivedcrisis.entity.SMGGrenadeProjectileEntity;
import net.mcreator.halflivedcrisis.client.model.Modelsmg_grenade;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SMGGrenadeProjectileRenderer extends EntityRenderer<SMGGrenadeProjectileEntity> {
	private static final ResourceLocation texture = new ResourceLocation("half_lived_crisis:textures/entities/smg_grenade.png");
	private final Modelsmg_grenade model;

	public SMGGrenadeProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelsmg_grenade(context.bakeLayer(Modelsmg_grenade.LAYER_LOCATION));
	}

	@Override
	public void render(SMGGrenadeProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SMGGrenadeProjectileEntity entity) {
		return texture;
	}
}
