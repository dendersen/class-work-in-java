package dk.mtdm;

public class ansiColors {
  public static void green() {
    System.out.print("\u001b[32m");
  }
  public static void red() {
    System.out.print("\u001b[31m");
  }
  public static void white() {
    System.out.print("\u001b[37m");
  }
  public static void reset() {
    System.out.print("\u001b[0m");
  }
  public static void blue() {
    System.out.print("\u001b[34m");
  }
  public static void yellow() {//incorrect
    System.out.print("\u001b[38;5;220m");
  }
  public static void purple() {
    System.out.print("\u001b[35m");
  }
  public static void cyan() {//incorrect
    System.out.print("\u001b[38;5;73m");
  }
  public static void allTest(){
    for (int i = 0; i < 255; i++) {
      System.out.print("\u001b[38;5;" + i + "mT");
    }
    reset();
    for (int i = 0; i < 255; i++) {
      System.out.print("\u001b[48;5;" + i + "mT");
    }
    reset();
  }
  public static void redTest() {
    for (int i = 0; i < 255; i++) {
      System.out.print("\u001b[38;2;" + i + "mT");
    }
    reset();
    for (int i = 0; i < 255; i++) {
      System.out.print("\u001b[48;2;" + i + "mT");
    }
    reset();
  }
  /**
   * 
   * @param highlighter
   * @param colorID not all standard colors work as intended, most colors above 7 work as expected
   */
  public static void setSpecificAnsi(boolean highlighter,int colorID){
    if(highlighter){
      System.out.print("\u001b[48;5;" + colorID + "m");
    }else{
      System.out.print("\u001b[38;5;" + colorID + "m");
    }
  }
  public static void fakeRedAnsi(boolean highlighter, int gradiantPoint) {
    if(highlighter){
      System.out.print("\u001b[48;2;" + gradiantPoint + "m");
    }else{
      System.out.print("\u001b[38;2;" + gradiantPoint + "m");
    }
  }
}
/*
 * j = 2 is red
 * j = 5 is good
 */
