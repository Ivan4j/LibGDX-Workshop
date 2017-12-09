package com.demo.workshop.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Ivan_Hernandez.
 */

public class GameObject extends Sprite {

    private boolean draggable = false;
    private boolean touchable = false;
    private boolean visible = true;

    public GameObject() {
        super();
    }

    public GameObject(Texture texture) {
        super(texture);
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public boolean isTouchable() {
        return touchable;
    }

    public void setTouchable(boolean touchable) {
        this.touchable = touchable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
