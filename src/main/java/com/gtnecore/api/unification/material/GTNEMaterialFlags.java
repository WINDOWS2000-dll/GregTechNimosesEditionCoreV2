package com.gtnecore.api.unification.material;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_SMALL_GEAR;

import gregtech.api.unification.material.Materials;

public class GTNEMaterialFlags {

    public static void init() {
        // Iron
        Materials.Iron.addFlags(GENERATE_DOUBLE_PLATE);

        Materials.HSSG.addFlags(GENERATE_ROTOR);

        Materials.Naquadah.addFlags(GENERATE_GEAR, GENERATE_SMALL_GEAR);
    }
}
