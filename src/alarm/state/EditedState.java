package alarm.state;

import alarm.AlarmController;

public class EditedState implements State{
	
private AlarmController alarmControler;
	
	public EditedState(AlarmController alarmControler){
		this.alarmControler = alarmControler;
	}

	@Override
	public void fire() { }

	@Override
	public void shut() { }

	@Override
	public void verify() { }

	@Override
	public void edit() { }

	@Override
	public void save(int id, int hora, int minuto) {
		this.alarmControler.setState(this.alarmControler.getWaitingState());
	}

}