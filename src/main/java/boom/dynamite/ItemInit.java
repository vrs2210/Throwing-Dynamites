package boom.dynamite;

import boom.dynamite.items.throwableDynamite.DynamiteItem;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ItemInit implements ItemRegistryContainer {
    public static DynamiteItem Dynamite = new DynamiteItem(false, true, 3.0f, "item.dynamite.dynamite.tooltip");
    public static DynamiteItem HE_Dynamite = new DynamiteItem(false, true, 6.0f, "item.dynamite.he_dynamite.tooltip");
    public static DynamiteItem Thermite_Dynamite = new DynamiteItem(true, true, 2.0f, "item.dynamite.thermite_dynamite.tooltip");
    public static DynamiteItem Ender_Dynamite = new DynamiteItem(false, false, 2.0f, "item.dynamite.ender_dynamite.tooltip");

    public static final void init(OwoItemGroup owoItemGroup) {
        ItemGroupEvents.modifyEntriesEvent(owoItemGroup).register(content -> {
            content.add(Dynamite);
            content.add(HE_Dynamite);
            content.add(Thermite_Dynamite);
            content.add(Ender_Dynamite);
        });
    }
}
