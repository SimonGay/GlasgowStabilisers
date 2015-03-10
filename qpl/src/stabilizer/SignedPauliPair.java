package stabilizer;

public class SignedPauliPair {
	public int sign; // +1 or -1
	public Pauli p1, p2;
	
	public SignedPauliPair(int s, Pauli a, Pauli b) {
		this.sign = s;
		this.p1 = a;
		this.p2 = b;
	}
}
