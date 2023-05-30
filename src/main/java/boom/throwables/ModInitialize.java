package boom.throwables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import boom.throwables.Initializers.BlockInitialize;
import boom.throwables.Initializers.ItemInitialize;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModInitialize implements ModInitializer {
    // Setting
    public static final String MOD_ID = "throwables";

    // Assets
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final OwoItemGroup GROUP = OwoItemGroup
        .builder(new Identifier(MOD_ID, "item_group"), () -> Icon.of(Items.IRON_AXE))
        .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Items and Blocks!");

        FieldRegistrationHandler.register(ItemInitialize.class, MOD_ID, false);
        FieldRegistrationHandler.register(BlockInitialize.class, MOD_ID, false);
        
        GROUP.initialize();

        

        LOGGER.info("Finished Initializing Items and Blocks!");
    }
}
