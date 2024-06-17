package com.kimkimora.test.items;


import com.kimkimora.test.Test;
import com.kimkimora.test.sounds.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item CITY_LIGHTS_MUSIC_DISC = registerItem("city_lights_music_disc",
            new MusicDiscItem(7, ModSounds.CITY_LIGHTS, new Item.Settings().rarity(Rarity.RARE).maxCount(1),  198));
    public static final Item BATTLE_OF_BERKLEY_MUSIC_DISC = registerItem("battle_of_berkley_music_disc",
            new MusicDiscItem(7, ModSounds.BATTLE_OF_BERKLEY, new Item.Settings().rarity(Rarity.RARE).maxCount(1),  268));



    public static void registerItems(){
        Test.LOGGER.info("Registering items for " + Test.MOD_ID);



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(CITY_LIGHTS_MUSIC_DISC);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(BATTLE_OF_BERKLEY_MUSIC_DISC);
        });
    }

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Test.MOD_ID, name), item);
    }
}
