package clock.state;

import java.util.Date;

public interface State {
	
	public void digital();
	public void analog();
	public void edit(Date datetime);
	public void refresh();
	
	
	
}
