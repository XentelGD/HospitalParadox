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
import com.xentel.hp.data.GameFonts;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.data.GameStyles;
import com.xentel.hp.data.lang.GameColors;
import com.xentel.hp.data.lang.Translations;
import com.xentel.hp.scenes.Scene;
import com.xentel.hp.scenes.Scenes;
import com.xentel.hp.utils.HPInputProcessor;
import com.xentel.hp.utils.Screen;
import com.xentel.hp.utils.Mouse;
import com.xentel.hp.utils.ui.Button;
import com.xentel.hp.utils.ui.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Language extends Scene {

    public Button back;
    public List<Button> languagesButtons = new ArrayList<>();
    public HashMap<String, String> languages = new HashMap<>();


    @Override
    public void start() {

        languages.put("ru", "Русский");
        languages.put("en", "English");

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


        back = new Button(
            Translations.get("back_button"), GameStyles.defaultButtonStyle,
            Screen.getCenterX() - 200, Screen.getBottomSide() + GameSettings.margin, 400, 70
        );
        back.listener = () -> {
            Scenes.run(Scenes.SETTINGS);
        };

        int i = 0;
        for (String lang : languages.keySet()) {

            Button button = new Button(
                languages.get(lang), GameStyles.defaultButtonStyle,
                Screen.getCenterX() - 200, Screen.getCenterY() - i * 100, 400, 70
            );
            button.listener = () -> {
                HospitalParadox.languageRequest = lang;
            };

            languagesButtons.add(button);
            i++;
        }

    }

    private void drawUI(SpriteBatch batchUI) {
        back.update(Mouse.pos, batchUI);


        for (Button button : languagesButtons) {
            button.update(Mouse.pos, batchUI);
        }

        batchUI.begin();

        Label.render(
            Translations.get("language_menu_title"),

            Screen.getCenterX(),
            Screen.getTopSide() - GameSettings.margin,

            "center", GameColors.GRAY, GameFonts.all.get("default"), batchUI
        );

        batchUI.end();
    }
}
