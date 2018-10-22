import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainScreen  extends JPanel implements ActionListener{

	JPanel buttonPanel;
	JButton play,create,help,exit;
	JPanel contentPane;
	public MainScreen(JPanel contentPane)
	{
		setBounds(0,0,700,700);
		setLayout(null);
		this.contentPane=contentPane;
		buttonPanel=new JPanel();
		buttonPanel.setBounds(140, 50, 300, 500);
		
		
		play=new JButton("Play");
		create=new JButton("Create a new game");
		help=new JButton("Help");
		exit=new JButton("Exit");
		
		
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(play);
		buttonPanel.add(create);
		buttonPanel.add(help);
		buttonPanel.add(exit);
		
		play.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);
		create.addActionListener(this);
		add(buttonPanel);
		
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon("img/bg.jpg").getImage(),0, 0,getWidth(),getHeight(), this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		if(e.getSource()==play)
		{
			setVisible(false);
			contentPane.add(new GameTypePanel(contentPane));
		}
		if(e.getSource()==create)
		{
			setVisible(false);
			contentPane.add(new LevelCreatorPanel(contentPane));

		}
		if(e.getSource()==help)
		{
			setVisible(false);
			contentPane.add(new HelpPanel(contentPane));

		}
		
	}
}
