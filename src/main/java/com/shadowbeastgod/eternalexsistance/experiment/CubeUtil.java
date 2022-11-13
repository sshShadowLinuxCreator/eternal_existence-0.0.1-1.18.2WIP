package com.shadowbeastgod.eternalexsistance.experiment;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;

public class CubeUtil extends BlockUtil {
    public static class foundCube{
        public final BlockPos minCorner;
        /** Distance between minimum and maximum values on the first axis argument */
        public final int axis1Size;
        /** Distance between minimum and maximum values on the second axis argument */
        public final int axis2Size;

        public final int axis3Size;


        public foundCube(BlockPos minCorner, int pAxis1Size, int pAxis2Size, int pAxis3Size) {
            this.minCorner = minCorner;
            this.axis1Size = pAxis1Size;
            this.axis2Size = pAxis2Size;
            this.axis3Size = pAxis3Size;
        }
    }

}