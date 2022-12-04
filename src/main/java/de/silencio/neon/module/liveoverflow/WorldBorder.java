package de.silencio.neon.module.liveoverflow;

import de.silencio.neon.module.Module;

public class WorldBorder extends Module {


    public WorldBorder() {
        super("World Border Bypass", "worldborderbypass", "Changes the client's world border size", Category.LIVEOVERFLOW, Type.TOGGLE, true);
    }

    @Override
    public void onTick() {

        if (mc.player != null && mc.player.getWorld() != null) {
            mc.player.getWorld().getWorldBorder().setSize(30000000);
        }

        super.onTick();
    }

    @Override
    public void onDisable() {
        this.setEnabled(true);
        super.onDisable();
    }
}
