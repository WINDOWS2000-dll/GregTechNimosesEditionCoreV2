package com.gtnecore.api.blocks;

import net.minecraft.util.IStringSerializable;

public interface ITierd extends IStringSerializable {

    default Object getInfo() {
        return null;
    }

    default Object getTier() {
        return this.getName();
    }
}
