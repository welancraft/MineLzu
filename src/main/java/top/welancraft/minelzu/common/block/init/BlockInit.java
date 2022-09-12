package top.welancraft.minelzu.common.block.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraftforge.fml.RegistryObject;
import top.welancraft.minelzu.client.creativeTab.TabInit;
import top.welancraft.minelzu.common.MineLZU;
import top.welancraft.minelzu.common.block.base.SimpleBuildingBlock;
import top.welancraft.minelzu.common.block.base.SimpleHorizontalWallBlock;
import top.welancraft.minelzu.common.block.base.TranslucentGlassBlock;
import top.welancraft.minelzu.common.block.base.VoxeledBuildingBlock;
import top.welancraft.minelzu.common.block.shapes.BlockShapes;
import top.welancraft.minelzu.common.util.RegistryHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static top.welancraft.minelzu.common.block.init.BlockReference.*;

public class BlockInit {
    public static final Map<String, RegistryObject<Block>> BLOCKS = new TreeMap<>();
    public static final Item.Properties DEFAULT = new Item.Properties().tab(TabInit.MAIN);

    public static final Map<String, VoxelShape> voxeledBlockMap = new HashMap<>();

    public static void registerBlock() {
        MineLZU.LOGGER.info("MineLzu >>> Registering blocks!");
        lazyRegisterSimpleBlock(outerWall1, corner1, bricksBrownWhite, bricksBrownBlack, bricksGreyBlack, bricksWhiteBlack);
        lazyRegisterStairsBlockNSlabBlock(bricksBrownWhite, bricksBrownBlack, bricksGreyBlack, bricksWhiteBlack);
        lazyRegisterGlassBlock(blueTranslucentGlass);
        BlockShapes.singleVoxeledBlockList.forEach((name, shape) -> BLOCKS.put(name, lazyRegisterVoxeledBlock(name, shape)));
        BlockShapes.simpleHorizontalBlockList.forEach((name, shape) -> BLOCKS.put(name, lazyRegisterSimpleHorizontalBlock(name, shape)));
        BLOCKS.forEach((name, block) -> RegistryHandler.Items.register(name, () -> new BlockItem(block.get(), DEFAULT)));
        MineLZU.LOGGER.info("MineLzu <<< Blocks registered!");
    }

    private static void lazyRegisterSimpleBlock(String... ids) {
        for (final String id : ids) BLOCKS.put(id, RegistryHandler.Blocks.register(id, SimpleBuildingBlock::new));
    }

    private static void lazyRegisterGlassBlock(String... ids) {
        for (final String id : ids) BLOCKS.put(id, RegistryHandler.Blocks.register(id, TranslucentGlassBlock::new));
    }

    private static void lazyRegisterStairsBlockNSlabBlock(String... ids) {
        for (final String id : ids) {
            if (!BLOCKS.containsKey(id)) {
                continue;
            }
            final String stairs = id + "_stairs";
            BLOCKS.put(stairs, RegistryHandler.Blocks.register(stairs, () -> new StairsBlock(() -> BLOCKS.get(id).get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE).noOcclusion().strength(-1, 100F))));
            final String slab = id + "_slab";
            BLOCKS.put(slab, RegistryHandler.Blocks.register(slab, () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE).noOcclusion().strength(-1, 100F))));
        }
    }

    private static RegistryObject<Block> lazyRegisterVoxeledBlock(String id, VoxelShape shape) {
        return RegistryHandler.Blocks.register(id, () -> new VoxeledBuildingBlock(shape));
    }

    private static RegistryObject<Block> lazyRegisterSimpleHorizontalBlock(String id, double[] shape) {
        return RegistryHandler.Blocks.register(id, () -> new SimpleHorizontalWallBlock(shape));
    }
}
