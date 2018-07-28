import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Panneau extends JPanel {
	

	private int posX =250;
	private int posY=350;
	
	private  int x1=230;
	private int x2=230;
	
	private int y1=680;
	private int y2=90;
	
	private int dim=25;
	
	public boolean b=false;
	public Panneau(boolean b){
		this.b=b;

	}
	
	public void paintComponent(Graphics g) {

		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.red);
		for(int i=0;i<3;i++)
			g.drawLine(2, 700-i, this.getWidth()-3, 700-i);
		
		for(int i=0;i<3;i++)
			g.drawLine(2, 24+i, this.getWidth()-3, 24+i);
		
		for(int i=0;i<3;i++)
			g.drawLine(2+i, 26, 2+i, 698);
		
		for(int i=0;i<3;i++)
			g.drawLine(getWidth()-3-i, 26, getWidth()-3-i, 698);
		
		g.setColor(Color.green);
		g.fillArc(this.getWidth()/2 -40, 668, 80, 60, 0, 180);
		
		g.setColor(Color.red);
		g.drawArc(this.getWidth()/2 -40, 668, 80, 60, 0, 180);
		
	
		
		g.setColor(Color.green);
		g.fillArc(this.getWidth()/2 -40, -3, 80, 60, 0, -180);
		
		g.setColor(Color.red);
		g.drawArc(this.getWidth()/2 -40,-3, 80, 60, 0,-180);
		
		g.setColor(Color.blue);
		for(int i=0;i<3;i++)
			g.drawLine(5, 500-i, this.getWidth()-6, 500-i);
		
		for(int i=0;i<3;i++)
			g.drawLine(5, 226+i, this.getWidth()-6, 226+i);
		
		g.setColor(Color.red);
		for(int i=0;i<3;i++){
			for(int j=2;j<this.getWidth()-3;j++)
				if(j%6!=0)
					g.drawLine(j, 363+i, j, 363+i);
		}
		g.drawLine(2, this.getHeight()/2+3, this.getWidth()-3, this.getHeight()/2+3);
		g.drawLine(2, this.getHeight()/2-1, this.getWidth()-3, this.getHeight()/2-1);
		
		g.setColor(Color.green);
		g.drawOval(this.getWidth()/2-80, this.getHeight()/2-80, 160, 160);
		
	
		
		
	if(b==true){	

		g.setColor(Color.black);

		g.fillOval(posX, posY, dim, dim);
		
		g.setColor(Color.black);
	
		
		g.fillRoundRect(x1,y1, 125, 10, 10, 10);
		
		
		g.setColor(Color.black);
		
		
		g.fillRoundRect(x2,y2, 125, 10, 10, 10);
		
		
}

		
}
	

	

	public int getPosX() {
		return posX;
		}

	public void setPosX(int posX) {
		this.posX = posX;
		}

	public int getPosY() {
		return posY;
		}

	public void setPosY(int posY) {
		this.posY = posY;
		}

	
	public void setX1(int x){
		this.x1=x;
	}
	
	public void setX2(int x){
		this.x2=x;
	}
	
	public int getX2(){
		return this.x2;
	}
	
	public void setY1(int y){
		this.y1=y;
	}
	
	public void setY2(int y){
		this.y2=y;
	}
	
	public int getY2(){
		return this.y2;
	}
	
	public void setBool(boolean b){
		this.b=b;
	}
	
	public void setDim(int dim){
		this.dim=dim;
	}
	
	
	public int getDim(){
		return this.dim;
	}
	
	public int getX1(){
		return this.x1;
	}
	public int getY1(){
		return this.y1;
	}
}
