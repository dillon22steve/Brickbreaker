package Objects;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

//This class was mostly written by Steve, with some additions made by Chase
public class Ball extends Ellipse2D {

    private int x;
    private int y;
    private int width;
    private int height;
    private int xSpeed =2 * (int)Math.pow(-1, Math.ceil(Math.random() * 2));   // 2
    private int ySpeed = -2; // -2

    //Written by Steve
    public Ball() {
        x = (int)(Math.random() * 800 + 100);
        y = 640;
        width = 20;
        height = 20;
    } //constructor


    //Written by Steve
    public void spawnBall(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, width, height);
    } //spawnBall


    //Written by Steve
    public void moveBall() {
        x += xSpeed;
        y += ySpeed;
        if (x <= 0) {
            x = 0;
            xSpeed = xSpeed * -1;
        }
        if (y <= 0) {
            y = 0;
            ySpeed = ySpeed * -1;
        }
        if (x >= 975) {
            x = 975;
            xSpeed = xSpeed * -1;
        } //if
    } //moveBall

    public int getXSpeed() {
        return xSpeed;
    } //getXSpeed

    public int getYSpeed() {
        return ySpeed;
    } //getYSpeed

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    } //setXSpeed

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    } //setYSpeed


    //All of the getters and setters below were written by Chase
    @Override
    public double getX() {
        return x;
    } //getX

    @Override
    public double getY() {
        return y;
    } //getY

    @Override
    public Rectangle2D getBounds2D() {
        throw new UnsupportedOperationException("Unimplemented method 'getBounds2D'");
    } //getBounds2D

    @Override
    public double getWidth() {
       return width;
    } //getWidth

    @Override
    public double getHeight() {
       return height;
    } //getHeight

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    } //isEmpty

    @Override
    public void setFrame(double x, double y, double w, double h) {
        
    } //setFrame

} //Ball
