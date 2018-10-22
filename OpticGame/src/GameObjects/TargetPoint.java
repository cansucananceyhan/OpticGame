package GameObjects;

import java.awt.Color;
import java.awt.Graphics;

public class TargetPoint  extends GameObject implements Runnable{

	public static int width=50,height=50;
	Color color2;
	Color color1;
	int cred;
	int cgreen;
	int cblue;
	Thread paintThread;
	public TargetPoint(int x,int y)
	{
		super(x,y);
		color2=Color.RED;
		color1=Color.green;
		
		
		cred=color1.getRed();
		cgreen=color1.getGreen();
		cblue=color1.getBlue();
		
		paintThread=new Thread(this);
		paintThread.start();
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawOval(x, y, 50, 50);
		g.setColor(new Color(cred, cgreen, cblue));
		g.fillOval(x, y, 50, 50);
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
}
