package boom.dynamite_.items.throwableDynamite;

import java.util.List;

import boom.dynamite_.Util.ItemUtil;
import boom.dynamite_.Util.ThrowableUtil;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DynamiteItem extends SnowballItem {
    public float explosionPower;
    public Boolean useFire;
    public Boolean useGravity;
    public String toolTipKey;

    private static final SoundEvent USE_SOUND_EVENT = SoundEvents.ENTITY_EGG_THROW;
    private static final SoundCategory SOUND_CATEGORY = SoundCategory.HOSTILE;
    private static final float MIN_PITCH = 0.2f;
    private static final float MAX_PITCH = 0.8f;
    private static final float SOUND_VOLUME = 0.5f;
    private static final float THROW_SPEED = 1.5f;

    public DynamiteItem(Boolean useFire, Boolean useGravity, float explosionPower, String toolTipKey) {
        super(new FabricItemSettings());

        this.useFire = useFire;
        this.explosionPower = explosionPower;
        this.useGravity = useGravity;
        this.toolTipKey = toolTipKey;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        // Get the blockpos and stack in current hand
        final BlockPos blockPos = playerEntity.getBlockPos();
        final ItemStack itemStack = playerEntity.getStackInHand(hand);

        // Play a creeper hiss
        world.playSound(null, blockPos, USE_SOUND_EVENT, SOUND_CATEGORY, SOUND_VOLUME,
                ThrowableUtil.getThrowVolume(world, MIN_PITCH, MAX_PITCH));

        if (!world.isClient) {
            // Create a new basic throwable to use when the item itself has been used
            final DynamiteEntity basicThrowable = new DynamiteEntity(world, playerEntity, this.useFire, this.useGravity,
                    this.explosionPower);
            ThrowableUtil.throwItemStack(playerEntity, itemStack, basicThrowable, world, THROW_SPEED, this.useGravity);
        }

        // Damage the item, if of course it can be damaged
        ItemUtil.DamageItem(playerEntity, itemStack);
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // for versions since 1.19
        tooltip.add(Text.translatable(this.toolTipKey));
    }
}
