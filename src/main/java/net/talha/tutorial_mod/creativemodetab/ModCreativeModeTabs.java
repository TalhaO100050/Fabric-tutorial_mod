package net.talha.tutorial_mod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.talha.tutorial_mod.TutorialMod;
import net.talha.tutorial_mod.block.ModBlocks;
import net.talha.tutorial_mod.item.ModItems;

public class ModCreativeModeTabs {

    public static final CreativeModeTab GEM_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "gem_items"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.GEM_BLOCK))
                    .title(Component.translatable("creativemodetab.tutorial_mod.gem_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.GEM);
                        output.accept(ModItems.RAW_GEM);
                        output.accept(ModBlocks.GEM_BLOCK);
                        output.accept(ModBlocks.RAW_GEM_BLOCK);
                    })
                    .build());

    public static void registerModCreativeModeTabs() {
        TutorialMod.LOGGER.info("Registering creative mode tabs for " + TutorialMod.MOD_ID);
    }
}
