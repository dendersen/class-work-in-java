package dk.mtdm.visual;

import java.util.ArrayList;

import dk.mtdm.playerObjects.CardObject;
import dk.mtdm.visual.Buttons.Button;
import dk.mtdm.visual.Buttons.StartButton;
import processing.core.PApplet;

public class Sketch extends PApplet {
    StartButton startButton;
    CardObject test;
    ArrayList <Button>  drawable =  new ArrayList<Button>();
    ArrayList <Button> Clickable =  new ArrayList<Button>();
    ArrayList <Button> hoverable =  new ArrayList<Button>();

    public Sketch() {
        startButton = new StartButton("Start", 100, 100, 100, 100, this);
    }

    @Override
    public void setup() {
        background(10, 150, 20);
        test = new CardObject(2, 1, this);
    }

    @Override
    public void draw() {
        startButton.show(g);
        startButton.hover();
        test.hover();
        test.draw(g, 200, 200, 100, 200);
    }

    public void drawActiveButton(){

    }

    public void hoverActiveButton(){

    }
    
    @Override
    public void mouseClicked() {
        startButton.clicked();
        test.clicked();
    }

    @Override
    public void settings() {
        size(1000, 800);
    }


}
