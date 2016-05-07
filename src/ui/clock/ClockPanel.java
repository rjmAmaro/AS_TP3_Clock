package ui.clock;

import java.awt.GridLayout;
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
		
		this.setLayout(new GridLayout(6, 1));

		this.setVisible(true);
	}
	
	
	public void build(ClockDriver clockDriver, ClockController clockController) {
		
		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockController.setClockPanel(this);
		
		// create Panel that allow the user to edit the time (to be showned)
		editDateTimePanel = new EditDateTimePanel(clockDriver, clockController, this);
		
		// create Panel that show the user the clock (analog or digital)
		clockViewerPanel = new ClockViewerPanel(clockDriver, clockController, this);
		
		buildUI();
	}
	
	private void buildUI() {
		
		this.add(editDateTimePanel);
		
		this.add(clockViewerPanel);
		
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
