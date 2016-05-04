package alarm;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

import driver.ClockDriver;

public class Alarm implements Observer {
	
	private LocalTime alarmTime;
	private int id;
	
	public Alarm(int id, int hour, int minute) {
		this.id = id;
		this.alarmTime = LocalTime.of(hour, minute);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(alarmTime.truncatedTo(ChronoUnit.MINUTES).equals(((ClockDriver) o).getTime().truncatedTo(ChronoUnit.MINUTES)))
			System.out.println("ALARM!");
	}

	public LocalTime getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(LocalTime alarmTime) {
		this.alarmTime = alarmTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
