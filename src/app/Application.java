package app;

import alarm.AlarmManager;
import driver.ClockDriver;
import ui.AppFrame;

public class Application {
	
	private static ClockDriver clockDriver;
	private static AlarmManager alarmManager;
	
	public static void main(String[] args) {
		AppFrame f = new AppFrame();
//		clockDriver = new ClockDriver();
//		alarmManager = new AlarmManager(clockDriver);
	}

}
