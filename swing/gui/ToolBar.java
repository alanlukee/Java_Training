package com.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {
	
	
	private JButton helloButton;
	private JButton goodbyeButton;
	private JButton clearButton;
	
	//private TextPanel textPanel;
	
	private StringListener textListener;
	private ScreenCleaner screenCleaner;
	
	public ToolBar() {
		
		setBorder(BorderFactory.createEtchedBorder());
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("GoodBye");
		clearButton = new JButton("Clear");

		helloButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textListener.textEmitted("Hello\n");
				
			}
		});
		goodbyeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textListener.textEmitted("Bye-Bye\n");

				
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenCleaner.clearScreen();
				
				
				
			}
		});
		
	
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
		add(clearButton);

	}
	
	public void setStringListener(StringListener textListener) {
		this.textListener = textListener;
	}
	
	public void setScreenCleaner(ScreenCleaner screenCleaner) {
		this.screenCleaner= screenCleaner;
	}

	
	
	public void setTextPanel(TextPanel textPanel) {
		//this.textPanel = textPanel;
	}
	
}
