
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.coosanta.explosive_anvils.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.coosanta.explosive_anvils.block.ExplosiveAnvilBlock;
import net.coosanta.explosive_anvils.ExplosiveAnvilsMod;

public class ExplosiveAnvilsModBlocks {
	public static Block EXPLOSIVE_ANVIL;

	public static void load() {
		EXPLOSIVE_ANVIL = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ExplosiveAnvilsMod.MODID, "explosive_anvil"), new ExplosiveAnvilBlock());
	}

	public static void clientLoad() {
		ExplosiveAnvilBlock.clientInit();
	}
}
