package com.shadowbeastgod.eternalexistence.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.EteranlAltarBlockEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.RecipeBook;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EternalAltarRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;

    private final NonNullList<Ingredient> recipeItems;

    private final int manaRequird;


    public EternalAltarRecipe(ResourceLocation id,ItemStack output, NonNullList<Ingredient> recipeItems,int manaRequired){
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.manaRequird = manaRequired;

    }
    public static final int energyRequiredHolder = 0;


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {


        if( recipeItems.get(0).test(pContainer.getItem(1)) &&
                recipeItems.get(1).test(pContainer.getItem(2)) &&
                recipeItems.get(2).test(pContainer.getItem(3)) &&
                recipeItems.get(3).test(pContainer.getItem(4)) &&
                recipeItems.get(4).test(pContainer.getItem(5)) &&
                recipeItems.get(5).test(pContainer.getItem(6)) &&
                recipeItems.get(6).test(pContainer.getItem(7)) &&
                recipeItems.get(7).test(pContainer.getItem(8))
                ){
            return EteranlAltarBlockEntity.energyCopied > manaRequird;
        }
        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public int getManaAmount(){
        return manaRequird;
    }

    @Override
    public ItemStack getToastSymbol() {
        return Recipe.super.getToastSymbol();
    }

    public static class Type implements RecipeType<EternalAltarRecipe>{
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "eternal_altar_recipe";





    }
    public static class Serializer implements RecipeSerializer<EternalAltarRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(EternalExistence.MOD_ID, "eternal_altar_recipe");

        @Override
        public EternalAltarRecipe fromJson(ResourceLocation id, JsonObject json) {
            int energyfromjson = GsonHelper.getAsInt(json, "mana", EternalAltarRecipe.energyRequiredHolder);
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
            JsonArray i1 = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(8, Ingredient.EMPTY);



            for (int i = 0; i < inputs.size(); i++) {


                inputs.set(i, Ingredient.fromJson(i1.get(i)));


            }

            return new EternalAltarRecipe(id, output, inputs,energyfromjson);

        }

        @Override
        public EternalAltarRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);


            int mana = buf.readVarInt();



            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }



            ItemStack output = buf.readItem();
            return new EternalAltarRecipe(id, output, inputs,mana);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, EternalAltarRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
            buf.writeVarInt(recipe.manaRequird);
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
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }

    }
    

}
