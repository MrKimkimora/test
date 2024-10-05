package com.kimkimora.test.item;

import com.kimkimora.test.Test;
import com.kimkimora.test.item.custom.OreDetector;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    /*
    Создаём модовые предметы
     */
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));

    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));

    public static final Item TOPAZ = registerItem("topaz", new Item(new Item.Settings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));

    public static final Item ROUGH_BRONZE_BLEND = registerItem("rough_bronze_blend", new Item(new Item.Settings()));
    public static final Item ORE_DETECTOR = registerItem("ore_detector", new OreDetector(new Item.Settings()
            .maxDamage(32)));


    private static Item registerItem(String name, Item item){
        /*
        Отдельный метод для регистрации предмета
         */
        return Registry.register(Registries.ITEM, new Identifier(Test.MOD_ID, name), item);
    }

    public static void register(){
        /*
          Метод, вызываемый из главного класса. Инициализирует этот класс и сохраняет лог в общий хэндлер.
         */
        Test.LOGGER.info("Registering items for " + Test.MOD_ID);

    }
}
