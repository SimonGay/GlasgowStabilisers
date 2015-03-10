package equivalence;

public class SendAction extends Action {
	public String channel;
	public int value;
	
	public SendAction(String channel, int value) {
		this.channel = channel;
		this.value = value;
	}
}
