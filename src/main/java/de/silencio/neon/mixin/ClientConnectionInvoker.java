package de.silencio.neon.mixin;


import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientConnection.class)
public interface ClientConnectionInvoker {

    @Invoker("sendImmediately")
    void sendIm(Packet<?> packet, PacketCallbacks callbacks);
}
