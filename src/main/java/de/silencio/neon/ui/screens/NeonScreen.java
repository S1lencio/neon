package de.silencio.neon.ui.screens;

import de.silencio.neon.module.Module;
import de.silencio.neon.module.ModuleManager;
import de.silencio.neon.module.other.ClientGameMode;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

public class NeonScreen extends Screen {

    private final Screen parent;
    private final GameOptions settings;

    public NeonScreen(Screen parent, GameOptions gameOptions) {
        super(Text.literal("Neon"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    protected void init() {
        // BACK BUTTON
        this.addDrawableChild(new ButtonWidget(10, this.height-30, 50, 20, ScreenTexts.BACK,
                button -> { this.client.setScreen(this.parent); }
        ));

        // MODULE TOGGLES
        /// MOVEMENT
        int indexMovement = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.MOVEMENT)) {
            this.addDrawableChild(new ButtonWidget(10, 30+indexMovement*30, 100, 20, Text.literal(module.getDisplayName()),
                    button -> {
                        module.toggle();
                        this.clearAndInit();
                    }
            ));
            indexMovement++;
        }

        /// COMBAT
        int indexCombat = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.COMBAT)) {
            this.addDrawableChild(new ButtonWidget(120, 30+indexCombat*30, 100, 20, Text.literal(module.getDisplayName()),
                    button -> {
                        module.toggle();
                        this.clearAndInit();
                    }
            ));
            indexCombat++;
        }

        /// RENDER
        int indexRender = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.RENDER)) {
            this.addDrawableChild(new ButtonWidget(230, 30+indexRender*30, 100, 20, Text.literal(module.getDisplayName()),
                    button -> {
                        module.toggle();
                        this.clearAndInit();
                    }
            ));
            indexRender++;
        }

        /// EXPLOIT
        int indexExploit = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.EXPLOIT)) {
            this.addDrawableChild(new ButtonWidget(340, 30+indexExploit*30, 100, 20, Text.literal(module.getDisplayName()),
                    button -> {
                        module.toggle();
                        this.clearAndInit();
                    }
            ));
            indexExploit++;
        }

        /// LIVEOVERFLOW
        int indexLiveOverflow = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.LIVEOVERFLOW)) {
            this.addDrawableChild(new ButtonWidget(450, 30+indexLiveOverflow*30, 100, 20, Text.literal(module.getDisplayName()),
                    button -> {
                        module.toggle();
                        this.clearAndInit();
                    }
            ));
            indexLiveOverflow++;
        }

        /// OTHER
        int indexOther = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.OTHER)) {

            if (module.getNameKey().equals("clientgamemode")) {
                this.addDrawableChild(new ButtonWidget(560, 30+indexOther*30, 100, 20, Text.literal("Set to Creative"),
                        button -> {
                            ClientGameMode.setGameMode(GameMode.CREATIVE);
                            this.clearAndInit();
                        }
                ));
                indexOther++;
                this.addDrawableChild(new ButtonWidget(560, 30+indexOther*30, 100, 20, Text.literal("Set to Survival"),
                        button -> {
                            ClientGameMode.setGameMode(GameMode.SURVIVAL);
                            this.clearAndInit();
                        }
                ));
                indexOther++;
                this.addDrawableChild(new ButtonWidget(560, 30+indexOther*30, 100, 20, Text.literal("Set to Adventure"),
                        button -> {
                            ClientGameMode.setGameMode(GameMode.ADVENTURE);
                            this.clearAndInit();
                        }
                ));
                indexOther++;
                this.addDrawableChild(new ButtonWidget(560, 30+indexOther*30, 100, 20, Text.literal("Set to Spectator"),
                        button -> {
                            ClientGameMode.setGameMode(GameMode.SPECTATOR);
                            this.clearAndInit();
                        }
                ));
                indexOther++;
            } else {
                this.addDrawableChild(new ButtonWidget(560, 30+(4+indexOther)*30, 100, 20, Text.literal(module.getDisplayName()),
                        button -> {
                            module.toggle();
                            this.clearAndInit();
                        }
                ));
            }
            indexOther++;
        }
    }
}
