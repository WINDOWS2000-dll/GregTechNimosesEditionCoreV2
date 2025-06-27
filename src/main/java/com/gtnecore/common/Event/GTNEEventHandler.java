package com.gtnecore.common.Event;

import static net.minecraft.util.text.TextFormatting.*;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import gregtech.api.unification.material.event.MaterialEvent;

import com.gtnecore.GTNECoreValues;
import com.gtnecore.api.unification.material.GTNEMaterials;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = GTNECoreValues.MODID)
public class GTNEEventHandler {

    public GTNEEventHandler() {}

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterialHigh(MaterialEvent event) {
        GTNEMaterials.registerMaterialHigh();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerMaterialLow(MaterialEvent event) {
        GTNEMaterials.registerMaterialLow();
    }

    public static class PlayerLoginEventHandler {

        private static final String[] lines = {
                GOLD + "============================================",
                BOLD + "Welcome to GregTechNimosesEdition!!!!",
                GRAY + "The current game is" + RED + " beta version",
                GOLD + "============================================"
        };

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
            Objects.requireNonNull(event.player);
            for (String line : lines) {
                event.player.sendMessage(new TextComponentString(line));
            }
        }
    }
}
