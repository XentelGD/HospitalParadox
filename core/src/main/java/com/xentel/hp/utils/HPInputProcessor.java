package com.xentel.hp.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.xentel.hp.HospitalParadox;

public class HPInputProcessor implements InputProcessor {
    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {

        Mouse.old.x = Mouse.pos.x;
        Mouse.old.y = Mouse.pos.y;

        Mouse.pos.x = i;
        Mouse.pos.y = i1;

        HospitalParadox.viewport.unproject(Mouse.pos);

        Mouse.delta.x = Mouse.pos.x - Mouse.old.x;
        Mouse.delta.y = Mouse.pos.y - Mouse.old.y;



        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {

        Mouse.old.x = Mouse.pos.x;
        Mouse.old.y = Mouse.pos.y;

        Mouse.pos.x = i;
        Mouse.pos.y = i1;

        HospitalParadox.viewport.unproject(Mouse.pos);

        Mouse.delta.x = Mouse.pos.x - Mouse.old.x;
        Mouse.delta.y = Mouse.pos.y - Mouse.old.y;



        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
