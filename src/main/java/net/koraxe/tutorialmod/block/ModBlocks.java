package net.koraxe.tutorialmod.block;

import net.koraxe.tutorialmod.TutorialMod;
import net.koraxe.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TutorialMod.MOD_ID);


    public static final DeferredBlock<Block> ALEXANDRITE_ORE = registerBlock(
            "alexandrite_ore", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(4f, 300f)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()
                            .ignitedByLava()
                            .destroyTime(10f))
    );

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> Block){
        ModItems.ITEMS.register(name, () -> new BlockItem(Block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
