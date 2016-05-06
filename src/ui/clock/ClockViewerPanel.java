package ui.clock;

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
//	private AnalogClockPanel analogClockPanel;	// painel para mostrar o relógio em modo analógico
	private JButton changeClockTypeButton;
	
	public ClockViewerPanel(ClockPanel clockPanel) {
		super();
		this.clockPanel = clockPanel;
		buildUI();
	}
	
	public void build(ClockController clockController, ClockDriver clockDriver){
		this.clockController = clockController;
		this.clockDriver = clockDriver;
	}
	
	private void buildUI() {
		clockViewer = new JPanel();
		this.add(clockViewer);
		changeViewerPanel = new JPanel();
		this.add(changeViewerPanel);
		
		digitalClockPanel = new DigitalClockPanel();
		clockViewer.add(digitalClockPanel);
		initiateDigitalClock();
		
		buildChangeClockTypeButton();
		changeViewerPanel.add(changeClockTypeButton);
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
	
	private void initiateDigitalClock() {
		digitalClockPanel.getDateTimeLabel().setText(clockController.getDateTime().toString());
	}
	
	public void initiateAnalogClock(){

	}

}
