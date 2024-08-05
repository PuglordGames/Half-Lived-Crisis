
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.halflivedcrisis.client.model.Modelwood_crate_001a;
import net.mcreator.halflivedcrisis.client.model.Modelsmg_grenade;
import net.mcreator.halflivedcrisis.client.model.Modelrpg_rocket;
import net.mcreator.halflivedcrisis.client.model.Modelhev_suit;
import net.mcreator.halflivedcrisis.client.model.Modelgrenade_projectile;
import net.mcreator.halflivedcrisis.client.model.Modelcrossbow_bolt;
import net.mcreator.halflivedcrisis.client.model.Modelbullet;
import net.mcreator.halflivedcrisis.client.model.ModelCustomModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class HalfLivedCrisisModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modelhev_suit.LAYER_LOCATION, Modelhev_suit::createBodyLayer);
		event.registerLayerDefinition(Modelwood_crate_001a.LAYER_LOCATION, Modelwood_crate_001a::createBodyLayer);
		event.registerLayerDefinition(Modelsmg_grenade.LAYER_LOCATION, Modelsmg_grenade::createBodyLayer);
		event.registerLayerDefinition(Modelrpg_rocket.LAYER_LOCATION, Modelrpg_rocket::createBodyLayer);
		event.registerLayerDefinition(Modelbullet.LAYER_LOCATION, Modelbullet::createBodyLayer);
		event.registerLayerDefinition(Modelcrossbow_bolt.LAYER_LOCATION, Modelcrossbow_bolt::createBodyLayer);
		event.registerLayerDefinition(Modelgrenade_projectile.LAYER_LOCATION, Modelgrenade_projectile::createBodyLayer);
	}
}
