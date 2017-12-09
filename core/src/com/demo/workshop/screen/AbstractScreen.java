package com.demo.workshop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.demo.workshop.GameDemo;
import com.demo.workshop.controller.GameController;

/**
 *
 * Created by Ivan_Hernandez.
 */

public abstract class AbstractScreen implements Screen {

    protected SpriteBatch spriteBatch;
    protected SpriteBatch uiBatch;
    protected Array<com.demo.workshop.ui.Button> uiComponents;

    protected com.demo.workshop.controller.UIController uiController;
    protected GameController gameController;

    protected InputMultiplexer multiplexer;

    public AbstractScreen() {

        spriteBatch = GameDemo.getSpriteBatch();
        uiBatch = GameDemo.getSpriteBatch();
        uiComponents = new Array<com.demo.workshop.ui.Button>();
        uiController = new com.demo.workshop.controller.UIController(uiComponents);
        gameController = new GameController(new Array<Sprite>());

        multiplexer = new InputMultiplexer();

        multiplexer.addProcessor(uiController);
        multiplexer.addProcessor(gameController);

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void show() {

    }

    @Override
    public final void render(float delta) {

        // Color to clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        render();
        renderUI();
    }

    public void renderUI() {

        uiBatch.begin();

        for(com.demo.workshop.ui.Button ui : uiComponents) {
            ui.draw(GameDemo.getSpriteBatch());
        }

        uiBatch.end();
    }
    public abstract void render();

    @Override
    public void resize(int width, int height) {
        GameDemo.getViewport().update(width, height, true);
        GameDemo.getCamera().update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public com.demo.workshop.controller.UIController getUiController() {
        return this.uiController;
    }

    public GameController getGameController() {
        return this.gameController;
    }
}
