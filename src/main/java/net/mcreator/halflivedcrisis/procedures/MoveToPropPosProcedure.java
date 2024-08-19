package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class MoveToPropPosProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("source:physics_props")))==true&&entity.getPersistentData().getBoolean("picked_up")==true) {{
Entity _ent = entity;
_ent.teleportTo(,,);
if (_ent instanceof ServerPlayer _serverPlayer)
_serverPlayer.connection.teleport(, , , _ent.getYRot(), _ent.getXRot());
}if (entity instanceof LivingEntity _entity) _entity.setHealth(entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1);entity.setNoGravity(true);{
Entity _ent = entity;
_ent.setYRot((float));
_ent.setXRot(entity.getXRot());
_ent.setYBodyRot(_ent.getYRot());
_ent.setYHeadRot(_ent.getYRot());
_ent.yRotO = _ent.getYRot();
_ent.xRotO = _ent.getXRot();
if (_ent instanceof LivingEntity _entity) {
_entity.yBodyRotO = _entity.getYRot();
_entity.yHeadRotO = _entity.getYRot();
}
}}if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("source:physics_props")))==true&&entity.getPersistentData().getBoolean("picked_up")==false) {entity.setNoGravity(false);}
}
}
