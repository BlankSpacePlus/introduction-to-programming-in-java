package com.mit.intro.assign5;

import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {

    private BouncingBox box;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        this.box = new BouncingBox(200, 50, Color.RED);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        this.box.draw(surface);
        this.box.setMovementVector(2, 2);
    }

}
