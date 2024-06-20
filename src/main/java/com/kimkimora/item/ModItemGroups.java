package com.kimkimora.item;

import com.kimkimora.test.Test;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup TEST_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Test.MOD_ID, "test_mod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.test_mod"))
                    .icon(() -> new ItemStack(ModItems.TIN_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.TOPAZ);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);

                    }).build());

    public static void register(){
        Test.LOGGER.info("Registering item groups for " + Test.MOD_ID);


    }
}
