package com.demo.workshop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Exercise #01: Background Image
 *
 * Created by Ivan_Hernandez.
 */

public class ScreenExercise01 extends AbstractScreen {

    private Texture backgroundTexture;

    public ScreenExercise01() {

        backgroundTexture = new Texture(Gdx.files.internal("img/background/low_poly_01.png"));

    }

    @Override
    public void render() {

        spriteBatch.begin();

            //Draw a white image as background
            spriteBatch.draw(backgroundTexture, 0, 0, com.demo.workshop.utils.Constants.SCREEN_WIDTH, com.demo.workshop.utils.Constants.SCREEN_HEIGHT);

        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
    }

}
