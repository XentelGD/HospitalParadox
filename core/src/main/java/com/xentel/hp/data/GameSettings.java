package com.xentel.hp.data;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameSettings {

    public static Preferences prefs;

    public static int width = (int) (1920 / 1.3f), height = (int) (1080 / 1.3f);
    public static int volume = 100;
    public static boolean isFullscreen = true;

    public static int night = 1;
    public static String language = "en";

    public static float margin = 50;

    public static void loadData() {
        prefs = Gdx.app.getPreferences("GameSettings");

        volume = prefs.getInteger("volume");
    }
}
