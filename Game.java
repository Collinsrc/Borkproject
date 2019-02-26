import java.util.ArrayList;
/**
 * Write a description of class Game here.
 *
 * @author Kevin Smith, Haris Islamcevic,
 * @version 02/24/2019
 */
public class Game
{
    /**Instance variables to declare locations  */
    private Location jailCell;
    private Location messhall;
    private Location storage;
    private Location armory;
    private Location study;
    private Location laboratory;
    private Location doorway;
    private Location summoningRoom;

    /**Instance variables to declare items  */
    private Item lantern;
    private Item moldyFood;
    private Item sigil;
    private Item rock;
    private Item excalibur;
    private Item key;
    private Item portalStone;
    private Item portal;

    /**Instance variable for ArrayList of object Item  */
    private ArrayList<Item> itemsHeld;

    /**Instance variable for currentLocation  */
    private Location currentLocation;

    /**Instance variable for a message  */
    private String message;

    private int count = 0;
    private int count2 = 0;
    private int count3 = 0;

    /**
     * Constructor for objects of class Game
     */
    public Game(){
        itemsHeld = new ArrayList<Item>();
        createWorld();
        currentLocation = jailCell;
        setWelcomeMessage();
    }

    /**
     * Method to get the current message
     * @return message
     */
    public String getMessage(){
        return message;
    }

    /**
     * Method that creates the world
     */
    private void createWorld(){

        moldyFood = new Item("Moldy Food", "moldy food left by a patron", 3, false, false, 0, 0);
        sigil = new Item("Sigil", "a sigil", 8, false, false, 0, 0);
        rock = new Item("Rock", "a normal looking rock", 10, false, true, 1, 2);
        excalibur = new Item("Excalibur", "a sword said to crown whomever can lift it from it's rock as King", 100, false, true, 100, 100);
        key = new Item("Key", "a key", 1, false, false, 0, 0);
        portalStone = new Item("Portal Stone", "a stone used by sorcerers, and wizards to open portals", 15, false, false, 0, 0);
        portal = new Item("Portal", "a summoning circle used to open up a portal... Something is missing...", 49, false, false, 0, 0);

        jailCell = new Location("Jail cell");
        messhall = new Location("Messhall", moldyFood);
        study = new Location("Study", sigil);
        storage = new Location("Storage", rock);
        armory = new Location("Armory", sword);
        laboratory = new Location("An evil scientist's laboratory", key);
        doorway = new Location("Doorway", portalStone);
        summoningRoom = new Location("Summoning Room", portal);

        storage.addNeighbor("north", armory);
        storage.addNeighbor("south",jailCell);
        armory.addNeighbor("south", storage);
        jailCell.addNeighbor("north",storage);
        jailCell.addNeighbor("south",doorway);
        jailCell.addNeighbor("west",study);
        jailCell.addNeighbor("east",messhall);
        doorway.addNeighbor("north",jailCell);
        doorway.addNeighbor("south",summoningRoom);
        summoningRoom.addNeighbor("north",doorway);
        messhall.addNeighbor("west",jailCell);
        laboratory.addNeighbor("east",study);
        study.addNeighbor("west",laboratory);
        study.addNeighbor("east",jailCell);
    }

    /**
     * Method that sets a welcome message
     */
    public void setWelcomeMessage(){
        message = "Welcome to Bork. This is a text adventure game with similar elements to the popular game Zork. \n"
        + "try to escape, but, be warned, you must avoiding the at all costs Beholder.\n"
        + "Use anything you can to your advantage. Just understand that some things may be too good to be true...";
    }

    /**
     * Method that checks for an item within our ArrayList
     */
    private Item checkForItem (String name){
        for(Item i: itemsHeld) {
            if(i.getName() == name) {
                itemsHeld.add(i);
            }
        }
        return null;
    }

    /**
     * Method that gives helpful hints to the player
     */
    public void help(){
        if(count == 0){
            message = "The objective is to find the key to open the doorway.";
            count++;
        }
        else if(count == 1){
            message = "An item might be in the laboratory.";
            count++;
        }
        else if(count == 2){
            message = "keep the key untill you go to the Jail Cell";
            count++;
        }else if(count == 3){
            message = "Sorry, no more hints...";
            count++;
        }
    }

    /**
     * Method to say what the player sees in a room
     */
    public void look(){
        message = currentLocation.getLongDescription();
    }

    /**
     * Method that allows the player to move in certain locations
     */
    public void move (String pDir){
        Location nextSpot = currentLocation.getNeighbor(pDir);
        if (nextSpot == null){
            message = "You can't move in that direction";
        }
        else if(nextSpot == study && count2 == 0){
            message = "The beholder is blocking the entrance, if only there was a way to distract it...";
        }
        else if (nextSpot == doorway && count3 == 0){
            message = "Insert the key to enter";
        }
        else if(nextSpot == summoningRoom && !itemsHeld.contains(portalStone)){
            gameOver();
        }
        else {
            currentLocation = nextSpot;
            message = currentLocation.getLongDescription();
        }

    }

    /**
     * Method that tells how many items are in our ArrayList
     */
    public void list(){
        message = "You are holding: ";
        for(Item it: itemsHeld){
            message = message +"\n" + it.getName();
        }
        message = message + "\n" + "nothing";
    }

    /**
     * Method that allows the player to pickup objects
     */
    public void pickup(){
        if(currentLocation.hasItem() == true)
        {
            if(currentLocation.getItem().getWeight() < 50){
                itemsHeld.add(currentLocation.getItem());
                message = "You picked up " + currentLocation.getItem().getName();
                currentLocation.removeItem();
            }
            else{
                message = "The item is too heavy to carry";
            }
        }
        else if(currentLocation.hasItem() == false){
            message = "This room doesn't have an item";
        }
    }

    /**
     * Method that allows the player to drop objects in a room with no item
     */
    public void drop (String item){
        if(checkForItem(item) != null)
        {
            Item i = checkForItem(item);
            itemsHeld.remove(i);
            currentLocation.addItem(i);

            message = "You have dropped the " + item + " " + currentLocation.getDescription();
        }
        else
        if(currentLocation.hasItem() == true)
            message = "This room already has an item";
        else
            message = "the player is not holding that item";
    }

    /**
     * Method that allows the player to eat an edible object
     */
    public void eat(String item){
        if(checkForItem(item) != null){
            Item i = checkForItem(item);
            if(i.isEdible() == true){
                message = "You ate " + i.getName();
                itemsHeld.remove(i);
            }
            else if(i.isEdible() == false){
                message = "You can not eat " + i.getName();
            }
            else if(i.getName() != item){
                message = "You are not holding that item";
            }
        }
    }

    /**
     * Method that allows the player to throw an object
     */
    public void toss(String item){
        count2 = 1;
        itemsHeld.remove(rock);
        message = "You threw the rock";
    }

    /**
     * Method that allows the player to slide an object
     */
    public void slide(String item){
        if(itemsHeld.contains(key)){
            if(currentLocation == jailCell){
                message = "you unlocked the doorway with the key";
                itemsHeld.remove(key);
                count3 = 1;
            }
        }
    }

    /**
     * Method that tells the player if they won or lost
     */
    public boolean gameOver(){
        if(currentLocation == summoningRoom && itemsHeld.contains(portalStone)){
            message = "You successfully escaped the Dungeon, you win!";
            return true;
        }
        return false;
    }
}
