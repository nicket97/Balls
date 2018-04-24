import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Start {
	static ArrayList<Ball> balls = new ArrayList<Ball>();
	
	final static double  g = 9.82;
	final static int  height = 1000;
	final static int  width = 1000;
	public static void main(String args[]){
		balls.add (new Ball(500,500,0,40, Color.red));
		balls.add ( new Ball(200,500,0,40, Color.blue));
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new Canvas();
		canvas.setSize(width,height);
		frame.add(canvas);
		frame.setSize(1200,1200);;
		frame.setVisible(true);
		while(true){
			
			canvas.update(canvas.getGraphics());
			for(Ball b : balls){
				b.updatePos();
				
			}
			for(Ball b : balls){
				for(Ball collide : balls){
					if(collide.equals(b)){
						break;
					}
					else{
						b.checkCollition(collide);
					}
				}
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
