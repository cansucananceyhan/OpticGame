import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel  extends JPanel implements ActionListener{

	JButton back;
	JPanel contentPane;
	JLabel label;
	public HelpPanel(JPanel contentPane)
	{
	    Font font = new Font("Jokerman", Font.PLAIN, 35);

		setBounds(0,0,700,700);
		setLayout(null);
		this.contentPane=contentPane;
	
		
		back=new JButton("Back");
		label=new JLabel("ADSSADSADAS\nsadasdsad\nsdasadas");
		label.setFont(font);
		label.setBounds(100, 100, 400, 400);
		add(label);
	
		
	
		
		back.addActionListener(this);
		back.setBounds(50, 650, 50, 50);
		add(back);
		
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon("img/bg.jpg").getImage(),0, 0,getWidth(),getHeight(), this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==back)
		{
			setVisible(false);
			contentPane.add(new MainScreen(contentPane));
		}
		
		
	}
}
