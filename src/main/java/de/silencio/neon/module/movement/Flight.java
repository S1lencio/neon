package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module {

    public Flight() {
        super("Flight", "Simple vanilla fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
    }

    @Override
    public void onTick() {
        mc.player.getAbilities().flying = true;
        super.onTick();

    }

    @Override
    public void onDisable() {
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
