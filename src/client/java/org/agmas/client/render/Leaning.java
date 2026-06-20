package org.agmas.client.render;

import com.mojang.math.Axis;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.agmas.client.TiltedClient;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Leaning {

    public static Vec3 lean(Camera camera, float tickDelta) {
        float t = tickDelta;
        if (TiltedClient.previousLeaning == TiltedClient.leaning) t = 1;
        float angle = Mth.lerp(t,10 * TiltedClient.previousLeaning, 10 * TiltedClient.leaning);
        double shift = Mth.lerp(t,-0.3 * TiltedClient.previousLeaning, -0.3 * TiltedClient.leaning);
        if (Minecraft.getInstance().options.getCameraType().isMirrored()) {
            camera.rotation().rotateZ((float) Math.toRadians(-angle));
        } else {
            camera.rotation().rotateZ((float) Math.toRadians(angle));
        }
        Vector3f shf = camera.rotation().transform(new Vector3f((float) (-0.3 * TiltedClient.leaning), (float) 0,0));
        if (!Minecraft.getInstance().level.noCollision(new AABB(new Vec3(camera.position().x-shf.x,camera.position().y,camera.position().z-shf.z).subtract(0.4*shf.x,0.4,0.4*shf.z), new Vec3(camera.position().x+shf.x,camera.position().y,camera.position().z+shf.z).add(0.4*shf.x,0.4,0.4*shf.z)))) {
            return new Vec3(0,0,0);
        }

        if (Minecraft.getInstance().options.getCameraType().isMirrored()) {
            shift = -shift;
        }
        return new Vec3(0,0,shift);
    }
}
