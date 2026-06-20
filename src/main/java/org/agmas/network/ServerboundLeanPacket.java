package org.agmas.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.agmas.Tilted;

public record ServerboundLeanPacket(int leaning) implements CustomPacketPayload {
    public static final Identifier CHANGE_LEAN_DIRECTION = Tilted.of("change_lean_direction");
    public static final CustomPacketPayload.Type<ServerboundLeanPacket> TYPE = new CustomPacketPayload.Type<>(CHANGE_LEAN_DIRECTION);
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundLeanPacket> CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundLeanPacket::leaning, ServerboundLeanPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
