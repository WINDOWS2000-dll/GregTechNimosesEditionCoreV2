package com.gtnecore.modules;

import net.minecraft.util.ResourceLocation;

import com.gtnecore.api.module.IGTNEModule;
import com.gtnecore.api.util.GTNEUtility;

import java.util.Collections;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

public abstract class BaseGTNEModule implements IGTNEModule {

    @NotNull
    @Override
    public Set<ResourceLocation> getDependencyUids() {
        return Collections.singleton(GTNEUtility.gtneID(GTNEModules.MODULE_CORE));
    }
}
