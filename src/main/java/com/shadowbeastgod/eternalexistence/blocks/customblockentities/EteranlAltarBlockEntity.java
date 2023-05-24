package com.shadowbeastgod.eternalexistence.blocks.customblockentities;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.recipes.EternalAltarManaRecipe;
import com.shadowbeastgod.eternalexistence.recipes.EternalAltarRecipe;
import com.shadowbeastgod.eternalexistence.screen.EternalAltarMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EteranlAltarBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(10){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    } ;



    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int rProgress = 0;
    private int rProgressMax = 18;
    private int mProgress = 0;
    private int mProgressMax = 8;

    private int mContainer = 0;
    private int mContainerMax = 66;
    private int manaRequired;

    private int mana;

    public static int manaCopied =0;

    public EteranlAltarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModblockEntities.ETERNALALTAR.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                switch (pIndex){
                    case 0: return EteranlAltarBlockEntity.this.rProgress;
                    case 1: return EteranlAltarBlockEntity.this.rProgressMax;
                    case 2: return EteranlAltarBlockEntity.this.mContainer;
                    case 3: return EteranlAltarBlockEntity.this.mContainerMax;
                    case 4: return EteranlAltarBlockEntity.this.mProgress;
                    case 5: return EteranlAltarBlockEntity.this.mProgressMax;

                    default:return 0;
                }
            }



            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0: EteranlAltarBlockEntity.this.rProgress = pValue; break;
                    case 1: EteranlAltarBlockEntity.this.rProgressMax = pValue; break;
                    case 2: EteranlAltarBlockEntity.this.mContainer = pValue; break;
                    case 3: EteranlAltarBlockEntity.this.mContainerMax = pValue; break;
                    case 4: EteranlAltarBlockEntity.this.mProgress = pValue; break;
                    case 5: EteranlAltarBlockEntity.this.mProgressMax = pValue; break;

                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };


    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Eteranal Altar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new EternalAltarMenu(pContainerId,pPlayerInventory,this,this.data);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

       if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
           return lazyItemHandler.cast();
       }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(()-> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }


    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("eternal_altar.recipe_progress",rProgress);
        pTag.putInt("eternal_altar.mana_container",mContainer);
        pTag.putInt("eternal_altar.mana_progress",mProgress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));

        manaRequired = pTag.getInt("mana");
        mana = pTag.getInt("mana");

        rProgress = pTag.getInt("eternal_altar.recipe_progress");
        mContainer = pTag.getInt("eternal_altar.mana_container");
        mProgress = pTag.getInt("eternal_altar.mana_progress");

    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i< itemHandler.getSlots();i++ ){
            inventory.setItem(i, itemHandler.getStackInSlot(0));
            inventory.setItem(i, itemHandler.getStackInSlot(1));
            inventory.setItem(i, itemHandler.getStackInSlot(2));
            inventory.setItem(i, itemHandler.getStackInSlot(3));
            inventory.setItem(i, itemHandler.getStackInSlot(4));
            inventory.setItem(i, itemHandler.getStackInSlot(5));
            inventory.setItem(i, itemHandler.getStackInSlot(6));
            inventory.setItem(i, itemHandler.getStackInSlot(7));
            inventory.setItem(i, itemHandler.getStackInSlot(8));
        }
        /*for(int j = 0; j< itemmanaHandler.getSlots();j++ ){
            inventory.setItem(j, itemHandler.getStackInSlot(1));
        }*/

        Containers.dropContents(this.level,this.worldPosition,inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, EteranlAltarBlockEntity pBlockEntity) {

        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.rProgress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.rProgress > pBlockEntity.rProgressMax) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }

        if(hasmanaRecipe(pBlockEntity)) {
            int i = 0;
            if(i <=360) {
                pBlockEntity.mProgress++;
                i++;
            }
            else {
                i = 0;
            }
           if(pBlockEntity.mProgress > pBlockEntity.mProgressMax) {
                createmana(pBlockEntity);
            }
            setChanged(pLevel, pPos, pState);
        } else {
            pBlockEntity.resetmanaProgress();
            setChanged(pLevel, pPos, pState);
        }
    }



    private static boolean hasRecipe(EteranlAltarBlockEntity entity) {

        boolean requiredmanalessthan = false;


        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<EternalAltarRecipe> match = level.getRecipeManager()
                .getRecipeFor(EternalAltarRecipe.Type.INSTANCE, inventory, level);
        if(match.isPresent()) {
            requiredmanalessthan = match.get().getManaAmount() < entity.mContainer;
        }
        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())&& requiredmanalessthan;
    }

    private static boolean hasmanaRecipe(EteranlAltarBlockEntity entity) {


        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getStackInSlot(0));
        Item io = entity.itemHandler.getStackInSlot(0).getItem();


        boolean notFull = entity.mContainer <= 66;

        boolean itemmana = io == ModBlocks.CRYSTAL.get().asItem();

        return itemmana && canInsertItemIntomanaSlot(inventory)&& notFull;
    }


    private static void craftItem(EteranlAltarBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<EternalAltarRecipe> match = level.getRecipeManager()
                .getRecipeFor(EternalAltarRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {
            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);
            entity.itemHandler.extractItem(3,1, false);
            entity.itemHandler.extractItem(4,1, false);
            entity.itemHandler.extractItem(5,1, false);
            entity.itemHandler.extractItem(6,1, false);
            entity.itemHandler.extractItem(7,1, false);
            entity.itemHandler.extractItem(8,1, false);

            entity.itemHandler.setStackInSlot(9, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(9).getCount() + 1));

            //entity.mContainer -= match.get().getManaAmount();


            entity.resetProgress();
        }
    }

    private static void createmana(EteranlAltarBlockEntity entity){
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getStackInSlot(0));


        entity.itemHandler.extractItem(0,1, false);

        entity.mContainer += 10;

        entity.resetmanaProgress();


    }

    private void resetProgress() {
        this.rProgress = 0;
    }


    private void resetmanaProgress() {
        this.mProgress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(9).getItem() == output.getItem() || inventory.getItem(9).isEmpty();
    }

    private static boolean canInsertItemIntomanaSlot(SimpleContainer inventory) {
        return !inventory.getItem(0).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        boolean r1 = inventory.getItem(1).getMaxStackSize() > inventory.getItem(1).getCount();
        boolean r2 = inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
        boolean r3 = inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
        boolean r4 = inventory.getItem(4).getMaxStackSize() > inventory.getItem(4).getCount();
        boolean r5 = inventory.getItem(5).getMaxStackSize() > inventory.getItem(5).getCount();
        boolean r6 = inventory.getItem(6).getMaxStackSize() > inventory.getItem(6).getCount();
        boolean r7 = inventory.getItem(7).getMaxStackSize() > inventory.getItem(7).getCount();
        boolean r8 = inventory.getItem(8).getMaxStackSize() > inventory.getItem(8).getCount();

        return r1 && r2 && r3 && r4 && r5 && r6 && r7 && r8;
    }

}
