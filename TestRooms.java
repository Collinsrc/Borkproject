package Bork;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestRooms {

	/*********************************************************************
	 * Method to test that a player is able to win the game
	 ********************************************************************/
	@Test
	public void testWinGame() {
		Game g = new Game();
		g.pickup();
		g.move("north");
		System.out.println(g.getMessage());
		g.pickup2();
		System.out.println(g.getMessage());
		g.move("west");
		System.out.println(g.getMessage());
		g.attack();
		System.out.println(g.getMessage());
		g.pickup();
		System.out.println(g.getMessage());
		g.move("east");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.move("east");
		System.out.println(g.getMessage());
		g.move("north");
		System.out.println(g.getMessage());
		g.attack();
		System.out.println(g.getMessage());
		g.pickup();
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.move("west");
		System.out.println(g.getMessage());
		g.move("west");
		System.out.println(g.getMessage());
		g.toss("Rock");
		System.out.println(g.getMessage());
		g.move("west");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.pickup();
		System.out.println(g.getMessage());
		g.move("north");
		System.out.println(g.getMessage());
		g.move("west");
		System.out.println(g.getMessage());
		g.attack();
		System.out.println(g.getMessage());
		g.pickup();
		System.out.println(g.getMessage());
		g.move("east");
		System.out.println(g.getMessage());
		g.move("east");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.slide("Keycard");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.pickup();
		System.out.println(g.getMessage());
		g.move("east");
		System.out.println(g.getMessage());
		g.open();
		System.out.println(g.getMessage());
		g.move("west");
		System.out.println(g.getMessage());
		g.move("north");
		System.out.println(g.getMessage());
		g.move("north");
		System.out.println(g.getMessage());
		g.move("north");
		System.out.println(g.getMessage());
		g.pickup2();
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.move("south");
		System.out.println(g.getMessage());
		g.attack();
		System.out.println(g.getMessage());
		System.out.println("__________________________________________________________________");
		System.out.println();
	}

	/*********************************************************************
	 * Method to test that a player is able to try moving west, but is blocked
	 * by an enemy.
	 ********************************************************************/
	@Test
	public void testMoveRooms1() {
		Game g = new Game();
		g.pickup();
		g.move("west");
		System.out.println("1 " + g.getMessage());
	}

	/*********************************************************************
	 * Method to test that a player can move to the Storage room and pickup a
	 * rock.
	 ********************************************************************/
	@Test
	public void testMoveRooms2() {
		Game g = new Game();
		g.move("north");
		System.out.println("2 " + g.getMessage());
		g.pickup2();
		System.out.println("3 " + g.getMessage());
	}

	/*********************************************************************
	 * Method to test that a player cannot move south without swiping a keycard,
	 * and that a player cannot pickup an item that is not there.
	 ********************************************************************/
	@Test
	public void testMoveRooms3() {
		Game g = new Game();
		g.move("south");
		System.out.println("4 " + g.getMessage());
		g.pickup();
		System.out.println("5 " + g.getMessage());
	}

	/*********************************************************************
	 * Method to test that a player dies three times in a row by the Dire Wolf,
	 * which then means Game Over.
	 ********************************************************************/
	@Test
	public void testGameOver() {
		Game g = new Game();
		g.move("north");
		g.move("west");
		g.attack();
		g.move("north");
		g.move("west");
		g.attack();
		g.move("north");
		g.move("west");
		g.attack();
		System.out.println(g.getMessage());
		equals(g.gameOver());
	}

}