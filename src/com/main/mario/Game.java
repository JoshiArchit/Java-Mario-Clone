package com.main.mario;
import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable{
    // Frame variables
    public static final int WIDTH = 270;
    public static final int HEIGHT = WIDTH/14*10;
    public static final int SCALE = 4;
    public static final String TITLE = "Super Mario";

    // Game loop threads
    private Thread thread;
    private boolean running = false;

    // TODO: 6/23/2023 : ADD JFRAME Code
    private void jFrame() {
        // Move frame code here to reduce clutter in main()
    }

    private synchronized void start() {
        if(running) return;

        running = true;
        thread = new Thread(this, "Thread");
        thread.start();
    }

    private synchronized void stop() {
        if(!running) return;

        running = false;
        try {
            thread.join(); // Join with main thread and continue main()
        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }
    }

    // TODO: Research run() method
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        double delta = 0.0;
        double ns = 1000000000.0/60.0;

        int frames = 0;
        int ticks = 0;

        while(running) {
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames + " fps " + ticks + " updates per second");
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

    public void render() {

    }


    public void tick() {

    }



    // Constructor
    public Game() {
        Dimension size = new Dimension( WIDTH*SCALE, HEIGHT*SCALE );
        setPreferredSize( size );
        setMaximumSize( size );
        setMinimumSize( size );
    }

    public static void main( String[] args ) {
        Game game = new Game();

        // Move to frames method
        JFrame frame = new JFrame( TITLE );
        frame.add( game );
        frame.pack();
        frame.setResizable( false );
        frame.setLocationRelativeTo( null );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );

        game.start();
    }
}
