package com.kimkimora.test.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class ModOxidizableBlock extends Block implements ModOxidizable {
    public static final MapCodec<com.kimkimora.test.block.ModOxidizableBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(ModOxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(this::getDegradationLevel), createSettingsCodec())
                    .apply(instance, com.kimkimora.test.block.ModOxidizableBlock::new)
    );
    private final ModOxidizable.OxidationLevel oxidationLevel;

    @Override
    public MapCodec<com.kimkimora.test.block.ModOxidizableBlock> getCodec() {
        return CODEC;
    }

    public ModOxidizableBlock(ModOxidizable.OxidationLevel oxidationLevel, AbstractBlock.Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    public ModOxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
