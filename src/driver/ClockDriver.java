package driver;

import java.time.LocalTime;
import java.util.Observable;

public class ClockDriver extends Observable implements Runnable {
	
	private LocalTime time;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		time = LocalTime.now();
		
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
