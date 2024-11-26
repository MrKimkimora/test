package com.kimkimora.test.datagen;

import com.kimkimora.test.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModTagTagProvider extends FabricTagProvider { //<- а чё сюда писать то?

    public ModTagTagProvider(FabricDataOutput output, RegistryKey registryKey, CompletableFuture registriesFuture) {
        super(output, registryKey, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ConventionalBlockTags.ORES) //                          Ore Tags
                .add(ModTags.Blocks.TIN_ORES)
                .add(ModTags.Blocks.TOPAZ_ORES)
        ;
    }
}
