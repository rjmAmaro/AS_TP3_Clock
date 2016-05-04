package clock;

import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;

import driver.ClockDriver;

public class ClockViewer implements Observer {
	
	LocalTime timeMod = LocalTime.of(12, 02, 02);

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Time: " + ((ClockDriver) o).getTime().toString());
		((ClockDriver) o).setTime(timeMod);
	}
	
}
