package net.koraxe.tutorialmod.block;

import net.koraxe.tutorialmod.TutorialMod;
import net.koraxe.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
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
                    new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of()
                            .strength(3f, 8f)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()
                            .ignitedByLava()
                            .lightLevel(p_152686_ -> 3))
    );

    public static final DeferredBlock<Block> ALEXANDRITE_DEEPSLATE_ORE = registerBlock(
            "alexandrite_deepslate_ore", () ->
                    new DropExperienceBlock(UniformInt.of(2,5),
                    BlockBehaviour.Properties.of()
                            .strength(3.5f, 10f)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
                            .ignitedByLava()
                            .lightLevel(p_152686_ -> 5))
    );

    public static final DeferredBlock<Block> ALEXANDRITE_DEEPSLATE_NUGGET_ORE = registerBlock(
            "alexandrite_deepslate_nugget_ore", () ->
                    new DropExperienceBlock(UniformInt.of(2,5),
                    BlockBehaviour.Properties.of()
                            .strength(3.5f, 10f)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
                            .ignitedByLava()
                            .lightLevel(p_152686_ -> 3))
    );

    public static final DeferredBlock<Block> ALEXANDRITE_NUGGET_ORE = registerBlock(
            "alexandrite_nugget_ore", () ->
                    new DropExperienceBlock(UniformInt.of(2,5),
                    BlockBehaviour.Properties.of()
                            .strength(3.5f, 10f)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
                            .ignitedByLava()
                            .lightLevel(p_152686_ -> 3))
    );

    public static final DeferredBlock<Block> ALEXANDRITE_BLOCK = registerBlock(
            "alexandrite_block", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(4f, 20f)
                            .sound(SoundType.AMETHYST)
                            .requiresCorrectToolForDrops()
                            .ignitedByLava()
                            .lightLevel(p_152686_ -> 10))
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
