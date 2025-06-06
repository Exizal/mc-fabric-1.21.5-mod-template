package exizal.testmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeSunlightGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FishyEntity extends AnimalEntity {

        public final AnimationState idleAnimationState = new AnimationState();
        private int idleAnimationTimeout = 0;

        public FishyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MoveIntoWaterGoal(this));
        this.goalSelector.add(2,new EscapeSunlightGoal(this, 1.00));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
            return MobEntity.createMobAttributes()
                    .add(EntityAttributes.MAX_HEALTH, 100)
                    .add(EntityAttributes.MOVEMENT_SPEED, 1)
                    .add(EntityAttributes.OXYGEN_BONUS, 50000)
                    .add(EntityAttributes.WATER_MOVEMENT_EFFICIENCY, 2);
    }

    private void setupAnimationStates() {
            if (this.idleAnimationTimeout <=0) {
                this.idleAnimationTimeout = 40;
                this.idleAnimationState.start(this.age);
            }
            else {
                --this.idleAnimationTimeout;
            }
    }

    public void tick(){
            super.tick();
                    if (this.getWorld().isClient()) {
                        this. setupAnimationStates();
                    }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Item.byRawId(518));
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
