package boom.dynamite;

import boom.dynamite.items.throwableDynamite.DynamiteItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static DynamiteItem Dynamite = new DynamiteItem(false, 3.0f);
    public static DynamiteItem HEDynamite = new DynamiteItem(false, 6.0f);
    public static DynamiteItem ThermiteDynamite = new DynamiteItem(true, 2.0f);

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("dynamite", "dynamite_items"))
        .icon(() -> new ItemStack(Dynamite))
        .build();

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("dynamite", "dynamite"), Dynamite);
        Registry.register(Registries.ITEM, new Identifier("dynamite", "thermite_dynamite"), ThermiteDynamite);
        Registry.register(Registries.ITEM, new Identifier("dynamite", "he_dynamite"), HEDynamite);
    
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(Dynamite);
            content.add(HEDynamite);
            content.add(ThermiteDynamite);
        });
    }
}