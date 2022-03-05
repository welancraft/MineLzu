package top.welancraft.minelzu.common.block.shapes;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;

import static top.welancraft.minelzu.common.block.init.BlockReference.lampPost;

public class BlockShapes {
    public static Map<String, VoxelShape> voxeledBlockList = new HashMap<>();

    public static void init() {
        voxeledBlockList.put(lampPost, Block.box(6, 0, 6, 10, 16, 10));
    }
}
