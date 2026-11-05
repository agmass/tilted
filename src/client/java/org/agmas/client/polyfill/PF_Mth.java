package org.agmas.client.polyfill;

//? if < 1.21.2 {

public class PF_Mth {
    public static float easeInOutSine(float value) {
        return (float) (-(Math.cos(Math.PI * value) - 1.0) / 2.0);
    }

    public static double easeInOutSine(double value) {
        return -(Math.cos(Math.PI * value) - 1.0) / 2.0;
    }
}

//? }