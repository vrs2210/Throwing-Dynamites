package boom.throwables.Initializers;

import boom.throwables.ModInitialize;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.TntBlock;
import net.minecraft.item.BlockItem;

public class BlockInitialize implements BlockRegistryContainer {
    public static final Block BLOCK_OF_DYNAMITE = new TntBlock(FabricBlockSettings.of(Material.TNT));

    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
        return new BlockItem(block, new OwoItemSettings().group(ModInitialize.GROUP));
    }
}
