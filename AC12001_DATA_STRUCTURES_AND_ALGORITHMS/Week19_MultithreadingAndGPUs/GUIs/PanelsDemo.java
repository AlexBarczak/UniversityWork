/*
 * From: Programming with Java: A multimedia approach example
 * PanelsDemo 
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.geom.*;

public class PanelsDemo {
	/**
	 * Standard Swing main method that creates a new thread
	 * @param args usual input args
	 */
	 public static void main(String [] args) {
		 
		 /* Short-hand way of starting a Swing GUI in a separate thread.
		  * Using an annonymous class
		  */
//	    javax.swing.SwingUtilities.invokeLater(new Runnable()
//	    {
//	    	public void run(){
//				runProgram();
//			}
//	    });

		/** This is a longer way of writing out a common
		 *  piece of code used to start GUIs in a separate thread. 
		 */
		class MyGuiThread implements Runnable {
			public void run(){
				runProgram();
			}
		}
		
		MyGuiThread myGui = new MyGuiThread();
		javax.swing.SwingUtilities.invokeLater(myGui);
	 }
	
	
/**
 * Runs the GUI program in its own thread
 */
  public static void runProgram() {
    JFrame window = new JFrame();
      
    // create three panels
    JPanel topPanel = new JPanel();
    JPanel panel1 = new JPanel();

   // Create a panel specifically for drawing graphics on 
    JPanel drawingPanel = new JPanel() {
    	
	/**
	* Override the paint component to draw on the panel
	*/
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D myGraphics = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Float(100, 100, 100, 200);
        Rectangle2D rectangle = new Rectangle2D.Float(200, 200, 100, 50);
        myGraphics.draw(circle);
        myGraphics.draw(rectangle);
       }
    };

    // add panel1, panel2, drawingPanel to topPanel
    topPanel.add(panel1);
    topPanel.add(drawingPanel);

    // set topPanel as content pane for this window
    window.setContentPane(topPanel);
      
    // add two buttons to panel1
    JButton button1 = new JButton("Rectangle");
    panel1.add(button1);
    JButton button2 = new JButton("Circle");
    panel1.add(button2);
      
    // set the size of drawingPanel
    drawingPanel.setPreferredSize(new Dimension(400, 400));
       
    window.setSize(800, 500);
    window.setTitle("Panels Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

