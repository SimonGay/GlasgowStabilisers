package equivalence;

import equivalence.node.*;
import equivalence.analysis.*;

public class Reset extends MyDepthFirstAdapter {
	public void outASendTerm(ASendTerm node)
    {
        this.setData(node,new PrefixData(0));
    }
	
	public void outAReceiveTerm(AReceiveTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAMeasureTerm(AMeasureTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAXTerm(AXTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAYTerm(AYTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAZTerm(AZTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAHTerm(AHTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outACnotTerm(ACnotTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAIfxTerm(AIfxTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAIfyTerm(AIfyTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAIfzTerm(AIfzTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outANewTerm(ANewTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAInputTerm(AInputTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAOutputTerm(AOutputTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
	
	public void outAPrintTerm(APrintTerm node)
    {
		this.setData(node,new PrefixData(0));
    }
}
