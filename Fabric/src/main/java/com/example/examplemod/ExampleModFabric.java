package com.example.examplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class ExampleModFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstants.LOGGER.info("Hello Fabric!");
        ExampleMod.initialize();
        ItemTooltipCallback.EVENT.register(ExampleMod::onItemTooltip);
    }
}
