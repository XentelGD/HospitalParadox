package com.xentel.hp.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.xentel.hp.data.GameSettings;

public class Transition {

    public static float in = 100, out = 100, total = 0;
    public static boolean isWorkingNow = false;
    public static Listener _listener;

    public static void start(Listener listener) {
        in = 0;
        out = 0;
        isWorkingNow = true;
        _listener = listener;
    }

    public static void update(ShapeRenderer renderer) {

        float deltaTime = Gdx.graphics.getDeltaTime();

        if ((int)in < 100) {
            isWorkingNow = true;
            in += deltaTime * 350;
        } else if ((int)out < 100) {
            out += deltaTime * 350;
        }

        if ((int)in >= 100 && (int)out >= 100) {
            isWorkingNow = false;
        }


        if ((int)in > 1 && (int)in < 100) {
            total = MathUtils.lerp(total, 1, 10f * deltaTime);
        }

        if ((int)in >= 100 && out >= 0) {
            if (_listener != null) {
                _listener.func();
            }
        }

        if ((int)out > 1 && (int)out < 100 && (int)in >= 100) {
            total = MathUtils.lerp(total, 0, 10f * deltaTime);
        }


        Gdx.gl.glEnable(GL20.GL_BLEND);


        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(new Color(0f, 0f, 0f, total));
        renderer.rect(
            Screen.getLeftSide(), Screen.getBottomSide(),
            Screen.getWidth() * 2, Screen.getHeight() * 2
        );

        renderer.end();


    }
}
