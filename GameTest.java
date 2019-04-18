package BORK;
/**
 * Write a description of class GameTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class GameTest {

  /** Test Case Main. */
  public static void main(String args[]) {
    Game g = new Game();
    System.out.println(g.getMessage());
    g.pickup();
    System.out.println(g.getMessage());
    g.move("south");
    System.out.println(g.getMessage());
    g.drop("book");
    System.out.println(g.getMessage());
    g.move("north");
    System.out.println(g.getMessage());
    g.move("south");
    System.out.println(g.getMessage());
    g.pickup();
    System.out.println(g.getMessage());
    if (g.gameOver()) {
      System.out.println(g.getMessage());
    }
  }
}
