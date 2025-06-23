package com.gtnecore.common;

import com.gtnecore.GTNECoreValues;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GTNECoreValues.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent preInitEvent) {
        /**/
    }

    public void preLoad() {
        /**/
    }

    public void init(FMLInitializationEvent initEvent) {
        /**/
    }

    public void postInit(FMLPostInitializationEvent postInitEvent) {
        /**/
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> blockRegisterEvent) {
        /**/
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> itemRegisterEvent) {
        /**/
    }

    @SubscribeEvent
    public static void onWorldLoadEvent(WorldEvent.Load onWorldLoadEvent) {
        /**/
    }

    private static <T extends Block>ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> recipeRegisterEvent) {

    }

}
