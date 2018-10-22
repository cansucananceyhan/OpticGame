
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import GameObjects.Light;
import GameObjects.Mirror;
import GameObjects.Obstacle;
import GameObjects.TargetPoint;


public class GameWorld {
	
	public Light light;
	public TargetPoint target;
	public ArrayList<Obstacle> obstacles;
	public ArrayList<Mirror> mirrors;
	
	int lastHitAngle=0;
	long currentTime;
	long lastTime;
	
	
	int[][] map;
	
	int basex,basey;
	int basevelx,basevely;
	
	PlayPanel playPanel;
	
	public GameWorld(String text,PlayPanel playPanel)
	{
		lastTime=System.currentTimeMillis();
		map=new int[14][12];
		for(int a=0;a<14;a++)
			for(int b=0;b<12;b++)
			{
				map[a][b]=-1;
			}
		this.playPanel=playPanel;
		
		obstacles=new ArrayList<>();
		mirrors=new ArrayList<>();
		loadMap(text);
		
		basex=light.x;
		basey=light.y;
		basevelx=light.velX;
		basevely=light.velY;
		
		for(int a=0;a<14;a++)
		{
			for(int b=0;b<12;b++)
			{
				System.out.print(map[a][b]+" ");
			}
		System.out.println();
		}
			
		

		
					
		
		
	}
	public void drawWorld(Graphics g)
	{
		target.draw(g);
		
		for(int a=0;a<obstacles.size();a++)
			obstacles.get(a).draw(g);
		for(int a=0;a<mirrors.size();a++)
			mirrors.get(a).draw(g);
		light.draw(g);
		
		
		g.setColor(Color.black);
		for(int a=0;a<=600;a=a+50)
		{
			g.drawLine(0, a, 700, a);
		}
		for(int a=0;a<=700;a=a+50)
		{
			g.drawLine(a, 0, a, 600);
		}
		

	
	
		
	}
	
	public void loadMap(String text)
	{
		File file=new File(text);
		Scanner strScan;
		try {
			Scanner fileScan=new Scanner(file);
			String  lightText=fileScan.nextLine();
			String targetText=fileScan.nextLine();

			strScan=new Scanner(lightText);
			light=new Light(Integer.parseInt(strScan.next())+25, Integer.parseInt(strScan.next())+25);
			strScan=new Scanner(targetText);
			target=new TargetPoint(Integer.parseInt(strScan.next()), Integer.parseInt(strScan.next()));
			
			
			while(fileScan.hasNextLine())
			{
				String line=fileScan.nextLine();
				 strScan=new Scanner(line);
				 int x=Integer.parseInt(strScan.next());
				 System.out.println(x);
				 int y=Integer.parseInt(strScan.next());
				 Obstacle o=new Obstacle(x, y);
				 map[x][y]=-10;
				 
				obstacles.add(o);
			
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isTarget()
	{
		if(Math.sqrt(Math.pow(target.x-light.x, 2)+Math.pow(target.y-light.y, 2))<50) {
		return true;	
		}
		else
			return false;
	}
	public int getPositionValue()
	{
		return map[light.x/50][light.y/50];
	}
	public void step() {
		// TODO Auto-generated method stub
		
		currentTime=System.currentTimeMillis();
		if(currentTime-lastTime>1000)
		{
			lastTime=currentTime;
			lastHitAngle=0;
		}
		light.move();
		int check=getPositionValue();

		if(check==-10||light.x<10||light.x>680||light.y<15||light.y>585&&(light.velX==0&&light.velY==0))
		{
			playPanel.lostGame();
		}
		
		if(light.x%25==0&&light.x%10!=0) {
			if(check!=-1)
			{
				light.impact(check);
			}
		}
		if(isTarget())
		{
			light.move();
			light.move();
			playPanel.win();
		}
		
		
		
		
	
		
	}
	public void addMirror(int x,int y,int a2,Image im) {
		// TODO Auto-generated method stub
		//mirrors.add(tempMirror);
		
		map[x][y]=a2;
		mirrors.add(new Mirror(x, y, im));
		
		
	
	

	}
	public void reset() {
		// TODO Auto-generated method stub
		light.velX=basevelx;
		light.velY=basevely;
		light.x=basex;
		light.y=basey;
		
	}

}
