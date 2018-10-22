package GameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;


public class Mirror extends GameObject{
	

	Image im;
	public Mirror(int x,int y,Image im)
	{
		super(x,y);
		this.im=im;
	
	}

	
	
	public void draw(Graphics g)
	{
		
		g.drawImage(im, x*50, y*50, 50,50,null);
		
		


	}

}
