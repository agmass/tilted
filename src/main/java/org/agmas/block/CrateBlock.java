package org.agmas.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import org.agmas.ModItems;

import java.util.List;
import java.util.Random;

public class CrateBlock extends Block {
    public CrateBlock(Properties properties) {
        super(properties);
    }

    List<Item> commonDrops = List.of(
            ModItems.CARNIVORA_SMITHING_TEMPLATE,
            ModItems.JUNKYARD_SMITHING_TEMPLATE,
            ModItems.GOLDENEYE_SMITHING_TEMPLATE,
            ModItems.CARRION_SMITHING_TEMPLATE,
            ModItems.HISTORY_SMITHING_TEMPLATE,
            ModItems.MONEYTALKS_SMITHING_TEMPLATE,
            ModItems.NROSES_SMITHING_TEMPLATE,
            ModItems.REVENANT_SMITHING_TEMPLATE,
            ModItems.RIPPER_SMITHING_TEMPLATE,
            ModItems.SHIPPED_SMITHING_TEMPLATE,
            ModItems.TEMPERED_SMITHING_TEMPLATE,
            ModItems.TRAINING_SMITHING_TEMPLATE,
            ModItems.SUNSET_SMITHING_TEMPLATE,
            ModItems.TIDE_SMITHING_TEMPLATE,
            ModItems.FLAMBE_SMITHING_TEMPLATE
    );
    List<Item> uncommonDrops =
            List.of(ModItems.MINED_SMITHING_TEMPLATE,
                    ModItems.HOLIDAY_SMITHING_TEMPLATE,
                    ModItems.HYPERDEATH_SMITHING_TEMPLATE,
                    ModItems.SPECIALOPS_SMITHING_TEMPLATE,
                    ModItems.VIRTUE_SMITHING_TEMPLATE,
                    ModItems.RUNESCAPE_SMITHING_TEMPLATE,
                    ModItems.HAMMER_SMITHING_TEMPLATE,
                    ModItems.KEBAB_SMITHING_TEMPLATE,
                    ModItems.WILLPOWER_SMITHING_TEMPLATE,
                    ModItems.WRATH_SMITHING_TEMPLATE,
                    ModItems.AQUARIUS_SMITHING_TEMPLATE,
                    ModItems.CHERRY_SMITHING_TEMPLATE,
                    ModItems.CLOCKWORK_SMITHING_TEMPLATE,
                    ModItems.COTTONCANDY_SMITHING_TEMPLATE,
                    ModItems.SENTINAL_SMITHING_TEMPLATE);
    List<Item> rareDrops =
            List.of(ModItems.NOSTALGIA_SMITHING_TEMPLATE,
                    ModItems.ICE_SMITHING_TEMPLATE,
                    ModItems.SHRIMP_SMITHING_TEMPLATE,
                    ModItems.MISSING_TEXTURE_SMITHING_TEMPLATE,
                    ModItems.GUI_SMITHING_TEMPLATE);
    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        Random random = new Random();
        int roll = random.nextInt(11);
        if (roll == 0) {
            return List.of(rareDrops.get(random.nextInt(rareDrops.size())).getDefaultInstance());
        } else if (roll < 4) {
            return List.of(uncommonDrops.get(random.nextInt(uncommonDrops.size())).getDefaultInstance());
        } else {
            return List.of(commonDrops.get(random.nextInt(commonDrops.size())).getDefaultInstance());
        }
    }
}
