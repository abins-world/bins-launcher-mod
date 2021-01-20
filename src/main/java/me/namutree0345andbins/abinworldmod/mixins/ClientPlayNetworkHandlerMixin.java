package me.namutree0345andbins.abinworldmod.mixins;

import io.netty.buffer.Unpooled;
import me.namutree0345andbins.abinworldmod.AbinworldMod;
import me.namutree0345andbins.abinworldmod.client.AbinworldModClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Redirect(method = {"onGameJoin"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/network/ClientConnection;send(Lnet/minecraft/network/Packet;)V"))
    private void onGameJoin(ClientConnection clientConnection, Packet<?> packet) {
        if(!(packet instanceof CustomPayloadC2SPacket) || !AbinworldMod.getPayloadChannel(packet).equals(CustomPayloadC2SPacket.BRAND)) {
            clientConnection.send(packet);
            return;
        }
        clientConnection.send((Packet) new CustomPayloadC2SPacket(CustomPayloadC2SPacket.BRAND, (new PacketByteBuf(Unpooled.buffer())).writeString("Ymluc3dvcmxk")));
    }

}
