package Objects;

import Objects.Brick;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

//This class was written by Chase
public class BrickArray {
    
    private Brick[][] brickArray = new Brick[5][10];
    private int numBricks;

    public BrickArray() {
		for (int i = 0; i < brickArray.length; i++) {
            int brickX = 20;
		    int brickY = 30 + (36 * i);
			    for (int j = 0; j < brickArray[i].length; j++) {
				    brickArray[i][j] = new Brick(brickX, brickY, 95, 35, i, j);
                    brickX += 96;
			    } //for
        } //for
        numBricks = 50;
    } //constructor

    public void removeBrick(int i, int j) {
        brickArray[i][j] = null;
        numBricks--;
    } //removeBrick

    public int getLength() {
        return brickArray.length;
    } //getLength

    public int getWidth(int col) {
        return brickArray[col].length;
    } //getWidth

    public Brick getBrick(int i, int j) {
        return brickArray[i][j];
    } //getBrick

    public int getNumBricks() {
        return numBricks;
    } //getNumBricks

    public void spawnBricks(Graphics g) {
        g.setColor(Color.green);
    	for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                if (brickArray[i][j] != null) {
            	    g.fillRect(brickArray[i][j].x, brickArray[i][j].y, brickArray[i][j].width, 
            			brickArray[i][j].height);
                } //if
            } //for
    	} //for
    } //spawnBricks

} //BrickArray