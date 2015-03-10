package stabilizer;

import java.util.Vector;

public class StabilizerRow {
	public int phase; // // 0, 1, 2 or 3 representing 1, i, -1, -i. Multiply by adding modulo 4.
	public Vector<Pauli> row;
	
	public StabilizerRow(int n) {
		row = new Vector<Pauli>(n);
		for (int i = 0; i < n; i++)
			row.addElement(Pauli.I);
		phase = 0;
	}
	
	public int length() {
		return row.size();
	}
	
	// Intended for use on a fresh row in which all entries are I
	public void setQbit(int q, SignedPauli a) {
		row.setElementAt(a.op,q);
		phase = 1 - a.sign;
	}
	
	public void applyX(int q) {
		SignedPauli a = QOps.applyX(row.elementAt(q));
		row.setElementAt(a.op,q);
		phase = (phase + (1 - a.sign)) % 4;
	}
	
	public void applyY(int q) {
		SignedPauli a = QOps.applyY(row.elementAt(q));
		row.setElementAt(a.op,q);
		phase = (phase + (1 - a.sign)) % 4;
	}
	
	public void applyZ(int q) {
		SignedPauli a = QOps.applyZ(row.elementAt(q));
		row.setElementAt(a.op,q);
		phase = (phase + (1 - a.sign)) % 4;
	}
	
	public void applyH(int q) {
		SignedPauli a = QOps.applyH(row.elementAt(q));
		row.setElementAt(a.op,q);
		phase = (phase + (1 - a.sign)) % 4;
	}
	
	public void applyP(int q) {
		SignedPauli a = QOps.applyP(row.elementAt(q));
		row.setElementAt(a.op,q);
		phase = (phase + (1 - a.sign)) % 4;
	}
	
	public void applyCNOT(int q, int r) {
		SignedPauliPair p = QOps.applyCNOT(row.elementAt(q),row.elementAt(r));
		row.setElementAt(p.p1,q);
		row.setElementAt(p.p2,r);
		phase = (phase + (1 - p.sign)) % 4;
	}
	
	// Returns this . s, i.e. pointwise multiplication with the correct overall phase 
	public StabilizerRow multiply(StabilizerRow s) {
		int n = this.length();
		int phase = this.phase;
		PhasedPauli p;
		StabilizerRow r = new StabilizerRow(n);
		for (int i = 0; i < n; i++) {
			p = QOps.multiply(row.elementAt(i),s.row.elementAt(i));
			phase = (phase + p.phase)%4;
			r.row.setElementAt(p.op,i);
		}
		r.phase = (s.phase + phase) % 4;
		return r;
	}
	
	// Multiply this by s in place
	public void multiplyBy(StabilizerRow s) {
		int n = this.length();
		PhasedPauli p;
		for (int i = 0; i < n; i++) {
			p = QOps.multiply(row.elementAt(i),s.row.elementAt(i));
			phase = (phase + p.phase)%4;
			row.setElementAt(p.op,i);
		}
		phase = (phase + s.phase) % 4;
	}
	
	// In-place movement of column a to column b, assuming a > b.
	// Columns from b onwards are shifted to the right.
	public void move(int a, int b) {
		Pauli p = row.remove(a);
		row.insertElementAt(p,b);
	}
	
	// Does this row consist entirely of I operators, with sign +1 (i.e. phase 0) ?
	public boolean isMinusIdentity() {
		for (Pauli p : row)
			if (p != Pauli.I)
				return false;
		return phase == 2;
	}
	
	// Does this row consist entirely of I operators, with sign -1 (i.e. phase 2) ?
		public boolean isIdentity() {
			for (Pauli p : row)
				if (p != Pauli.I)
					return false;
			return phase == 0;
		}
	
	public StabilizerRow copy() {
		int n = row.size();
		StabilizerRow c = new StabilizerRow(n);
		c.phase = phase;
		for (int i = 0; i < n; i++)
			c.row.setElementAt(row.elementAt(i), i);
		return c;
	}
	
	public String toString() {
		String s;
		switch (phase) {
			case 0: s = " +"; break;
			case 1: s = " i"; break;
			case 2: s = " -"; break;
			default: s = "-i"; break;
		}
		for (Pauli p : row)
			switch (p) {
				case I: s = s + "I"; break;
				case X: s = s + "X"; break;
				case Y: s = s + "Y"; break;
				case Z: s = s + "Z"; break;
			}
		return s;
	}
}
