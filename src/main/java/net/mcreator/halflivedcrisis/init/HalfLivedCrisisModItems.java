
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.halflivedcrisis.item.SMGItem;
import net.mcreator.halflivedcrisis.item.PistolItem;
import net.mcreator.halflivedcrisis.item.MagnumItem;
import net.mcreator.halflivedcrisis.item.LongJumpModuleItem;
import net.mcreator.halflivedcrisis.item.HEVSuitItem;
import net.mcreator.halflivedcrisis.item.GaussGunItem;
import net.mcreator.halflivedcrisis.item.CrowbarItem;
import net.mcreator.halflivedcrisis.block.display.XenSporeDisplayItem;
import net.mcreator.halflivedcrisis.block.display.NihilanthsLairDisplayItem;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<Item> HEV_SUIT_CHESTPLATE = REGISTRY.register("hev_suit_chestplate", () -> new HEVSuitItem.Chestplate());
	public static final RegistryObject<Item> HEV_SUIT_LEGGINGS = REGISTRY.register("hev_suit_leggings", () -> new HEVSuitItem.Leggings());
	public static final RegistryObject<Item> CROWBAR = REGISTRY.register("crowbar", () -> new CrowbarItem());
	public static final RegistryObject<Item> PISTOL = REGISTRY.register("pistol", () -> new PistolItem());
	public static final RegistryObject<Item> SMG = REGISTRY.register("smg", () -> new SMGItem());
	public static final RegistryObject<Item> MAGNUM = REGISTRY.register("magnum", () -> new MagnumItem());
	public static final RegistryObject<Item> PISTOL_AMMO = block(HalfLivedCrisisModBlocks.PISTOL_AMMO);
	public static final RegistryObject<Item> SMG_AMMO = block(HalfLivedCrisisModBlocks.SMG_AMMO);
	public static final RegistryObject<Item> MAGNUM_AMMO = block(HalfLivedCrisisModBlocks.MAGNUM_AMMO);
	public static final RegistryObject<Item> SMG_GRENADE = block(HalfLivedCrisisModBlocks.SMG_GRENADE);
	public static final RegistryObject<Item> GAUSS_GUN = REGISTRY.register("gauss_gun", () -> new GaussGunItem());
	public static final RegistryObject<Item> GAUSS_AMMO = block(HalfLivedCrisisModBlocks.GAUSS_AMMO);
	public static final RegistryObject<Item> XENSTONE = block(HalfLivedCrisisModBlocks.XENSTONE);
	public static final RegistryObject<Item> XENMOSS = block(HalfLivedCrisisModBlocks.XENMOSS);
	public static final RegistryObject<Item> XEN_PORTAL = block(HalfLivedCrisisModBlocks.XEN_PORTAL);
	public static final RegistryObject<Item> XEN_SPORE = REGISTRY.register(HalfLivedCrisisModBlocks.XEN_SPORE.getId().getPath(), () -> new XenSporeDisplayItem(HalfLivedCrisisModBlocks.XEN_SPORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> NIHILANTHS_LAIR = REGISTRY.register(HalfLivedCrisisModBlocks.NIHILANTHS_LAIR.getId().getPath(), () -> new NihilanthsLairDisplayItem(HalfLivedCrisisModBlocks.NIHILANTHS_LAIR.get(), new Item.Properties()));
	public static final RegistryObject<Item> XEN_CRYSTAL = block(HalfLivedCrisisModBlocks.XEN_CRYSTAL);
	public static final RegistryObject<Item> LONG_JUMP_MODULE = REGISTRY.register("long_jump_module", () -> new LongJumpModuleItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
