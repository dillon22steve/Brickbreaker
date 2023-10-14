package Objects;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


//This class was written by Steve
public class Paddle extends Rectangle {
	
	private int xPos;
	private int yPos;
	private Color myGray = new Color(207, 207, 207);
	private boolean right, left;

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	public Paddle() {
		xPos = 500;
		yPos = 650;
		width = 150;
		height = 30;
		right = false;
		left = false;
	} //constructor
	
	public int getXPos() {
		return xPos;
	} //getXPos

	public int getYPos() {
		return yPos;
	} //getYPos
	
	public void draw(Graphics g) {
		g.setColor(myGray);
		g.fillRect(xPos, yPos, width, height);
	} //draw

	
	public void updatePos() {
		if(left && !right) {
			xPos -= 3.0f;
		} else if (right && !left) {
			xPos += 3.0f;
		} //if
		
		if(xPos < 0) {
			xPos = 0;
		} else if (xPos > 850) {
			xPos = 850;
		} //if
	} //updatePos


	public void setRight(boolean right) {
		this.right = right;
	} //setRight

	public void setLeft(boolean left) {
		this.left = left;
	} //setLeft
} //Paddle

