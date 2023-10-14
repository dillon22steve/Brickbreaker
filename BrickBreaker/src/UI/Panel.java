package UI;

import java.awt.*;
import Objects.*;

import javax.swing.JPanel;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

//This class was written by Steve and Chase
public class Panel extends JPanel {

	boolean gameOver = false;

	public int score = 0;
	
	BrickArray brickArray1 = new BrickArray();
	Paddle paddle = new Paddle();
	Ball ball = new Ball();
	
	//Written by Steve
	public Panel() {
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(new MouseInputs(this, paddle));
		addMouseMotionListener(new MouseInputs(this, paddle));
		setBackground(Color.BLACK);
	} //constructor

	public Paddle getPaddle() {
		return this.paddle;
	} //getPaddle

	public int getScore() {
		return score;
	} //getScore

	public void setScore(int score) {
		this.score = score;
	} //setScore


	//Written by Steve
	public void update() {
		checkBrickCollision();
		checkPaddleCollision();
		checkBallCollision();
		paddle.updatePos();	
		ball.moveBall();	
	} //update

	
	//Written by Steve
	public void paintComponent(Graphics g) {
		//This draws a blank frame so that objects from the previous frame are not painted onto
		//the new frame
		super.paintComponent(g);
		
		g.setColor(Color.gray);
		paddle.draw(g);

		brickArray1.spawnBricks(g);

		ball.spawnBall(g);

		g.setColor(Color.WHITE);
		g.setFont(new Font ("Monospaced Bold",1,20));
		g.drawString("Score: " + score, 20, 20);
	} //paintComponent


	//Written by Chase
	//HELPER METHOD FOR CHECK BRICK COLLISION.  Only used for readability
	private Brick getBrickAt(int i, int j) {
		return brickArray1.getBrick(i,j);
	} //getBrickAt


	//Written by Steve
	public void checkBallCollision() {
		if (ball.getY() >= 670) {
			gameOver = true;
		} //if
		if (score == 250) {
			gameOver = true;
			GameOverPanel.setTitleWin();
		} //if
	} //checkBallCollision


	public boolean getGameOver() {
		return gameOver;
	} //getGameOver


	//Written by Chase
	public void checkBrickCollision() {
		int numHit= 0;
		for(int i = 0; i < brickArray1.getLength(); i++) {
			for (int j = 0; j < brickArray1.getWidth(i); j++) {
				if ((getBrickAt(i,j) != null) && ball.intersects(getBrickAt(i,j))) {
					numHit++;
					if (numHit < 2) {
						if (ball.intersects(getBrickAt(i,j).getX() + 2, getBrickAt(i,j).getY(), getBrickAt(i,j).getWidth() - 4, getBrickAt(i, j).getHeight())) {
							ball.setYSpeed(ball.getYSpeed() * -1);
						} else if (ball.intersects(getBrickAt(i,j).getX(), getBrickAt(i,j).getY(), 2, getBrickAt(i,j).getHeight())) {
							ball.setXSpeed(ball.getXSpeed() * -1);
						} else if (ball.intersects(getBrickAt(i,j).getX() + getBrickAt(i,j).getWidth() - 1, getBrickAt(i,j).getY(), 2, getBrickAt(i,j).getHeight())) {
							ball.setXSpeed(ball.getXSpeed() * -1);
						}
					}
					brickArray1.removeBrick(i,j);
					setScore(getScore() + 5);
				} //if
			} //for
		} //for
	} //checkBrickCollision

	//Written by Chase
	public void checkPaddleCollision() {
		if (ball.intersects(paddle.getXPos() + 3, paddle.getYPos(),paddle.getWidth() - 6,10)) {
			ball.setYSpeed(Math.abs(ball.getYSpeed()) * -1);
		} else if (ball.intersects(paddle.getXPos(),paddle.getYPos(), 3, paddle.getHeight())) {
			ball.setXSpeed(ball.getXSpeed() * -1);
		} else if (ball.intersects(paddle.getXPos() + paddle.getWidth() - 1,paddle.getYPos(), 3, paddle.getHeight())) {
			ball.setXSpeed(ball.getXSpeed() * -1);
		} //if
	} //checkPaddleCollision
} //Panel