package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import UI.*;
import Objects.Paddle;

//This class was written by Steve. It was later decided that the game would be played
//using the keyboard, but we kept this class in case we wanted to add mouse functionality
//later
public class MouseInputs implements MouseListener, MouseMotionListener {
	
	private Panel gamePanel;
	private Paddle paddle;
	
	public MouseInputs(Panel gamePanel, Paddle paddle) {
		this.gamePanel = gamePanel;
		this.paddle = paddle;
	} //constructor

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} //mouseClicked

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} //mousePressed

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} //mouseReleased

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	} //mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} //mouseExited

	@Override
	public void mouseDragged(MouseEvent e) {
		
	} //mouseDragged

	@Override
	public void mouseMoved(MouseEvent e) {
		
	} //mouseMoved
	
	
} //MouseInputs
