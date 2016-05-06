package alarm.state;

public interface State {
	public void fire();
	public void shut();
	public void verify();
	public void edit();
	public void save(int id, int hora, int minuto);
}
