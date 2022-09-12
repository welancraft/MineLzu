package top.welancraft.minelzu.common.block.shapes;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;

import static top.welancraft.minelzu.common.block.init.BlockReference.*;

public class BlockShapes {
    public static final Map<String, VoxelShape> singleVoxeledBlockList = new HashMap<>();
    public static final Map<String, double[]> simpleHorizontalBlockList = new HashMap<>();

    public static void init() {
        singleVoxeledBlockList.put(lampPost, Block.box(6, 0, 6, 10, 16, 10));

        simpleHorizontalBlockList.put(outerWall2, new double[]{0, 0, 3, 16, 16, 13});
        simpleHorizontalBlockList.put(academy2OpenworkBricks, new double[]{0, 0, 0, 16, 16, 16});
    }

    public static VoxelShape getFromDouble(double[] d) {
        return Block.box(d[0], d[1], d[2], d[3], d[4], d[5]);
    }

    public static double[] rotateV(double[] d) {
        return new double[]{d[2], d[1], d[0], d[5], d[4], d[3]};
    }

}
