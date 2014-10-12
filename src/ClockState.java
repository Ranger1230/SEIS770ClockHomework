

public interface ClockState {
	boolean GetIsEdit();
	void Increment();
	void Decrement();
	void ChangeMode(SimpleClock simpleClock);
	void Cancel(SimpleClock simpleCLock);
}
