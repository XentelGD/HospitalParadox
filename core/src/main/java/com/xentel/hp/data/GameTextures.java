package com.xentel.hp.data;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class GameTextures {
    public static HashMap<String, Texture> all = new HashMap<>();

    public static void init() {
        all.put("button_default", new Texture("ui/button_default.png"));
        all.put("button_hover", new Texture("ui/button_hover.png"));
        all.put("button_inactive", new Texture("ui/button_inactive.png"));
        all.put("small_button_default", new Texture("ui/small_button_default.png"));
        all.put("small_button_hover", new Texture("ui/small_button_hover.png"));
        all.put("small_button_inactive", new Texture("ui/small_button_inactive.png"));
    }
}
