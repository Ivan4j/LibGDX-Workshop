package com.demo.workshop.controller;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.demo.workshop.GameDemo;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Back;

/**
 * Created by Ivan_Hernandez.
 */

public class GameController implements InputProcessor {

    private Vector3 touchPoint = new Vector3();
    private boolean dragging;

    private Array<Sprite> gameObjects;

    private Sprite spriteSelected = null;

    public enum GAME_STATE {INIT, GAMEPLAY, PAUSE, COMPLETED}

    public GameController(Array<Sprite> gameObjects) {

        this.gameObjects = gameObjects;
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        touchPoint = GameDemo.getViewport().unproject(new Vector3(screenX,screenY,0));

        dragging = true;

        spriteSelected = null;

        for(Sprite s : this.gameObjects) {
            if (com.demo.workshop.utils.MathUtils.checkTouchCollision(touchPoint, s.getBoundingRectangle())) {

                spriteSelected = s;
                animateComponentIN(s);
                System.out.println("Sprite Touched");

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        touchPoint = GameDemo.getViewport().unproject(new Vector3(screenX,screenY,0));
        if (dragging && spriteSelected != null) {
            for (Sprite s : this.gameObjects) {
                if (com.demo.workshop.utils.MathUtils.checkTouchCollision(touchPoint, s.getBoundingRectangle())) {

                    System.out.println("Sprite Released");
                    if(s == spriteSelected) {
                        animateComponentOUT(s);
                        dragging = false;
                        spriteSelected = null;
                        return true;
                    }
                }
            }
        }

        if(spriteSelected != null)
            animateComponentOUT(spriteSelected);

        dragging = false;

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        if(!dragging)
            return false;

        if(spriteSelected != null && spriteSelected instanceof com.demo.workshop.model.GameObject) {

            if(((com.demo.workshop.model.GameObject)spriteSelected).isDraggable()) {

                touchPoint = GameDemo.getViewport().unproject(new Vector3(screenX, screenY, 0));

                //TODO Add the code for dragging
                spriteSelected.setPosition(touchPoint.x - spriteSelected.getWidth() / 2, touchPoint.y - spriteSelected.getHeight() / 2);
            }
        }

        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    public void animateComponentIN(Sprite component) {

        component.setScale(1);

        Tween.to(component, com.demo.workshop.utils.SpriteAccessor.SCALE_XY, 0.15f)
                .target(1.15f, 1.15f)
                .ease(Back.INOUT)
                .start(GameDemo.getTweenManager());

    }

    public void animateComponentOUT(Sprite component) {

        Tween.to(component, com.demo.workshop.utils.SpriteAccessor.SCALE_XY, 0.2f)
                .target(1f, 1f)
                .ease(Back.INOUT)
                .start(GameDemo.getTweenManager());

    }

    public void clearGameObjectsList() {
        this.gameObjects.clear();
    }

    public void setGameObjectsList(Array<Sprite> list) {
        this.gameObjects = list;
    }

}
