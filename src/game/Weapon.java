
package game;

import java.awt.Image;

import characters.Character;

public class Weapon extends Item implements Usable {

	public static enum WeaponType {
		MELEE, RANGED
	}

	private Image weaponTexture;

	public static final Weapon FISTS = new Weapon("Fists", "FISTS", 1, 0,
			WeaponType.MELEE);

	private int clipSize = -1;

	private double damage;

	private int maxRange = 1;

	private WeaponType type;

	private Image texture;

	public Weapon(String name, String baseName, int dmg, int cost,
			int range, int clipSize, WeaponType type) {
		this(name, baseName, dmg, cost, type);
		this.maxRange = range;
		this.clipSize = clipSize;
		loadTextures(name);
	}

	private void loadTextures(String name) {
		// TODO Auto-generated method stub

	}

	public Weapon(String name, String baseName, int dmg, int cost,
			WeaponType type) {
		super(baseName, cost);
		this.damage = dmg;
		this.setType(type);
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

	@Override
	public void use(Character actor) {
		for (Weapon weapon : actor.getEquippedWeapons()) {
			if (weapon.equals(this)) {
				return;
			}
			else {
				use(actor);
			}
		}
	}

	public void equip(Character actor) {

	}
}
