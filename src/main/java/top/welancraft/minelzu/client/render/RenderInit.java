package top.welancraft.minelzu.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.welancraft.minelzu.common.block.api.ISpecialLayer;
import top.welancraft.minelzu.common.block.init.BlockInit;

import java.util.Collection;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderInit {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            final Collection<RegistryObject<Block>> blocks = BlockInit.BLOCKS.values();
            for (final RegistryObject<Block> blockRegistry : blocks) {
                final Block block = blockRegistry.get();
                if (block instanceof ISpecialLayer)
                    RenderTypeLookup.setRenderLayer(block, ((ISpecialLayer) block).getRenderType());
            }
        });
    }
}
