package com.snapShotMeta;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SnapShotAppMeta extends JFrame{
	
	private ButtonsBar buttonsBar;
	
	public SnapShotAppMeta() {
		super("Smart SnapShot App");
		
		setLayout(new BorderLayout());
		
		buttonsBar = new ButtonsBar();
		
		
		
		buttonsBar.setStartListener(new StartButtonListener() {
			
			@Override
			public void startButtonAction() {
				
				
				
			}
		});
		
		buttonsBar.setStopListener(new StopButtonListener() {
			
			@Override
			public void stopButtonAction() {
				
				
			}
		});
		
		
		
		
		add(buttonsBar,BorderLayout.CENTER);
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460,150);
		setLocation(1050, 650);
		//setLocationRelativeTo(null);
		setVisible(true);

	}
	

}
