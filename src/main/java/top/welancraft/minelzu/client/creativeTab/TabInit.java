package top.welancraft.minelzu.client.creativeTab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class TabInit {
    public static final ItemGroup MAIN = new ItemGroup("minelzu.main") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            //todo:Icon
            return ItemStack.EMPTY;
        }
    };
}
