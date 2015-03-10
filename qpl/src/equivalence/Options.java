package equivalence;

import equivalence.node.*;

import java.util.Vector;

public class Options extends MyDepthFirstAdapter {
	
	public void caseANilTerm(ANilTerm node)
    {
        this.setOut(node,new Vector<Action>());
    }
	
	public void caseASendTerm(ASendTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new SendAction(node.getChannel().getText(),this.getFromStore(node,node.getData().getText())));
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAReceiveTerm(AReceiveTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new ReceiveAction(node.getChannel().getText()));
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAMeasureTerm(AMeasureTerm node)
    {
		PrefixData pd = (PrefixData)this.getData(node);
		if (pd.state == 0) {
			Vector<Action> a = new Vector<Action>();
			int qubit = this.getFromStore(node,node.getSource().getText());
			a.addElement(new TauAction());
			boolean random = stab.measurementIsRandom(qubit);
			pd.random = random;
			if (random) {
				a.addElement(new TauAction());
			}
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAXTerm(AXTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAYTerm(AYTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAZTerm(AZTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAHTerm(AHTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseACnotTerm(ACnotTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAIfxTerm(AIfxTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAIfyTerm(AIfyTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAIfzTerm(AIfzTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseANewTerm(ANewTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAInputTerm(AInputTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAOutputTerm(AOutputTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAPrintTerm(APrintTerm node)
    {
		if (((PrefixData)this.getData(node)).state == 0) {
			Vector<Action> a = new Vector<Action>();
			a.addElement(new TauAction());
			this.setOut(node,a);
		}
		else {
			node.getTerm().apply(this);
			this.setOut(node,this.getOut(node.getTerm()));
		}
    }
	
	public void caseAParensTerm(AParensTerm node)
    {
		if (this.getStore(node.getProcess()) == null)
			this.setStore(node.getProcess(),this.getStore(node));
		node.getProcess().apply(this);
		this.setOut(node,this.getOut(node.getProcess()));
    }
	
	public void caseATermProcess(ATermProcess node)
    {
		if (this.getStore(node.getTerm()) == null)
			this.setStore(node.getTerm(),this.getStore(node));
		node.getTerm().apply(this);
		this.setOut(node,this.getOut(node.getTerm()));
    }
	
	public void caseStart(Start node)
    {
		if (this.getStore(node.getPProcess()) == null)
			this.setStore(node.getPProcess(),this.getStore(node));
		node.getPProcess().apply(this);
		Vector<Action> options = this.getOut(node.getPProcess());
		Vector<Integer> processOpts = new Vector<Integer>();
		Vector<Action> opts = new Vector<Action>();
		
		for (int i = 0; i < options.size(); i++) {
			if (options.elementAt(i) instanceof TauAction) {
				processOpts.addElement(i);
				opts.addElement(new TauAction());
			}
		}
		this.setData(node,new StartData(processOpts));
		this.setOut(node,opts);
    }
	
	public void caseAParallelProcess(AParallelProcess node)
    {
		if (this.getStore(node.getLeft()) == null)
			this.setStore(node.getLeft(),this.getStore(node).copy());
		node.getLeft().apply(this);
		if (this.getStore(node.getRight()) == null)
			this.setStore(node.getRight(),this.getStore(node).copy());
		node.getRight().apply(this);
		Vector<Action> leftOptions = this.getOut(node.getLeft());
		Vector<Action> rightOptions = this.getOut(node.getRight());
		Vector<CommData> commOpts = new Vector<CommData>();
		
		for (int i = 0; i < leftOptions.size(); i++)
			for (int j = 0; j < rightOptions.size(); j++) {
				Action li = leftOptions.elementAt(i);
				Action rj = rightOptions.elementAt(j);
				if (li instanceof SendAction && rj instanceof ReceiveAction && ((SendAction)li).channel.compareTo(((ReceiveAction)rj).channel) == 0)
					commOpts.addElement(new CommData(i,j,((SendAction)li).value));
				else if (li instanceof ReceiveAction && rj instanceof SendAction && ((ReceiveAction)li).channel.compareTo(((SendAction)rj).channel) == 0)
					commOpts.addElement(new CommData(i,j,((SendAction)rj).value));
			}
				
		this.setData(node,new ParallelData(leftOptions,rightOptions,commOpts));
		
		Vector<Action> opts = new Vector<Action>();
		opts.addAll(leftOptions);
		opts.addAll(rightOptions);
		for (CommData cd : commOpts)
			opts.addElement(new TauAction());
		this.setOut(node,opts);
    }
}
