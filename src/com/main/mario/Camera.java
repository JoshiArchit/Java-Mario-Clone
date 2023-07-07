package com.main.mario;

import com.main.mario.entity.Entity;

public class Camera {

    public int x, y;

    public int getX() {
        return x;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y ) {
        this.y = y;
    }

    public void tick( Entity player ) {
        setX(-player.getX() + Game.getFrameWidth()/3);
        setY( (int) (-player.getY() + Game.getFrameHeight()/1.5) );
    }
}
