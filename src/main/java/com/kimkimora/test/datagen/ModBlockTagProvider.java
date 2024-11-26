package com.kimkimora.test.datagen;

import com.kimkimora.test.block.ModBlocks;
import com.kimkimora.test.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.TIN_ORES)  //                           Custom Ores
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
        ;
        getOrCreateTagBuilder(ModTags.Blocks.TOPAZ_ORES)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
        ;



        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE) //                          Tools
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.EXPOSED_BRONZE)
                .add(ModBlocks.WEATHERED_BRONZE)
                .add(ModBlocks.OXIDIZED_BRONZE)
                .add(ModBlocks.COKE_BLOCK)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.RAW_TIN_BLOCK)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
        ;
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
        ;
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL) //                           Tool Levels
                .add(ModBlocks.COKE_BLOCK)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.RAW_TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.EXPOSED_BRONZE)
                .add(ModBlocks.WEATHERED_BRONZE)
                .add(ModBlocks.OXIDIZED_BRONZE)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
        ;



        getOrCreateTagBuilder(ConventionalBlockTags.ORES) //                          Ore Tag
                .addTag(ModTags.Blocks.TIN_ORES)
                .addTag(ModTags.Blocks.TOPAZ_ORES)
        ;
    }
}