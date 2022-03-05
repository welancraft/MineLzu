package top.welancraft.minelzu.common.block.base;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SimpleBuildingBlock extends Block {
    public SimpleBuildingBlock() {
        super(Properties.of(Material.STONE).noOcclusion().strength(-1, 100F));
    }
}
