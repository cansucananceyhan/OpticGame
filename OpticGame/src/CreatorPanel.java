import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import GameObjects.Light;
import GameObjects.Obstacle;
import GameObjects.TargetPoint;

public class CreatorPanel extends JPanel implements MouseMotionListener,MouseListener{
	
	
	
	ArrayList<Obstacle> obstacles;
	Light light;
	TargetPoint target;
	
	boolean addingTarget=false;
	boolean targetAdded=false;
	boolean lightAdded=false;
	boolean addingObstacle=false;
	boolean addingLight=false;
	Obstacle tempObstacle;
	boolean rotated=false;
	public CreatorPanel()
	{
		addMouseMotionListener(this);
		addMouseListener(this);
		setBounds(0,0,700,600);
		setLayout(null);
		obstacles=new ArrayList<>();
		
		setFocusable(true);
		requestFocusInWindow();
		
		
	}
	public void addLight() {
		addingObstacle=false;
		addingLight=true;
		addingTarget=false;

		light=new Light(0, 0);
		
	}
	public void addTarget() {
		addingObstacle=false;
		addingLight=false;
		addingTarget=true;
		target=new TargetPoint(0, 0);
		
	}
	public void addObstacle()
	{
		addingTarget=false;

		addingLight=false;
		addingObstacle=true;
		tempObstacle=new Obstacle(0, 0);
		
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		for(int a=0;a<=getHeight();a=a+50)
		{
			g.drawLine(0, a, getWidth(), a);
		}
		for(int a=0;a<=getWidth();a=a+50)
		{
			g.drawLine(a, 0, a, getHeight());
		}

		if(addingObstacle)
		{
			tempObstacle.draw(g);
		}
		if(addingLight)
		{
			g.fillRect(light.x, light.y, 5, 5);
			light.draw(g);
		}
		if(addingTarget)
			target.draw(g);
		if(targetAdded)
			target.draw(g);
		
		if(lightAdded)
			g.fillRect(light.x, light.y, 5, 5);

		
		for(int a=0;a<obstacles.size();a++)
			obstacles.get(a).draw(g);
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if(addingTarget)
		{
			target.x=e.getX()-25;
			target.y=e.getY()-25;
			repaint();
		}
		
		if(addingObstacle)
		{
			tempObstacle.	x=e.getX()/50;
			tempObstacle.y=e.getY()/50;
			repaint();
		}if(addingLight)
		{
			light.x=e.getX();
			light.y=e.getY();
			repaint();
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		int x=e.getX()/50;
		int y=e.getY()/50;
		if(addingObstacle)
		{
			
			obstacles.add(tempObstacle);
			addingObstacle=false;
		}
		if(addingLight) {
			light.x=x*50;
			light.y=y*50;
			lightAdded=true;
			addingLight=false;
		}
		if(addingTarget)
		{
			target.x=e.getX()-25;
			target.y=e.getY()-25;
			targetAdded=true;
			addingTarget=false;
		}
	
		
		repaint();
		
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
