package com.gtnecore.client.renderer.texture;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;

import com.gtnecore.GTNECoreValues;

@Mod.EventBusSubscriber(modid = GTNECoreValues.MODID, value = Side.CLIENT)
public class GTNECoreTextures {

    /////////////////////////////////////////////////////////////////////////////
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_4x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_16x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_64x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_256x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_1024x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_4096x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_16384x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_65536x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_262144x;
    public static SimpleOverlayRenderer MULTIPART_WIRELESS_ENERGY_1048576x;
    /////////////////////////////////////////////////////////////////////////////

    public static void preInit() {
        MULTIPART_WIRELESS_ENERGY = new SimpleOverlayRenderer("wireless_hatch/overlay_front");
        MULTIPART_WIRELESS_ENERGY_4x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.4x");
        MULTIPART_WIRELESS_ENERGY_16x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.16x");
        MULTIPART_WIRELESS_ENERGY_64x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.64x");
        MULTIPART_WIRELESS_ENERGY_256x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.256x");
        MULTIPART_WIRELESS_ENERGY_1024x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.1024x");
        MULTIPART_WIRELESS_ENERGY_4096x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.4096x");
        MULTIPART_WIRELESS_ENERGY_16384x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.16384x");
        MULTIPART_WIRELESS_ENERGY_65536x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.65536x");
        MULTIPART_WIRELESS_ENERGY_262144x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.262144x");
        MULTIPART_WIRELESS_ENERGY_1048576x = new SimpleOverlayRenderer("wireless_hatch/overlay_front.1048576x");
    }
}
