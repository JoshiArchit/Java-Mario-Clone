package com.main.mario.entity;

import com.main.mario.Game;
import com.main.mario.Handler;
import com.main.mario.Id;
import com.main.mario.tile.Tile;

import java.awt.*;

public class Player extends Entity{

    private int frame = 0;
    private int frameDelay = 0;

    private boolean animate = false;
    public Player( int x, int y, int width, int height, boolean solid, Id id, Handler handler ) {
        // Use entity class constructor
        super( x, y, width, height, solid, id, handler );

        //TODO: 7/6/2023 : Maybe remove later
        this.falling = true;
    }

    @Override
    public void render( Graphics g ) {
        //g.drawImage( Game.player.getBufferedImage(), x, y, width, height, null); // For single entity
        if(facing == 0) {
            g.drawImage( Game.player[0].getBufferedImage(), x, y, width, height, null);
        } else if(facing == 1){
            g.drawImage( Game.player[frame+3].getBufferedImage(), x, y, width, height, null);
        } else {
            g.drawImage( Game.player[frame+1].getBufferedImage(), x, y, width, height, null);
        }
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // Adjust to window bounds
        if (x <= 0) x =0;
        if (y+height >= 771) y = 771 - height;

        // Animate
        if (velX != 0) animate = true;
        else animate = false;

        for( Tile t:handler.tile) {
            if(!t.solid) break;
            if(t.getId() == Id.wall) {
                if(getBoundsTop().intersects( t.getBounds() )) {
                    setVelY( 0 );
//                    y = t.getY() + t.height;
                    if(jumping) {
                        jumping = false;
                        gravity = 1.0;
                        falling = true;
                    }
                }

                if(getBoundsBottom().intersects( t.getBounds() )) {
                    setVelY( 0 );
                    y = t.getY() - t.height;
                    if(falling) falling = false;
                } else {
                    if(!falling && !jumping) {
                        gravity = 0.0;
                        falling = true;
                    }
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

        if(jumping) {
            // gravity -= 0.5;
            gravity -= 0.5;
            setVelY( (int) -gravity );
            if(gravity <= 0.0) {
                jumping = false;
                falling = true;
            }
        }

        if(falling) {
            // gravity += 0.1;
            gravity += 0.5;
            setVelY( (int) gravity );
        }

        if(animate) {
            frameDelay ++;
            if(frameDelay >= 3) {
                frame ++;
                if(frame >= 2) {
                    frame = 0;
                }
                frameDelay = 0;
            }
        }

    }
}
