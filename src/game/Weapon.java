package game;

public class Weapon extends Item {
	private double damage;

	public Weapon(String name, int dmg, int cost) {
		super(name, cost);
		this.damage = dmg;
	}
}
