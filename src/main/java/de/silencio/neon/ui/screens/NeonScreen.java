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
        this.addDrawableChild(ButtonWidget.builder(ScreenTexts.BACK,
                        button -> this.client.setScreen(this.parent)
                        )
                        .dimensions(10, this.height - 30, 50, 20)
                        .build()
        );

        // MODULE TOGGLES
        /// MOVEMENT
        int indexMovement = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.MOVEMENT)) {
            addModuleButton(module, 10, 30 + indexMovement * 30);
            indexMovement++;
        }

        /// COMBAT
        int indexCombat = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.COMBAT)) {
            addModuleButton(module, 120, 30 + indexCombat * 30);
            indexCombat++;
        }

        /// RENDER
        int indexRender = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.RENDER)) {
            addModuleButton(module, 230, 30 + indexRender * 30);
            indexRender++;
        }

        /// EXPLOIT
        int indexExploit = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.EXPLOIT)) {
            addModuleButton(module, 340, 30 + indexExploit * 30);
            indexExploit++;
        }

        /// OTHER
        int indexOther = 0;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(Module.Category.OTHER)) {
            if (module.getNameKey().equals("clientgamemode")) {
                addGameModeButtons(30 + indexOther * 30, indexOther);
                indexOther += 4;  // Since we add four buttons for game modes
            } else {
                addModuleButton(module, 450, 30 + indexOther * 30);
                indexOther++;
            }
        }
    }

    private void addModuleButton(Module module, int x, int y) {
        this.addDrawableChild(ButtonWidget.builder(
                                Text.literal(module.getDisplayName()),
                                button -> {
                                    module.toggle();
                                    this.clearAndInit();
                                }
                        )
                        .dimensions(x, y, 100, 20)
                        .build()
        );
    }

    private void addGameModeButtons(int baseY, int indexOther) {
        String[] gameModes = {"Creative", "Survival", "Adventure", "Spectator"};
        GameMode[] gameModeValues = {
                GameMode.CREATIVE, GameMode.SURVIVAL, GameMode.ADVENTURE, GameMode.SPECTATOR
        };

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
    }
}
