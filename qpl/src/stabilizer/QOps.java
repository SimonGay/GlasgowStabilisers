package stabilizer;

public class QOps {
	
	// Calculates a.b
	public static PhasedPauli multiply(Pauli a, Pauli b) {
		int phase = 0;
		Pauli op = Pauli.I;
		switch (a) {
			case I:
				phase = 0; op = b; break;
			case X:
				switch (b) {
					case I:
						phase = 0; op = Pauli.X; break;
					case X:
						phase = 0; op = Pauli.I; break;
					case Y:
						phase = 1; op = Pauli.Z; break;
					case Z:
						phase = 3; op = Pauli.Y; break;
				};
				break;
			case Y:
				switch (b) {
					case I:
						phase = 0; op = Pauli.Y; break;
					case X:
						phase = 3; op = Pauli.Z; break;
					case Y:
						phase = 0; op = Pauli.I; break;
					case Z:
						phase = 1; op = Pauli.X; break;
				};
				break;
			case Z:
				switch (b) {
					case I:
						phase = 0; op = Pauli.Z; break;
					case X:
						phase = 1; op = Pauli.Y; break;
					case Y:
						phase = 3; op = Pauli.X; break;
					case Z:
						phase = 0; op = Pauli.I; break;
				};
				break;
		}
		return new PhasedPauli(phase,op);
	}
	
	// Calculates a.b.inv(a). Remember inv(a) = a.
	public static SignedPauli conjugate(Pauli a, Pauli b) {
		PhasedPauli p1 = QOps.multiply(a, b);
		PhasedPauli p2 = QOps.multiply(p1.op, a);
		return new SignedPauli(1-(p1.phase+p2.phase)%4,p2.op);
	}
	
	// The next few methods calculate the effect of applying the operator specified in the method name, on an entry in a stabilizer row.
	public static SignedPauli applyX(Pauli a) {
		return QOps.conjugate(Pauli.X,a);
	}
	
	public static SignedPauli applyY(Pauli a) {
		return QOps.conjugate(Pauli.Y,a);
	}
	
	public static SignedPauli applyZ(Pauli a) {
		return QOps.conjugate(Pauli.Z,a);
	}
	
	public static SignedPauli applyH(Pauli a) {
		int phase = 0;
		Pauli op = Pauli.I;
		switch (a) {
			case I: break;
			case X: phase = 0; op = Pauli.Z; break;
			case Y: phase = 2; op = Pauli.Y; break;
			case Z: phase = 0; op = Pauli.X; break;
		}
		return new SignedPauli(1-phase,op);
	}
	
	public static SignedPauli applyP(Pauli a) {
		int phase = 0;
		Pauli op = Pauli.I;
		switch (a) {
			case I: break;
			case X: phase = 0; op = Pauli.Y; break;
			case Y: phase = 2; op = Pauli.X; break;
			case Z: phase = 0; op = Pauli.Z; break;
		}
		return new SignedPauli(1-phase,op);
	}
	
	public static SignedPauliPair applyCNOT(Pauli a, Pauli b) {
		int sign = 1;
		Pauli p1 = Pauli.I;
		Pauli p2 = Pauli.I;
		switch (a) {
			case I: 
				if (b == Pauli.Y || b == Pauli.Z)
					p1 = Pauli.Z;
				p2 = b; 
				break;
			case X:
				switch (b) {
					case I: p1 = Pauli.X; p2 = Pauli.X; break;
					case X: p1 = Pauli.X; p2 = Pauli.I; break;
					case Y: p1 = Pauli.Y; p2 = Pauli.Z; break;
					case Z: p1 = Pauli.Y; p2 = Pauli.Y; sign = -1; break;
				};
				break;
			case Y:
				switch (b) {
					case I: p1 = Pauli.Y; p2 = Pauli.X; break;
					case X: p1 = Pauli.Y; p2 = Pauli.I; break;
					case Y: p1 = Pauli.X; p2 = Pauli.Z; sign = -1; break;
					case Z: p1 = Pauli.X; p2 = Pauli.Y; break;
				};
				break;
			case Z:
				if (b == Pauli.I || b == Pauli.X)
					p1 = Pauli.Z;
				p2 = b; 
				break;
		}
		return new SignedPauliPair(sign,p1,p2);
	}
	
}
