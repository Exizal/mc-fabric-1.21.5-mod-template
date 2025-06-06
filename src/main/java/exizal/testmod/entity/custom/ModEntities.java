// In src/main/java/exizal/testmod/entity/ModEntities.java

package exizal.testmod.entity.custom;

import exizal.testmod.TestMod;
import exizal.testmod.entity.custom.FishyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    // Declare the EntityType here, but do not assign it a value yet.
    public static EntityType<FishyEntity> FISHY;

    // This method will be called at the correct time to register the entity.
    public static void registerModEntities() {
        FISHY = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(TestMod.MOD_ID, "fishy"),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FishyEntity::new)
                        .dimensions(EntityDimensions.fixed(1f, 2.5f))
                        .build()
        );
    }
}