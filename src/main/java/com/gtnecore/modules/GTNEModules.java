package com.gtnecore.modules;

import com.gtnecore.GTNECoreValues;
import com.gtnecore.api.module.IModuleContainer;

public class GTNEModules implements IModuleContainer {

    public static final String MODULE_CORE = "core";
    public static final String MODULE_TOOLS = "tools";
    public static final String MODULE_INTEGRATION = "integration";

    // Integration Module
    public static final String MODULE_AE2 = "ae2_integration";

    @Override
    public String getID() {
        return GTNECoreValues.MODID;
    }
}
