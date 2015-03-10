package stabilizer;

import java.util.Vector;

// Represents a unitary operator as a stabilizer array, using map-state duality.
public class MapState {
	public int n; // The number of inputs and outputs.
	public Vector<StabilizerRow> stabilizers; // A stabilizer array for 2n qubits. Input/output m correspond to qubits 2m and 2m+1.
	
	// Constructs a map-state representation with given size and stabilizer rows.
	public MapState(int n, Vector<StabilizerRow> s) {
		this.n = n;
		this.stabilizers = s;
	}
	
	public static MapState basis0() {
		StabilizerRow row = new StabilizerRow(1);
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(1);
		row.setQbit(0,new SignedPauli(1,Pauli.Z));
		return new MapState(1,stabilizers);
	}
	
	/* Constructs the map-state representation of the identity operator on n qubits.
	 * 
	 * To illustrate the construction with the identity operator on 2 qubits:
	 * The matrix is
	 * 
	 * ( 1 0 0 0 )
	 * ( 0 1 0 0 )
	 * ( 0 0 1 0 )
	 * ( 0 0 0 1 )
	 * 
	 * which in outer product form is
	 * 
	 * |00><00| + |01><01| + |10><10| + |11><11|
	 * 
	 * so the map-state representation is (applying a permutation)
	 * 
	 * |0000> + |0011> + |1100> + |1111>
	 * 
	 * which has stabilizer generators
	 * 
	 * ZZII and IIZZ and XXII and IIXX
	 * 
	 */
	public static MapState identity(int n) {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(n*2);
		for (int i = 0; i < n; i++) {
			row = new StabilizerRow(n*2);
			row.setQbit(i*2,new SignedPauli(1,Pauli.Z));
			row.setQbit(i*2+1,new SignedPauli(1,Pauli.Z));
			stabilizers.addElement(row);
			row = new StabilizerRow(n*2);
			row.setQbit(i*2,new SignedPauli(1,Pauli.X));
			row.setQbit(i*2+1,new SignedPauli(1,Pauli.X));
			stabilizers.addElement(row);
		}
		return new MapState(n,stabilizers);
	}
	
	/*
	 * The matrix for the Pauli X operator is
	 * 
	 * ( 0 1 )
	 * ( 1 0 )
	 * 
	 * which in outer product form is
	 * 
	 * |0><1| + |1><0|
	 * 
	 * so the map-state representation is
	 * 
	 * |01> + |10>
	 * 
	 * which has stabilizer generators
	 * 
	 * XX and -ZZ
	 * 
	 */
	public static MapState PauliX() {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(2);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.X));
		row.setQbit(1,new SignedPauli(1,Pauli.X));
		stabilizers.addElement(row);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.Z));
		row.setQbit(1,new SignedPauli(-1,Pauli.Z));
		stabilizers.addElement(row);
		return new MapState(1,stabilizers);
	}
	
	/*
	 * The matrix for the Pauli Y operator is
	 * 
	 * ( 0 -i )
	 * ( i  0 )
	 * 
	 * which in outer product form is
	 * 
	 * -i|0><1| + i|1><0|
	 * 
	 * so the map-state representation is
	 * 
	 * i|01> - i|10>
	 * 
	 * which has stabilizer generators
	 * 
	 * -XX and -ZZ
	 * 
	 */
	public static MapState PauliY() {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(2);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.X));
		row.setQbit(1,new SignedPauli(-1,Pauli.X));
		stabilizers.addElement(row);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.Z));
		row.setQbit(1,new SignedPauli(-1,Pauli.Z));
		stabilizers.addElement(row);
		return new MapState(1,stabilizers);
	}
	
	/*
	 * The matrix for the Pauli Z operator is
	 * 
	 * ( 1 0 )
	 * ( 0 -1 )
	 * 
	 * which in outer product form is
	 * 
	 * |0><0| - |1><1|
	 * 
	 * so the map-state representation is
	 * 
	 * |00> - |11>
	 * 
	 * which has stabilizer generators
	 * 
	 * -XX and YY
	 * 
	 */
	public static MapState PauliZ() {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(2);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.X));
		row.setQbit(1,new SignedPauli(-1,Pauli.X));
		stabilizers.addElement(row);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.Y));
		row.setQbit(1,new SignedPauli(1,Pauli.Y));
		stabilizers.addElement(row);
		return new MapState(1,stabilizers);
	}
	
	/*
	 * The matrix for the phase operator is
	 * 
	 * ( 1 0 )
	 * ( 0 i )
	 * 
	 * which in outer product form is
	 * 
	 * |0><0| + i|1><1|
	 * 
	 * so the map-state representation is
	 * 
	 * |00> + i|11>
	 * 
	 * which has stabilizer generators
	 * 
	 * XY and YX
	 * 
	 */
	public static MapState Phase() {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(2);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.X));
		row.setQbit(1,new SignedPauli(1,Pauli.Y));
		stabilizers.addElement(row);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.Y));
		row.setQbit(1,new SignedPauli(1,Pauli.X));
		stabilizers.addElement(row);
		return new MapState(1,stabilizers);
	}
	
	/*
	 * The matrix for the Hadamard operator is
	 * 
	 * ( 1  1 )
	 * ( 1 -1 )
	 * 
	 * which in outer product form is
	 * 
	 * |0><0| + |0><1| + |1><0| - |1><1|
	 * 
	 * so the map-state representation is
	 * 
	 * |00> + |01> + |10> - |11>
	 * 
	 * which has stabilizer generators
	 * 
	 * XZ and ZX
	 * 
	 */
	public static MapState Hadamard() {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(2);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.X));
		row.setQbit(1,new SignedPauli(1,Pauli.Z));
		stabilizers.addElement(row);
		row = new StabilizerRow(2);
		row.setQbit(0,new SignedPauli(1,Pauli.Z));
		row.setQbit(1,new SignedPauli(1,Pauli.X));
		stabilizers.addElement(row);
		return new MapState(1,stabilizers);
	}
	
	/*
	 * The matrix for the CNOT operator is
	 * 
	 * ( 1 0 0 0 )
	 * ( 0 1 0 0 )
	 * ( 0 0 0 1 )
	 * ( 0 0 1 0 )
	 * 
	 * which in outer product form is
	 * 
	 * |00><00| + |01><01| + |11><10| + |10><11|
	 * 
	 * so the map-state representation is (applying a permutation)
	 * 
	 * |0000> + |0011> + |1101> + |1110>
	 * 
	 * which has stabilizer generators
	 * 
	 * XXIX and IIXX and ZZII and ZIZZ
	 * 
	 */
	public static MapState CNOT() {
		StabilizerRow row;
		Vector<StabilizerRow> stabilizers = new Vector<StabilizerRow>(4);
		row = new StabilizerRow(4);
		row.setQbit(0,new SignedPauli(1,Pauli.X));
		row.setQbit(1,new SignedPauli(1,Pauli.X));
		row.setQbit(3,new SignedPauli(1,Pauli.X));
		stabilizers.addElement(row);
		row = new StabilizerRow(4);
		row.setQbit(2,new SignedPauli(1,Pauli.X));
		row.setQbit(3,new SignedPauli(1,Pauli.X));
		stabilizers.addElement(row);
		row = new StabilizerRow(4);
		row.setQbit(0,new SignedPauli(1,Pauli.Z));
		row.setQbit(1,new SignedPauli(1,Pauli.Z));
		stabilizers.addElement(row);
		row = new StabilizerRow(4);
		row.setQbit(0,new SignedPauli(1,Pauli.Z));
		row.setQbit(2,new SignedPauli(1,Pauli.Z));
		row.setQbit(3,new SignedPauli(1,Pauli.Z));
		stabilizers.addElement(row);
		return new MapState(2,stabilizers);
	}
	
	// In-place tensor with st
	// Time is O(n*st.n + st.n^2)
	public void tensor(MapState st) {
		int stSize = st.n;
		// Add columns to the right of each stabilizer generator
		for (StabilizerRow r : stabilizers)
			for (int i = 0; i < stSize*2; i++)
				r.row.addElement(Pauli.I);
		StabilizerRow r;
		// Add stabilizer generators
		for (int i = 0; i < stSize*2; i++) {
			r = new StabilizerRow(n*2); // This gives a row filled with I
			// Now copy the operators from a row of st, extending the new row r
			for (Pauli p : st.stabilizers.elementAt(i).row)
				r.row.addElement(p);
			r.phase = st.stabilizers.elementAt(i).phase;
			stabilizers.addElement(r);
		}
		n = n + stSize;
	}
	
	// Does measurement of qubit q have a random result?
	// Time is O(n)
	public boolean measurementIsRandom(int q) {
		for (StabilizerRow row : stabilizers)
			if (row.row.elementAt(q) == Pauli.X || row.row.elementAt(q) == Pauli.Y)
				return true;
		return false;
	}
	
	// Choose the result r of a random measurement of qubit q.
	// First we must use measurementIsRandom to establish that the result is random.
	// Time is O(n^2)
	public void chooseMeasurementResult(int q, int r) {
		int p = 0;
		while (stabilizers.elementAt(p).row.elementAt(q) == Pauli.I || stabilizers.elementAt(p).row.elementAt(q) == Pauli.Z)
			p++;
		for (int i = 0; i < stabilizers.size(); i++)
			if (i != p && (stabilizers.elementAt(i).row.elementAt(q) == Pauli.X || stabilizers.elementAt(i).row.elementAt(q) == Pauli.Y))
				stabilizers.elementAt(i).multiplyBy(stabilizers.elementAt(p));
		StabilizerRow newRow = new StabilizerRow(stabilizers.elementAt(p).row.size());
		newRow.setQbit(q,new SignedPauli(1-2*r,Pauli.Z));
		stabilizers.setElementAt(newRow,p);
	}
	
	// In-place cut between columns a and b
	// Time is O(n^2) because of the use of chooseMeasurementResult
	public void cut(int a, int b) {
		//System.out.println("Before cut");
		//System.out.println(this);
		// Apply CNOT(a,b)
		for (StabilizerRow r : stabilizers)
			r.applyCNOT(a, b);
		// Apply H(a)
		for (StabilizerRow r : stabilizers)
			r.applyH(a);
		//System.out.println("After basis change");
		//System.out.println(this);
		// If measurement of a is random, set the result to 0
		if (this.measurementIsRandom(a))
			this.chooseMeasurementResult(a,0);
		// If measurement of b is random, set the result to 0
		if (this.measurementIsRandom(b))
			this.chooseMeasurementResult(b,0);
		// If the cut is between an output of one unitary and an input of another unitary, then the measurement results will always be random.
		// This is because both the input and the output must have the possibility of either |0> or |1>.
		//System.out.println("After projection");
		//System.out.println(this);
		// Trace out a and b
		if (a < b) {
			StabilizerArray.PTrace(b,stabilizers);
			StabilizerArray.PTrace(a,stabilizers);
		}
		else {
			StabilizerArray.PTrace(a,stabilizers);
			StabilizerArray.PTrace(b,stabilizers);
		}
		//System.out.println("After partial trace");
		//System.out.println(this);
		n = n - 1;
	}
	
	// In-place column movement of column a to column position b
	public void move(int a, int b) {
		for (StabilizerRow r : stabilizers)
			r.move(a,b);
	}
	
	// In-place post-composition with the Clifford operators on specified qubits.
	
	/*
	public void composeX(int q) {
		int a = q*2+1; // The output column for qubit q
		int b = n*2; // The input column for the operator
		this.tensor(MapState.PauliX()); // Input is column b, output is column b+1
		this.cut(a,b); // Columns a and b disappear, output is now column b-1
		this.move(b-1,a);
	}
	*/
	
	public void composeX(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyX(q);
	}
	
	/*
	public void composeY(int q) {
		int a = q*2+1; // The output column for qubit q
		int b = n*2; // The input column for the operator
		this.tensor(MapState.PauliY());
		this.cut(a,b);
		this.move(b-1,a);
	}
	*/

	public void composeY(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyY(q);
	}
	
	/*
	public void composeZ(int q) {
		int a = q*2+1; // The output column for qubit q
		int b = n*2; // The input column for the operator
		this.tensor(MapState.PauliZ());
		this.cut(a,b);
		this.move(b-1,a);
	}
	*/

	public void composeZ(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyZ(q);
	}
	
	/*
	public void composeH(int q) {
		int a = q*2+1; // The output column for qubit q
		int b = n*2; // The input column for the operator
		this.tensor(MapState.Hadamard());
		this.cut(a,b);
		this.move(b-1,a);
	}
	*/
	
	public void composeH(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyH(q);
	}
	
	/*
	public void composeP(int q) {
		int a = q*2+1; // The output column for qubit q
		int b = n*2; // The input column for the operator
		this.tensor(MapState.Phase());
		this.cut(a,b);
		this.move(b-1,a);
	}
	*/
	
	public void composeP(int q) {
		for (StabilizerRow row : stabilizers)
			row.applyP(q);
	}
	
	/*
	public void composeCNOT(int p, int q) {
		int pOut = p*2+1; // The output column for qubit p
		int qOut = q*2+1; // The output column for qubit q
		int cIn  = n*2;   // The input column for the control
		int cOut = n*2+1; // The output column for the control
		int tIn  = n*2+2; // The input column for the target
		int tOut = n*2+3; // The output column for the target
		//System.out.println("Before starting to compose with CNOT");
		//System.out.println(this);
		this.tensor(MapState.CNOT());
		if (p < q) {
			this.cut(qOut, tIn);
			cIn--;   // Because qOut disappears and it was to the left of cIn 
			cOut--;  // Because qOut disappears and it was to the left of cOut
			tOut-=2; // Because qOut and tIn disappear, both to the left of tOut
			this.cut(pOut, cIn);
			cOut-=2; // Because pOut and cIn disappear, both to the left of cOut
			tOut-=2; // Because pOut and cIn disappear, both to the left of tOut
			//System.out.println("After cuts");
			//System.out.println(this);
			this.move(cOut, pOut);
			//System.out.println("After first move");
			//System.out.println(this);
			this.move(tOut, qOut);
			//System.out.println("After second move");
			//System.out.println(this);
		}
		else {
			this.cut(pOut, tIn);
			cIn--; cOut--; tOut-=2;
			this.cut(qOut, cIn);
			cOut-=2; tOut-=2;
			this.move(cOut, qOut);
			cOut++;
			this.move(tOut, pOut);
		}
	}
	*/
	
	public void composeCNOT(int p, int q) {
		for (StabilizerRow row : stabilizers)
			row.applyCNOT(p,q);
	}
	
	// Equality test
	public static boolean equal(MapState s, MapState t) {
		return StabilizerArray.equal(s.stabilizers, t.stabilizers);
	}
	
	public String toString() {
		String s = "";
		for (StabilizerRow row : stabilizers)
			s = s + row.toString() + "\n";
		return s;
	}
}
