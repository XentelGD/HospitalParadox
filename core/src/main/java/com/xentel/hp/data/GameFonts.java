package com.xentel.hp.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.HashMap;

public class GameFonts {
    public static HashMap<String, BitmapFont> all = new HashMap<>();

    public static void init() {
        all.put("default", new BitmapFont(Gdx.files.internal("fonts/default.fnt")));
    }
}
