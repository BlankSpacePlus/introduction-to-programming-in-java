package com.mit.intro.assign5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays a window and delegates drawing to DrawGraphics.
 */
public class SimpleDraw extends JPanel implements Runnable {

    private static final long serialVersionUID = -7469734580960165754L;

    private final int FRAME_DELAY = 50; // 50 ms = 20 FPS

    public static final int WIDTH = 300;

    public static final int HEIGHT = 300;

    private boolean animate;

    private DrawGraphics draw;

    public SimpleDraw(DrawGraphics drawer) {
        this.animate = true;
        this.draw = drawer;
    }

    /**
     * Paint callback from Swing. Draw graphics using g.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Enable anti-aliasing for better looking graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.draw.draw(g2);
    }

    /**
     * Enables periodic repaint calls.
     */
    public synchronized void start() {
        this.animate = true;
    }

    /**
     * Pauses animation.
     */
    public synchronized void stop() {
        this.animate = false;
    }

    private synchronized boolean animationEnabled() {
        return this.animate;
    }

    @Override
    public void run() {
        while (true) {
            if (animationEnabled()) {
                repaint();
            }
            try {
                Thread.sleep(FRAME_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        final SimpleDraw content = new SimpleDraw(new DrawGraphics());
        JFrame frame = new JFrame("Graphics!");
        Color bgColor = Color.WHITE;
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
        content.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setContentPane(content);
        frame.setResizable(false);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
                content.start();
            }
            @Override
            public void windowIconified(WindowEvent e) {
                content.stop();
            }
        });
        new Thread(content).start();
        frame.setVisible(true);
    }

}