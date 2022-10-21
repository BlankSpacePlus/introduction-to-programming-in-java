package com.mit.intro.assign6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval implements Sprite {

    private int width;

    private int height;

    private Color color;

    /**
     * Create a box that has dimensions width and height, filled with startColor.
     */
    public Oval(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics surface, int x, int y) {
        // Draw the object
        surface.setColor(this.color);
        surface.fillOval(x, y, this.width, this.height);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, this.width, this.height);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

}
