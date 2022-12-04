package de.silencio.neon.mixin;

import de.silencio.neon.helper.RoundPosition;
import de.silencio.neon.module.ModuleManager;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(PlayerMoveC2SPacket.Full.class)
public class PlayerPositionFullPacketMixin {
    @ModifyArgs(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/c2s/play/PlayerMoveC2SPacket;<init>(DDDFFZZZ)V"))
    private static void init(Args args) {
        if (ModuleManager.INSTANCE.getModule("antihumanbypass").isEnabled()) {
            RoundPosition.onPositionPacket(args);
        }
    }
}