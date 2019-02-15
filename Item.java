
/**
 * Write a description of class Item here.
 * 
 * @author Kevin Smith  
 * @version 4/12/2017
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

    /**
     * Constructor for objects of class Item
     */

    public Item(){
        name = "";
        description = "";
        weight = 0;
        edible = false;
    }

    /**
     * Constructor for objects of class Item
     * @param n,d,w,e
     */
    public Item(String n, String d, int w, boolean e){
        name = n;
        description = d;
        weight = w;
        edible = e;
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

}

