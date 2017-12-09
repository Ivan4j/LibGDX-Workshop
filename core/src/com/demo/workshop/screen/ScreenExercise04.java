package com.demo.workshop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.demo.workshop.model.GameObject;
import com.demo.workshop.utils.Constants;

/**
 * Exercise #04: Change position, scale and rotation
 *
 * Created by Ivan_Hernandez.
 */

public class ScreenExercise04 extends AbstractScreen {

    private Texture backgroundTexture;

    private GameObject androidSprite;
    private Texture androidTexture;

    public ScreenExercise04() {

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

            //Move the object to the desired position
            androidSprite.setPosition(200, 400);

            //Set a fixed angle
            androidSprite.setRotation(45);

            //Double size
            androidSprite.setScale(2f);

        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        androidTexture.dispose();
    }

}
