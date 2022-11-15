package dk.mtdm.playerObjects;

import java.util.ArrayList;
import java.util.Collections;

import dk.mtdm.gameLogic.Game;
import dk.mtdm.gameLogic.GameStates;
import processing.core.PApplet;
import processing.core.PGraphics;

public class Board {
    private ArrayList<CardObject> middelCards = new ArrayList<CardObject>();
    private ArrayList<CardObject> deck;
    private Player[] players;
    private final int sizeOfSet = 52;
    private final int numberOfSymbols = 4;
    private final int highestCardNumber = 14;
    private final int expectedNumberOfTurns = 3;
    private final int cardsPerTurn;
    private final int startNumberOfCards = 4;
    public int ActivePlayerID = 0;

    public Board(int numberOfPlayers, int numberOfCardSets, PApplet p) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(i);
        }
        deck = deckGen(numberOfCardSets,p);
        shuffle();
        cardsPerTurn = calcCardToPlayer(expectedNumberOfTurns);
        fillHand();
        {
            ArrayList<CardObject> temp = new ArrayList<CardObject>();
            for (int j = 0; j  < startNumberOfCards; j++){
                temp.add(deck.remove(0));
            }
            addMiddelCards(temp);
            // System.out.println(middelCards);
        }
    }
    private void fillHand() {
        if(deck.size() > cardsPerTurn * players.length){
            for (int i = 0; i < players.length; i++) {
                ArrayList<CardObject> temp = new ArrayList<CardObject>();
                for (int j = 0; j  < cardsPerTurn; j++){
                    temp.add(deck.remove(0));
                }
                players[i].addCards(temp);
            }
        }else{
            while (deck.size() > players.length){
                for (int i = 0; i < players.length;i++){
                    players[i].addCard(deck.remove(0));
                }
            } 
            addMiddelCards(deck);
            deck.clear();
        }
    }
    private int calcCardToPlayer(int turns) {
        return (int) (Math.floor(Math.floor((deck.size()-startNumberOfCards) / players.length) / turns));
        //number of cards given to players per round 
    }
    private void shuffle(){
        Collections.shuffle(deck);
    }
    
    private ArrayList<CardObject> deckGen(int  numberOfCardSets,PApplet p){
        ArrayList<CardObject> out = new ArrayList<CardObject>();
        out.ensureCapacity(numberOfCardSets*sizeOfSet);
        
        for (int i = 0; i < numberOfCardSets; i++) {
            for (int j = 1; j <= numberOfSymbols; j++) {
                for (int l = 2; l <=highestCardNumber ; l++) {
                    out.add(new CardObject(l, j, p));
                }
            }
        }
        
        
        return out;
    }
    public void addMiddelCards(ArrayList<CardObject> cards) {
        middelCards.addAll(cards);
    }
    public void removeMiddelCards(ArrayList<CardObject> cards){
        for (int i = 0; i < cards.size(); i++) {
            if(!middelCards.remove(cards.get(i))){
                System.out.println("could not find Card: \n" + cards.get(i).toString());
            }
        }
    }

    public void show(PGraphics g, int cardWidth){
        showMiddelCards(g,cardWidth);
        players[ActivePlayerID].show(g,cardWidth);
    }

    private void showMiddelCards(PGraphics g,int cardWidth) {
        // TODO make it better, plus change y
        int offSet = 20;
        // int startXOffset = g.width / 2 - ((middelCards.size() + offSet) * cardWidth) / 2 ;
        // for (int i = 0; i < middelCards.size(); i++) {
        //     middelCards.get(i).draw(g, startXOffset + i * (cardWidth + offSet), g.height - cardWidth*5 - offSet , cardWidth);
        // }

        int startX = g.width/2 - (cardWidth+offSet)/2 * middelCards.size() + offSet/2;
        for (int i = 0; i < middelCards.size(); i++) {
            middelCards.get(i).draw(g, startX + (offSet+cardWidth) * i, g.height - cardWidth*8, cardWidth);
        }
    }

    public ArrayList<CardObject> getMiddelCards() {
        return (ArrayList<CardObject>) middelCards.clone();
    }
    public Player[] getPlayers(){
        return players.clone();
    }

    public void turn(){
        if(ActivePlayerID > players.length){
            ActivePlayerID = 0;
            if(!players[0].hasCards()){
                fillHand();
            }
        }
        Game.gameState = GameStates.awaitAction;
    }
    public boolean performeAction(ArrayList<CardObject> pickedMiddelCards, CardObject activeCard){
        if (Game.SumCheck(pickedMiddelCards, activeCard)){
            return false;
        }
        players[ActivePlayerID].collectWinnings(pickedMiddelCards);
        return true;
    }
}