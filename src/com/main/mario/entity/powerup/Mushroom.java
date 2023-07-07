package com.main.mario.entity.powerup;

import com.main.mario.Game;
import com.main.mario.Handler;
import com.main.mario.Id;
import com.main.mario.entity.Entity;

import java.awt.*;

public class Mushroom extends Entity {

    public Mushroom( int x, int y, int width, int height, boolean solid, Id id, Handler handler ) {
        super( x, y, width, height, solid, id, handler );
    }

    //===========================================//
    // Parent override methods
    //==========================================//
    @Override
    public void render( Graphics g ) {
        g.drawImage( Game.mushroom.getBufferedImage(), x, y, width, height, null );
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }
}
