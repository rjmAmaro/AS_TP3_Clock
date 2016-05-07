package ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import alarm.AlarmManager;
import clock.ClockController;
import driver.ClockDriver;
import timeout.TimeoutController;
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
		super("Clock");
		this.clockDriver = clockDriver;
	}
	
	public void createAndShowGUI(ClockController clockController, TimeoutController timeoutController, AlarmManager alarmManager) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(1, 3));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		this.buildTimeoutPanel(timeoutController);
		this.buildClockPanel(clockController);
		this.buildAlarmPanel(alarmManager);
		
		this.pack();
		this.setVisible(true);
	}

	public void buildTimeoutPanel(TimeoutController timeoutController) {
		this.timeoutPanel = new TimeoutPanel();
		this.timeoutPanel.build(timeoutController);
		this.add(this.timeoutPanel);
	}
	
	public void buildClockPanel(ClockController clockController) {
		// In here only the title and the size will be build
		this.clockPanel = new ClockPanel(); 
		//Set the controller and driver to the Panel and build a first setup (one run)
		this.clockPanel.build(this.clockDriver, clockController); 
		
		this.add(this.clockPanel);
	}
	
	public void buildAlarmPanel(AlarmManager alarmManager) {
		this.alarmPanel = new AlarmPanel();
		this.alarmPanel.build(this.clockDriver, alarmManager);
		this.add(this.alarmPanel);
	}
	

	public ClockController getClockViewer() {
		return clockController;
	}

	public void setClockViewer(ClockController clockController) {
		this.clockController = clockController;
	}
}
