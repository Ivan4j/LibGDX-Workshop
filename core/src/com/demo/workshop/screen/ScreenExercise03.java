package com.demo.workshop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.demo.workshop.model.GameObject;
import com.demo.workshop.utils.Constants;

/**
 * Exercise #03: Draw a game Object (GameObject extends Sprite)
 *
 * Created by Ivan_Hernandez.
 */

public class ScreenExercise03 extends AbstractScreen {

    private Texture backgroundTexture;

    private GameObject androidSprite;
    private Texture androidTexture;

    public ScreenExercise03() {

        backgroundTexture = new Texture(Gdx.files.internal("img/background/low_poly_01.png"));

        androidTexture = new Texture(Gdx.files.internal("img/characters/ardilla__01_256.png"));
        androidTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        androidSprite = new GameObject(androidTexture);

    }
    @Override
    public void render() {

        spriteBatch.begin();

            //Draw a white image as background
            spriteBatch.draw(backgroundTexture, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

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
