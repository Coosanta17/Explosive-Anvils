package net.coosanta.explosive_anvils.item;

import net.coosanta.explosive_anvils.ExplosiveAnvils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ANVILITE = registerItem("anvilite", new Item(new FabricItemSettings()));
    public static final Item EEEEE = registerItem("eeeee", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(ANVILITE);
        entries.add(EEEEE);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ExplosiveAnvils.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ExplosiveAnvils.LOGGER.info("Registering Mod Items for " + ExplosiveAnvils.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
