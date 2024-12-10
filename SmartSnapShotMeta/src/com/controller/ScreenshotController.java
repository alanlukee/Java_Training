package com.controller;

import java.awt.Frame;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.model.ScreenshotModel;
import com.view.ButtonsBar;
import com.view.ButtonsListener;
import com.view.PreviewWindow;

public class ScreenshotController {
	
	private ScreenshotModel model;
	private ButtonsBar buttonsBar;
	private Timer screenshotTimer;
	
	public ScreenshotController( ButtonsBar buttonsBar ) {
		
		model = new ScreenshotModel();
		this.buttonsBar = buttonsBar;
		
		buttonsBar.setButtonsListener(new ButtonsListener() {
		
			@Override
			public void stopButtonAction() {
				// TODO Auto-generated method stub
				stopScreenShotProcess();
			}
			
			@Override
			public void startButtonAction() {
				// TODO Auto-generated method stub
				startScreenShotProcess();
			}
			
			@Override
			public void timerButtonAction() {
				// TODO Auto-generated method stub
				timerProcess();	
			}
		});	
	}
	private void startScreenShotProcess() {
		
		if(!model.isActive()) {
			System.out.println("Snapshot functionality initiated.");
			model.setActive(true);
			
			buttonsBar.setActiveButtonIcon();
			buttonsBar.enableStopButon(true);
	
			
			
			screenshotTimer = new Timer();
			
			screenshotTimer.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					model.takeScreenshot();;
				}
				
			}, 0, model.getInterval());
			
		}
		else {
			System.out.println("Start button is already active.");
		}
		
	}

	private void stopScreenShotProcess() {
		
		if(model.isActive()) {
			System.out.println("SnapShot stopped");
			model.setActive(false);
			buttonsBar.setStartButtonIcon();
			buttonsBar.enableStopButon(false);
			
			
			if(screenshotTimer!=null) {
				screenshotTimer.cancel();
			}
			
			model.resetScreenshotCounter();
			
			
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
                null,
                "Select timer interval (seconds):",
                "Set Timer", 
                JOptionPane.PLAIN_MESSAGE, 
                null,
                options,
                String.valueOf(model.getInterval() / 1000)
        );

        if (selected != null) {
            try {
                int newInterval = Integer.parseInt(selected) * 1000;
                model.setInterval(newInterval);
                buttonsBar.getTimerButton().setToolTipText("Selected interval: " + selected + " seconds");
                System.out.println("Screenshot interval set to: " + model.getInterval() / 1000 + " seconds");

                if (model.isActive()) {
                    restartTimer();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
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
				model.takeScreenshot();
			}
			
		}, 0, model.getInterval());
		
		System.out.println("Timer restarted with new interval: "+model.getInterval()/1000+" seconds");
	}	
	
	
	
	

}
