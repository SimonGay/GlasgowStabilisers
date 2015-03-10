package stabilizer;

import java.util.Iterator;
import java.util.Vector;
import java.util.NoSuchElementException;

public class BasisIterator implements Iterator<StabilizerArray> {
	
	Vector<Boolean> b;
	int qubits;
	int count;
	int basisSize;
	
	public BasisIterator(int n) {
		qubits = n;
		b = new Vector<Boolean>(n*2);
		for (int i = 0; i < n*2; i++)
			b.addElement(false);
		count = 0;
		basisSize = StabilizerArray.power2(n*2);
	}
	
	public boolean hasNext() {
		return count < basisSize;
	}
	
	public StabilizerArray next() {
		StabilizerArray sa = new StabilizerArray(qubits,b);
		b = StabilizerArray.inc(b);
		count = count + 1;
		return sa;
	}
	
	public void remove() {
		throw new NoSuchElementException();
	}

}
