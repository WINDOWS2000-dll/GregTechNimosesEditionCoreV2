package com.gtnecore.api.capabilities.Wireless;

import java.math.BigInteger;
import java.util.UUID;

public class WirelessEUNetworkNode {

    private final UUID networkownerUUID;

    private final int networkID;

    private String networkName;

    private BigInteger energy;

    private boolean isOpen;

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

    public int getNetworkID() {
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
