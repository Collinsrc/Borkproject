
/**
 * Write a description of class Item here.
 *
 * @author Kevin Smith, Haris Islamcevic,
 * @version 02/24/2019
 */
public class Item
{
    /** Instance variable for name */
    String name;

    /** Instance variable for description */
    String description;

    /** Instance variable for weight */
    int weight;

    /** Instance variable for edible */
    boolean edible;

    /** Instance variable for weapon */
    boolean isWeapon;

    /** Instance variable for minimum damage the weapon can do */
    int minimumDamage;

    /** Instance variable for maximum damage the weapon can do */
    int maximumDamage;

    /**
     * Constructor for objects of class Item
     */

    public Item(){
        name = "";
        description = "";
        weight = 0;
        edible = false;
        isWeapon = false;
        minimumDamage = 0;
        maximumDamage = 0;
    }

    /**
     * Constructor for objects of class Item
     * @param n,d,w,e
     */
    public Item(String n, String d, int w, boolean e, boolean wpn, int minD, int maxD){
        name = n;
        description = d;
        weight = w;
        edible = e;
        isWeapon = wpn;
        damage = dmg;
    }

    /**
     * Method to get the name. +
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the description.
     * return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to get the weight.
     * return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Method to set the weight.
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Method to set if the item is edible or not.
     * @param edible
     */
    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    /**
     * Method that sets edible to true.
     * return edible
     */
    public boolean isEdible(){
        return edible = true;
    }

    /**
     * Method that sets isWeapon to true.
     * return edible
     */
    public boolean isWeapon(){
        return isWeapon = true;
    }

    /**
     * Method to get a weapon's minimum damage.
     * return weight
     */
     public int getMinimumDamage() {
         return minimumDamage;
     }

     /**
      * Method to get a weapon's maxiumum damage.
      * return weight
      */
     public int getMaximumDamage() {
         return maximumDamage;
     }

     /**
      * Method to set a weapon's minimum damage.
      * @param minimumDamage
      */
     public void setWeight(int damage) {
         this.minimumDamage = damage;
     }

     /**
      * Method to set a weapon's maximum damage.
      * @param maximumDamage
      */
     public void setWeight(int damage) {
         this.maximumDamage = damage;
     }
}
