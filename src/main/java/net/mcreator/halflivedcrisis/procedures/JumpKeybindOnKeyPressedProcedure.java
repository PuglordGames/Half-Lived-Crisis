package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JumpKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isSprinting()) {
			if (!world.getBlockState(BlockPos.containing(x, y - 0.5, z)).canOcclude() && (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).jump_var == false
					&& (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).has_long_jump_module == true) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 8), (entity.getDeltaMovement().y() + 0.5), (entity.getDeltaMovement().z() * 8)));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:long_jump_module_used")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:long_jump_module_used")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jump_var = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (entity.isSprinting()) {
			if (!world.getBlockState(BlockPos.containing(x, y - 0.5, z)).canOcclude() && (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).jump_var == false
					&& (entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HalfLivedCrisisModVariables.PlayerVariables())).has_long_jump_module == true) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 12), (entity.getDeltaMovement().y() + 1), (entity.getDeltaMovement().z() * 12)));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:long_jump_module_used")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:long_jump_module_used")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(HalfLivedCrisisModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jump_var = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
