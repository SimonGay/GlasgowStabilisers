package stabilizer;

import java.util.Vector;

public class StabilizerArray {
	public int nqubits;
	public Vector<StabilizerRow> stabilizers;
	public Vector<StabilizerRow> destabilizers;
	
	// Initialize a stabilizer array for n qubits in state |00...0>
	public StabilizerArray(int n) {
		StabilizerRow row;
		nqubits = n;
		stabilizers = new Vector<StabilizerRow>(n);
		destabilizers = new Vector<StabilizerRow>(n);
		for (int i = 0; i < n; i++) {
			row = new StabilizerRow(n);
			row.setQbit(i, new SignedPauli(+1,Pauli.Z));
			stabilizers.addElement(row);
			row = new StabilizerRow(n);
			row.setQbit(i, new SignedPauli(+1,Pauli.X));
			destabilizers.addElement(row);
		}
	}
	
	// Initialize as a copy of a given stabilizer array
	public StabilizerArray(StabilizerArray s) {
		nqubits = s.nqubits;
		stabilizers = new Vector<StabilizerRow>();
		destabilizers = new Vector<StabilizerRow>();
		for (StabilizerRow r : s.stabilizers)
			stabilizers.addElement(r.copy());
		for (StabilizerRow r : s.destabilizers)
			destabilizers.addElement(r.copy());
	}
	
	// Initialize as a stabilizer basis element on n qubits, defined by a vector of 2n bits
	public StabilizerArray(int n, Vector<Boolean> b) {
		this(n);
		Vector<Integer> ones = new Vector<Integer>();
		Vector<Integer> zeros = new Vector<Integer>();
		for (int j = 0; j < n; j++)
			if (b.elementAt(j))
				ones.addElement(j);
			else
				zeros.addElement(j);
		int i = ones.size();
		for (int j = 0; j < i; j++)
			if (b.elementAt(n+j))
				this.applyX(ones.elementAt(j));
		if (i < n) {
			this.applyH(zeros.elementAt(0));
			if (b.elementAt(2*n-1))
				this.applyP(zeros.elementAt(0));
			for (int j = 0; j < n - i - 1; j++)
				this.applyCNOT(zeros.elementAt(0),zeros.elementAt(j+1));
			for (int j = 0; j < n - i - 1; j++)
				if (b.elementAt(n+j))
					this.applyX(zeros.elementAt(j+1));
		}
	}
	
	public static Vector<Boolean> incCarry(Vector<Boolean> b, boolean c) {
		Vector<Boolean> bb = new Vector<Boolean>(b.size());
		bb.addElement(b.elementAt(0)?c:!c);
		c = b.elementAt(0) || c;
		for (int i = 1; i < b.size(); i++) {
			bb.addElement(b.elementAt(i)?!c:c);
			c = b.elementAt(i) && c;
		}
		return bb;
	}
	
	public static Vector<Boolean> inc(Vector<Boolean> b) {
		return incCarry(b,false);
	}
	
	public static int power2(int n) {
		int p = 1;
		while (n > 0) {
			p = p * 2;
			n--;
		}
		return p;
	}
	
	public void reset() {
		StabilizerRow row;
		int n = nqubits;
		stabilizers = new Vector<StabilizerRow>(n);
		destabilizers = new Vector<StabilizerRow>(n);
		for (int i = 0; i < n; i++) {
			row = new StabilizerRow(n);
			row.setQbit(i, new SignedPauli(+1,Pauli.Z));
			stabilizers.addElement(row);
			row = new StabilizerRow(n);
			row.setQbit(i, new SignedPauli(+1,Pauli.X));
			destabilizers.addElement(row);
		}
	}
	
	public int allocate() {
		stabilizers.addElement(new StabilizerRow(nqubits));
		destabilizers.addElement(new StabilizerRow(nqubits));
		for (StabilizerRow r : stabilizers)
			r.row.addElement(Pauli.I);
		for (StabilizerRow r : destabilizers)
			r.row.addElement(Pauli.I);
		stabilizers.elementAt(stabilizers.size()-1).setQbit(nqubits,new SignedPauli(+1,Pauli.Z));
		destabilizers.elementAt(stabilizers.size()-1).setQbit(nqubits,new SignedPauli(+1,Pauli.X));
		nqubits = nqubits + 1;
		return nqubits - 1;
	}
	
	// All of these operations take time O(n)
	public void applyX(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyX(q);
		for (StabilizerRow row : destabilizers)
			row.applyX(q);
	}
	
	public void applyY(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyY(q);
		for (StabilizerRow row : destabilizers)
			row.applyY(q);
	}
	
	public void applyZ(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyZ(q);
		for (StabilizerRow row : destabilizers)
			row.applyZ(q);
	}
	
	public void applyH(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyH(q);
		for (StabilizerRow row : destabilizers)
			row.applyH(q);
	}
	
	public void applyP(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyP(q);
		for (StabilizerRow row : destabilizers)
			row.applyP(q);
	}
	
	public void applyCNOT(int q, int r) {
		for (StabilizerRow row : stabilizers)
			row.applyCNOT(q,r);
		for (StabilizerRow row : destabilizers)
			row.applyCNOT(q,r);
	}
	
	// Does measurement of qubit q have a random result?
	public boolean measurementIsRandom(int q) {
		for (StabilizerRow row : stabilizers)
			if (row.row.elementAt(q) == Pauli.X || row.row.elementAt(q) == Pauli.Y)
				return true;
		return false;
	}
	
	// Choose the result r of a random measurement of qubit q.
	// First use measurementIsRandom to establish that the result is random.
	public void chooseMeasurementResult(int q, int r) {
		int p = 0;
		while (stabilizers.elementAt(p).row.elementAt(q) == Pauli.I || stabilizers.elementAt(p).row.elementAt(q) == Pauli.Z)
			p++;
		for (StabilizerRow row : destabilizers)
			row.multiplyBy(stabilizers.elementAt(p));
		for (int i = 0; i < stabilizers.size(); i++)
			if (i != p && (stabilizers.elementAt(i).row.elementAt(q) == Pauli.X || stabilizers.elementAt(i).row.elementAt(q) == Pauli.Y))
				stabilizers.elementAt(i).multiplyBy(stabilizers.elementAt(p));
		StabilizerRow newRow = new StabilizerRow(stabilizers.elementAt(p).row.size());
		newRow.setQbit(q,new SignedPauli(1-2*r,Pauli.Z));
		stabilizers.setElementAt(newRow,p);
	}
	
	// Find the result of a deterministic measurement of qubit q.
	// Assume that measurementIsRandom(q) returned false.
	public boolean findMeasurementResult(int q) {
		StabilizerRow newRow = new StabilizerRow(stabilizers.elementAt(0).row.size());
		for (int i = 0; i < destabilizers.size(); i++) {
			Pauli p = destabilizers.elementAt(i).row.elementAt(q);
			if (p == Pauli.X || p == Pauli.Y)
				newRow.multiplyBy(stabilizers.elementAt(i));
		}
		return newRow.phase == 2;
	}
	
	// Partial trace. Only operates on the stabilizer rows, not the destabilizer rows, so incorrect results
	// will be produced if further operations are applied afterwards.
	// Something goes wrong if the result is a mixed state.
	public void applyPTrace(int q) {
		StabilizerArray.PTrace(q,stabilizers);
		nqubits = nqubits - 1;
	}
	
	// Methods for RREF
	
	// Find the number of different Pauli operators (X,Y,Z) in the given column of the given vector of stabilizer rows,
	// ignoring rows before minRow.
	public static int countPaulis(int col, int minRow, Vector<StabilizerRow> rows) {
		int numX = 0, numY = 0, numZ = 0;
		for (int i = minRow; i < rows.size(); i++) {
			switch (rows.elementAt(i).row.elementAt(col)) {
				case I: break;
				case X: numX = numX + ((numX==0)?1:0); break;
				case Y: numY = numY + ((numY==0)?1:0); break;
				case Z: numZ = numZ + ((numZ==0)?1:0); break;
			}
		}
		return numX + numY + numZ;
	}
	
	// Normalise the given column of the given vector of stabilizer rows, in place, ignoring rows before minRow. 
	// Return the number of non-I rows in the normalised column.
	public static int normaliseColumn(int col, int minRow, Vector<StabilizerRow> rows) {
		int numPaulis = StabilizerArray.countPaulis(col, minRow, rows);
		if (numPaulis == 0)
			return 0;
		
		else if (numPaulis == 1) {
			int k = minRow;
			while (rows.elementAt(k).row.elementAt(col) == Pauli.I)
				k++;
			// Swap row k to the top
			if (k != minRow) {
				StabilizerRow temp = rows.elementAt(minRow);
				rows.setElementAt(rows.elementAt(k), minRow);
				rows.setElementAt(temp, k);
			}
			for (int i = minRow+1; i < rows.size(); i++) {
				if (rows.elementAt(i).row.elementAt(col) != Pauli.I)
					rows.elementAt(i).multiplyBy(rows.elementAt(minRow));
			}
			return 1;
		}
		
		else {
			int k1 = minRow;
			while (rows.elementAt(k1).row.elementAt(col) == Pauli.I)
				k1++;
			Pauli sigma1 = rows.elementAt(k1).row.elementAt(col);
			int k2 = k1 + 1;
			while (rows.elementAt(k2).row.elementAt(col) == Pauli.I || rows.elementAt(k2).row.elementAt(col) == sigma1)
				k2++;
			Pauli sigma2 = rows.elementAt(k2).row.elementAt(col);
			// Swap row k1 to the top
			if (k1 != minRow) {
				StabilizerRow temp = rows.elementAt(minRow);
				rows.setElementAt(rows.elementAt(k1), minRow);
				rows.setElementAt(temp, k1);
			}
			// Swap row k2 to be next below the top
			if (k2 != minRow+1) {
				StabilizerRow temp = rows.elementAt(minRow+1);
				rows.setElementAt(rows.elementAt(k2), minRow+1);
				rows.setElementAt(temp, k2);
			}
			for (int i = minRow+2; i < rows.size(); i++) {
				Pauli sigma3 = rows.elementAt(i).row.elementAt(col);
				if (sigma3 == sigma1) {
					rows.elementAt(i).multiplyBy(rows.elementAt(minRow));
				}
				else if (sigma3 == sigma2) {
					rows.elementAt(i).multiplyBy(rows.elementAt(minRow+1));
				}
				else if (sigma3 != Pauli.I) {
					rows.elementAt(i).multiplyBy(rows.elementAt(minRow));
					rows.elementAt(i).multiplyBy(rows.elementAt(minRow+1));
				}
			}
			return 2;
		}
	}
	
	// Puts the given vector of stabilizer rows into RREF.
	public static void RREF(Vector<StabilizerRow> rows) {
		int k = rows.size();
		int n;
		int kU = 0; // Top row of active region
		int nL = 0; // Leftmost column of active region
		int columnLeaderSize;
		if (k == 0)
			n = 0;
		else
			n = rows.elementAt(0).row.size();
		while (kU < k && nL < n) {
			columnLeaderSize = StabilizerArray.normaliseColumn(nL,kU,rows);
			nL = nL + 1;
			kU = kU + columnLeaderSize;
		}
	}
	
	// Applies partial trace to the given vector of stabilizer rows.
	public static void PTrace(int col, Vector<StabilizerRow> rows) {
		int numCols;
		if (rows.size() == 0)
			numCols = 0;
		else
			numCols = rows.elementAt(0).length();
		int numNonI = StabilizerArray.normaliseColumn(col, 0, rows);
		for (int i = 0; i < numNonI; i++)
			rows.removeElementAt(0);
		if (rows.size() == 0)
			rows.addElement(new StabilizerRow(numCols));
		for (StabilizerRow r : rows)
			r.row.removeElementAt(col);
	}
	
	// Returns the number of identity rows in the vector of rows. Intended to be called when the vector of rows is 
	// in RREF, in order to calculate the rank.
	public static int numIrows(Vector<StabilizerRow> rows) {
		int n = 0;
		for (StabilizerRow r : rows)
			if (r.isIdentity())
				n++;
		return n;
	}
	
	// Is there a row of the form -I...I ?
	public static boolean minusIrow(Vector<StabilizerRow> rows) {
		for (StabilizerRow r : rows)
			if (r.isMinusIdentity())
				return true;
		return false;
	}
	
	public boolean equal(StabilizerArray s) {
		int n1 = stabilizers.size();
		Vector<StabilizerRow> a = new Vector<StabilizerRow>(n1);
		for (StabilizerRow row : stabilizers)
			a.addElement(row.copy());
		StabilizerArray.RREF(a);
		int rank1 = n1 - StabilizerArray.numIrows(a);
		int n2 = s.stabilizers.size();
		Vector<StabilizerRow> b = new Vector<StabilizerRow>(n2);
		for (StabilizerRow row : s.stabilizers)
			b.addElement(row.copy());
		StabilizerArray.RREF(b);
		int rank2 = n2 - StabilizerArray.numIrows(b);
		if (rank1 != rank2)
			return false;
		a.addAll(b);
		StabilizerArray.RREF(a);
		int rank3 = n1 + n2 - StabilizerArray.numIrows(a);
		return rank3 == rank1;
	}
	
	public static boolean equal(Vector<StabilizerRow> r, Vector<StabilizerRow> s) {
		int n1 = r.size();
		Vector<StabilizerRow> a = new Vector<StabilizerRow>(n1);
		for (StabilizerRow row : r)
			a.addElement(row.copy());
		StabilizerArray.RREF(a);
		int rank1 = n1 - StabilizerArray.numIrows(a);
		int n2 = s.size();
		Vector<StabilizerRow> b = new Vector<StabilizerRow>(n2);
		for (StabilizerRow row : s)
			b.addElement(row.copy());
		StabilizerArray.RREF(b);
		int rank2 = n2 - StabilizerArray.numIrows(b);
		if (rank1 != rank2)
			return false;
		a.addAll(b);
		StabilizerArray.RREF(a);
		int rank3 = n1 + n2 - numIrows(a);
		return rank3 == rank1;
	}
	
	// Inner product from Aaronson-Gottesman, implemented by Jessica
	public double innerProduct(StabilizerArray sa) {
		Vector<StabilizerRow> t = copy(this.stabilizers);
		int n = t.size();
		for (StabilizerRow row : sa.stabilizers)
			t.add(row);
		RREF(t);
		if (minusIrow(t))
			return 0;
		int rank = 2*n - numIrows(t);
		int s = rank - n;
		return Math.pow(Math.sqrt(2), -s); 
	}
	
	// In-place movement of column a to column b, assuming a > b.
	// Columns from b onwards are shifted to the right.
	public void move(int a, int b) {
		for (StabilizerRow s : stabilizers)
			s.move(a,b);
		for (StabilizerRow d : destabilizers)
			d.move(a,b);
	}
	
	public static Vector<StabilizerRow> copy(Vector<StabilizerRow> rows) {
		Vector<StabilizerRow> c = new Vector<StabilizerRow>(rows.size());
		for (StabilizerRow row : rows)
			c.addElement(row.copy());
		return c;
	}
	
	public String toString() {
		String s = "";
		for (StabilizerRow row : stabilizers)
			s = s + row.toString() + "\n";
		return s;
	}
	
	public static String toString(Vector<StabilizerRow> rows) {
		String s = "";
		for (StabilizerRow row : rows)
			s = s + row.toString() + "\n";
		return s;
	}
	
}
