package com.xentel.hp.scenes.list;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.xentel.hp.HospitalParadox;
import com.xentel.hp.data.lang.GameColors;
import com.xentel.hp.data.lang.Translations;
import com.xentel.hp.scenes.Scenes;
import com.xentel.hp.utils.Mouse;
import com.xentel.hp.scenes.Scene;
import com.xentel.hp.data.GameFonts;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.data.GameStyles;
import com.xentel.hp.utils.Screen;
import com.xentel.hp.utils.ui.Button;
import com.xentel.hp.utils.ui.Label;


public class Settings extends Scene {

    public Button volume, language, windowMode, back;


    @Override
    public void start() {

        super.start();
        initUI();
    }

    @Override
    public void update(OrthographicCamera camera, SpriteBatch batch, SpriteBatch batchUI, ShapeRenderer renderer) {
        super.update(camera, batch, batchUI, renderer);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            back.listener.func();
        }

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(new Color(0.1f, 0.1f, 0.1f, 1f));
        renderer.rect(Screen.getCenterX() - 200, Screen.getCenterY() + 15 + 100, 400, 20);
        renderer.end();

        drawUI(batchUI);


    }

    private void initUI() {


        volume = new Button(
            "<>", GameStyles.smallButtonStyle,
            Screen.getCenterX() + 350, Screen.getCenterY() + 100,
            50, 50
        );

        volume.bounds.x = (int) volume.valueToPos(0, 100, Screen.getCenterX() - 200, GameSettings.volume, 350);

        volume.mode = 2;
        volume.listener = () -> {
            if (Math.abs(Mouse.delta.x) > 0.1f) {
                volume.bounds.x = (int) (Screen.getCenterX() + Math.max(-200, Math.min(150, (int) Mouse.pos.x - 25)));
                GameSettings.volume = (int) volume.posToValue(0, 100, Screen.getCenterX() - 200, 350);
            }
        };

        language = new Button(
            Translations.get("language_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY(), 400, 70
        );
        language.listener = () -> {
            Scenes.run(Scenes.LANGUAGE);
        };

        windowMode = new Button(
            "", GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY() - 100, 400, 70
        );

        if (GameSettings.isFullscreen) {
            windowMode.text = Translations.get("window_mode");
        } else {
            windowMode.text = Translations.get("fullscreen_mode");
        }

        windowMode.listener = () -> {
            if (GameSettings.isFullscreen) {
                GameSettings.isFullscreen = false;
                windowMode.text = Translations.get("fullscreen_mode");
            } else {
                GameSettings.isFullscreen = true;
                windowMode.text = Translations.get("window_mode");
            }
            HospitalParadox.setScreenMode();
        };


        back = new Button(
            Translations.get("back_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getBottomSide() + GameSettings.margin, 400, 70
        );
        back.listener = () -> {
            Scenes.run(Scenes.MENU);
        };

    }

    private void drawUI(SpriteBatch batchUI) {
        volume.update(Mouse.pos, batchUI);
        back.update(Mouse.pos, batchUI);
        language.update(Mouse.pos, batchUI);
        windowMode.update(Mouse.pos, batchUI);

        batchUI.begin();

        Label.render(
            Translations.get("volume"),

            Screen.getCenterX() - 220,
            Screen.getCenterY() + 135,

            "right", GameColors.GRAY, GameFonts.all.get("default"), batchUI
        );

        Label.render(
            String.valueOf(GameSettings.volume),

            volume.bounds.x + 25,
            volume.bounds.y + 90,

            "center", GameColors.GRAY, GameFonts.all.get("default"), batchUI
        );

        Label.render(
            Translations.get("settings_menu_title"),

            Screen.getCenterX(),
            Screen.getTopSide() - GameSettings.margin,

            "center", GameColors.GRAY, GameFonts.all.get("default"), batchUI
        );



        batchUI.end();
    }
}
