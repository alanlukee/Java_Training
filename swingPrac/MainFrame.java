package com.swingPrac;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	
	private ToolBar toolBar;
	private TextPanel textPanel;
	private FormPanel formPanel;
	
	
	public MainFrame() {
		
		super("Basic App");
		
		setLayout(new BorderLayout());
		
		toolBar = new ToolBar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		
		toolBar.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String text) {
	
				textPanel.appendText(text);
				
			}
			
		});
		
		    
		add(formPanel,BorderLayout.WEST);
		add(toolBar,BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		

		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

}
