/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.coosanta.explosive_anvils.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.coosanta.explosive_anvils.ExplosiveAnvilsMod;

public class ExplosiveAnvilsModItems {
	public static Item EXPLOSIVE_ANVIL;
	public static Item CREEPER_EXPLOSIVE_ANVIL;

	public static void load() {
		EXPLOSIVE_ANVIL = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ExplosiveAnvilsMod.MODID, "explosive_anvil"), new BlockItem(ExplosiveAnvilsModBlocks.EXPLOSIVE_ANVIL, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> content.accept(EXPLOSIVE_ANVIL));
		CREEPER_EXPLOSIVE_ANVIL = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ExplosiveAnvilsMod.MODID, "creeper_explosive_anvil"), new BlockItem(ExplosiveAnvilsModBlocks.CREEPER_EXPLOSIVE_ANVIL, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> content.accept(CREEPER_EXPLOSIVE_ANVIL));
	}

	public static void clientLoad() {
	}
}
