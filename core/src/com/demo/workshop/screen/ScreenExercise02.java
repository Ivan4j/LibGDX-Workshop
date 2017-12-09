package com.demo.workshop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Exercise #02: Draw a game Object (Sprite)
 *
 * Created by Ivan_Hernandez.
 */

public class ScreenExercise02 extends AbstractScreen {

    private Texture backgroundTexture;

    private Sprite androidSprite;
    private Texture androidTexture;

    public ScreenExercise02() {

        backgroundTexture = new Texture(Gdx.files.internal("img/background/low_poly_01.png"));

        androidTexture = new Texture(Gdx.files.internal("img/characters/ardilla__01_256.png"));
        androidTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        androidSprite = new Sprite(androidTexture);

    }
    @Override
    public void render() {

        spriteBatch.begin();

            //Draw a white image as background
            spriteBatch.draw(backgroundTexture, 0, 0, com.demo.workshop.utils.Constants.SCREEN_WIDTH, com.demo.workshop.utils.Constants.SCREEN_HEIGHT);

            //Draw the game object
            androidSprite.draw(spriteBatch);

        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        androidTexture.dispose();
    }

}
