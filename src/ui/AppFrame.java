package ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import clock.ClockController;
import driver.ClockDriver;
import timeout.TimeoutManager;
import ui.alarm.AlarmPanel;
import ui.clock.ClockPanel;
import ui.timeout.TimeoutPanel;

public class AppFrame extends JFrame {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	private ClockDriver clockDriver;
	private ClockPanel clockPanel;
	private AlarmPanel alarmPanel;
	private TimeoutPanel timeoutPanel;
	
	private ClockController clockController;
	
	public AppFrame(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
		
		this.setLayout(new GridLayout(1, 3));
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
	}
	
	public void buildClockPanel(ClockController clockController) {
		this.clockPanel = new ClockPanel();
		this.clockPanel.build(this.clockDriver, clockController);
		this.add(this.clockPanel);
	}
	
	public void buildAlarmPanel() {
		this.alarmPanel = new AlarmPanel();
		this.alarmPanel.build(this.clockDriver);
		this.add(this.alarmPanel);
	}
	
	public void buildTimeoutPanel(TimeoutManager timeoutManager) {
		this.timeoutPanel = new TimeoutPanel();
		this.timeoutPanel.build(timeoutManager);
		this.add(this.timeoutPanel);
	}

	public ClockController getClockViewer() {
		return clockController;
	}

	public void setClockViewer(ClockController clockViewer) {
		this.clockController = clockViewer;
	}
}
