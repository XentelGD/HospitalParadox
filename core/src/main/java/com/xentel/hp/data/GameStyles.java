package com.xentel.hp.data;

import com.badlogic.gdx.graphics.Color;
import com.xentel.hp.utils.ui.ButtonStyle;

public class GameStyles {

    public static ButtonStyle defaultButtonStyle;
    public static ButtonStyle smallButtonStyle;

    public static void init() {
        defaultButtonStyle = new ButtonStyle(
            GameTextures.all.get("button_default"),
            GameTextures.all.get("button_hover"),
            GameFonts.all.get("default"),
            new Color(1, 1, 1, 1),
            new Color(0.4f, 0.4f, 0.4f, 1f),
            GameTextures.all.get("button_inactive")
        );

        smallButtonStyle = new ButtonStyle(
            GameTextures.all.get("small_button_default"),
            GameTextures.all.get("small_button_hover"),
            GameFonts.all.get("default"),
            new Color(1, 1, 1, 1),
            new Color(0.4f, 0.4f, 0.4f, 1f),
            GameTextures.all.get("small_button_inactive")
        );
    }
}
