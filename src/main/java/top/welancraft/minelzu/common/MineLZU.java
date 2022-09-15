package top.welancraft.minelzu.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.welancraft.minelzu.common.util.RegistryHandler;

@Mod(MineLZU.MODID)
public class MineLZU {
    public static final String MODID = "minelzu";
    public static final Logger LOGGER = LogManager.getLogger();

    public MineLZU() {
        RegistryHandler.initReferences();
        RegistryHandler.register();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
