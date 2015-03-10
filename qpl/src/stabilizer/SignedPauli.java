package stabilizer;

public class SignedPauli {
	public int sign; // +1 or -1
	public Pauli op;
	
	public SignedPauli(int s, Pauli o) {
		this.sign = s;
		this.op = o;
	}
	
	public String toString() {
		String s;
		if (sign == 1)
			s = "+";
		else
			s = "-";
		s = s + op.toString();
		return s;
	}
}
