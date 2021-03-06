package com.demo.workshop.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.demo.workshop.ui.action.IAction;

/**
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class Button extends Sprite {

    private Texture texture;

    private ButtonType type;

    private IAction action;

    public Button(ButtonType type) {

        this.type = type;
        setTexture();

        setBounds(0, 0, com.demo.workshop.utils.Constants.BUTTON_SIZE_BIG, com.demo.workshop.utils.Constants.BUTTON_SIZE_BIG);
    }

    private void setTexture() {

        switch(type) {

            case START:
                texture = new Texture(Gdx.files.internal(com.demo.workshop.utils.Constants.BUTTON_START));
                break;
            case PAUSE:
                texture = new Texture(Gdx.files.internal(com.demo.workshop.utils.Constants.BUTTON_PAUSE));
                break;
            case BACK:
                texture = new Texture(Gdx.files.internal(com.demo.workshop.utils.Constants.BUTTON_BACK));
                break;
            case NONE:
                texture = new Texture(Gdx.files.internal(com.demo.workshop.utils.Constants.BUTTON_NONE));
                break;
        }

        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        setTexture(texture);
        this.setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void setBounds(float x, float y, float width, float height) {
        super.setBounds(x, y, width, height);
        this.setOrigin(width / 2, height / 2);

    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void executeAction() {

        if(this.action != null) {
            this.action.execute();
        } else
            System.err.println("Action NULL, please set an action to this button");
    }


    public ButtonType getType() {
        return type;
    }

}
