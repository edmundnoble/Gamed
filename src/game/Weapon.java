
package game;

import characters.Actor;

public class Weapon extends Item {

	private double damage;
	public static final Weapon FISTS = new Weapon("Fists", 1, 0,
			WeaponType.MELEE);

	public enum WeaponType {
		SHOTGUN, SNIPER, RIFLE, MELEE
	}

	public Weapon(String name, int dmg, int cost, WeaponType type) {
		super(name, cost);
		this.damage = dmg;
		this.setType(type);
	}

	public Weapon(String name, int dmg, int cost, int range, int clipSize,
			WeaponType type) {
		this(name, dmg, cost, type);
		setMaxRange(range);
		this.setClipSize(clipSize);
	}

	private int clipSize = -1;
	private int maxRange = 1;
	private WeaponType type;

	@Override
	public void use(Actor actor) {
		for (Weapon weapon : actor.getEquippedWeapons()) {
			if (weapon.equals(this)) {
				return;
			}
			else {
				actor.equip(this);
			}
		}
	}

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public int getClipSize() {
		return clipSize;
	}

	public void setClipSize(int clipSize) {
		this.clipSize = clipSize;
	}
}
