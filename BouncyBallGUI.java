/*
 * Donald Trowbridge
 * Module 7 Programming lab
 * 
 * This class creates the GUI and adds the panel.
 *
 */


package bouncyball;

import javax.swing.JFrame;

public class BouncyBallGUI extends JFrame
{   
    //creates gui
    public BouncyBallGUI()
    {
        super("Bouncy Ball GUI");
        //sets the size and positions the gui into the middle of the screen
        this.setBounds(675, 250 , 600, 600);
        BouncyBallPanel panel = new BouncyBallPanel();//creates panel object
        this.add(panel);//adds panel to gui
        this.setVisible(rootPaneCheckingEnabled);//sets gui to visible
        this.setDefaultCloseOperation(3); //disposes the gui on close
        
        
        //got this from Mr.McMicheals ball bounce program outline
        while(this.isVisible())//continually repaints the the panel
        {
            panel.repaint();
        }
        panel.exe.shutdown();//closes threads when gui is no longer active.
    }
}
