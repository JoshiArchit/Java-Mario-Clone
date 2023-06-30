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
                case KeyEvent.VK_W, KeyEvent.VK_UP -> entity.setVelY( -5 );
                case KeyEvent.VK_S, KeyEvent.VK_DOWN -> entity.setVelY( 5 );
                case KeyEvent.VK_A, KeyEvent.VK_LEFT -> entity.setVelX( -5 );
                case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> entity.setVelX( 5 );
            }
        }

    }

    @Override
    public void keyReleased( KeyEvent e ) {
        int key = e.getKeyCode();

        for( Entity entity : Game.handler.entity ) {
            switch ( key ) {
                case KeyEvent.VK_W, KeyEvent.VK_UP, KeyEvent.VK_S, KeyEvent.VK_DOWN -> entity.setVelY( 0 );
                case KeyEvent.VK_A, KeyEvent.VK_LEFT, KeyEvent.VK_D, KeyEvent.VK_RIGHT -> entity.setVelX( 0 );
            }
        }
    }
}
