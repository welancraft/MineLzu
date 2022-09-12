package top.welancraft.minelzu.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

import static top.welancraft.minelzu.common.block.shapes.BlockShapes.getFromDouble;
import static top.welancraft.minelzu.common.block.shapes.BlockShapes.rotateV;

@SuppressWarnings("deprecation")
public class SimpleHorizontalWallBlock extends VoxeledBuildingBlock {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    private final double[] shape;

    public SimpleHorizontalWallBlock(double[] shape) {
        super(getFromDouble(shape));
        this.shape = shape;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, @Nonnull ISelectionContext ctx) {
        switch (state.getValue(FACING)) {
            case SOUTH:
            case NORTH:
                return getFromDouble(shape);
            case EAST:
            case WEST:
                return getFromDouble(rotateV(shape));
        }
        return getFromDouble(shape);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nonnull
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Nonnull
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
