package stabilizer;

import java.util.Vector;

public class Scheduler {
	Schedulable system;
	Vector<Vector<Integer>> tree;
	
	public Scheduler(Schedulable system) {
		this.system = system;
	}
	
	public Vector<Integer> range(int n) {
		Vector<Integer> r = new Vector<Integer>(n);
		for (int i = 0; i < n; i++)
			r.addElement(i);
		return r;
	}
	
	// Generate the next path in a depth-first exploration of system, starting at the given depth
	public void exploreNext(int depth) {
		Vector<Action> opts = system.options();
		Vector<Integer> r = range(opts.size());
		if (tree.size() <= depth) {
			tree.addElement(r);
			if (opts.size() == 0)
				return;
			else {
				system.select(r.elementAt(0),true);
				exploreNext(depth+1);
			}
		}
		else {
			system.select(tree.elementAt(depth).elementAt(0),true);
			exploreNext(depth+1);
		}
	}
	
	// Remove the current path
	public void remove() {
		while (tree.size() > 0 && tree.elementAt(tree.size()-1).size() == 0) {
			tree.removeElementAt(tree.size()-1);
			if (tree.size() > 0)
				tree.elementAt(tree.size()-1).removeElementAt(0);
		}
	}
	
	// Full exploration
	public void explore() {
		this.tree = new Vector<Vector<Integer>>(0);
		system.reset();
		exploreNext(0);
		System.out.println(); 
		remove();
		while (tree.size() > 0) {
			system.reset();
			exploreNext(0);
			System.out.println();
			remove();
		}
	}
	
}
