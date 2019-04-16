package BORK;
/**
 * Write a description of class GameTest here.
 *
 * @author Robert Collins
 * @version 1
 */

public class GameTest {

  /** Main game test. */
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
