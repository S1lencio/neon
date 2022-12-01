package de.silencio.neon.helper;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class NeonScreen extends Screen {

    private final Screen parent;
    private final GameOptions settings;

    public NeonScreen(Screen parent, GameOptions gameOptions) {
        super(Text.literal("Neon"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 -100, this.height / 6 + 90, 200, 20, Text.literal("Test Button"),
                button -> {}
        ));
        this.addDrawableChild(new ButtonWidget(this.width / 2 -100, this.height / 6 + 138, 200, 20, ScreenTexts.BACK,
                button -> { this.client.setScreen(this.parent); }
        ));
    }
}
