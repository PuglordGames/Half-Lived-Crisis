
package net.mcreator.halflivedcrisis.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LongJumpModuleItem extends Item {
	public LongJumpModuleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
