package stabilizer;

import java.util.Vector;

public class Prefix implements Schedulable {
	int state; // 0 means beginning, 1 means after doing prefix
	Action pref;
	Schedulable continuation;

	public Prefix(Action prefix, Schedulable system) {
		pref = prefix;
		continuation = system;
	}

	public void reset() {
		state = 0;
	}

	public Vector<Action> options() {
		if (state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(pref);
			return a;
		}
		else
			return continuation.options();
	}

	public void select(int n, boolean display) {
		if (state == 0) {
			state = 1;
			if (display)
				System.out.print(pref+" ");
			continuation.reset();
		}
		else {
			continuation.select(n,display);
		}
	}

}
