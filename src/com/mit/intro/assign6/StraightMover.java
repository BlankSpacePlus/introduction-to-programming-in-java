package com.mit.intro.assign6;

import java.awt.Graphics;

public class StraightMover implements Mover {

    private int x;

    private int y;

    private int xDirection;

    private int yDirection;

    private Sprite sprite;

    /**
     * Create a Bouncer that positions sprite at (startX, startY).
     */
    public StraightMover(int startX, int startY, Sprite sprite) {
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
     * Draws the sprite at its current position on to graphics.
     */
    @Override
    public void draw(Graphics graphics) {
        this.sprite.draw(graphics, this.x, this.y);
        // Move the center of the object each time we draw it
        this.x += this.xDirection;
        this.y += this.yDirection;
    }

}
