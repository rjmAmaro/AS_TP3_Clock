package clock;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import driver.ClockDriver;

public class ClockController implements Observer {
	
	JLabel label;

	@Override
	public void update(Observable o, Object arg) {
		label.setText(((ClockDriver) o).getTime().toString());
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
