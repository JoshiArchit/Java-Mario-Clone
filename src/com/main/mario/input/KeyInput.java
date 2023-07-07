package com.main.mario.input;

import com.main.mario.Game;
import com.main.mario.entity.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    @Override
    public void keyTyped( KeyEvent e ) {

    }

    @Override
    public void keyPressed( KeyEvent e ) {
        int key = e.getKeyCode();

        for( Entity entity : Game.handler.entity ) {
            switch ( key ) {
                case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                    if(!entity.jumping) {
                        entity.jumping = true;
                        // entity.gravity = 10.00;
                        entity.gravity = 20.0;
                    }
                }
                case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                    entity.facing = 1;
                    entity.setVelX( -5 );
                }
                case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                    entity.facing = 2;
                    entity.setVelX( 5 );
                }
            }
        }

    }

    @Override
    public void keyReleased( KeyEvent e ) {
        int key = e.getKeyCode();

        for( Entity entity : Game.handler.entity ) {
            switch ( key ) {
                case KeyEvent.VK_W, KeyEvent.VK_UP, KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                    entity.facing = 0;
                    entity.setVelY( 0 );
                }
                case KeyEvent.VK_A, KeyEvent.VK_LEFT, KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                    entity.facing = 0;
                    entity.setVelX( 0 );
                }
            }
        }
    }
}
