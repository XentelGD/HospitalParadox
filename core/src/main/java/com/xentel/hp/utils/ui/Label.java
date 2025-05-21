package com.xentel.hp.utils.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.xentel.hp.data.GameSettings;
import com.xentel.hp.data.lang.Translations;
import com.xentel.hp.utils.Screen;

public class Label {

    public float x, y;
    public String text;
    public String alignment = "center";
    public BitmapFont font;
    public Color color;

    public Label(String text, float x, float y, String alignment, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.alignment = alignment;
        this.color = color;
    }

    public void render(BitmapFont font, SpriteBatch batchUI) {

        GlyphLayout titleGL = new GlyphLayout();
        titleGL.setText(font, text);

        float offsetX = 0;

        if (alignment == "center") {
            offsetX = (titleGL.width) / 2;
        } else if (alignment == "right") {
            offsetX = (titleGL.width);
        }

        font.setColor(color);
        font.draw(batchUI, text, this.x - offsetX, this.y);
    }

    public static void render(
        String text, float x, float y, String alignment, Color color, BitmapFont font, SpriteBatch batchUI
    ) {
        new Label(text, x, y, alignment, color).render(font, batchUI);
    }
}
