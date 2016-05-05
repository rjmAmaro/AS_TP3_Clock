package ui.clock;

import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import clock.ClockController;
import driver.ClockDriver;

public class ClockPanel extends JPanel {
	
	private ClockDriver clockDriver;
	private ClockController clockController;
	private EditClockPanel editClockPanel;
	
	private JLabel title = new JLabel("Clock");
	private JLabel time;
	
	public ClockPanel() {
		this.add(title);
		this.time = new JLabel();
		this.add(this.time);
		this.setVisible(true);
		
		editClockPanel = new EditClockPanel(this);
			
	}
	
	
	public void build(ClockDriver clockDriver, ClockController clockController) {
		
		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockController.setLabel(time);
		
		editClockPanel.build(clockController, clockDriver);
		
	}
	
	public void changeTime(int hour, int minute) {
		LocalTime newTime = LocalTime.of(hour, minute);
		this.clockDriver.setTime(newTime);
	}

	public ClockController getClockController() {
		return clockController;
	}

	public EditClockPanel getEditClockPanel() {
		return editClockPanel;
	}

	public void setEditClockPanel(EditClockPanel editClockPanel) {
		this.editClockPanel = editClockPanel;
	}
}
