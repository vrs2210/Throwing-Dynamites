package boom.dynamite.Util;

import net.minecraft.entity.player.PlayerEntity;

public class PlayerEntityUtil {
    public static Boolean isCreative(PlayerEntity playerEntity) {
        return playerEntity.getAbilities().creativeMode;
    }
}
