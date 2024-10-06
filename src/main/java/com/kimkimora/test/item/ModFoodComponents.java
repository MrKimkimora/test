package com.kimkimora.test.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
    public static final FoodComponent FRACTAL_CUCUMBER = new FoodComponent.Builder().hunger(5).saturationModifier(1f).build();
    public static final FoodComponent BRONZE_CUCUMBER = new FoodComponent.Builder().hunger(1).saturationModifier(0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200), 1f).build();
}
