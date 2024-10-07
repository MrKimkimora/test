package com.kimkimora.test.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Degradable;
import net.minecraft.util.StringIdentifiable;

import java.util.Optional;
import java.util.function.Supplier;

public interface ModOxidizable extends Degradable<com.kimkimora.test.block.ModOxidizable.OxidationLevel> {
    Supplier<BiMap<Block, Block>> OXIDATION_LEVEL_INCREASES = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(ModBlocks.BRONZE_BLOCK, ModBlocks.EXPOSED_BRONZE)
                    .put(ModBlocks.EXPOSED_BRONZE, ModBlocks.WEATHERED_BRONZE)
                    .put(ModBlocks.WEATHERED_BRONZE, ModBlocks.OXIDIZED_BRONZE)
                    .build()
    );
    Supplier<BiMap<Block, Block>> OXIDATION_LEVEL_DECREASES = Suppliers.memoize(() -> ((BiMap)OXIDATION_LEVEL_INCREASES.get()).inverse());

    static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block)((BiMap)OXIDATION_LEVEL_DECREASES.get()).get(block));
    }

    static Block getUnaffectedOxidationBlock(Block block) {
        Block block2 = block;

        for (Block block3 = (Block)((BiMap)OXIDATION_LEVEL_DECREASES.get()).get(block);
             block3 != null;
             block3 = (Block)((BiMap)OXIDATION_LEVEL_DECREASES.get()).get(block3)
        ) {
            block2 = block3;
        }

        return block2;
    }

    static Optional<BlockState> getDecreasedOxidationState(BlockState state) {
        return getDecreasedOxidationBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    static Optional<Block> getIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block)((BiMap)OXIDATION_LEVEL_INCREASES.get()).get(block));
    }

    static BlockState getUnaffectedOxidationState(BlockState state) {
        return getUnaffectedOxidationBlock(state.getBlock()).getStateWithProperties(state);
    }

    @Override
    default Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedOxidationBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    @Override
    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == com.kimkimora.test.block.ModOxidizable.OxidationLevel.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum OxidationLevel implements StringIdentifiable {
        UNAFFECTED("unaffected"),
        EXPOSED("exposed"),
        WEATHERED("weathered"),
        OXIDIZED("oxidized");

        public static final Codec<net.minecraft.block.Oxidizable.OxidationLevel> CODEC = StringIdentifiable.createCodec(net.minecraft.block.Oxidizable.OxidationLevel::values);
        private final String id;

        private OxidationLevel(String id) {
            this.id = id;
        }

        @Override
        public String asString() {
            return this.id;
        }
    }
}
