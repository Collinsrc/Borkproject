package BORK;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class location here.
 *
 * @author Kevin Smith, Haris Islamcevic
 * @version 02/24/2019
 */
public class Location
{
    /** Instance variable for name */
    private String description;

    /** Instance variable for item */
    private Item item;

    /** Instance variable of HashMap of object String and Location */
    private HashMap <String,Location> myNeighbors = new HashMap<String,Location>();

    /** Instance variable of an array of items */
    private Item[] items = new Item[1];

    /** Instance variable for current item */
    private Item currentItem;

    /** Instance variable of ArrayList of object Item */
    private ArrayList <Item> mapItems = new ArrayList <Item>();

    /**
     * Constructor for objects of class location
     */
    public Location(String pDescription){
        description = pDescription;
        item = null;

    }

    /**
     * Constructor for objects of class location
     * @param pDescription, pItem
     */
    public Location(String pDescription, Item pItem){
        description = pDescription;
        item = pItem;
        currentItem = pItem;
        mapItems.add(currentItem);
    }

    /**
     * Method to get the item
     * @return currentItem
     */
    public Item getItem(){
        return currentItem;
    }

    /**
     * Method to get the description
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Method to add an item to our array
     * @param pItem
     */
    public void addItem(Item pItem){
        item = pItem;
        currentItem = pItem;
        mapItems.add(currentItem);
    }

    /**
     * Method to see if a room has an item
     */
    public boolean hasItem() {
        if(mapItems.size() == 0 || items == null){
            return false;
        }
        return true;
    }

    /**
     * Method to add neighbors around your location
     * @param pDir,pLoc
     */
    public void addNeighbor(String pDir, Location pLoc){
        myNeighbors.put(pDir,pLoc);
    }

    /**
     * Method to get the neighbor
     * @param pDirection
     */
    public Location getNeighbor(String pDirection){
        return myNeighbors.get(pDirection);
    }

    /**
     * Method to remove the item from our array
     * @return currentItem
     */
    public Item removeItem(){
        items = null;
        item = null;
        return currentItem;
    }

    /**
     * Method to get the long description
     */
    public String getLongDescription(){
        if(hasItem() == true ){
            return ("You are in the " + description + " room," + " You see  " + item.getName());
        }
        return ("You are in the " + description + " room.");
    }
}
