package ui.timeout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import driver.ClockDriver;

public class TimeoutPanel extends JPanel {
	private ClockDriver clockDriver;

	private JLabel title = new JLabel("Timeout");

	public TimeoutPanel() {
		this.add(title);
		this.setVisible(true);
	}

	public void build(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
	}
}
