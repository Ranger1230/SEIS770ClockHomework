

public class SetMinutesClockState implements ClockState {


	private SimpleTimer _timer;
	
	public SetMinutesClockState(SimpleTimer timer){
		_timer = timer;
	}

	@Override
	public void Increment() {
		_timer.addMinute();
	}

	@Override
	public void Decrement() {
		_timer.subtractMinute();
	}

	@Override
	public void ChangeMode(SimpleClock simpleClock) {
		_timer.stop();
		simpleClock.SetState(new SetSecondsClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		simpleClock.SetState(new SetHoursClockState(_timer));
	}

	@Override
	public boolean GetIsEditMode() {
		return true;
	}

	@Override
	public boolean GetIsEditHours() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetIsEditMinutes() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetIsEditSeconds() {
		// TODO Auto-generated method stub
		return false;
	}

}
