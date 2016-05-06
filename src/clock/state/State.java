package clock.state;

import java.util.Date;

public interface State {
	
	public void digital();
	public void analog();
	public void edit(int year, int month, int dayOfMonth, int hour, int minute);
	public void refresh();
	
	
	
}
