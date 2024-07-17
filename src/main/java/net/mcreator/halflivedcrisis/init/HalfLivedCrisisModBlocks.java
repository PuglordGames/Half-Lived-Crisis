
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.halflivedcrisis.block.XenstoneBlock;
import net.mcreator.halflivedcrisis.block.XenmossBlock;
import net.mcreator.halflivedcrisis.block.XenSporeBlock;
import net.mcreator.halflivedcrisis.block.XenPortalBlock;
import net.mcreator.halflivedcrisis.block.XenCrystalBlock;
import net.mcreator.halflivedcrisis.block.SMGammoBlock;
import net.mcreator.halflivedcrisis.block.SMGGrenadeBlock;
import net.mcreator.halflivedcrisis.block.PistolAmmoBlock;
import net.mcreator.halflivedcrisis.block.NihilanthsLairBlock;
import net.mcreator.halflivedcrisis.block.MagnumAmmoBlock;
import net.mcreator.halflivedcrisis.block.GaussAmmoBlock;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<Block> PISTOL_AMMO = REGISTRY.register("pistol_ammo", () -> new PistolAmmoBlock());
	public static final RegistryObject<Block> SMG_AMMO = REGISTRY.register("smg_ammo", () -> new SMGammoBlock());
	public static final RegistryObject<Block> MAGNUM_AMMO = REGISTRY.register("magnum_ammo", () -> new MagnumAmmoBlock());
	public static final RegistryObject<Block> SMG_GRENADE = REGISTRY.register("smg_grenade", () -> new SMGGrenadeBlock());
	public static final RegistryObject<Block> GAUSS_AMMO = REGISTRY.register("gauss_ammo", () -> new GaussAmmoBlock());
	public static final RegistryObject<Block> XENSTONE = REGISTRY.register("xenstone", () -> new XenstoneBlock());
	public static final RegistryObject<Block> XENMOSS = REGISTRY.register("xenmoss", () -> new XenmossBlock());
	public static final RegistryObject<Block> XEN_PORTAL = REGISTRY.register("xen_portal", () -> new XenPortalBlock());
	public static final RegistryObject<Block> XEN_SPORE = REGISTRY.register("xen_spore", () -> new XenSporeBlock());
	public static final RegistryObject<Block> NIHILANTHS_LAIR = REGISTRY.register("nihilanths_lair", () -> new NihilanthsLairBlock());
	public static final RegistryObject<Block> XEN_CRYSTAL = REGISTRY.register("xen_crystal", () -> new XenCrystalBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
