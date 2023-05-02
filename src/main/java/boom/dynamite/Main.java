package boom.dynamite;

import boom.dynamite.Util.ItemUtil;
import boom.dynamite.items.throwableDynamite.DynamiteItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static final String MOD_ID = "dynamite";

    public static DynamiteItem Dynamite = new DynamiteItem(false, true, 3.0f, "item.dynamite.dynamite.tooltip");
    public static DynamiteItem HEDynamite = new DynamiteItem(false, true, 6.0f, "item.dynamite.he_dynamite.tooltip");
    public static DynamiteItem ThermiteDynamite = new DynamiteItem(true, true, 2.0f, "item.dynamite.thermite_dynamite.tooltip");

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "dynamite_items"))
        .icon(() -> new ItemStack(Dynamite))
        .build();

    @Override
    public void onInitialize() {
        ItemUtil.registerItem(Dynamite, "dynamite");
        ItemUtil.registerItem(ThermiteDynamite, "thermite_dynamite");
        ItemUtil.registerItem(HEDynamite, "he_dynamite");

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(Dynamite);
            content.add(HEDynamite);
            content.add(ThermiteDynamite);
        });
    }
}