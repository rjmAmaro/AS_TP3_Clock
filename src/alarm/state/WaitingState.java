package alarm.state;

import alarm.AlarmController;

public class WaitingState implements State{
	
	private AlarmController alarmController;
	
	public WaitingState(AlarmController alarmController){
		this.alarmController = alarmController;
	}

	@Override
	public void fire() {
		this.alarmController.setState(this.alarmController.getFiredState());
	}

	@Override
	public void shut() { }

	@Override
	public void verify() { }

	@Override
	public void edit() {
		this.alarmController.setState(this.alarmController.getEditedState());
		this.alarmController.getAlarmPanel().changePanelToEditAlarm(this.alarmController.getId());
	}

	@Override
	public void save(int id, int hora, int minuto) { }

}
