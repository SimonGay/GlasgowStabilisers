package equivalence;

public class ReceiveAction extends Action {
	public String channel;
	
	public ReceiveAction(String channel) {
		this.channel = channel;
	}
}
