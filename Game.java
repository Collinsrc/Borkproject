import java.util.ArrayList;
/**
 * Write a description of class Game here.
 * 
 * @author Kevin Smith
 * @version 4/17/2017
 */
public class Game
{   
    /**Instance variables to declare locations  */
    private Location cmdCenter;
    private Location cafe;
    private Location storage;
    private Location armory;
    private Location comms;
    private Location medical;
    private Location airlock;
    private Location bay;

    /**Instance variables to declare items  */
    private Item flashlight;
    private Item odorSpray;
    private Item radar;
    private Item rock;
    private Item lmg;
    private Item keycard;
    private Item suit;
    private Item ship;

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
        currentLocation = cmdCenter;
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

        cmdCenter = new Location("Command center");
        odorSpray = new Item("Odor spray", "odor spray", 3, false);
        cafe = new Location("Cafeteria", odorSpray);
        radar = new Item("Radar", "a radar", 8, false);
        comms = new Location("Comms", radar);
        rock = new Item("Moon rock", "a moon rock", 10, false);
        storage = new Location("Storage", rock);
        lmg = new Item("Lmg", "a light machine gun", 80, false);
        armory = new Location("Armory", lmg);
        keycard = new Item("Keycard", "a keycard", 1, false);
        medical = new Location("Medical Facility", keycard);
        suit = new Item("Space suit", "a space suit", 40, false);
        airlock = new Location("Airlock", suit);
        ship = new Item("Spaceship", "a y-wing spaceship", 49, false);
        bay = new Location("Spaceship Bay", ship);

        storage.addNeighbor("north", armory);
        storage.addNeighbor("south",cmdCenter);
        armory.addNeighbor("south", storage);
        cmdCenter.addNeighbor("north",storage);
        cmdCenter.addNeighbor("south",airlock);
        cmdCenter.addNeighbor("west",comms);
        cmdCenter.addNeighbor("east",cafe);
        airlock.addNeighbor("north",cmdCenter);
        airlock.addNeighbor("south",bay);
        bay.addNeighbor("north",airlock);
        cafe.addNeighbor("west",cmdCenter);
        medical.addNeighbor("east",comms);
        comms.addNeighbor("west",medical);
        comms.addNeighbor("east",cmdCenter);
    }

    /**
     * Method that sets a welcome message
     */
    public void setWelcomeMessage(){
        message = "Welcome to Seclusion. This is a game where you must find your way off of the space \n"
        + "station by reaching the spaceship bay whilst avoiding the Xenomorph on board. Be warned,\n"
        + "use any objects to your advantage. However, some things may seem to good to be true...";
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
            message = "The objective is to find the keycard to open the Airlocks.";
            count++;
        }
        else if(count == 1){
            message = "An item might be in the Medical Facility.";
            count++;
        }
        else if(count == 2){
            message = "keep the keycard till you go to the Command Center";
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
        else if(nextSpot == comms && count2 == 0){
            message = "The alien is blocking a doorway, if only there was a way to distract it...";
        }
        else if (nextSpot == airlock && count3 == 0){
            message = "Swipe your keycard to enter";
        }
        else if(nextSpot == bay && !itemsHeld.contains(suit)){
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
        if(itemsHeld.contains(keycard)){
            if(currentLocation == cmdCenter){
                message = "you swiped the keycard to open the airlocks";
                itemsHeld.remove(keycard);
                count3 = 1;
            }
        }
    }

    /**
     * Method that tells the player if they won or lost
     */
    public boolean gameOver(){
        if(currentLocation == bay && itemsHeld.contains(suit)){
            message = "You successfully escaped the Xenomorph, you win!";
            return true;
        }
        return false;
    }
}
