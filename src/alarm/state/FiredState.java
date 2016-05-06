package alarm.state;

import alarm.AlarmController;

public class FiredState implements State{
	
	private AlarmController alarmControler;
	
	public FiredState(AlarmController alarmControler){
		this.alarmControler = alarmControler;
	}
	
	@Override
	public void fire() { }

	@Override
	public void shut() {
		this.alarmControler.setState(this.alarmControler.getWaitingState());
	}

	@Override
	public void verify() { }

	@Override
	public void edit() { }

	@Override
	public void save(int id, int hora, int minuto) { }

}
