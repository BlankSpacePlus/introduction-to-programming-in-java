package com.mit.intro.assign6;

import java.awt.Graphics;

public class Bouncer implements Mover {

    private int x;

    private int y;

    private int xDirection;

    private int yDirection;

    private Sprite sprite;

    /**
     * Create a Bouncer that positions sprite at (startX, startY).
     */
    public Bouncer(int startX, int startY, Sprite sprite) {
        this.x = startX;
        this.y = startY;
        this.sprite = sprite;
    }

    /**
     * Starts moving the object in the direction (xIncrement, yIncrement).
     */
    @Override
    public void setMovementVector(int xIncrement, int yIncrement) {
        this.xDirection = xIncrement;
        this.yDirection = yIncrement;
    }

    /**
     * Draws the sprite at its current position on to surface.
     */
    @Override
    public void draw(Graphics surface) {
        // Draw the sprite
        this.sprite.draw(surface, this.x, this.y);
        // Move the object each time we draw it
        this.x += this.xDirection;
        this.y += this.yDirection;
        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((this.x <= 0 && this.xDirection < 0) || (this.x + this.sprite.getWidth() >= SimpleDraw.WIDTH && this.xDirection > 0)) {
            this.xDirection = -this.xDirection;
        }
        if ((this.y <= 0 && this.yDirection < 0) || (this.y + this.sprite.getHeight() >= SimpleDraw.HEIGHT && this.yDirection > 0)) {
            this.yDirection = -this.yDirection;
        }
    }

}
