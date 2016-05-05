package ui.timeout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import timeout.TimeoutController;

public class TimeoutPanel extends JPanel {
	private static final int BUTTON_WIDTH = 50;
	private static final int BUTTON_HEIGHT = 20;
	private static final int BUTTON_WIDTH_INTERVAL = 10;
	private static final int BUTTON_HEIGHT_INTERVAL = 10;
	
	private static final int TEXT_FIELD_WIDTH = 50;
	private static final int TEXT_FIELD_HEIGHT = 20;
	
	private TimeoutController timeoutController;

	private JLabel title = new JLabel("Timeout");
	private JLabel timeLeftLabel = new JLabel();
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private JButton pauseButton = new JButton("Pause");
	private JButton editButton = new JButton("Edit");
	
	private JTextField hourTextField = new JTextField();
	private JTextField minuteTextField = new JTextField();
	private JTextField secondTextField = new JTextField();

	public TimeoutPanel() {
		this.add(title);
		this.add(timeLeftLabel);
		this.buildUI();
		this.setVisible(true);
	}

	public void build(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
		this.timeoutController.setTimeLeftLabel(this.timeLeftLabel);
	}
	
	private void buildUI() {
		buildStartButton();
		buildStopButton();
		buildPauseButton();
		buildEditButton();
		buildEditableTextFields();
	}
	
	private void buildStartButton() {
		this.add(startButton);
		this.startButton.setLocation(10, 400);
		this.startButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.startButton.setVisible(true);
		
		this.startButton.addActionListener(e -> {
			timeoutController.getState().start();;
		});
	}
	
	private void buildStopButton() {
		this.add(stopButton);
		this.stopButton.setLocation(10, 400);
		this.stopButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.stopButton.setVisible(true);
		
		this.stopButton.addActionListener(e -> {
			timeoutController.getState().stop();;
		});
	}
	
	private void buildPauseButton() {
		this.add(pauseButton);
		this.pauseButton.setLocation(10, 400);
		this.pauseButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.pauseButton.setVisible(true);
		
		this.pauseButton.addActionListener(e -> {
			timeoutController.getState().pause();;
		});
	}
	
	private void buildEditButton() {
		this.add(editButton);
		this.editButton.setLocation(10, 400);
		this.editButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.editButton.setVisible(true);
		
		this.editButton.addActionListener(e -> {
			int hour = Integer.parseInt(this.hourTextField.getText());
			int minute = Integer.parseInt(this.minuteTextField.getText());
			int second = Integer.parseInt(this.secondTextField.getText());
			timeoutController.getState().edit(hour, minute, second);
		});
	}
	
	private void buildEditableTextFields() {
		hourTextField.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		this.add(hourTextField);
		
		minuteTextField.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		this.add(minuteTextField);
		
		secondTextField.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		this.add(secondTextField);
	}

}
