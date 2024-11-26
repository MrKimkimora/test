package com.kimkimora.test.datagen;

import com.kimkimora.test.block.ModBlocks;
import com.kimkimora.test.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final String compacting = null;
    private static final String reverse = null;

    private static final List<ItemConvertible> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
    private static final List<ItemConvertible> TOPAZ_SMELTABLES = List.of(ModBlocks.TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.7f, 200, "tin");
        offerBlasting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.7f, 100, "tin");

        offerSmelting(exporter, TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.TOPAZ, 0.7f, 200, "topaz");
        offerBlasting(exporter, TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.TOPAZ, 0.7f, 100, "topaz");

        offerSmelting(exporter, List.of(Items.COAL), RecipeCategory.MISC, ModItems.COKE, 0.7f, 200, "coke");
        offerBlasting(exporter, List.of(ModItems.ROUGH_BRONZE_BLEND), RecipeCategory.MISC, ModItems.BRONZE_INGOT, 2.0f, 200, "bronze");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COKE, RecipeCategory.DECORATIONS, ModBlocks.COKE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOPAZ, RecipeCategory.DECORATIONS, ModBlocks.TOPAZ_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT, RecipeCategory.DECORATIONS, ModBlocks.TIN_BLOCK, "tin_block_from_tin_ingot", compacting, "tin_ingot_from_tin_block", reverse);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TIN_NUGGET, RecipeCategory.MISC, ModItems.TIN_INGOT, "tin_ingot_from_tin_nugget", compacting, "tin_nugget_from_tin_ingot", reverse);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK, "bronze_block_from_bronze_ingot", compacting, "bronze_ingot_from_bronze_block", reverse);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BRONZE_NUGGET, RecipeCategory.MISC, ModItems.BRONZE_INGOT, "bronze_ingot_from_bronze_nugget", compacting, "bronze_nugget_from_bronze_ingot", reverse);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROUGH_BRONZE_BLEND, 1)
                .input(ModItems.TIN_NUGGET, 2)
                .input(ModItems.COPPER_NUGGET, 7)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ROUGH_BRONZE_BLEND)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_CUCUMBER, 1)
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .input('B', ModItems.BRONZE_INGOT)
                .input('C', ModItems.CUCUMBER)
                .criterion(hasItem(ModItems.CUCUMBER), conditionsFromItem(ModItems.CUCUMBER))
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BRONZE_CUCUMBER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.LANTERN, 1)
                .pattern("BBB")
                .pattern("BTB")
                .pattern("BBB")
                .input('B', ModItems.BRONZE_NUGGET)
                .input('T', Items.TORCH)
                .criterion(hasItem(ModItems.BRONZE_NUGGET), conditionsFromItem(ModItems.BRONZE_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(Items.LANTERN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ORE_DETECTOR, 1)
                .pattern(" SB")
                .pattern("INN")
                .pattern(" NN")
                .input('S', Items.STICK)
                .input('B', Items.WATER_BUCKET)
                .input('I', Items.IRON_INGOT)
                .input('N', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ORE_DETECTOR)));
    }
}
