package ui.clock;

import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JPanel;

import clock.ClockController;
import driver.ClockDriver;

public class ClockPanel extends JPanel {
	
	private ClockDriver clockDriver;
	private ClockController clockController;
	
	private JLabel title = new JLabel("Clock");
	private JLabel time;
	
	public ClockPanel() {
		this.add(title);
		this.time = new JLabel();
		this.add(this.time);
		this.setVisible(true);
	}
	
	public void build(ClockDriver clockDriver, ClockController clockController) {
		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockController.setLabel(time);
	}
	
	public void changeTime(int hour, int minute) {
		LocalTime newTime = LocalTime.of(hour, minute);
		this.clockDriver.setTime(newTime);
	}

	public ClockController getClockController() {
		return clockController;
	}
}
