package app;

import clock.ClockViewer;
import driver.ClockDriver;

public class Clock {

	public static void main(String[] args) {
		
		ClockDriver clockDriver = new ClockDriver();
		ClockViewer clockViewer = new ClockViewer();
		
		clockDriver.addObserver(clockViewer);
		
		Thread t = new Thread(clockDriver);
		t.start();
	}

}
