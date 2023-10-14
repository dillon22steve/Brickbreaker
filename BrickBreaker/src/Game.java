import UI.*;

//This class was mostly written by Steve, except for the end method, which
//was written by Chase
public class Game implements Runnable {
	
	private Frame gameFrame;
	private Panel gamePanel;
	private StartUpPanel startPanel;
	private GameOverPanel endPanel;

	private Thread gameThread;

	//The desired number of frames, updates, and opacity updates per second.
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	private final int OPACITY_UPDATE = 200;

	//Counting the number of frames and updates.
	private int frames = 0;
	private int updates = 0;

	//The time stamp of the last FPS and UPS check.
	private long lastCheck = 0;
	
	//Written by Steve
	public Game() {
		startPanel = new StartUpPanel();
		endPanel = new GameOverPanel();
		gamePanel = new Panel();
	    gameFrame = new Frame(startPanel, gamePanel, endPanel);
	    startPanel.requestFocus();
		start();
	} //constructor

	//Written mostly by Chase
	private void end() {
		gameFrame.endGame();
		endPanel.requestFocus();
		long last = System.currentTimeMillis();

		long now = System.nanoTime();
		long lastOpacityUpdate = System.nanoTime();

		while(!endPanel.getGameStart()) {
			now = System.nanoTime();

			//written by Steve
			if(now - lastOpacityUpdate >= OPACITY_UPDATE) {
				lastOpacityUpdate = now;
				endPanel.updateOpacity();
				endPanel.repaint();
			} //if
		} //while
		gameFrame.dispose();
		Driver.newGame = true;
	} //end


	//Written by Steve
	private void start() {
		long last = System.currentTimeMillis();
		long now = System.nanoTime();
		long lastOpacityUpdate = System.nanoTime();

		//This paints the start screen until the user presses enter. Then getGameStart will return true and
		//the loop will break.
		while (!startPanel.getGameStart()) {
			now = System.nanoTime();

			if(now - lastOpacityUpdate >= OPACITY_UPDATE) {
				lastOpacityUpdate = now;
				startPanel.updateOpacity();
				startPanel.repaint();
			} //if
		} //while

		//Starts the game.
		startGameLoop();
	} //start
	

	//Written by Steve
	private void startGameLoop() {
		gameFrame.startGame();

		//This line is to direct your keyboard and mouse inputs to the Game Panel. Without it,
	    //your input won't do anything on the screen.
		gamePanel.requestFocus();

		gameThread = new Thread(this);
		gameThread.setDaemon(true);
		gameThread.start();
	} //startGameLoop
	

	//Written by Steve
	@Override
	public void run() {
		
		double timePerFrame = (1_000_000_000.0 / FPS_SET);
		double timePerUpdate = (1_000_000_000.0 / UPS_SET);
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long now = System.nanoTime();
		
		while(!gamePanel.getGameOver()) {
			now = System.nanoTime();
			
			/*
			* This block of code is used to test that the FPS and UPS are working correctly.
			*
			//If the current time is less than the last time the FPS and UPS were printed to the console is greater than
			//1 second.
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			} //if
			*
			*/
			
			//If the current time minus the last time a frame was painted is greater than the 120 FPS interval we want,
			//then it will paint another frame.
			if ((now - lastFrame) >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			} //if
			
			//If the current time minus the last time the game was updated is greater than the 200 UPS interval we want,
			//then it will update the game
			if((now - lastUpdate) >= timePerUpdate) {
				gamePanel.update();
				lastUpdate = now;
				updates++;
			} //if

		} //while

		end();
		
	} //run
	
} //Game

