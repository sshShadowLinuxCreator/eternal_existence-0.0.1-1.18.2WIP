package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RusbAlmvoCoggBogPortalConnectore extends Block {

    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 16, 18, 16);
    private static BlockPattern portalShape;

    public RusbAlmvoCoggBogPortalConnectore(Properties properties){
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockPos.MutableBlockPos mutablePos = pPos.mutable();
        int xin = pPos.getX()-5;
        int yin = pPos.getY()-1;
        int zin = pPos.getZ()-5;
        mutablePos.set(xin,yin,zin);
        boolean tested = false;

        int xtest = 0;
        int ytest = 0;
        int ztest = 0;

        int w = 0;
        int d = 0;
        int g = 0;
        int h = 0;
        int a = 0;
        int p = 0;

        //W=73
        //D=12
        //G=16
        //A=20
        //P=1
        //#=100
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
            }

        };

        if(!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND){
            while(!tested){

                if(w== 73 && d == 12 && g == 12 && a == 20 && p == 1 && h>=89 && pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.EXISTENCESPARK.get()){
                    portalbuild(pPos,false,pLevel);
                    pPlayer.getItemInHand(InteractionHand.MAIN_HAND).setCount(0);
                    break;
                }


                xtest++;
                if(xtest==11){
                    if(ztest==10){
                        xtest=0;
                        ztest=0;
                        ytest++;
                        if(ytest==2){
                            break;
                        }
                    }
                    xtest=0;
                    ztest++;
                }



                if(portal[ytest][xtest][ztest] != '?'){

                    mutablePos.set(xin+xtest,yin+ytest,zin+ztest);

                    if(portal[ytest][xtest][ztest]=='W'){
                        if (pLevel.getBlockState(mutablePos).getBlock()== ModBlocks.WAKARANAIBLOCK.get()){
                            w++;

                        }else {
                            pPlayer.sendMessage(new TranslatableComponent("Missing Block: わからない block at x:" +mutablePos.getX()+", y:"+mutablePos.getY()+", z:"+mutablePos.getZ()), pPlayer.getUUID());
                        }
                    }
                    if(portal[ytest][xtest][ztest]=='D'){
                        if (pLevel.getBlockState(mutablePos).getBlock()== ModBlocks.GUILDEDWAKARANAIBLOCK.get()){
                            d++;

                        }else {
                            pPlayer.sendMessage(new TranslatableComponent("Missing Block: Guilded わからない at x:" +mutablePos.getX()+", y:"+mutablePos.getY()+", z:"+mutablePos.getZ()), pPlayer.getUUID());
                        }
                    }
                    if(portal[ytest][xtest][ztest]=='G'){
                        if (pLevel.getBlockState(mutablePos).getBlock()==Blocks.GOLD_BLOCK){
                            g++;

                        }else {
                            pPlayer.sendMessage(new TranslatableComponent("Missing Block: Gold block at x:" +mutablePos.getX()+", y:"+mutablePos.getY()+", z:"+mutablePos.getZ()), pPlayer.getUUID());
                        }
                    }
                    if(portal[ytest][xtest][ztest]=='A'){
                        if (pLevel.getBlockState(mutablePos).getBlock()== ModBlocks.ETERNALALTAR.get()){
                            a++;

                        }else {
                            pPlayer.sendMessage(new TranslatableComponent("Missing Block: Eternal Altar at x:" +mutablePos.getX()+", y:"+mutablePos.getY()+", z:"+mutablePos.getZ()), pPlayer.getUUID());
                        }
                    }
                    if(portal[ytest][xtest][ztest]=='P'){
                        if (pLevel.getBlockState(mutablePos).getBlock()== ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get()){
                            p++;

                        }else {
                            pPlayer.sendMessage(new TranslatableComponent("Missing Block: бог область Portal Connectore at x:" +mutablePos.getX()+", y:"+mutablePos.getY()+", z:"+mutablePos.getZ()), pPlayer.getUUID());
                        }
                    }
                    if(portal[ytest][xtest][ztest]=='#'){
                        if (pLevel.getBlockState(mutablePos).getBlock()==Blocks.AIR){
                            h++;

                        }else {
                            pPlayer.sendMessage(new TranslatableComponent("Missing Block: Air at x:" +mutablePos.getX()+", y:"+mutablePos.getY()+", z:"+mutablePos.getZ()), pPlayer.getUUID());
                        }
                    }
                }





            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    /*public static BlockPattern getOrCreatePortalShape(){
        if(portalShape==null){
            portalShape = BlockPatternBuilder.start().aisle("???WWWWW???", "??WDGDGDW??", "?WGWWWWWGW?", "WDWWWWWWWDW", "WGWWWWWWWGW", "WDWWWWWWWDW", "WGWWWWWWWGW", "WDWWWWWWWDW", "??WDGDGDW??", "???WWWWW???")
                    .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                    .where('G', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.GOLD_BLOCK)))
                    .where('W', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.WAKARANAIBLOCK.get())))
                    .where('D', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.GUILDEDWAKARANAIBLOCK.get())))

                    .aisle("???AAAAA???", "??AAAAAAA??", "?AAAAAAAAA?", "AAAATTTAAAA", "AAATTTTTAAA", "AAATTCTTAAA", "AAATTTTTAAA", "AAAATTTAAAA", "?AAAAAAAAA?", "??AAAAAAA??", "???AAAAA???")
                    .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                    .where('A', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.AIR)))
                    .where('T', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.ETERNALALTAR.get())))
                    .where('C', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get()))).build()
            ;


        }

        return portalShape;
    }*/


    public void portalbuild(BlockPos bpos, boolean portalbuilt, Level level){
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
                        level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());


                    }
                    if (y == 2) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                       level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                        mutablePos.setWithOffset(bpos, x + xoff, y + 3, z + zoff);
                        level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());
                    }
                    if (y == 3) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 2, z + zoff);
                        level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                        mutablePos.setWithOffset(bpos, x + xoff, y, z + zoff);
                        level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                        mutablePos.setWithOffset(bpos, x + xoff, y - 1, z + zoff);
                        level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    }
                    if (y == 0 || y == 1) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        level.setBlockAndUpdate(mutablePos, Blocks.AIR.defaultBlockState());

                    }

                }
                if (portal[y][x][z] == 'W') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlockAndUpdate(mutablePos, ModBlocks.WAKARANAIBLOCK.get().defaultBlockState());
                }
                if (portal[y][x][z] == 'D') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlockAndUpdate(mutablePos, ModBlocks.GUILDEDWAKARANAIBLOCK.get().defaultBlockState());
                }
                if (portal[y][x][z] == 'G') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlockAndUpdate(mutablePos, Blocks.GOLD_BLOCK.defaultBlockState());
                }
                if (portal[y][x][z] == 'R') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff + 3, z + zoff);
                    level.setBlockAndUpdate(mutablePos, ModBlocks.PORTALSPAWNPLATFORM.get().defaultBlockState());


                    BlockPos r = mutablePos;
                    r.offset(-12, 26, -37);


                    //System.out.println("genx:" + r.getX() + "geny:" + r.getY() + "genz:" + r.getZ() + "var:" + this.plat.getY());


                }
                if (portal[y][x][z] == 'F') {
                    if (y == 3) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        level.setBlockAndUpdate(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)));
                        intstate++;
                        //System.out.println("cords["+1+"]["+bx+"]["+az+"] = " + intstate + ";");

                        mutablePos.setWithOffset(bpos, x + xoff, y + 0, z + zoff);
                        level.setBlockAndUpdate(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)));
                        intstate++;
                        //System.out.println("cords["+2+"]["+bx+"]["+az+"] = " + intstate + ";");

                        mutablePos.setWithOffset(bpos, x + xoff, y + 1, z + zoff);
                        level.setBlockAndUpdate(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)));
                        intstate++;
                        //System.out.println("cords["+ 3 +"]["+bx+"]["+az+"] = " + intstate + ";");
                    }
                    if (y == 2) {
                        mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                        level.setBlockAndUpdate(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)));
                        intstate++;
                        //System.out.println("cords["+0+"]["+bx+"]["+az+"] = " + intstate + ";");

                        mutablePos.setWithOffset(bpos, x + xoff, y + 3, z + zoff);
                        level.setBlockAndUpdate(mutablePos, portalcyc.setValue(PORTAL, Integer.valueOf(intstate)));
                        intstate++;
                        //System.out.println("cords["+4+"]["+bx+"]["+az+"] = " + intstate + ";");
                    }
                }

                if (portal[y][x][z] == 'A') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlockAndUpdate(mutablePos, ModBlocks.ETERNALALTAR.get().defaultBlockState());

                }
                if (portal[y][x][z] == 'P') {
                    mutablePos.setWithOffset(bpos, x + xoff, y + yoff, z + zoff);
                    level.setBlockAndUpdate(mutablePos, ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get().defaultBlockState());

                }
            }


        }

    }

}
