package alarm;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

import driver.ClockDriver;

public class AlarmController implements Observer {
	
	private LocalTime alarmTime;
	
	public AlarmController(int hour, int minute) {
		this.alarmTime = LocalTime.of(hour, minute);
	}

	@Override
	public void update(Observable o, Object arg) {
		LocalTime timeNow = ((ClockDriver) o).getTime();
		
		if(timeNow.truncatedTo(ChronoUnit.MINUTES).equals(alarmTime.truncatedTo(ChronoUnit.MINUTES)))
			System.out.println("ALARM");
	}

}
