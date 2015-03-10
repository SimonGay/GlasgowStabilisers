package stabilizer;

import java.util.Vector;

public class Measurement implements Schedulable {
	int state; // 0 means before producing result, 1 means in continuation
	Schedulable continuation;
	
	public Measurement(Schedulable cont) {
		continuation = cont;
	}

	public void reset() {
		state = 0;
	}

	public Vector<Action> options() {
		if (state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new Action("tau", false));
			a.addElement(new Action("tau", false));
			return a;
		}
		else
			return continuation.options();
	}

	public void select(int n, boolean display) {
		if (state == 0) {
			if (display)
				System.out.print("measure<"+n+"> ");
			state = 1;
			continuation.reset();
		}
		else
			continuation.select(n,display);
	}

}
