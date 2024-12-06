package de.silencio.neon.mixin;

import de.silencio.neon.ui.screens.NeonScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text text) {
        super(text);
    }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci) {

        ButtonWidget button = ButtonWidget.builder(
                        Text.literal("Neon"),  // Button label
                        buttonWidget -> this.client.setScreen(new NeonScreen(this, this.client.options)) // OnPress action
                )
                .dimensions(10, 20, 90, 20) // Position and size
                .build();

        this.addDrawableChild(button);
    }
}