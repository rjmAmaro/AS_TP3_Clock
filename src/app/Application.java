package app;

import alarm.AlarmManager;
import alarm.AlarmController;
import clock.ClockController;
import driver.ClockDriver;
import timeout.TimeoutController;
import ui.AppFrame;

public class Application {

	public static void main(String[] args) {
		ClockDriver clockDriver = new ClockDriver();
		
		ClockController clockController = new ClockController();
		clockDriver.addObserver(clockController);
		
		TimeoutController timeoutController = new TimeoutController();
		clockDriver.addObserver(timeoutController);
		
		AlarmManager alarmManager = new AlarmManager(clockDriver);
		
		Thread t = new Thread(clockDriver);
		t.start();
		
		javax.swing.SwingUtilities.invokeLater(() -> {
			AppFrame appFrame = new AppFrame(clockDriver);
			appFrame.createAndShowGUI(clockController, timeoutController, alarmManager);
		});
	}

}
