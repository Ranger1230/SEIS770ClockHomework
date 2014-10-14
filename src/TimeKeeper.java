
public class TimeKeeper implements Runnable {

	private boolean isPaused;
	
	private long secondsDisplayed;
	private long minutesDisplayed;
	private long hoursDisplayed;

	private long startTime;
	private long secondsSaved;
	private long secondsElapsed;
	private long minutesSaved;
	private long minutesElapsed;
	private long hoursSaved;
	private long hoursElapsed;
	
	public TimeKeeper() {

		secondsSaved = 0;
		minutesSaved = 0;
		hoursSaved = 0;
		
		startTime = System.currentTimeMillis();
		isPaused = false;
	
	}
	
	public long getMinutesDisplayed() {
		return minutesDisplayed%60;
	}
	
	public long getSecondsDisplayed() {
		return secondsDisplayed%60;
	}
	
	public long getHoursDisplayed() {
		if (hoursDisplayed % 12 == 0) {
			return 12;
		} else {			
			return hoursDisplayed % 12;
		}
	}
	
	public void addHour() {
		hoursDisplayed += 1;
		hoursSaved += 1;
	}
	
	public void subtractHour() {
		
		if (hoursDisplayed == 0) {
			hoursDisplayed = 11;
		} else {			
			hoursDisplayed -= 1;
		}
		
		if (hoursSaved == 0) {
			hoursSaved = 11;
		} else {			
			hoursSaved -= 1;
		}
	}
	
	public void addMinute() {
		
		if (minutesDisplayed == 59) {
			minutesDisplayed = 0;
		} else {			
			minutesDisplayed += 1;
		}
		
		if (minutesSaved == 59) {			
			minutesSaved = 0;
		} else {
			minutesSaved += 1;
		}
	}
	
	public void subtractMinute() {
		
		if (minutesDisplayed == 0) {
			minutesDisplayed = 59;
		} else {			
			minutesDisplayed -= 1;
		}
		
		if (minutesSaved == 0) {
			minutesSaved = 59;
		} else {			
			minutesSaved -= 1;
		}		
	}
	
	public void addSecond() {
		secondsDisplayed += 1;
		secondsSaved += 1;
	}
	
	public void subtractSecond() {
		if (secondsDisplayed == 0) {
			secondsDisplayed = 59;
		} else {			
			secondsDisplayed -= 1;
		}
		
		if (secondsSaved == 0) {
			secondsSaved = 59;
		} else {			
			secondsSaved -= 1;
		}
		
	}
	
	@Override
	public void run() {
						
		try {
			
			synchronized (this) {
				
				while (true) {					
					if (!isPaused) {
						tick();
					}
										
					wait(1000);
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	private void tick() {
		
		secondsElapsed = (System.currentTimeMillis() - startTime)/1000;
		update();

	}
	
	private void update() {
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
	
	
	public void stop() {
		
		isPaused = true;
		
		secondsSaved = secondsDisplayed;
		minutesSaved = minutesDisplayed;
		hoursSaved = hoursDisplayed;
	}
	
	public void start() {
		
		isPaused = false;
		
		startTime = System.currentTimeMillis();
	}

}
