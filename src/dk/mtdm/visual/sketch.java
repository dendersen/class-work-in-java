package dk.mtdm.visual;

import dk.mtdm.visual.Buttons.StartButton;
import processing.core.PApplet;

public class Sketch extends PApplet {
    StartButton startButton;

    public Sketch() {
        startButton = new StartButton(100, 100, 100, 100, this);
    }

    @Override
    public void setup() {
        background(10, 150, 20);
    }

    @Override
    public void draw() {
        startButton.show(g);
        startButton.hover();
    }

    @Override
    public void mouseClicked() {
        startButton.clicked();
    }

    @Override
    public void settings() {
        size(1000, 800);
    }
}
