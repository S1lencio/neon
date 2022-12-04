package de.silencio.neon.module.other;

import de.silencio.neon.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameMode;

public class ClientGameMode extends Module {

    private static MinecraftClient mc = MinecraftClient.getInstance();
    public ClientGameMode() {
        super("Client Game Mode", "clientgamemode", "Change your gamemode. Only affects the client.", Category.OTHER, Type.SWITCH, false);
    }

    public static void gamemodeToggle() {
        String currentGamemode = mc.interactionManager.getCurrentGameMode().toString();
        System.out.println("before: " + mc.interactionManager.getCurrentGameMode() + " but actually should be " + currentGamemode);
        if (currentGamemode.equals("survival")) {
            mc.interactionManager.setGameMode(GameMode.CREATIVE);
            currentGamemode = "creative";
        } else if (currentGamemode.equals("creative")) {
            mc.interactionManager.setGameMode(GameMode.SPECTATOR);
            currentGamemode = "spectator";
        } else if (currentGamemode.equals("spectator")) {
            mc.interactionManager.setGameMode(GameMode.ADVENTURE);
            currentGamemode = "adventure";
        } else if (currentGamemode.equals("adventure")) {
            mc.interactionManager.setGameMode(GameMode.SURVIVAL);
            currentGamemode = "survival";
        }
        System.out.println("after: " + mc.interactionManager.getCurrentGameMode() + " but actually should be " + currentGamemode);
    }

    public static void setGameMode(GameMode gameMode) {
        mc.interactionManager.setGameMode(gameMode);
    }

    public GameMode getGamemode() {
        return mc.interactionManager.getCurrentGameMode();
    }
}
