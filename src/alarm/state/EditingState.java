package alarm.state;

import javax.swing.JPanel;

import alarm.AlarmController;

public class EditingState implements State{
	
private AlarmController alarmControler;
	
	public EditingState(AlarmController alarmControler){
		this.alarmControler = alarmControler;
	}

	@Override
	public void fire() { }

	@Override
	public void shut() { }

	@Override
	public void verify() { }

	@Override
	public void edit(JPanel p) { }

	@Override
	public void save(AlarmController alarmController2, int hora, int minuto) {
		this.alarmControler.editAlarm(hora, minuto);
		this.alarmControler.setState(this.alarmControler.getWaitingState());
	}

	@Override
	public void cancel() {
		this.alarmControler.setState(this.alarmControler.getWaitingState());
	}

}
