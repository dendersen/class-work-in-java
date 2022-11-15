package dk.mtdm;
import dk.mtdm.playerObjects.CardObject;
import processing.core.PApplet;

public class Tests {
  public static String errors = "";
  public static void main(String[] args) {
    System.out.println();
    ansiTest();
    ansiColors.white();
    CardStandard();
    CardNull();
    ansiColors.reset();
    System.out.println(errors);
    System.exit(0);
  }
  
  public static void CardNull(){
    ansiColors.white();
    System.out.println("\nstarting CardNull test suit!\n");
    CardObject testCard = null;
    try {
      try {
        ansiColors.white();
        System.out.print("creation:\t");
        testCard = new CardObject(3,2,null);
        ansiColors.green();
        System.out.println("[SUCCES]");
      } catch (Exception e) {
        ansiColors.red();
        System.out.println("[FAILED]");
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
      }

      try {
        ansiColors.white();
        System.out.print("numTest:\t");
        if (testCard.getNumber() != 3){
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }

      try {
        ansiColors.white();
        System.out.print("symTest:\t");
        if(testCard.getSymbol() != 2){
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }
      
      try {
        ansiColors.white();
        System.out.print("letterTest:\t");
        if (testCard.letterTest()) {
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }

      try {
        ansiColors.white();
        System.out.print("NumStr:\t\t");
        if (testCard.getNumberString() != "") {
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }
    }catch(Exception e){
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        System.out.println("\n[CRITICAL ERROR]\n\t unchaught error in CardNull test suit");
      System.out.println(e);
      e.printStackTrace();
    }
  }
  
  public static void CardStandard(){
    ansiColors.white();
    System.out.println("\nstarting CardStandard test suit!\n");
    String[] processingArgs = {"TestSketch"};
    PApplet draw = new TestSketch();
    PApplet.runSketch(processingArgs,draw);
    CardObject testCard = null;
    try {
      try {
        ansiColors.white();
        System.out.print("creation:\t");
        testCard = new CardObject(3,2,draw);
        ansiColors.green();
        System.out.println("[SUCCES]");
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[FAILED]");
      }

      try {
        ansiColors.white();
        System.out.print("numTest:\t");
        if (testCard.getNumber() != 3){
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }

      try {
        ansiColors.white();
        System.out.print("symTest:\t");
        if(testCard.getSymbol() != 2){
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }
      
      try {
        ansiColors.white();
        System.out.print("letterTest:\t");
        if (testCard.letterTest()) {
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }

      try {
        ansiColors.white();
        System.out.print("NumStr:\t\t");
        if (testCard.getNumberString() != "") {
          ansiColors.red();
          System.out.println("[FAILED]");
        }else{
          ansiColors.green();
          System.out.println("[SUCCES]");
        }
      } catch (Exception e) {
        errors += e.getMessage() + "\n" + pullStackTrace(e) + "\n\n";
        ansiColors.red();
        System.out.println("[CRITICAL ERROR!!!]");
      }
    }catch(Exception e){
      System.out.println("\n[CRITICAL ERROR]\n\t unchaught error in CardNull test suit");
      System.out.println(e);
      e.printStackTrace();
    }
    draw.exitCalled();
  }
  
  public static void ansiTest() {
    System.out.println("\nstarting ansi test");
    ansiColors.blue();
    System.out.println("blue");
    ansiColors.cyan();
    System.out.println("cyan");
    ansiColors.green();
    System.out.println("green");
    ansiColors.purple();
    System.out.println("purple");
    ansiColors.red();
    System.out.println("red");
    ansiColors.reset();
    System.out.println("standard");
    ansiColors.white();
    System.out.println("white");
    ansiColors.yellow();
    System.out.println("yellow");
    ansiColors.reset();

    ansiColors.allTest();
    ansiColors.reset();
    System.out.println();
  }
  
  public static String pullStackTrace(Exception e) {
    String out  = "";
    StackTraceElement[] stack = e.getStackTrace();
    for (int i = 0; i < stack.length;i++){
      out += stack[i].toString() + "\n";
    }
    return out;
  }
}
