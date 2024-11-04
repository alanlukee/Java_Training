package com.Exercise_1;

import java.awt.BorderLayout;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	
	private ToolBar toolbar;
	private FormPanel formPanel;
	private TextPanel textPanel;
	private RocketComponent custComponent;

	

	public MainFrame() {
		
		super("SpaceX");
		
		setLayout(new BorderLayout());
		toolbar = new ToolBar();
		formPanel = new FormPanel();
		textPanel = new TextPanel();
		custComponent = new RocketComponent();
		
		add(toolbar,BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		add(textPanel, BorderLayout.SOUTH);
		add(custComponent, BorderLayout.EAST);
		
		toolbar.setRocketListener(new RocketListener() {
			
			@Override
			public void rocketReturn() {
				// TODO Auto-generated method stub
				textPanel.appendText("Starship returned to starbase\n");
				
			}
			
			@Override
			public void rocketEmitted() {
				// TODO Auto-generated method stub
				
				textPanel.appendText("Starship launched\n");
				
			}
			
			@Override
			public void rocketCleared() {
				// TODO Auto-generated method stub
				textPanel.clearTextArea();
				System.out.println("StarBase cleared\n");
				
			}
		});
		
		setSize(800, 700);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setJMenuBar(createMenuBar());

		
	}
	
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Star Link");
		JMenuItem exportDataItem = new JMenuItem("Features");
		JMenuItem importDataItem = new JMenuItem("Engine");
		JMenuItem exitItem = new JMenuItem("Power Off");

		fileMenu.add(exportDataItem);
		
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		

		menuBar.add(fileMenu);

		
		return menuBar;

}
}
