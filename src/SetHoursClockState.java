

public class SetHoursClockState implements ClockState {
	
	private SimpleTimer _timer;
	
	public SetHoursClockState(SimpleTimer timer) {
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
		simpleClock.SetState(new SetMinutesClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		simpleClock.SetState(new DisplayTimeClockState(_timer));
	}

	@Override
	public boolean GetIsEditMode() {
		return true;
	}

	@Override
	public boolean GetIsEditHours() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetIsEditMinutes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetIsEditSeconds() {
		// TODO Auto-generated method stub
		return false;
	}

}
