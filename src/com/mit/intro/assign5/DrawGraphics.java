package com.mit.intro.assign5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawGraphics {

    private List<BouncingBox> boxList;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        this.boxList = new ArrayList<>();
        BouncingBox box1 = new BouncingBox(200, 50, Color.RED);
        box1.setMovementVector(-1, 2);
        this.boxList.add(box1);
        BouncingBox box2 = new BouncingBox(100, 100, Color.BLUE);
        box2.setMovementVector(2, -1);
        this.boxList.add(box2);
        BouncingBox box3 = new BouncingBox(0, 70, Color.YELLOW);
        box3.setMovementVector(1, 1);
        this.boxList.add(box3);
        BouncingBox box4 = new BouncingBox(50, 100, Color.MAGENTA);
        box4.setMovementVector(-3, -1);
        this.boxList.add(box4);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        this.boxList.get(0).drawRec(surface);
        this.boxList.get(1).drawRoundRect(surface);
        this.boxList.get(2).drawOval(surface);
        this.boxList.get(3).drawArc(surface);
    }

}
