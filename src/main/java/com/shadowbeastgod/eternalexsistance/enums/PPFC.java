package com.shadowbeastgod.eternalexsistance.enums;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
//portal position from center
public enum PPFC {
    Portal1(0,0,0);


    private final int disx;
    private final int disy;
    private final int disz;

    PPFC(int disx, int disy, int disz){

        this.disx = disx;
        this.disy = disy;
        this.disz = disz;
    }

    public int getxdis(){
        return disx;
    }
    public int getydis(){
        return disy;
    }
    public int getzdis(){
        return disz;
    }



}
