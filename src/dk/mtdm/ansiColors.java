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

    // for (int i = 0; i < 255; i++) {
    //   for (int j = 0; j < 255; j++) {
    //     System.out.print("\u001b[38;" + 2 +";" + i + "m");
    //     System.out.print("\u001b[48;" + 2 +";" + j + "mT");
    //   }
    //   reset();
    //   System.out.println();
    // }
    for (int i = 0; i < 255; i++) {
      System.out.print("\u001b[38;5;" + i + "mT");
    }
    reset();
    for (int i = 0; i < 255; i++) {
      System.out.print("\u001b[48;5;" + i + "mT");
    }
    reset();
  }
}
/*
 * j = 2 is red
 * j = 5 is good
 */
