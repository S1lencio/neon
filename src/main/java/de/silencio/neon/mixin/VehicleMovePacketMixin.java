package de.silencio.neon.mixin;

import de.silencio.neon.helper.RoundPosition;
import de.silencio.neon.module.ModuleManager;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VehicleMoveC2SPacket.class)
public class VehicleMovePacketMixin {
    // Anti-human bypass for X
    @Redirect(method = "<init>(Lnet/minecraft/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getX()D"))
    public double getX(Entity instance)
    {
        if (ModuleManager.INSTANCE.getModule("antihumanbypass").isEnabled()) {
            return RoundPosition.roundCoordinate(instance.getX());
        } else {
            return instance.getX();
        }
    }
    // Anti-human bypass for Z
    @Redirect(method = "<init>(Lnet/minecraft/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getZ()D"))
    public double getZ(Entity instance) {
        if (ModuleManager.INSTANCE.getModule("antihumanbypass").isEnabled()) {
            return RoundPosition.roundCoordinate(instance.getZ());
        } else {
            return instance.getX();
        }
    }
}