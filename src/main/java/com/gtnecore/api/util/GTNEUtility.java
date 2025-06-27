package com.gtnecore.api.util;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_DOUBLE_PLATE;

import net.minecraft.util.ResourceLocation;

import gregtech.api.unification.material.info.MaterialFlag;

import com.gtnecore.GTNECoreValues;

import org.jetbrains.annotations.NotNull;

public class GTNEUtility {

    public static @NotNull ResourceLocation gtneID(String path) {
        return new ResourceLocation(GTNECoreValues.MODID, path);
    }

    /**
     * @implNote This Array is used GregTechNimosesEdition default Material Flag
     */
    public static MaterialFlag[] DefaultMaterialFlags = new MaterialFlag[] {
            GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL,
            GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING,
            GENERATE_SPRING_SMALL, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_RING,
            GENERATE_DENSE, GENERATE_FINE_WIRE, GENERATE_FRAME, GENERATE_DOUBLE_PLATE
    };
}
