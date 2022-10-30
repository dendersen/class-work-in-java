package dk.mtdm.visual.Buttons;

import dk.mtdm.visual.Button;

public class StartButton extends Button {

    public StartButton(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void clicked() {
        System.out.println("Test");
    }

}
