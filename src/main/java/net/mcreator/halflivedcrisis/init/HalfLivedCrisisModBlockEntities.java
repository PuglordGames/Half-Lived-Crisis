
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.halflivedcrisis.block.entity.XenSporeTileEntity;
import net.mcreator.halflivedcrisis.block.entity.NihilanthsLairTileEntity;
import net.mcreator.halflivedcrisis.block.entity.LightStalkTileEntity;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<BlockEntityType<XenSporeTileEntity>> XEN_SPORE = REGISTRY.register("xen_spore", () -> BlockEntityType.Builder.of(XenSporeTileEntity::new, HalfLivedCrisisModBlocks.XEN_SPORE.get()).build(null));
	public static final RegistryObject<BlockEntityType<NihilanthsLairTileEntity>> NIHILANTHS_LAIR = REGISTRY.register("nihilanths_lair",
			() -> BlockEntityType.Builder.of(NihilanthsLairTileEntity::new, HalfLivedCrisisModBlocks.NIHILANTHS_LAIR.get()).build(null));
	public static final RegistryObject<BlockEntityType<LightStalkTileEntity>> LIGHT_STALK = REGISTRY.register("light_stalk", () -> BlockEntityType.Builder.of(LightStalkTileEntity::new, HalfLivedCrisisModBlocks.LIGHT_STALK.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
