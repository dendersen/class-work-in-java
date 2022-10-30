package dk.mtdm.visual;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
import java.awt.Rectangle;

public abstract class Button {
    private int h;
    private int w;
    private int y;
    private int x;
    private int backgroundColor = 255;
    private final Rectangle bounds;
    private PApplet p;
    private String txt;
    private float textSize;

    public Button(String txt, int x, int y, int w, int h, PApplet p) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.bounds = new Rectangle(x, y, w, h);
        this.p = p;
        this.txt = txt;
        this.textSize = ((float) (w / 2)) * 0.30f;
    }

    public void show(PGraphics g) {
        g.push();

        g.fill(backgroundColor);
        g.rect(x, y, w, h);

        g.textAlign(PConstants.CENTER, PConstants.CENTER);
        g.textSize(textSize);
        g.fill(0);
        g.text(txt, x, y, w, h);

        g.pop();
    }

    public abstract void clicked();

    protected boolean checkBounds() {
        if (bounds.contains(p.mouseX, p.mouseY)) {
            return true;
        } else {
            return false;
        }
    }

    public void hover() {
        if (checkBounds()) {
            backgroundColor = 220;
        } else {
            backgroundColor = 255;
        }
    }
}
