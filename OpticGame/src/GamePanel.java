import java.io.File;

import javax.swing.JPanel;

public class GamePanel  extends JPanel{

	
	PlayPanel playPanel;
	ControlPanel controlPanel;
	JPanel contentPane;
	public GamePanel(File[] files,int selected,JPanel content)
	{
		setBounds(0,0,700,700);
		setLayout(null);
		this.contentPane=content;
		
		playPanel=new PlayPanel(files,selected,this);
		controlPanel=new ControlPanel(playPanel);
		add(playPanel);
		add(controlPanel);
		
	}
	public void gomain() {
		// TODO Auto-generated method stub
		setVisible(false);
		contentPane.removeAll();
		contentPane.add(new MainScreen(contentPane));

		contentPane.repaint();
		contentPane.revalidate();
		
	}
}
