package com.xentel.hp.utils.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ButtonStyle {
    public Texture normalTexture;
    public Texture hoverTexture;
    public Texture inactiveTexture;
    public BitmapFont font;
    public Color textColor;
    public Color inactiveTextColor;

    public ButtonStyle(Texture normalTexture,
                       Texture hoverTexture,
                       BitmapFont font,
                       Color textColor,
                       Color inactiveTextColor,
                       Texture inactiveTexture) {

        this.normalTexture = normalTexture;
        this.hoverTexture = hoverTexture;
        this.font = font;
        this.textColor = textColor;
        this.inactiveTextColor = inactiveTextColor;
        this.inactiveTexture = inactiveTexture;
    }

    public ButtonStyle(ButtonStyle other) {
        this.normalTexture     = other.normalTexture;
        this.hoverTexture      = other.hoverTexture;
        this.font              = other.font;
        this.textColor         = other.textColor;
        this.inactiveTextColor = other.inactiveTextColor;
        this.inactiveTexture   = other.inactiveTexture;
    }
}
