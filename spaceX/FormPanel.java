package com.Exercise_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel rocketNameLabel;
	private JTextField rocketNameText;
	
	private JLabel raptorEngine;
	private JTextField raptorEngineText;
	
	private JLabel heatShield;
	private JTextField heatShieldText;
	
	private JList testList;

	
	private JRadioButton block_1_version;
	private JRadioButton block_2_version;
	private JRadioButton block_3_version;
	
	
	private ButtonGroup version;
	
	
	private JButton submitButton;


	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FormPanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		rocketNameLabel = new JLabel("Rocket Name");
		rocketNameText = new JTextField(10);
		
		raptorEngine = new JLabel("Raptor Engine");
		raptorEngineText = new JTextField(10);
		
		heatShield = new JLabel("Heat Shield");
		heatShieldText = new JTextField(10);
		
		block_1_version = new JRadioButton("Block-1");
		block_2_version = new JRadioButton("Block-2");
		block_3_version = new JRadioButton("Block-3");
		
		
		block_1_version.setActionCommand("block1");
		block_2_version.setActionCommand("block2");
		block_3_version.setActionCommand("block3");
		
		version= new ButtonGroup();
		
		version.add(block_1_version);
		version.add(block_2_version);
		version.add(block_3_version);
		
		testList = new JList();
		
		submitButton = new JButton("Process");
		
		
		
		DefaultListModel flightList = new DefaultListModel();
		
		flightList.addElement("test flight-1");
		flightList.addElement("test flight-2");
		flightList.addElement("test flight-3");
		flightList.addElement("test flight-4");
		flightList.addElement("test flight-5");

		
		testList.setModel(flightList);
		
		testList.setPreferredSize((new Dimension(120,100)));
		testList.setBorder(BorderFactory.createEtchedBorder());
		testList.setSelectedIndex(1);


		Border innerBorder = BorderFactory.createTitledBorder("StarShip Components");
		Border outerBorder = BorderFactory.createLineBorder(Color.darkGray, 2, true);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		layoutComponents();
		
		
		
		
	}
	
	public void layoutComponents() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		//row-1
		
		gc.weighty = 1;
		//gc.weightx = 0.1;
		
		gc.gridy = 0;
		gc.gridx = 0;
		
		add(rocketNameLabel,gc);
		
		gc.gridy = 0;
		gc.gridx = 1;
		add(rocketNameText,gc);
		
		//row-2
		
		gc.gridy = 1;
		gc.gridx = 0;
		add(raptorEngine, gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		add(raptorEngineText, gc);
		
		//row - 3
		
		gc.gridy = 2;
		gc.gridx = 0;
		add(heatShield, gc);
		
		gc.gridy = 2;
		gc.gridx = 1;
		add(heatShieldText,gc);
		
		//row-4
		
		gc.gridy = 3;
		gc.gridx = 0;
		add(new JLabel("Version: "), gc);
		
		gc.gridy = 3;
		gc.gridx =1;
		add(block_1_version,gc);
		
		gc.gridy = 4;
		gc.gridx =1;
		add(block_2_version,gc);
		
		gc.gridy = 5;
		gc.gridx =1;
		add(block_3_version,gc);
		
		gc.gridy = 7;
		gc.gridx = 1;
		add(testList,gc);
		
		
		gc.weighty = 1;
		gc.weightx = 0.1;
		gc.gridy = 8;
		gc.gridx = 1;
		add(submitButton,gc);
	
		
		
		
	}



}
