package com.shadowbeastgod.eternalexsistance.world;

import com.shadowbeastgod.eternalexsistance.blocks.modblocks;
import com.shadowbeastgod.eternalexsistance.experiment.CubeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import java.util.Optional;
import java.util.function.Function;

public class godrealmteleportal implements ITeleporter {
    public static ServerLevel level = null;
    private BlockPos plat;

    public godrealmteleportal(BlockPos bpos,ServerLevel level, Entity entity) {
        this.level = level;
        portalbuild(bpos,false);
    }


    public void portalbuild(BlockPos bpos, boolean portalbuilt){
        int x=0;
        int y=0;
        int z=0;
        int xoff = -5;
        int yoff = -1;
        int zoff = -5;
        int intstate = 0;

        BlockState portalcyc = modblocks.GRPORTALBLOCK.get().defaultBlockState();

        IntegerProperty PORTAL = IntegerProperty.create("portal",0,72);


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
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());


                }
                if(y==2){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff, y + 3 , z + zoff);
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());
                }
                if(y==3){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff+2, z + zoff);
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff,   y, z + zoff);
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    mutablePos.setWithOffset(bpos, x + xoff,y-1, z + zoff);
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                }
                if (y==0||y==1){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                }

            }
            if (portal[y][x][z] =='W') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                godrealmteleportal.level.setBlockAndUpdate(mutablePos, modblocks.WAKARANAIBLOCK.get().defaultBlockState());
            }
            if (portal[y][x][z] =='D') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                godrealmteleportal.level.setBlockAndUpdate(mutablePos, modblocks.GUILDEDWAKARANAIBLOCK.get().defaultBlockState());
            }
            if (portal[y][x][z] =='G') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                godrealmteleportal.level.setBlockAndUpdate(mutablePos, Blocks.GOLD_BLOCK.defaultBlockState());
            }
            if (portal[y][x][z] =='R') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 3, z + zoff);
                godrealmteleportal.level.setBlockAndUpdate(mutablePos, modblocks.PORTALSPAWNPLATFORM.get().defaultBlockState());

                BlockPos r = mutablePos;
                r.offset(-12,26,-37);

                this.plat = r;
                System.out.println("genx:"+r.getX()+"geny:"+r.getY()+"genz:"+r.getZ() +"var:"+ this.plat.getY());



            }
            if (portal[y][x][z] =='F') {
                if (y==3) {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlock(mutablePos,portalcyc.cycle(PORTAL), intstate);
                    intstate++;
                    System.out.println("BlockState " + intstate + ": x:" + x + ", y:" + y + ", z:" +z);

                    mutablePos.setWithOffset(bpos, x + xoff, y+0, z + zoff);
                    level.setBlock(mutablePos,portalcyc.cycle(PORTAL), intstate);
                    intstate++;
                    System.out.println("BlockState " + intstate + ": x:" + x + ", y:" + (y + 1) + ", z:" +z);

                    mutablePos.setWithOffset(bpos, x + xoff,y+1, z + zoff);
                    level.setBlock(mutablePos,portalcyc.cycle(PORTAL), intstate);
                    intstate++;
                    System.out.println("BlockState " + intstate + ": x:" + x + ", y:" + (y + 2) + ", z:" +z);
                }
                if(y==2){
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlock(mutablePos,portalcyc.cycle(PORTAL), intstate);
                    intstate++;
                    System.out.println("BlockState " + intstate + ": x:" + x + ", y:" + y + ", z:" +z);

                    mutablePos.setWithOffset(bpos, x + xoff, y + 3 , z + zoff);
                    level.setBlock(mutablePos,portalcyc.cycle(PORTAL), intstate);
                    intstate++;
                    System.out.println("BlockState " + intstate + ": x:" + x + ", y:" + (y+2)  + ", z:" +z);
                }
            }

            if (portal[y][x][z] =='A') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                godrealmteleportal.level.setBlockAndUpdate(mutablePos, modblocks.ETERNALALTAR.get().defaultBlockState());

            }
            if (portal[y][x][z] =='P') {
                mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                godrealmteleportal.level.setBlockAndUpdate(mutablePos, modblocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get().defaultBlockState());

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

    public Optional<CubeUtil.foundCube> makePortal(BlockPos pos, Direction.Axis axis) {
        //portalStructure.portalbuild(pos,false);

        return Optional.of(new CubeUtil.foundCube(pos.immutable(), 10, 10, 10));
    }

    //ArmorStand
    //EndPortalBlock

}
