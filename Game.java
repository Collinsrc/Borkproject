package BORK;

import java.util.ArrayList;
/**
 * Write a description of class Game here.
 *
 * @author Kevin Smith, Haris Islamcevic, Robert Collins
 * @version 02/24/2019
 */
public class Game {
  /** Instance variables to declare locations. */
  private Location jailCell;

  private Location messhall;
  private Location storage;
  private Location armory;
  private Location study;
  private Location laboratory;
  private Location doorway;
  private Location summoningRoom;
  private Location lair;
  private Location caves;
  private Location secret_room;
  private Location wardens;
  private Location exit;

  /** Instance variables to declare items */
  /** Useful. */
  private Item keycard;

  private Item portal;
  private Item portalStone;
  private Item chestKey1;
  private Item chestKey2;
  private Item chestKey3;
  private Item Crown;

  /** Weapons. */
  private Item excalibur;

  private Item Makeshift_shiv;
  private Item Longsword;
  private Item Greataxe;
  private Item Maul;
  private Item Wand;

  /** Useless. */
  private Item moldyFood;

  private Item sigil;
  private Item rock;
  private Item gold;
  private Item loot;
  private Item Grail;
  private Item characterSheet;
  private Item lantern;
  private Item torch;
  private Item corpse;
  private Item trash;
  private Item no_item;
  private Item no_item2;

  /** Immovable items. */
  private Item rubble;

  private Item table;
  private Item statue;
  private Item trap;
  private Item largeChest;

  /** Instance variables to declare enemies. */
  private Enemy mad_scientist;

  private Enemy dire_wolf;
  private Enemy cave_troll;
  private Enemy final_bossman;
  private Enemy no_enemy;

  /** Instance variable for ArrayList of object Item. */
  private ArrayList<Item> itemsHeld;

  /** Instance variable for currentLocation. */
  public Location currentLocation;

  /** Instance variable for a message. */
  private String message;

  private int count = 0;
  private int count2 = 0;
  private int count3 = 0;
  private int lives = 3;

  /** Constructor for objects of class Game. */
  public Game() {
    itemsHeld = new ArrayList<Item>();
    createWorld();
    currentLocation = jailCell;
    setWelcomeMessage();
  }

  /**
   * Method to get the current message.
   *
   * @return message
   */
  public String getMessage() {
    return message;
  }

  /** Method that creates the world. */
  private void createWorld() {
    /** Useful Items */
    keycard = new Item("Keycard", "a keycard to swipe in the jailcell", 1, false, false, 0);
    chestKey1 =
        new Item(
            "Chest Key 1",
            "one of three keys to open the chest in the wardens office",
            1,
            false,
            false,
            0);
    chestKey2 =
        new Item(
            "Chest Key 2",
            "one of three keys to open the chest in the wardens office",
            1,
            false,
            false,
            0);
    chestKey3 =
        new Item(
            "Chest Key 3",
            "one of three keys to open the chest in the wardens office",
            1,
            false,
            false,
            0);

    portal =
        new Item(
            "Portal",
            "a summoning circle used to open up a portal... Something is missing...",
            50,
            false,
            false,
            0);
    portalStone =
        new Item(
            "Portal Stone",
            "a stone used by sorcerers, and wizards to open portals",
            15,
            false,
            false,
            0);

    /** Weapons */
    Makeshift_shiv =
        new Item(
            "Shiv", "A pointy shiv made from a toothbrush and a razor blade", 10, false, true, 1);
    Longsword =
        new Item("Longsword", "a VERY pointy stick used to hit things! Yay!", 15, false, true, 2);
    Greataxe =
        new Item(
            "Greataxe",
            "You know that thing people use to "
                + "cut down trees? It's that but bigger, and more... Hurty.",
            20,
            false,
            true,
            3);
    Maul =
        new Item(
            "Maul",
            "asledgehammer used to kill monsters. Goblets everywhere!!!",
            25,
            false,
            true,
            4);
    Wand =
        new Item(
            "Wand of Fireball",
            "Essentially a pocket wizard... If "
                + "that wizard could only cast one spell... At leasts it's an iconic  spell!",
            1,
            false,
            true,
            5);
    excalibur =
        new Item(
            "Excalibur",
            "a sword said to crown whomever can lift it from it's rock as King",
            40,
            false,
            true,
            100);

    /** Useless Items */
    no_item = new Item("nothing", "There are no items here", 5, false, false, 0);
    no_item2 = new Item("nothing", "There is no second item here", 5, false, false, 0);
    gold = new Item("Gold Pouch", "a leather pouch conpaining 25 gold pieces", 5, false, false, 0);
    loot =
        new Item(
            "Loot from a chest",
            "a pile of gold coins. Must be around 75 pieces!",
            15,
            false,
            false,
            0);
    Grail = new Item("The Holy Grail", "If only King Arthur knew.", 3, false, false, 0);
    Crown =
        new Item(
            "The Kings Crown", "Whoever wears this will be considered king", 3, false, false, 0);
    characterSheet =
        new Item("Character Sheet", "Hmph. How'd this get here? Weird.", 1, false, false, 0);
    lantern = new Item("Lantern", "Used to illuminate one's surroundings.", 5, false, false, 0);
    torch = new Item("Torch", "Used to illuminate one's surroundings.", 2, false, false, 0);
    moldyFood = new Item("Moldy Food", "moldy food left by a patron", 1, false, false, 0);
    corpse =
        new Item(
            "Corpse",
            "a slain adventurer. Hopefully you will be more fortunate",
            5,
            false,
            false,
            0);
    sigil = new Item("Sigil", "a sigil with strange arcane inscriptions", 1, false, false, 0);
    rock = new Item("Rock", "a normal looking rock", 3, false, true, 1);
    trash =
        new Item(
            "Trash",
            "Literally just a pile of trash. Why would you pick this up? Ughh. Users...",
            100,
            false,
            false,
            0);

    /** Immovable Items */
    rubble = new Item("Rubble", "Remnants of a damaged structure", 100, false, false, 0);
    table = new Item("Table", "a sturdy table.", 100, false, false, 0);
    statue =
        new Item(
            "Statue",
            "a large statue affixed to a wall. It is "
                + "humanoid in shape, but it's worn "
                + "exterior makes it hard to depict whom it resembles",
            100,
            false,
            false,
            0);
    trap =
        new Item(
            "Sprung Trap",
            "This trap was likely sprung by "
                + "another adventurer some time ago. You hope they're okay.",
            100,
            false,
            false,
            0);
    largeChest =
        new Item(
            "Chest",
            "The chest contains solid gold bars. If only you could carry them all... What a shame",
            100,
            false,
            false,
            0);

    mad_scientist =
        new Enemy(
            "A Mad Scientist",
            "A Scientist Corrupted by his research of "
                + "the dark arts. It looks like a longer or "
                + "larger weapon will be able to kill him",
            2);
    dire_wolf =
        new Enemy(
            "Dire Wolf",
            "A Wolf on the hunt for dinner, you "
                + "just happen to look appetizing.  "
                + "Your shiv looks like it will be able to take it out",
            1);
    cave_troll = new Enemy("Cave Troll", "A troll from the caves", 4);

    final_bossman = new Enemy("Titan", "A fire titan, The guardian of the holy grail", 4);

    no_enemy = new Enemy("No enemy", "no enemy here", 1);

    /** Item Locations */
    jailCell = new Location("Jail cell", Makeshift_shiv, corpse, no_enemy);
    messhall = new Location("Messhall", table, moldyFood, no_enemy);
    study = new Location("Study", sigil, lantern, no_enemy);
    storage = new Location("Storage", statue, rock, no_enemy);
    armory = new Location("Armory", corpse, excalibur, no_enemy);
    laboratory = new Location("An evil scientist's laboratory", keycard, lantern, mad_scientist);
    doorway = new Location("Doorway", portalStone, statue, no_enemy);
    summoningRoom = new Location("Summoning Room", portal, Grail, final_bossman);
    lair = new Location("Lair", Longsword, torch, dire_wolf);
    wardens = new Location("Warden's office", largeChest, trap, no_enemy);
    caves = new Location("Dark Caves", Greataxe, rubble, cave_troll);
    secret_room = new Location("A secret room", Wand, largeChest, no_enemy);
    exit = new Location("Exit Game", no_item, no_item2, no_enemy);

    /** Location Layout */
    storage.addNeighbor("north", armory);
    storage.addNeighbor("south", jailCell);
    storage.addNeighbor("west", lair);
    lair.addNeighbor("east", storage);
    armory.addNeighbor("south", storage);
    jailCell.addNeighbor("north", storage);
    jailCell.addNeighbor("south", doorway);
    jailCell.addNeighbor("west", study);
    jailCell.addNeighbor("east", messhall);
    doorway.addNeighbor("north", jailCell);
    doorway.addNeighbor("south", summoningRoom);
    doorway.addNeighbor("east", wardens);
    wardens.addNeighbor("west", doorway);
    summoningRoom.addNeighbor("north", doorway);
    messhall.addNeighbor("west", jailCell);
    messhall.addNeighbor("north", caves);
    caves.addNeighbor("south", messhall);
    laboratory.addNeighbor("east", study);
    study.addNeighbor("west", laboratory);
    study.addNeighbor("east", jailCell);
    study.addNeighbor("south", secret_room);
    secret_room.addNeighbor("north", study);
    exit.addNeighbor("north", summoningRoom);
  }

  /** Method that sets a welcome message. */
  public void setWelcomeMessage() {
    message =
        "Welcome to Bork. This is a text adventure game with similar elements to the game Zork\n"
            + "Try to escape with the holy "
            + "grail, but, be warned. There are monsters lurking everywhere\n"
            + "Use anything you can to your advantage.";
  }

  public void setResetMessage() {
    message = "Good luck this time around";
  }

  /** Method that checks for an item within our ArrayList. */
  private Item checkForItem(String name) {
    for (Item i : itemsHeld) {
      if (i.getName() == name) {
        itemsHeld.add(i);
      }
    }
    return null;
  }

  /**
   * Method to check if item exists in list.
   *
   * @param name name of item to search for.
   * @return boolean to see if item exists.
   */
  public boolean checkForItemForThrow(String name) {
    for (Item i : itemsHeld) {
      if (i.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  /** Method that gives helpful hints to the player. */
  public void help() {
    if (count == 0) {
      message = "The objective is to find the holy grail and escape";
      count++;
    } else if (count == 1) {
      message = "Only certain weapons kill certain monsters";
      count++;
    } else if (count == 2) {
      message = "The key to enter doorway is somewhere to the west";
      count++;
    } else if (count == 3) {
      message = "There might be a way to get excalibur in the warden's office";
      count++;
    } else {
      message = "no more hints for you";
    }
  }

  /** Method to say what the player sees in a room. */
  public void look() {
    if (currentLocation.hasEnemy() == true && currentLocation.hasItem() == true) {
      message = currentLocation.getLongDescription();
    } else {
      message = currentLocation.getLongDescription();
    }
  }

  /** Method that allows the player to move in certain locations. */
  public void move(String pDir) {
    Location nextSpot = currentLocation.getNeighbor(pDir);
    if (nextSpot == null) {
      message = "You can't move in that direction";
    } else if (nextSpot == study && count2 == 0) {
      message = "The beholder is blocking the entrance, if only there was a way to distract it...";
    } else if (nextSpot == doorway && count3 == 0) {
      message = "Insert the key to enter";
    } else if (nextSpot == exit && itemsHeld.contains(Grail)) {
      gameOver();
    } else {
      currentLocation = nextSpot;
      message = currentLocation.getLongDescription();
      // message = currentLocation.getEnemyDescription();
    }
  }

  /** Method that tells how many items are in our ArrayList. */
  public void list() {
    message = "You are holding: ";
    for (Item it : itemsHeld) {
      message = message + "\n" + it.getName();
    }
    message = message + "\n" + "nothing";
  }

  /** Method that allows the player to pickup objects. */
  public void pickup() {
    if (currentLocation.hasItem() == true) {
      if (currentLocation.getItem().getWeight() < 50) {
        itemsHeld.add(currentLocation.getItem());
        message = "You picked up " + currentLocation.getItem().getName();
        currentLocation.removeItem();
        currentLocation.addItem(no_item);
      } else {
        message = "The item is too heavy to carry";
      }
    } else if (currentLocation.hasItem() == false) {
      message = "This room doesn't have an item";
    }
  }

  /** Method to pick up item. */
  public void pickup2() {
    if (currentLocation.hasItem() == true) {
      if (currentLocation.getItem2().getWeight() < 50 && currentLocation.getItem2() != excalibur) {
        itemsHeld.add(currentLocation.getItem2());
        message = "You picked up " + currentLocation.getItem2().getName();
        currentLocation.removeItem2();
        currentLocation.addItem2(no_item);
      } else if (currentLocation.getItem2() == excalibur && itemsHeld.contains(Crown)) {
        message = "You have proved yourself worthy of the sword";
        itemsHeld.add(excalibur);
        currentLocation.addItem2(no_item);
      } else if (currentLocation.getItem2() == excalibur && itemsHeld.contains(Crown) == false) {
        message = "You Need to prove yourself worthy of the sword";
      }
    } else if (currentLocation.hasItem() == false) {
      message = "This room doesn't have an item";
    }
  }

  /** Method to determine if player has keys. */
  public boolean hasKeys() {
    if (itemsHeld.contains(chestKey1)
        && itemsHeld.contains(chestKey2)
        && itemsHeld.contains(chestKey3)) {
      return true;
    } else {
      return false;
    }
  }

  /** Method to open the door. */
  public void open() {
    if (currentLocation == wardens) {
      if (hasKeys() == true) {
        message = "You have opened the chest and received the King's Crown!";
        itemsHeld.add(Crown);
      } else if (hasKeys() == false) {
        message = "You need three keys to open this chest";
      }
    } else {
      message = "there is nothing to open";
    }
  }

  /** Method to Attack enemies. */
  public void attack() {
    if (currentLocation.hasEnemy() == true && currentLocation == lair) {

      if (itemsHeld.contains(Longsword) || itemsHeld.contains(Makeshift_shiv)) {
        message = "you killed the Dire wolf and received the Chest Key";
        itemsHeld.add(chestKey1);
        currentLocation.removeEnemy();
        currentLocation.addEnemy(no_enemy);
      } else {
        currentLocation = jailCell;
        lives = lives - 1;
        message =
            "you were killed by the Dire wolf, maybe try the shiv\nYou have "
                + lives
                + " lives left ";
      }

    } else if (currentLocation.hasEnemy() == true && currentLocation == caves) {
      if (itemsHeld.contains(Longsword) || itemsHeld.contains(Greataxe)) {
        message = "you killed the Cave Troll and received the second chest key";
        itemsHeld.add(chestKey2);
        currentLocation.removeEnemy();
        currentLocation.addEnemy(no_enemy);
      } else {
        currentLocation = jailCell;
        lives--;
        message =
            "you were killed by the Cave Troll, if only you had a longsword\nYou have "
                + lives
                + " lives left ";
      }
    } else if (currentLocation.hasEnemy() == true && currentLocation == laboratory) {
      if (itemsHeld.contains(Wand) || itemsHeld.contains(Greataxe)) {
        message = "you killed the Mad Scientist and looted the third chest key";
        itemsHeld.add(chestKey3);
        currentLocation.removeEnemy();
        currentLocation.addEnemy(no_enemy);
      } else {
        currentLocation = jailCell;
        lives--;
        message =
            "you were killed by the The Mad Scientist, if only you had a wand\nYou have "
                + lives
                + " lives left ";
      }
    } else if (currentLocation.hasEnemy() == true && currentLocation == summoningRoom) {
      if (itemsHeld.contains(excalibur)) {
        message =
            "After killing the titan and attaining the "
                + "holy grail the light of the exit catches your eye, YOU WIN !!!";
        currentLocation.removeEnemy();
        itemsHeld.add(Grail);
      } else {
        currentLocation = jailCell;
        lives--;
        message =
            "you were killed by the Fire Titan, you need the sword of Kings\nYou have "
                + lives
                + " lives left ";
      }
    } else {
      message = "there is nothing to attack";
    }

    if (lives == 0) {
      message = "GAME OVER, you are out of lives press reset to start a new game";
    }
  }

  /** Method that allows the player to drop objects in a room with no item. */
  public void drop(String item) {
    if (checkForItem(item) != null) {
      Item i = checkForItem(item);
      itemsHeld.remove(i);
      currentLocation.removeItem();
      message = "You have dropped the " + item + " " + currentLocation.getDescription();
    } else if (currentLocation.hasItem() == true) {
      message = "You have dropped the " + item + " in the " + currentLocation.getDescription();
      currentLocation.removeItem();
      currentLocation.addItem(Makeshift_shiv);
    } else {
      message = "the player is not holding that item";
    }
  }

  /** Method that allows the player to eat an edible object. */
  public void eat(String item) {
    if (checkForItem(item) != null) {
      Item i = checkForItem(item);
      if (i.isEdible() == true) {
        message = "You ate " + i.getName();
        itemsHeld.remove(i);
      } else if (i.isEdible() == false) {
        message = "You can not eat " + i.getName();
      } else if (i.getName().equals(item)) {
        message = "You are not holding that item";
      }
    }
  }

  /** Method that allows the player to throw an object. */
  public void toss(String item) {
    count2 = 1;
    if (item == null) {
      message = "Throw cancelled.";
      return;
    }
    if (checkForItemForThrow(item)) {
      // itemsHeld.remove(item);
      for (Item i : itemsHeld) {
        if (i.getName().equals(item)) {
          itemsHeld.remove(i);
          message = "You threw the " + item;
          return;
        }
      }
      // message = "You threw the " + item;
    }
    message = "You don't have that item.";
  }

  /** Method that allows the player to slide an object. */
  public void slide(String item) {
    if (itemsHeld.contains(keycard)) {
      if (currentLocation == jailCell) {
        message = "you unlocked the doorway with the key";
        itemsHeld.remove(keycard);
        count3 = 1;
      }
    }
  }

  /** Method that tells the player if they won or lost. */
  public boolean gameOver() {
    if (currentLocation == exit && itemsHeld.contains(Grail)) {
      message = "You successfully found the holy grail and escaped";
      return true;
    } else if (lives == 0) {
      message = "You have run out of lives GAME OVER";
      return true;
    }
    return false;
  }

  /** Resets the game. */
  public void reset() {
    itemsHeld = new ArrayList<Item>();
    createWorld();
    currentLocation = jailCell;
    setResetMessage();
  }
}
