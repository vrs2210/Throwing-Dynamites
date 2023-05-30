package boom.throwables.Initializers;

import boom.throwables.ModInitialize;
import boom.throwables.Customs.ThrowableItem;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;

public class ItemInitialize implements ItemRegistryContainer {
    public static final Item DYNAMITE = new ThrowableItem(new OwoItemSettings().group(ModInitialize.GROUP));
}
