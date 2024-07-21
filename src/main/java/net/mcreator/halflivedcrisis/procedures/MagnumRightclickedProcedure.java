package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;
import net.mcreator.halflivedcrisis.item.MagnumItem;
import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModEntities;
import net.mcreator.halflivedcrisis.entity.MagnumProjectileEntity;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class MagnumRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).magnum_ammo != 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:magnum_shoot")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:magnum_shoot")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new MagnumProjectileEntity(HalfLivedCrisisModEntities.MAGNUM_PROJECTILE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) 1.2, 0);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 30, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof MagnumItem)
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "shoot");
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 14);
			{
				double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).magnum_ammo - 1;
				entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.magnum_ammo = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			for (int index0 = 0; index0 < 14; index0++) {
				HalfLivedCrisisMod.queueServerWork(1, () -> {
					{
						Entity _ent = entity;
						_ent.setYRot(entity.getYRot());
						_ent.setXRot((float) (entity.getXRot() - 1));
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				});
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough ammo."), true);
		}
	}
}
