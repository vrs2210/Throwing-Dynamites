package boom.dynamite.Util;

import boom.dynamite.items.throwableDynamite.DynamiteEntity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class ThrowableUtil {
    private static final Byte ENTITY_STATUS_BYTE = EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES;
    private static final ExplosionSourceType EXPLOSION_SOURCE_TYPE = ExplosionSourceType.BLOCK;

    public static void throwItemStack(PlayerEntity playerEntity, ItemStack itemStack, DynamiteEntity dynamiteEntity, World world, float Speed, Boolean useGravity) {
        dynamiteEntity.setItem(itemStack);
        dynamiteEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f, Speed, 1.0f);
        dynamiteEntity.setNoGravity(!dynamiteEntity.useGravity);
        world.spawnEntity(dynamiteEntity);
    }

    public static void handleOnCollision(World world, DynamiteEntity dynamiteEntity, float explosionPower) {
        final Double X = dynamiteEntity.getX();
        final Double Y = dynamiteEntity.getY();
        final Double Z = dynamiteEntity.getZ();

        world.sendEntityStatus(dynamiteEntity, ENTITY_STATUS_BYTE);
        world.createExplosion(dynamiteEntity, X, Y, Z, explosionPower, dynamiteEntity.useFire, EXPLOSION_SOURCE_TYPE);
    }

    public static float getThrowVolume(World world, float minFloat, float maxFloat) {
        return minFloat / (world.getRandom().nextFloat() * minFloat + maxFloat);
    }
}
