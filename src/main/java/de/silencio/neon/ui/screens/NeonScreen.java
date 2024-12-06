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

    @Override
    protected void init() {
        // BACK BUTTON
        this.addDrawableChild(ButtonWidget.builder(
                                ScreenTexts.BACK,
                                button -> this.client.setScreen(this.parent)
                        )
                        .dimensions(10, this.height - 30, 50, 20)
                        .build()
        );

        // MODULE TOGGLES
        /// MOVEMENT
        int indexMovement = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.MOVEMENT)) {
            this.addDrawableChild(ButtonWidget.builder(
                                    Text.literal(module.getDisplayName()),
                                    button -> {
                                        module.toggle();
                                        this.clearAndInit();
                                    }
                            )
                            .dimensions(10, 30 + indexMovement * 30, 100, 20)
                            .build()
            );
            indexMovement++;
        }

        /// COMBAT
        int indexCombat = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.COMBAT)) {
            this.addDrawableChild(ButtonWidget.builder(
                                    Text.literal(module.getDisplayName()),
                                    button -> {
                                        module.toggle();
                                        this.clearAndInit();
                                    }
                            )
                            .dimensions(120, 30 + indexCombat * 30, 100, 20)
                            .build()
            );
            indexCombat++;
        }

        /// RENDER
        int indexRender = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.RENDER)) {
            this.addDrawableChild(ButtonWidget.builder(
                                    Text.literal(module.getDisplayName()),
                                    button -> {
                                        module.toggle();
                                        this.clearAndInit();
                                    }
                            )
                            .dimensions(230, 30 + indexRender * 30, 100, 20)
                            .build()
            );
            indexRender++;
        }

        /// EXPLOIT
        int indexExploit = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.EXPLOIT)) {
            this.addDrawableChild(ButtonWidget.builder(
                                    Text.literal(module.getDisplayName()),
                                    button -> {
                                        module.toggle();
                                        this.clearAndInit();
                                    }
                            )
                            .dimensions(340, 30 + indexExploit * 30, 100, 20)
                            .build()
            );
            indexExploit++;
        }

        /// OTHER
        int indexOther = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.OTHER)) {
            if (module.getNameKey().equals("clientgamemode")) {
                // Add specific game mode buttons
                String[] gameModes = {"Creative", "Survival", "Adventure", "Spectator"};
                GameMode[] gameModeValues = {GameMode.CREATIVE, GameMode.SURVIVAL, GameMode.ADVENTURE, GameMode.SPECTATOR};

                for (int i = 0; i < gameModes.length; i++) {
                    int finalI = i;
                    this.addDrawableChild(ButtonWidget.builder(
                                            Text.literal("Set to " + gameModes[i]),
                                            button -> {
                                                ClientGameMode.setGameMode(gameModeValues[finalI]);
                                                this.clearAndInit();
                                            }
                                    )
                                    .dimensions(450, 30 + (indexOther + i) * 30, 100, 20)
                                    .build()
                    );
                }
                indexOther += gameModes.length;
            } else {
                this.addDrawableChild(ButtonWidget.builder(
                                        Text.literal(module.getDisplayName()),
                                        button -> {
                                            module.toggle();
                                            this.clearAndInit();
                                        }
                                )
                                .dimensions(560, 30 + (4 + indexOther) * 30, 100, 20)
                                .build()
                );
                indexOther++;
            }
        }
    }

}
