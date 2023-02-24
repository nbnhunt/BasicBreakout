package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int height;
    int width;

    public Paddle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void update() {
        x = Gdx.input.getX();
        y = 10;


        if (x > (Gdx.graphics.getWidth() - width)) {
            x = Gdx.graphics.getWidth() - width;
        }

 /*       if (y > (Gdx.graphics.getHeight() - height)) {
            y = Gdx.graphics.getHeight() - height;
        }*/
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
