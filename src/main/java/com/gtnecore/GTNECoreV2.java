package com.gtnecore;

import com.gtnecore.api.util.GTNELogger;
import com.gtnecore.modules.GTNEModuleManager;
import com.gtnecore.modules.GTNEModules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;


import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
     modid = GTNECoreValues.MODID,
     version = GTNECoreValues.MOD_VER,
     name = GTNECoreValues.MOD_NAME,
     acceptedMinecraftVersions = "[1.12.2]")
@Mod.EventBusSubscriber(modid = GTNECoreValues.MODID)
public class GTNECoreV2 {

    private GTNEModuleManager moduleManager;

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent constructionEvent) {
        MinecraftForge.EVENT_BUS.register(this);
        GTNELogger.logger.info("starting construction event...");
        moduleManager = GTNEModuleManager.getInstance();
        moduleManager.registerContainer(new GTNEModules());
        moduleManager.setup(constructionEvent.getASMHarvestedData(), Loader.instance().getConfigDir());
        moduleManager.onConstruction(constructionEvent);
        GTNELogger.logger.info("finished construction!");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preInitializationEvent) {
        moduleManager.onPreInit(preInitializationEvent);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent initializationEvent) {
        moduleManager.onInit(initializationEvent);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent postInitializationEvent) {
        moduleManager.onPostInit(postInitializationEvent);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent loadCompleteEvent) {
        moduleManager.onLoadComplete(loadCompleteEvent);
    }

    @Mod.EventHandler
    public void serverAboutToStart(FMLServerAboutToStartEvent serverAboutToStartEvent) {
        moduleManager.onServerAboutToStart(serverAboutToStartEvent);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent serverStartingEvent) {
        moduleManager.onServerStarting(serverStartingEvent);
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent serverStartedEvent) {
        moduleManager.onServerStarted(serverStartedEvent);
    }

    @Mod.EventHandler
    public void serverStopping(FMLServerStoppingEvent serverStoppingEvent) {
        moduleManager.onServerStopping(serverStoppingEvent);
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent serverStoppedEvent) {
        moduleManager.onServerStopped(serverStoppedEvent);
    }

    @Mod.EventHandler
    public void respondIMC(FMLInterModComms.IMCEvent event) {
        moduleManager.processIMC(event.getMessages());
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GTNECoreValues.MODID)) {
            ConfigManager.sync(GTNECoreValues.MODID, Config.Type.INSTANCE);
        }
    }


}
