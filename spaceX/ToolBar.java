package com.Exercise_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {
	
	
	private JButton launchButton;
	private JButton returnButton;
	private JButton removeButton;
	
	private RocketListener rocketListener;
	
	
	public ToolBar() {
		
		launchButton = new JButton("Launch Rocket");
		returnButton = new JButton("Return to Starbase");
		removeButton = new JButton("Remove rocket");
		
		setBorder(BorderFactory.createEtchedBorder());
	
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		launchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rocketListener.rocketEmitted();
				
				
			}
		});
		
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rocketListener.rocketReturn();
				
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rocketListener.rocketCleared();
				
			}
		});
		
		
		add(launchButton);
		add(returnButton);
		add(removeButton);

		
	}


	public void setRocketListener(RocketListener rocketListener) {
		this.rocketListener = rocketListener;
	}
	
	

}
