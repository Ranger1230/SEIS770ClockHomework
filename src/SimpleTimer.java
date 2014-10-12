
public class SimpleTimer implements Runnable {

	private boolean isPaused;
	private boolean isRunning;
	
	private long startTime;
	private long secondsSaved;
	private long secondsElapsed;
	private long secondsDisplayed;
	private long minutesSaved;
	private long minutesElapsed;
	private long minutesDisplayed;
	private long hoursSaved;
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
						
		try {
			
			synchronized (this) {
				
				if (isRunning && !isPaused) {
					tick();
				}
				
				System.out.println(hoursDisplayed + ":" + minutesDisplayed + ":" + secondsDisplayed);
				
				wait(1000);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	private void tick() {
		
		secondsElapsed = (System.currentTimeMillis() - startTime)/1000;
		secondsDisplayed = (secondsSaved + secondsElapsed) % 60;
		minutesElapsed = (secondsSaved + secondsElapsed) / 60;
		minutesDisplayed = (minutesSaved + minutesElapsed) % 60;
		hoursElapsed = (minutesSaved + minutesElapsed) / 60;
		
		if ((hoursSaved + hoursElapsed) % 12 == 0) {
			hoursDisplayed = 12;
		} else {
			hoursDisplayed = (hoursSaved + hoursElapsed) % 12;
		}

	}
	
	public void addHour() {
		hoursDisplayed += 1;
	}
	
	public void subtractHour() {
		hoursDisplayed -= 1;
	}
	
	public void addMinute() {
		minutesDisplayed += 1;
	}
	
	public void subtractMinute() {
		minutesDisplayed -= 1;
	}
	
	public void addSecond() {
		secondsDisplayed += 1;
	}
	
	public void subtractSecond() {
		secondsDisplayed -= 1;
	}
	
	public void stop() {
		
		isRunning = false;
		isPaused = true;
		
		secondsSaved = secondsDisplayed;
		minutesSaved = minutesDisplayed;
		hoursSaved = hoursDisplayed;
	}
	
	public void start() {
		
		isRunning = true;
		isPaused = false;
		
		startTime = System.currentTimeMillis();
	}

}
