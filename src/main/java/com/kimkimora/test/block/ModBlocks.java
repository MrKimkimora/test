package com.kimkimora.test.block;

import com.kimkimora.test.Test;
import com.kimkimora.test.block.custom.CustomBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    /*
      Создаём модовые блоки
     */

    public static final Block CUSTOM_BLOCK = registerBlock("custom_block",
            new CustomBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK)));
    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COPPER_ORE)));
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f)));


    private static Block registerBlock(String name, Block block){
        /*
          Отдельный метод для регистрации блока
         */
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Test.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        /*
          Отдельный метод для регистрации блока как предмета
         */
        return Registry.register(Registries.ITEM, new Identifier(Test.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void register(){
        /*
          Метод, вызываемый из главного класса. Инициализирует этот класс и сохраняет лог в общий хэндлер.
         */
        Test.LOGGER.info("Registering blocks for " + Test.MOD_ID);

    }
}
