package dk.mtdm.gameLogic;

import java.util.ArrayList;

import dk.mtdm.playerObjects.Board;
import dk.mtdm.playerObjects.CardObject;
import dk.mtdm.playerObjects.Player;
import processing.core.PApplet;
import processing.core.PGraphics;

public class Game {
  static CardObject tieBreaker = new CardObject(2, 3, null);
  static boolean tieBreakerFound = false;
  public static GameStates gameState = GameStates.start;
  private static Board board;

  public static void startGame(int numberOfPlayers,PApplet p) {
    // TODO remove hard code of numberCardsSetes
    board = new Board(numberOfPlayers, 1, p);
  }

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
  public static void runTurn(PGraphics g, int cardWidth){
    board.show(g, cardWidth);
    board.turn();
  }
  public static void performeAction(ArrayList<CardObject> pickedMiddelCards, CardObject activeCard){
    if (board.performeAction(pickedMiddelCards, activeCard)){
    }
  }
  public static void drawTurn(PGraphics g, int cardWidth) {
    board.show(g, cardWidth);
    return;
  }

  public static ArrayList<CardObject> getScreenCards() {
    ArrayList <CardObject> b = board.getMiddelCards();
    b.addAll(board.getPlayers()[board.ActivePlayerID].getHand());
    return b;
  }

}
