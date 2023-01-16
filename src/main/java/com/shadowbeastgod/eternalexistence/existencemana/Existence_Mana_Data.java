package com.shadowbeastgod.eternalexistence.existencemana;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.saveddata.SavedData;


//ToDo elementstructure : element effect{like what kind of spell}
public class Existence_Mana_Data extends SavedData {

    private final CompoundTag EXISTENCE_MANA;
    private int ManaAmount;
    private String ManaType;


    public Existence_Mana_Data(CompoundTag EXISTENCE_MANA,int ManaAmount,String ManaType) {
        this.EXISTENCE_MANA= EXISTENCE_MANA;
        this.ManaAmount = ManaAmount;
        this.ManaType = ManaType;

        }

    public static int getManaAmount(int mana) {
        return 0;
    }


    @Override
    public CompoundTag save(CompoundTag pCompoundTag) {
        return EXISTENCE_MANA;
    }





}
