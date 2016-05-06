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
	
	private JPanel startPausePanel = new JPanel();
	private JPanel stopPanel = new JPanel();
	private JPanel editTimerPanel = new JPanel();
	private JPanel textPanel = new JPanel();

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
		buildStartPausePanel();
		startPausePanel.setVisible(true);
		buildStopPanel();
		buildEditTimerPanel();
	}
	
	private void buildStartPausePanel() {
		buildStartButton();
		buildPauseButton();
		startPausePanel.add(startButton);
		this.add(startPausePanel);
	}
	
	private void buildStopPanel() {
		buildStopButton();
		this.add(stopPanel);
	}
	
	private void buildEditTimerPanel() {
		buildEditButton();
		buildEditableTextFields();
		
		editTimerPanel.setLayout(new GridLayout(2, 1));
		
		editTimerPanel.add(textPanel);
		JPanel bPanel = new JPanel();
		bPanel.add(editButton);
		editTimerPanel.add(bPanel);
		editTimerPanel.setVisible(true);
		this.add(editTimerPanel);
	}
	
	private void buildStartButton() {
		this.startButton.setLocation(10, 400);
		this.startButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.startButton.setVisible(true);
		
		this.startButton.addActionListener(e -> {
			timeoutController.getState().start();
		});
	}
	
	private void buildStopButton() {
		this.stopButton.setLocation(10, 400);
		this.stopButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.stopButton.setVisible(true);
		
		this.stopButton.addActionListener(e -> {
			timeoutController.getState().stop();
		});
	}
	
	private void buildPauseButton() {
		this.pauseButton.setLocation(10, 400);
		this.pauseButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.pauseButton.setVisible(true);
		
		this.pauseButton.addActionListener(e -> {
			timeoutController.getState().pause();
		});
	}
	
	private void buildEditButton() {
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
	}
	
	public void hideAndDisableStartButton() {
		startPausePanel.remove(startButton);
		startButton.setEnabled(false);
		startButton.setVisible(false);
	}
	
	public void showAndEnableStartButton() {
		startPausePanel.add(startButton);
		startButton.setEnabled(true);
		startButton.setVisible(true);
	}
	
	public void hideAndDisablePauseButton() {
		pauseButton.setEnabled(false);
		pauseButton.setVisible(false);
		startPausePanel.remove(pauseButton);
	}
	
	public void showAndEnablePauseButton() {
		startPausePanel.add(pauseButton);
		pauseButton.setEnabled(true);
		pauseButton.setVisible(true);
	}
	
	public void hideAndDisableStopButton() {
//		stopPanel.remove(stopButton);
		stopButton.setEnabled(false);
		stopButton.setVisible(false);
	}
	
	public void showAndEnableStopButton() {
		stopPanel.add(stopButton);
		stopButton.setEnabled(true);
		stopButton.setVisible(true);
	}
	
	public void hideAndDisableEditPanel() {
		editButton.setEnabled(false);
		editTimerPanel.setVisible(false);
	}
	
	public void showAndEnableEditPanel() {
		editButton.setEnabled(true);
		editTimerPanel.setVisible(true);
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
