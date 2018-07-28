import java.awt.BorderLayout;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Window extends JWindow{
	
	public Thread t;
	public JProgressBar bar;
	public Background pan=new Background(true,true);

	
	public Window(){
		
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		
		
		t=new Thread(new Traitement());
		
		bar=new JProgressBar();
		bar.setMaximum(250);
		bar.setMinimum(0);
		bar.setStringPainted(true);
		t = new Thread(new Traitement());
		t.start();
	

		this.getContentPane().add(bar,BorderLayout.SOUTH);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}

	class Traitement implements Runnable{
		public void run(){
		
			for(int val = 0; val <= 250; val++){
				bar.setValue(val);
				
				try{
					t.sleep(10);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
			setVisible(false);
	new Fenetre();
		
		}
}
}
