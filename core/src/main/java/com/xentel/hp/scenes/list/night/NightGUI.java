package com.xentel.hp.scenes.list.night;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.data.GameStyles;
import com.xentel.hp.utils.Mouse;
import com.xentel.hp.utils.Screen;
import com.xentel.hp.utils.ui.Button;

public class NightGUI {

    public static Button tablet;

    public static void init() {
        tablet = new Button("\\/", GameStyles.longButtonStyle,
            Screen.getCenterX() - 300, GameSettings.margin, 600, 70);
    }

    public static void update(SpriteBatch batchUI, ShapeRenderer renderer) {
        tablet.update(Mouse.pos, batchUI);
    }
}
