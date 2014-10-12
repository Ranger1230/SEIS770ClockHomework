

public interface ClockState {
	boolean GetIsEditMode();
	boolean GetIsEditHours();
	boolean GetIsEditMinutes();
	boolean GetIsEditSeconds();
	void Increment();
	void Decrement();
	void ChangeMode(SimpleClock simpleClock);
	void Cancel(SimpleClock simpleCLock);
}
