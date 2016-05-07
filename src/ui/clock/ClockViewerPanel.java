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
	private JButton changeClockTypeToAnalogButton;
	private JButton changeClockTypeToDigitalButton;
	
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
		
		buildChangeClockTypeButtons();
		changeViewerPanel.add(changeClockTypeToAnalogButton);

		analogClockPanel = new AnalogClockPanel();
//		clockViewer.setLayout(new GridLayout(1, 1));
//		clockViewer.add(analogClockPanel);
		
		digitalClockPanel = new DigitalClockPanel();
		clockViewer.add(digitalClockPanel);		
	}
	
	public void buildChangeClockTypeButtons(){
		changeClockTypeToAnalogButton = new JButton();
		changeClockTypeToAnalogButton.setText("Go to Analog Clock");
		changeClockTypeToAnalogButton.addActionListener(e -> {
			clockController.getState().analog();
		});
		
		changeClockTypeToDigitalButton = new JButton();
		changeClockTypeToDigitalButton.setText("Go to Digital Clock");
		changeClockTypeToDigitalButton.addActionListener(e -> {
			clockController.getState().digital();
		});
	}
	
	public void changeClockToAnalog() {
		clockViewer.remove(digitalClockPanel);
		clockViewer.add(analogClockPanel);
		
		changeViewerPanel.remove(changeClockTypeToAnalogButton);
		changeViewerPanel.add(changeClockTypeToDigitalButton);
	}
	
	public void changeClockToDigital() {
		clockViewer.remove(analogClockPanel);
		clockViewer.add(digitalClockPanel);	
		
		changeViewerPanel.remove(changeClockTypeToDigitalButton);
		changeViewerPanel.add(changeClockTypeToAnalogButton);
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
