package net.coosanta.explosive_anvils.item;

import net.coosanta.explosive_anvils.ExplosiveAnvils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup EXPLOSIVE_ANVILS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(ExplosiveAnvils.MOD_ID, "explosive-anvils"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.explosive-anvils"))
                    .icon(() -> new ItemStack(ModItems.EEEEE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ANVILITE);
                        entries.add(ModItems.EEEEE);

                        //testing - not real!!1!
                        entries.add(Items.ANVIL);
                        entries.add(Items.TNT);
                        entries.add(Items.TNT_MINECART);
                    }).build());

    public static void registerItemGroups(){
        ExplosiveAnvils.LOGGER.info("Registering Item Groups for " + ExplosiveAnvils.MOD_ID);
    }
}
