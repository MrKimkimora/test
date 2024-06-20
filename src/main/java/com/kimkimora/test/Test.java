package com.kimkimora.test;

import com.kimkimora.test.block.ModBlocks;
import com.kimkimora.test.item.ModItemGroups;
import com.kimkimora.test.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test implements ModInitializer {

    public static final String MOD_ID = "test";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
    public void onInitialize() {

        ModItemGroups.register();

        ModItems.register();
        ModBlocks.register();

        LOGGER.info("AMOGUS");

    }
}
