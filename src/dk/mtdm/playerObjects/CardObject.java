package dk.mtdm.playerObjects;

import processing.core.PImage;
import dk.mtdm.Main;
import dk.mtdm.visual.Buttons.Button;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class CardObject extends Button{

  private PImage Symbol;
  private PImage Letter;
  private final int symbol;
  private final int number;
  private final String path = "src/dk/mtdm/assets/data/";
  private PGraphics g = null;
  private boolean isClicked = false;

  public CardObject(int number, int symbol, PApplet p) {
    super("",0,0,0,0,p);
    
    this.number = number;
    this.symbol = symbol;
    // System.out.println(toString());
    if (p != null){
      this.g = p.getGraphics();
      Symbol = p.loadImage(path + getSymbolString() + ".png");
      if (!letterTest()) {
        Letter = p.loadImage(path + "blank.png");
      } else {
        Letter = p.loadImage(path + getColorString() + "_" + getNumberString() + ".png");
      }
    }
  }

  public void draw(int x,int y, int height,PGraphics g){
    draw(g, x, y, height/2, height );
  }

  public void draw(PGraphics g, int x,int y, int width){
    draw(g, x, y, width, width*2);
  }

  public void draw(PGraphics g, int x, int y, int width, int height) {
    this.g = g;
    reCalc("", x, y, width, height);
    
    float textSize = ((float) (height / 2)) * 0.25f;
    g.push();
    g.fill(255);
    g.rect(x, y, width, height);
    g.image(Symbol, x, y, width, height / 2);
    g.fill(0);

    g.textSize(textSize);

    g.image(Letter, x, y + height / 2, width, height / 2);
    if (!letterTest()) {
      g.textAlign(PConstants.CENTER, PConstants.CENTER);
      g.text(getNumberChar(), x, y + height / 2, width, height / 2);
    }
    g.line(x, y + height / 2, x + width, y + height / 2);
    g.pop();
  }

  public int getNumber() {
    return number;
  }

  public int getSymbol() {
    return symbol;
  }

  public String getSymbolString() {
    String string = "";
    switch (getSymbol()) {
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

  public String getColorString() {
    String string = "";
    switch (getSymbol()) {
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

  public Boolean letterTest() {
    switch (getNumber()) {
      case 1:
      case 11:
      case 12:
      case 13:
      case 14:
        return true;
      default:
        return false;
    }
  }

  public String getNumberChar() {
    String string = "";
    switch (getNumber()) {
      case 0:
        string = "j";
        break;
      case 1:
      case 11:
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
      case 12:
        string = "B";
        break;
      case 13:
        string = "D";
        break;
      case 14:
        string = "K";
        break;
    }
    return string;
  }

  public String getNumberString() {
    switch (getNumber()) {
      case 1:
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

  @Override
  public void clicked() {
    if(!checkBounds()) return;
    g.push();
    g.noFill();
    g.strokeWeight(5);
    g.stroke(0, 0, 255);
    g.rect(x,y,w,h);
    g.pop();
    if (!isClicked) {
      isClicked = true;
      return;
    }
    g.push();
    g.noFill();
    g.strokeWeight(5);
    g.stroke(Main.backgroundColor[0],Main.backgroundColor[1],Main.backgroundColor[2]);
    g.rect(x,y,w,h);
    g.pop();
    draw(g, x, y, w);
    isClicked = false;
  }

  @Override
  public void hover() {
    if (checkBounds())
    System.out.println("Test");
  }
  public String toString(){
    String out = "";
    out += "[" + getNumberChar() + ",";
    out += getSymbolString() + " || ";
    out += getNumber() + ",";
    out += getSymbol() + "]";
    return out;
  }
}


