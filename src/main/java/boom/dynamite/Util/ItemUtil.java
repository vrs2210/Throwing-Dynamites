package boom.dynamite.Util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

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
}
