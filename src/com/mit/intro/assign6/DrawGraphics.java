package com.mit.intro.assign6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawGraphics {

    private List<Bouncer> movingSpriteList;

    private List<StraightMover> straightMoverList;

    /**
     * Initializes this class for drawing.
     */
    public DrawGraphics() {
        this.movingSpriteList = new ArrayList<>();
        Sprite box1 = new Rectangle(15, 20, Color.RED);
        Bouncer bouncer1 = new Bouncer(100, 170, box1);
        bouncer1.setMovementVector(3, 1);
        this.movingSpriteList.add(bouncer1);
        Sprite box2 = new Oval(30, 20, Color.GREEN);
        Bouncer bouncer2 = new Bouncer(50, 80, box2);
        bouncer2.setMovementVector(-2, -4);
        this.movingSpriteList.add(bouncer2);
        this.straightMoverList = new ArrayList<>();
        Sprite box3 = new Rectangle(15, 20, Color.YELLOW);
        StraightMover mover1 = new StraightMover(120, 190, box3);
        mover1.setMovementVector(3, 1);
        this.straightMoverList.add(mover1);
        Sprite box4 = new Oval(30, 20, Color.BLUE);
        StraightMover mover2 = new StraightMover(70, 100, box4);
        mover2.setMovementVector(-2, -4);
        this.straightMoverList.add(mover2);
    }

    /**
     * Draw the contents of the window on surface.
     */
    public void draw(Graphics surface) {
        for (Bouncer bouncer : this.movingSpriteList) {
            bouncer.draw(surface);
        }
        for (StraightMover mover : this.straightMoverList) {
            mover.draw(surface);
        }
    }

}
