package com.gtnecore.api.patern;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;

import com.gtnecore.api.util.GTNEUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Supplier;

import org.apache.commons.lang3.ArrayUtils;

public class MultipleTraceabilityPredicate {

    public static TraceabilityPredicate optionalStates(String mark, IBlockState... allowedStates) {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState state = blockWorldState.getBlockState();
            if (state.getBlock() instanceof VariantActiveBlock) {
                blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            }
            if (ArrayUtils.contains(allowedStates, state)) {
                return (blockWorldState.getMatchContext().getOrPut(mark, true));
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, getCandidates(allowedStates));
    }

    public static TraceabilityPredicate optionalAbilities(String mark, MultiblockAbility<?>... allowedAbilities) {
        return new TraceabilityPredicate(blockWorldState -> {
            TileEntity tileEntity = blockWorldState.getTileEntity();
            if (tileEntity instanceof IGregTechTileEntity) {
                MetaTileEntity metaTileEntity = ((IGregTechTileEntity) tileEntity).getMetaTileEntity();
                if (metaTileEntity instanceof IMultiblockAbilityPart<?> && ArrayUtils.contains(allowedAbilities,
                        ((IMultiblockAbilityPart<?>) metaTileEntity).getAbility())) {
                    Set<IMultiblockAbilityPart> partsFound = blockWorldState.getMatchContext()
                            .getOrCreate("MultiblockParts", HashSet::new);
                    partsFound.add((IMultiblockAbilityPart) metaTileEntity);
                    return (blockWorldState.getMatchContext().getOrPut(mark, true));
                }
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, GTNEUtil.getCandidates(Arrays.stream(allowedAbilities)
                .flatMap(ability -> MultiblockAbility.REGISTRY.get(ability).stream()).toArray(MetaTileEntity[]::new)));
    }

    public static Supplier<BlockInfo[]> getCandidates(IBlockState... allowedStates) {
        return () -> Arrays.stream(allowedStates).map(state -> new BlockInfo(state, null)).toArray(BlockInfo[]::new);
    }
}
