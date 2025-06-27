package com.gtnecore.api.unification.material;

import gregtech.api.unification.material.Material;

public class GTNEMaterials {

    public static Material HIGH_PURITY_SILICON;
    public static Material Draconium;
    public static Material Awakened_Draconium;
    public static Material Highly_Active_Draconium;
    public static Material Highly_Active_Awakened_Draconium;
    public static Material Infinity;
    public static Material Celestiallium;
    public static Material Lunatium;
    public static Material Stellarium;
    public static Material Fractallium;
    public static Material Entropium;
    public static Material Sacred_Metal;

    public static void registerMaterialHigh() {
        GTNEMaterialFlags.init();
    }

    public static void registerMaterialLow() {
        GTNEWindowsMaterials.init();
    }
}
