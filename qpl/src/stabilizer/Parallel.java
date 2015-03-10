package stabilizer;

import java.util.Vector;

public class Parallel implements Schedulable {

	Schedulable p, q;
	int pOptions, qOptions;
	Vector<ActionPair> tauOpts;
	
	public Parallel(Schedulable p, Schedulable q) {
		this.p = p;
		this.q = q;
	}

	public void reset() {
		p.reset();
		q.reset();
	}

	public Vector<Action> options() {
		Vector<Action> opts = p.options();
		pOptions = opts.size();
		
		Vector<Action> qOpts = q.options();
		qOptions = qOpts.size();
		
		tauOpts = new Vector<ActionPair>();
		
		for (int i = 0; i < pOptions; i++)
			for (int j = 0; j < qOptions; j++)
				if (opts.elementAt(i).name.compareTo(qOpts.elementAt(j).name) == 0 && opts.elementAt(i).complement != qOpts.elementAt(j).complement)
					tauOpts.addElement(new ActionPair(i,j));
		
		opts.addAll(qOpts);
		for (ActionPair ap : tauOpts)
			opts.addElement(new Action("tau",false));
		return opts;
	}

	public void select(int n, boolean display) {
		if (n < pOptions)
			p.select(n,display);
		else if (n < pOptions + qOptions)
			q.select(n-pOptions,display);
		else {
			ActionPair ap = tauOpts.elementAt(n-pOptions-qOptions);
			System.out.print("tau ");
			p.select(ap.fst,false);
			q.select(ap.snd,false);
		}
	}

}
