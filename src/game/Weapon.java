
package game;

public class Weapon extends Item {

	private double damage;
	public static final Weapon FISTS = new Weapon("Fists", 1, 0);

	public Weapon(String name, int dmg, int cost) {
		super(name, cost);
		this.damage = dmg;
	}
}
