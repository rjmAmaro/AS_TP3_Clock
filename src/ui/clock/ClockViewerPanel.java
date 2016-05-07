package ui.clock;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JPanel;

import clock.ClockController;
import driver.ClockDriver;

public class ClockViewerPanel extends JPanel {

	private ClockPanel clockPanel;
	private ClockDriver clockDriver;
	private ClockController clockController;
	
	private JPanel clockViewer;					// painel onde é mostrado o relógio em formato digital ou analógico
	private JPanel changeViewerPanel;			// painel com o botão para mudar o tipo de visualização (digital/analógico)
	private DigitalClockPanel digitalClockPanel;// painel para mostrar o relógio em modo digital
	private AnalogClockPanel analogClockPanel;	// painel para mostrar o relógio em modo analógico
	private JButton changeClockTypeButton;
	
	public ClockViewerPanel(ClockDriver clockDriver, ClockController clockController, ClockPanel clockPanel) {
		super();
		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockPanel = clockPanel;
		buildUI();
	}
	
	private void buildUI() {
		
		changeViewerPanel = new JPanel();
		this.add(changeViewerPanel);
		
		clockViewer = new JPanel();
		this.add(clockViewer);
		
		buildChangeClockTypeButton();
		changeViewerPanel.add(changeClockTypeButton);

		analogClockPanel = new AnalogClockPanel();
		clockViewer.setLayout(new GridLayout(1, 1));
		clockViewer.add(analogClockPanel);
		
		digitalClockPanel = new DigitalClockPanel();
		clockViewer.add(digitalClockPanel);		
		

		
	}
	
	public void buildChangeClockTypeButton(){
		changeClockTypeButton = new JButton();
		this.setChangeClockTypeButtonToAnalog();
	}
	
	private void setChangeClockTypeButtonToAnalog() {
		changeClockTypeButton.setText("Go to Analog Clock");
		changeClockTypeButton.addActionListener(e -> {
			clockController.getState().analog();
			this.setChangeClockTypeButtonToDigital();
		});
	}
	
	private void setChangeClockTypeButtonToDigital() {
		changeClockTypeButton.setText("Go to Digital Clock");
		changeClockTypeButton.addActionListener(e -> {
			clockController.getState().digital();
			this.setChangeClockTypeButtonToAnalog();
		});
		
		
	}
	
	public DigitalClockPanel getDigitalClockPanel() {
		return digitalClockPanel;
	}

	public void setDigitalClockPanel(DigitalClockPanel digitalClockPanel) {
		this.digitalClockPanel = digitalClockPanel;
	}
	
	public AnalogClockPanel getAnalogClockPanel() {
		return analogClockPanel;
	}

	public void setAnalogClockPanel(AnalogClockPanel analogClockPanel) {
		this.analogClockPanel = analogClockPanel;
	}


}
