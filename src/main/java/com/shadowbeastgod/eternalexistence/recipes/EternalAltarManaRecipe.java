package com.shadowbeastgod.eternalexistence.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EternalAltarManaRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;

    private final NonNullList<Ingredient> recipeItems;

    private final int manaamount;





    public EternalAltarManaRecipe(ResourceLocation id, NonNullList<Ingredient> recipeItems, int manaRequired){
        this.id = id;
        this.recipeItems = recipeItems;
        this.manaamount = manaRequired;

    }
    public static final int manaRequiredHolder = 0;


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return recipeItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return null;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return EternalAltarManaRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return EternalAltarManaRecipe.Type.INSTANCE;
    }

    public int getmanaAmount(){
        return manaamount;
    }




    public static class Type implements RecipeType<EternalAltarManaRecipe>{
        private Type(){}
        public static final EternalAltarManaRecipe.Type INSTANCE = new EternalAltarManaRecipe.Type();
        public static final String ID = "eternal_altar_mana_recipe";


    }
    public static class Serializer implements RecipeSerializer<EternalAltarManaRecipe> {
        public static final EternalAltarManaRecipe.Serializer INSTANCE = new EternalAltarManaRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(EternalExistence.MOD_ID, "eternal_altar_mana_recipe");



        @Override
        public EternalAltarManaRecipe fromJson(ResourceLocation id, JsonObject json) {
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(8, Ingredient.EMPTY);
            inputs.set(0, Ingredient.fromJson(ingredients.get(0)));

            int mana = GsonHelper.getAsInt(json, "mana", EternalAltarManaRecipe.manaRequiredHolder);

            return new EternalAltarManaRecipe(id,inputs,mana);

        }


        @Override
        public EternalAltarManaRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            inputs.set(0, Ingredient.fromNetwork(buf));
            int mana = buf.readVarInt();

            return new EternalAltarManaRecipe(id,inputs,mana);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, EternalAltarManaRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeItemStack(recipe.getResultItem(), false);
            buf.writeVarInt(recipe.getmanaAmount());
        }



        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return EternalAltarManaRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }

    }

}
