package com.gtnecore.api.module;

import net.minecraft.util.ResourceLocation;

import com.gtnecore.api.util.GTNEUtility;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IModuleManager {

    default boolean isModuleEnabled(@NotNull String containerID, @NotNull String moduleID) {
        return isModuleEnabled(new ResourceLocation(containerID, moduleID));
    }

    default boolean isModuleEnabled(@NotNull String moduleID) {
        return isModuleEnabled(GTNEUtility.gtneID(moduleID));
    }

    boolean isModuleEnabled(@NotNull ResourceLocation id);

    void registerContainer(@NotNull IModuleContainer container);

    @Nullable
    IModuleContainer getLoadedContainer();

    @NotNull
    ModuleStage getStage();

    boolean hasPassedStage(@NotNull ModuleStage stage);
}
