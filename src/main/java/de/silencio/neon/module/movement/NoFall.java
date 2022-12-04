package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", "nofall", "Mitigated fall damage", Category.MOVEMENT, Type.TOGGLE, false);
    }

    @Override
    public void onTick() {
        if (this.isEnabled()) {
            if (mc.player != null) {
                if (mc.player.fallDistance <= (mc.player.isFallFlying() ? 1.0f : 2.0f)) { return; }
                if (mc.player.isFallFlying() && mc.player.isSneaking() && (mc.player.getVelocity().y < -0.5)) { return; }

                mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
            }
        }
        super.onTick();
    }
}
