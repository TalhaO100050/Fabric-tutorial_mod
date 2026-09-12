package net.talha.tutorial_mod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.talha.tutorial_mod.block.ModBlocks;
import net.talha.tutorial_mod.creativemodetab.ModCreativeModeTabs;
import net.talha.tutorial_mod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModBlocks.registerModBlocks();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
