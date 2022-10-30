package dk.mtdm.storage.Game;

import java.util.ArrayList;

import dk.mtdm.storage.CardObject;

public class Player {
  int playerID;
  ArrayList<CardObject> hand = new ArrayList<CardObject>();
  int points = 0;
  boolean hasTieBreaker = false; // if two winning players have same point value the winner of the entire game is the one with the tie breaker
  public Player(int id){
    playerID = id;
  }
  public void addCars(ArrayList<CardObject> newCards){
    hand.addAll(newCards);
  }
  public CardObject removeCard(cardIndex){
    
  }
}
