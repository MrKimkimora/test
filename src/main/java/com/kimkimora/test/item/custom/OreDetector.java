package com.kimkimora.test.item.custom;

import com.kimkimora.test.Test;
import com.kimkimora.test.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreDetector extends Item {
    public OreDetector(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){

        /*
            Сканируем до бедрока блоки под блоком, на который мы нажали. Проверяем наличие руды.

         */

        if(!context.getWorld().isClient() && context.getPlayer() != null) {    // Строчка, которую я не могу понять
            BlockPos clickPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= clickPos.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(clickPos.down(i));

                if(isValuableBlock(state)){
                    outputValuable(clickPos.down(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.translatable("message."+Test.MOD_ID+".ore_detector.not_found"), false);
            }
        }
        if(context.getPlayer() != null) {
            context.getStack().damage(1, context.getPlayer(),
                    playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        }
        return ActionResult.SUCCESS;
    }

    private void outputValuable(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.translatable(block.asItem().getTranslationKey())
                .append(Text.translatable("message."+ Test.MOD_ID+".ore_detector.found")), false);
    }

    private boolean isValuableBlock(BlockState state){  // Говнокод п*здец, Руслан, помоги.
        return state.isOf(ModBlocks.TIN_ORE) || state.isOf(ModBlocks.TOPAZ_ORE)
                || state.isOf(Blocks.COPPER_ORE) || state.isOf(Blocks.IRON_ORE)
                || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DIAMOND_ORE)
                || state.isOf(Blocks.LAPIS_ORE) || state.isOf(Blocks.REDSTONE_ORE)
                || state.isOf(Blocks.COAL_ORE) || state.isOf(Blocks.EMERALD_ORE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip."+Test.MOD_ID+".ore_detector").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
