package top.welancraft.minelzu.common.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.welancraft.minelzu.common.MineLZU;
import top.welancraft.minelzu.common.block.init.BlockInit;
import top.welancraft.minelzu.common.block.init.BlockReference;
import top.welancraft.minelzu.common.block.shapes.BlockShapes;

public class RegistryHandler {

    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, MineLZU.MODID);
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, MineLZU.MODID);

    public static void initReferences() {
        BlockReference.init();
        BlockShapes.init();
    }

    public static void register() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.registerBlock();

        Blocks.register(eventBus);
        Items.register(eventBus);
    }
}
