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
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Circuits.MODID);
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(CBlocks.EXAMPLE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> AND_GATE_ITEM = ITEMS.register("and_gate_item", () -> new BlockItem(CBlocks.AND_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> OR_GATE_ITEM = ITEMS.register("or_gate_item", () -> new BlockItem(CBlocks.OR_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> XOR_GATE_ITEM = ITEMS.register("xor_gate_item", () -> new BlockItem(CBlocks.XOR_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> INVERTER_GATE_ITEM = ITEMS.register("inverter_gate_item", () -> new BlockItem(CBlocks.INVERTER_GATE.get(), new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
