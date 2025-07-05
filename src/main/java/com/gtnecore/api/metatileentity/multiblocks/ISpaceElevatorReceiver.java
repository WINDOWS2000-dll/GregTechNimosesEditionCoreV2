package com.gtnecore.api.metatileentity.multiblocks;

import org.jetbrains.annotations.Nullable;

public interface ISpaceElevatorReceiver {

    @Nullable
    ISpaceElevatorProvider getSpaceElevator();

    void setSpaceElevator(ISpaceElevatorProvider provider);

    void sentWorkingDisabled();

    void sentWorkingEnabled();

    String getNameForDisplayCount();
}
