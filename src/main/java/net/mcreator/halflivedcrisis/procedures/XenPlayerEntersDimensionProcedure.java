package net.mcreator.halflivedcrisis.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class XenPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("half_lived_crisis", "starting_cave"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(-5, 95, 31), new BlockPos(-5, 95, 31), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("half_lived_crisis", "nihilanths_lair"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(-8, 109, -61), new BlockPos(-8, 109, -61), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("half_lived_crisis", "nihilanths_lair_top"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(-8, 152, -61), new BlockPos(-8, 152, -61), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(14.5, 99.5, 47.5);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(14.5, 99.5, 47.5, _ent.getYRot(), _ent.getXRot());
		}
		HalfLivedCrisisMod.queueServerWork(120, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(14.5, 99.5, 47.5), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:transcendent")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound(14.5, 99.5, 47.5, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("half_lived_crisis:transcendent")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
		});
	}
}
