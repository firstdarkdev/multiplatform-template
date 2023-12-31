package com.example.examplemod;

import com.example.examplemod.platform.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ExampleMod {

    public static void initialize() {
        ModConstants.LOGGER.info("Hello from Common init on {}! we are currently in a {} environment!", IPlatformHelper.INSTANCE.getPlatformName(), IPlatformHelper.INSTANCE.isDevelopmentEnvironment() ? "development" : "production");
        ModConstants.LOGGER.info("Diamond Item >> {}", BuiltInRegistries.ITEM.getKey(Items.DIAMOND));
    }

    // This method serves as a hook to modify item tooltips. The vanilla game
    // has no mechanism to load tooltip listeners so this must be registered
    // by a mod loader like Forge or Fabric.
    public static void onItemTooltip(ItemStack stack, TooltipFlag context, List<Component> tooltip) {
        if (!stack.isEmpty()) {
            final FoodProperties food = stack.getItem().getFoodProperties();

            if (food != null) {
                tooltip.add(Component.literal("Nutrition: " + food.getNutrition()));
                tooltip.add(Component.literal("Saturation: " + food.getSaturationModifier()));
            }
        }
    }

}
