package com.gtnecore.client;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.gtnecore.client.renderer.texture.GTNECoreTextures;
import com.gtnecore.common.CommonProxy;

import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        GTNECoreTextures.preInit();
    }

    @SubscribeEvent
    public static void textureStitchPre(@NotNull TextureStitchEvent.Pre event) {
        /**/
    }
}
