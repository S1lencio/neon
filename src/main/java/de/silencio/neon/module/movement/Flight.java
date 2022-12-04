package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module {

    private int flightTime = 0;

    public Flight() {
        super("Flight", "flight", "Simple vanilla fly", Category.MOVEMENT, Type.TOGGLE, false);
        this.setKey(GLFW.GLFW_KEY_G);
    }

    @Override
    public void onTick() {
        if (flightTime == 50) {

            Vec3d velocity = mc.player.getVelocity();
            mc.player.setVelocity(velocity.x, -0.07, velocity.z);
            //mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(mc.player.getX(), mc.player.getY()-0.9D, mc.player.getZ(), false));
            flightTime = 0;
        }
        mc.player.getAbilities().flying = true;
        mc.player.setSilent(true);
        mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
        flightTime++;
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.player.getAbilities().flying = false;
        flightTime = 0;
        super.onDisable();
    }
}
