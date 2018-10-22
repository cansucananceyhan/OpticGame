import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameTypePanel extends JPanel implements ActionListener {
	
	JButton normalGame,customGame;
	JPanel contentPane;
	public GameTypePanel(JPanel contentPane) {
		setBounds(0,0,700,700);
		setLayout(null);
		this.contentPane=contentPane;
		normalGame=new JButton("Normal Game");
		customGame=new JButton("Custom Game");
		normalGame.addActionListener(this);
		customGame.addActionListener(this);
		normalGame.setBounds(100, 100, 400, 100);
		customGame.setBounds(200, 400, 400, 100);
		
		add(normalGame);
		add(customGame);
	}
	
	public void back()
	{
		setVisible(false);
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
		if(e.getSource()==normalGame)
		{
			setVisible(false);
			contentPane.add(new NormalLevelsPanel(contentPane));
		}
		else
		{
			setVisible(false);
			contentPane.add(new CustomLevelsPanel(contentPane));

		}
		
	}

}
