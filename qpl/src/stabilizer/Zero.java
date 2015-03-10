package stabilizer;

import java.util.Vector;

public class Zero implements Schedulable {

	public void reset() {
	}

	public Vector<Action> options() {
		return new Vector<Action>();
	}

	public void select(int n, boolean display) {
	}

}
