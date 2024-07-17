
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halflivedcrisis.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.halflivedcrisis.world.inventory.HEVSuitGUIMenu;
import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

public class HalfLivedCrisisModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HalfLivedCrisisMod.MODID);
	public static final RegistryObject<MenuType<HEVSuitGUIMenu>> HEV_SUIT_GUI = REGISTRY.register("hev_suit_gui", () -> IForgeMenuType.create(HEVSuitGUIMenu::new));
}
