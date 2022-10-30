package dk.mtdm.playerObjects;

import processing.core.PGraphics;

public class Board {
    CardObject[] middelcards;
    Player[] players;

    public Board(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
    }

    public void setMiddelCards(CardObject[] cards) {
        middelcards = cards;
    }

    public void show(PGraphics g) {
        for (int i = 0; i < middelcards.length; i++) {
        }
    }
}
