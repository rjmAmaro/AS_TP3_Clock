package ui.alarm;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import alarm.AlarmController;
import alarm.AlarmManager;
import driver.ClockDriver;

public class AlarmPanel extends JPanel implements PropertyChangeListener {

	private ClockDriver clockDriver;
	private AlarmManager alarmManager;
	private AlarmController alarmController;
	
	private JLabel title = new JLabel("Alarms ");
	
	private JPanel newAlarmPanel;
	private JPanel alarmsListPanel;
	//private JPanel p;
	
	private Map<Integer, JPanel> alarmsListPanels;
	private List<AlarmController> alarmList;
	
	private JLabel horasLabel = new JLabel("Hora do Alarme");
	private JLabel minLabel = new JLabel("Minutos do Alarme");
	
	private JFormattedTextField horasField;
	private JFormattedTextField minField;
	
	private NumberFormat horasFormat;
	private NumberFormat minFormat;

	private int horasValor = 00;
	private int minValor = 00;

	private JButton createButton = new JButton("Create Alarm");

	public AlarmPanel() {
		this.alarmsListPanels = new HashMap<Integer, JPanel>();

		this.setLayout(new GridLayout(5, 1));
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title);
		buildUI();
		this.setVisible(true);
	}

	public void build(ClockDriver clockDriver, AlarmManager alarmManager) {
		this.clockDriver = clockDriver;	
		this.alarmManager = alarmManager;
	}
	
	private void buildUI(){
		buildNewAlarmPanel();
		this.add(newAlarmPanel);
		
		buildAlarmListPanel(0);
	}
	
	public void buildAlarmListPanel(int flag){
		if(flag == 0){
			addAlarmPanel(alarmManager, flag);
			alarmsListPanel = new JPanel();
			alarmsListPanel.setLayout(new GridLayout(0, 1));
			this.add(alarmsListPanel);
		}else if(flag==1){
			alarmsListPanel = new JPanel();
			alarmsListPanel.setLayout(new GridLayout(0, 1));
			this.add(alarmsListPanel);
			this.validate();
			this.repaint();
			addAlarmPanel(alarmManager, flag);
			
		}
	}
	
	private void buildNewAlarmPanel() {
		newAlarmPanel = new JPanel();
		newAlarmPanel.setLayout(new GridLayout(2, 1));
		newAlarmPanel.add(new JLabel("New Alarm"));
		
		JPanel a = new JPanel();
		a.setLayout(new GridLayout(1, 3));
		
		JPanel b = new JPanel();
		b.setLayout(new GridLayout(2, 1));
		b.add(horasLabel);
		horasField = new JFormattedTextField(horasFormat);
		horasField.setValue(horasValor);
		b.add(horasField);
		
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(2, 1));
		c.add(minLabel);
		minField = new JFormattedTextField(minFormat);
		minField.setValue(minValor);
		c.add(minField);
		
		JPanel d = new JPanel();
		buildCreateAlarmButton();
		d.add(createButton);
		
		a.add(b);
		a.add(c);
		a.add(d);
		
		newAlarmPanel.add(a);

		a.setVisible(true);
		b.setVisible(true);
		c.setVisible(true);
		d.setVisible(true);
	}
	
	public void buildCreateAlarmButton(){
		this.add(createButton);
//		this.createButton.setLocation(10, 400);
		//this.createButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.createButton.setVisible(true);
		
		this.createButton.addActionListener(e -> {
			this.alarmManager.createAlarm(Integer.parseInt(this.horasField.getText()), Integer.parseInt(this.minField.getText()));
			this.remove(alarmsListPanel);
			this.revalidate();
			this.repaint();
			buildAlarmListPanel(1);
		});
	}
	
	public void addAlarmPanel(AlarmManager alarm, int flag) {
			
		if(flag != 0){
			alarmList = alarm.getAlarmsList();		
				
			for(int i=0; i<alarmList.size(); i++){
				
				AlarmController iAlarm = alarmList.get(i);
				
				JPanel p = new JPanel();
				p.setLayout(new GridLayout(1, 3));
				
				
				p.setName(Integer.toString(iAlarm.getId()));		
				
				JPanel t = new JPanel();
				JPanel e = new JPanel();
				JPanel d = new JPanel();
				
				p.add(t);
				p.add(e);
				p.add(d);
				
				p.setVisible(true);
				t.setVisible(true);
				e.setVisible(true);
				d.setVisible(true);
				
				JLabel text = new JLabel(iAlarm.getAlarmTime().toString());
				t.add(text);
			
				JButton editB = new JButton("Edit");
				e.add(editB);
				/*editB.addActionListener(e1 -> {
					System.out.println("ID ALARME ESCOLHIDO: "+iAlarm.getId());
					//iAlarm.getState().edit();
				});*/
				
				JButton deleteB = new JButton("Delete");
				d.add(deleteB);
				deleteB.addActionListener(e2 -> {
					System.out.println("ID ALARME ESCOLHIDO: "+iAlarm.getId());
					this.alarmManager.deleteAlarm(iAlarm.getId());
					this.remove(alarmsListPanel);
					this.revalidate();
					this.repaint();
					buildAlarmListPanel(1);
				});
				
				alarmsListPanel.add(p);
			}
			
		}
	}
	
	
	public void changePanelToEditAlarm(int alarmId) {
		JPanel p = alarmsListPanels.get(Integer.toString(alarmId));
		
	}
	
	/** Called when a field's "value" property changes. */
	public void propertyChange(PropertyChangeEvent e) {
		Object source = e.getSource();
		if (source == horasField) {
			this.horasValor = ((Number)horasField.getValue()).intValue();
		}else if(source == minField) {
			this.minValor = ((Number)minField.getValue()).intValue();
		}
	}
}
