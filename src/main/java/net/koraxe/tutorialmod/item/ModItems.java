package net.koraxe.tutorialmod.item;

import net.koraxe.tutorialmod.TutorialMod;
import net.minecraft.references.Items;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALEXANDRITE_INGOT = ITEMS.register("alexandrite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALEXANDRITE_NUGGET = ITEMS.register("alexandrite_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}