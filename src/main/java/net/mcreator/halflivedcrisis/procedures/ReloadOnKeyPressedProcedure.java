package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.network.HalfLivedCrisisModVariables;
import net.mcreator.halflivedcrisis.item.ShotgunItem;
import net.mcreator.halflivedcrisis.item.SMGItem;
import net.mcreator.halflivedcrisis.item.PistolItem;
import net.mcreator.halflivedcrisis.item.MagnumItem;
import net.mcreator.halflivedcrisis.item.GaussGunItem;
import net.mcreator.halflivedcrisis.item.AR2Item;
import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModItems;
import net.mcreator.halflivedcrisis.init.HalfLivedCrisisModBlocks;

public class ReloadOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.PISTOL_AMMO.get())) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.PISTOL.get()) {
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).pistol_ammo != 18) {
				{
					double _setval = 18;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pistol_ammo = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PistolItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload");
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.PISTOL_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:pistol_reload")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:pistol_reload")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 17);
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SMG_AMMO.get())) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.SMG.get()) {
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).smg_ammo != 45) {
				{
					double _setval = 45;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.smg_ammo = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SMGItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload");
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SMG_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:smg_reload")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:smg_reload")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 24);
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.MAGNUM_AMMO.get())) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.MAGNUM.get()) {
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).magnum_ammo != 6) {
				{
					double _setval = 6;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.magnum_ammo = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof MagnumItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload");
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.MAGNUM_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:magnum_reload")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:magnum_reload")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 52);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.GAUSS_GUN.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof GaussGunItem)
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload");
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.SHOTGUN.get()) {
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo == 0) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_06")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_06")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShotgunItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload6");
				for (int index0 = 0; index0 < 6; index0++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
						{
							double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo + 1;
							entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shotgun_ammo = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 56);
					}
				}
			}
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo == 1) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_05")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_05")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShotgunItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload5");
				for (int index1 = 0; index1 < 5; index1++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
						{
							double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo + 1;
							entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shotgun_ammo = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 48);
					}
				}
			}
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo == 2) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_04")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_04")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShotgunItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload4");
				for (int index2 = 0; index2 < 4; index2++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
						{
							double _setval = 6;
							entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shotgun_ammo = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 40);
					}
				}
			}
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo == 3) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_03")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_03")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShotgunItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload3");
				for (int index3 = 0; index3 < 3; index3++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
						{
							double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo + 1;
							entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shotgun_ammo = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 32);
					}
				}
			}
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo == 4) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_02")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_02")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShotgunItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload2");
				for (int index4 = 0; index4 < 2; index4++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
						{
							double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo + 1;
							entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shotgun_ammo = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 24);
					}
				}
			}
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo == 5) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_01")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:shotgun_reload_01")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShotgunItem)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload1");
				for (int index5 = 0; index5 < 1; index5++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get())) : false) {
						{
							double _setval = (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).shotgun_ammo + 1;
							entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shotgun_ammo = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 16);
					}
				}
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(HalfLivedCrisisModBlocks.PULSE_RIFLE_AMMO.get())) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == HalfLivedCrisisModItems.AR_2.get()) {
			if ((entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).pusle_rifle_ammo != 30) {
				{
					double _setval = 30;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pusle_rifle_ammo = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AR2Item)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("geckoAnim", "reload");
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(HalfLivedCrisisModBlocks.PULSE_RIFLE_AMMO.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:pulse_rifle_reload")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:pulse_rifle_reload")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 15);
			}
		}
	}
}
