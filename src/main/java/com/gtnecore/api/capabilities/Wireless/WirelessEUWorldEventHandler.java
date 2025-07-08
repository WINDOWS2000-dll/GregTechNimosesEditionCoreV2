package com.gtnecore.api.capabilities.Wireless;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.gtnecore.api.util.GTNELogger;

public class WirelessEUWorldEventHandler {

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (!event.getWorld().isRemote && event.getWorld().provider.getDimension() == 0) {
            WirelessEUNetworkDataBase.get(event.getWorld());
            GTNELogger.logger.info("[Network] Dimention " +
                    event.getWorld().provider.getDimension() +
                    " Loading Network Data...");
        }
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END &&
                !event.world.isRemote &&
                event.world.provider.getDimension() == 0) {
            if (event.world.getTotalWorldTime() % 600 == 0) {
                WirelessEUNetworkDataBase dataBase = WirelessEUNetworkDataBase.get(event.world);
                if (dataBase.isDirty()) {
                    dataBase.markDirty();
                }
            }
        }
    }
}
