package com.pearlarmy;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
	public static final ResourceKey<EntityType<?>> SOLDIER_KEY = ResourceKey.create(
			Registries.ENTITY_TYPE,
			Identifier.fromNamespaceAndPath(PearlArmyMod.MOD_ID, "soldier")
	);

	public static final EntityType<SoldierEntity> SOLDIER = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			SOLDIER_KEY,
			EntityType.Builder.<SoldierEntity>of(SoldierEntity::new, MobCategory.MISC)
					.sized(0.6f, 1.95f)
					.fireImmune()
					.clientTrackingRange(8)
					.build(SOLDIER_KEY)
	);

	public static void register() {
		FabricDefaultAttributeRegistry.register(SOLDIER, SoldierEntity.createSoldierAttributes());
	}
}
