package net.mcreator.halflivedcrisis.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModBlockEntities;
import net.mcreator.halflivedcrisis.block.renderer.XenSporeTileRenderer;
import net.mcreator.halflivedcrisis.block.renderer.NihilanthsLairTileRenderer;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

@Mod.EventBusSubscriber(modid = HalfLivedCrisisMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(HalfLivedCrisisModBlockEntities.XEN_SPORE.get(), context -> new XenSporeTileRenderer());
		event.registerBlockEntityRenderer(HalfLivedCrisisModBlockEntities.NIHILANTHS_LAIR.get(), context -> new NihilanthsLairTileRenderer());
	}
}
