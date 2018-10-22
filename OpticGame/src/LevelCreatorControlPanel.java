import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class LevelCreatorControlPanel extends JPanel implements ActionListener {

	
	
	
	JButton lightButton;
	JButton obstacleButton;
	JButton targetButton;
	JButton create;
	JButton back;
	CreatorPanel cp;
	LevelCreatorPanel lp;
	public LevelCreatorControlPanel(CreatorPanel cp,LevelCreatorPanel lp)
	{
		this.cp=cp;
		this.lp=lp;
		setBounds(0,600,700,100);
		GridLayout gl=new GridLayout(1, 5);
		setLayout(gl);
		
		lightButton=new JButton(new ImageIcon("img/LIGHT.png"));
		obstacleButton=new JButton(new ImageIcon("img/OBSTACLE.png"));
		targetButton=new JButton(new ImageIcon("img/TARGET.png"));
		create=new JButton("CREATE");
		back=new JButton("<-");

		lightButton.addActionListener(this);
		targetButton.addActionListener(this);
		obstacleButton.addActionListener(this);
		back.addActionListener(this);
		create.addActionListener(this);
		add(lightButton);
		add(targetButton);
		add(obstacleButton);
		add(create);
	
		add(back);

		
		
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==obstacleButton)
		{
			cp.addObstacle();
		}
		if(e.getSource()==lightButton)
		{
			cp.addLight();
		}
		if(e.getSource()==back)
		{
				lp.goToMain();
		}
		if(e.getSource()==create)
		{
			lp.save();
			lp.goToMain();
		}
		
		if(e.getSource()==targetButton)
			cp.addTarget();
		
		

		
	}
	
	
}
