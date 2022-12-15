package com.shadowbeastgod.eternalexistence.experiment;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;

public class CubeUtil extends BlockUtil {
    public static class foundCube{
        public final BlockPos minCorner;
        /** Distance between minimum and maximum values on the first axis argument */
        public final BlockPos maxCorner;
        public final int axis1Size;
        /** Distance between minimum and maximum values on the second axis argument */
        public final int axis2Size;

        public final int axis3Size;




        public foundCube(BlockPos minCorner,BlockPos maxCorner, int pAxis1Size, int pAxis2Size, int pAxis3Size) {
            this.minCorner = minCorner;
            this.maxCorner = maxCorner;
            this.axis1Size = pAxis1Size;
            this.axis2Size = pAxis2Size;
            this.axis3Size = pAxis3Size;

        }
    }

}
