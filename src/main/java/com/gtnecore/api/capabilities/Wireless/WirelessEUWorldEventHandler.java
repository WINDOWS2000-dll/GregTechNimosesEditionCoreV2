package com.gtnecore.api.capabilities.Wireless;

import com.gtnecore.api.util.GTNELogger;
import gregtech.api.util.GTUtility;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;

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
                dataBase.getNetworks().keySet().forEach(x -> {
                    var net = dataBase.getNetWork(x);
                    if (net != null)
                    {
                        List<WorldBlockPos> pos = new ArrayList<>();
                        for (var machine : net.machines)
                        {
                            if (machine.getDimention() == event.world.provider.getDimension() && event.world.isBlockLoaded(machine.getPos()))
                            {
                                var mte = GTUtility.getMetaTileEntity(event.world, machine.getPos());
                                if (mte == null)
                                {
                                    pos.add(machine);
                                }
                            }
                        }
                        for (var remove : pos)
                        {
                            net.machines.remove(remove);
                        }
                    }
                });
                if (dataBase.isDirty()) {
                    dataBase.markDirty();
                }
            }
        }
    }
}
