package dk.mtdm.playerObjects;

import java.util.ArrayList;

import dk.mtdm.gameLogic.Game;
import processing.core.PGraphics;

public class Player {
  private int playerID;
  private ArrayList<CardObject> hand = new ArrayList<CardObject>();
  private int points = 0;
  public boolean hasTieBreaker = false; // if two winning players have same point value the winner of the entire game is the one with the tie breaker
  public Player(int id){
    playerID = id;
  }
  public void addCards(ArrayList<CardObject> newCards){
    hand.addAll(newCards);
  }
  public void addCard(CardObject newCard){
    hand.add(newCard);
  }
  public CardObject removeCard(int cardIndex){
    return hand.remove(cardIndex);
  }
  public int getPoints(){
    return points;
  }
  public int getPlayerID(){
    return playerID;
  }
  public void collectWinnings(ArrayList<CardObject> winnings){
    for (CardObject card : winnings) {
      if(Game.isPointCard(card)){
        points++;
      }
      if(Game.istieBreaker(card)){
        hasTieBreaker = true;
      }
    }
  }
  public void show(PGraphics g, int cardWidth){
    // TODO make it better, plus change y
    int offSet = 20;
    int startX = g.width/2 - (cardWidth+offSet)/2 * hand.size() + offSet/2;
    for (int i = 0; i < hand.size(); i++) {
      hand.get(i).draw(g, startX + (offSet+cardWidth) * i, g.height - cardWidth*4, cardWidth);
    }
  }
  public boolean hasCards(){
    return hand.size() > 0;
  }
  public ArrayList<CardObject> getHand(){
    return (ArrayList<CardObject>) hand.clone();
  }
}
