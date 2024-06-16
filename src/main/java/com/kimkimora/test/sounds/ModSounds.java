package com.kimkimora.test.sounds;

import com.kimkimora.test.Test;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CITY_LIGHTS = registerSoundEvent("city_lights");




    public static void registerSounds(){
        Test.LOGGER.info("Registring Sounds for " + Test.MOD_ID);
    }

    public static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(Test.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
