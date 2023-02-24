package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {
    public boolean destroyed;
    int x, y, width, height;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public void update() {
    }

    public void checkCollision(Ball ball) {
        if(collidesWith(ball)){
            ball.ySpeed = -ball.ySpeed;
            destroyed = true;
        }
    }

    private boolean collidesWith(Ball ball) {
        return x + height >= ball.x && x - height <= ball.x + ball.size && y + height >= ball.y && y - height <= ball.y + ball.size;

    }
}
