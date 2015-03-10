package equivalence;

import equivalence.analysis.*;
import equivalence.lexer.*;
import equivalence.node.*;
import equivalence.parser.*;
import stabilizer.*;

import java.io.*;

public class Main {

	public static void main(String[] args) { 
		if (args.length > 0) { 
			try { 
				String file1 = args[0];
				String file2 = args[1];
				Lexer lexer = new Lexer (new PushbackReader(new FileReader(file1), 1024)); 
				Parser parser = new Parser(lexer); 
				Start ast1 = parser.parse();
				System.out.println("Successful parse: " + file1);
				lexer = new Lexer (new PushbackReader(new FileReader(file2), 1024)); 
				parser = new Parser(lexer); 
				Start ast2 = parser.parse();
				System.out.println("Successful parse: " + file2);
				Scheduler scheduler1 = new Scheduler(ast1);
				Scheduler scheduler2 = new Scheduler(ast2);
				InputSize is = new InputSize();
				ast1.apply(is);
				int qubits = (Integer)is.getOut(ast1);
				System.out.println("Number of input qubits: " + qubits);
				boolean equal = true;
				int runs1 = 0;
				int runs2 = 0;
				for (StabilizerArray stab : new Basis(qubits)) {
					StabilizerArray output1 = scheduler1.output(stab);
					runs1 = runs1 + scheduler1.runs;
					if (output1 == null) {
						System.out.println(file1 + " is non-deterministic on the following input.");
						System.out.println(stab);
						equal = false;
					}
					else {
						StabilizerArray output2 = scheduler2.output(stab);
						runs2 = runs2 + scheduler2.runs;
						if (output2 == null) {
							System.out.println(file2 + " is non-deterministic on the following input.");
							System.out.println(stab);
							equal = false;
						}
						else {
							if (!output1.equal(output2)) {
								System.out.println("On input");
								System.out.println(stab);
								System.out.println(file1 + " produces output");
								System.out.println(output1);
								System.out.println("and " + file2 + "produces output");
								System.out.println(output2);
								equal = false;
							}
						}
					}
				}
				if (equal)
					System.out.println(file1 + " and " + file2 + " are equivalent.");
				else
					System.out.println(file1 + " and " + file2 + " are not equivalent.");
				System.out.println("" + runs1 + " runs on " + file1);
				System.out.println("" + runs2 + " runs on " + file2);
			}
			catch (Exception e) { 
				System.out.println (e) ; 
			} 
		} else { 
			System.err.println("usage: check file1 file2"); 
			System.exit(1); 
		} 
	} 

}
