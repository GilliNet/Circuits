package org.gillinet.circuits.blocks;
import org.gillinet.circuits.Circuits;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "circuits" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Circuits.MODID);

    // Creates all blocks for the mod and registers them with the BLOCKS DeferredRegister
    public static final RegistryObject<Block> AND_GATE_BLOCK = BLOCKS.register("and_gate_block", () -> new ANDGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> OR_GATE_BLOCK = BLOCKS.register("or_gate_block", () -> new ORGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> XOR_GATE_BLOCK = BLOCKS.register("xor_gate_block", () -> new XORGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> INVERTER_GATE_BLOCK = BLOCKS.register("inverter_gate_block", () -> new InverterGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> NOR_LATCH_BLOCK = BLOCKS.register("nor_latch_block", () -> new NORLatch(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new TestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));


    // Function to register all blocks
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
