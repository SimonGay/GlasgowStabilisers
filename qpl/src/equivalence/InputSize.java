package equivalence;

import equivalence.analysis.*;
import equivalence.node.*;

public class InputSize extends DepthFirstAdapter {
	public void outStart(Start node)
    {
        setOut(node,getOut(node.getPProcess()));
    }
	
	public void outATermProcess(ATermProcess node)
    {
		setOut(node,getOut(node.getTerm()));
    }
	
	public void outAParallelProcess(AParallelProcess node)
    {
        Object l = getOut(node.getLeft());
        if (l != null)
        	setOut(node,l);
        else
        	setOut(node,getOut(node.getRight()));
    }
	
	public void outAInputTerm(AInputTerm node)
    {
        setOut(node,getOut(node.getIdlist()));
    }
	
	public void outAParensTerm(AParensTerm node)
    {
        setOut(node,getOut(node.getProcess()));
    }
	
	public void outAIdIdlist(AIdIdlist node)
    {
        setOut(node,1);
    }

    public void outAIdconsIdlist(AIdconsIdlist node)
    {
        setOut(node,1+(Integer)getOut(node.getIdlist()));
    }
}
