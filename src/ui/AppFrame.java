package ui;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class AppFrame extends JFrame {
	
	public AppFrame() {
		this.setLayout(new GridLayout(2, 3));
		this.setSize(400, 300);
		this.setVisible(true);
	}
}
