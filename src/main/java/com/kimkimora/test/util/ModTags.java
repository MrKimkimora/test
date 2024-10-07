package com.kimkimora.test.util;

import com.kimkimora.test.Test;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> TIN_ORES = createTag("tin_ores");
        public static final TagKey<Block> TOPAZ_ORES = createTag("topaz_ores");


        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
        private static TagKey<Block> createModTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Test.MOD_ID, name));
        }
    }

    public static class Items{


        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Test.MOD_ID, name));
        }
    }


}
