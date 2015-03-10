package equivalence;

import java.util.Hashtable;

public class Store {
	public Hashtable<String,Integer> store;
	
	public Store() {
		store = new Hashtable<String,Integer>();
	}
	
	public Store(Hashtable<String,Integer> store) {
		this.store = store;
	}
	
	public void defineStore(Hashtable<String,Integer> store) {
		this.store = store;
	}
	
    public int get(String var) {
        return this.store.get(var);
    }

    public void set(String var, int value) {
        this.store.put(var, value);
    }

	public void remove(String var) {
		this.store.remove(var);
	}
	
	public Store copy() {
		return new Store(new Hashtable<String,Integer>(this.store));
	}

}
