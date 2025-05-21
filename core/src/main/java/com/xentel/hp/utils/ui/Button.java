package com.xentel.hp.utils.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.xentel.hp.HospitalParadox;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.utils.Listener;
import com.xentel.hp.utils.Mouse;
import com.xentel.hp.utils.Screen;

import java.awt.*;

public class Button {
    public ButtonStyle style;
    public Rectangle bounds;
    public boolean
        isHovered = false,
        wasHovered = false,
        isPressed = false,
        isActive = true,
        wasPressedInside = false;

    public String text;
    public Listener listener;

    public Listener onHover, onHoverEnd;

    // ---- MODE ----
    // 0 = normal (one click = one listener call);
    // 1 = extended (The listener is called until the button is released)
    // 2 = extended + action doesn't end when the cursor leaves the button
    public int mode = 0;

    public Button(String text, ButtonStyle style, float x, float y, float width, float height) {
        this.text = text;
        this.style = new ButtonStyle(style);
        this.bounds = new Rectangle((int) x, (int) y, (int) width, (int) height);
    }



    private void render(SpriteBatch batch) {
        // Выбираем текстуру в зависимости от состояния
        Texture currentTexture = style.normalTexture;

        if (isActive) {
            if (isHovered) {
                currentTexture = style.hoverTexture;
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
                if (!wasHovered) {
                    if (onHover != null) {
                        onHover.func();
                    }
                }
            }
            if (!isHovered && wasHovered) {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
                if (onHoverEnd != null) {
                    onHoverEnd.func();
                }
            }
        } else {
            currentTexture = style.inactiveTexture;
        }

        batch.begin();

        batch.draw(currentTexture, bounds.x, bounds.y, bounds.width, bounds.height);

        GlyphLayout layout = new GlyphLayout(style.font, text);
        float textX = bounds.x + (bounds.width - layout.width) / 2;
        float textY = bounds.y + (bounds.height + layout.height) / 2;

        style.font.setColor(style.textColor);
        if (!isActive) {
            style.font.setColor(style.inactiveTextColor);
        }

        style.font.draw(batch, text, textX, textY);

        batch.end();
    }


    public void update(Vector3 touchPos, SpriteBatch batch) {


        if (isActive) {

            wasHovered = isHovered;
            Rectangle newBounds = new Rectangle(bounds);
            newBounds.x -= (int) (HospitalParadox.viewport.getWorldWidth() / 2);
            newBounds.y -= (int) (HospitalParadox.viewport.getWorldHeight() / 2);
            isHovered = newBounds.contains(touchPos.x, touchPos.y);

            if (!Gdx.input.isTouched() || (!isHovered && mode != 2)) wasPressedInside = false;

            if (isHovered && Gdx.input.justTouched()) {
                isPressed = true;
                wasPressedInside = true;

                if (listener != null) listener.func();
            }

            if (mode != 0 && Gdx.input.isTouched() && wasPressedInside) {
                isPressed = true;
                if (listener != null) listener.func();
            }

        }

        render(batch);
    }

    public float valueToPos(int min, int max, float x, float value, float width) {

        return x + width * ((value - min) / (float)(max - min));


    }

    public float posToValue(int min, int max, float x, float width) {

        return min + ((bounds.x - x) / width * (max - min));
    }


}
