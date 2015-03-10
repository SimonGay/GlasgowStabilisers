package equivalence;

import equivalence.node.*;

import java.util.Vector;

public class Select extends MyDepthFirstAdapter {
	
	public void caseASendTerm(ASendTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAReceiveTerm(AReceiveTerm node)
    {
		SelectParameters sp = this.getIn(node);
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			this.setInStore(node,node.getData().getText(),sp.value);
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAMeasureTerm(AMeasureTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		int n = this.getIn(node).n; // The index of the action being selected.
		int qubit = this.getFromStore(node,node.getSource().getText());
		if (pd.state == 0) {
			pd.state = 1;
			if (pd.random) {
				stab.chooseMeasurementResult(qubit,n);
				this.setInStore(node,node.getTarget().getText(),n);
			}
			else {
				boolean result = stab.findMeasurementResult(qubit);
				this.setInStore(node,node.getTarget().getText(),result?1:0);
			}
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAXTerm(AXTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			stab.applyX(this.getFromStore(node,node.getId().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAYTerm(AYTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			stab.applyY(this.getFromStore(node,node.getId().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAZTerm(AZTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			stab.applyZ(this.getFromStore(node,node.getId().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAHTerm(AHTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			stab.applyH(this.getFromStore(node,node.getId().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseACnotTerm(ACnotTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			stab.applyCNOT(this.getFromStore(node,node.getFst().getText()),this.getFromStore(node,node.getSnd().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAIfxTerm(AIfxTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			if (this.getFromStore(node,node.getCond().getText()) == 1)
				stab.applyX(this.getFromStore(node,node.getTarget().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAIfyTerm(AIfyTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			if (this.getFromStore(node,node.getCond().getText()) == 1)
				stab.applyY(this.getFromStore(node,node.getTarget().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAIfzTerm(AIfzTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			if (this.getFromStore(node,node.getCond().getText()) == 1)
				stab.applyZ(this.getFromStore(node,node.getTarget().getText()));
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseANewTerm(ANewTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			int index = stab.allocate();
			//System.out.println("Array is now:");
			//System.out.println(stab);
			this.setInStore(node,node.getId().getText(),index);
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAInputTerm(AInputTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			IdListConverter ilc = new IdListConverter();
			PIdlist idlist = node.getIdlist();
			idlist.apply(ilc);
			Vector<String> ids = (Vector<String>)ilc.getOut(idlist);
			for (int i = 0; i < ids.size(); i++)
				this.setInStore(node,ids.elementAt(i),i);
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	// Tracing out the non-output qubits will break the mapping from variable names to qubit numbers.
	public void caseAOutputTerm(AOutputTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			IdListConverter ilc = new IdListConverter();
			PIdlist idlist = node.getIdlist();
			idlist.apply(ilc);
			Vector<String> ids = (Vector<String>)ilc.getOut(idlist);
			// Need to move the output qubits into the first columns, then trace out the rest.
			for (int i = 0; i < ids.size(); i++) {
				int col = this.getFromStore(node,ids.elementAt(i));
				if (col > i) {
					//System.out.println("Moving column " + col + " to " + i);
					stab.move(col,i);
					for (int j = i+1; j < ids.size(); j++)
						if (this.getFromStore(node,ids.elementAt(j)) < col)
							this.setInStore(node,ids.elementAt(j),this.getFromStore(node,ids.elementAt(j))+1);
				}
			}
			
			int lastQubit = ids.size();
			int nqubits = stab.nqubits;
			int traced = 0;
			for (int i = 0; i < nqubits - lastQubit; i++) {
				stab.applyPTrace(lastQubit);
				traced++;
			}
			
			//System.out.println("Traced out " + traced + " qubits.");
			//System.out.println(stab);
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }

	public void caseAPrintTerm(APrintTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			pd.state = 1;
			String var = node.getId().getText();
			int val = this.getFromStore(node,var);
			System.out.println(var + " = " + val);
			if (this.getStore(node.getTerm()) == null)
				this.setStore(node.getTerm(),this.getStore(node));
		}
		else {
			this.setIn(node.getTerm(),this.getIn(node));
			node.getTerm().apply(this);
		}
    }
	
	public void caseAParensTerm(AParensTerm node)
    {
		this.setIn(node.getProcess(),this.getIn(node));
		this.setStore(node.getProcess(),this.getStore(node));
		node.getProcess().apply(this);
    }
	
	public void caseATermProcess(ATermProcess node)
    {
		this.setIn(node.getTerm(),this.getIn(node));
		this.setStore(node.getTerm(),this.getStore(node));
		node.getTerm().apply(this);
    }
	
	public void caseStart(Start node)
    {
		StartData sd = (StartData)this.getData(node);
		SelectParameters sp = this.getIn(node);
		this.setIn(node.getPProcess(),new SelectParameters(sd.processOpts.elementAt(sp.n),sp.value));
		node.getPProcess().apply(this);
    }
	
	public void caseAParallelProcess(AParallelProcess node)
    {
		SelectParameters sp = this.getIn(node);
		ParallelData pd = (ParallelData)this.getData(node);
 
		if (sp.n < pd.leftOpts.size()) {
			this.setIn(node.getLeft(),sp);
			node.getLeft().apply(this);
		}
		else if (sp.n < pd.leftOpts.size() + pd.rightOpts.size()) {
			this.setIn(node.getRight(),new SelectParameters(sp.n-pd.leftOpts.size(),sp.value));
			node.getRight().apply(this);
		}
		else {
			CommData cd = pd.commOpts.elementAt(sp.n - pd.leftOpts.size() - pd.rightOpts.size());
			this.setIn(node.getLeft(),new SelectParameters(cd.leftIndex,cd.value));
			node.getLeft().apply(this);
			this.setIn(node.getRight(),new SelectParameters(cd.rightIndex,cd.value));
			node.getRight().apply(this);
		}
    }
}
