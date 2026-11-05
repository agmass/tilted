package org.agmas.network;

//? if >=1.21.11 {
/*import net.minecraft.resources.Identifier;
 *///? } else {
import net.minecraft.resources.ResourceLocation;
//? }
import org.agmas.Tilted;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ServerboundLeanPacket(int leaning) implements CustomPacketPayload {
    //? if >=1.21.11 {
    /*public static final Identifier CHANGE_LEAN_DIRECTION = Tilted.of("change_lean_direction");
    *///? } else {
    public static final ResourceLocation CHANGE_LEAN_DIRECTION = Tilted.of("change_lean_direction");
    //? }
    public static final CustomPacketPayload.Type<ServerboundLeanPacket> TYPE = new CustomPacketPayload.Type<>(CHANGE_LEAN_DIRECTION);
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundLeanPacket> CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundLeanPacket::leaning, ServerboundLeanPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}