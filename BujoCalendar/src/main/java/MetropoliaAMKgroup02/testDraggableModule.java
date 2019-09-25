package MetropoliaAMKgroup02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class testDraggableModule extends JComponent {

	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;

	public testDraggableModule() {
		setBorder(new LineBorder(Color.BLACK, 3));
		setBackground(Color.WHITE);
		setBounds(0, 0, 150, 100); //leveys, korkeus
		setOpaque(false);

		addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) { }

			public void mousePressed(MouseEvent e) {
				screenX = e.getXOnScreen();
				screenY = e.getYOnScreen();

				myX = getX();
				myY = getY();
			}

			public void mouseReleased(MouseEvent e) { }

			public void mouseEntered(MouseEvent e) { }

			public void mouseExited(MouseEvent e) { }

		});
		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getXOnScreen() - screenX;
				int deltaY = e.getYOnScreen() - screenY;

				setLocation(myX + deltaX, myY + deltaY);
			}

			public void mouseMoved(MouseEvent e) { }

		});
	}

}

