package org.agmas;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;

public class ModAttachments {
    public static final AttachmentType<Integer> LEANING_DIRECTION = AttachmentRegistry.create(
            Tilted.of("leaning_direction"),
            integerBuilder -> integerBuilder.initializer(() -> 0).syncWith(ByteBufCodecs.INT, AttachmentSyncPredicate.all())
    );
    public static final AttachmentType<Boolean> IS_AIMING = AttachmentRegistry.create(
            Tilted.of("is_aiming"),
            booleanBuilder -> booleanBuilder.initializer(() -> false).syncWith(ByteBufCodecs.BOOL, AttachmentSyncPredicate.all())
    );


    public static void init() {}
}
