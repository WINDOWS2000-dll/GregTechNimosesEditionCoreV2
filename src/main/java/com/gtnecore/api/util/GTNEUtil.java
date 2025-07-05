package com.gtnecore.api.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

import gregtech.api.block.machines.BlockMachine;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.util.BlockInfo;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

public class GTNEUtil {

    public static BlockMachine MACHINE;

    public static MetaTileEntityHolder getTileEntity(MetaTileEntity tile) {
        MetaTileEntityHolder holder = new MetaTileEntityHolder();
        holder.setMetaTileEntity(tile);
        holder.getMetaTileEntity().onPlacement();
        holder.getMetaTileEntity().setFrontFacing(EnumFacing.SOUTH);
        return holder;
    }

    /**
     * @param allowedStates Allowed Block States.
     * @return Used to build upgrade multiblock.
     */
    public static Supplier<BlockInfo[]> getCandidates(IBlockState... allowedStates) {
        return () -> Arrays.stream(allowedStates)
                .map(state -> new BlockInfo(state, null))
                .toArray(BlockInfo[]::new);
    }

    /**
     * @param metaTileEntities Allowed Meta Tile Entities.
     * @return Used to build upgrade multiblock.
     */
    public static Supplier<BlockInfo[]> getCandidates(MetaTileEntity... metaTileEntities) {
        return () -> Arrays.stream(metaTileEntities)
                .filter(Objects::nonNull)
                .map(tile -> new BlockInfo(MACHINE.getDefaultState(), getTileEntity(tile)))
                .toArray(BlockInfo[]::new);
    }
}
