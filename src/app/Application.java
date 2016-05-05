package app;

import alarm.AlarmManager;
import clock.ClockController;
import driver.ClockDriver;
import ui.AppFrame;
import ui.clock.ClockPanel;

public class Application {

	public static void main(String[] args) {
		ClockDriver clockDriver = new ClockDriver();
		ClockController clockViewer = new ClockController();
		
		clockDriver.addObserver(clockViewer);
		
		AppFrame appFrame = new AppFrame(clockDriver);
		appFrame.buildTimeoutPanel();
		appFrame.buildClockPanel(clockViewer);
		appFrame.buildAlarmPanel();
		
		Thread t = new Thread(clockDriver);
		t.start();
//		alarmManager = new AlarmManager(clockDriver);
	}

}
