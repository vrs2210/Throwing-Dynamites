package boom.dynamite;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static final String MOD_ID = "dynamite";

    public static final OwoItemGroup OWO_ITEM_GROUP = OwoItemGroup
            .builder(new Identifier(MOD_ID, "item_group"), () -> Icon.of(ItemInit.HE_Dynamite))
            .build();

    @Override
    public void onInitialize() {
        ItemInit.init(OWO_ITEM_GROUP);
        OWO_ITEM_GROUP.initialize();

        FieldRegistrationHandler.register(ItemInit.class, MOD_ID, false);        
    }
}