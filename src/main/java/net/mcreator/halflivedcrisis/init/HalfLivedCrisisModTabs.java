
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<CreativeModeTab> WEAPONS_AND_AMMUNITION = REGISTRY.register("weapons_and_ammunition",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.half_lived_crisis.weapons_and_ammunition")).icon(() -> new ItemStack(HalfLivedCrisisModItems.CROWBAR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(HalfLivedCrisisModItems.CROWBAR.get());
				tabData.accept(HalfLivedCrisisModItems.PISTOL.get());
				tabData.accept(HalfLivedCrisisModItems.SMG.get());
				tabData.accept(HalfLivedCrisisModItems.MAGNUM.get());
				tabData.accept(HalfLivedCrisisModItems.GAUSS_GUN.get());
				tabData.accept(HalfLivedCrisisModBlocks.PISTOL_AMMO.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.SMG_AMMO.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.MAGNUM_AMMO.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.SMG_GRENADE.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.GAUSS_AMMO.get().asItem());
				tabData.accept(HalfLivedCrisisModItems.SHOTGUN.get());
				tabData.accept(HalfLivedCrisisModBlocks.SHOTGUN_AMMO.get().asItem());
				tabData.accept(HalfLivedCrisisModItems.AR_2.get());
				tabData.accept(HalfLivedCrisisModBlocks.PULSE_RIFLE_AMMO.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> HEV_SUIT_RELATED = REGISTRY.register("hev_suit_related",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.half_lived_crisis.hev_suit_related")).icon(() -> new ItemStack(HalfLivedCrisisModItems.HEV_SUIT_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(HalfLivedCrisisModItems.HEV_SUIT_CHESTPLATE.get());
				tabData.accept(HalfLivedCrisisModItems.HEV_SUIT_LEGGINGS.get());
				tabData.accept(HalfLivedCrisisModItems.LONG_JUMP_MODULE.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> XEN_BLOCKS_AND_CREATURES = REGISTRY.register("xen_blocks_and_creatures",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.half_lived_crisis.xen_blocks_and_creatures")).icon(() -> new ItemStack(HalfLivedCrisisModBlocks.XENSTONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(HalfLivedCrisisModBlocks.XENSTONE.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.XEN_PILLAR.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.XENMOSS.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.XEN_CRYSTAL.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.XEN_PORTAL.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.XEN_SPORE.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.LIGHT_STALK.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.LIGHT_STALK_HIDDEN.get().asItem());
				tabData.accept(HalfLivedCrisisModBlocks.NIHILANTHS_LAIR_CORE.get().asItem());
			})

					.build());
}
