package com.gtnecore.api;

import net.minecraft.block.state.IBlockState;

import com.gtnecore.api.blocks.IElevatorMotorTier;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class GTNEAPI {

    public static final Object2ObjectMap<IBlockState, IElevatorMotorTier> ELEVATOR_MOTORS = new Object2ObjectOpenHashMap<>();
}
