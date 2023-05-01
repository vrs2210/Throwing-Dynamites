package boom.dynamite.Util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemUtil {
    public static void DamageItem(PlayerEntity playerEntity, ItemStack itemStack) {
        if (!canDamageItem(playerEntity)) {
            itemStack.decrement(1);
        }
    }

    public static Boolean canDamageItem(PlayerEntity playerEntity) {
        return PlayerEntityUtil.isCreative(playerEntity);
    }
}
