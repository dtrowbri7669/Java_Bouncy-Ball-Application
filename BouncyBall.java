/*
 * Donald Trowbridge
 * Module 7 Programming lab
 * 
 * Class defines ball objects.
 *
 */
package bouncyball;

import java.awt.Graphics;
import java.awt.Color;
import java.security.SecureRandom;

public class BouncyBall implements Runnable
{
    private int x, y, w, h; //ball attributes
    private int max = 600-65; //sets max value for ball to "hit" the "ground"
    private int sleep;
    private Color[] colors = {Color.red, Color.green, Color.YELLOW, Color.blue,
        Color.yellow};//Color array for ball color
    private Color ballColor; //color attribute for the ball
    private static int count = 0;//count of ball objects
    private boolean UP = false; //direction to define velocity
    private SecureRandom sec = new SecureRandom(); // secure random obj.
    
    public BouncyBall(int x,int y,int w,int h)
    {
       //set attributes of ball
       this.x = x;
       this.y = y;
       this.h = h;
       this.w = w;
       int index = count % (colors.length);//change color based on count of balls
       this.ballColor = colors[index];//set ball color
       count++;//increase count of balls
       //sets random sleep/speed value from 2-10 (1 is super fast, had to exclude)
       sleep = sec.nextInt(9) + 1;
    }
    //draw ball graphic
    public void draw(Graphics g)
    {
       g.setColor(ballColor);//set ball graphic color
       g.fillOval(x, y, w, h);//set ball graphic attributes
    }
    //returns current y pos
    public int getY()
    {
        return this.y;
    }
    //action to be ran 
    public void run()
    {
        /*continual loop to keep the ball moving.
        * Got the while loop from Joe Fett from 
        * https://coderanch.com/t/385918/java/Multithreading-bouncing-balls
        */
        while(true)
        {
        try
        {
         Thread.sleep(sleep); // puts thread asleep
         //decision making for direction the ball should move
         if(this.getY()!= 0 && UP == true)//ball bounces up but doesn't hit boundary
        {
            this.y--;//moves ball up
        }
        else if(this.getY()== 0 && UP == true)//ball hits the boundary on up motion
        {
            //changes ball direction downward
            this.y++; 
            UP = false;
        }
        else if(this.getY() != max && UP == false)//ball is in falling motion but hasn't hit boundary
        {
            //mobes ball down
            this.y++;
        }
        else if(this.getY() == max && UP == false)//ball has hit lower boundary
        {
            //changes ball direction upward
            this.y--;
            this.UP = true;
        }
        }
        catch(InterruptedException exception)
        {
            exception.printStackTrace();
            Thread.currentThread();
        }
        }
    }

}
