package ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import clock.ClockController;
import driver.ClockDriver;
import ui.alarm.AlarmPanel;
import ui.clock.ClockPanel;
import ui.timeout.TimeoutPanel;

public class AppFrame extends JFrame {
	
	private ClockDriver clockDriver;
	private ClockPanel clockPanel;
	private AlarmPanel alarmPanel;
	private TimeoutPanel timeoutPanel;
	
	private ClockController clockController;
	
	public AppFrame(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
		
		this.setLayout(new GridLayout(1, 3));
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	public void buildClockPanel(ClockController clockController) {
		this.clockPanel = new ClockPanel();
		this.clockPanel.build(clockDriver, clockController);
		this.add(clockPanel);
	}

	public ClockController getClockViewer() {
		return clockController;
	}

	public void setClockViewer(ClockController clockViewer) {
		this.clockController = clockViewer;
	}
}
