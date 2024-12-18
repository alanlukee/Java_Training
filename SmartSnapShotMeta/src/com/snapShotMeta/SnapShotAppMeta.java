package com.snapShotMeta;

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
	
	private Timer screenshotTimer;
	private int interval = 2000;
	private boolean isActive = false;
	private int screenshotCounter = 1;

	
	public SnapShotAppMeta() {
		
		
		super("Smart SnapShot App");
		
		setLayout(new BorderLayout());
		
		buttonsBar = new ButtonsBar();
		
		
		
		buttonsBar.setStartListener(new StartButtonListener() {
			@Override
			public void startButtonAction() {
				startScreenShotProcess();	
			}
		});
		
		buttonsBar.setStopListener(new StopButtonListener() {
			@Override
			public void stopButtonAction() {
				stopScreenShotProcess();	
			}
		});
		
		

		
		buttonsBar.setTimerListener(new TimerButtonListener() {
			
			@Override
			public void timerButtonAction() {
				// TODO Auto-generated method stub
				
				timerProcess();
			}
		});
		
		
	
		add(buttonsBar,BorderLayout.CENTER);
		
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460,150);
		setLocation(1050, 650);
		//setLocationRelativeTo(null);
		setVisible(true);

	}
	
	
	private void startScreenShotProcess() {
		
		if(!isActive) {
			System.out.println("Snapshot functionality initiated.");
			isActive = true;
			
			buttonsBar.setActiveButtonIcon();
			buttonsBar.enableStopButon(true);
			
			ImageIcon activeIcon = new ImageIcon("src/assets/snapshot_active.png");
			Image scaledActiveImage = activeIcon.getImage().getScaledInstance(80, 85,  Image.SCALE_SMOOTH);
			setIconImage(scaledActiveImage);
			
			setState(Frame.ICONIFIED);
			
			
			screenshotTimer = new Timer();
			screenshotTimer.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					takeScreenshot();
				}
				
			}, 0, interval);
			
			isActive = true;
			
		}
		else {
			System.out.println("Start button is already active.");
		}
		
	}

	private void stopScreenShotProcess() {
		
		if(isActive) {
			System.out.println("SnapShot stopped");
			isActive = false;
			buttonsBar.setStartButtonIcon();
			buttonsBar.enableStopButon(false);
			
			
			if(screenshotTimer!=null) {
				screenshotTimer.cancel();
			}
			
			screenshotCounter = 1;
			
			
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("Opening preview window");
					PreviewWindow previewer = new PreviewWindow();
					previewer.setVisible(true);
					
				}
			});	
		}
	}
	
	private void timerProcess() {
		
        String[] options = {"1", "2", "3","4", "5", "6", "7" ,"8" ,"9","10"};
        String selected = (String) JOptionPane.showInputDialog(
                this,
                "Select timer interval (seconds):",
                "Set Timer", //title of dialog box
                JOptionPane.PLAIN_MESSAGE, //not error/info message kinda
                null, //no custom icon used
                options,
                String.valueOf(interval / 1000) //initial selection value.
        );

        if (selected != null) {
            try {
                int newInterval = Integer.parseInt(selected) * 1000;
                interval = newInterval;
                buttonsBar.getTimerButton().setToolTipText("Selected interval: " + selected + " seconds");
                System.out.println("Screenshot interval set to: " + interval / 1000 + " seconds");

                if (isActive) {
                    restartTimer();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
	
	}
	
	
	private void restartTimer() {
		
		if(screenshotTimer!=null) {
			screenshotTimer.cancel();
		}
		screenshotTimer = new Timer();
		
		screenshotTimer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				takeScreenshot();
			}
			
		}, 0, interval);
		
		System.out.println("Timer restarted with new interval: "+interval/1000+" seconds");
	}		
	
	
	
	private void takeScreenshot() {

		try {
			
			flashScreen();
			Robot robot = new Robot(); //interface to interact with the screen
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //provides access to the systems graphical environment.
			//getScreenSize() would fetch the dimensions of the entire screen.
		
			Rectangle screenRect = new Rectangle(screenSize); //Rectangle class is used to define a rectangular region.
		
			BufferedImage screenshot = robot.createScreenCapture(screenRect); //captures the screenarea defined by screenrect
			//																	and stored as a bufferedImage object
		
			String folderPath = "src/snapShots/";
			String fileName = "screenshot_" +screenshotCounter+".png";
			File file = new File(folderPath+fileName);
			ImageIO.write(screenshot, "png", file);
			System.out.println("Screen captured");
			System.out.println("Screenshot saved: "+file.getAbsolutePath());
		
			//JOptionPane.showMessageDialog(null, "Screenshot saved: "+file.getAbsolutePath());
		
			screenshotCounter++;
		
		}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed to capture screen" +ex.getMessage(),"error",JOptionPane.ERROR_MESSAGE);	
		}
}
	
	private void flashScreen() {
		
		JWindow flashWindow = new JWindow();
		flashWindow.setBackground(new Color(255,255,255,150));
		flashWindow.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		flashWindow.setAlwaysOnTop(true);
		flashWindow.setVisible(true);
		
		try {
			Thread.sleep(70);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		flashWindow.dispose();
		
		}
}