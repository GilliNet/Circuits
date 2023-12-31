package org.gillinet.circuits.items;

import org.gillinet.circuits.Circuits;
import org.gillinet.circuits.blocks.CBlocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CItems {
    // Create a Deferred Register to hold Items which will all be registered under the "circuits" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Circuits.MODID);
    
    // Creates block items for all mod blocks to be registered with the ITEMS DeferredRegister
    public static final RegistryObject<Item> TEST_BLOCK_ITEM = ITEMS.register("test_block", () -> new BlockItem(CBlocks.TEST_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> AND_GATE_ITEM = ITEMS.register("and_gate_item", () -> new BlockItem(CBlocks.AND_GATE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> OR_GATE_ITEM = ITEMS.register("or_gate_item", () -> new BlockItem(CBlocks.OR_GATE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> XOR_GATE_ITEM = ITEMS.register("xor_gate_item", () -> new BlockItem(CBlocks.XOR_GATE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> INVERTER_GATE_ITEM = ITEMS.register("inverter_gate_item", () -> new BlockItem(CBlocks.INVERTER_GATE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> NOR_LATCH_ITEM = ITEMS.register("nor_latch_item", () -> new BlockItem(CBlocks.NOR_LATCH_BLOCK.get(), new Item.Properties()));

    // Register function to register all items
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
