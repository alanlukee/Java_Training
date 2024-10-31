package com.gui;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PrefsDialog extends JDialog {
	public PrefsDialog(JFrame parent ) {
		super( parent,  "Preference", false);
		setSize(400,300);
		
	}

}
