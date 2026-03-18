package net.koraxe.tutorialmod.item.custom;

import net.koraxe.tutorialmod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;


public class ALEXANDRITE_CHISEL extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK,
                    Blocks.DIAMOND_BLOCK, ModBlocks.ALEXANDRITE_BLOCK.get()
            );

    public ALEXANDRITE_CHISEL(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        Block blockclicked = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(blockclicked)){
            //(!level.isClientSide()) checks only if the level is sever side
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(blockclicked).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1,
                        ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

}
