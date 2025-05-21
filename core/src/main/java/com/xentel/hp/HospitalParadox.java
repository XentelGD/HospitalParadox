package com.xentel.hp;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.data.GameStyles;
import com.xentel.hp.data.lang.Translation;
import com.xentel.hp.data.lang.Translations;
import com.xentel.hp.scenes.Scenes;
import com.xentel.hp.scenes.Scene;
import com.xentel.hp.utils.HPInputProcessor;
import com.xentel.hp.utils.Transition;
import com.xentel.hp.data.GameFonts;
import com.xentel.hp.data.GameTextures;
import com.xentel.hp.utils.Mouse;

public class HospitalParadox extends Game {

    public static SpriteBatch batch, batchUI;
    public static ShapeRenderer renderer;
    public static OrthographicCamera camera;
    public static Viewport viewport;
    public static Scene current;
    public static Translation translation;
    public static InputProcessor inputProcessor;
    public static String languageRequest = "null";

    private float timer = 0;

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(null); // Сброс ввода
        Gdx.input.setInputProcessor(inputProcessor); // Переинициализация
    }


    public static void setScreenMode() {
        if (GameSettings.isFullscreen) {
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        } else {
            Gdx.graphics.setWindowedMode(GameSettings.width, GameSettings.height);
        }
    }

    @Override
    public void create() {
        inputProcessor = new HPInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);

        setScreenMode();

        batch = new SpriteBatch();
        batchUI = new SpriteBatch();
        renderer = new ShapeRenderer();
        camera = new OrthographicCamera(GameSettings.width, GameSettings.height);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

        Translations.init();
        Scenes.init();
        GameTextures.init();
        GameFonts.init();
        GameStyles.init();
        GameSettings.loadData();

        translation = Translations.getLanguageByCode(GameSettings.language);

        Scenes.MENU.start();
        current = Scenes.MENU;

    }

    private void saveData() {
        GameSettings.prefs.putInteger("volume", GameSettings.volume);
        GameSettings.prefs.flush();
    }


    @Override
    public void render() {

        if (Gdx.input.getDeltaX() == 0 && Gdx.input.getDeltaY() == 0) {
            Mouse.delta.x = 0;
            Mouse.delta.y = 0;
        }

        if (languageRequest != "null" && languageRequest != GameSettings.language) {

            GameSettings.language = languageRequest;

            Scenes.run(Scenes.MENU, () -> {

                translation = Translations.getLanguageByCode(GameSettings.language);
                languageRequest = "null";
            });

        }

        ScreenUtils.clear(new Color(0.05f, 0.05f, 0.05f, 1f)); // cleans the screen

        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
        batch.setProjectionMatrix(camera.combined); // binds the sprite batch to the camera
        current.update(camera, batch, batchUI, renderer);


        if (Transition.isWorkingNow) {
            Transition.update(renderer);
        }

        System.out.println(Mouse.delta.x);

        timer += Gdx.graphics.getDeltaTime();
        if (timer > 1) {
            saveData();
            timer = 0;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        renderer.dispose();
    }
}
