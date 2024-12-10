package com.view;

import com.controller.ScreenshotController;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class SnapShotAppMeta extends JFrame{
	
	private ButtonsBar buttonsBar;
//	private ScreenshotModel model;
	private ScreenshotController controller;
	


	public SnapShotAppMeta() {
		super("Smart SnapShot App");
		
		controller = new ScreenshotController(buttonsBar);
		
		
		setLayout(new BorderLayout());
		
		buttonsBar = new ButtonsBar();
		
		add(buttonsBar,BorderLayout.CENTER);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460,150);
		setLocation(1050, 650);
		//setLocationRelativeTo(null);
		setVisible(true);
		

	}
	
	

}