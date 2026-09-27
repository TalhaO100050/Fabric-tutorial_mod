package net.talha.tutorial_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.talha.tutorial_mod.block.ModBlocks;
import net.talha.tutorial_mod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> GEM_SMELTABLES = List.of(ModItems.RAW_GEM, ModBlocks.RAW_GEM_BLOCK);

                oreSmelting(GEM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.GEM, 0.25F, 200, "gem");
                oreBlasting(GEM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.GEM, 0.25F, 100, "gem");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.GEM, RecipeCategory.DECORATIONS, ModBlocks.GEM_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_GEM_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_GEM)
                        .unlockedBy(getHasName(ModItems.RAW_GEM), has(ModItems.RAW_GEM))
                        .group("gem_block")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_GEM, 9)
                        .requires(ModBlocks.RAW_GEM_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_GEM_BLOCK), has(ModBlocks.RAW_GEM_BLOCK))
                        .group("raw_gem")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.GEM_SOUP, 1)
                        .requires(ModItems.GEM)
                        .requires(Items.BOWL)
                        .unlockedBy(getHasName(ModItems.GEM), has(ModItems.GEM))
                        .group("gem_soup")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "tutorial_mod recipes";
    }
}
