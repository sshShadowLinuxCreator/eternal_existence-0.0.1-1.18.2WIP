package com.shadowbeastgod.eternalexistence.blocks.customblockentities;

import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.recipes.EternalAltarEnergyRecipe;
import com.shadowbeastgod.eternalexistence.recipes.EternalAltarRecipe;
import com.shadowbeastgod.eternalexistence.screen.EternalAltarMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

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
    private int eProgress = 0;
    private int eProgressMax = 8;

    private int eContainer = 0;
    private int eContainerMax = 66;
    private int energyRequired;

    private int additionalEnergy;

    public static int energyCopied =0;

    public EteranlAltarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModblockEntities.ETERNALALTAR.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                switch (pIndex){
                    case 0: return EteranlAltarBlockEntity.this.rProgress;
                    case 1: return EteranlAltarBlockEntity.this.rProgressMax;
                    case 2: return EteranlAltarBlockEntity.this.eContainer;
                    case 3: return EteranlAltarBlockEntity.this.eContainerMax;
                    case 4: return EteranlAltarBlockEntity.this.eProgress;
                    case 5: return EteranlAltarBlockEntity.this.eProgressMax;

                    default:return 0;
                }
            }



            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0: EteranlAltarBlockEntity.this.rProgress = pValue; break;
                    case 1: EteranlAltarBlockEntity.this.rProgressMax = pValue; break;
                    case 2: EteranlAltarBlockEntity.this.eProgress = pValue; break;
                    case 3: EteranlAltarBlockEntity.this.eProgressMax = pValue; break;
                    case 4: EteranlAltarBlockEntity.this.rProgress = pValue; break;
                    case 5: EteranlAltarBlockEntity.this.rProgressMax = pValue; break;

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
        pTag.putInt("eternal_altar.energy_progress",eProgress);
        pTag.putInt("eternal_altar.energy_container",eContainer);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));

        energyRequired = pTag.getInt("required_energy");
        additionalEnergy = pTag.getInt("energy");

        rProgress = pTag.getInt("eternal_altar.recipe_progress");
        eProgress = pTag.getInt("eternal_altar.energy_progress");
        eContainer= pTag.getInt("eternal_altar.energy_container");
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
        /*for(int j = 0; j< itemEnergyHandler.getSlots();j++ ){
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

        if(hasEnergyRecipe(pBlockEntity)) {
            pBlockEntity.eProgress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.eProgress > pBlockEntity.eProgressMax) {
                createEnergy(pBlockEntity);
            }
        } else {
            pBlockEntity.resetEnergyProgress();
            setChanged(pLevel, pPos, pState);
        }
    }



    private static boolean hasRecipe(EteranlAltarBlockEntity entity) {

        boolean requiredenergylessthan = false;


        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<EternalAltarRecipe> match = level.getRecipeManager()
                .getRecipeFor(EternalAltarRecipe.Type.INSTANCE, inventory, level);
        if(match.isPresent()) {
            requiredenergylessthan = match.get().getEnergyAmount() < entity.eContainer;
        }
        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())&& requiredenergylessthan;
    }

    private static boolean hasEnergyRecipe(EteranlAltarBlockEntity entity) {


        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());


        boolean notFull = entity.eContainer != 66;

        Optional<EternalAltarEnergyRecipe> match = level.getRecipeManager()
                .getRecipeFor(EternalAltarEnergyRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputEnergySlot(inventory)
                && canInsertItemIntoEnergySlot(inventory)&& notFull;
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

            entity.eContainer -= match.get().getEnergyAmount();
            energyCopied -= match.get().getEnergyAmount();


            entity.resetProgress();
        }
    }

    private static void createEnergy(EteranlAltarBlockEntity entity){
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));

                }

                Optional<EternalAltarEnergyRecipe> match = level.getRecipeManager()
                .getRecipeFor(EternalAltarEnergyRecipe.Type.INSTANCE, inventory, level);

                if(match.isPresent()) {
                    entity.itemHandler.extractItem(0,1, false);

                    entity.eContainer += match.get().getEnergyAmount();
                    energyCopied += match.get().getEnergyAmount();

                    entity.resetEnergyProgress();
        }

    }

    private void resetProgress() {
        this.rProgress = 0;
    }


    private void resetEnergyProgress() {
        this.eProgress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(9).getItem() == output.getItem() || inventory.getItem(9).isEmpty();
    }

    private static boolean canInsertItemIntoEnergySlot(SimpleContainer inventory) {
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

    private static boolean canInsertAmountIntoOutputEnergySlot(SimpleContainer inventory) {
        return inventory.getItem(0).getMaxStackSize() > inventory.getItem(0).getCount();

    }



}
