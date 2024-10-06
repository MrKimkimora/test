package com.kimkimora.test;

import com.kimkimora.test.block.ModBlocks;
import com.kimkimora.test.item.ModFuelItems;
import com.kimkimora.test.item.ModItemGroups;
import com.kimkimora.test.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test implements ModInitializer {

    /*
    Основной класс мода

    by MrKimkimora
     */

    public static final String MOD_ID = "test";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
    public void onInitialize() {

        ModItemGroups.register();

        ModItems.register();
        ModBlocks.register();

        ModFuelItems.register();

        LOGGER.info("AMOGUS");

    }
}
