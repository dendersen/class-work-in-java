package dk.mtdm.playerObjects;

import java.util.ArrayList;

import processing.core.PGraphics;

public class Board {
    CardObject[] middelcards;
    ArrayList<CardObject> deck;
    Player[] players;
    final int sizeOfSet = 52;
    final int numberOfSymbols = 4;
    final int highestCardNumber = 14;

    public Board(int numberOfPlayers,int numberOfCardSets) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(i);
        }
        deck = deckGen(numberOfCardSets);
        shuffle();
    }
    private void shuffle(){
    }
    
    private ArrayList<CardObject> deckGen(int  numberOfCardSets){
        ArrayList<CardObject> out = new ArrayList<CardObject>();
        out.ensureCapacity(numberOfCardSets*sizeOfSet);
        
        for (int i = 0; i < numberOfCardSets; i++) {
            for (int j = 1; j <= numberOfSymbols; j++) {
                for (int l = 2; l <=highestCardNumber ; l++) {
                    out.add(new CardObject(l, l, null));
                }
            }
        }
        
        
        return out;
    }
    public void setMiddelCards(CardObject[] cards) {
        middelcards = cards;
    }

    public void show(PGraphics g) {
        for (int i = 0; i < middelcards.length; i++) {
        int sqr = (int) Math.sqrt(middelcards.length);
        
        }
    }
}
