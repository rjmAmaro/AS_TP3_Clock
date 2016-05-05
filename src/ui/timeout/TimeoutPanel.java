package ui.timeout;

import java.awt.GridLayout;
import java.time.temporal.ChronoUnit;

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
		this.setLayout(new GridLayout(7, 1));
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title);
		timeLeftLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(timeLeftLabel);
		this.buildUI();
		this.setVisible(true);
	}

	public void build(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
		this.timeoutController.setPanel(this);
		timeLeftLabel.setText(this.timeoutController.getTimeAsString());
	}
	
	private void buildUI() {
		buildStartButton();
		buildStopButton();
		buildPauseButton();
		buildEditableTextFields();
		buildEditButton();
	}
	
	private void buildStartButton() {
		this.add(startButton);
		this.startButton.setLocation(10, 400);
		this.startButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.startButton.setVisible(true);
		
		this.startButton.addActionListener(e -> {
			timeoutController.getState().start();
		});
	}
	
	private void buildStopButton() {
		this.add(stopButton);
		this.stopButton.setLocation(10, 400);
		this.stopButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.stopButton.setVisible(true);
		
		this.stopButton.addActionListener(e -> {
			timeoutController.getState().stop();
		});
	}
	
	private void buildPauseButton() {
		this.add(pauseButton);
		this.pauseButton.setLocation(10, 400);
		this.pauseButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.pauseButton.setVisible(true);
		
		this.pauseButton.addActionListener(e -> {
			timeoutController.getState().pause();
		});
	}
	
	private void buildEditButton() {
		this.add(editButton);
		this.editButton.setLocation(10, 400);
		this.editButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.editButton.setVisible(true);
		
		this.editButton.addActionListener(e -> {
			int hour = Integer.parseInt(this.hourTextField.getText());
			hourTextField.setText("0");
			int minute = Integer.parseInt(this.minuteTextField.getText());
			minuteTextField.setText("0");
			int second = Integer.parseInt(this.secondTextField.getText());
			secondTextField.setText("0");
			timeoutController.getState().edit(hour, minute, second);
		});
	}
	
	private void buildEditableTextFields() {
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2, 3));
		
		JLabel hourLabel = new JLabel("Hours");
		textPanel.add(hourLabel);
		JLabel minuteLabel = new JLabel("Minutes");
		textPanel.add(minuteLabel);
		JLabel secondLabel = new JLabel("Seconds");
		textPanel.add(secondLabel);
		
//		hourTextField.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		hourTextField.setText("0");
		textPanel.add(hourTextField);
		
//		minuteTextField.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		minuteTextField.setText("0");
		textPanel.add(minuteTextField);
		
//		secondTextField.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		secondTextField.setText("0");
		textPanel.add(secondTextField);
		
		this.add(textPanel);
	}

	public JLabel getTimeLeftLabel() {
		return timeLeftLabel;
	}

	public void setTimeLeftLabel(JLabel timeLeftLabel) {
		this.timeLeftLabel = timeLeftLabel;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
	}

	public JButton getEditButton() {
		return editButton;
	}

	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}

	public JTextField getHourTextField() {
		return hourTextField;
	}

	public void setHourTextField(JTextField hourTextField) {
		this.hourTextField = hourTextField;
	}

	public JTextField getMinuteTextField() {
		return minuteTextField;
	}

	public void setMinuteTextField(JTextField minuteTextField) {
		this.minuteTextField = minuteTextField;
	}

	public JTextField getSecondTextField() {
		return secondTextField;
	}

	public void setSecondTextField(JTextField secondTextField) {
		this.secondTextField = secondTextField;
	}

}
