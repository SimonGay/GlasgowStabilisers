package stabilizer;

public class Action {
	public String name;
	public boolean complement;
	
	public Action(String n, boolean c) {
		name = n;
		complement = c;
	}
	
	public String toString() {
		String s = name;
		if (complement)
			s = s + "'";
		return s;
	}
}
