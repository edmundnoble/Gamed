package game;

import characters.Actor;

public class Item {

	private String name = "Default";

	private Actor owner;

	private int cost;

	public Item() {
		this("Default");
	}

	public Item(String name) {
		this(name, 0);
	}

	public Item(String name, int cost) {
		this.name = name;
		this.setCost(cost);
	}

	public String getName() {
		return name;
	}

	public boolean isOwned(Item i) {
		if (owner != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Actor owner) {
		this.owner = owner;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
