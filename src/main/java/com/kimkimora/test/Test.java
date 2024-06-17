package com.kimkimora.test;

import com.kimkimora.test.items.ModItems;
import com.kimkimora.test.sounds.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test implements ModInitializer {

    public static final String MOD_ID = "test";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
    public void onInitialize() {

        ModItems.registerItems();
        ModSounds.registerSounds();


        LOGGER.info("AMOGUS");

    }
}
