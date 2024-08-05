package net.mcreator.halflivedcrisis.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Entity;

import net.mcreator.halflivedcrisis.item.GravityGunItem;

public class GravityGunItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Creeper.class,
				AABB.ofSize(
						new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
						1, 1, 1),
				e -> true).isEmpty()) {
			if (itemstack.getItem() instanceof GravityGunItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "detect");
		}
		if (entity.getPersistentData().getBoolean("pick_up") == true) {
			if (itemstack.getItem() instanceof GravityGunItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "hold");
		}
	}
}
