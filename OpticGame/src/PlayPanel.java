import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameObjects.Light;
import GameObjects.Mirror;

public class PlayPanel extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
	
	boolean playing;
	public  Timer t;
	static GameWorld world;
	
	Mirror tempMirror;
	public boolean start;
	
	
	Image currentIm;
	boolean[] addingMirror;
	
	
	int mouseX,mouseY;
	GamePanel contentPane;
	File[] files;
	int selected;
	public PlayPanel(File[] files,int selected,GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		setBounds(0,0,700,600);
		setLayout(null);
		this.files=files;
		this.selected=selected;
		this.contentPane=gamePanel;
		currentIm=new ImageIcon("img/0derece.png").getImage();
		
		addingMirror=new boolean[8];
		for(int a=0;a<8;a++)
			addingMirror[a]=false;
		
		addMouseMotionListener(this);
		addMouseListener(this);
		start=true;
		
		playing=false;
	
		
		 world=new GameWorld(files[selected].getPath(),this);
		
		 t=new Timer(50, this);
		t.start();
	}
	
	public  void lostGame()
	{
		t.stop();
		int n = JOptionPane.showOptionDialog(null,
	            "You loose.. repeat?",
	            "A Title",
	            JOptionPane.YES_NO_CANCEL_OPTION,
	            JOptionPane.DEFAULT_OPTION,
	            null,
	            null,
	            null);  
				world.reset();
				
		if(n==0)
		{
			t=new Timer(150,this );
			t.start();	
		}
		else
		{
			contentPane.gomain();
		}
			
	}
	public void win()
	{
		t.stop();
		int n = JOptionPane.showOptionDialog(null,
	            "You won.. Go to the next level?",
	            "A Title",
	            JOptionPane.YES_NO_CANCEL_OPTION,
	            JOptionPane.DEFAULT_OPTION,
	            null,
	            null,
	            null);  
		
		if(n==0)
		{
			if(selected<files.length)
			{
				selected++;
				 world=new GameWorld(files[selected].getPath(),this);
				 start=false;
				 t=new Timer(150,this );
					t.start();	

			}
			else
			contentPane.gomain();
		}
		else
		{
			contentPane.gomain();
		}
		JOptionPane.showMessageDialog(this, "YOU WON....");
		
	

	}
	public void paintComponent(Graphics g)
	{
		
		world.drawWorld(g);
		
		for(int a=0;a<8;a++)
			if(addingMirror[a])
		g.drawImage(currentIm, mouseX-25, mouseY-25,50,50, this);
	

		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==t) {
			
			if(playing)
			{
				world.step();

			}
			
			
			
		}
		repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mouseX=e.getX();
		this.mouseY=e.getY();
		repaint();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x=e.getX()/50;
		int y=e.getY()/50;
		for(int a=0;a<8;a++)
		{
			if(addingMirror[a]==true)
			{
				world.addMirror(x, y, a,currentIm);
			}
		}
		
		for(int a=0;a<8;a++)
			addingMirror[a]=false;
	
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
