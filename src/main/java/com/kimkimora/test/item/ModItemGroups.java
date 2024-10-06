package com.kimkimora.test.item;

import com.kimkimora.test.Test;
import com.kimkimora.test.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    /*
    Отдельная креативная вкладка под мод. Здесь же добавляются предметы.
     */

    public static final ItemGroup TEST_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Test.MOD_ID, "test_mod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.test_mod"))
                    .icon(() -> new ItemStack(ModItems.TOPAZ)).entries((displayContext, entries) -> {

                        entries.add(ModItems.CUCUMBER);
                        entries.add(ModItems.FRACTAL_CUCUMBER);
                        entries.add(ModItems.BRONZE_CUCUMBER);

                        entries.add(ModItems.COPPER_NUGGET);

                        entries.add(ModItems.BRONZE_NUGGET);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModBlocks.BRONZE_BLOCK);

                        entries.add(ModBlocks.TOPAZ_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TOPAZ_ORE);
                        entries.add(ModItems.TOPAZ);
                        entries.add(ModBlocks.TOPAZ_BLOCK);

                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModItems.TIN_NUGGET);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModBlocks.TIN_BLOCK);

                        entries.add(ModItems.COKE);
                        entries.add(ModBlocks.COKE_BLOCK);

                        entries.add(ModItems.ROUGH_BRONZE_BLEND);
                        entries.add(ModItems.ORE_DETECTOR);

                        entries.add(ModBlocks.CUSTOM_BLOCK);

                    }).build());

    public static void register(){
        /*
          Метод, вызываемый из главного класса. Инициализирует этот класс и сохраняет лог в общий хэндлер.
         */
        Test.LOGGER.info("Registering item groups for " + Test.MOD_ID);


    }
}
