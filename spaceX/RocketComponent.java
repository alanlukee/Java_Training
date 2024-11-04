package com.Exercise_1;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class RocketComponent extends JPanel {
	
	public RocketComponent() {
		
		setPreferredSize(new Dimension(300,200));
		
		Border innerBorder = BorderFactory.createTitledBorder("StarShip");
		Border outerBorder = BorderFactory.createLineBorder(Color.darkGray, 2, true);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
	

	}
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GRAY);
		g2d.fillRect(100, 150, 100, 200);
		
		g2d.setColor(Color.RED);
		
		Polygon nose = new Polygon();
		nose.addPoint(100, 150);
		nose.addPoint(150, 50);
		nose.addPoint(200, 150);
		
		g2d.fillPolygon(nose);
		
		Polygon leftFin = new Polygon();
		leftFin.addPoint(100, 350);
		leftFin.addPoint(50, 400);
		leftFin.addPoint(100, 400);
		g2d.fillPolygon(leftFin);
		
		Polygon rightFin = new Polygon();
		rightFin.addPoint(200, 350);
		rightFin.addPoint(200, 400);
		rightFin.addPoint(250, 400);
		g2d.fillPolygon(rightFin);
		
		g2d.setColor(Color.CYAN);
		g2d.fillOval(130, 180, 40, 40);
		
		

		
		
		
		
		
	}
	

}
