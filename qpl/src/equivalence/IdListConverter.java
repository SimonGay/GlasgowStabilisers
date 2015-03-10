package equivalence;

import java.util.Vector;
import equivalence.analysis.*;
import equivalence.node.*;

public class IdListConverter extends DepthFirstAdapter {
	public void outAIdIdlist(AIdIdlist node)
    {
		Vector<String> v = new Vector<String>();
		v.addElement(node.getId().getText());
        setOut(node,v);
    }

    public void outAIdconsIdlist(AIdconsIdlist node)
    {
    	Vector<String> v = (Vector<String>)getOut(node.getIdlist());
    	v.add(0,node.getId().getText());
        setOut(node,v);
    }
}
