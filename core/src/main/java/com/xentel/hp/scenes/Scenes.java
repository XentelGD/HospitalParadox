package com.xentel.hp.scenes;

import com.xentel.hp.HospitalParadox;
import com.xentel.hp.scenes.list.*;
import com.xentel.hp.scenes.list.night.Night;
import com.xentel.hp.utils.Listener;
import com.xentel.hp.utils.Transition;

public class Scenes {

    // all Hospital Paradox's scenes

    public static Scene MENU, NIGHT, SETTINGS, MODE_SELECTION, LANGUAGE;

    // initializes all Hospital Paradox's scenes

    public static void init() {
        MENU = new Menu();
        NIGHT = new Night();
        SETTINGS = new Settings();
        MODE_SELECTION = new ModeSelection();
        LANGUAGE = new Language();
    }

    public static void run(Scene scene) {
        Transition.start(() -> {
            scene.start();
            HospitalParadox.current = scene;
        });
    }

    public static void run(Scene scene, Listener custom) {
        Transition.start(() -> {
            scene.start();
            custom.func();
            HospitalParadox.current = scene;

        });
    }
}
