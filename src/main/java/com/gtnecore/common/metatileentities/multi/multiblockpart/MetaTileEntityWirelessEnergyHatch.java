package com.gtnecore.common.metatileentities.multi.multiblockpart;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.AbilityInstances;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;

import com.gtnecore.api.capabilities.Wireless.WirelessEUNetworkDataBase;
import com.gtnecore.api.capabilities.Wireless.WirelessEUNetworkNode;
import com.gtnecore.api.capabilities.impl.EnergyContainerWireless;
import com.gtnecore.client.renderer.texture.GTNECoreTextures;

import java.math.BigInteger;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;

public class MetaTileEntityWirelessEnergyHatch extends MetaTileEntityMultiblockPart
                                               implements IMultiblockAbilityPart<IEnergyContainer> {

    private final int amperage;

    private final boolean isExport;

    private final EnergyContainerWireless energyContainer;

    public int WirelessID = -1;

    private BigInteger lastEnergy = BigInteger.ZERO;

    private final long lastUpdateTime = 0;

    public MetaTileEntityWirelessEnergyHatch(ResourceLocation metaTileEntityId, int tier,
                                             int amperage, boolean isExport) {
        super(metaTileEntityId, tier);
        this.isExport = isExport;
        this.amperage = amperage;
        energyContainer = new EnergyContainerWireless(this, isExport, GTValues.V[tier], this.amperage);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityWirelessEnergyHatch(this.metaTileEntityId, this.getTier(), this.amperage,
                this.isExport);
    }

    public void setCurrentWirelessID(int id) {
        this.WirelessID = Math.min(Math.max(this.WirelessID + id, 1), (int) Math.pow((getTier() + 1), 2));
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 360, 240);

        builder.image(3, 4, 186, 214, GuiTextures.DISPLAY);

        var scroll = new ScrollableListWidget(0, 6, 188, 202);
        scroll.addWidget((new AdvancedTextWidget(6, 2, this::addNetworksDisplayText, 1677215)));
        builder.widget(scroll);

        builder.bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT, 192, 160);

        builder.widget(new IncrementButtonWidget(4, 219, 80, 18, 1, 4, 16, 64, this::setCurrentWirelessID)
                .setDefaultTooltip()
                .setShouldClientCallback(false));

        builder.widget(new IncrementButtonWidget(84, 219, 80, 18, -1, -4, -16, -64, this::setCurrentWirelessID)
                .setDefaultTooltip()
                .setShouldClientCallback(false));

        builder.image(164, 220, 24, 16, GuiTextures.DISPLAY);

        builder.widget(new TextFieldWidget2(170, 224, 20, 18, this::getValue, this::setValue).setMaxLength(3)
                .setAllowedChars(TextFieldWidget2.WHOLE_NUMS));

        builder.image(190, 4, 164, 154, GuiTextures.DISPLAY);

        builder.dynamicLabel(194, 10, () -> "Wireless Energy Channel Controll System", 0xFFFFFF);

        builder.widget((new AdvancedTextWidget(194, 22, this::addDisplayText, 1677215)).setMaxWidthLimit(162));

        return builder.build(this.getHolder(), entityPlayer);
    }

    private String getValue() {
        return String.valueOf(WirelessID);
    }

    private void setValue(String value) {
        try {
            this.WirelessID = Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            this.WirelessID = 0;
        }
    }

    protected void addDisplayText(List<ITextComponent> textList) {
        textList.add(new TextComponentString("Accessing to...>>ID: " + WirelessID + "Energy Network"));
        if (this.getOwner() != null) {
            WirelessEUNetworkDataBase dataBase = WirelessEUNetworkDataBase.get(getWorld());
            WirelessEUNetworkNode node = dataBase.getNetWork(WirelessID);
            if (node != null) {
                textList.add(new TextComponentString("Network Name:" + node.getNetworkName()));
                textList.add(new TextComponentString("Current EU Stored: " +
                        formatScientificNotation(node.getEnergy()) + " EU (" +
                        formatEnergyValue(node.getEnergy()) + ")"));

                BigInteger energyDiff = node.getEnergy().subtract(lastEnergy);
                if (!energyDiff.equals(BigInteger.ZERO)) {
                    String change = energyDiff.compareTo(BigInteger.ZERO) > 0 ?
                            "+" + formatEnergyValue(energyDiff) :
                            formatEnergyValue(energyDiff);
                    textList.add(new TextComponentString("Energy Diff: " + change));
                }

                lastEnergy = node.getEnergy();

            }
        }
    }

    private String formatScientificNotation(BigInteger energy) {
        double value = energy.doubleValue();
        return String.format("%.3E", value);
    }

    private String formatEnergyValue(BigInteger energy) {
        if (energy.compareTo(BigInteger.valueOf(1_000_000_000L)) >= 0) {
            return energy.divide(BigInteger.valueOf(1_000_000_000)) + " GEU";
        } else if (energy.compareTo(BigInteger.valueOf(1_000_000L)) >= 0) {
            return energy.divide(BigInteger.valueOf(1_000_000L)) + " MEU";
        } else if (energy.compareTo(BigInteger.valueOf(1_000L)) >= 0) {
            return energy.divide(BigInteger.valueOf(1_000L)) + " KEU";
        } else {
            return energy + " EU";
        }
    }

    protected void addNetworksDisplayText(List<ITextComponent> textList) {
        if (this.getOwner() != null) {
            WirelessEUNetworkDataBase dataBase = WirelessEUNetworkDataBase.get(getWorld());
            dataBase.getNetworks().keySet().forEach(x -> {
                var node = dataBase.getNetWork(x);
                if (node != null) {
                    textList.add(new TextComponentString("--------------------"));
                    textList.add(new TextComponentString(">>ID:" + node.getNetworkID()));
                    textList.add(new TextComponentString(this.getOwner().toString()));
                    textList.add(new TextComponentString("NetWork Name:" + node.getNetworkName()));
                    textList.add(new TextComponentString("Current EU Stored:" + node.getEnergy().toString()));
                }
            });
        }
    }

    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()) {
            getOverlay().renderSided(getFrontFacing(), renderState, translation, pipeline);
        }
    }

    @SideOnly(Side.CLIENT)
    private SimpleOverlayRenderer getOverlay() {
        if (amperage == 2) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY;
        } else if (amperage == 4) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_4x;
        } else if (amperage == 16) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_16x;
        } else if (amperage == 64) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_64x;
        } else if (amperage == 256) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_256x;
        } else if (amperage == 1024) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_1024x;
        } else if (amperage == 4096) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_4096x;
        } else if (amperage == 16384) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_16384x;
        } else if (amperage == 65536) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_65536x;
        } else if (amperage == 262144) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_262144x;
        } else if (amperage == 1048576) {
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY_1048576x;
        } else
            return GTNECoreTextures.MULTIPART_WIRELESS_ENERGY;
    }

    @Override
    public MultiblockAbility<IEnergyContainer> getAbility() {
        return isExport ? MultiblockAbility.OUTPUT_ENERGY : MultiblockAbility.INPUT_ENERGY;
    }

    @Override
    public void registerAbilities(@NotNull AbilityInstances abilityInstances) {
        abilityInstances.add(energyContainer);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("wirelessid", this.WirelessID);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.WirelessID = data.getInteger("wirelessid");
    }

    @Override
    public void addInformation(ItemStack stack,
                               World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        String tierName = GTValues.VNF[this.getTier()];

        tooltip.add(I18n.format("gtnecore.machine.wireless_energy_hatch.tooltip.1"));
        tooltip.add(I18n.format("gtnecore.machine.wireless_energy_hatch.tooltip.2"));

        if (this.isExport) {
            tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_out", this.energyContainer.getOutputVoltage(),
                    tierName));
            tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_out_till",
                    this.energyContainer.getOutputAmperage()));
        } else {
            tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_in", this.energyContainer.getInputVoltage(),
                    tierName));
            tooltip.add(
                    I18n.format("gregtech.universal.tooltip.amperage_in_till", this.energyContainer.getInputVoltage()));
        }

        tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", this,
                energyContainer.getEnergyCapacity()));
        tooltip.add(I18n.format("gregtech.universal.enabled"));

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(I18n.format("gtnecore.machine.wireless_energy_hatch.tooltip.shift"));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }
}
