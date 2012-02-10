package game;

public class Item {

	private String name = "Default";

	private boolean owned;

	private int cost;

	public Item() {
		this("Default");
	}

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isOwned(Item i) {
		return owned;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}
}
