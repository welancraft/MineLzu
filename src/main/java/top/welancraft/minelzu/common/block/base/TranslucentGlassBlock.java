package top.welancraft.minelzu.common.block.base;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.welancraft.minelzu.common.block.api.ISpecialLayer;

public class TranslucentGlassBlock extends AbstractGlassBlock implements ISpecialLayer {
    public TranslucentGlassBlock() {
        super(Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(-1, 100F).noOcclusion());
    }

    @OnlyIn(Dist.CLIENT)
    public RenderType getRenderType() {
        return RenderType.translucent();
    }
}
