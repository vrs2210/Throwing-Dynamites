package boom.dynamite.Util;

import boom.dynamite.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemUtil {
    private static final int DAMAGE_VALUE = 1;

    public static void DamageItem(PlayerEntity playerEntity, ItemStack itemStack) {
        if (!canDamageItem(playerEntity)) {
            itemStack.decrement(DAMAGE_VALUE);
        }
    }

    public static Boolean canDamageItem(PlayerEntity playerEntity) {
        return PlayerEntityUtil.isCreative(playerEntity);
    }

    public static void registerItem(Item item, String itemId) {
        final String modId = Main.MOD_ID;
        Registry.register(Registries.ITEM, new Identifier(modId, itemId), item);
    }
}
