package com.gtnecore.api.capabilities.impl;

import com.gtnecore.api.capabilities.Wireless.WirelessEUNetworkDataBase;
import com.gtnecore.api.capabilities.Wireless.WirelessEUNetworkManager;
import com.gtnecore.api.capabilities.Wireless.WirelessEUNetworkNode;
import com.gtnecore.api.capabilities.Wireless.WorldBlockPos;
import com.gtnecore.common.metatileentities.multi.multiblockpart.MetaTileEntityWirelessEnergyHatch;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;

import java.math.BigInteger;

public class EnergyContainerWireless extends EnergyContainerHandler {

    public EnergyContainerWireless(MetaTileEntity tileEntity, boolean isExport, long voltage, long amperage) {
        this(tileEntity, voltage * amperage * 320, isExport ? 0 : voltage, amperage, isExport ? voltage : 0, amperage);
    }

    public EnergyContainerWireless(MetaTileEntity tileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage, long maxOutputVoltage, long maxOutputAmperage) {
        super(tileEntity, maxCapacity, maxInputVoltage, maxInputAmperage, maxOutputVoltage, maxOutputAmperage);
    }

    @Override
    public void update() {
        super.update();
        if (!this.metaTileEntity.getWorld().isRemote) {
            var world = metaTileEntity.getWorld();
            if (this.metaTileEntity.getOwner() != null) {
                int id = ((MetaTileEntityWirelessEnergyHatch)metaTileEntity).WirelessID;
                if (id == -1 || id == 0)
                    return;
                //NET WORK SECURE ACCESSOR
                //DO NOT CHANGE THIS METHOD
                WirelessEUNetworkDataBase dataBase = WirelessEUNetworkDataBase.get(world);
                WirelessEUNetworkNode node = dataBase.getNetWork(((MetaTileEntityWirelessEnergyHatch)metaTileEntity).WirelessID);

                if (node == null) {
                    WirelessEUNetworkManager.INSTANCE.createNetwork(world, metaTileEntity.getOwner(), "wirelessNetwork");
                    dataBase = WirelessEUNetworkDataBase.get(world);
                    node = dataBase.getNetWork(((MetaTileEntityWirelessEnergyHatch)metaTileEntity).WirelessID);
                }
                {
                    var machine = new WorldBlockPos(metaTileEntity.getWorld().provider.getDimension(),metaTileEntity.getPos());
                    if (!node.machines.contains(machine))
                    {
                        node.machines.add(machine);
                        WirelessEUNetworkDataBase finalDataBase = dataBase;
                        WirelessEUNetworkNode finalNode = node;
                        dataBase.getNetworks().keySet().forEach(x -> {
                            var del = finalDataBase.getNetWork(x);
                            if (del.getNetworkID() != finalNode.getNetworkID())
                            {
                                del.machines.remove(machine);
                            }
                        });
                    }
                }
                //add Energy Function
                if (this.getInputVoltage() == 0)
                {
                    if (this.energyStored > 0)
                    {
                        var b1 = BigInteger.valueOf(this.energyStored);
                        if (node != null)
                        {
                            long added = WirelessEUNetworkManager.INSTANCE.transferEnergy(world, node.getNetworkID(),b1);
                            this.removeEnergy(added);
                        }
                    }
                }
                //If Export
                else
                {
                    long needEnergy = this.getEnergyCapacity() - this.getEnergyStored();
                    if (node != null)
                    {
                        long added = WirelessEUNetworkManager.INSTANCE.transferEnergy(world, node.getNetworkID(), BigInteger.valueOf(-needEnergy));
                        this.addEnergy(Math.abs(added));
                    }
                }

            }
        }
    }

    @Override
    public long getEnergyCanBeInserted() {
        return 0;
    }

}