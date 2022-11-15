package dk.mtdm.visual;

import java.util.ArrayList;

import dk.mtdm.gameLogic.Game;
import dk.mtdm.playerObjects.CardObject;
import dk.mtdm.visual.Buttons.Button;
import dk.mtdm.visual.Buttons.LockButton;
import dk.mtdm.visual.Buttons.StartButton;
import dk.mtdm.visual.Buttons.UnLockButton;
import processing.core.PApplet;

public class Sketch extends PApplet {
    StartButton startButton;
    LockButton lockButton;
    UnLockButton unLockButton;
    static final int cardWidth = 75;
    ArrayList <Button>  drawable =  new ArrayList<Button>();
    ArrayList <Button> Clickable =  new ArrayList<Button>();
    ArrayList <Button> hoverable =  new ArrayList<Button>();

    public Sketch() {}

    @Override
    public void setup() {
        background(10, 150, 20);
        startButton = new StartButton("Start", width / 2 - 200, height / 2 - 100, 400, 200, this);

        // TODO Change pos/size of button
        lockButton = new LockButton("Lock", 100, 100, 100, 100, this);
        unLockButton = new UnLockButton("UnLock", 200, 200, 100, 100, this);
    }

    @Override
    public void draw() {
        switch(Game.gameState) {
            case awaitAction:
            line(width/ 2,0, width /2 , height);
                // lockButton.show(g);
                // unLockButton.show(g);
                // lockButton.hover();
                // unLockButton.hover();
            break;
            case playing:
                background(10, 150, 20);
                Game.runTurn(g,cardWidth);
                break;
            case start:
                startButton.show(g);
                startButton.hover();
                break;
            default:
                break;
        }
    }

    public void drawActiveButton(){

    }

    public void hoverActiveButton(){

    }
    
    @Override
    public void mouseClicked() {
        switch(Game.gameState){
            case awaitAction:
                lockButton.clicked();
                unLockButton.clicked();
                ArrayList<CardObject> screenCards = Game.getScreenCards();
                for (int i = 0; i < screenCards.size(); i++) {
                    screenCards.get(i).hover();
                }
                break;
            case playing:
                break;
            case start:
                startButton.clicked();
                break;
            default:
                break;
        }
    }

    @Override
    public void settings() {
        size(1200, 600);
    }


}
