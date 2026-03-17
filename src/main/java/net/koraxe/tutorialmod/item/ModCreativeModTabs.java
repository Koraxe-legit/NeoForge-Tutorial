package net.koraxe.tutorialmod.item;

import net.koraxe.tutorialmod.TutorialMod;
import net.koraxe.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TAB.register("alexandrite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creative.tutorialmod.tutorialmod_creative_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE);
                        output.accept(ModItems.ALEXANDRITE_INGOT);
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK);
                        output.accept(ModBlocks.ALEXANDRITE_ORE);
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);

                    }).build());

    //public static final Supplier<CreativeModeTab> ALEXANDRITE_Block_TAB = CREATIVE_MODE_TAB.register("alexandrite_blocks_tab",
      //      () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
        //            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "alexandrite_items_tab"))
          //          .title(Component.translatable("creative.tutorialmod.alexandrite_blocks"))
            //        .displayItems((itemDisplayParameters, output) -> {
              //          output.accept(ModBlocks.ALEXANDRITE_BLOCK);
                //        output.accept(ModBlocks.ALEXANDRITE_ORE);
                  //
                    //}).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
