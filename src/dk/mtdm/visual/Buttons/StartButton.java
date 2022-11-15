package dk.mtdm.visual.Buttons;

import dk.mtdm.gameLogic.Game;
import dk.mtdm.gameLogic.GameStates;
import processing.core.PApplet;

public class StartButton extends Button {

    public StartButton(String txt, int x, int y, int w, int h, PApplet p) {
        super(txt, x, y, w, h, p);
    }

    public void clicked() {
        if (checkBounds()){
            // TODO remove hard code of numberOfPlayers
            Game.gameState = GameStates.playing;
            Game.startGame(2, p);
        }
    }

}
