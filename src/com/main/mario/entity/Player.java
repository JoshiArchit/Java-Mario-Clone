package com.main.mario.entity;

import com.main.mario.Handler;
import com.main.mario.Id;
import com.main.mario.tile.Tile;

import java.awt.*;

public class Player extends Entity{
    public Player( int x, int y, int width, int height, boolean solid, Id id, Handler handler ) {
        // Use entity class constructor
        super( x, y, width, height, solid, id, handler );
    }

    @Override
    public void render( Graphics g ) {
        g.setColor( Color.BLUE );
        g.fillRect( x, y, width, height );
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // Adjust to window bounds
        if (x <= 0) x =0;
        if (y <= 0) y =0;
        if (x+width >= 1080) x = 1080 - width;
        if (y+height >= 771) y = 771 - height;

        for( Tile t:handler.tile) {
            if(!t.solid) break;
            if(t.getId() == Id.wall) {
                if(getBoundsTop().intersects( t.getBounds() )) {
                    setVelY( 0 );
                    y = t.getY() + t.height;
                }
                if(getBoundsBottom().intersects( t.getBounds() )) {
                    setVelY( 0 );
                    y = t.getY() - t.height;
                }
                if(getBoundsLeft().intersects( t.getBounds() )) {
                    setVelX( 0 );
                    x = t.getX()+t.width;
                }
                if(getBoundsLeft().intersects( t.getBounds() )) {
                    setVelX( 0 );
                    x = t.getX() - t.width;
                }
            }
        }
    }
}
