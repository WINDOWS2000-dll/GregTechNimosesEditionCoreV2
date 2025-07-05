package com.gtnecore.common.Block;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

import com.gtnecore.common.Block.elevator.ElevatorCasing;
import com.gtnecore.common.Block.elevator.ElevatorCasingTiered;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTNEMetaBlocks {

    public static BlockGTNEWireCoil BLOCK_GTNE_WIRE_COIL;
    public static ElevatorCasingTiered ELEVATOR_CASING_TIERED;
    public static ElevatorCasing ELEVATOR_CASING;

    public static void init() {
        BLOCK_GTNE_WIRE_COIL = new BlockGTNEWireCoil();
        BLOCK_GTNE_WIRE_COIL.setRegistryName("gtne_wire_coil");
        ELEVATOR_CASING_TIERED = new ElevatorCasingTiered();
        ELEVATOR_CASING_TIERED.setRegistryName("gtne_elevator_casing_tiered");
        ELEVATOR_CASING = new ElevatorCasing();
        ELEVATOR_CASING.setRegistryName("gtne_elevator_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        BLOCK_GTNE_WIRE_COIL.onModelRegister();
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }
}
