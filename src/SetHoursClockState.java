

public class SetHoursClockState extends ClockState {
	
	private SimpleTimer _timer;
	
	public SetHoursClockState(SimpleTimer timer) {
		_timer = timer;
	}

	@Override
	public void Increment() {
		_timer.addHour();
	}

	@Override
	public void Decrement() {
		_timer.subtractHour();
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
	public boolean GetIsEditHours() {
		// TODO Auto-generated method stub
		return true;
	}
}
