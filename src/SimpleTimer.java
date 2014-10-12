
public class SimpleTimer implements Runnable {

	private boolean isPaused;
	private boolean isRunning;
	
	private long startTime;
	private long secondsElapsed;
	private long secondsDisplayed;
	private long minutesElapsed;
	private long minutesDisplayed;
	private long hoursElapsed;
	private long hoursDisplayed;
	
	public SimpleTimer() {

		startTime = System.currentTimeMillis();
		isPaused = false;
		isRunning = true;
	
	}
	
	public long getMinutesDisplayed() {
		return minutesDisplayed;
	}
	
	public long getSecondsDisplayed() {
		return secondsDisplayed;
	}
	
	public long getHoursDisplayed() {
		return hoursDisplayed;
	}
	
	@Override
	public void run() {
		
		while (true) {
						
			try {
				
				synchronized (this) {
					
					if (isRunning && !isPaused) {
						
					}
					tick();
					
					wait(1000);
				}
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
		}
	}
	
	private void tick() {

		secondsElapsed = System.currentTimeMillis() - startTime/1000;
		secondsDisplayed = (secondsDisplayed + secondsElapsed) % 60;
		minutesElapsed = secondsElapsed / 60;
		minutesDisplayed = (minutesDisplayed + minutesElapsed) % 60;
		hoursElapsed = minutesElapsed / 60;
		
		if ((hoursDisplayed + hoursElapsed) % 12 == 0) {
			hoursDisplayed = 12;
		} else {
			hoursDisplayed = (hoursDisplayed + hoursElapsed) % 12;
		}

	}

	public static void main (String[] args) {
		
		SimpleTimer timer = new SimpleTimer();
		
		timer.run();
		
	}

}
