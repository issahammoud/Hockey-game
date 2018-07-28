import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton{
	
	
	
	public Button(String name){
		
		Font font=new Font("Berlin Sans FB",Font.PLAIN,20);
		this.setFont(font);
		this.setForeground(Color.blue);
		this.setPreferredSize(new Dimension(160,40));
	
		this.setText(name);
		
	}

}
