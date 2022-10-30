package dk.mtdm.visual.Buttons;

import dk.mtdm.visual.Button;
import processing.core.PApplet;

public class StartButton extends Button {

    public StartButton(String txt, int x, int y, int w, int h, PApplet p) {
        super(txt, x, y, w, h, p);
    }

    public void clicked() {
        if (checkBounds())
            System.out.println("Test");
    }

}
