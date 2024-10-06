package com.kimkimora.test.item;

import com.kimkimora.test.Test;
import com.kimkimora.test.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuelItems {
    /*
    Регистрируем топливо
     */
    public static void register(){
        /*
          Метод, вызываемый из главного класса. Инициализирует этот класс и сохраняет лог в общий хэндлер.
         */
        Test.LOGGER.info("Registering fuel items for " + Test.MOD_ID);

        FuelRegistry.INSTANCE.add(ModItems.COKE,2400);
        FuelRegistry.INSTANCE.add(ModBlocks.COKE_BLOCK,24000);
    }
}
