import java.awt.*;
import java.util.Random;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.image.*;
import java.lang.Thread;

public class ControlPanel extends JPanel implements ActionListener {

	JButton startButton;
	PlayPanel playPanel;
	
	JButton d0,d0r,d135,d180,d180r,d225,d270,d270r,d315,d90,d90r;
	Image currentIm=null;
	public ControlPanel(PlayPanel p)
	{
		setBounds(0,600,700,100);
		setLayout(new GridLayout(2, 4));
		
		this.playPanel=p;
		d0=new JButton(new ImageIcon("img/0derece.png"));
		d0r=new JButton(new ImageIcon("img/0derecep.png"));
		d135=new JButton(new ImageIcon("img/135derece.png"));

		
		
		d225=new JButton(new ImageIcon("img/225derece.png"));
		
		d315=new JButton(new ImageIcon("img/315derece.png"));
		d90=new JButton(new ImageIcon("img/90derece.png"));
		d90r=new JButton(new ImageIcon("img/90dereceters.png"));
		startButton=new JButton("START");
		
		d0.addActionListener(this);
		d0r.addActionListener(this);
		d135.addActionListener(this);
		d225.addActionListener(this);
		d315.addActionListener(this);
		d90.addActionListener(this);
		d90r.addActionListener(this);

		
		add(d0);
		add(d0r);
		add(d135);
		add(d225);
		add(d315);
		add(d90);
		add(d90r);
		add(startButton);
		
		startButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==startButton)
		{
			playPanel.start=true;
			playPanel.playing=true;
		}
		
		if(e.getSource()==d0)
		{
			playPanel.currentIm=new ImageIcon("img/0derece.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[0]=true;
			
			
		}if(e.getSource()==d0r)
		{
			playPanel.currentIm=new ImageIcon("img/0derecep.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[1]=true;
			

		}if(e.getSource()==d135)
		{
			playPanel.currentIm=new ImageIcon("img/135derece.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[2]=true;

	
		}if(e.getSource()==d225)
		{
			playPanel.currentIm=new ImageIcon("img/225derece.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[3]=true;

	

		}if(e.getSource()==d315)
		{
			playPanel.currentIm=new ImageIcon("img/315derece.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[4]=true;

		}
		if(e.getSource()==d90)
		{
			playPanel.currentIm=new ImageIcon("img/90derece.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[5]=true;

		}
		if(e.getSource()==d90r)
		{
			playPanel.currentIm=new ImageIcon("img/90dereceters.png").getImage();
			for(int a=0;a<8;a++)
				playPanel.addingMirror[a]=false;
			playPanel.addingMirror[6]=true;

		}
	
		
		
	}
}
