package eval;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {
	
	private JButton saveButton;
	private JButton clearButton;
	private JButton exitButton;
	
	private TextSaver textSaver;
	private ScreenCleaner screenCleaner;
	private ScreenExiter screenExiter;
	
	
	
	public ToolBar() {
		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");
		exitButton = new JButton("Exit");
		
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(saveButton);
		add(clearButton);
		add(exitButton);
		
		setBorder(BorderFactory.createEtchedBorder());
		
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenCleaner.cleaner();
				
			}
		});
		
//		saveButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//				
//			}
//		});

		
//		exitButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				
//				
//			}
//		});
		
	
	
		
	}



	public void setTextSaver(TextSaver textSaver) {
		this.textSaver = textSaver;
	}



	public void setScreenCleaner(ScreenCleaner screenCleaner) {
		this.screenCleaner = screenCleaner;
	}



	public void setScreenExiter(ScreenExiter screenExiter) {
		this.screenExiter = screenExiter;
	}

}
