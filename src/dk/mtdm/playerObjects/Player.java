package dk.mtdm.playerObjects;

import java.util.ArrayList;

import dk.mtdm.gameLogic.Game;

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
}
