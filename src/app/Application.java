package app;

import alarm.AlarmManager;
import clock.ClockViewer;
import driver.ClockDriver;
import ui.AppFrame;

public class Application {

	private static ClockDriver clockDriver;
	private static AlarmManager alarmManager;

	public static void main(String[] args) {
		ClockViewer clockViewer = new ClockViewer();
		AppFrame f = new AppFrame(clockViewer);
		clockDriver = new ClockDriver();
		clockDriver.addObserver(clockViewer);
		Thread t = new Thread(clockDriver);
		t.start();
//		alarmManager = new AlarmManager(clockDriver);
	}

}
