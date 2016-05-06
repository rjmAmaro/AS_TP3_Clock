package alarm;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import driver.ClockDriver;

public class AlarmManager implements Runnable {
	
	private static int alarmIdCounter = 1;
	
	private ClockDriver clockDriver;
	private List<AlarmController> alarmsList;
	
	
	public AlarmManager(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
		this.alarmsList = new ArrayList<AlarmController>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void createAlarm(int hour, int minute) {
		AlarmController alarm = new AlarmController(alarmIdCounter++, hour, minute);
		this.alarmsList.add(alarm);
		clockDriver.addObserver(alarm);
		System.out.println("[AlarmManager] New alarm created for " + hour + "h" + minute);
		printAlarms();
	}
	
	private void printAlarms() {
		for(int i=0; i<alarmsList.size(); i++){
			System.out.println("ALARME ID "+alarmsList.get(i).getId()+" : "+alarmsList.get(i).getAlarmTime());
		}
		
	}

	public void editAlarm(int id, int hour, int minute) {
		AlarmController alarm = null;
		for(AlarmController a : this.alarmsList) {
			if(a.getId() == id) {
				alarm = a;
				break;
			}
		}	
		alarm.setAlarmTime(LocalTime.of(hour, minute));
	}
	
	public void deleteAlarm(int id){
		for(int i=0; i<alarmsList.size(); i++){
			if(alarmsList.get(i).getId() == id){
				alarmsList.remove(i);
			}
		}
	}

	public List<AlarmController> getAlarmsList() {
		return alarmsList;
	}

	public void setAlarmsList(List<AlarmController> alarmsList) {
		this.alarmsList = alarmsList;
	}
}
