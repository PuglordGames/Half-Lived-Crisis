package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MoveToPropPosProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("source:physics_props"))) == true && entity.getPersistentData().getBoolean("picked_up") == true) {
			{
				Entity _ent = entity;
				_ent.teleportTo(HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_x, HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_y, HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_x, HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_y,
							HalfLivedCrisisModVariables.WorldVariables.get(world).prop_pos_z, _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			entity.setNoGravity(true);
			{
				Entity _ent = entity;
				_ent.setYRot((float) HalfLivedCrisisModVariables.WorldVariables.get(world).player_rotation);
				_ent.setXRot(entity.getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("source:physics_props"))) == true && entity.getPersistentData().getBoolean("picked_up") == false) {
			entity.setNoGravity(false);
		}
	}
}
