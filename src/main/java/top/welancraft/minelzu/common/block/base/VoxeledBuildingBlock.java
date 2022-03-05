package top.welancraft.minelzu.common.block.base;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import top.welancraft.minelzu.common.block.api.ISpecialLayer;

import javax.annotation.Nonnull;

public class VoxeledBuildingBlock extends SimpleBuildingBlock implements ISpecialLayer {
    private final VoxelShape shape;

    public VoxeledBuildingBlock(VoxelShape shape) {
        this.shape = shape;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, @Nonnull ISelectionContext ctx) {
        return shape;
    }
}
