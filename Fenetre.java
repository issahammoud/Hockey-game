
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;


	public class Fenetre extends JFrame implements MouseMotionListener,KeyListener,MouseListener{
		
		public int x=2;
		public int x1,y1,x2=230,y2=710,x3=230,y3=50;
		
		public boolean backX=false;
		public boolean backY=false;
		public boolean goal;
		public boolean isTwo;
		
		public int sc1=0,sc2=0;
		public String player1="",player2="";
		public String about;
		
		public Panneau pan = new Panneau(false);
		public JLabel score=new JLabel();
		public Thread t,th,compTh,onePlayThread;	
		public Font font=new Font("Consolas",Font.PLAIN,18);
		public JOptionPane jop=new JOptionPane();
		public JOptionPane jop1=new JOptionPane();
		public JMenuBar menuBar=new JMenuBar();
		public JMenu newgame=new JMenu("New Game"),
				level=new JMenu("Level"),
				help=new JMenu("Help"),
				file=new JMenu("Game"),
				size=new JMenu("Size");
		
		public JRadioButtonMenuItem play1=new JRadioButtonMenuItem("1 player"),
				play2=new JRadioButtonMenuItem("2 player"),
						easy=new JRadioButtonMenuItem("Easy"),
						medium=new JRadioButtonMenuItem("Medium"),
						hard=new JRadioButtonMenuItem("Hard"),
						smallBall=new JRadioButtonMenuItem("20"),
						mediumBall=new JRadioButtonMenuItem("25"),
						bigBall=new JRadioButtonMenuItem("30");
						
		public JMenuItem apropos=new JMenuItem("About"),
				pause=new JMenuItem("Pause"),
				resume=new JMenuItem("Resume"),
				exit=new JMenuItem("Exit");
		public ButtonGroup bg = new ButtonGroup();
		public ButtonGroup bg1 = new ButtonGroup();
		public ButtonGroup bg2 = new ButtonGroup();
		
		
		public Fenetre() {
			
			
			this.setTitle("Hockey");
			this.setSize(600,800);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			score.setHorizontalAlignment(JLabel.CENTER);
			score.setForeground(Color.red);
			score.setFont(font);
			score.setText("------------");
			
			this.getContentPane().add(pan,BorderLayout.CENTER);
			this.getContentPane().add(score,BorderLayout.NORTH);
			
			about="About programer\n"+"------------------------\n";
			about+="I' am Issa Hammoud , an electrical and telecommunication engineering student.\n";
			about+="I study at Lebanese University,faculty of engineering- Branch III.\n";
			about+="I have a mania in programming , and it's my first game with graphical user interface.\n";
			about+="I hope you like it ;)\n\n\n";
			about+="About the game\n"+"------------------------\n";
			about+="this game is written using Java language with eclipse IDE.\n";
			about+="You can chose a level of difficulty and in each level , you can chose a ball size.\n";
			about+="To play a game, you also need to chose 1 or 2 players.\n";
			about+="Press alt-g to open the Game menu , then 'p' to pause , 'r' to resume or 'e' to exit...\n ";
			about+="You can ,during a game, change ball's size and game's level.\n";
			about+="The first one who put 12 balls in the goal win.";
			
			this.addMouseMotionListener(this);
			this.addKeyListener(this);
			this.addMouseListener(this);		
			this.initMenu();
			this.setVisible(true);
			
			
		}
		
		
		private void go() {
			
	th=new Thread(new TimeThread());
	th.start();
			
		x1=pan.getPosX();
		y1=pan.getPosY();
			

		while (true) {

	
			if((x1>pan.getWidth()/2-35 && x1<pan.getWidth()/2 +35 && ((y1<54 &&y1>25) || (y1>669 && y1<698))) || goal==true)
				{
				
				goal=true;
				int i,j;
				
				i=((int)System.currentTimeMillis())%200;
				if(i<0)i=-i;
				j=(int)(Math.random()*100000);
				
				switch(j%4){
				case 0:backX=true;
						backY=true;
						break;
					
				case 1: backX=false;
						backY=false;
						break;
				
				case 2: backX=true;
						backY=false;
						break;
				case 3: backX=false;
						backY=true;
						break;
				}
			
				
					if(((x1>pan.getWidth()/2-35 && x1<pan.getWidth()/2 +35) && (y1<54 && y1>25)))
						{
						sc1++;
						pan.setPosY(290+i);
						pan.setPosX(300+i);
							
						
						
							
						th=new Thread(new TimeThread());
						th.start();
				
						}
					
					else 	if(((x1>pan.getWidth()/2-35 && x1<pan.getWidth()/2 +35) && (y1>669 && y1<698)))
						{
						sc2++;
						pan.setPosY(290+i);
						pan.setPosX(300+i);
						
						
						th=new Thread(new TimeThread());
						th.start();
						}
						
						
		
					
				
					x1=pan.getPosX();
					y1=pan.getPosY();
					
					if(sc1==12)
						break;
					
					else if(sc2==12)						
						break;
					
				}
			if(goal==false) {	
				
				
			
			if(x1>=x2-pan.getDim() && x1<=x2+126 && (y1+pan.getDim()>=y2-2 && y1+pan.getDim()<=y2+7))
		
				backY=true;
			
			
			if(x1>=x3-pan.getDim() && x1<=x3+126 && y1+pan.getDim()>=y3-2 && y1+pan.getDim()<=y3 +7)
				backY=true;
			
			if(x1>=x2-pan.getDim() && x1<=x2+126 && (y1>=y2+3 && y1<=y2+12))
		
				backY=false;
			
			
			
			if(x1>=x3-pan.getDim() && x1<=x3+126 && (y1>=y3+3 && y1<=y3+12))
				backY=false;
			
				
		if (x1 < 5)
			backX=false;
	

		if (x1 > pan.getWidth() -(pan.getDim()-6))
			backX = true;

		if (y1 < 26)
			backY=false;
		
		if (y1>678)
			backY = true;

			
			
			
		if (!backX)
		{x1++;
			pan.setPosX(++x1);
		}
		
		
		else
		{	x1--;
			pan.setPosX(--x1);
		}
		
		if (!backY)
		{	y1++;
			pan.setPosY(++y1);
		}
		
		else 
		{	y1--;
			pan.setPosY(--y1);
		}
		

			}
		pan.repaint();
		
		try {
		Thread.sleep(x,5000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
		
		pan.setBool(false);
		this.getContentPane().setCursor(getCursor());
		
		play2.setEnabled(true);
		play1.setEnabled(true);
		pan.repaint();
		
		
		
		}
		
		class ClassThread implements Runnable{
			public void run(){
				go();
			}
		}
	
		class TimeThread implements Runnable{
			public void run(){
			goal=true;
				score.setForeground(Color.blue);
				if(sc1!=12 && sc2!=12){
					
					
				score.setText("3");
				try{
					Thread.sleep(400);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				score.setText("2");
				try{
					Thread.sleep(400);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				score.setText("1");
				try{
					Thread.sleep(400);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				score.setText("Go");
				try{
					Thread.sleep(400);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				goal=false;
				}
				score.setForeground(Color.red);
				
				score.setText(player1+"  "+sc1 + " - "+sc2+"  "+player2);
			if(sc1==12){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				score.setText("Winner is :"+player1+"---------"+"Loser is :"+player2);
				
			}
			if(sc2==12){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
				score.setText("Winner is :"+player2+"---------"+"Loser is :"+player1);
				}
			}
		}


		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		
			
			x2=e.getX();
			  y2=e.getY();
			 if(x2>=getWidth()-131)x2=pan.getWidth()-131;
			 if(x2<5)x2=5;
			pan.setX1(x2);
			
			if(y2>688)y2=688;
			if(y2<500)y2=500;
			
			pan.setY1(y2);
			

		/*	if(!isTwo){
				
				/*if(x1<x3)
					x3-=125;
				if(x1>x3+125)
					x3+=125;
				x3=x1-63;
					if(y1<y3+3)
				y3-=40;
			if(y1>y3+13)
				y3+=10;
			//y3=y1-10;
				if(x3<5)x3=5;
				if(x3>pan.getWidth()-131)x3=pan.getWidth()-131;
				if(y3<26)y3=26;
				if(y3>216)y3=216;
				
				pan.setX2(x3);
				pan.setY2(y3);
			}*/
			

		}


		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		
			x2=e.getX();
			  y2=e.getY();
			 if(x2>=getWidth()-131)x2=pan.getWidth()-131;
			 if(x2<5)x2=5;
			pan.setX1(x2);
			
			if(y2>688)y2=688;
			if(y2<500)y2=500;
			
			pan.setY1(y2);
			
		/*		if(!isTwo){
				
				/*if(x1<x3)
					x3-=125;
				if(x1>x3+125)
					x3+=125;
				x3=x1-63;
					if(y1<y3+3)
				y3-=40;
			if(y1>y3+13)
				y3+=10;
			//y3=y1-10;
				if(x3<5)x3=5;
				if(x3>pan.getWidth()-131)x3=pan.getWidth()-131;
				if(y3<26)y3=26;
				if(y3>216)y3=216;
				
				pan.setX2(x3);
				pan.setY2(y3);
			}*/
			
		}
			
		
			


		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		if(isTwo){
			
			x3=pan.getX2();
			 y3=pan.getY2();
			if(e.getKeyCode()==39 && x3<pan.getWidth()-131)
			{
				
				x3+=60;
				if(x3>pan.getWidth()-131)
				 x3=pan.getWidth()-131;
				pan.setX2(x3);
			}
			if(e.getKeyCode()==37 && x3>5)
			{
				
				x3-=60;
				if(x3<5) x3=5;
				pan.setX2(x3);
			}
			if(e.getKeyCode()==38 && y3>26)
			{
				y3-=10;
					
				if(y3<26) y3=26;
				
				pan.setY2(y3);
			}
		if(e.getKeyCode()==40 && y3<226){
			
			y3+=10;
				
			if(y3>216) y3=216;
			pan.setY2(y3);
		}
			}
		}
		


		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

			if(isTwo){
				x3=pan.getX2();
				 y3=pan.getY2();
				if(e.getKeyCode()==39 && x3<pan.getWidth()-131)
				{
					
					x3+=60;
					if(x3>pan.getWidth()-131)
					 x3=pan.getWidth()-131;
					pan.setX2(x3);
				}
				if(e.getKeyCode()==37 && x3>5)
				{
					
					x3-=60;
					if(x3<5) x3=5;
					pan.setX2(x3);
				}
				if(e.getKeyCode()==38 && y3>26)
				{
					y3-=10;
						
					if(y3<26) y3=26;
					
					pan.setY2(y3);
				}
			if(e.getKeyCode()==40 && y3<226){
				
				y3+=10;
					
				if(y3>216) y3=216;
				pan.setY2(y3);
			}
				}
				
		}		


		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		if(isTwo){
				x3=pan.getX2();
				 y3=pan.getY2();
				if(e.getKeyCode()==39 && x3<pan.getWidth()-131)
				{
					
					x3+=60;
					if(x3>pan.getWidth()-131)
					 x3=pan.getWidth()-131;
					pan.setX2(x3);
				}
				if(e.getKeyCode()==37 && x3>5)
				{
					
					x3-=60;
					if(x3<5) x3=5;
					pan.setX2(x3);
				}
				if(e.getKeyCode()==38 && y3>26)
				{
					y3-=10;
						
					if(y3<26) y3=26;
					
					pan.setY2(y3);
				}
			if(e.getKeyCode()==40 && y3<226){
				
				y3+=10;
					
				if(y3>216) y3=216;
				pan.setY2(y3);
			}
				}
				
				
		}
		
		
		
		public void initMenu(){
			file.add(newgame);
			file.add(level);
			file.add(size);
			file.add(pause);
			file.add(resume);
			file.add(exit);
			help.add(apropos);
			resume.setEnabled(false);
			pause.setEnabled(false);
			
			file.setMnemonic('g');
			help.setMnemonic('h');
			pause.setMnemonic('p');
			newgame.setMnemonic('n');
			resume.setMnemonic('r');
			exit.setMnemonic('e');
			size.setMnemonic('s');
			level.setMnemonic('l');
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
			pause.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				
					
					t.stop();
					pause.setEnabled(false);
					resume.setEnabled(true);
					getContentPane().setCursor(getCursor());
					
				}
			});
			
			resume.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					t=new Thread(new ClassThread());
					t.start();
					resume.setEnabled(false);
					pause.setEnabled(true);
					BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

				
					Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					    cursorImg, new Point(0, 0), "blank cursor");

				
					getContentPane().setCursor(blankCursor);
					
				}
			});
			play2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					isTwo=true;
					th=new Thread(new TimeThread());
					t=new Thread(new ClassThread());
						
						pan.setBool(true);
						
						pause.setEnabled(true);
						
					BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

					// Create a new blank cursor.
					Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					    cursorImg, new Point(0, 0), "blank cursor");

					// Set the blank cursor to the JFrame.
					getContentPane().setCursor(blankCursor);
					sc1=sc2=0;
					player1=jop1.showInputDialog(null,"Nom du premier joueur","Nom du premier joueur",JOptionPane.QUESTION_MESSAGE);
					player2=jop1.showInputDialog(null, "Nom du deuxième joueur","Nom du deuxième joueur", JOptionPane.QUESTION_MESSAGE);
					score.setText(player1+"  "+ sc1 + " - "+sc2+"  "+player2);
					
					play2.setEnabled(false);
					play1.setEnabled(true);
					
					t.start();
				
					
					goal=false;
					}
					
				
				
			});
			
			play1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					isTwo=false;
					player2="artificiel intelligence";
					th=new Thread(new TimeThread());
					t=new Thread(new ClassThread());
						
						pan.setBool(true);
						
						pause.setEnabled(true);
						
					BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

					// Create a new blank cursor.
					Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					    cursorImg, new Point(0, 0), "blank cursor");

					// Set the blank cursor to the JFrame.
					getContentPane().setCursor(blankCursor);
					sc1=sc2=0;
					player1=jop1.showInputDialog(null,"Nom du joueur","Nom du joueur",JOptionPane.QUESTION_MESSAGE);

					score.setText(player1+"  "+ sc1 + " - "+sc2+"  "+player2);
					
					
					play1.setEnabled(false);
					play2.setEnabled(true);
					
					t.start();
				
					
					goal=false;

				}
			});
			easy.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				
					x=3;
				}
			});
			medium.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
			
					x=2;
				}
			});
			hard.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				
					x=1;
				}
			});
			
			bg.add(easy);
			bg.add(medium);
			bg.add(hard);
			bg1.add(play1);
			bg1.add(play2);
			bg2.add(smallBall);
			bg2.add(mediumBall);
			bg2.add(bigBall);
			newgame.add(play1);
			newgame.add(play2);
			
			level.add(easy);
			level.add(medium);
			level.add(hard);
			
			medium.setSelected(true);
			
			size.add(smallBall);
			size.add(mediumBall);
			size.add(bigBall);
			
			smallBall.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pan.setDim(20);
				}
			});
			
			mediumBall.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pan.setDim(25);
				}
			});
			
			bigBall.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pan.setDim(30);
				}
			});
			
			mediumBall.setSelected(true);
			
			apropos.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					jop.showMessageDialog(null, about,"Help",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			
			menuBar.add(file);
			menuBar.add(help);
			this.setJMenuBar(menuBar);
		}
		
	

		public static void main(String[] args) {
			new Fenetre();
		}


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
			onePlayThread=new Thread(new OnePlayThread());
			onePlayThread.start();
				
				
			
		}


		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
			onePlayThread=new Thread(new OnePlayThread());
			onePlayThread.start();
			
			}
		


		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		class OnePlayThread implements Runnable{
			public void run(){
			while(!isTwo){
				if(x1<x3)
					x3--;
					
				if(x1>x3+125)
					x3++;
					
				if(y1<y3+3)
		if(x==3)	y3--;
		else y3-=3;
		
				if(y1>y3+13)
				if(x==3)	y3++;
				else y3+=2;
				
			if(x3<5)x3=5;
			if(x3>pan.getWidth()-131)x3=pan.getWidth()-131;
			if(y3<26)y3=26;
			if(y3>216)y3=216;
			
			pan.setX2(x3);
			pan.setY2(y3);
			try{
				if(x==1)
				Thread.sleep(15);
				else if(x==2)
					Thread.sleep(35);
				else if(x==3)
					Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			}
		}
	}
	}	