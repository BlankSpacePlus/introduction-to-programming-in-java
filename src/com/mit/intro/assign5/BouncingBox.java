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
        // Draw the object
        surface.setColor(this.color);
        surface.fillRect(this.x - SIZE / 2, this.y - SIZE / 2, SIZE, SIZE);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawRect(this.x - SIZE / 2, this.y - SIZE / 2, SIZE, SIZE);
        surface.setColor(Color.GREEN);
        surface.fillArc(this.x - SIZE * 2, this.y + SIZE * 2, SIZE * 3, SIZE * 2, 30, 80);
        surface.setColor(Color.MAGENTA);
        surface.fillRoundRect(this.x - SIZE * 7, this.y + SIZE * 6, SIZE * 3, SIZE * 3 / 2, 10, 45);
        // Move the center of the object each time we draw it
        this.x += xDirection;
        this.y += yDirection;
        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck" rather than moving in the right direction
        if ((this.x - SIZE / 2 <= 0 && this.xDirection < 0) || (this.x + SIZE / 2 >= SimpleDraw.WIDTH && this.xDirection > 0)) {
            this.xDirection = -this.xDirection;
        }
        if ((this.y - SIZE / 2 <= 0 && this.yDirection < 0) || (this.y + SIZE / 2 >= SimpleDraw.HEIGHT && this.yDirection > 0)) {
            this.yDirection = -this.yDirection;
        }
        surface.setColor(Color.PINK);
        surface.fillOval(this.x + SIZE, this.y + SIZE, SIZE * 3 / 2, SIZE);
        surface.setColor(Color.BLACK);
        surface.drawOval(this.x + SIZE, this.y + SIZE, SIZE * 3 / 2, SIZE);
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        this.xDirection = xIncrement;
        this.yDirection = yIncrement;
    }

}
