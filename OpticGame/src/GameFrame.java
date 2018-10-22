import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame {
	
	static JFrame frame=null;
	public  static void main(String[] args)
	{
		 frame=new JFrame("optic game");
		frame.setBounds(0,0,700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane=new JPanel();
		contentPane.setBounds(0, 0, 700, 700);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(new MainScreen(contentPane));
		
		frame.setVisible(true);
		
	}
	

	
	

}
