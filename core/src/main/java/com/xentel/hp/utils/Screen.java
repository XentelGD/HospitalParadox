package com.xentel.hp.utils;

import com.xentel.hp.HospitalParadox;

public class Screen {

    public static float getWidth() {
        return HospitalParadox.viewport.getWorldWidth();
    }

    public static float getHeight() {
        return HospitalParadox.viewport.getWorldHeight();
    }

    public static float getBottomSide() {
        return 0;
    }

    public static float getTopSide() {
        return HospitalParadox.viewport.getWorldHeight();
    }

    public static float getRightSide() {
        return 0;
    }

    public static float getLeftSide() {
        return -HospitalParadox.viewport.getWorldWidth();
    }

    public static float getCenterX() {
        return getWidth() / 2;
    }

    public static float getCenterY() {
        return getHeight() / 2;
    }
}
