package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class CrossbowRightclickedProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
ItemStack itemstack
) {
if(
entity == null
) return ;
if ((entity instanceof Player _playerHasItem? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.CROSSBOW_BOLTS.get())):false)&&==0) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.CROSSBOW_BOLTS.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}}if (!=0) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.CROSSBOW_BOLTS.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:crossbow_shoot")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:crossbow_shoot")),
SoundSource.NEUTRAL, 1, 1, false);
}
}
{
Entity _shootFrom = entity;
Level projectileLevel = _shootFrom.level();
if (!projectileLevel.isClientSide()) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
AbstractArrow entityToSpawn = new CrossbowProjectileEntity(HalfLivedCrisisModEntities.DELETED_MOD_ELEMENT.get(), level);
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setKnockback(knockback);
entityToSpawn.setSilent(true);
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, (float)3.3, 0);
_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 30, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}
}if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() instanceof CrossbowItem)
(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "shoot");if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(itemstack.getItem(), (int)38.6);HalfLivedCrisisMod.queueServerWork((int)38.6, () -> {
if (entity instanceof Player _playerHasItem? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.CROSSBOW_BOLTS.get())):false) {}
});
}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("Not enough ammo."), true);}
}
}
