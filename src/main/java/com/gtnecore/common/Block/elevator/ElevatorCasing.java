package com.gtnecore.common.Block.elevator;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import gregtech.api.block.VariantBlock;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

public class ElevatorCasing extends VariantBlock<ElevatorCasing.CasingType> {

    public ElevatorCasing() {
        super(Material.IRON);
        setTranslationKey("gtne_elevator_casing");
        setHardness(50.F);
        setResistance(10.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 3);
        setDefaultState(this.getState(CasingType.HIGH_STRENGTH_CONCRETE));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum CasingType implements IStringSerializable {

        HIGH_STRENGTH_CONCRETE("concrete_strong"),
        ELEVATOR_BASE_CASING("elevator_base"),
        ELEVATOR_INTERNAL_STRUCTURE("elevator_internal"),
        ELEVATOR_SUPPORT_STRUCTURE("elevator_support"),
        ELEVATOR_CABLE("elevator_cable");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getName() {
            return this.name;
        }
    }
}
