package com.swingPrac;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener{
	
	
	private JButton helloButton;
	private JButton goodbyeButton;
	
	//private TextPanel textPanel;
	private StringListener textListener;
	
	public ToolBar() {
		setBorder(BorderFactory.createEtchedBorder());
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("GoodBye");
		
		
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
	
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);

	}
	
	public void setStringListener(StringListener textListener) {
		this.textListener = textListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == helloButton) {
			//textPanel.appendText("Hello\n");
			if(textListener !=null) {
				textListener.textEmitted("hello\n");
			}
		}
		
		else if (clicked ==goodbyeButton) {
			//textPanel.appendText("GoodBye\n");
			if(textListener !=null) {
				textListener.textEmitted("goodbye\n");

			}

		}
	
	}
	public void setTextPanel(TextPanel textPanel) {
		//this.textPanel = textPanel;
	}
	
}
