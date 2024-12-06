package de.silencio.neon.mixin;

import de.silencio.neon.ui.Hud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("RETURN"))
    public void renderHud(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        MatrixStack matrices = context.getMatrices();
        float tickDelta = tickCounter.getTickDelta(true);

        Hud.render(matrices, tickDelta, context);
    }
}