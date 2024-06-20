package com.kimkimora.item;

import com.kimkimora.test.Test;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TOPAZ = registerItem("topaz", new Item(new Item.Settings()));

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(TOPAZ);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Test.MOD_ID, name), item);
    }

    public static void register(){
        Test.LOGGER.info("Registering items for " + Test.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.INGREDIENTS)).register(ModItems::addItemsToIngredientItemGroup);
    }
}
