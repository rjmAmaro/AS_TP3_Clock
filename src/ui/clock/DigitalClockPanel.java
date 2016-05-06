package ui.clock;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClockPanel extends JPanel {
	private JLabel dateTimeLabel;

	public DigitalClockPanel() {
		super();
		dateTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(dateTimeLabel);
	}

	public JLabel getDateTimeLabel() {
		return dateTimeLabel;
	}

	public void setDateTimeLabel(JLabel dateTimeLabel) {
		this.dateTimeLabel = dateTimeLabel;
	}
	
}
