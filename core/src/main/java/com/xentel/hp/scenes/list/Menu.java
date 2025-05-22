package com.xentel.hp.scenes.list;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.xentel.hp.HospitalParadox;
import com.xentel.hp.data.lang.Translations;
import com.xentel.hp.scenes.Scenes;
import com.xentel.hp.data.GameStyles;
import com.xentel.hp.utils.Mouse;
import com.xentel.hp.scenes.Scene;
import com.xentel.hp.utils.Screen;
import com.xentel.hp.utils.ui.Button;

// main menu scene

public class Menu extends Scene {

    public Button play, settings, quit;


    @Override
    public void start() {
        super.start();

        initUI();

    }

    @Override
    public void update(OrthographicCamera camera, SpriteBatch batch, SpriteBatch batchUI, ShapeRenderer renderer) {
        super.update(camera, batch, batchUI, renderer);

        drawUI(batchUI);
    }

    private void initUI() {


        play = new Button(
            Translations.get("play_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY(), 400, 70
        );

        play.listener = () -> {
            Scenes.run(Scenes.MODE_SELECTION);
        };

        settings = new Button(
            Translations.get("settings_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY() - 100,   400, 70
        );

        settings.listener = () -> {
            Scenes.run(Scenes.SETTINGS);
        };

        quit = new Button(
            Translations.get("quit_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY() - 200,   400, 70
        );

        quit.listener = () -> {
            Gdx.app.exit();
        };

    }

    private void drawUI(SpriteBatch batchUI) {
        play.update(Mouse.pos, batchUI);
        settings.update(Mouse.pos, batchUI);
        quit.update(Mouse.pos, batchUI);
    }
}
