package com.gtnecore.core;

import static gregtech.api.GregTechAPI.*;

import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.gtnecore.GTNECoreValues;
import com.gtnecore.api.module.GTNEModule;
import com.gtnecore.api.module.IGTNEModule;
import com.gtnecore.common.Block.BlockGTNEWireCoil;
import com.gtnecore.common.Block.GTNEMetaBlocks;
import com.gtnecore.common.CommonProxy;
import com.gtnecore.common.metatileentities.GTNEMetaTileEntities;
import com.gtnecore.modules.GTNEModules;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@GTNEModule(
            moduleID = GTNEModules.MODULE_CORE,
            containerID = GTNECoreValues.MODID,
            name = "GregTech NimosesEdition Core",
            description = "Core GTNE content. Disabling this disables the entire mod and all its addons.",
            coreModule = true)
public class CoreModule implements IGTNEModule {

    public static final Logger logger = LogManager.getLogger("GTNECore");

    @Override
    public @NotNull Logger getLogger() {
        return logger;
    }

    @SidedProxy(modId = "gtnecore",
                clientSide = "com.gtnecore.client.ClientProxy",
                serverSide = "com.gtnecore.common.CommonProxy")
    public static CommonProxy proxy;

    @Override
    public void construction(FMLConstructionEvent constructionEvent) {
        /**/
    }

    @Override
    public void preInit(FMLPreInitializationEvent preInitEvent) {

        proxy.preInit(preInitEvent);
        proxy.preLoad();

        GTNEMetaBlocks.init();

        logger.info("Registering GTNE Meta Tile Entities");
        GTNEMetaTileEntities.Initialization();

        for (BlockGTNEWireCoil.CoilType type : BlockGTNEWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTNEMetaBlocks.BLOCK_GTNE_WIRE_COIL.getState(type), type);
        }
    }
}
