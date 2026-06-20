package org.agmas.attachments;

import org.jspecify.annotations.Nullable;

public enum ScopeAttachment {
    IRON_SIGHTS(0.9f,3,false,false),
    MAGNIFIED_A(0.6f,20,false,false),
    MAGNIFIED_B(0.55f,20,false,true),
    TELESCOPIC(0.1f,10,true,false),
    MICROSCOPE(0.01f,100,true,false);

    public final float zoom;
    public final int ticksToADS;
    public final boolean impairedVision;
    public final boolean enhancedCrosshair;
    ScopeAttachment(float zoom, int ticksToADS, boolean impairedVision, boolean enhancedCrosshair) {
        this.zoom = zoom;
        this.ticksToADS = ticksToADS;
        this.impairedVision = impairedVision;
        this.enhancedCrosshair = enhancedCrosshair;
    }
}
