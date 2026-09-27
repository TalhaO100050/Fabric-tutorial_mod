package net.talha.tutorial_mod.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties GEM_SOUP = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build();

    public static final Consumable GEM_SOUP_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 200, 2), 0.7F)).build();
}
