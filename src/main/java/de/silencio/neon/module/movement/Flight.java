package de.silencio.neon.module.movement;

import de.silencio.neon.helper.RoundPosition;
import de.silencio.neon.module.Module;
import net.minecraft.entity.MovementType;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

public class Flight extends Module {

    private int flightTime = 0;

    public Flight() {
        super("Flight", "flight", "Simple vanilla fly", Category.MOVEMENT, Type.TOGGLE, false);
        this.setKey(GLFW.GLFW_KEY_G);
    }

    @Override
    public void onTick() {
        if (flightTime == 50) {

            //mc.player.applyMovementInput(new Vec3d(mc.player.getVelocity().x, -0.9, mc.player.getVelocity().z), 0.1F); // Works but not when moving upwards
            Vec3d velocity = mc.player.getVelocity();
            mc.player.setVelocity(velocity.x, -0.07, velocity.z);

            flightTime = 0;
        }
        mc.player.getAbilities().flying = true;
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
