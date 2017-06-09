	/**
	 * Author: Timothy Field
	 * Class and School: IT 226, Illinois State University 
	 * Instructor: Dr. Rishi Saripalle  
	 * Description: Simple Rectangle Drawing Program using Java Swing  
	 * Date: Updated for posting 6/9/2017, Originally coded in Spring 2016
	 */
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FunWithRectanglesGUI extends JFrame {

	public static void main(String[] args) {

		// MainFrame Setup and Component setup
		JFrame mainFrame = new JFrame("FUN WTIH RECTANGLES");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(1200, 700);
		mainFrame.setVisible(true);
		DrawingRec firstPaint = new DrawingRec();
		mainFrame.add(firstPaint, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}

}
