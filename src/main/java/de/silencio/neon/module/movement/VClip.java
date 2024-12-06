package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;

public class VClip extends Module {

    public VClip() {
        super("VClip", "vclip", "Allows you to teleport upwards through blocks", Category.MOVEMENT, Type.BUTTON, false);
    }

    @Override
    public void onEnable() {
        System.out.println("teleported, or should have");
        mc.player.setPosition(mc.player.getX(), mc.player.getY() + 5, mc.player.getZ());
        super.onEnable();
        this.setEnabled(false);
    }

    @Override
    public void onTick() {
        this.setEnabled(false);
        super.onTick();
    }
}
