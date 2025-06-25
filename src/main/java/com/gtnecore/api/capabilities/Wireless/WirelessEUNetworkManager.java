package com.gtnecore.api.capabilities.Wireless;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.FMLServerHandler;

import java.math.BigInteger;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class WirelessEUNetworkManager {

    //Singleton Model
    public static final WirelessEUNetworkManager INSTANCE = new WirelessEUNetworkManager();
    private final ConcurrentHashMap<Integer, Object> networkLocks = new ConcurrentHashMap<>();

    //Get Current Network Model
    private WirelessEUNetworkDataBase getDataBase(World world) {
        return WirelessEUNetworkDataBase.get(world);
    }

    //Create Network
    public WirelessEUNetworkNode createNetwork(World world, UUID owner, String name) {
        WirelessEUNetworkDataBase dataBase = WirelessEUNetworkDataBase.get(world);
        int newID = generateUniqueID(dataBase);
        WirelessEUNetworkNode node = new WirelessEUNetworkNode(owner, newID, name);
        dataBase.addNetWork(node);
        return node;
    }

    public long transferEnergy(World world, int networkID, BigInteger amount) {
        if (amount.equals(BigInteger.ZERO))
            return 0L;
        Object lock = networkLocks.computeIfAbsent(networkID, k -> new Object());
        synchronized (lock) {
            WirelessEUNetworkDataBase dataBase = WirelessEUNetworkDataBase.get(world);
            WirelessEUNetworkNode node = dataBase.getNetworks().get(networkID);
            if (node == null)
                return 0L;

            BigInteger actual = node.modifyEnergy(amount);
            if (!actual.equals(BigInteger.ZERO)) {
                dataBase.markDirty();
            }

            return actual.longValue();
        }
    }

    private int generateUniqueID(WirelessEUNetworkDataBase dataBase) {
        return dataBase.getNetworks().keySet().stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0) + 1;
    }

    //easier access to Network Manager
    public BigInteger getEnergy(World world, int networkID) {
        WirelessEUNetworkNode node = WirelessEUNetworkDataBase.get(world).getNetWork(networkID);
        return node != null ? node.getEnergy() : BigInteger.ZERO;
    }

    public boolean hasEnoughEnergy(World world, int networkID, BigInteger amount) {
        return getEnergy(world, networkID).compareTo(amount) >= 0;
    }

    public static World getWorldByDimention(int dimention) {
        MinecraftServer server = FMLServerHandler.instance().getServer();
        if (server != null) {
            return server.getWorld(dimention);
        }
        return null;
    }

}
