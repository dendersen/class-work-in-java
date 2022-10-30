package dk.mtdm.visual;

import processing.core.PApplet;
import processing.core.PGraphics;
import java.awt.Rectangle;

public abstract class Button {
    private int h;
    private int w;
    private int y;
    private int x;
    private int backgroundColor = 255;
    private final Rectangle bounds;

    public Button(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.bounds = new Rectangle(x, y, w, h);
    }

    public void show(PGraphics g) {
        g.push();
        g.fill(backgroundColor);
        g.rect(x, y, w, h);
        g.pop();
    }

    // public abstract void clicked();

    private boolean checkBounds(PApplet p) {
        if (bounds.contains(p.mouseX, p.mouseY)) {
            return true;
        } else {
            return false;
        }
    }

    public void hover(PApplet g) {
        if (checkBounds(g)) {
            backgroundColor = 220;
        } else {
            backgroundColor = 255;
        }
    }
}
