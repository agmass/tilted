package org.agmas.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.agmas.Tilted;

public record ServerboundADSPacket(boolean isAdsing) implements CustomPacketPayload {
    public static final Identifier TOGGLE_ADS = Tilted.of("toggle_ads");
    public static final Type<ServerboundADSPacket> TYPE = new Type<>(TOGGLE_ADS);
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundADSPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundADSPacket::isAdsing, ServerboundADSPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
