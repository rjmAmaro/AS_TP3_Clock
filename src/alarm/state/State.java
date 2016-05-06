package alarm.state;

import javax.swing.JPanel;

public interface State {
	public void fire();
	public void shut();
	public void verify();
	public void edit(JPanel p);
	public void save(int hora, int minuto);
	public void cancel();
}
