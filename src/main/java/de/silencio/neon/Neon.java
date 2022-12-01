package de.silencio.neon;

import de.silencio.neon.module.Module;
import de.silencio.neon.module.ModuleManager;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class Neon implements ModInitializer {

    public static final Neon INSTANCE = new Neon();
    public Logger logger = LogManager.getLogger(Neon.class);

    private MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        System.out.println("| Neon Initialized successfully!");
    }

    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (Module module : ModuleManager.INSTANCE.getModules()) {
                if (key == module.getKey()) module.toggle();
            }
        }
    }

    public void onTick() {
        if (mc.player != null) {
            for (Module module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }
}
