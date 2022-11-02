package dk.mtdm.gameLogic;

import java.util.ArrayList;

import dk.mtdm.playerObjects.CardObject;

public class Game {
  static CardObject tieBreaker = new CardObject(2, 3, null);
  static boolean tieBreakerFound = false;
  
  public static boolean SumCheck(ArrayList<CardObject> cards, CardObject hand){
    int sum = 0;
    int ace = 0;
    for (int i = 0; i < cards.size(); i++){
      if (cards.get(i).getNumberChar() == "A"){
        ace ++;
        sum += 11;
      }else{
        sum += cards.get(i).getNumber();
      }
    }
    if (sum == hand.getNumber()){
      return true;
    }else{
      return recursiveSumCheck(sum,hand.getNumber(),ace);
    }
  }
  
  private static boolean recursiveSumCheck(int sum, int total, int ace){
    if (total == 1) total = 11;
    if (sum == total){
      return true;
    }
    if (ace > 0){
      return recursiveSumCheck(sum-10, total, ace-1);
    }
    return false;
  }
  
  public static boolean isPointCard(CardObject card){
    return card.getNumber() == 1 || card.getNumber() > 9;
  }
  public static boolean istieBreaker(CardObject card){
    return !tieBreakerFound && card.getNumber() == tieBreaker.getNumber() && card.getSymbol() == tieBreaker.getSymbol();
  }
  public void runTurn(int playerID){
    
  }
  
}
