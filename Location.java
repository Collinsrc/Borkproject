package BORK;

import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class location here.
 *
 * @author Kevin Smith, Haris Islamcevic, Brandon DeFore
 * @version 02/24/2019
 */

public class Location {
  /** Instance variable for name. */
  private String description;

  /** Instance variable for item. */
  private Item item;

  private Item item2;
  private Enemy enemy;

  /** Instance variable of HashMap of object String and Location. */
  private HashMap<String, Location> myNeighbors = new HashMap<String, Location>();
  /** Instance variable of an array of enemies. */
  private Enemy[] enemies = new Enemy[1];
  /** Instance variable of an array of items. */
  private Item[] items = new Item[1];
  /** Instance variable for current item. */
  private Item currentItem;

  private Item currentItem2;
  private Enemy currentEnemy;

  /** Instance variable of ArrayList of object Item. */
  private ArrayList<Item> mapItems = new ArrayList<Item>();

  private ArrayList<Enemy> mapEnemies = new ArrayList<Enemy>();

  /** Constructor for objects of class location. */
  public Location(String pDescription) {
    description = pDescription;
    item = null;
  }

  /**
   * Constructor for objects of class location.
   *
   * @param pDescription location description
   * @param pItem items in location
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
   * Method to get the first item.
   *
   * @return item first item.
   */
  public Item getItem() {
    return item;
  }

  /**
   * Method to return the second item.
   * 
   * @return item2 second item.
   */
  public Item getItem2() {
    return item2;
  }

  /**
   * Method to return the enemy in room.
   * @return currentEnemy enemy in room.
   */
  public Enemy getEnemy() {
    return currentEnemy;
  }

  /**
   * Method to get the description.
   *
   * @return description description of room.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Method to add an item to our array.
   *
   * @param pItem add Item to room.
   */
  public void addItem(Item pItem) {
    item = pItem;
    currentItem = pItem;
    mapItems.add(currentItem);
  }

  /**
   * Method to add item2 into room.
   * @param pItem2 item 2.
   */
  public void addItem2(Item pItem2) {
    item2 = pItem2;
    currentItem2 = pItem2;
    mapItems.add(currentItem2);
  }

  /**
   * Method to add enemy into room.
   * @param pEnemy enemy to be added.
   */
  public void addEnemy(Enemy pEnemy) {
    enemy = pEnemy;
    currentEnemy = pEnemy;
    mapEnemies.add(currentEnemy);
  }

  /** Method to see if a room has an item. */
  public boolean hasItem() {
    if (mapItems.size() == 0 || items == null) {
      return false;
    }
    return true;
  }

  /**
   * Method to see if two items are in the room.
   * @return boolean whether room has two items.
   */
  public boolean hasItem2() {
    if (mapItems.size() <= 1 || items == null) {
      return false;
    }
    return true;
  }

  /**
   * Method to check if enemy is in the room.
   * 
   * @return boolean if enemy is in room.
   */
  public boolean hasEnemy() {
    if (mapEnemies.size() == 0 || enemies == null) {
      return false;
    }
    return true;
  }

  /**
   * Method to add neighbors around your location.
   *
   * @param pDir add direction of neighbor.
   * @param pLoc add location of neighbor.
   */
  public void addNeighbor(String pDir, Location pLoc) {
    myNeighbors.put(pDir, pLoc);
  }

  /**
   * Method to get the neighbor.
   *
   * @param pDirection direction of neighbor.
   */
  public Location getNeighbor(String pDirection) {
    return myNeighbors.get(pDirection);
  }

  /**
   * Method to remove the item from our array.
   *
   * @return currentItem item to remove.
   */
  public Item removeItem() {
    item = null;
    return currentItem;
  }

  public Item removeItem2() {
    item2 = null;
    return currentItem2;
  }

  /**
   * Method to remove enemy.
   * 
   * @return currentEnemy enemy removed.
   */
  public Enemy removeEnemy() {
    enemies = null;
    enemy = null;
    return currentEnemy;
  }


  /** 
   * Gets the long description.
   * @return long description.
   */
  public String getLongDescription() {

    return ("You are in the "
        + description
        + " , "
        + " you see: item 1: "
        + item.getName()
        + " , "
        + "item 2: "
        + item2.getName()
        + " , Enemy: "
        + enemy.getName());
  }
}
