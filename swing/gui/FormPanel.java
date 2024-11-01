package com.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField namefield;
	private JTextField occupationfield;
	private JButton okBtn;
	private FormListener formListener;
	private JList ageList;
	private JComboBox empCombo;
	
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	
	private ButtonGroup genderGroup;
	
	@SuppressWarnings("unchecked")
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
	
		nameLabel = new JLabel("Name:");
		occupationLabel = new JLabel("Occupation:");
		namefield = new JTextField(10);
		occupationfield = new JTextField(10);
		ageList = new JList();
		empCombo = new JComboBox();
		
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID: ");
		
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
		
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		
		
		maleRadio.setActionCommand("male");
		femaleRadio.setActionCommand("female");
		
		genderGroup= new ButtonGroup();
		
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		
		
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nameLabel.setLabelFor(namefield);
			
		citizenCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean isTicked = citizenCheck.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);

				
			}
			
		});
	
		//set up list box
		DefaultListModel ageModel = new DefaultListModel();
		
		ageModel.addElement(new AgeCategory(0,"Under 18"));
		ageModel.addElement(new AgeCategory(1,"18- 65"));
		ageModel.addElement(new AgeCategory(2,"over 65"));
		
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize((new Dimension(110,70)));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		
		//set up combo box
		
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		
		empModel.addElement("employed");
		empModel.addElement("self - employed");
		empModel.addElement("unemployed");
		empCombo.setModel(empModel);
		
		empCombo.setSelectedIndex(0);
		empCombo.setEditable(true);
		
		okBtn = new JButton("Ok");
		okBtn.setMnemonic(KeyEvent.VK_O);
		 

		//ageModel.setModel(ageModel);

		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String name  = namefield.getText();
				String occupation = occupationfield.getText();
				AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
				String empCat = (String) empCombo.getSelectedItem();
				String taxId = taxField.getText();
				boolean usCitizen = citizenCheck.isSelected();
				String gender = genderGroup.getSelection().getActionCommand();
				
				
				FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCat, taxId, usCitizen, gender);
				
				if(formListener != null) {
					formListener.formEventOccurred(ev); 
				}
				
				
			}
		});
		
		
		
	
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createLineBorder(Color.RED, 1, true);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		layoutComponents();
		
	}
	
	public void layoutComponents() {
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

	
		//first row
		
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.insets = new Insets(0,0,0,5);
		
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;

		add(namefield, gc);
		
		//second row
		
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridx = 1;
		gc.gridy =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.LINE_START;

		add(occupationfield, gc);
		
		
		//third row
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age: "), gc);
		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);
		
		//next row
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employeement: "), gc);
		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(empCombo, gc);
		
		//next row
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("US Citizen: "), gc);
		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheck, gc);
		
		//next row
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxLabel, gc);
		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(taxField, gc);
		
		//next row
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);

		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Gender: "), gc);
		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(maleRadio, gc);
		
		//next row
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);


		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(femaleRadio, gc);
		

		
		//fourth row 
		
		gc.gridy ++;
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

		
	
	}

	public void setFormListener(FormListener formListener) {
		// TODO Auto-generated method stub
		this.formListener = formListener;
		
	}
	
	class AgeCategory{
		private int id;
		private String text;
		
		 public AgeCategory(int id, String text){
			 this.id = id;
			 this.text = text;
			 
		 }
		 
		 public String toString() {
			 return text;
		 }
		 
		 public int getId() {
			 return id;
		 }
		
	}

}
