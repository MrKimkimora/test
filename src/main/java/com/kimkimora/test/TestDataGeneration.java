package com.kimkimora.test;

import com.kimkimora.test.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class TestDataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(TagProvider::new);
    }

    private static class TagProvider extends FabricTagProvider.ItemTagProvider{
        private static final TagKey<Item> MUSIC = TagKey.of(RegistryKeys.ITEM, new Identifier("test:music_discs"));

        public TagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(MUSIC)
                    .add(ModItems.CITY_LIGHTS_MUSIC_DISC,
                            ModItems.BATTLE_OF_BERKLEY_MUSIC_DISC,
                            ModItems.RESONANCE_MUSIC_DISC,
                            ModItems.SPACE_BATTLE_MUSIC_DISC,
                            ModItems.END_OF_THE_MILLENNIUM_MUSIC_DISC);
            getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).addTag(MUSIC);
            getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS).addTag(MUSIC);
        }
    }
}
