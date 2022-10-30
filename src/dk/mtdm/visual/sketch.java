package dk.mtdm.visual;

import dk.mtdm.visual.Buttons.StartButton;
import processing.core.PApplet;

public class Sketch extends PApplet {
    Button button;

    public Sketch() {
        button = new StartButton(100, 100, 100, 100);
    }

    public void setup() {
        background(10, 150, 20);
    }

    public void draw() {
        button.show(g);
        button.hover(this);
    }

    @Override
    public void settings() {
        size(1000, 800);
    }
}
