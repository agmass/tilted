package org.agmas.attachments;

import org.jspecify.annotations.Nullable;

public enum BarrelAttachment {
    NONE(1f),
    SUPPRESSOR(1f),
    EXTENDED_BARREL(1.5f),
    FLASH_HIDER(0.4f),
    COMPENSATOR(1.0f);

    public final float uncertaintyMultiplier;
    BarrelAttachment(float uncertaintyMultiplier) {
        this.uncertaintyMultiplier = uncertaintyMultiplier;
    }
}
