import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomLevelsPanel extends JPanel implements ActionListener {
	
	ArrayList<JButton> buttons;
	JPanel contentPane;
	JButton backButton;

	public CustomLevelsPanel(JPanel contentPane) {
		// TODO Auto-generated constructor stub
		
		this.contentPane=contentPane;
		setBounds(0,0,700,700);
		setLayout(new GridLayout(4, 4));
		backButton=new JButton("<-");
		backButton.addActionListener(this);
		buttons=new ArrayList<>();
		File folder = new File("CustomLevels/");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isDirectory()) {
		        System.out.println(file.getName());
		        
		        JButton button=new JButton(file.getName());
		        button.addActionListener(this);
		        buttons.add(button);
		        add(button);
		    }
		}
		for(int a=0;a<16-buttons.size()-1;a++)
			add(new JLabel(""));
		
		add(backButton);

	}
	public void back()
	{
		setVisible(false);
		contentPane.removeAll();
		contentPane.add(new MainScreen(contentPane));
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon("img/bg.jpg").getImage(),0, 0,getWidth(),getHeight(), this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==backButton)
		{
			back();
			return;
		}
		for(int a=0;a<buttons.size();a++)
		{
			JButton button=buttons.get(a);
			if(e.getSource()==button)
			{
				setVisible(false);
				contentPane.add(new UsersGamesPanel(contentPane, ((JButton)e.getSource()).getActionCommand()));
			}
		}
		
	}

}
