package app;

import clock.ClockController;
import driver.ClockDriver;
import timeout.TimeoutController;
import timeout.TimeoutManager;
import ui.AppFrame;

public class Application {

	public static void main(String[] args) {
		ClockDriver clockDriver = new ClockDriver();
		
		ClockController clockController = new ClockController();
		clockDriver.addObserver(clockController);
		
		TimeoutManager timeoutManager = new TimeoutManager();
		TimeoutController timeoutController = new TimeoutController();
		timeoutManager.setTimeoutController(timeoutController);
		clockDriver.addObserver(timeoutController);
		
		AppFrame appFrame = new AppFrame(clockDriver);
		appFrame.buildTimeoutPanel(timeoutManager);
		appFrame.buildClockPanel(clockController);
		appFrame.buildAlarmPanel();
		
		Thread t = new Thread(clockDriver);
		t.start();
//		alarmManager = new AlarmManager(clockDriver);
	}

}
