package com.gtnecore.common.Block.elevator;

import com.gtnecore.api.blocks.IElevatorMotorTier;
import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ElevatorCasingTiered extends VariantBlock<ElevatorCasingTiered.CasingType> {

    public ElevatorCasingTiered() {
        super(Material.IRON);
        setTranslationKey("gtne_elevator_casing_tiered");
        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 3);
        setDefaultState(this.getState(CasingType.ELEVATOR_MOTOR_1));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum CasingType implements IStringSerializable, IElevatorMotorTier {

        ELEVATOR_MOTOR_1("elevator_motor_1"),
        ELEVATOR_MOTOR_2("elevator_motor_2"),
        ELEVATOR_MOTOR_3("elevator_motor_3"),
        ELEVATOR_MOTOR_4("elevator_motor_4"),
        ELEVATOR_MOTOR_5("elevator_motor_5");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getName() {
            return this.name;
        }

        @Override
        public int getTier() {
            return this.ordinal();
        }

    }

}
