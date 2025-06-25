package com.gtnecore;

import com.gtnecore.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

@Mod(
     modid = GTNECoreValues.MODID,
     version = GTNECoreValues.MOD_VER,
     name = GTNECoreValues.MOD_NAME,
     acceptedMinecraftVersions = "[1.12.2]")
public class GTNECoreV2 {

    @SidedProxy(modId = "gtnecore", clientSide = "com.gtnecore.client.ClientProxy", serverSide = "com.gtnecore.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static GTNECoreV2 instance;

    public static Logger logger;

    @EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc. (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    // load "Do your mod setup. Build whatever data structures you care about." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
