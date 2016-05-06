package alarm;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import driver.ClockDriver;

public class AlarmManager implements Runnable {
	
	private static int alarmIdCounter = 1;
	
	private ClockDriver clockDriver;
	private List<Alarm> alarmsList;
	
	
	public AlarmManager(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
		this.alarmsList = new ArrayList<Alarm>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void createAlarm(int hour, int minute) {
		Alarm alarm = new Alarm(alarmIdCounter++, hour, minute);
		this.alarmsList.add(alarm);
		clockDriver.addObserver(alarm);
		System.out.println("[AlarmManager] New alarm created for " + hour + "h" + minute);
		printAlarms();
	}
	
	private void printAlarms() {
		for(int i=0; i<alarmsList.size(); i++){
			System.out.println("ALARME Nº"+(i+1)+" : "+alarmsList.get(i).getAlarmTime());
		}
		
	}

	public void editAlarm(int id, int hour, int minute) {
		Alarm alarm = null;
		for(Alarm a : this.alarmsList) {
			if(a.getId() == id) {
				alarm = a;
				break;
			}
		}	
		alarm.setAlarmTime(LocalTime.of(hour, minute));
	}
}
