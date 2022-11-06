package com.shadowbeastgod.eternalexsistance.experiment;

import com.shadowbeastgod.eternalexsistance.modblocks.modblocks;
import com.shadowbeastgod.eternalexsistance.world.modbiomes.godrealmteleportal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.block.Blocks;

public class portalStructure {
    static int x;
    static int y;
    static int z;
    
    static int xoff = -5;
    static int zoff = -5;
    static int yoff = -1;

    static boolean portalnotbuilt=false;

    public static void build(BlockPos bpos, boolean isthereaportal){

        portalnotbuilt = isthereaportal;

        while(!portalnotbuilt){
            if (y==0) {
                portalStructure.b1Shapebuild(bpos);
            }
            if(y==1) {
                portalStructure.b2shapebuild(bpos);
            }
            if(y>1||y<7) {
                portalStructure.portalbuild(bpos);
            }
            if(y==7) {
                portalStructure.platformbuild(bpos);
            }
        }

    }

    public static void b1Shapebuild(BlockPos bpos){
        x=0;
        y=0;
        z=0;
        BlockPos.MutableBlockPos mutablePos = bpos.mutable();

       char[][] cord={
               {'#','#','#','W','W','W','W','W','#','#','#'},
               {'#','#','W','D','G','D','G','D','W','#','#'},
               {'#','W','G','W','W','W','W','W','G','W','#'},
               {'W','D','W','W','W','W','W','W','W','D','W'},
               {'W','G','W','W','W','W','W','W','W','G','W'},
               {'W','D','W','W','W','W','W','W','W','D','W'},
               {'W','G','W','W','W','W','W','W','W','G','W'},
               {'W','D','W','W','W','W','W','W','W','D','W'},
               {'#','W','G','W','W','W','W','W','G','W','#'},
               {'#','#','W','D','G','D','G','D','W','#','#'},
               {'#','#','#','W','W','W','W','W','#','#','#'}
       };

           if(cord[x][z]=='W'){
               mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
               godrealmteleportal.level.setBlock(mutablePos, modblocks.WAKARANAIBLOCK.get().defaultBlockState(),1);
           }
           if(cord[x][z]=='D'){
               mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
               godrealmteleportal.level.setBlock(mutablePos, modblocks.GUILDEDWAKARANAIBLOCK.get().defaultBlockState(), 1);
           }
           if(cord[x][y]=='G'){
               mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
               godrealmteleportal.level.setBlock(mutablePos, Blocks.GOLD_BLOCK.defaultBlockState(),1);
           }

           if(x==10){
               if(z==10){
                   y++;
                   x=0;
                   z=0;
               }else {
                   x = 0;
                   z++;
               }
           }
           x++;




    }
    public static void b2shapebuild(BlockPos bpos){
        x=0;
        y=1;
        z=0;
        BlockPos.MutableBlockPos mutablePos = bpos.mutable();

        char[][] cords ={
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
        };



            if(cords[x][z]=='A'){
                mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
                godrealmteleportal.level.setBlock(mutablePos,modblocks.ETERNALALTAR.get().defaultBlockState(), 1);

            }
            if(cords[x][z]=='P'){
                mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
                godrealmteleportal.level.setBlock(mutablePos,modblocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get().defaultBlockState(), 1);
            }
            if(x==10){
                if(z==10){
                    y++;
                    x=0;
                    z=0;
                }else {
                    x = 0;
                    z++;
                }
            }
            x++;





    }

    public static void portalbuild(BlockPos bpos){
        x=0;
        y=2;
        z=0;

        char[][] btportal= {
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'}
        };
        char[][] mportal={
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','F','#','#','#','#','#','F','#','#'},
                {'#','#','F','#','#','#','#','#','F','#','#'},
                {'#','#','F','#','#','#','#','#','F','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'}
        };


        BlockPos.MutableBlockPos mutablePos = bpos.mutable();

        if(y==2){

                if(btportal[x][z]=='F'){
                    mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
                    godrealmteleportal.level.setBlock(mutablePos,modblocks.GRPORTALBLOCK.get().defaultBlockState(), 1);
                }

                if(x==10){
                    if(z==10){
                        y++;
                        x=0;
                        z=0;
                    }else {
                        x = 0;
                        z++;
                    }
                }
                x++;

            
        }
        if(y>2||y<6){

                if(mportal[x][z]=='F'){
                    mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
                    godrealmteleportal.level.setBlock(mutablePos,modblocks.GRPORTALBLOCK.get().defaultBlockState(), 1);
                }

                if(x==10){
                    if(z==10){
                        y++;
                        x=0;
                        z=0;
                    }else {
                        x = 0;
                        z++;
                    }
                }
                x++;



        }
        if(y==6){

                if(btportal[x][z]=='F'){
                    mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
                    godrealmteleportal.level.setBlock(mutablePos,modblocks.GRPORTALBLOCK.get().defaultBlockState(), 1);

                }

                if(x==10){
                    if(z==10){
                        y++;
                        x=0;
                        z=0;
                    }else {
                        x = 0;
                        z++;
                    }
                }
                x++;


        }


    }

    public static void platformbuild(BlockPos bpos){
        BlockPos.MutableBlockPos mutablePos = bpos.mutable();

        char[][] platform={
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','R','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'}

        };



            if(platform[x][z]=='R'){
                mutablePos.setWithOffset(bpos, x + xoff,y+yoff,z+zoff );
                godrealmteleportal.level.setBlock(mutablePos,modblocks.PORTALSPAWNPLATFORM.get().defaultBlockState(), 1);
            }
            if(x==10){
                if(z==10){
                    portalnotbuilt=true;
                }else {
                    x = 0;
                    z++;
                }
            }
            x++;

        

    }

    public static void b1Shaptest(BlockPos bpos){
        x=0;
        y=0;
        z=0;

        char[][] cord={
                {'#','#','#','W','W','W','W','W','#','#','#'},
                {'#','#','W','D','G','D','G','D','W','#','#'},
                {'#','W','G','W','W','W','W','W','G','W','#'},
                {'W','D','W','W','W','W','W','W','W','D','W'},
                {'W','G','W','W','W','W','W','W','W','G','W'},
                {'W','D','W','W','W','W','W','W','W','D','W'},
                {'W','G','W','W','W','W','W','W','W','G','W'},
                {'W','D','W','W','W','W','W','W','W','D','W'},
                {'#','W','G','W','W','W','W','W','G','W','#'},
                {'#','#','W','D','G','D','G','D','W','#','#'},
                {'#','#','#','W','W','W','W','W','#','#','#'}
        };
        while(x<11||z<11){
            if(cord[x][z]=='W'){

            }
            if(cord[x][z]=='D'){

            }
            if(cord[x][z]=='G'){

            }
            x++;
            if(x==10){
                x=0;
                z++;
            }
        }



    }
    public static void b2shapetest(){
        x=0;
        y=1;
        z=0;

        char[][] cords ={
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
        };

        while(x<11||z<11){
            if(cords[x][z]=='A'){

            }
            if(cords[x][z]=='P'){

            }
            x++;
            if(x==10){
                x=0;
                z++;
            }

        }



    }


}
