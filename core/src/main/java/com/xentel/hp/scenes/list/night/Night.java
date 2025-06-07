package com.xentel.hp.scenes.list.night;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.xentel.hp.scenes.Scene;

// night scene

public class Night extends Scene {

    @Override
    public void start() {
        super.start();
        NightGUI.init();
    }

    @Override
    public void update(OrthographicCamera camera, SpriteBatch batch, SpriteBatch batchUI, ShapeRenderer renderer) {
        super.update(camera, batch, batchUI, renderer);
        NightGUI.update(batchUI, renderer);
    }
}
