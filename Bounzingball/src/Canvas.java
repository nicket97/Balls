import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(100, 0, Start.width, Start.height);
		for(Ball b : Start.balls){
			b.drawBall(g);
		}
	}
}

