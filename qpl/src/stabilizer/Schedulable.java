package stabilizer;

import java.util.Vector;

public interface Schedulable {
	// Resets to the initial state
	public void reset();
	
	// Returns the number of options available in the current state.
	public Vector<Action> options();
	
	// Selects an option.
	public void select(int n, boolean display);
}
