package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class BoatFly extends Module {

    Double upwardsSpeed = 3.0;
    Double forwardsSpeed = 3.0;

    public BoatFly() {
        super("BoatFly", "boatfly", "Allows you to fly with your boat", Category.MOVEMENT, Type.TOGGLE, false);
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onTick() {

        if(!mc.player.hasVehicle())
            return;

        Entity vehicle = mc.player.getVehicle();
        Vec3d velocity = vehicle.getVelocity();

        // default motion
        double motionX = velocity.x;
        double motionY = 0;
        double motionZ = velocity.z;

        // up/down
        if(mc.options.jumpKey.isPressed())
            motionY = upwardsSpeed;
        else if(mc.options.sprintKey.isPressed())
            motionY = velocity.y;

        // forward
        if(mc.options.forwardKey.isPressed())
        {
            double speed = forwardsSpeed;
            float yawRad = vehicle.getYaw() * MathHelper.RADIANS_PER_DEGREE;

            motionX = MathHelper.sin(-yawRad) * speed;
            motionZ = MathHelper.cos(yawRad) * speed;
        }

        // apply motion
        vehicle.setVelocity(motionX, motionY, motionZ);

        super.onTick();
    }
}
