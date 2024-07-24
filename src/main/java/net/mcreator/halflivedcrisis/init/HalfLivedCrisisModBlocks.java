
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
import net.mcreator.halflivedcrisis.block.XenSporeTopBlock;
import net.mcreator.halflivedcrisis.block.XenSporeBlock;
import net.mcreator.halflivedcrisis.block.XenPortalBlock;
import net.mcreator.halflivedcrisis.block.XenPillarBlock;
import net.mcreator.halflivedcrisis.block.XenCrystalBlock;
import net.mcreator.halflivedcrisis.block.SuitBatteryBlock;
import net.mcreator.halflivedcrisis.block.ShotgunAmmoBlock;
import net.mcreator.halflivedcrisis.block.SMGammoBlock;
import net.mcreator.halflivedcrisis.block.SMGGrenadeBlock;
import net.mcreator.halflivedcrisis.block.PulseRifleAmmoBlock;
import net.mcreator.halflivedcrisis.block.PistolAmmoBlock;
import net.mcreator.halflivedcrisis.block.NihilanthsLairOuterRingVerticalBlock;
import net.mcreator.halflivedcrisis.block.NihilanthsLairOuterRingCornerBlock;
import net.mcreator.halflivedcrisis.block.NihilanthsLairOuterRingBlock;
import net.mcreator.halflivedcrisis.block.NihilanthsLairCoreBlock;
import net.mcreator.halflivedcrisis.block.MedkitBlock;
import net.mcreator.halflivedcrisis.block.MagnumAmmoBlock;
import net.mcreator.halflivedcrisis.block.LightStalkHiddenBlock;
import net.mcreator.halflivedcrisis.block.LightStalkBlock;
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
	public static final RegistryObject<Block> XEN_CRYSTAL = REGISTRY.register("xen_crystal", () -> new XenCrystalBlock());
	public static final RegistryObject<Block> XEN_PILLAR = REGISTRY.register("xen_pillar", () -> new XenPillarBlock());
	public static final RegistryObject<Block> XEN_SPORE = REGISTRY.register("xen_spore", () -> new XenSporeBlock());
	public static final RegistryObject<Block> XEN_SPORE_TOP = REGISTRY.register("xen_spore_top", () -> new XenSporeTopBlock());
	public static final RegistryObject<Block> LIGHT_STALK = REGISTRY.register("light_stalk", () -> new LightStalkBlock());
	public static final RegistryObject<Block> LIGHT_STALK_HIDDEN = REGISTRY.register("light_stalk_hidden", () -> new LightStalkHiddenBlock());
	public static final RegistryObject<Block> NIHILANTHS_LAIR_CORE = REGISTRY.register("nihilanths_lair_core", () -> new NihilanthsLairCoreBlock());
	public static final RegistryObject<Block> NIHILANTHS_LAIR_OUTER_RING = REGISTRY.register("nihilanths_lair_outer_ring", () -> new NihilanthsLairOuterRingBlock());
	public static final RegistryObject<Block> NIHILANTHS_LAIR_OUTER_RING_CORNER = REGISTRY.register("nihilanths_lair_outer_ring_corner", () -> new NihilanthsLairOuterRingCornerBlock());
	public static final RegistryObject<Block> NIHILANTHS_LAIR_OUTER_RING_VERTICAL = REGISTRY.register("nihilanths_lair_outer_ring_vertical", () -> new NihilanthsLairOuterRingVerticalBlock());
	public static final RegistryObject<Block> SHOTGUN_AMMO = REGISTRY.register("shotgun_ammo", () -> new ShotgunAmmoBlock());
	public static final RegistryObject<Block> PULSE_RIFLE_AMMO = REGISTRY.register("pulse_rifle_ammo", () -> new PulseRifleAmmoBlock());
	public static final RegistryObject<Block> SUIT_BATTERY = REGISTRY.register("suit_battery", () -> new SuitBatteryBlock());
	public static final RegistryObject<Block> MEDKIT = REGISTRY.register("medkit", () -> new MedkitBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
