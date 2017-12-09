package com.demo.workshop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Exercise #00: Background Color
 *
 * Created by Ivan_Hernandez.
 */

public class ScreenExercise00 extends AbstractScreen {

    @Override
    public void render() {

        // Color to clear the screen
        // Use float values between 0 and 1
        Gdx.gl.glClearColor(0.55f, 0.75f, 0.15f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

}
