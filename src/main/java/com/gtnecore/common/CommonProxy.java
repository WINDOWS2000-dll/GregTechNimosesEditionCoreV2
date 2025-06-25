package com.gtnecore.common;

import com.gtnecore.api.capabilities.Wireless.WirelessEUWorldEventHandler;
import gregtech.common.items.MetaItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.gtnecore.GTNECoreValues;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GTNECoreValues.MODID)
public class CommonProxy {

    public static final CreativeTabs GTNECore = new CreativeTabs("gtnecore") {
        @Override
        public ItemStack createIcon() {
            return MetaItems.NANO_MAINFRAME_LUV.getStackForm();
        }
    };

    public void preInit(FMLPreInitializationEvent preInitEvent) {
        /**/
    }

    public void preLoad() {
        /**/
    }

    public void init(FMLInitializationEvent initEvent) {
        /**/
    }

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new WirelessEUWorldEventHandler());
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

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> recipeRegisterEvent) {
        /**/
    }
}
