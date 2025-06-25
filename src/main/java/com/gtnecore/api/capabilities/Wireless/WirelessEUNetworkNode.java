package com.gtnecore.api.capabilities.Wireless;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class WirelessEUNetworkNode {

    private final UUID networkownerUUID;

    private final int networkID;

    private String networkName;

    private BigInteger energy;

    private boolean isOpen;

    public List<WorldBlockPos> machines = new ArrayList<>();

    public WirelessEUNetworkNode(UUID networkowner, int id, String name) {
        this.networkownerUUID = networkowner;
        this.networkID = id;
        this.networkName = name;
        this.energy = BigInteger.ZERO;
        this.isOpen = true;
    }

    public UUID getNetworkownerUUID() {
        return networkownerUUID;
    }

    public int getNetworkID(){
        return networkID;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public BigInteger getEnergy() {
        return energy;
    }

    public void setEnergy(BigInteger energy) {
        this.energy = energy;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public synchronized boolean addMachine(World world, BlockPos pos) {
        WorldBlockPos worldBlockPos = new WorldBlockPos(
                world.provider.getDimension(),
                pos
        );
        if (!machines.contains(worldBlockPos)) {
            return machines.add(worldBlockPos);
        }
        return false;
    }

    public synchronized boolean addMachine(WorldBlockPos worldBlockPos) {
        if (!machines.contains(worldBlockPos)) {
            return machines.add(worldBlockPos);
        }
        return false;
    }

    public synchronized List<BlockPos> getMachineInDimention(int dimention) {
        return machines.stream()
                .filter(worldBlockPos -> worldBlockPos.getDimention() == dimention)
                .map(WorldBlockPos::getPos)
                .collect(Collectors.toList());
    }

    public BigInteger modifyEnergy(BigInteger delta) {
        BigInteger original = this.energy;
        BigInteger newValue = original.add(delta);

        if (newValue.compareTo(BigInteger.ZERO) < 0) {
            this.energy = BigInteger.ZERO;
            return original.negate();
        }
        this.energy = newValue;
        return delta;
    }

}
