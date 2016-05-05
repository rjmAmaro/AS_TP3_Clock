package ui.alarm;

import javax.swing.JLabel;
import javax.swing.JPanel;

import driver.ClockDriver;

public class AlarmPanel extends JPanel {

	private ClockDriver clockDriver;
	
	private JLabel title = new JLabel("Alarms");
	
	public AlarmPanel() {
		this.add(title);
		this.setVisible(true);
	}
	
	public void build(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
	}
}
