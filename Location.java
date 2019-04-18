package BORK ;

import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class location here.
 *
 * @author Kevin Smith, Haris Islamcevic, Brandon DeFore
 * @version 02/24/2019
 */
public class Location {
  /** Instance variable for name */
  private String description;

  /** Instance variable for item */
  private Item item;
  private Item item2;
  private Enemy enemy;
  
 

  /** Instance variable of HashMap of object String and Location */
  private HashMap<String, Location> myNeighbors = new HashMap<String, Location>();
  /** Instance variable of an array of enemies */
  private Enemy[] enemies = new Enemy[1];
  /** Instance variable of an array of items */
  private Item[] items = new Item[1];
  /** Instance variable for current item */
  private Item currentItem;
  private Item currentItem2;
  private Enemy currentEnemy;

  /** Instance variable of ArrayList of object Item */
  private ArrayList<Item> mapItems = new ArrayList<Item>();
  
  private ArrayList<Enemy> mapEnemies = new ArrayList<Enemy>();

  /** Constructor for objects of class location */
  public Location(String pDescription) {
    description = pDescription;
    item = null;
  }

  /**
   * Constructor for objects of class location
   *
   * @param pDescription, pItem
   */
  public Location(String pDescription, Item pItem, Item pItem2, Enemy pEnemy) {
    description = pDescription;
    item = pItem;
    currentItem = pItem;
    item2 = pItem2;
    currentItem2 = pItem2;
    enemy = pEnemy;
    currentEnemy = pEnemy;
    mapItems.add(currentItem);
    mapItems.add(currentItem2);
    mapEnemies.add(currentEnemy);
  }

  /**
   * Method to get the item
   *
   * @return currentItem
   */
  public Item getItem() {
    return item;
  }
  
  public Item getItem2() {
	  return item2;
  }

  public Enemy getEnemy() {
	  return currentEnemy;
  }
  
  /**
   * Method to get the description
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Method to add an item to our array
   *
   * @param pItem
   */
  public void addItem(Item pItem) {
    item = pItem;
    currentItem = pItem;
    mapItems.add(currentItem);
  }
  
  public void addItem2(Item pItem2) {
	    item2 = pItem2;
	    currentItem2 = pItem2;
	    mapItems.add(currentItem2);
	  }
  
  public void addEnemy(Enemy pEnemy) {
	  enemy = pEnemy;
	  currentEnemy = pEnemy;
	  mapEnemies.add(currentEnemy);
  }

  /** Method to see if a room has an item */
  public boolean hasItem() {
    if (mapItems.size() == 0 || items == null) {
      return false;
    }
    return true;
  }
  
  public boolean hasItem2() {
	    if (mapItems.size() <= 1 || items == null) {
	      return false;
	    }
	    return true;
	  }
   
  public boolean hasEnemy() {
	  if(mapEnemies.size() == 0 || enemies == null) {
		  return false;
	  }
	  return true;
  }

  /**
   * Method to add neighbors around your location
   *
   * @param pDir,pLoc
   */
  public void addNeighbor(String pDir, Location pLoc) {
    myNeighbors.put(pDir, pLoc);
  }

  /**
   * Method to get the neighbor
   *
   * @param pDirection
   */
  public Location getNeighbor(String pDirection) {
    return myNeighbors.get(pDirection);
  }

  /**
   * Method to remove the item from our array
   *
   * @return currentItem
   */
  public Item removeItem() {
    item = null;
    return currentItem;
  }
  
  
  public Item removeItem2() {
	    item2 = null;
	    return currentItem2;
	  }
  
  public Enemy removeEnemy() {
	  enemies = null;
	  enemy = null;
	  return currentEnemy;
  }

  /** Method to get the long description */
//  public String getLongDescription() {
//    if (hasItem() == true) {
//      return ("You are in the " + description + " room," + "You see a " + item.getName() +item2.getName() + enemy.getName());
//    }
//    else if(hasTwoItems() == true) {
//    	return ("You are in the " + description + " room," + "You see a " + item.getName() +" "+ "and a " + item2.getName());
//    }
//    else if(hasEnemy() == true && hasItem() == true) {
//    	return ("You are in the " + description + " room," + "You see a " + item.getName() +" "+ "and " + enemy.getName());
//    }
//    return ("You are in the " + description + " room.");
//  }
//}
  
  public String getLongDescription() {

		  return("You are in the " + description + " , " + " you see: item 1: " +item.getName() + " , " + "item 2: " +item2.getName() +  " , Enemy: " + enemy.getName());
	  
  }
}
  
