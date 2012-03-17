
package game;

import characters.Character;

public class Restorative extends Item {

	private int power = -1;
	private double powerPercent = 0;

	public Restorative(String name, int cost, int power) {
		super(name, cost);
		this.power = power;
	}

	public Restorative(String name, int cost, double powerPercent) {
		super(name, cost);
		this.powerPercent = powerPercent;
	}

	@Override
	public void use(Character actor) {
		if (power != -1) {
			actor.setHP((int) (actor.getHP() + actor.getHP()
					* powerPercent));
		}
		else {
			actor.setHP(actor.getHP() + power);
		}
	}

}
