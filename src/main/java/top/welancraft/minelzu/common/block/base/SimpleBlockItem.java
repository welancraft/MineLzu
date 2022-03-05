package top.welancraft.minelzu.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import top.welancraft.minelzu.client.creativeTab.TabInit;

public class SimpleBlockItem extends BlockItem {

    public SimpleBlockItem(Block block) {
        super(block, new Properties().tab(TabInit.MAIN));
    }
}
