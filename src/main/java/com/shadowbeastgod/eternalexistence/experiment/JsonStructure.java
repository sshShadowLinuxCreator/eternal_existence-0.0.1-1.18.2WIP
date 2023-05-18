package com.shadowbeastgod.eternalexistence.experiment;

import com.sun.jna.StringArray;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class JsonStructure {
    private Object[] block;
    private Object[] blockState;

    public JsonStructure(Iterable<BlockPos> positions,
                        Map<Block, Character> blockMatcher,
                         Map<BlockState, Character> blockStateMatcher,
                         Map<String,Integer> dims,
                         Level level,BlockPos lowpos){

        this.block = assignb(positions,level,lowpos,blockMatcher,dims);
        this.blockState = assignbs(positions,level,lowpos,blockStateMatcher,dims);



    }

    public Object[] assignb(Iterable<BlockPos> positions, Level level,BlockPos lowpos,Map<Block, Character> blockMatcher,Map<String,Integer> dims){
        Object[] ablock = new Object[2];

        char[][][] preletters = new char[dims.get("height")][dims.get("width")][dims.get("depth")];

        for (BlockPos bp : positions){
            preletters[bp.getY()-lowpos.getY()][bp.getX()-lowpos.getX()][bp.getZ()-lowpos.getZ()] =
                    blockMatcher.get(level.getBlockState(bp).getBlock());
        }

        String[][] letters= convertCharArrayToStringArray(preletters);

        ablock[0] = letters;
        ablock[1] = blockMatcher;

        return  ablock;
    }

    public static String[][] convertCharArrayToStringArray(char[][][] charArray) {
        int dim1 = charArray.length;
        int dim2 = charArray[0].length;
        int dim3 = charArray[0][0].length;

        String[][] stringArray = new String[dim1][dim2];

        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                stringArray[i][j] = String.valueOf(charArray[i][j]);
            }
        }

        return stringArray;
    }

    public Object[] assignbs(Iterable<BlockPos> positions, Level level,BlockPos lowpos,Map<BlockState, Character> blockMatcher,Map<String,Integer> dims){
        Object[] ablock = new Object[2];

        char[][][] preletters = new char[dims.get("height")][dims.get("width")][dims.get("depth")];

        for (BlockPos bp : positions){
            preletters[bp.getY()-lowpos.getY()][bp.getX()-lowpos.getX()][bp.getZ()-lowpos.getZ()] =
                    blockMatcher.get(level.getBlockState(bp));
        }

        String[][] letters= convertCharArrayToStringArray(preletters);

        ablock[0] = letters;
        ablock[1] = blockMatcher;

        return  ablock;
    }



}
