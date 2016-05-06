package ui.clock;

import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JPanel;

import clock.ClockController;
import driver.ClockDriver;

public class ClockPanel extends JPanel {
	
	private ClockDriver clockDriver;
	private ClockController clockController;
	
	private EditDateTimePanel editDateTimePanel;
	private ClockViewerPanel clockViewerPanel;
	
	private JLabel title = new JLabel("Clock");
	private JLabel time;
	
	public ClockPanel() {
		this.add(title);
		this.time = new JLabel();
		this.add(this.time);
		this.setVisible(true);
		
		
		
		editDateTimePanel = new EditDateTimePanel(this);
		clockViewerPanel = new ClockViewerPanel(this);
		
	}
	
	
	public void build(ClockDriver clockDriver, ClockController clockController) {
		
		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockController.setClockPanel(this);
		this.clockController.setLabel(time);

		editDateTimePanel.build(clockController, clockDriver);
		clockViewerPanel.build(clockController, clockDriver);
	}
	
	public void changeTime(int hour, int minute) {
		LocalTime newTime = LocalTime.of(hour, minute);
		this.clockDriver.setTime(newTime);
	}

	public ClockController getClockController() {
		return clockController;
	}
	
	public EditDateTimePanel getEditDateTimePanel() {
		return editDateTimePanel;
	}


	public void setEditDateTimePanel(EditDateTimePanel editDateTimePanel) {
		this.editDateTimePanel = editDateTimePanel;
	}


	public ClockViewerPanel getClockViewerPanel() {
		return clockViewerPanel;
	}


	public void setClockViewerPanel(ClockViewerPanel clockViewerPanel) {
		this.clockViewerPanel = clockViewerPanel;
	}


	
}
