package ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import clock.ClockViewer;

public class AppFrame extends JFrame {
	
	ClockViewer clockViewer;
	
	public AppFrame(ClockViewer clockViewer) {
		this.clockViewer = clockViewer;
		this.setLayout(new GridLayout(1, 3));
		this.setSize(400, 300);
		this.setVisible(true);
		
		JLabel time = new JLabel();
		
		this.add(time);
		
		clockViewer.setLabel(time);
	}
}
