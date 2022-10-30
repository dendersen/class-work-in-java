package dk.mtdm.gameLogic;

import java.util.ArrayList;

import dk.mtdm.storage.CardObject;

public class Game {
  
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
}
