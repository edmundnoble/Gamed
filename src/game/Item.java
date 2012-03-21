
package game;

import characters.Character;

public abstract class Item {

	private String name = "Default";

	private Character owner;

	private int cost = 0, weight = 0;

	public Item() {
		this("Default");
	}

	Item(String name) {
		this.name = name;
	}

	public Item(String name, int cost) {
		this(name);
		this.cost = cost;
	}

	public Item(String name, int cost, int weight) {
		this(name, cost);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public abstract void use(Character actor);

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCost() {
		return cost;
	}

	public String getName() {
		return name;
	}

	public boolean isOwned(Item i) {
		if (owner != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Character owner) {
		this.owner = owner;
	}
}
