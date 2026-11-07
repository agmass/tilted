package org.agmas.network;

//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }
import org.agmas.Tilted;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
public record ServerboundADSPacket(boolean isAdsing) implements CustomPacketPayload {
    //? if >=1.21.11 {
    public static final Identifier TOGGLE_ADS = Tilted.of("toggle_ads");
    //? } else {
    /*public static final ResourceLocation TOGGLE_ADS = Tilted.of("toggle_ads");
    *///? }
    public static final Type<ServerboundADSPacket> TYPE = new Type<>(TOGGLE_ADS);
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundADSPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundADSPacket::isAdsing, ServerboundADSPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}