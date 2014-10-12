

public class SetSecondsClockState implements ClockState {


	private Timer _timer;
	
	public SetSecondsClockState(Timer timer){
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
		simpleClock.SetState(new DisplayTimeClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		simpleClock.SetState(new SetMinutesClockState(_timer));
	}

	@Override
	public boolean GetIsEdit() {
		return true;
	}

}
