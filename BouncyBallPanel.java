/*
 * Donald Trowbridge
 * Module 7 Programming lab
 * 
 * Creates panel where the ball objects are added with a click of the mouse
 *
 */

package bouncyball;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BouncyBallPanel extends JPanel implements MouseListener
{
    private Graphics g;//creates graphics object
    private BouncyBall ball = new BouncyBall(75,75,25,25); //creates first ball
    ExecutorService exe = Executors.newCachedThreadPool();//manages threads
    private ArrayList<BouncyBall> balls = new ArrayList<BouncyBall>();//contains ball objs
    public BouncyBallPanel()
    {
 
        balls.add(ball);//adds first precreated ball obj to the arraylist
        exe.execute(ball);//adds first ball to executor service
        this.addMouseListener(this);//adds mouselistener to panel
    }
    
    //paints to panel
    public void paint(Graphics g)
    {
        super.paint(g);
        super.setBackground(Color.white);//sets background to white.
        for(BouncyBall ball: balls) //adds all balls as the gui is painted.
            ball.draw(g);
    }
    //adds new ball objs
    @Override
    public void mouseClicked(MouseEvent click)
    {
        //gets position of mouse click
        int x = click.getX();
        int y = click.getY();
        //adds ball obj at location of click
        BouncyBall ball2 = new BouncyBall(x,y, 20,20);
        balls.add(ball2);//adds ball to array
        this.repaint();// repaints to panel as soon as the ball is added
        exe.execute(ball2);//adds new ball thread to the executor
    }
    
    //micellaneous mouse listeners added as part of implementation of the class
    public void mouseExited(MouseEvent e){}       
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
}
