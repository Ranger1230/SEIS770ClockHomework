

public class DisplayTimeClockState implements ClockState {
	
	private SimpleTimer _timer;
	
	public DisplayTimeClockState(SimpleTimer timer){
		_timer = timer;
	}
	
	@Override
	public void Increment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Decrement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ChangeMode(SimpleClock simpleClock) {
		simpleClock.SetState(new SetHoursClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean GetIsEditMode() {
		return false;
	}

	@Override
	public boolean GetIsEditHours() {
		return false;
	}

	@Override
	public boolean GetIsEditMinutes() {
		return false;
	}

	@Override
	public boolean GetIsEditSeconds() {
		return false;
	}
}
