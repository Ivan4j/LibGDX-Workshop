package com.demo.workshop.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Ivan_Hernandez.
 */

public class GameCharacter extends GameObject {

    public enum CHARACTER_TYPE {GOOD_GUY, BAD_GUY, NEUTRAL}

    private CHARACTER_TYPE type = CHARACTER_TYPE.NEUTRAL;
    Texture textureA;

    private float timer = 0.5f;

    public GameCharacter(CHARACTER_TYPE type) {

        this.type = type;

        switch (this.type) {
            case GOOD_GUY:
                textureA = new Texture(Gdx.files.internal("img/characters/greenbird.png"));
                break;
            case BAD_GUY:
                textureA = new Texture(Gdx.files.internal("img/characters/redbird.png"));
                break;
            default:
                textureA = new Texture(Gdx.files.internal("img/characters/blackbird.png"));
        }

        textureA.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        this.setTexture(textureA);
        this.setSize(Math.abs(textureA.getWidth()), Math.abs(textureA.getHeight()));
        this.setRegion(0, 0, textureA.getWidth(), textureA.getHeight());
        this.setOrigin(textureA.getWidth() / 2, textureA.getHeight() / 2);
    }

    public GameCharacter(Texture texture) {
        super(texture);
    }

    public float getTimer() {
        return this.timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

}
