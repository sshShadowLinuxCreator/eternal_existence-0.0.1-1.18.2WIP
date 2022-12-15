package com.shadowbeastgod.eternalexistence.world;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.experiment.CubeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Function;

public class GodRealmTeleportal implements ITeleporter {
    public static ServerLevel level = null;
    public static BlockPos plat;

    public GodRealmTeleportal(BlockPos bpos, ServerLevel level, Entity entity) {
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
        int intstate = 1;

        //using these as blockstate cords
        int az = -2;
        int bx = -2;

        BlockState portalcyc = ModBlocks.GRPORTALBLOCK.get().defaultBlockState();

        IntegerProperty PORTAL = IntegerProperty.create("portal",0,72);


        BlockPos.MutableBlockPos mutablePos = bpos.mutable();

        char[][][] portal= {
                {
                        {'?','?','?','W','W','W','W','W','?','?','?','?'},
                        {'?','?','W','D','G','D','G','D','W','?','?','?'},
                        {'?','W','G','W','W','W','W','W','G','W','?','?'},
                        {'W','D','W','W','W','W','W','W','W','D','W','?'},
                        {'W','G','W','W','W','W','W','W','W','G','W','?'},
                        {'W','D','W','W','W','W','W','W','W','D','W','?'},
                        {'W','G','W','W','W','W','W','W','W','G','W','?'},
                        {'W','D','W','W','W','W','W','W','W','D','W','?'},
                        {'?','W','G','W','W','W','W','W','G','W','?','?'},
                        {'?','?','W','D','G','D','G','D','W','?','?','?'},
                        {'?','?','?','W','W','W','W','W','?','?','?','?'}
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
            z++;
            az++;
            if (z == 11) {
                if (x == 11) {
                    az =-2;
                    bx =-2;

                    y++;
                    x = 0;
                    z = 0;
                } else {
                    az = -2;
                    bx++;

                    z = 0;
                    x++;
                }
            }
            if(y==5){
                portalbuilt = true;
            }

            if(y!=5&&x!=11&&z!=11) {
                if (portal[y][x][z] == '#') {
                    if (y == 4) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 3, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());


                    }
                    if (y == 2) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                        mutablePos.setWithOffset(bpos, x + xoff, y + 3, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());
                    }
                    if (y == 3) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 2, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                        mutablePos.setWithOffset(bpos, x + xoff, y, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                        mutablePos.setWithOffset(bpos, x + xoff, y - 1, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    }
                    if (y == 0 || y == 1) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    }

                }
                if (portal[y][x][z] == 'W') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.WAKARANAIBLOCK.get().defaultBlockState());
                }
                if (portal[y][x][z] == 'D') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.GUILDEDWAKARANAIBLOCK.get().defaultBlockState());
                }
                if (portal[y][x][z] == 'G') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, Blocks.GOLD_BLOCK.defaultBlockState());
                }
                if (portal[y][x][z] == 'R') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 3, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.PORTALSPAWNPLATFORM.get().defaultBlockState());


                    BlockPos r = mutablePos;
                    r.offset(-12, 26, -37);

                    this.plat = mutablePos;
                    //System.out.println("genx:" + r.getX() + "geny:" + r.getY() + "genz:" + r.getZ() + "var:" + this.plat.getY());


                }
                if (portal[y][x][z] == 'F') {
                    if (y == 3) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        level.setBlock(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)), 0);
                        intstate++;
                        //System.out.println("cords["+1+"]["+bx+"]["+az+"] = " + intstate + ";");

                        mutablePos.setWithOffset(bpos, x + xoff, y + 0, z + zoff);
                        level.setBlock(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)), 0);
                        intstate++;
                        //System.out.println("cords["+2+"]["+bx+"]["+az+"] = " + intstate + ";");

                        mutablePos.setWithOffset(bpos, x + xoff, y + 1, z + zoff);
                        level.setBlock(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)), 0);
                        intstate++;
                        //System.out.println("cords["+ 3 +"]["+bx+"]["+az+"] = " + intstate + ";");
                    }
                    if (y == 2) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        level.setBlock(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)), 0);
                        intstate++;
                        //System.out.println("cords["+0+"]["+bx+"]["+az+"] = " + intstate + ";");

                        mutablePos.setWithOffset(bpos, x + xoff, y + 3, z + zoff);
                        level.setBlock(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)), 0);
                        intstate++;
                        //System.out.println("cords["+4+"]["+bx+"]["+az+"] = " + intstate + ";");
                    }
                }

                if (portal[y][x][z] == 'A') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.ETERNALALTAR.get().defaultBlockState());

                }
                if (portal[y][x][z] == 'P') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    GodRealmTeleportal.level.setBlockAndUpdate(mutablePos, ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get().defaultBlockState());

                }
            }


        }

    }

    public Optional<CubeUtil.foundCube> makePortal(BlockPos pos, Direction.Axis axis) {
        //PortalStructure.portalbuild(pos,false);

        return Optional.of(new CubeUtil.foundCube(pos.immutable(),pos.immutable(), 10, 10, 10));
    }

    //ArmorStand

    @Override
    @Nullable
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo)
    {
        Vec3 v = new Vec3(plat.getX()-5.5, plat.getY(), plat.getZ()-5.5);
        return new PortalInfo(v, Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }


}
