package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.controller.Controller;

public class MainFrame extends JFrame {
	
	
	private ToolBar toolBar;
	private TextPanel textPanel;
	private FormPanel formPanel;
	
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	private PrefsDialog prefsDialog;
	
	public MainFrame() {
		
		super("Basic App");
		
		setLayout(new BorderLayout());
		
		toolBar = new ToolBar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		fileChooser = new JFileChooser();
		controller = new Controller();
		tablePanel = new TablePanel();
		prefsDialog = new PrefsDialog(this);
		
		
		tablePanel.setData(controller.getPeople());
		tablePanel.setPersonTableListener(new PersonTableListener(){
			public void rowDeleted(int row) {
				System.out.println(row);
				controller.removePerson(row);
			}
		});
		fileChooser.addChoosableFileFilter( new PersonFileFilter());
		
		toolBar.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);
				
			}
		}); 
		
		toolBar.setScreenCleaner(new ScreenCleaner() {
			
			@Override
			public void clearScreen() {
				// TODO Auto-generated method stub
				textPanel.clearTextArea();
				
			}
		});
		
		
		
		formPanel.setFormListener( new FormListener() {

			@Override
			public void formEventOccurred(FormEvent e) {
				// TODO Auto-generated method stub
				
				controller.addPerson(e);
				tablePanel.refresh();
				
//				String name = e.getName();
//				String occupation = e.getOccupation();
//				int ageCat = e.getAgeCategory();
//				String empCat = e.getEmpCat();
//				String gender = e.getGender();
//				System.out.println(e.getGender());
//				textPanel.appendText(name + ": "+ occupation +": "+ageCat+ ": "+empCat+ ": "+gender+ "\n");
			}
			
		});

		add(formPanel,BorderLayout.WEST);
		add(toolBar,BorderLayout.NORTH);
		//add(textPanel, BorderLayout.CENTER);
		add(tablePanel, BorderLayout.CENTER);
		
		
		setMinimumSize(new Dimension(500,500));
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setJMenuBar(createMenuBar());
		
	}
	
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data");
		JMenuItem importDataItem = new JMenuItem("Import Data");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exportDataItem);
		
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		
		JMenu showMenu = new JMenu("Show");
		JMenuItem prefsItem = new JMenuItem("Preferences...");
		windowMenu.add(showMenu);
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		
		
		showMenu.add(showFormItem);
		menuBar.add(fileMenu);
		windowMenu.add(prefsItem);
		menuBar.add(windowMenu);
		
		prefsItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				prefsDialog.setVisible(true);
				
			}
		});
		
		showFormItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				// TODO Auto-generated method stub
				
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String text = JOptionPane.showInputDialog(MainFrame.this, "enter your name",JOptionPane.OK_OPTION);
				System.out.println(text);
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "sure you wanna quit?", "confirm exit",
						JOptionPane.OK_CANCEL_OPTION);
				
				if(action ==JOptionPane.OK_OPTION) {
					System.exit(0);

				}
				
			}
		});
		
		importDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//returns integer value
				
				if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION) {
					//This value "approve_option:, indicates that the user selected a file and clicked the "Open" button.
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file","Error", JOptionPane.ERROR_MESSAGE );
					}
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//returns integer value
				
				if(fileChooser.showSaveDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION) {
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to file","Error", JOptionPane.ERROR_MESSAGE );
					}
				}
			}
		});
		
		
		
		
		

		return menuBar;
		
	}
	
	
	

}
