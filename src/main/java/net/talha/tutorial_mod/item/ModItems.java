package net.talha.tutorial_mod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.talha.tutorial_mod.TutorialMod;

import java.util.function.Function;

public class ModItems {

    public static final Item GEM = registerItem("gem", Item::new);
    public static final Item RAW_GEM = registerItem("raw_gem", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);
    }
}