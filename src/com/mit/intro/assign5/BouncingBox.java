package com.mit.intro.assign5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BouncingBox {

    private int x;

    private int y;

    private Color color;

    private int xDirection = 0;

    private int yDirection = 0;

    private final int SIZE = 20;

    /**
     * Initialize a new box with its center located at (startX, startY), filled with startColor.
     */
    public BouncingBox(int startX, int startY, Color startColor) {
        this.x = startX;
        this.y = startY;
        this.color = startColor;
    }

    /**
     * Draws the box at its current position on to surface.
     */
    public void draw(Graphics surface) {
        // Move the center of the object each time we draw it
        this.x += this.xDirection;
        this.y += this.yDirection;
        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck" rather than moving in the right direction
        if ((this.x <= 0 && this.xDirection < 0) || (this.x + SIZE >= SimpleDraw.WIDTH && this.xDirection > 0)) {
            this.xDirection = -this.xDirection;
        }
        if ((this.y <= 0 && this.yDirection < 0) || (this.y + SIZE >= SimpleDraw.HEIGHT && this.yDirection > 0)) {
            this.yDirection = -this.yDirection;
        }
    }

    public void drawRec(Graphics surface) {
        surface.setColor(this.color);
        surface.fillRect(this.x, this.y, SIZE, SIZE);
        this.draw(surface);
    }

    public void drawOval(Graphics surface) {
        surface.setColor(this.color);
        surface.fillOval(this.x, this.y, SIZE, SIZE);
        this.draw(surface);
    }

    public void drawRoundRect(Graphics surface) {
        surface.setColor(this.color);
        surface.fillRoundRect(this.x, this.y, SIZE, SIZE, 10, 45);
        this.draw(surface);
    }

    public void drawArc(Graphics surface) {
        surface.setColor(this.color);
        surface.fillArc(this.x, this.y, SIZE, SIZE, 30, 80);
        this.draw(surface);
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        this.xDirection = xIncrement;
        this.yDirection = yIncrement;
    }

}
