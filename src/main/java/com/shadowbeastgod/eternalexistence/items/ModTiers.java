package com.shadowbeastgod.eternalexistence.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier WAKARANAI = new ForgeTier(4,2000,4f, 4f, 22,
            BlockTags.NEEDS_IRON_TOOL, ()-> Ingredient.of(ModItems.WAKARANAIINGOT.get()));
    public static final ForgeTier ANOTATOS = new ForgeTier(4,2000,4f, 4f, 22,
            BlockTags.NEEDS_IRON_TOOL, ()-> Ingredient.of(ModItems.ANOTATOSINGOT.get()));
    public static final ForgeTier SUMMAVI= new ForgeTier(4,2000,4f, 4f, 22,
            BlockTags.NEEDS_IRON_TOOL, ()-> Ingredient.of(ModItems.SUMMAVIINGOT.get()));
}
