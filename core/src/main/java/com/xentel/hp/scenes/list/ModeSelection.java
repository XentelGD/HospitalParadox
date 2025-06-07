package com.xentel.hp.scenes.list;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.xentel.hp.data.lang.Translations;
import com.xentel.hp.scenes.Scenes;
import com.xentel.hp.utils.Mouse;
import com.xentel.hp.scenes.Scene;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.data.GameStyles;
import com.xentel.hp.utils.Screen;
import com.xentel.hp.utils.ui.Button;

// main menu scene

public class ModeSelection extends Scene {

    public Button newGame, continueGame, back;


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

        drawUI(batchUI);
    }

    private void initUI() {


        newGame = new Button(
            Translations.get("new_game_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY(), 400, 70
        );

        newGame.listener = () -> {
            Scenes.run(Scenes.NIGHT);
        };


        continueGame = new Button(
            Translations.get("continue_game_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getCenterY() - 100, 400, 70
        );

        continueGame.isActive = false;

        continueGame.listener = () -> {
            Scenes.run(Scenes.SETTINGS);
        };

        continueGame.onHover = () -> {
            continueGame.style.textColor = new Color(0.5f, 1f, 0.5f, 1f);
            continueGame.text = Translations.get("night") + " " + GameSettings.night;
        };

        continueGame.onHoverEnd = () -> {
            continueGame.style.textColor = new Color(1, 1, 1, 1f);
            continueGame.text = Translations.get("continue_game_button");
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
        newGame.update(Mouse.pos, batchUI);
        continueGame.update(Mouse.pos, batchUI);
        back.update(Mouse.pos, batchUI);
    }
}
