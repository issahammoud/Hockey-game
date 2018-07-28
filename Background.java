
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {
	
	public Image img;
	public boolean b;
	public boolean bool=false;
	
public Background(boolean b,boolean bool){
	this.b=b;
	this.bool=bool;
}
	@Override
	public void paintComponent(Graphics g){
		
		if(bool==true){
		
		try{
			if(b==true)img=ImageIO.read(new File("hockey.png"));
			else 
				img=ImageIO.read(new File("rink.jpg"));
				
				
			g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		}
	
	}
}
