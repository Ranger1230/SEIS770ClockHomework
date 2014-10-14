

public class DisplayTimeClockState extends ClockState {
	
	private SimpleTimer _timer;
	
	public DisplayTimeClockState(SimpleTimer timer){
		_timer = timer;
	}

	@Override
	public void ChangeMode(SimpleClock simpleClock) {
		simpleClock.SetState(new SetHoursClockState(_timer));
	}

	@Override
	public boolean GetIsEditMode() {
		return false;
	}
}
