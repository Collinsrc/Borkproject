package BORK;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.event.*;
import java.util.*;

/**
 * *********************************************************** GUI for a a text based game.
 *
 * @author Kevin Smith, Haris Islamcevic, Robert Collins, Brandon DeFore
 * @version 02/24/2019 **********************************************************
 */

public class GameGUI extends JFrame implements ActionListener {

  /** Instance variable that declares Game. */
  Game g;

  /** JButtons. */
  private JButton east;

  private JButton west;
  private JButton north;
  private JButton south;
  private JButton help;
  private JButton pickup;
  private JButton pickup2;
  private JButton drop;
  private JButton reset;
  private JButton look;
  private JButton list;
  private JButton slide;
  private JButton toss;
  private JButton showMinimap;
  private JButton attack;
  private JButton open;

  /** Displays results in this text area. */
  JTextArea results;

  /** menu items. */
  JMenuBar menus;

  JMenu fileMenu;
  JMenuItem quitItem;

  /**
   * *************************************************************** Main Method.
   * **************************************************************
   */
  public static void main(String args[]) {
    GameGUI gui = new GameGUI();
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui.setTitle("BORK");
    gui.setPreferredSize(new Dimension(1000, 500));
    gui.pack();
    gui.setVisible(true);
  }

  /**
   * *************************************************************** constructor installs all of
   * the. GUI components **************************************************************
   */
  public GameGUI() {
    g = new Game();

    setLayout(new GridBagLayout());
    GridBagConstraints loc;

    results = new JTextArea(20, 50);
    DefaultCaret caret = (DefaultCaret)results.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    JScrollPane scrollPane = new JScrollPane(results);
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 0;
    loc.insets.left = 5;
    loc.insets.bottom = 5;
    add(scrollPane, loc);

    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, 500);
    add(new JLabel("Actions: "), loc);

    loc = new GridBagConstraints();
    loc.gridx = 1;
    loc.gridy = 0;
    loc.insets = new Insets(0, 50, 150, 0);
    add(new JLabel("Directions: "), loc);

    look = new JButton();
    look.setText("Look");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, 350);
    add(look, loc);

    pickup = new JButton();
    pickup.setText("Pick up item 1");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, 170);
    add(pickup, loc);

    drop = new JButton();
    drop.setText("Drop");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, -240);
    add(drop, loc);

    pickup2 = new JButton();
    pickup2.setText("Pick up item 2");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, -60);
    add(pickup2, loc);

    attack = new JButton();
    attack.setText("Attack");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, -60, 350);
    add(attack, loc);

    open = new JButton();
    open.setText("Open");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, -60, 210);
    add(open, loc);

    reset = new JButton();
    reset.setText("reset");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, -60, -152);
    add(reset, loc);

    help = new JButton();
    help.setText("help");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, -60, 85);
    add(help, loc);

    list = new JButton();
    list.setText("List");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, -60, -30);
    add(list, loc);

    slide = new JButton();
    slide.setText("Swipe");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, -372);
    add(slide, loc);

    toss = new JButton();
    toss.setText("Throw");
    loc = new GridBagConstraints();
    loc.gridx = 0;
    loc.gridy = 1;
    loc.insets = new Insets(0, 0, 0, -512);
    add(toss, loc);

    north = new JButton();
    north.setText("North");
    loc = new GridBagConstraints();
    loc.gridx = 1;
    loc.gridy = 0;
    loc.insets = new Insets(0, 50, 100, 0);
    add(north, loc);

    west = new JButton();
    west.setText("West");
    loc = new GridBagConstraints();
    loc.gridx = 1;
    loc.gridy = 0;
    loc.insets = new Insets(0, -100, 25, 0);
    add(west, loc);
    south = new JButton();
    south.setText("South");
    loc = new GridBagConstraints();
    loc.gridx = 1;
    loc.gridy = 0;
    loc.insets = new Insets(0, 50, -50, 0);
    add(south, loc);

    east = new JButton();
    east.setText("East");
    loc = new GridBagConstraints();
    loc.gridx = 1;
    loc.gridy = 0;
    loc.insets = new Insets(0, 200, 25, 0);
    add(east, loc);

    showMinimap = new JButton();
    showMinimap.setText("Minimap");
    loc = new GridBagConstraints();
    loc.gridx = 1;
    loc.gridy = 0;
    loc.insets = new Insets(0, 50, -200, 0);
    add(showMinimap, loc);

    // FIX ME: register the button action listeners
    north.addActionListener(this);
    south.addActionListener(this);
    east.addActionListener(this);
    west.addActionListener(this);
    help.addActionListener(this);
    pickup.addActionListener(this);
    pickup2.addActionListener(this);
    drop.addActionListener(this);

    reset.addActionListener(this);
    look.addActionListener(this);
    list.addActionListener(this);
    slide.addActionListener(this);
    toss.addActionListener(this);
    showMinimap.addActionListener(this);
    attack.addActionListener(this);
    open.addActionListener(this);

    fileMenu = new JMenu("File");
    quitItem = new JMenuItem("Quit");
    fileMenu.add(quitItem);
    menus = new JMenuBar();
    setJMenuBar(menus);
    menus.add(fileMenu);

    fileMenu.addActionListener(this);
    quitItem.addActionListener(this);

    g.setWelcomeMessage();
    results.append(g.getMessage());
  }

  /**
   * *************************************************************** This method is called when any
   * button is clicked. The proper internal method is called as needed.
   *
   * @param e the event that was fired
   *     **************************************************************
   */
  public void actionPerformed(ActionEvent e) {
    // menu item - quit
    if (e.getSource() == quitItem) {
      System.exit(1);
    } else if (e.getSource() == look) {
      g.look();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == open) {
      g.open();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == pickup) {
      g.pickup();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == pickup2) {
      g.pickup2();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == attack) {
      g.attack();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == drop) {
      String toDrop = JOptionPane.showInputDialog(null, "Drop what?");
      g.drop(toDrop);
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == reset) {
      g.reset();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == list) {
      g.list();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == north) {
      g.move("north");
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == east) {
      g.move("east");
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == west) {
      g.move("west");
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == south) {
      g.move("south");
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == toss) {
      String toToss = JOptionPane.showInputDialog(null, "Throw what?");
      g.toss(toToss);
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == slide) {
      String toSlide = JOptionPane.showInputDialog(null, "Swipe what?");
      g.slide(toSlide);
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (e.getSource() == showMinimap) {
      JFrame minimapDisplay = new JFrame();
      minimapDisplay.setLayout(new FlowLayout());
      minimapDisplay.setSize(575, 375);
      minimapDisplay.setResizable(false);
      minimapDisplay.setVisible(true);
      minimapDisplay.setTitle("BORK MiniMap");

      ImageIcon image = new ImageIcon("minimap.jpg");
      JLabel imageLabel = new JLabel(image);
      imageLabel.setBounds(10, 10, 575, 375);
      imageLabel.setVisible(true);
      minimapDisplay.add(imageLabel);
    } else if (e.getSource() == help) {
      g.help();
      String msg = g.getMessage();
      results.append("\n" + msg);
    } else if (g.gameOver() == true) {
      gameOver();
      String msg = g.getMessage();
      results.append("\n" + msg);
    }
  }

  /** Method that disables all the buttons when the game is over. */
  private void gameOver() {
    if (g.gameOver() == true) {
      look.setEnabled(false);
      pickup.setEnabled(false);
      drop.setEnabled(false);
      reset.setEnabled(false);
      list.setEnabled(false);
      help.setEnabled(false);
      slide.setEnabled(false);
      toss.setEnabled(false);
      north.setEnabled(false);
      east.setEnabled(false);
      west.setEnabled(false);
      south.setEnabled(false);
      showMinimap.setEnabled(false);
    }
  }

  /** Method that creates a new game for the player. */
  private void newGame() {
    g = new Game();
    look.setEnabled(true);
    pickup.setEnabled(true);
    drop.setEnabled(true);
    reset.setEnabled(true);
    list.setEnabled(true);
    help.setEnabled(true);
    slide.setEnabled(true);
    toss.setEnabled(true);
    north.setEnabled(true);
    east.setEnabled(true);
    west.setEnabled(true);
    south.setEnabled(true);
    showMinimap.setEnabled(true);
    g.setWelcomeMessage();
    results.setText("");
  }
}
