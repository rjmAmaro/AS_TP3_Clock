package alarm;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import alarm.state.EditingState;
import alarm.state.FiredState;
import alarm.state.State;
import alarm.state.WaitingState;
import driver.ClockDriver;
import ui.alarm.AlarmPanel;

public class AlarmController implements Observer {
	
	private LocalTime alarmTime;
	private int id;
	private AlarmPanel alarmPanel;
	private JPanel thisAlarmPanel;
	
	private State waitingState;
	private State firedState;
	private State editingState;
	
	private State state;
	
	public AlarmController(int id, int hour, int minute) {
		this.id = id;
		this.alarmTime = LocalTime.of(hour, minute);
		
		this.waitingState = new WaitingState(this);
		this.firedState = new FiredState(this);
		this.editingState = new EditingState(this);
		
		this.state = waitingState;
	}

	@Override
	public void update(Observable o, Object arg) {
		LocalTime timeNow = ((ClockDriver) o).getTime().toLocalTime();
		
		if(timeNow.truncatedTo(ChronoUnit.SECONDS).equals(alarmTime.truncatedTo(ChronoUnit.SECONDS))){
			System.out.println("ALARM");
			this.state.fire();
		}	
	}

	public void editAlarm(int hora, int min) {	
		this.setAlarmTime(LocalTime.of(hora, min));
	}

	public LocalTime getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(LocalTime alarmTime) {
		this.alarmTime = alarmTime;
	}

	public State getWaitingState() {
		return waitingState;
	}

	public void setWaitingState(State waitingState) {
		this.waitingState = waitingState;
	}

	public State getFiredState() {
		return firedState;
	}

	public void setFiredState(State firedState) {
		this.firedState = firedState;
	}

	public State getEditingState() {
		return editingState;
	}

	public void setEditingState(State editingState) {
		this.editingState = editingState;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JPanel getThisAlarmPanel() {
		return thisAlarmPanel;
	}

	public void setThisAlarmPanel(JPanel thisAlarmPanel) {
		this.thisAlarmPanel = thisAlarmPanel;
	}

	public AlarmPanel getAlarmPanel() {
		return alarmPanel;
	}

	public void setAlarmPanel(AlarmPanel alarmPanel) {
		this.alarmPanel = alarmPanel;
	}


}
