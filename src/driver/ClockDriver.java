package driver;

import java.time.LocalDateTime;
import java.util.Observable;

public class ClockDriver extends Observable implements Runnable {
	
	private LocalDateTime time;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		time = LocalDateTime.now();
		
		try {
			Thread.sleep(999);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			time = time.plusSeconds(1);
			setChanged();
			notifyObservers();
			
//			System.out.println(time.toString());
			
			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void editCurrentDateTime(int year, int month, int dayOfMonth, int hour, int minute) {
		this.time = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
		setChanged();
		notifyObservers();
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
