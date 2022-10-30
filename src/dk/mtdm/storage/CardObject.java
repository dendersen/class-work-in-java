package dk.mtdm.storage;

import processing.core.PImage;
import processing.core.PApplet;
import processing.core.PGraphics;

public class CardObject {

  private final PImage Symbol;
  private final PImage Letter;
  private final int symbol;
  private final int number;
  
  public CardObject(int number, int symbol,PApplet p){
    this.number = number;
    this.symbol = symbol;
    Symbol = p.loadImage(getSymbolString() + ".png");
    if (!letterTest()){
    Letter = p.loadImage("blank.png");
    }else{
      Letter = p.loadImage(getSymbolString() + "_" + getNumberString() + ".png");
    }
  }
  
  public void draw(PGraphics g, int x, int y, int width, int height){
    g.fill(255, 255, 255);
    g.rect(x, y, width, height);
    g.image(Symbol,x,y,x+width,y+height/2);
    g.image(Letter,x,y,x+width,y+height/2);
    if (!letterTest()){
      g.text(getNumberChar(), x+width/1.9f, y+height-g.textSize);
    }
  }
  
  public int getNumber(){
    return number;
  }
  
  public int getSymbol(){
    return symbol;
  }
  
  public String getSymbolString(){
    String string = "";
    switch (getSymbol()){
      case 1:
      string = "hjerter";
      break;
      case 2:
      string = "romber";
      break;
      case 3:
      string = "klør";
      break;
      case 4:
      string = "spar";
      break;
    }
    return string;
  }
  
  public String getColorString(){
    String string = "";
    switch (getSymbol()){
      case 1:
      case 2:
      string = "rød";
      break;
      case 3:
      case 4:
      string = "sort";
      break;
    }
    return string;
  }
  
  public Boolean letterTest(){
    switch(getNumber()){
      case 1:
      case 11:
      case 12:
      case 13:
        return true;
      default:
        return false;
    }
  }
  
  public String getNumberChar(){
    String string = "";
    switch(getNumber()){
      case 0: 
      string = "j";
      break;
      case 1:
      string = "A";
      break;
      case 2:
      string = "2";
      break;
      case 3:
      string = "3";
      break;
      case 4:
      string = "4";
      break;
      case 5:
      string = "5";
      break;
      case 6:
      string = "6";
      break;
      case 7:
      string = "7";
      break;
      case 8:
      string = "8";
      break;
      case 9:
      string = "9";
      break;
      case 10:
      string = "X";
      break;
      case 11:
      string = "B";
      break;
      case 12:
      string = "D";
      break;
      case 13:
      string = "K";
      break;
    }
    return string;
  }
  
  public String getNumberString(){
    switch(getNumber()){
      case 1:
      return "es";
      case 11:
      return "es";
      case 12:
      return "bonde";
      case 13:
      return "dronning";
      case 14:
        return "konge";
      default:
      return "";
    }
  }
}
