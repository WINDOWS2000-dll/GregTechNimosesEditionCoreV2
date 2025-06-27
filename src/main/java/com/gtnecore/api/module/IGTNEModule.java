package com.gtnecore.api.module;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public interface IGTNEModule {

    /**
     * What other modules this module depends on.
     * <p>
     * e.g. {@code new ResourceLocation("gtnecore", "foo_module")} represents a dependency on the module
     * "foo_module" in the container "gtnecore"
     */
    @NotNull
    default Set<ResourceLocation> getDependencyUids() {
        return Collections.emptySet();
    }

    default void construction(@NotNull FMLConstructionEvent event) {}

    default void preInit(@NotNull FMLPreInitializationEvent event) {}

    default void init(@NotNull FMLInitializationEvent event) {}

    default void postInit(@NotNull FMLPostInitializationEvent event) {}

    default void loadComplete(@NotNull FMLLoadCompleteEvent event) {}

    default void serverAboutToStart(@NotNull FMLServerAboutToStartEvent event) {}

    default void serverStarting(@NotNull FMLServerStartingEvent event) {}

    default void serverStarted(@NotNull FMLServerStartedEvent event) {}

    default void serverStopping(@NotNull FMLServerStoppingEvent event) {}

    default void serverStopped(@NotNull FMLServerStoppedEvent event) {}

    default void registerItems(RegistryEvent.Register<Item> event) {}

    default void registerBlocks(RegistryEvent.Register<Block> event) {}

    default void registerRecipesHighest(RegistryEvent.Register<IRecipe> event) {}

    default void registerRecipesHigh(RegistryEvent.Register<IRecipe> event) {}

    default void registerRecipesNormal(RegistryEvent.Register<IRecipe> event) {}

    default void registerRecipesLow(RegistryEvent.Register<IRecipe> event) {}

    default void registerRecipesLowest(RegistryEvent.Register<IRecipe> event) {}

    /**
     * Register packets using GTNEcore's packet handling API here.
     */
    default void registerPackets() {}

    /**
     * The class itself gets subscribed, instead of a class instance, so event handlers <strong>must</strong> be
     * {@code static}.
     *
     * @return A list of classes to subscribe to the Forge Event Bus,
     *         {@link net.minecraftforge.common.MinecraftForge#EVENT_BUS}.
     */
    default @NotNull List<Class<?>> getEventBusSubscribers() {
        return Collections.emptyList();
    }

    /**
     * The class itself gets subscribed, instead of a class instance, so event handlers <strong>must</strong> be
     * {@code static}.
     *
     * @return A list of classes to subscribe to the Forge Terrain Gen Bus,
     *         {@link net.minecraftforge.common.MinecraftForge#TERRAIN_GEN_BUS}.
     */
    default @NotNull List<Class<?>> getTerrainGenBusSubscribers() {
        return Collections.emptyList();
    }

    /**
     * The class itself gets subscribed, instead of a class instance, so event handlers <strong>must</strong> be
     * {@code static}.
     *
     * @return A list of classes to subscribe to the Forge Ore Gen Bus,
     *         {@link net.minecraftforge.common.MinecraftForge#ORE_GEN_BUS}.
     */
    default @NotNull List<Class<?>> getOreGenBusSubscribers() {
        return Collections.emptyList();
    }

    /**
     * @param message the message to process
     * @return if the message was processed, stopping all other modules from processing it
     */
    default boolean processIMC(@NotNull FMLInterModComms.IMCMessage message) {
        return false;
    }

    /**
     * @return A logger to use for this module.
     */
    @NotNull
    Logger getLogger();
}
