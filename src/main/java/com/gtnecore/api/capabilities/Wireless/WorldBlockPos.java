package com.gtnecore.api.capabilities.Wireless;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public class WorldBlockPos {

    private final int dimention;
    private final BlockPos pos;

    public WorldBlockPos(int dimention, BlockPos pos) {
        this.dimention = dimention;
        this.pos = pos;
    }

    // NBTからのデシリアライズ
    public static WorldBlockPos readFromNBT(NBTTagCompound data) {
        return new WorldBlockPos(
                data.getInteger("dim"),
                new BlockPos(
                        data.getInteger("x"),
                        data.getInteger("y"),
                        data.getInteger("z")));
    }

    // NBTのシリアライズ
    public NBTTagCompound writeToNBT() {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("dim", dimention);
        data.setInteger("x", pos.getX());
        data.setInteger("y", pos.getY());
        data.setInteger("z", pos.getZ());

        return data;
    }

    // 座標取得
    public int getDimention() {
        return dimention;
    }

    public BlockPos getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;

        WorldBlockPos that = (WorldBlockPos) object;

        return dimention == that.dimention &&
                pos.getX() == that.pos.getX() &&
                pos.getY() == that.pos.getY() &&
                pos.getZ() == that.pos.getZ();
    }

    @Override
    public int hashCode() {
        return 31 * dimention + pos.hashCode();
        // ここでの31はintでありhash値の再計算に用いる定数である
        // Vec3iを参照
    }
}
