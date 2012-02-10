package game;

public class Item {

	private String name = "";
	private boolean owned;

	public Item() {

	}

	public Item(String name) {

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
