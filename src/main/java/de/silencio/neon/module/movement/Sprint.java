package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "Automatically sprint", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_H);
    }

    @Override
    public void onTick() {
        mc.player.setSprinting(true);
        super.onTick();
    }
}
