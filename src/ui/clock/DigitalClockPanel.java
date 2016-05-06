package ui.clock;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClockPanel extends JPanel {
	private JLabel dateTimeLabel;

	public DigitalClockPanel() {
		super();
		dateTimeLabel = new JLabel();
		dateTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(dateTimeLabel);
	}
	
	public void initiateDigitalClock(String textToShow) {
		dateTimeLabel.setText(textToShow);
	}

	public JLabel getDateTimeLabel() {
		return dateTimeLabel;
	}

	public void setDateTimeLabel(JLabel dateTimeLabel) {
		this.dateTimeLabel = dateTimeLabel;
	}
}
