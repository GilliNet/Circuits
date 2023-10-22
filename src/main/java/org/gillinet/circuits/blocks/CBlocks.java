package org.gillinet.circuits.blocks;
import org.gillinet.circuits.Circuits;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Circuits.MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> AND_GATE = BLOCKS.register("and_gate", () -> new ANDGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> OR_GATE = BLOCKS.register("or_gate", () -> new ORGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> XOR_GATE = BLOCKS.register("xor_gate", () -> new XORGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> INVERTER_GATE = BLOCKS.register("inverter_gate", () -> new InverterGate(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new PoweredBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new TestBlock(BlockBehaviour.Properties.copy(Blocks.REPEATER)));


    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
