package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < (size) || x > (Gdx.graphics.getWidth() - size)) {
            xSpeed = -xSpeed;
        }
        if (y < (size) || y > (Gdx.graphics.getHeight() - size)) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)){
            ySpeed = -ySpeed;
        }
    }

    /*private boolean collidesWith(Paddle paddle) {
        //return ((y - paddle.y) == (size + paddle.height) || (paddle.y - y) == (size + paddle.height) || (paddle.x - x) == (size + paddle.width) || (x - paddle.x) == (size + paddle.width));
        return (size + y) == (paddle.y + paddle.height);

    }*/

    private boolean collidesWith(Paddle paddle) {
        return x + size >= paddle.x && x - size <= paddle.x + paddle.width && y + size >= paddle.y && y - size <= paddle.y + paddle.height;
    }

    public void checkCollision(Block block) {
        if (collidesWith(block)) {
            ySpeed = -ySpeed;
            block.destroyed = true;
        }
    }

    private boolean collidesWith(Block block) {
        return x + size >= block.x && x - size <= block.x + block.width && y + size >= block.y && y - size <= block.y + block.height;
    }

}
