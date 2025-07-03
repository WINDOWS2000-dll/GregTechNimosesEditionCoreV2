package com.gtnecore.api.unification.material;

import static com.gtnecore.api.unification.material.GTNEElements.*;
import static com.gtnecore.api.unification.material.GTNEMaterials.*;
import static com.gtnecore.api.util.GTNEUtility.DefaultMaterialFlags;
import static com.gtnecore.api.util.GTNEUtility.gtneID;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

import gregtech.api.GTValues;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.MaterialToolProperty;

import com.gtnecore.api.unification.material.info.GTNEMaterialIconSet;

public class GTNEWindowsMaterials {

    public static void init() {
        // 24001 ~ 24500
        HIGH_PURITY_SILICON = new Material.Builder(24001, gtneID("high_purity_silicon"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2273))
                .color(0x2a2a2a)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL)
                .blast(b -> b
                        .temp(2400, BlastProperty.GasTier.LOW))
                .build();

        Draconium = new Material.Builder(24002, gtneID("draconium"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(4800))
                .color(0x9b00ff)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .blast(b -> b
                        .temp(4700, BlastProperty.GasTier.HIGH)
                        .blastStats(8192, 10000)
                        .vacuumStats(VA[EV], 750))
                .toolStats(MaterialToolProperty.Builder.of(400F, 100F, 42000, 160).build())
                .cableProperties(8192L, 16, 16, false)
                .element(Dc)
                .build();

        Awakened_Draconium = new Material.Builder(24003, gtneID("draconium_awakened"))
                .dust()
                .ingot()
                .plasma()
                .liquid(new FluidBuilder().temperature(9001))
                .color(0xff5100)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DefaultMaterialFlags)
                .blast(b -> b
                        .temp(9000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(120000, 12000)
                        .vacuumStats(VA[ZPM], 750))
                .toolStats(MaterialToolProperty.Builder.of(700F, 200F, 81920, 500).build())
                .cableProperties(GTValues.V[9], 32, 16, false)
                .element(DcX)
                .build();

        Highly_Active_Draconium = new Material.Builder(24004, gtneID("highly_active_draconium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(17500))
                .plasma()
                .color(0x32064f)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME,
                        GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW,
                        GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blast(b -> b
                        .temp(17500, BlastProperty.GasTier.HIGHEST)
                        .blastStats(2000000, 9600)
                        .vacuumStats(VA[UV], 1000))
                .toolStats(MaterialToolProperty.Builder.of(800F, 280F, 96000, 200).build())
                .cableProperties(V[UEV], 32, 32, false)
                .element(HADc)
                .build();

        Highly_Active_Awakened_Draconium = new Material.Builder(24005, gtneID("highly_active_awakened_draconium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(23500))
                .plasma()
                .color(0x943001)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROTOR, GENERATE_FRAME,
                        GENERATE_FINE_WIRE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING, GENERATE_BOLT_SCREW,
                        GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_PLATE, GENERATE_ROUND)
                .blast(b -> b
                        .temp(23500, BlastProperty.GasTier.HIGHEST)
                        .blastStats(12000000, 4800)
                        .vacuumStats(VA[UEV], 1200))
                .toolStats(MaterialToolProperty.Builder.of(1000F, 320F, 120000, 600).build())
                .cableProperties(V[UIV], 32, 64, false)
                .element(HADcX)
                .build();

        Infinity = new Material.Builder(24006, gtneID("infinity"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2000000000).textures(true, false))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(GTNEMaterialIconSet.INFINITY)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(6000F, 1800F, 8192000, 999).build())
                .cableProperties(V[UEV], 32, 0, false)
                .element(If)
                .build();

        Celestiallium = new Material.Builder(24007, gtneID("celestiallium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(16))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(8000F, 2000F, 16384000, 999).build())
                .cableProperties(V[UIV], 32, 0, false)
                .element(CLS)
                .build();

        Lunatium = new Material.Builder(24008, gtneID("lunatium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(666666666))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(8000F, 2000F, 16384000, 999).build())
                .cableProperties(V[UIV], 524288, 600000, false)
                .element(LNT)
                .build();

        Sacred_Metal = new Material.Builder(24009, gtneID("sacred_metal"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(77777777))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(9000F, 3000F, 32768000, 999).build())
                .cableProperties(V[UIV], 64, 0, false)
                .element(SCR)
                .build();

        Stellarium = new Material.Builder(24010, gtneID("stellarium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647).textures(true, false))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(GTNEMaterialIconSet.STELLARIUM)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(10000F, 4000F, 65536000, 999).build())
                .cableProperties(V[UXV], 64, 0, false)
                .element(STL)
                .build();

        Fractallium = new Material.Builder(24011, gtneID("fractallium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(20000F, 8000F, 131072000, 999).build())
                .cableProperties(V[OpV], 64, 0, false)
                .element(FTL)
                .build();

        Entropium = new Material.Builder(24012, gtneID("entropium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2147483647))
                .plasma()
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DULL)
                .flags(DefaultMaterialFlags)
                .blast(builder -> builder
                        .temp(200_000_000))
                .toolStats(MaterialToolProperty.Builder.of(2147483647F, 10000000F, 2147483647, 999).build())
                .cableProperties(V[MAX], 128, 0, false)
                .element(ETP)
                .build();
    }
}
