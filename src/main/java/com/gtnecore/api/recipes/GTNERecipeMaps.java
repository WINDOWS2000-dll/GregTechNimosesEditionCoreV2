package com.gtnecore.api.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMapBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
public class GTNERecipeMaps {

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ASSEMBLER_MODULE_RECIPES = new RecipeMapBuilder<>(
            "assembler_module",
            new SimpleRecipeBuilder())
                    .itemInputs(16)
                    .itemOutputs(1)
                    .build();
}
