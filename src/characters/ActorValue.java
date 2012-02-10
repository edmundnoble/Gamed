package characters;

public class ActorValue {

	public ActorValue(String name, int value) {
		this.value = value;
		this.name = name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	private int value;
	private String name;
}
