package BORK;
/**
 * Write a description of class Item here.
 *
 * @author Kevin Smith, Haris Islamcevic, Robert Collins
 * @version 02/24/2019
 */

public class Item {
  /** Instance variable for name. */
  String name;

  /** Instance variable for description. */
  String description;

  /** Instance variable for weight. */
  int weight;

  /** Instance variable for edible. */
  boolean edible;

  /** Instance variable for weapon. */
  boolean isWeapon;

  /** Instance variable for the damage the weapon can do. */
  int damage;

  /** Constructor for objects of class Item. */
  public Item() {
    name = "";
    description = "";
    weight = 0;
    edible = false;
    isWeapon = false;
    damage = 0;
  }

  /**
   * Constructor for objects of class Item.
   *
   * @param n name.
   * @param d description.
   * @param w weight.
   * @param e edible.
   */
  public Item(String n, String d, int w, boolean e, boolean wpn, int dmg) {
    name = n;
    description = d;
    weight = w;
    edible = e;
    isWeapon = wpn;
  }

  /**
   * Method to get the name. +
   *
   * @return name name of item.
   */
  public String getName() {
    return name;
  }

  /**
   * Method to set the name.
   *
   * @param name name of item.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Method to get the description.
   *
   * @return description description of item.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Method to set the description.
   *
   * @param description description of item.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Method to get the weight.
   *
   * @return weight weight of item.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Method to set the weight.
   *
   * @param weight weight of item.
   */
  public void setWeight(int weight) {
    this.weight = weight;
  }

  /**
   * Method to set if the item is edible or not.
   *
   * @param edible is edible.
   */
  public void setEdible(boolean edible) {
    this.edible = edible;
  }

  /**
   * Method that sets edible to true.
   *
   * @return edible see if is edible.
   */
  public boolean isEdible() {
    return edible = true;
  }

  /**
   * Method that sets isWeapon to true.
   *
   * @return isWeapon if it is a weapon.
   */
  public boolean isWeapon() {
    return isWeapon = true;
  }

  /**
   * Method to get a weapon's damage.
   *
   * @return damage items damage
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Method to set a weapon's damage.
   *
   * @param damage items damage.
   */
  public void setDamage(int damage) {
    this.damage = damage;
  }
}
