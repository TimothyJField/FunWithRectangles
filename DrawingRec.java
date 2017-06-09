/*
 * MouseEvents and Adapters to Receive points, Draw rectangles, etc.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class DrawingRec extends JComponent {
	ArrayList<Rectangle> RectanglesList = new ArrayList<Rectangle>();
	Point start_point;
	Point end_point;

	// Gets start Point
	public DrawingRec() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				start_point = new Point(e.getX(), e.getY());
				end_point = start_point;
				repaint();
			}

			public void mouseReleased(MouseEvent e) {

				// Accounts For Rectangle Being Drawn In Every Direction
				Rectangle rect2 = new Rectangle((Math.min(end_point.x, start_point.x)), (Math.min(end_point.y, start_point.y)),
						Math.abs(end_point.x - start_point.x), Math.abs(end_point.y - start_point.y));

				RectanglesList.add(rect2);
				start_point = null;
				end_point = null;
				repaint();
			}
		});
		// Gets end Point
		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				end_point = new Point(e.getX(), e.getY());
				repaint();
			}
		});
	}

 	public void paintComponent(Graphics graf) {
		Graphics2D graf2 = (Graphics2D) graf;
		// Border
		graf2.setStroke(new BasicStroke(5));
		// Previews Rect
		if (start_point != null && end_point != null) {
			Rectangle rect2 = new Rectangle((Math.min(end_point.x, start_point.x)), (Math.min(end_point.y, start_point.y)),
					Math.abs(end_point.x - start_point.x), Math.abs(end_point.y - start_point.y));
			graf2.drawRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
			graf2.setPaint(Color.red);
			graf2.fillRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
		}
		//// Prints Rect
		for (Rectangle rect2 : RectanglesList) {
			graf2.setPaint(Color.black);
			graf2.drawRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());

		}
	}
}