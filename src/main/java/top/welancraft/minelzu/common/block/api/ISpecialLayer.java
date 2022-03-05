package top.welancraft.minelzu.common.block.api;

import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface ISpecialLayer {
    @OnlyIn(Dist.CLIENT)
    default RenderType getRenderType() {
        return RenderType.cutout();
    }
}
