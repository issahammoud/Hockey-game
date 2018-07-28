import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	private int sc1=0,sc2=0;
	private String player1,player2,str;
	private Font font=new Font("Berlin Sans FB",Font.PLAIN,20);
	
	public Label(String player1,String player2,int sc1,int sc2){
		
	this.player1=player1;
	this.player2=player2;
	this.sc1=sc1;
	this.sc2=sc2;
	this.setHorizontalAlignment(JLabel.CENTER);
	this.setForeground(Color.red);
	this.setFont(font);
	this.setText(this.player1+"  "+ this.sc1 + " - "+this.sc2+"  "+this.player2);
		
	}
	
	public Label(String player1,int sc1,int sc2){
		
		this.player1=player1;
		this.player2="Computer";
		this.sc1=sc1;
		this.sc2=sc2;
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.blue);
		this.setFont(font);
		this.setText(this.player1+"  "+ this.sc1 + " - "+this.sc2+"  "+this.player2);
		
		}
	
	
}
