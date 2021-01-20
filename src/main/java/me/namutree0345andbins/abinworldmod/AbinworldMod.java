package me.namutree0345andbins.abinworldmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.mixin.networking.accessor.CustomPayloadC2SPacketAccessor;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.Identifier;

public class AbinworldMod implements ModInitializer {
    @Override
    public void onInitialize() {

    }

    public static Identifier getPayloadChannel(Packet<?> packet) {
        return ((CustomPayloadC2SPacketAccessor)packet).getChannel();
    }

    public static PacketByteBuf getPayloadData(CustomPayloadC2SPacket packet) {
        return ((CustomPayloadC2SPacketAccessor)packet).getData();
    }
}
