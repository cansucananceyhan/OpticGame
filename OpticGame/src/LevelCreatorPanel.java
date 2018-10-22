import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GameObjects.Mirror;
import GameObjects.Obstacle;

public class LevelCreatorPanel extends JPanel  {

	
	CreatorPanel creatorPanel;
	LevelCreatorControlPanel controlPanel;
	
	JPanel contentPane;
	
	String username;
	
	public LevelCreatorPanel(JPanel contentPane)
	{
		setBounds(0,0,700,700);
		setLayout(null);
		
		this.contentPane=contentPane;
		creatorPanel=new CreatorPanel();
		controlPanel=new LevelCreatorControlPanel(creatorPanel,this);
		
		add(creatorPanel);
		add(controlPanel);

		
		
	}
	
	public void goToMain()
	{
		setVisible(false);
		contentPane.add(new MainScreen(contentPane));
	}


	public void save() {

		username=JOptionPane.showInputDialog(this, "Enter name...");

		Random rand=new Random();
		File file = new File("CustomLevels/"+username);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
		ArrayList<Obstacle> obstacles=creatorPanel.obstacles;
		//Generate random name
		int level=rand.nextInt(5000);
		String name=username+""+level+".txt";
	    PrintWriter writer;
		try {
			writer = new PrintWriter("CustomLevels/"+username+"/"+name, "UTF-8");
			writer.println(creatorPanel.light.x+" "+creatorPanel.light.y);
			writer.println(creatorPanel.target.x+" "+creatorPanel.target.y);
		
			for(int a=0;a<obstacles.size();a++)
			{
		
					Obstacle m=obstacles.get(a);
				    writer.println(m.x+" "+m.y);
			
			}
		    writer.close();

		} catch (IOException e1) {
			
		} 
		
	}
	
	


}
