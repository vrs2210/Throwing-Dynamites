package boom.throwables.Customs;

import boom.throwables.Initializers.ItemInitialize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class ThrowableItemEntity extends ThrownItemEntity {
    private static final TrackedData<ItemStack> ITEM = DataTracker.registerData(ThrownItemEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    private static final EntityType<ThrowableItemEntity> ENTITY_TYPE = Registry.register(Registries.ENTITY_TYPE, id, EntityType.Builder<ThrowableItemEntity>.build(id));;

    public ThrowableItemEntity(World world, LivingEntity livingEntity) {
        super((EntityType<? extends ThrowableItemEntity>), livingEntity, world);
    }

    public ItemStack getItem() {
        return this.getDataTracker().get(ITEM);
    }

    public void setItem(ItemStack item) {
        if (!item.isOf(this.getItem().getItem()) || item.hasNbt()) {
            this.getDataTracker().set(ITEM, Util.make(item.copy(), stack -> stack.setCount(1)));
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 4, ExplosionSourceType.TNT);
            this.discard();
        }
    }

    @Override
    public void initDataTracker() {
        this.getDataTracker().startTracking(ITEM, ItemStack.EMPTY);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInitialize.DYNAMITE;
    }
}
