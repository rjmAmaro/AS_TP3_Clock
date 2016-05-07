package alarm;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import driver.ClockDriver;
import ui.alarm.AlarmPanel;

public class AlarmManager implements Runnable {
	
	private static int alarmIdCounter = 1;
	
	private ClockDriver clockDriver;
	private List<AlarmController> alarmsList;
	private AlarmPanel alarmPanel;
	
	
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
		alarm.setAlarmPanel(alarmPanel);
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
	
	public void deleteAlarm(AlarmController iAlarm){
		for(int i=0; i<alarmsList.size(); i++){
			if(alarmsList.get(i).getId() == iAlarm.getId()){
				clockDriver.deleteObserver(alarmsList.get(i));
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

	public static int getAlarmIdCounter() {
		return alarmIdCounter;
	}

	public static void setAlarmIdCounter(int alarmIdCounter) {
		AlarmManager.alarmIdCounter = alarmIdCounter;
	}

	public ClockDriver getClockDriver() {
		return clockDriver;
	}

	public void setClockDriver(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
	}

	public AlarmPanel getAlarmPanel() {
		return alarmPanel;
	}

	public void setAlarmPanel(AlarmPanel alarmPanel) {
		this.alarmPanel = alarmPanel;
	}
}
