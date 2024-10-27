package com.swingPrac;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField namefield;
	private JTextField occupationfield;
	private JButton okBtn;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
	
		nameLabel = new JLabel("Name:");
		occupationLabel = new JLabel("Occupation:");
		namefield = new JTextField(10);
		occupationfield = new JTextField(10);
		okBtn = new JButton("Ok");
		
	
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

	
		//first row
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		//gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;

		add(namefield, gc);
		
		//second row
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridx = 1;
		gc.gridy =1;
		//gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.LINE_START;

		add(occupationfield, gc);
		
		
		//third row
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridy = 2;
		gc.gridx =1;
		//gc.insets = new Insets(0,0,0,0);

		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);




		
	}

}
