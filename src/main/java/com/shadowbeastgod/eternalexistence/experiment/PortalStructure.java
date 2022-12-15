package com.shadowbeastgod.eternalexistence.experiment;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.world.GodRealmTeleportal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.HashMap;
import java.util.Map;

public class PortalStructure {
    static int x;
    static int y;
    static int z;




    public static void portalbuild(BlockPos bpos,boolean portalbuilt){
        x=0;
        y=0;
        z=0;
        int xoff = -5;
        int yoff = -1;
        int zoff = -5;


        BlockPos.MutableBlockPos mutablePos = bpos.mutable();

        char[][][] portal= {
                {
                        {'#','#','#','W','W','W','W','W','#','#','#','#'},
                        {'#','#','W','D','G','D','G','D','W','#','#','#'},
                        {'#','W','G','W','W','W','W','W','G','W','#','#'},
                        {'W','D','W','W','W','W','W','W','W','D','W','#'},
                        {'W','G','W','W','W','W','W','W','W','G','W','#'},
                        {'W','D','W','W','W','W','W','W','W','D','W','#'},
                        {'W','G','W','W','W','W','W','W','W','G','W','#'},
                        {'W','D','W','W','W','W','W','W','W','D','W','#'},
                        {'#','W','G','W','W','W','W','W','G','W','#','#'},
                        {'#','#','W','D','G','D','G','D','W','#','#','#'},
                        {'#','#','#','W','W','W','W','W','#','#','#','#'}
                },
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','A','A','A','#','#','#','#','#'},
                        {'#','#','#','A','A','A','A','A','#','#','#','#'},
                        {'#','#','#','A','A','P','A','A','#','#','#','#'},
                        {'#','#','#','A','A','A','A','A','#','#','#','#'},
                        {'#','#','#','#','A','A','A','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                },
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                },
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','F','#','#','#','#','#','F','#','#','#'},
                        {'#','#','F','#','#','#','#','#','F','#','#','#'},
                        {'#','#','F','#','#','#','#','#','F','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                }
                ,
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','R','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                }
                };



        
        while(!portalbuilt) {
            if (portal[y][x][z] =='#') {
                if(y==4) {
                    mutablePos.setWithOffset(bpos, x + xoff, y+yoff+3, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());


                }
                if(y==2){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff, y + 3 , z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                }
                if(y==3){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff+2, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff,   y, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff,y-1, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                }
                if (y==0||y==1){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());
                }

            }
            if (portal[y][x][z] =='W') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.WAKARANAIBLOCK.get().defaultBlockState());
            }
            if (portal[y][x][z] =='D') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GUILDEDWAKARANAIBLOCK.get().defaultBlockState());
            }
            if (portal[y][x][z] =='G') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.GOLD_BLOCK.defaultBlockState());
            }
            if (portal[y][x][z] =='R') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 3, z + zoff);
                GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.PORTALSPAWNPLATFORM.get().defaultBlockState());




            }
            if (portal[y][x][z] =='F') {
                if (y==3) {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GRPORTALBLOCK.get().defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff, y+0, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GRPORTALBLOCK.get().defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff,y+1, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GRPORTALBLOCK.get().defaultBlockState());
                }
                if(y==2){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GRPORTALBLOCK.get().defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff, y + 3 , z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GRPORTALBLOCK.get().defaultBlockState());
                }
            }

            if (portal[y][x][z] =='A') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.ETERNALALTAR.get().defaultBlockState());

            }
            if (portal[y][x][z] =='P') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get().defaultBlockState());

            }
            x++;
            if (x == 11) {
                if (z == 11) {
                    y++;
                    x = 0;
                    z = 0;
                } else {
                    x = 0;
                    z++;
                }
            }
            if(y==5){
                portalbuilt = true;
            }


        }

    }




    public static void portalshapeptest(BlockPos bpos){
        x=0;
        y=0;
        z=0;

        char[][][] cord={
                {{'#','#','#','W','W','W','W','W','#','#','#'},
                {'#','#','W','D','G','D','G','D','W','#','#'},
                {'#','W','G','W','W','W','W','W','G','W','#'},
                {'W','D','W','W','W','W','W','W','W','D','W'},
                {'W','G','W','W','W','W','W','W','W','G','W'},
                {'W','D','W','W','W','W','W','W','W','D','W'},
                {'W','G','W','W','W','W','W','W','W','G','W'},
                {'W','D','W','W','W','W','W','W','W','D','W'},
                {'#','W','G','W','W','W','W','W','G','W','#'},
                {'#','#','W','D','G','D','G','D','W','#','#'},
                {'#','#','#','W','W','W','W','W','#','#','#'}},

                {
                        {'#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','A','A','A','#','#','#','#'},
                        {'#','#','#','A','A','A','A','A','#','#','#'},
                        {'#','#','#','A','A','P','A','A','#','#','#'},
                        {'#','#','#','A','A','A','A','A','#','#','#'},
                        {'#','#','#','#','A','A','A','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#'}
                }


        };
        Map<BlockPos,Block> structre;

        while(x<11||z<11){
            if(cord[y][x][z]=='W'){

            }
            if(cord[y][x][z]=='D'){

            }
            if(cord[y][x][z]=='G'){

            }
            x++;
            if(x==10){
                x=0;
                z++;
            }
        }



    }


    public <T extends Comparable<T>, V extends T> void multiblockblockstatetester(Level l , BlockPos thisblock, BlockState s, int xlength, int ylength, int zlength, Block compair, char[][][] map, Property<T> pProperty, V pValue){
        LevelReader lr = null;
        BlockPos.MutableBlockPos mm = thisblock.mutable();
        Block r = lr.getBlockState(mm).getBlock();
        int x=0;
        int y=0;
        int z=0;
        while (x !=xlength && y != ylength && z != zlength) {
            mm.setWithOffset(mm, x, y , z);
                if(r==compair){
                    s.setValue(pProperty,pValue);
                }
            x++;
            if (y != 0 && x == 10) {
                if (z == 10) {
                    y++;
                    x = 0;
                    z = 0;
                } else {
                    x = 0;
                    z++;
                }
            }
            if (y == 0 && x == 11) {
                if (z == 11) {
                    y++;
                    x = 0;
                    z = 0;
                } else {
                    x = 0;
                    z++;
                }
            }

        }


        }
        public static void portalblocktexture(BlockPos portalspawn){
        char[][][] shape={
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                },
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','F','#','#','#','#','#','F','#','#','#'},
                        {'#','#','F','#','#','#','#','#','F','#','#','#'},
                        {'#','#','F','#','#','#','#','#','F','#','#','#'},
                        {'#','#','#','F','#','#','#','F','#','#','#','#'},
                        {'#','#','#','#','F','F','F','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                }
        };
        Map<BlockPos, Block> Structure = new HashMap<>();
            int xoff =0;
            int yoff =0;
            int zoff =0;
            boolean construct=false;
            BlockPos cords = portalspawn;
            Block b = ModBlocks.GRPORTALBLOCK.get();
            while(!construct) {
                if(shape[yoff][xoff][zoff]=='F') {
                    if (yoff==0) {
                        cords = new BlockPos(portalspawn.getX() + xoff, portalspawn.getY() + yoff, portalspawn.getZ() + zoff);
                        Structure.put(cords,b);

                        cords = new BlockPos(portalspawn.getX() + xoff, portalspawn.getY() + yoff+4, portalspawn.getZ() + zoff);
                        Structure.put(cords,b);
                    }
                    if(yoff==1){
                        cords = new BlockPos(portalspawn.getX() + xoff, portalspawn.getY() + yoff, portalspawn.getZ() + zoff);
                        Structure.put(cords,b);
                        cords = new BlockPos(portalspawn.getX() + xoff, portalspawn.getY() + yoff+1, portalspawn.getZ() + zoff);
                        Structure.put(cords,b);
                        cords = new BlockPos(portalspawn.getX() + xoff, portalspawn.getY() + yoff+2, portalspawn.getZ() + zoff);
                        Structure.put(cords,b);
                    }
                }
                x++;
                if (x == 11) {
                    if (z == 11) {
                        y++;
                        x = 0;
                        z = 0;
                    } else {
                        x = 0;
                        z++;
                    }
                }
                if(y==2){
                    construct = true;
                }
            }

        }
}


