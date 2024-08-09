
package net.mcreator.halflivedcrisis.client.renderer;

public class WoodCrateRenderer extends MobRenderer<WoodCrateEntity, Modelwood_crate_001a<WoodCrateEntity>> {

	public WoodCrateRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwood_crate_001a(context.bakeLayer(Modelwood_crate_001a.LAYER_LOCATION)), 1f);

	}

	@Override
	public ResourceLocation getTextureLocation(WoodCrateEntity entity) {
		return new ResourceLocation("half_lived_crisis:textures/entities/wood_crate_001a.png");
	}

}
