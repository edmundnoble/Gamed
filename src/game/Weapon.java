

package game;

import characters.Character;


public class Weapon extends Item implements Equippable {

	public static enum WeaponType {
		MELEE, RANGED
	}

	public static final Weapon FISTS = new Weapon("Fists", 1, 0, WeaponType.MELEE);

	private int clipSize = -1;

	private double damage;

	private int maxRange = 1;

	private WeaponType type;

	public Weapon(String name, int dmg, int cost, int range, int clipSize,
			WeaponType type) {
		this(name, dmg, cost, type);
		setMaxRange(range);
		this.setClipSize(clipSize);
	}

	public Weapon(String name, int dmg, int cost, WeaponType type) {
		super(name, cost);
		this.damage = dmg;
		this.setType(type);
	}

	@ Override
	public void equip(Character character) {
		// TODO Auto-generated method stub

	}

	public int getClipSize() {
		return clipSize;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public WeaponType getType() {
		return type;
	}

	public void setClipSize(int clipSize) {
		this.clipSize = clipSize;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}

	@ Override
	public void use(Character actor) {
		for (Weapon weapon : actor.getEquippedWeapons()) {
			if (weapon.equals(this)) {
				return;
			} else {
				equip(actor);
			}
		}
	}
}
