package equivalence;

import java.util.Vector;
import stabilizer.ActionPair;

public class ParallelData {
	public Vector<Action> leftOpts;
	public Vector<Action> rightOpts;
	public Vector<CommData> commOpts;
	
	public ParallelData(Vector<Action> leftOpts, Vector<Action> rightOpts, Vector<CommData> commOpts) {
		this.leftOpts = leftOpts;
		this.rightOpts = rightOpts;
		this.commOpts = commOpts;
	}
}
