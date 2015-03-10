package stabilizer;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		int n = 3;
		
		/*
		StabilizerArray a = new StabilizerArray(2);
		a.applyH(0);
		a.applyCNOT(0, 1);
		System.out.println(a);
		*/
		
		/*
		StabilizerArray a = new StabilizerArray(3);
		StabilizerArray b = new StabilizerArray(3);
		a.applyH(0);
		a.applyH(1);
		//b.applyZ(0);
		//b.applyX(1);
		//b.applyX(2);
		System.out.println("Inner product = " + a.innerProduct(b));
		*/
		
		
		/*
		for (StabilizerArray s : new Basis(n))
			for (StabilizerArray t : new Basis(n)) {
				if (!s.equal(t)) {
					if (s.toString().equalsIgnoreCase(t.toString())) {
						System.out.println("ERROR:");
						System.out.println("Equal states:");
						System.out.println("First state:");
						System.out.println(s);
						System.out.println("Second state:");
						System.out.println(t);
					}
				}
			}
		*/
		
		/*
		Vector<Boolean> b = new Vector<Boolean>(n*2);
		for (int i = 0; i < n*2; i++)
			b.addElement(false);
		for (int i = 0; i < StabilizerArray.power2(n*2); i++) {
			System.out.println(new StabilizerArray(n,b));
			b = StabilizerArray.inc(b);
		}
		*/
		
		/*
		StabilizerArray a = new StabilizerArray(5);
		a.applyH(0);
		a.applyCNOT(0,1);
		a.applyCNOT(0,2);
		a.applyCNOT(0,3);
		a.applyCNOT(0,4);
		System.out.println(a);
		*/
		
		
		MapState a = MapState.identity(2);
		MapState cnot = MapState.CNOT();
		MapState b = MapState.identity(2);
		a.composeX(0);
		b.composeXnew(0);
		
		
		
		System.out.println(a);
		
		System.out.println(b);
		
		System.out.println(MapState.equal(a, b));
		
		
		/*
		StabilizerArray a = new StabilizerArray(2);
		a.applyH(0);
		a.applyCNOT(0,1);
		System.out.println(a);
		if (a.measurementIsRandom(0)) {
			System.out.println("Measurement of 0 is random.");
			System.out.println("Choosing 0.");
			a.chooseMeasurementResult(0,0);
		}
		else {
			System.out.println("Measurement of 0 is deterministic: "+a.findMeasurementResult(0));
		}
		
		if (a.measurementIsRandom(1)) {
			System.out.println("Measurement of 1 is random.");
			System.out.println("Choosing 0.");
			a.chooseMeasurementResult(1,0);
		}
		else {
			System.out.println("Measurement of 1 is deterministic: "+a.findMeasurementResult(1));
		}
		*/
	}

}
