package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Obstacle  extends GameObject{
	
	
	
	public boolean rotated=false;
	Image im;
	
	public Obstacle(int x,int y)
	{
		super(x,y);
		
		im=new ImageIcon("img/obstacle.png").getImage();
		
	}

	
	
	public void draw(Graphics g)
	{
		g.drawImage(im, x*50, y*50,50,50,null);

	}

}
