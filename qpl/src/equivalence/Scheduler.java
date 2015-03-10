package equivalence;

import equivalence.node.*;
import stabilizer.*;

import java.util.*;

public class Scheduler {
	public Start system;
	public Hashtable<Node,SelectParameters> inTable;
	public Hashtable<Node,Object> dataTable;
	public Hashtable<Node,Vector<Action>> outTable;
	public Hashtable<Node,Store> store;
	public StabilizerArray stab;
	public StabilizerArray startingStab;
	public Reset reset = new Reset();
	public Options options = new Options();
	public Select select = new Select();
	public Vector<Vector<Integer>> tree;
	public int runs;
	
	public Scheduler(Start system) {
		this.system = system;
	}
	
	public Vector<Integer> range(int n) {
		Vector<Integer> r = new Vector<Integer>(n);
		for (int i = 0; i < n; i++)
			r.addElement(i);
		return r;
	}
	
	public void reset() {
		this.inTable = new Hashtable<Node,SelectParameters>();
		this.dataTable = new Hashtable<Node,Object>();
		this.outTable = new Hashtable<Node,Vector<Action>>();
		this.store = new Hashtable<Node,Store>();
		stab = new StabilizerArray(startingStab);
		reset.defineIn(inTable);
		reset.defineData(dataTable);
		reset.defineOut(outTable);
		reset.defineStore(store);
		reset.stab = stab;
		options.defineIn(inTable);
		options.defineData(dataTable);
		options.defineOut(outTable);
		options.defineStore(store);
		options.stab = stab;
		select.defineIn(inTable);
		select.defineData(dataTable);
		select.defineOut(outTable);
		select.defineStore(store);
		select.stab = stab;
		system.apply(reset);
		reset.setStore(system,new Store());
	}
	
	// Generate the next path in a depth-first exploration of system, starting at the given depth
	public void exploreNext(int depth) {
		system.apply(options);
		Vector<Action> opts = options.getOut(system);
		Vector<Integer> r = range(opts.size());
		if (tree.size() <= depth) {
			tree.addElement(r);
			if (opts.size() == 0)
				return;
			else {
				select.setIn(system,new SelectParameters(r.elementAt(0),0));
				system.apply(select);
				exploreNext(depth+1);
			}
		}
		else {
			select.setIn(system,new SelectParameters(tree.elementAt(depth).elementAt(0),0));
			system.apply(select);
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
		reset();
		exploreNext(0);
		//System.out.println(); 
		//System.out.println(stab);
		remove();
		while (tree.size() > 0) {
			reset();
			exploreNext(0);
			//System.out.println();
			//System.out.println(stab);
			remove();
		}
	}
	
	// Return the output for a given input, or return nil if the output is not the same on all paths
	public StabilizerArray output(StabilizerArray input) {
		StabilizerArray result;
		this.startingStab = input;
		//System.out.println("Input:");
		//System.out.println(input);
		this.tree = new Vector<Vector<Integer>>(0);
		reset();
		runs = 0;
		exploreNext(0);
		result = stab;
		//System.out.println("Output:");
		//System.out.println(result);
		remove();
		runs = runs + 1;
		while (tree.size() > 0) {
			reset();
			exploreNext(0);
			runs = runs + 1;
			//System.out.println("Output:");
			//System.out.println(stab);
			if (!stab.equal(result))
				return null;
			remove();
		}
		return new StabilizerArray(result);
	}
	
}
