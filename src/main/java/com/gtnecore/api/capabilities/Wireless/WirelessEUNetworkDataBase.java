package com.gtnecore.api.capabilities.Wireless;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WirelessEUNetworkDataBase extends WorldSavedData {

    private static final String DATABASE_NAME = "gtnecore_network_data";
    private Map<Integer, WirelessEUNetworkNode> networks = new HashMap<>();

    public WirelessEUNetworkDataBase() {
        super(DATABASE_NAME);
    }

    public WirelessEUNetworkDataBase(String name) {
        super(name);
    }

    //Load NBT Data
    @Override
    public void readFromNBT(NBTTagCompound data) {
        NBTTagList list = data.getTagList("networks", 10);
        for (NBTBase tag : list) {
            NBTTagCompound nodeTag = (NBTTagCompound) tag;
            WirelessEUNetworkNode node = new WirelessEUNetworkNode(
                    UUID.fromString(nodeTag.getString("owner")),
                    nodeTag.getInteger("id"),
                    nodeTag.getString("name")
            );

            node.setEnergy(new BigInteger(nodeTag.getString("energy")));
            node.setOpen(nodeTag.getBoolean("isOpen"));

            NBTTagList machineList = data.getTagList("machines", 10);
            for (NBTBase tagBase : machineList) {
                node.addMachine(WorldBlockPos.readFromNBT((NBTTagCompound) tagBase));
            }

            networks.put(node.getNetworkID(), node);

        }
    }

    //Write to NBT Data
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        NBTTagList list = new NBTTagList();
        for (WirelessEUNetworkNode node : networks.values()) {
            NBTTagCompound nodeTag = new NBTTagCompound();
            nodeTag.setString("owner", node.getNetworkownerUUID().toString());
            nodeTag.setInteger("id", node.getNetworkID());
            nodeTag.setString("name", node.getNetworkName());
            nodeTag.setString("energy", node.getEnergy().toString());
            nodeTag.setBoolean("isOpen", node.isOpen());

            NBTTagList machineList = new NBTTagList();
            for (WorldBlockPos worldBlockPos : node.machines) {
                machineList.appendTag(worldBlockPos.writeToNBT());
            }

            data.setTag("machines", machineList);
            list.appendTag(nodeTag);
        }

        data.setTag("networks", list);
        return data;
    }

    //Data Getter(Thread Safety)
    public Map<Integer, WirelessEUNetworkNode> getNetworks() {
        return Collections.unmodifiableMap(networks);
    }

    //Data Access Method (Direct Access)
    public void addNetWork(WirelessEUNetworkNode node) {
        networks.put(node.getNetworkID(), node);
        markDirty();
    }

    public WirelessEUNetworkNode getNetWork(int id) {
        return networks.get(id);
    }

    public static WirelessEUNetworkDataBase get(World world) {
        MapStorage storage = world.getMapStorage();
        WirelessEUNetworkDataBase instance = (WirelessEUNetworkDataBase) storage.getOrLoadData(WirelessEUNetworkDataBase.class, DATABASE_NAME);
        if (instance == null) {
            instance = new WirelessEUNetworkDataBase();
            storage.setData(DATABASE_NAME, instance);
        }
        return instance;
    }

}
