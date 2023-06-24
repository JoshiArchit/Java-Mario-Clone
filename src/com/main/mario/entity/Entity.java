package com.main.mario.entity;

import java.awt.*;

public class Entity {

    public int x, y;    // Position classes
    public int width, height;
    public boolean solid;

    public int velX;
    public int velY;

    public Entity(int x, int y, int width, int height, boolean solid) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
    }

    public void render( Graphics g ) {
        // Uses graphics object+buffer strategy from Game class

    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public void setY( int y ) {
        this.y = y;
    }


    public void setVelX( int velX ) {
        this.velX = velX;
    }

    public void setVelY( int velY ) {
        this.velY = velY;
    }
}
