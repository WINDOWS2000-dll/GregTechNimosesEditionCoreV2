package com.gtnecore.common.metatileentities.multi.spaceelevator.modules;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import gregtech.core.sound.GTSoundEvents;

import com.gtnecore.client.renderer.texture.GTNECoreTextures;
import com.gtnecore.common.metatileentities.multi.spaceelevator.MetaTileEntityModuleRecipeBase;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;

public class MetaTileEntityAssemblerModule extends MetaTileEntityModuleRecipeBase {

    public MetaTileEntityAssemblerModule(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, int tier,
                                         int moduleTier, int minMotorTier) {
        super(metaTileEntityId, recipeMap, tier, moduleTier, minMotorTier);
    }

    @Override
    public void initializeAbilities() {
        this.inputFluidInventory = new FluidTankList(false, getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.inputInventory = new ItemHandlerList(getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.outputInventory = new ItemHandlerList(getAbilities(MultiblockAbility.EXPORT_ITEMS));
    }

    @Override
    protected TraceabilityPredicate abilities() {
        return abilities(MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.IMPORT_FLUIDS,
                MultiblockAbility.EXPORT_ITEMS);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityAssemblerModule(this.metaTileEntityId, this.recipeMap, this.tier, this.moduleTier,
                this.minMotorTier);
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        for (EnumFacing renderSide : EnumFacing.HORIZONTALS) {
            if (renderSide == getFrontFacing()) {
                getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(),
                        this.isActive(),
                        true);
            } else {
                GTNECoreTextures.ASSEMBLER_MODULE_OVERLAY.renderSided(renderSide, renderState, translation, pipeline);
            }
        }
    }
}
