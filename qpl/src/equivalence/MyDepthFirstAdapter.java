package equivalence;

import equivalence.node.*;
import equivalence.analysis.*;
import stabilizer.*;

import java.util.*;

public class MyDepthFirstAdapter extends DepthFirstAdapter {
	
	private Hashtable<Node,SelectParameters> in;
	private Hashtable<Node,Object> data;
	private Hashtable<Node,Vector<Action>> out;
	public Hashtable<Node,Store> store;
	public StabilizerArray stab;
	
	public void defineIn(Hashtable<Node,SelectParameters> ht) {
		this.in = ht;
	}
	
	public void defineData(Hashtable<Node,Object> ht) {
		this.data = ht;
	}
	
	public void defineOut(Hashtable<Node,Vector<Action>> ht) {
		this.out = ht;
	}
	
	public void defineStore(Hashtable<Node,Store> ht) {
		this.store = ht;
	}
	
    public SelectParameters getIn(Node node)
    {
        return this.in.get(node);
    }

    public void setIn(Node node, SelectParameters o)
    {
        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }
    
    public Object getData(Node node)
    {
        return this.data.get(node);
    }

    public void setData(Node node, Object o)
    {
        if(o != null)
        {
            this.data.put(node, o);
        }
        else
        {
            this.data.remove(node);
        }
    }
    
    public Vector<Action> getOut(Node node)
    {
       return this.out.get(node);
    }

    public void setOut(Node node, Vector<Action> o)
    {
        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }
    
    public Store getStore(Node node) {
    	return this.store.get(node);
    }
    
    public void setStore(Node node, Store store) {
    	this.store.put(node,store);
    }
    
    public int getFromStore(Node node, String var)
    {
        return this.store.get(node).get(var);
    }

    public void setInStore(Node node, String var, int value)
    {
        this.store.get(node).set(var,value);
    }
    
    public void remove(Node node, String var) {
    	this.store.get(node).remove(var);
    }

}
