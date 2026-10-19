
package com.pearlarmy;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;

public class SoldierRenderer extends ZombieRenderer {

    public SoldierRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public Identifier getTextureLocation(ZombieRenderState state) {
        return Identifier.fromNamespaceAndPath(
                PearlArmyMod.MOD_ID,
                "textures/entity/soldier.png"
        );
    }
}
