package UI;

import java.awt.*;
import javax.swing.JPanel;
import Inputs.KeyboardInputs;
import java.awt.event.KeyEvent;

//This class was written by Chase, except for the updateOpacity method, 
//which was written by Steve.
public class GameOverPanel extends JPanel{

    static int titleX = 105;
    boolean gameStart = false;
    static String title;

    private float opacity = 150;
    private float opacityUpdate = 0.000022f;

    //Written by Chase
    public GameOverPanel() {
        addKeyListener(new KeyboardInputs(this));
        setBackground(Color.BLACK); 
        title = "GAME OVER";
    } //StartUpPanel


    //Written by Chase
    static void setTitleWin() {
        title = "You Win!";
        titleX = 210;
    }  //setTitleWin


    //Written by Chase
    public void startGameKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                gameStart = true;
                break;
        } //switch
    } //startGameKey


    public boolean getGameStart() {
        return gameStart;
    } //getGameStart
  

    //Written by Chase, updated by Steve to add the opacity updates to the "Press Enter to Start"
    //text
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean foundI = false;
        g.setColor(Color.gray);
        g.setFont(new Font ("Monospaced Bold",1,125));
        g.drawString(title,titleX,375);
        g.setColor(Color.yellow);
        g.setFont(new Font ("Arial", 1, 25));

        g.setColor(new Color(Color.yellow.getRed(), Color.yellow.getGreen(), Color.yellow.getBlue(), (int)(opacity)));
        g.drawString("Press Enter to Start", 375, 475);
    } //paintComponent


    //Written by Steve
    public void updateOpacity() {
        if (opacity < 0) {
            opacity = 0;
            opacityUpdate *= -1;
        } else if (opacity > 150) {
            opacity = 150;
            opacityUpdate *= -1;
        } //if

        opacity -= opacityUpdate;
    } //updateOpacity
} //GameOverPanel
