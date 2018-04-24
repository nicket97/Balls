import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int x;
	int y;
	double dx;
	double dy;
	int size;
	Color c;
	
	
	public Ball(int x, int y, int speed, int size, Color c){
		this.x = x;
		this.y = y;
		this.dx = 5;
		this.dy = 0;
		this.size = size;
		this.c = c;
	}
	public void updatePos(){
		x += dx;
		y += dy;
		if(y >= Start.height - size-2){
			y = Start.height - size;
			dy *= -1;
		}
		if(x >= Start.width+100 -size){
			x = Start.width+100 -size;
			dx *= -1;
		}
		if(x <= 100+size){
			x = 100 +size;
			dx *= -1;
		}
		
		this.getAfectedByGravity();
	}
	private void getAfectedByGravity() {
		dy = dy + Start.g*0.05;
		
	}
	public void drawBall(Graphics g){
		g.setColor(c);
		g.fillOval(x - size, y - size, 2*size, 2*size);
	}
	public void checkCollition(Ball collide) {
		int diffX = this.x - collide.x;
		int diffY = this.y - collide.y;
		
		if(Math.abs(diffX)*Math.abs(diffX) +  Math.abs(diffY)*Math.abs(diffY)< (this.size + collide.size)*(this.size + collide.size)+5){
			if(this.dx > 0 && collide.dx > 0){
				if(this.x < collide.x){
					this.dx *= -1;
				}
				else{
					collide.dx *= -1;
				}
			}
			else if(this.dx < 0 && collide.dx < 0){
				if(this.dx < collide.dx){
					
					collide.dx += this.dx/2;
					this.dx *= -1;
					
				}
				else{
					this.dx += collide.dx/2;
					collide.dx *= -1;
				}
			}
			else{
				this.dx *=-1;	
				this.dx *=-1;
			}
			
			this.x += dx;
			this.y += dy;

		}
		
	}
	
}
