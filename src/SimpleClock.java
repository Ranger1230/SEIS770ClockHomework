


public class SimpleClock {

	private ClockState _currentClockState;
	private TimeKeeper _timeKeeper;
	
	public SimpleClock() {
		_timeKeeper = new TimeKeeper();
		
		Thread t = new Thread(_timeKeeper, "timeKeeper");
		t.start();
			
		_currentClockState = new DisplayTimeClockState(this);
	}

	public void SetState(ClockState newState){
		_currentClockState = newState;
	}
	
	public boolean GetIsEditMode() {
		return _currentClockState.GetIsEditMode();
	}
	
	public boolean GetIsEditHours() {
		return _currentClockState.GetIsEditHours();
	}
	
	public boolean GetIsEditMinutes() {
		return _currentClockState.GetIsEditMinutes();
	}
	
	public boolean GetIsEditSeconds() {
		return _currentClockState.GetIsEditSeconds();
	}
	
	public long[] GetTime(){
		return new long[]{_timeKeeper.getHoursDisplayed(),_timeKeeper.getMinutesDisplayed(), _timeKeeper.getSecondsDisplayed()};
	}

	public void Increment() {
		_currentClockState.Increment();
	}

	public void Decrement() {
		_currentClockState.Decrement();
	}

	public void ChangeMode() {
		_currentClockState.ChangeMode();
	}

	public void Cancel() {
		_currentClockState.Cancel();
	}
	
	public void addHour() {
		_timeKeeper.addHour();
	}
	
	public void subtractHour() {
		_timeKeeper.subtractHour();
	}
	
	public void addMinute() {
		_timeKeeper.addMinute();
	}
	
	public void subtractMinute() {
		_timeKeeper.subtractMinute();
	}
	
	public void addSecond() {
		_timeKeeper.addSecond();
	}
	
	public void subtractSecond() {
		_timeKeeper.subtractSecond();
	}
	
	public void stopTimer() {
		_timeKeeper.stop();
	}
	
	public void startTimer() {
		_timeKeeper.start();
	}
	
}
