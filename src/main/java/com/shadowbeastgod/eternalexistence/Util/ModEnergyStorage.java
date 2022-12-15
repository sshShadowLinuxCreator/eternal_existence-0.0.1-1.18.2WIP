package com.shadowbeastgod.eternalexistence.Util;

import net.minecraftforge.energy.EnergyStorage;

public class ModEnergyStorage extends EnergyStorage {
    public ModEnergyStorage(int capacity, int maxTransfer){
        super(capacity,maxTransfer);
    }

    public int setEnergy(int energy){
        this.energy = energy;
        return energy;
    }

    

}
