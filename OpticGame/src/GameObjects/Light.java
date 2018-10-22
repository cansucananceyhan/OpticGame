package GameObjects;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.Timer;


public class Light  extends GameObject implements Runnable{
	

	ArrayList<LightParticle> particles;
	int particleCount;
	
	Color color2;
	Color color1;
	int cred;
	int cgreen;
	int cblue;
	Thread paintThread;

	public int velX=-10;
	public int velY=0; 
	
	int lastHitX=0,lastHitY=0;
	
	public int angle;
	
	public Light(int x,int y)
	{
		super(x,y);
		color2=Color.RED;
		color1=Color.green;
		
		
		cred=color1.getRed();
		cgreen=color1.getGreen();
		cblue=color1.getBlue();
		particleCount=0;
		particles=new ArrayList<LightParticle>();
	
		paintThread=new Thread(this);
		paintThread.start();
		
	
		
	}
	
	
	public void move()
	{
		if(particleCount==5)
		{
			particles.remove(0);
			particles.add(new LightParticle(x, y));
		}
		else
		{
			particles.add(new LightParticle(x, y));
			particleCount++;
		}
		
		x+=velX;
		y+=velY;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(new Color(cred, cgreen, cblue));

		for(int a=1;a<particles.size();a++)
		{
			LightParticle p1=particles.get(a-1);
			LightParticle p2=particles.get(a);

			g2d.drawLine(p1.x,p1.y,p2.x,p2.y);

		}
		
		if(particleCount==0)
		{
			g2d.fillRect(x, y, 8, 8);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int fred=color2.getRed();
		int fgreen=color2.getGreen();
		int fblue=color2.getBlue();
		
		while(true)
		{

			if(fred>cred)
				cred++;
			else if(fred<cred)
				cred--;
			if(fgreen>cgreen)
				cgreen++;
			else if(fgreen<cgreen)
				cgreen--;
			if(fblue>cblue)
				cblue++;
			else if(fblue<cblue)
				cblue--;
			
			
			if(color2.getBlue()==cblue&&color2.getGreen()==cgreen&&color2.getRed()==cred)
			{
				
				fred=color1.getRed();
				fgreen=color1.getGreen();
				fblue=color1.getBlue();

				
				
			}
			else if(cblue==color1.getBlue()&&cred==color1.getRed()&&cgreen==color1.getGreen())
			{
				fred=color2.getRed();
				 fgreen=color2.getGreen();
				 fblue=color2.getBlue();
				
			}
			
			
			try {
				paintThread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		 
		
	}


	public void impact(int check) {
		// TODO Auto-generated method stub
		if(x==lastHitX&&y==lastHitY)
			return;
		if(check==0&&velX==0&&velY>0) {
			velY*=-1;
			
		}
		if(check==1&&velX==0&&velY<0) {
			velY*=-1;
			
		}
		if(check==2&&velX>0&&velY==0)
		{
			velX=0;
			velY=10;
		}
		if(check==2&&velX==0&&velY<0)
		{
			velX=-10;
			velY=0;
		}
		if(check==3&&velX<0&&velY==0)
		{
			velX=0;
			velY=10;
		}
		if(check==3&&velX==0&&velY<0)
		{
			velX=10;
			velY=0;
		}
		if(check==4&&velX==0&&velY>0)
		{
			velX=10;
			velY=0;
		}
		if(check==4&&velX<0&&velY==0)
		{
			velX=0;
			velY=-10;
		}
		if(check==5&&velX>0&&velY==0)
		{
			velX=-10;
			velY=-0;
		}
		if(check==6&&velX<0&&velY==0)
		{
			velX=10;
			velY=0;
		}
		
		
	}

}
