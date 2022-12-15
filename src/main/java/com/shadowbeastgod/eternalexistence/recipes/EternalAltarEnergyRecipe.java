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

public class EternalAltarEnergyRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;

    private final NonNullList<Ingredient> recipeItems;

    private final int energyamount;





    public EternalAltarEnergyRecipe(ResourceLocation id, NonNullList<Ingredient> recipeItems,int energyRequired){
        this.id = id;
        this.recipeItems = recipeItems;
        this.energyamount = energyRequired;

    }
    public static final int energyRequiredHolder = 0;


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
        return EternalAltarEnergyRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return EternalAltarEnergyRecipe.Type.INSTANCE;
    }

    public int getEnergyRequired(){
        return energyamount;
    }




    public static class Type implements RecipeType<EternalAltarEnergyRecipe>{
        private Type(){}
        public static final EternalAltarEnergyRecipe.Type INSTANCE = new EternalAltarEnergyRecipe.Type();
        public static final String ID = "eternal_altar_energy_recipe";


    }
    public static class Serializer implements RecipeSerializer<EternalAltarEnergyRecipe> {
        public static final EternalAltarEnergyRecipe.Serializer INSTANCE = new EternalAltarEnergyRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(EternalExistence.MOD_ID, "eternal_altar_energy_recipe");



        @Override
        public EternalAltarEnergyRecipe fromJson(ResourceLocation id, JsonObject json) {
            int energyfromjson = GsonHelper.getAsInt(json, "energy", EternalAltarEnergyRecipe.energyRequiredHolder);
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(8, Ingredient.EMPTY);

            inputs.set(0, Ingredient.fromJson(ingredients.get(0)));

            return new EternalAltarEnergyRecipe(id,inputs,energyfromjson);

        }


        @Override
        public EternalAltarEnergyRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            int energy = buf.readVarInt();



            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }



            ItemStack output = buf.readItem();
            return new EternalAltarEnergyRecipe(id,inputs,energy);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, EternalAltarEnergyRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
            buf.writeVarInt(recipe.getEnergyRequired());
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
            return EternalAltarEnergyRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }

    }

    public static class ExtraData{

    }
}
