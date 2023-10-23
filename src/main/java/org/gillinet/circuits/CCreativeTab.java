package org.gillinet.circuits;

import org.gillinet.circuits.items.CItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Circuits.MODID);

    // Creates a creative tab with the id "circuits:circuits_tab" for the circuits mod, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> CIRCUITS_TAB = CREATIVE_MODE_TABS.register("circuits_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> CItems.AND_GATE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                 // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(CItems.AND_GATE_ITEM.get());
                output.accept(CItems.OR_GATE_ITEM.get());
                output.accept(CItems.XOR_GATE_ITEM.get());
                output.accept(CItems.INVERTER_GATE_ITEM.get());
                output.accept(CItems.TEST_BLOCK_ITEM.get());
                output.accept(CItems.NOR_LATCH_ITEM.get());
            }).build());

    // Function to register the creative tab
    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
