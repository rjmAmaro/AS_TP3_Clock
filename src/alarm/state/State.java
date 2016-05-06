package alarm.state;

import alarm.AlarmController;

public interface State {
	public void fire();
	public void shut();
	public void verify();
	public void edit();
	public void save(int id, int hora, int minuto);
}
