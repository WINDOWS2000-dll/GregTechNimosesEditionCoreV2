package com.gtnecore.common;

import static com.gtnecore.common.Block.GTNEMetaBlocks.BLOCK_GTNE_WIRE_COIL;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import gregtech.api.block.VariantItemBlock;
import gregtech.common.items.MetaItems;

import com.gtnecore.GTNECoreValues;
import com.gtnecore.api.capabilities.Wireless.WirelessEUWorldEventHandler;
import com.gtnecore.api.util.GTNELogger;
import com.gtnecore.common.Event.GTNEEventHandler;

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
        MinecraftForge.EVENT_BUS.register(new GTNEEventHandler.PlayerLoginEventHandler());
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
        GTNELogger.logger.info("Registering Blocks...");
        IForgeRegistry<Block> registry = blockRegisterEvent.getRegistry();
        registry.register(BLOCK_GTNE_WIRE_COIL);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> itemRegisterEvent) {
        GTNELogger.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = itemRegisterEvent.getRegistry();

        registry.register(createItemBlock(BLOCK_GTNE_WIRE_COIL, VariantItemBlock::new));
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        ResourceLocation registryName = block.getRegistryName();
        if (registryName == null) {
            throw new IllegalArgumentException("Block " + block.getTranslationKey() + " has no registry name.");
        }
        itemBlock.setRegistryName(registryName);
        return itemBlock;
    }

    @SubscribeEvent
    public static void onWorldLoadEvent(WorldEvent.Load onWorldLoadEvent) {
        /**/
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> recipeRegisterEvent) {
        /**/
    }
}
