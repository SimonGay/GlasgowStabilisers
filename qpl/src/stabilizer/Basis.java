package stabilizer;

public class Basis implements Iterable<StabilizerArray> {
	
	int qubits;
	
	public Basis(int n) {
		qubits = n;
	}
	
	public BasisIterator iterator() {
		return new BasisIterator(qubits);
	}

}
