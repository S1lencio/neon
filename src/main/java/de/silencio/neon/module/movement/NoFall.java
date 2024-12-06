package de.silencio.neon.module.movement;

import de.silencio.neon.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", "nofall", "Mitigated fall damage", Category.MOVEMENT, Type.TOGGLE, false);
    }

    @Override
    public void onTick() {
        if (!this.isEnabled()) return;
        if (mc.player == null) return;
        if (mc.player.isOnGround()) return;

        mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true, mc.player.horizontalCollision));
        super.onTick();
    }
}
