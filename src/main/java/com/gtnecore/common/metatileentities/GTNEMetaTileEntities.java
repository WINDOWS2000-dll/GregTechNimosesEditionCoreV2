package com.gtnecore.common.metatileentities;

import static gregtech.api.GTValues.VN;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

import net.minecraft.util.ResourceLocation;

import com.gtnecore.common.metatileentities.multi.multiblockpart.MetaTileEntityWirelessEnergyHatch;

import org.jetbrains.annotations.NotNull;

public class GTNEMetaTileEntities {

    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_4A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_4A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_16A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_16A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_64A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_64A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_256A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_256A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_1024A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_1024A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_4096A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_4096A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_16384A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_16384A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_65536A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_65536A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_262144A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_262144A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_1048576A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_1048576A = new MetaTileEntityWirelessEnergyHatch[15];

    public static void Initialization() {
        for (int i = 0; i < 15; i++) {
            String tier = VN[i].toLowerCase();
            WIRELESS_INPUT_ENERGY_HATCH[i] = registerMetaTileEntity(3000 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input." + tier), i, 2, false));
            WIRELESS_INPUT_ENERGY_HATCH_4A[i] = registerMetaTileEntity(3000 + 15 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_4a." + tier), i, 4,
                            false));
            WIRELESS_INPUT_ENERGY_HATCH_16A[i] = registerMetaTileEntity(3000 + 30 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_16a." + tier), i, 16,
                            false));
            WIRELESS_INPUT_ENERGY_HATCH_64A[i] = registerMetaTileEntity(3000 + 45 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_64a." + tier), i, 64,
                            false));
            WIRELESS_INPUT_ENERGY_HATCH_256A[i] = registerMetaTileEntity(3000 + 60 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_256a." + tier), i, 256,
                            false));
            WIRELESS_INPUT_ENERGY_HATCH_1024A[i] = registerMetaTileEntity(3000 + 75 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_1024a." + tier), i, 1024,
                            false));
            WIRELESS_INPUT_ENERGY_HATCH_4096A[i] = registerMetaTileEntity(3000 + 90 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_4096a." + tier), i, 4096,
                            false));
            WIRELESS_INPUT_ENERGY_HATCH_16384A[i] = registerMetaTileEntity(3000 + 105 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_16384a." + tier), i,
                            16384, false));
            WIRELESS_INPUT_ENERGY_HATCH_65536A[i] = registerMetaTileEntity(3000 + 120 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_65536a." + tier), i,
                            65536, false));
            WIRELESS_INPUT_ENERGY_HATCH_262144A[i] = registerMetaTileEntity(3000 + 135 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_262144a." + tier), i,
                            262144, false));
            WIRELESS_INPUT_ENERGY_HATCH_1048576A[i] = registerMetaTileEntity(3000 + 150 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.input_1048576a." + tier), i,
                            1048576, false));

            WIRELESS_OUTPUT_ENERGY_HATCH[i] = registerMetaTileEntity(3000 + 165 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output." + tier), i, 2, true));
            WIRELESS_OUTPUT_ENERGY_HATCH_4A[i] = registerMetaTileEntity(3000 + 180 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_4a." + tier), i, 4,
                            true));
            WIRELESS_OUTPUT_ENERGY_HATCH_16A[i] = registerMetaTileEntity(3000 + 195 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_16a." + tier), i, 16,
                            true));
            WIRELESS_OUTPUT_ENERGY_HATCH_64A[i] = registerMetaTileEntity(3000 + 210 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_64a." + tier), i, 64,
                            true));
            WIRELESS_OUTPUT_ENERGY_HATCH_256A[i] = registerMetaTileEntity(3000 + 225 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_256a." + tier), i, 256,
                            true));
            WIRELESS_OUTPUT_ENERGY_HATCH_1024A[i] = registerMetaTileEntity(3000 + 240 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_1024a." + tier), i, 1024,
                            true));
            WIRELESS_OUTPUT_ENERGY_HATCH_4096A[i] = registerMetaTileEntity(3000 + 255 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_4096a." + tier), i, 4096,
                            true));
            WIRELESS_OUTPUT_ENERGY_HATCH_16384A[i] = registerMetaTileEntity(3000 + 270 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_16384a." + tier), i,
                            16384, true));
            WIRELESS_OUTPUT_ENERGY_HATCH_65536A[i] = registerMetaTileEntity(3000 + 285 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_65536a." + tier), i,
                            65536, true));
            WIRELESS_OUTPUT_ENERGY_HATCH_262144A[i] = registerMetaTileEntity(3000 + 300 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_262144a." + tier), i,
                            262144, true));
            WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[i] = registerMetaTileEntity(3000 + 315 + i,
                    new MetaTileEntityWirelessEnergyHatch(gtneId("wireless_energy_hatch.output_1048576a." + tier), i,
                            1048576, true));
        }
    }

    @NotNull
    public static ResourceLocation gtneId(String mtename) {
        return new ResourceLocation("gtnecore", mtename);
    }
}
