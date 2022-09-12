package top.welancraft.minelzu.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.welancraft.minelzu.common.util.RegistryHandler;

@Mod(MineLZU.MODID)
public class MineLZU {
    public static final String MODID = "minelzu";
    public static final Logger LOGGER = LoggerFactory.getLogger(MineLZU.class);

    public MineLZU() {
        RegistryHandler.initReferences();
        RegistryHandler.register();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
