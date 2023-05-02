package boom.dynamite.items.throwableDynamite;

import boom.dynamite.Util.ThrowableUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class DynamiteEntity extends SnowballEntity {
    public Boolean useFire;
    public boolean useGravity;
    public float explosionPower;
    
    public DynamiteEntity(World world, LivingEntity livingEntity, Boolean useFire, Boolean useGravity, float explosionPower) {
        super(world, livingEntity);
        this.useFire = useFire;
        this.explosionPower = explosionPower;
        this.useGravity = useGravity;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            // Handle OnCollision Logic
            ThrowableUtil.handleOnCollision(world, this, this.explosionPower);

            this.discard();
        }
    }
}
