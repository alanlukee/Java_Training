package eval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanel extends JPanel {
	
	
	private JLabel nameLabel;
	private JTextField nameField;
	
	private JLabel emailLabel;
	private JTextField emailField;

	private JLabel phoneLabel;
	private JTextField phoneField;
	
	private JLabel addressLabel;
	private JTextField addressField;
	
	private JButton submitButton;
	
	private FormListener formListener;
	
	//private ListBox listBox;
	

	

	public FormPanel() {
		
		Dimension d = getPreferredSize();
		d.width = 400;
		setPreferredSize(d);
		
		nameLabel = new JLabel("Name:");
		nameField = new JTextField(15);
		
		emailLabel = new JLabel("Email:");
		emailField = new JTextField(15);
		
		phoneLabel = new JLabel("Phone:");
		phoneField = new JTextField(15);
		
		addressLabel = new JLabel("Address:");
		addressField = new JTextField(15);
		
		submitButton = new JButton("Submit");
		
		
	
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		
		
		gc.gridy = 0;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		add(nameLabel,gc);
		
		gc.gridy = 0;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.NONE;
		add(nameField,gc);
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		add(emailLabel,gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.NONE;
		add(emailField,gc);
		
		gc.gridy = 2;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		add(phoneLabel,gc);
		
		gc.gridy = 2;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.NONE;
		add(phoneField,gc);
		
		gc.gridy = 3;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		add(addressLabel,gc);
		
		gc.gridy = 3;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.NONE;
		add(addressField,gc);
		
		gc.gridy = 4;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.NONE;
		add(submitButton, gc);
		
		
		submitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String name = nameField.getText();
		        String email = emailField.getText();
		        String phone = phoneField.getText();
		        String address = addressField.getText();
		        FormEvent e1;

		        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
		           
		            JOptionPane.showMessageDialog(FormPanel.this, 
		                "Please fill in all contact details.", 
		                "Warning", 
		                JOptionPane.WARNING_MESSAGE);
		        } else {
		            e1 = new FormEvent(this, name, email, phone, address);
		            formListener.formEventOccurred(e1);
		        }
		    }
		});

		
		
		
		
	
		
		setBorder(BorderFactory.createLineBorder(Color.red, 1));

	}
	
	public void clearText() {
		
		nameField.setText(" ");
		emailField.setText(" ");
		phoneField.setText(" ");
		addressField.setText(" ");
	
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

}
