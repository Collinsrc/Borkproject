package Bork;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Enemy{
	  /** Instance variable for name */
	  String name;

	  /** Instance variable for description */
	  String description;

	  /** Instance variable for weight */
	  int power;
	  
	  /** constructor of object enemy */
	  public Enemy() {
		    name = "";
		    description = "";
		    power = 0;

		  }
	  
	  /** constructor of object enemy */
	  public Enemy(String n, String d, int p) {
		    name = n;
		    description = d;
		    power = p;
		  }
	  
	  /**
	   * Method to get the name. +
	   *
	   * @return name
	   */
	  public String getName() {
	    return name;
	  }

	  /**
	   * Method to set the name.
	   *
	   * @param name
	   */
	  public void setName(String name) {
	    this.name = name;
	  }

	  /** Method to get the description. return description */
	  public String getDescription() {
	    return description;
	  }

	  /**
	   * Method to set the description.
	   *
	   * @param description
	   */
	  public void setDescription(String description) {
	    this.description = description;
	  }

	  /** Method to get the weight. return weight */
	  public int getPower() {
	    return power;
	  }

	  /**
	   * Method to set the weight.
	   *
	   * @param weight
	   */
	  public void setPower(int power) {
	    this.power = power;
	  }


}
