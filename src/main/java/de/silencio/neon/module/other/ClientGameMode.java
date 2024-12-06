package de.silencio.neon.module.other;

import de.silencio.neon.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameMode;

public class ClientGameMode extends Module {

    private static MinecraftClient mc = MinecraftClient.getInstance();
    public ClientGameMode() {
        super("Client Game Mode", "clientgamemode", "Change your gamemode. Only affects the client.", Category.OTHER, Type.SWITCH, false);
    }

    public static void setGameMode(GameMode gameMode) {
        mc.interactionManager.setGameMode(gameMode);
    }

    public GameMode getGamemode() {
        return mc.interactionManager.getCurrentGameMode();
    }
}
