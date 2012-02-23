package characters;

public class ActorValue {

	private int value;

	private String name;

	public ActorValue(String name, int value) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
