package stabilizer;

public class PhasedPauli {
	public int phase; // 0, 1, 2 or 3 representing 1, i, -1, -i. Multiply by adding modulo 4.
	public Pauli op;
	
	public PhasedPauli(int p, Pauli o) {
		this.phase = p;
		this.op = o;
	}
	
	public String toString() {
		String s = "";
		switch (phase) {
			case 0: s = ""; break;
			case 1: s = "i"; break;
			case 2: s = "-"; break;
			case 3: s = "-i"; break;
		}
		s = s + op.toString();
		return s;
	}
}
