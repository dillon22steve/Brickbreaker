package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import UI.*;


//This class was written by Steve and Chase
public class KeyboardInputs implements KeyListener {
	
	private StartUpPanel startUp;
	private Panel gamePanel;
	private GameOverPanel endPanel;
	private int typePanel = 0;
	
	//Written by Steve
	public KeyboardInputs (Panel gamePanel) {
		this.gamePanel = gamePanel;
		typePanel = 2;
	} //constructor

	//Written by Chase
	public KeyboardInputs (StartUpPanel startUp) {
		this.startUp = startUp;
		typePanel = 1;
	} //constructor

	//Written by Chase
	public KeyboardInputs (GameOverPanel endPanel) {
		this.endPanel = endPanel;
		typePanel = 3;
	} //constructor


	@Override
	public void keyTyped(KeyEvent e) {
	} //keyTyped

	//Written by Steve and Chase
	@Override
	public void keyPressed(KeyEvent e) {
		if (typePanel == 1) {
			//Written by Chase
			startUp.startGameKey(e);
		} //if
		if (typePanel == 2) {
			//Written by Steve
			switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					gamePanel.getPaddle().setRight(true);
					break;
				case KeyEvent.VK_LEFT:
					gamePanel.getPaddle().setLeft(true);
					break;
				case KeyEvent.VK_A:
					gamePanel.getPaddle().setLeft(true);
					break;
				case KeyEvent.VK_D:
					gamePanel.getPaddle().setRight(true);
					break;
			} //switch
		}
		if (typePanel == 3) {
			//Written by Chase
			endPanel.startGameKey(e);
		} //if
	} //keyPressed

	//Written by Steve
	@Override
	public void keyReleased(KeyEvent e) {
		if (typePanel == 2) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					gamePanel.getPaddle().setRight(false);
					break;
				case KeyEvent.VK_LEFT:
					gamePanel.getPaddle().setLeft(false);
					break;
				case KeyEvent.VK_A:
					gamePanel.getPaddle().setLeft(false);
					break;
				case KeyEvent.VK_D:
					gamePanel.getPaddle().setRight(false);
					break;
			} //switch
		} //if
	} //keyReleased
	
} //KeyboardInputs