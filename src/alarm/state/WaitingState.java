package alarm.state;

import javax.swing.JPanel;

import alarm.AlarmController;
import ui.alarm.AlarmPanel;

public class WaitingState implements State{
	
	private AlarmController alarmController;
	
	public WaitingState(AlarmController alarmController){
		this.alarmController = alarmController;
	}

	@Override
	public void fire() {
		this.alarmController.setState(this.alarmController.getFiredState());
		AlarmPanel a = this.alarmController.getAlarmPanel();
		a.addTurnOffAlarmButton(true, this.alarmController);
	}

	@Override
	public void shut() { }

	@Override
	public void verify() { }

	@Override
	public void edit(JPanel p) {
		System.out.println("ID: "+alarmController.getId());
		this.alarmController.setState(this.alarmController.getEditingState());
		AlarmPanel a= this.alarmController.getAlarmPanel();
		a.changePanelToEditAlarm(this.alarmController, p);
	}

	@Override
	public void save(int hora, int minuto) { }

	@Override
	public void cancel() { }

}
